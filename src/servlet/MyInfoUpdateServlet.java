package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Users;
import service.AccountService;

/**
 * Servlet implementation class UpdateConfirmServlet
 */
@WebServlet("/myInfoUpdate")
public class MyInfoUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 文字化け対策
		request.setCharacterEncoding("UTF-8");



		// 登録（名前、かな、パスワードの取得;
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String kana= request.getParameter("kana");
		String id = request.getParameter("login_id");

		if (!pass.equals("") && !name.equals("") && !kana.equals("") && !id.equals("")) {
		//入力情報を取得
		Users users = new Users(4, name, kana, id);
		//ユーザーを登録
		AccountService accountService = new AccountService();
		accountService.update(users);
        }
		// 次画面指定
		request.getRequestDispatcher("menu.jsp").forward(request, response);
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}