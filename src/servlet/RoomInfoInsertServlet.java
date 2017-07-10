package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import service.RoomsService;

/**
 * Servlet implementation class roomInfoInsert
 */
@WebServlet("/roomInfoInsert")
@MultipartConfig(location="/tmp", maxFileSize=1048576)
public class RoomInfoInsertServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomInfoInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RoomsService roomsService = new RoomsService();
		String room = request.getParameter("room");
		//必須項目の判定
		if(room.isEmpty()){
			request.setAttribute("msg", "必須項目を入力してください");
			response.sendRedirect("roomInfoInsert.jsp");
		}

		//ここから画像アップロード部分
        Part part = request.getPart("file");
        String name = this.getFileName(part);//恐らくここでファイル名の変換を行う必要があると思われる
        part.write(getServletContext().getRealPath("/WEB-INF/uploaded") + "/" + name);
        Integer size = null;
        //規模
        if(request.getParameter("size").isEmpty()){//空文字判定
        }else{
        	size = Integer.parseInt(request.getParameter("size"));
        }

        //設備
        String[] facilities = request.getParameterValues("facility");
        String facility = "";
        for(int i = 0;i < 6;i++){
        	if(10 < facilities[i].length()){
        		facilities[i] = facilities[i].substring(0, 10);//文字数制限対策(65文字)
        	}

        	if(i > 0){
        	facility = facility + "," +facilities[i];
        	}else{
        		facility = facility + facilities[i];
        	}
        }

        //備考
        String remarks = request.getParameter("remarks");
        if(160 < remarks.length()){
        	remarks = remarks.substring(0, 160);//文字数制限対策(160文字)
        }

        //先に画像以外を登録し、そのIDを取得
        int room_id = roomsService.roomInfoInsertWithoutPath(room,size,facility,remarks);
        if(room_id == 0){
        	request.setAttribute("msg", "教室の登録に失敗しました");
			response.sendRedirect("roomInfoInsert.jsp");
        }else{
        	roomsService.updateNewRoomsPath(room_id ,name);
        }

	}


	 private String getFileName(Part part) {
	        String name = null;
	        for (String dispotion : part.getHeader("Content-Disposition").split(";")) {
	            if (dispotion.trim().startsWith("filename")) {
	                name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
	                name = name.substring(name.lastIndexOf("\\") + 1);
	                break;
	            }
	        }
	        return name;
	    }

}
