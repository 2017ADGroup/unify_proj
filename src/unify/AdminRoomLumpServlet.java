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
@WebServlet("/adminRoomLump")
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 文字化け対策
		request.setCharacterEncoding("UTF-8");

		// 更新するID、名前、TEL、PASSの取得
		String[] reserveId = request.getParameterValues("reserveId");
		String[] reservePurpose = request.getParameterValues("reservePurpose");
		String[] reserveAmount = request.getParameterValues("reserveAmount");
		String[] reserveFixtures1 = request.getParameterValues("reserveFixtures1");
		String[] reserveFixtures2 = request.getParameterValues("reserveFixtures2");
		String[] reserveFixtures3 = request.getParameterValues("reserveFixtures3");
		String[] reserveFixtures4 = request.getParameterValues("reserveFixtures4");
		String[] reserveFixtures5 = request.getParameterValues("reserveFixtures5");
		String[] reserveFixtures6 = request.getParameterValues("reserveFixtures6");
		String[] reserveRemarks = request.getParameterValues("reserveRemarks");

		// 削除するIDの取得
		String[] reserveDelete = request.getParameterValues("reserveDelete");

		ReserveService reserveService = new ReserveService();
		Reserve reserve = new Reserve();

		// 一括更新
		for (int i = 0; i < reserveId.length; i++) {

			String join = "";

			if (!reserveFixtures1[i].equals("")) {
				join = join + reserveFixtures1[i] + ",";
			}
			if (!reserveFixtures2[i].equals("")) {
				join = join + reserveFixtures2[i] + ",";
			}
			if (!reserveFixtures3[i].equals("")) {
				join = join + reserveFixtures3[i] + ",";
			}
			if (!reserveFixtures4[i].equals("")) {
				join = join + reserveFixtures4[i] + ",";
			}
			if (!reserveFixtures5[i].equals("")) {
				join = join + reserveFixtures5[i] + ",";
			}
			if (!reserveFixtures6[i].equals("")) {
				join = join + reserveFixtures6[i] + ",";
			}
			join = join.substring(0, join.length() - 1);

			// 入力情報を取得
			reserve = new Reserve(Integer.parseInt(reserveId[i]), Integer.parseInt(reservePurpose[i]),
					Integer.parseInt(reserveAmount[i]), join, reserveRemarks[i]);
			// ユーザーを更新
			reserveService.reserveRenew(reserve);
		}

		// 一括削除
		if (reserveDelete != null) {
			for (String reDel : reserveDelete) {

				// ユーザーを削除
				reserveService.reserveErase(Integer.parseInt(reDel));

			}
		}

		// 全検索
		List<Reserve> list = reserveService.findAll();

		// 検索結果をセッションに保持
		request.setAttribute("reserveList", list);

		// 次画面指定
		request.getRequestDispatcher("adminRoomLump.jsp").forward(request, response);
	}

}
