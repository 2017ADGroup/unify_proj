package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Users;
import service.UsersService;

/**
 * Servlet implementation class MailCreateServlet
 */
@WebServlet("/mailCreate")
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
		/*HttpSession session = request.getSession();*/




			UsersService usersservice = new UsersService();
			List<Users> list = usersservice.findAll();

			request.setAttribute("usersList",list);

		request.getRequestDispatcher("mailCreate.jsp").forward(request, response);
	}
	    	/**
	    	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	    	 */
	    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    		// TODO Auto-generated method stub
	    		doGet(request, response);

	}

}
