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

@WebServlet("/AdminDelete")
public class AdminDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminDelete() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 文字化け対策
		request.setCharacterEncoding("UTF-8");

		UsersService userservice = new UsersService();

		List<Users> list = userservice.findAll();

		request.getRequestDispatcher("adminLump.jsp").forward(request, response);
	}

}
