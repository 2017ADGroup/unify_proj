package unify;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Reserve;
import service.ReserveService;

/**
 * Servlet implementation class roomUpdateServlet
 */
@WebServlet("/roomUpdate")
public class RoomUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RoomUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String reserveId = request.getParameter("reserveId");

		ReserveService reserveService = new ReserveService();

		Reserve reserve = reserveService.findByReserve(Integer.parseInt(reserveId));

		String fixList = reserveService.findFix(reserve.getRoom());

		request.setAttribute("reserve", reserve);
		request.setAttribute("fixList", fixList);

		request.getRequestDispatcher("roomUpdateConfirm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
