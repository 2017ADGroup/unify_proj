
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
import entity.Users;
import service.MailService;
import service.UsersService;

@WebServlet("/mail")
public class MailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 文字化け対策
		request.setCharacterEncoding("UTF-8");
		//session準備
		HttpSession session = request.getSession();
		Users login_user = (Users)session.getAttribute("login_user");
		String login_id = login_user.getLogin_id();

		//ページ読み込み
		int page;
		try {
			page = Integer.parseInt(request.getParameter("page"));
		} catch (Exception e) {
			page = 1;
		}

		//処理
		try {
			MailService mailService = new MailService();
			List<Mail> mailList = mailService.mailFindByLoginId(login_id);//ログインIDをもとにメールを取得
			List<MailView> mailViewList = new ArrayList<MailView>();
			UsersService UsersService = new UsersService();
			for (Mail mail : mailList) {
				String receivername = UsersService.idByName(mail.getReceiver());
				String sendername = UsersService.idByName(mail.getSender());
				MailView mailView = new MailView(receivername, sendername);
				mailViewList.add(mailView);
			}
			//ページとか色々
			request.setAttribute("page", page);
			session.setAttribute("mailViewList", mailViewList);
			session.setAttribute("mailList", mailList);
		} catch (Exception e) {

		}
		//遷移元を記録する
		session.setAttribute("backDoor", "mailBox");
		request.getRequestDispatcher("mail.jsp").forward(request, response);
	}

	//こっから↓いらないかも
	/////////////////////////////////////////////////////////////////////////////////
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login_id = "a002";
		// 文字化け対策
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		try {
			MailService mailService = new MailService();
			List<Mail> mailList = mailService.mailFindByLoginId(login_id);
			List<MailView> mailViewList = new ArrayList<MailView>();
			for (Mail mail : mailList) {
				UsersService UsersService = new UsersService();

				String receivername = UsersService.idByName(mail.getReceiver());
				String sendername = UsersService.idByName(mail.getSender());
				MailView mailView = new MailView(receivername, sendername);
				mailViewList.add(mailView);
			}
			session.setAttribute("mailViewList", mailViewList);
			session.setAttribute("mailList", mailList);
		} catch (Exception e) {

		}
		session.setAttribute("backDoor", "mailBox");
		request.getRequestDispatcher("mail.jsp").forward(request, response);
	}
}
