package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

	}

}
