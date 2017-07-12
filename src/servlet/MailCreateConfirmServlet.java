package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 文字化け対策
		request.setCharacterEncoding("UTF-8");


		String id = request.getParameter("receiver");


			UsersService usersservice = new UsersService();
			 usersservice.idByName(id);

			 request.setAttribute("users.name",id);

		request.getRequestDispatcher("mailCreate.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		/*String repass = request.getParameter("rePass");*/


		String to = (String)session.getAttribute("to");
		String from = (String)session.getAttribute("from");
		String time = (String)session.getAttribute("time");
		String subject = (String)session.getAttribute("subject");
		String message = (String)session.getAttribute("message");
		//値を取得

		/*if (repass == null){
			repass = "";
		}

		// 入力値のチェック
		if (!pass.equals(repass)) {
			// メッセージ設定
			request.setAttribute("msg", "前画面で入力されたパスワードと一致しませんでした");

			// 次画面指定
			request.getRequestDispatcher("insertConfirm.jsp").forward(request, response);
			return;
		}else{*/
			MailService mailservice = new MailService();


			mailservice.mailInsert(to, from, time, subject, message);



			request.getRequestDispatcher("mailCreate.jsp").forward(request, response);
	}


}
