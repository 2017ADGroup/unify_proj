package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Users;
import service.UsersService;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
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
		String login_id = request.getParameter("id");
		String pass = request.getParameter("pass");

		if (login_id == null || ("".equals(login_id)) || pass == null || ("".equals(pass))) {
			request.setAttribute("errmsg", "IDまたはPASSが入力されていません");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}

		Users users = UsersService.authentication(login_id, pass);
		boolean isSuccess = users != null;


		if (isSuccess) {
			request.getRequestDispatcher("menu.jsp").forward(request, response);
		} else {
			request.setAttribute("errmsg", "IDまたはPASSが間違っています");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
