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

@WebServlet("/allMailDisplay")
public class AllMailDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 文字化け対策
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		// ページ読み込み
/*		int page;
		//初回の場合は1が入る
		try {
			page = Integer.parseInt(request.getParameter("page"));
		} catch (Exception e) {
			page = 1;
		}*/
		try {
			MailService mailService = new MailService();
			List<Mail> mailList = mailService.mailFindAll();
			List<MailView> mailViewList = new ArrayList<MailView>();
			UsersService UsersService = new UsersService();
			for (Mail mail : mailList) {
				String receivername = UsersService.idByName(mail.getReceiver());
				String sendername = UsersService.idByName(mail.getSender());
				MailView mailView = new MailView(receivername, sendername);
				mailViewList.add(mailView);
			}
			// ページとか色々
			//request.setAttribute("page", page);
			session.setAttribute("mailViewList", mailViewList);
			session.setAttribute("mailList", mailList);
		} catch (Exception e) {

		}
		request.getRequestDispatcher("allMailDisplay.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 文字化け対策
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		try {
			// 情報取得
			String name = request.getParameter("name");
			String id = request.getParameter("id");
			String keyword = request.getParameter("keyword");
			String time = request.getParameter("time");//ここで恐らく面倒な処理が必要になる
			String[] checkbox = request.getParameterValues("checkbox");
/*			int page;
			try {
				page = Integer.parseInt(request.getParameter("page"));
			} catch (Exception e) {
				page = 1;
			}*/

			MailService mailService = new MailService();
			List<Mail> mailList = new ArrayList<Mail>();
			//チェックの有無、idの入力、非入力で5つに分岐する
			if(checkbox.length == 0){//チェック無し
					mailList = mailService.mailFindByNameTo("",keyword,time);//名前検索
			}else if(checkbox.length == 1){//片方チェックアリ
				if(checkbox[0].equals("to")){
					if(id.isEmpty()){//名前検索
						mailList = mailService.mailFindByNameTo(name,keyword,time);//名前検索
					}else{//IDでの検索
						mailList = mailService.mailFindByIdTo(id,keyword,time);//id検索
					}
				}else{
					if(id.isEmpty()){//名前検索
						mailList = mailService.mailFindByNameFrom(name,keyword,time);//名前検索
					}else{//IDでの検索
						mailList = mailService.mailFindByIdFrom(id,keyword,time);//id検索
					}
				}
			}else{//双方ともチェックアリ
				if(id.isEmpty()){//名前検索
					mailList = mailService.mailFindByName(name,keyword,time);//名前検索
				}else{//IDでの検索
					mailList = mailService.mailFindById(id,keyword,time);//id検索
				}
			}

			List<MailView> mailViewList = new ArrayList<MailView>();
			for (Mail mail : mailList) {
				UsersService UsersService = new UsersService();
				String receivername = UsersService.idByName(mail.getReceiver());
				String sendername = UsersService.idByName(mail.getSender());
				MailView mailView = new MailView(receivername, sendername);
				mailViewList.add(mailView);
			}
			//request.setAttribute("page", page);
			session.setAttribute("mailViewList", mailViewList);
			session.setAttribute("mailList", mailList);
		} catch (Exception e) {

		}
		request.getRequestDispatcher("allMailDisplay.jsp").forward(request, response);
	}

}
