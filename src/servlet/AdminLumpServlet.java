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


@WebServlet("/adminLump")
public class AdminLumpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public AdminLumpServlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		// 削除するIDの取得
				String[] lumpDel = request.getParameterValues("checkbox");
				UsersService usersservice = new UsersService();

				// 一括削除

				if (lumpDel != null) {
					for (String login_id : lumpDel) {

						// ユーザーを削除

						usersservice.delete(Integer.parseInt(login_id));
					}

				}
				List<Users> list = usersservice.findAll();

				request.setAttribute("usersList",list);
				request.getRequestDispatcher("adminLump.jsp").forward(request, response);

	}

}
