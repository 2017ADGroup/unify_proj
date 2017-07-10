package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/mailDetail")
public class MailDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MailDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	HttpSession session = request.getSession();
		// 文字化け対策
		request.setCharacterEncoding("UTF-8");

		String mail_id = (String)request.getAttribute("mail_id");

		//idをもとにデータで取得
		String to = request.getParameter("to");
		String from = request.getParameter("from");
		String time = request.getParameter("time");
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");


		//値を保存
		request.setAttribute("mail_id", mail_id);
	/*	request.setAttribute("to", to);
		request.setAttribute("from", from);
		request.setAttribute("time", time);
		request.setAttribute("subject", subject);
		request.setAttribute("message", message);
*/



		request.getRequestDispatcher("mailDetail.jsp").forward(request, response);
	}

}
