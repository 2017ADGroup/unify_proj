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
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("UTF-8");
		String login_id = request.getParameter("id");
		String pass = request.getParameter("pass");

		// 入力値がnullか空文字であるか
		if (login_id == null || ("".equals(login_id)) || pass == null || ("".equals(pass))) {
			//request.setAttribute("errmsg", "IDまたはPASSが入力されていません");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}

		// Usersテーブルからユーザー情報を取得し照合
		UsersService usersService = new UsersService();
		Users users = usersService.authentication(login_id, pass);
		boolean isSuccess = users != null;

		HttpSession session = request.getSession(true);

		// login_idとpassが照合した場合
		if (isSuccess) {
			session.setAttribute("login_user", users);

			// スーパーユーザー遷移
			if (users.getProperty() == 1) {
				request.getRequestDispatcher("adminMenu.jsp").forward(request, response);

				// その他のユーザー遷移
			} else {
				request.getRequestDispatcher("menu.jsp").forward(request, response);
			}

			// IDまたはPASSが間違っている場合、ログインへ戻る
		} else {
			//request.setAttribute("errmsg", "IDまたはPASSが間違っています");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
