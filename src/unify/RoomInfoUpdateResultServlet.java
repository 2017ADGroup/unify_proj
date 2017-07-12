package unify;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Rooms;
import service.RoomsService;

/**
 * Servlet implementation class RoomInfoUpdateResultServlet
 */
@WebServlet("/roomInfoUpdateResult")
public class RoomInfoUpdateResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RoomInfoUpdateResultServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// 文字化け対策
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		String roomsId = (String) session.getAttribute("roomsId");
		String newFixs = (String) session.getAttribute("newFixs");

		Rooms rooms = new Rooms(Integer.parseInt(roomsId), "imagePath", request.getParameter("newName"), Integer.parseInt(request.getParameter("newSize")), newFixs, request.getParameter("newRemarks"));

		RoomsService roomService = new RoomsService();
		roomService.renew(rooms);

		request.getRequestDispatcher("menu.jsp").forward(request, response);

	}

}
