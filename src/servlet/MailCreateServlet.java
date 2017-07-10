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

/**
 * Servlet implementation class MailCreateServlet
 */
@WebServlet("/MailCreateServlet")
public class MailCreateServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public MailCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
	    	/**
	    	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	    	 */
	    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    		// TODO Auto-generated method stub
	    		doGet(request, response);

	}

}
