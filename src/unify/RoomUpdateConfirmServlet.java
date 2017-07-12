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

/**
 * Servlet implementation class RoomUpdateConfirmServlet
 */
@WebServlet("/roomUpdateConfirm")
public class RoomUpdateConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RoomUpdateConfirmServlet() {
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

		String[] afFix = request.getParameterValues("afFix");

		String fix = "";
		for (String str : afFix) {
			if (!str.equals("")) {
				fix = fix + str + ",";
			}
		}
		fix = fix.substring(0, fix.length() - 1);

		Reserve reserve = new Reserve(Integer.parseInt(request.getParameter("reId")),
				Integer.parseInt(request.getParameter("afPurpose")), Integer.parseInt(request.getParameter("afAmount")),
				fix, request.getParameter("afRemarks"));

		ReserveService reserveService = new ReserveService();

		reserveService.reserveRenew(reserve);

		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("login_user");

		List<Reserve> list = reserveService.findById(user.getLogin_id());

		// テスト用
		// List<Reserve> list = reserveService.findById("99a3445");

		request.setAttribute("reserveList", list);

		request.getRequestDispatcher("roomLump.jsp").forward(request, response);
	}

}
