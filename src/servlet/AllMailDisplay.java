package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Mail;
import service.MailService;

@WebServlet("/AllMailDisplay")
public class AllMailDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 文字化け対策
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		try {
			MailService mailService = new MailService();
			List<Mail> mailList = mailService.mailFindAll();
			session.setAttribute("mailList", mailList);
		}
		catch (Exception e) {

		}
		request.getRequestDispatcher("allMailDisplay.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 文字化け対策
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		try {
		//情報取得
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String keyword = request.getParameter("keyword");
		String time = request.getParameter("time");
		String checkbox = request.getParameter("checkbox");
		int page = Integer.parseInt(request.getParameter("page"));

		MailService mailService = new MailService();
		List<Mail> mailList = mailService.mailFind();

		session.setAttribute("mailList", mailList);
		request.setAttribute("min",1);
		} catch (Exception e) {

		}
		request.getRequestDispatcher("allMailDisplay.jsp").forward(request, response);
	}

}
