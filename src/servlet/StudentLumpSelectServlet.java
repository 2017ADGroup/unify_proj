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
 * Servlet implementation class StudentLumpSelectServlet
 */
@WebServlet("/StudentLumpSelect")
public class StudentLumpSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		UsersService usersService = new UsersService();
		List<Users> studentList = usersService.findByProperty(5);
		request.setAttribute("studentList", studentList);
		System.out.println("エラーなし");
		request.getRequestDispatcher("studentLumpSelect.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		UsersService usersService = new UsersService();
		List<Users> studentList = usersService.findByProperty(5);
		request.setAttribute("studentList", studentList);
		request.getRequestDispatcher("studentLumpSelect.jsp").forward(request, response);
	}

}
