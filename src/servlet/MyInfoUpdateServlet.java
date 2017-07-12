package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Users;
import service.UsersService;

/**
 * Servlet implementation class UpdateConfirmServlet
 */
@WebServlet("/MyInfoUpdateServlet")
public class MyInfoUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 文字化け対策
		request.setCharacterEncoding("UTF-8");

		// 新規PASSを取得
		HttpSession session = request.getSession();
		String pass = (String) session.getAttribute("pass");

		// 更新後の値を取得
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String kana = request.getParameter("kana");
		String rePass = request.getParameter("pass");

		// PASS(再入力)をセッションスコープに保持
		session.setAttribute("rePass", rePass);

		if (!pass.equals(rePass)) {
			// メッセージを設定
			request.setAttribute("msg", "前画面で入力したパスワードと一致しません");
			// 次画面指定
			request.getRequestDispatcher("myInfoUpdate.jsp").forward(request, response);
			return;
		}

		// 入力情報を取得
		Users users = new Users(Integer.parseInt(id), name, kana, pass);

		// ユーザーを登録
		UsersService usersService = new UsersService();
		usersService.update(users);

		// IDをセッションに保持
		session.setAttribute("selectId", id);

		// 次画面指定
		request.getRequestDispatcher("myInfoUpdate.jsp").forward(request, response);
	}
}