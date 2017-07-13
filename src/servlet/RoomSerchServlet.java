package servlet;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Reserve;
import entity.Rooms;
import service.ReserveService;
import service.RoomsService;

/**
 * Servlet implementation class RoomSerchServlet
 */
@WebServlet("/roomSerch")
public class RoomSerchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomSerchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		int min = -1;
		int max = -1;
		//最大値最小値空文字チェック
		if(!request.getParameter("sizeMin").isEmpty()){
			min = Integer.parseInt(request.getParameter("sizeMin"));
		}

		if(!request.getParameter("sizeMax").isEmpty()){
			max = Integer.parseInt(request.getParameter("sizeMax"));
		}

		//複数検索
		RoomsService roomsService = new RoomsService();
		List<Rooms> roomList = roomsService.serchRooms(
				request.getParameter("room"),min,max,request.getParameter("fixtures"));
		session.setAttribute("roomList", roomList);

		Calendar thisDate = Calendar.getInstance();
		Integer month = Integer.valueOf(thisDate.get(Calendar.MONTH)) + 1;
		session.setAttribute("thisMonth",month);
		request.getRequestDispatcher("roomInsert.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		request.getParameter("roomSelect");
		HttpSession session = request.getSession();
		String room = request.getParameter("roomSelect");
		String month = request.getParameter("reserve_month");
		String date = request.getParameter("reserve_date");
		Calendar thisDate = Calendar.getInstance();
		String year = String.valueOf(thisDate.get(Calendar.YEAR));
		String reserve_date = year + "-" + month + "-" + date;
		ReserveService reserveService = new ReserveService();
		String schedule = "<td></td>";
		Reserve reserve = null;
		String purpose = null;
		//時間割生成。一段目
		for(int i = 1;i < 8 ;i++){
			reserve = reserveService.findByDateRoomTerm(reserve_date, room, i);
			if(reserve == null){
				schedule = schedule + "<td>" + "</td>";
			}else{
				switch(reserve.getPurpose()){
					case 1:
						purpose = "講義";
						break;
					case 2:
						purpose = "課外活動";
						break;
					case 3:
						purpose = "備品整備";
						break;
					default:
						purpose = "その他";
						break;
				}
				schedule = schedule + "<td>" + reserve.getReserve_host() + "<br>" + purpose + "</td>";
			}
			reserve = null;
		}
		schedule = schedule + "<tr></tr><td></td>";
		//二段目、チェックボックス部分修正
		for(int i = 1;i < 8 ;i++){
			reserve = reserveService.findByDateRoomTerm(reserve_date, room, i);
			if(reserve == null){
				schedule = schedule + "<td><input type='checkbox' name='reserve_term' value='" + i + "'></td>";
			}else{
				schedule = schedule + "<td>" + "</td>";
			}
		}

		RoomsService roomsService = new RoomsService();
		Rooms reserve_room = roomsService.serchRooms(room, -1, -1,"").get(0);
		String[] facility = reserve_room.getFacility().split(",");
		request.setAttribute("facility", facility);
		session.setAttribute("room", room);//選択した教室名を保存
		session.setAttribute("reserve_date", reserve_date);//選択されている日付を保存
		request.setAttribute("schedule", schedule);
		request.getRequestDispatcher("roomInsert.jsp").forward(request, response);
	}

}
