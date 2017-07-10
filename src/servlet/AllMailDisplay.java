package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Mail;
import entity.MailView;
import service.MailService;
import service.UsersService;

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
			List<MailView> mailViewList = new ArrayList<MailView>();
			for(Mail mail: mailList){
				UsersService UsersService = new UsersService();

				String receivername  = UsersService.idByName(mail.getReceiver());
				String sendername  = UsersService.idByName(mail.getSender());
				MailView mailView = new MailView(receivername,sendername);
				mailViewList.add(mailView);
			}
			session.setAttribute("mailViewList", mailViewList);

			System.out.println(mailViewList.get(0).getSendername()+"通ってる");
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
		String[] checkbox = request.getParameterValues("checkbox");
		int page = Integer.parseInt(request.getParameter("page"));

		MailService mailService = new MailService();
		List<Mail> mailList = mailService.mailFindAll();
		List<MailView> mailViewList = new ArrayList<MailView>();
		for(Mail mail: mailList){
			UsersService UsersService = new UsersService();

			String receivername  = UsersService.idByName(mail.getReceiver());
			String sendername  = UsersService.idByName(mail.getSender());
			MailView mailView = new MailView(receivername,sendername);
			mailViewList.add(mailView);
		}
		session.setAttribute("mailViewList", mailViewList);

		System.out.println(mailViewList.get(0).getSendername()+"通ってる");
		session.setAttribute("mailList", mailList);
		} catch (Exception e) {

		}
		request.getRequestDispatcher("allMailDisplay.jsp").forward(request, response);
	}

}
