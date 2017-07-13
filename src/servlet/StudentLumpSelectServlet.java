package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Users;
import service.UsersService;

/**
 * Servlet implementation class StudentLumpSelectServlet
 */
@WebServlet("/studentLumpSelect")
public class StudentLumpSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("login_user");

		System.out.println(users.getName());

		UsersService usersService = new UsersService();
		List<Users> studentList = usersService.findByProperty(5, users.getName());
		request.setAttribute("studentList", studentList);

		request.getRequestDispatcher("studentLumpSelect.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("login_user");

		// 削除するIDの取得
		String[] studentDelete = request.getParameterValues("studentDelete");
		UsersService usersService = new UsersService();

		// 一括削除

		if (studentDelete != null) {
			for (String studentDel : studentDelete) {

				// ユーザーを削除
				usersService.delete(Integer.parseInt(studentDel));
			}
		}

		List<Users> studentList = usersService.findByProperty(5, users.getName());
		request.setAttribute("studentList", studentList);

		request.getRequestDispatcher("studentLumpSelect.jsp").forward(request, response);
	}

}
