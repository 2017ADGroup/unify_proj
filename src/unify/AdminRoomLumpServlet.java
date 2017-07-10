package unify;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Reserve;
import service.ReserveService;

/**
 * Servlet implementation class AdminRoomLumpServlet
 */
@WebServlet("/AdminRoomLump")
public class AdminRoomLumpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminRoomLumpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 文字化け対策
		request.setCharacterEncoding("UTF-8");

		// 更新するID、名前、TEL、PASSの取得
		String[] reserveId = request.getParameterValues("reserveId");
		String[] reservePurpose = request.getParameterValues("reservePurpose");
		String[] reserveAmount = request.getParameterValues("reserveAmount");
		String[] reserveFixtures = request.getParameterValues("reserveFixtures");
		String[] reserveRemarks = request.getParameterValues("reserveRemarks");

		// 削除するIDの取得
		String[] reserveDelete = request.getParameterValues("reserveDelete");

		ReserveService reserveService = new ReserveService();
		Reserve reserve = new Reserve();

		// 一括更新
		for (int i = 0; i < reserveId.length; i++) {

				reserve = reserveService.find(reserveId[i]);

					// 入力情報を取得
					reserve = new Reserve(Integer.parseInt(lumpId[i]), lumpName[i], lumpTel[i], lumpPass[i]);
					// ユーザーを更新
					reserveService.renew(reserve);
			}

		// 一括削除
		if (reserveDelete != null) {
			for (String reDel: reserveDelete) {

				// ユーザーを削除
				reserveService.erase(reDel);

			}
		}

		// 全検索
		List<Reserve> list = reserveService.findAll();

		// 検索結果をセッションに保持
		request.setAttribute("adminRoomList", list);

		// 次画面指定
		request.getRequestDispatcher("adminRoomLump.jsp").forward(request, response);
	}

}
