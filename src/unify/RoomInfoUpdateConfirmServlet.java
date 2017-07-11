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
 * Servlet implementation class RoomInfoUpdateConfirmServlet
 */
@WebServlet("/roomInfoUpdateConfirm")
public class RoomInfoUpdateConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RoomInfoUpdateConfirmServlet() {
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

		String[] fixtures = request.getParameterValues("fixtures");

		String fix = "";
		for (String str : fixtures) {
			if (!str.equals("")) {
				fix = fix + str + ",";
			}
		}
		fix = fix.substring(0, fix.length() - 1);

		request.setAttribute("name", request.getParameter("name"));
		request.setAttribute("scale", request.getParameter("scale"));
		request.setAttribute("fix", fix);
		request.setAttribute("remarks", request.getParameter("remarks"));

		HttpSession session = request.getSession();
		String roomsId = (String) session.getAttribute("roomsId");

		RoomsService roomsService = new RoomsService();
		Rooms rooms = roomsService.find(Integer.parseInt(roomsId));

		request.setAttribute("room", rooms);

		request.getRequestDispatcher("roomInfoUpdateConfirm.jsp").forward(request, response);
	}

}
