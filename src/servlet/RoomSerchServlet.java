package servlet;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		response.setCharacterEncoding("UTF-8");
		int min = -1;
		int max = -1;
		//最大値最小値空文字チェック
		if(!request.getParameter("sizeMin").isEmpty()){
			min = Integer.parseInt(request.getParameter("sizeMin"));
		}

		if(!request.getParameter("sizeMax").isEmpty()){
			min = Integer.parseInt(request.getParameter("sizeMax"));
		}

		//複数検索
		RoomsService roomsService = new RoomsService();
		List<Rooms> roomList = roomsService.serchRooms(
				request.getParameter("room"),min,max,request.getParameter("facility"));
		request.setAttribute("roomList", roomList);
		request.getRequestDispatcher("roomInsert.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		request.getParameter("roomSelect");
		String room = request.getParameter("roomSelect");
		String month = request.getParameter("reserve_month");
		String date = request.getParameter("reserve_date");
		Calendar thisDate = Calendar.getInstance();
		String year = String.valueOf(thisDate.get(thisDate.YEAR));
		String reserve_date = year + "-" + month + "-" + "date";
		ReserveService reserveService = new ReserveService();
		String schedule = "";
		Reserve reserve = null;
		String purpose = null;
		for(int i = 0;i < 7 ;i++){
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
					case 4:
						purpose = "";
						break;
				}

				schedule = schedule + "<td>" + reserve.getReserve_host() + "<br>" + reserve.getPurpose() + "</td>";
			}
		}


	}

}
