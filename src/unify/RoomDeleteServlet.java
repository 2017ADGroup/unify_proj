package unify;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Reserve;
import entity.Users;
import service.ReserveService;
import service.RoomsService;

/**
 * Servlet implementation class RoomDeleteServlet
 */
@WebServlet("/roomDelete")
public class RoomDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RoomDeleteServlet() {
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
		// 削除するIDの取得
		String[] reserveDelete = request.getParameterValues("reserveDelete");

		RoomsService roomsService = new RoomsService();

		// 一括削除
		if (reserveDelete != null) {
			for (String reserveDel : reserveDelete) {

				// roomを削除
				roomsService.erase(Integer.parseInt(reserveDel));

			}
		}

		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("login_user");

		ReserveService reserveService = new ReserveService();
		List<Reserve> list = reserveService.findById(user.getLogin_id());

		// テスト用
//		List<Reserve> list = reserveService.findById("99a3445");

		request.setAttribute("reserveList", list);

		request.getRequestDispatcher("roomLump.jsp").forward(request, response);
	}

}
