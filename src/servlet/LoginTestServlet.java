package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Users;

/**
 * Servlet implementation class LoginTestServlet
 */
@WebServlet("/LoginTest")
public class LoginTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Users login_user = new Users();
				login_user.setUser_id(1001);
				login_user.setLogin_id("13e2034");
				login_user.setPassword("2034");

				2,"市川公輔","いちかわこうすけ",1,"管理課");
		HttpSession session = request.getSession();
		session.setAttribute("login_user", login_user);
		RequestDispatcher dispatcher = request.getRequestDispatcher("menu.jsp");
        //  フォワードによるページ遷移
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
