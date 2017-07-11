package servlet;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String month = request.getParameter("reserve_month");
		String date = request.getParameter("reserve_date");
		Calendar thisDate = Calendar.getInstance();
		String year = String.valueOf(thisDate.get(thisDate.YEAR));
		String reserve_date = year + "-" + month + "-" + "date";
		ReserveService reserveService = new ReserveService();


	}

}
