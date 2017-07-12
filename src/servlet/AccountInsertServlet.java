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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			request.getRequestDispatcher("accountInsert.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 文字化け対策
		request.setCharacterEncoding("UTF-8");

		// 登録（ID、名前、かなの取得
		String[] id = request.getParameterValues("login_id");
		String[] name = request.getParameterValues("name");
		String[] kana = request.getParameterValues("kana");
		String[] property = request.getParameterValues("property");

		AccountService accountService = new AccountService();
		Users users = new Users();

		System.out.println("ここまで");

		// 一括登録
				int inNum = 0;
				for (int i = 0; i < id.length; i++) {

					if (!name[i].equals("")) {
						users = accountService.find(id[i]);

						if (!(name[i].equals(users.getName()) && kana[i].equals(users.getKana()) && property[i].equals(users.getProperty()))) {

							// 入力情報を取得
							users = new Users(Integer.parseInt(id[i]), name[i], kana[i], property[i], null, null, i, null);
							// ユーザーを更新
							accountService.account(users);
							inNum++;

						}
					}
				}
				request.setAttribute("upNum", inNum);

		// 入力値がない場合
		if ("".equals(id) || "".equals(name) || "".equals(kana) || "".equals(property)) {
			// 次画面指定
			request.getRequestDispatcher("accountInsert.jsp").forward(request, response);
			return;
		}

		doGet(request, response);
	}

}
