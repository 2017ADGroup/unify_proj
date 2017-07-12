package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String room = request.getParameter("room");
		//ここから画像アップロード部分
/*        Part part = request.getPart("file");
        String name = this.getFileName(part);//恐らくここでファイル名の変換を行う必要があると思われる
        part.write(getServletContext().getRealPath("/WEB-INF/uploaded") + "/" + name);*/

        //規模
        int size = Integer.parseInt(request.getParameter("size"));

        //設備
        String[] facilities = request.getParameterValues("facility");

        //備考
        String remarks = request.getParameter("remarks");
        if(160 < remarks.length()){
        	remarks = remarks.substring(0, 160);//文字数制限対策(160文字)
        }

        //確認画面に受け渡し
        request.setAttribute("room",room);
        //request.setAttribute("path", name);
        request.setAttribute("size",size);
        request.setAttribute("facilities",facilities);
        request.setAttribute("remarks",remarks);

        request.getRequestDispatcher("roomInfoInsertConfirm.jsp").forward(request, response);
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
