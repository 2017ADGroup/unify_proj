package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Mail;
import service.MailService;

@WebServlet("/MailDetail")
public class MailDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MailDetailServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("mailDetail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/* HttpSession session = request.getSession(); */
		// 文字化け対策
		request.setCharacterEncoding("UTF-8");

		// idをもとにデータで取得
		String mail_id = (String) request.getAttribute("mail_id");

		MailService mailservice = new MailService();
		Mail mail = mailservice.mailFindById(Integer.parseInt(mail_id));

		request.setAttribute("mail", mail);

		request.getRequestDispatcher("mailDetail.jsp").forward(request, response);
	}

}
