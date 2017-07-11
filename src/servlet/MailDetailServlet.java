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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String mail_id = (String) request.getParameter("mail_id");
		System.out.println(mail_id);
		MailService mailservice = new MailService();
		Mail mail = mailservice.mailFindByMailId(Integer.parseInt(mail_id));

		request.setAttribute("mail", mail);

		request.getRequestDispatcher("mailDetail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String mail_id = (String) request.getParameter("mail_id");
		System.out.println(mail_id);
		MailService mailservice = new MailService();
		Mail mail = mailservice.mailFindByMailId(Integer.parseInt(mail_id));

		request.setAttribute("mail", mail);

		request.getRequestDispatcher("mailDetail.jsp").forward(request, response);
	}

}
