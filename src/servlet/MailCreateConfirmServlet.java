package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Users;
import service.MailService;
import service.UsersService;

/**
 * Servlet implementation class MailCreateConfirmServlet
 */
@WebServlet("/mailCreateConfirm")
public class MailCreateConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MailCreateConfirmServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 文字化け対策
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("receiver");

		UsersService usersservice = new UsersService();
		usersservice.idByName(id);

		request.setAttribute("users.name", id);

		request.getRequestDispatcher("mailCreate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 文字化け対策
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		/* String repass = request.getParameter("rePass"); */

		String to = (String) request.getParameter("receiver");
		Users login_user = (Users)session.getAttribute("login_user");
		String subject = (String) request.getParameter("subject");
		String message = (String) request.getParameter("message");
		System.out.println(to);
		System.out.println(subject);
		System.out.println(message);
		// 値を取得

		Date d = new Date();
		SimpleDateFormat d1 = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		String q1 = d1.format(d);


		MailService mailservice = new MailService();

		mailservice.mailInsert(to, login_user.getLogin_id(), q1, subject, message);

		session.setAttribute("receiver", to);
		session.setAttribute("sender", login_user.getLogin_id());
		session.setAttribute("time", q1);
		session.setAttribute("subject", subject);
		session.setAttribute("message", message);
		System.out.println("subject");
		System.out.println("message");

		request.getRequestDispatcher("mailCreate.jsp").forward(request, response);
	}

}
