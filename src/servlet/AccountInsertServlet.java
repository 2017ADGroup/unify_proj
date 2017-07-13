package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Users;
import service.AccountService;

/**
 * Servlet implementation class AccountInsertServlet
 */
@WebServlet("/accountInsert")
public class AccountInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccountInsertServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("accountInsert.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 文字化け対策
		request.setCharacterEncoding("UTF-8");

		// 登録（ID、名前、かなの取得
		String[] id = request.getParameterValues("id");
		String[] name = request.getParameterValues("name");
		String[] kana = request.getParameterValues("kana");
		String[] property = request.getParameterValues("property");

		AccountService accountService = new AccountService();

		// 一括登録

		for (int i = 0; i < id.length; i++) {

			if (!id[i].equals("") && !name[i].equals("") && !kana[i].equals("") && !property[i].equals("")) {

				// 入力情報を取得
				Users users = new Users(0, id[i], id[i], Integer.parseInt(property[i]), name[i], kana[i], 1, "");
				// ユーザーを登録
				accountService.insert(users);
			}

		}
		request.getRequestDispatcher("accountInsert.jsp").forward(request, response);
	}

}
