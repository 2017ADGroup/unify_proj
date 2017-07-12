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
 * Servlet implementation class StudentInsertServlet
 */
@WebServlet("/studentInsert")
public class StudentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("studentInsert.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// 文字化け対策
				request.setCharacterEncoding("UTF-8");

				// 登録（ID、名前、かなの取得
				String[] id = request.getParameterValues("id");
				String[] name = request.getParameterValues("name");
				String[] kana = request.getParameterValues("kana");

				AccountService accountService = new AccountService();

				// 一括登録

				for (int i = 0; i < id.length; i++) {

					if (!id[i].equals("") && !name[i].equals("") && !kana[i].equals("")) {

						// 入力情報を取得
						Users users = new Users(0, id[i], id[i], 4, name[i], kana[i], 0, "");
						// ユーザーを更新
						accountService.insert(users);
					}

				}
				request.getRequestDispatcher("studentInsert.jsp").forward(request, response);
			}

}
