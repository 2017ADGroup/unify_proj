package unify;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminRoomInsertServlet
 */
@WebServlet("/AdminRoomInsert")
public class AdminRoomInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminRoomInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 文字化け対策
		request.setCharacterEncoding("UTF-8");

		// 予約情報の取得
		String date1 = request.getParameter("date1");
		String loginId1 = request.getParameter("loginId1");
		String room1 = request.getParameter("room1");
		String period1 = request.getParameter("period1");
		String purpose1 = request.getParameter("purpose1");
		String number1 = request.getParameter("number1");
		String remarks1 = request.getParameter("remarks1");


		// NULLチェック
		if (date1 == null) {
			date1 = "";
		}
		if (loginId1 == null) {
			loginId1 = "";
		}
		if (room1 == null) {
			room1 = "";
		}
		if (period1 == null) {
			period1 = "";
		}
		if (purpose1 == null) {
			purpose1 = "";
		}
		if (number1 == null) {
			number1 = "";
		}
		if (remarks1 == null) {
			remarks1 = "";
		}

		// 入力値がない場合
		if ("".equals(name) || "".equals(tel) || "".equals(pass)) {
			// 次画面指定
			request.getRequestDispatcher("insert.jsp").forward(request, response);
			return;
		}

		// 名前、TEL、パスワードをセッションスコープに保持
		HttpSession session = request.getSession();
		session.setAttribute("insName", name);
		session.setAttribute("insTel", tel);
		session.setAttribute("insPass", pass);

		// 次画面指定
		request.getRequestDispatcher("insertConfirm.jsp").forward(request, response);
	}

}
