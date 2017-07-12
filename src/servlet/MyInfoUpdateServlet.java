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

		// 登録（ID、名前、パスワードの取得
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");

		if (!id.equals("") && !pass.equals("") && !name.equals("")) {
		//入力情報を取得
		Users users = new Users(0, id, pass, 4, name,"", 0, "");
		//ユーザーを登録
		AccountService accountService = new AccountService();
		accountService.update(users);

		}
		request.getRequestDispatcher("myInfoUpdate.jsp").forward(request, response);
	}

}