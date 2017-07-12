package unify;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Reserve;
import service.ReserveService;

/**
 * Servlet implementation class AdminRoomInsertServlet
 */
@WebServlet("/adminRoomInsert")
public class AdminRoomInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminRoomInsertServlet() {
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

		// 文字化け対策
		request.setCharacterEncoding("UTF-8");

		// 予約情報の取得1
		String date1 = request.getParameter("date1");
		String loginId1 = request.getParameter("loginId1");
		String room1 = request.getParameter("room1");
		String period1 = request.getParameter("period1");
		String purpose1 = request.getParameter("purpose1");
		String number1 = request.getParameter("number1");

		String join1 = "";
		for (String str : request.getParameterValues("fixtures1")) {
			if (!str.equals("")) {
				join1 = join1 + str + ",";
			}
		}
		if (!join1.equals("")) {
			join1 = join1.substring(0, join1.length() - 1);
		}

		String remarks1 = request.getParameter("remarks1");

		// NULLチェック
		if (date1 == null) {
			date1 = "";
		}
		if (loginId1 == null) {
			loginId1 = "";
		}
		if (room1 == null) {
			room1 = "";
		}
		if (period1 == null) {
			period1 = "";
		}
		if (purpose1 == null) {
			purpose1 = "";
		}
		if (number1 == null) {
			number1 = "";
		}
		if (remarks1 == null) {
			remarks1 = "";
		}

		// 予約情報の取得2
		String date2 = request.getParameter("date2");
		String loginId2 = request.getParameter("loginId2");
		String room2 = request.getParameter("room2");
		String period2 = request.getParameter("period2");
		String purpose2 = request.getParameter("purpose2");
		String number2 = request.getParameter("number2");

		String join2 = "";
		for (String str : request.getParameterValues("fixtures2")) {
			if (!str.equals("")) {
				join2 = join2 + str + ",";
			}
		}
		if (!join2.equals("")) {
			join2 = join2.substring(0, join2.length() - 1);
		}

		String remarks2 = request.getParameter("remarks2");

		// NULLチェック
		if (date2 == null) {
			date2 = "";
		}
		if (loginId2 == null) {
			loginId2 = "";
		}
		if (room2 == null) {
			room2 = "";
		}
		if (period2 == null) {
			period2 = "";
		}
		if (purpose2 == null) {
			purpose2 = "";
		}
		if (number2 == null) {
			number2 = "";
		}
		if (remarks2 == null) {
			remarks2 = "";
		}

		// 予約情報の取得3
		String date3 = request.getParameter("date3");
		String loginId3 = request.getParameter("loginId3");
		String room3 = request.getParameter("room3");
		String period3 = request.getParameter("period3");
		String purpose3 = request.getParameter("purpose3");
		String number3 = request.getParameter("number3");

		String join3 = "";
		for (String str : request.getParameterValues("fixtures3")) {
			if (!str.equals("")) {
				join3 = join3 + str + ",";
			}
		}
		if (!join3.equals("")) {
			join3 = join3.substring(0, join3.length() - 1);
		}

		String remarks3 = request.getParameter("remarks3");

		// NULLチェック
		if (date3 == null) {
			date3 = "";
		}
		if (loginId3 == null) {
			loginId3 = "";
		}
		if (room3 == null) {
			room3 = "";
		}
		if (period3 == null) {
			period3 = "";
		}
		if (purpose3 == null) {
			purpose3 = "";
		}
		if (number3 == null) {
			number3 = "";
		}
		if (remarks3 == null) {
			remarks3 = "";
		}

		// 予約情報の取得4
		String date4 = request.getParameter("date4");
		String loginId4 = request.getParameter("loginId4");
		String room4 = request.getParameter("room4");
		String period4 = request.getParameter("period4");
		String purpose4 = request.getParameter("purpose4");
		String number4 = request.getParameter("number4");

		String join4 = "";
		for (String str : request.getParameterValues("fixtures4")) {
			if (!str.equals("")) {
				join4 = join4 + str + ",";
			}
		}
		if (!join4.equals("")) {
			join4 = join4.substring(0, join4.length() - 1);
		}

		String remarks4 = request.getParameter("remarks4");

		// NULLチェック
		if (date4 == null) {
			date4 = "";
		}
		if (loginId4 == null) {
			loginId4 = "";
		}
		if (room4 == null) {
			room4 = "";
		}
		if (period4 == null) {
			period4 = "";
		}
		if (purpose4 == null) {
			purpose4 = "";
		}
		if (number4 == null) {
			number4 = "";
		}
		if (remarks4 == null) {
			remarks4 = "";
		}

		// 予約情報の取得5
		String date5 = request.getParameter("date5");
		String loginId5 = request.getParameter("loginId5");
		String room5 = request.getParameter("room5");
		String period5 = request.getParameter("period5");
		String purpose5 = request.getParameter("purpose5");
		String number5 = request.getParameter("number5");

		String join5 = "";
		for (String str : request.getParameterValues("fixtures5")) {
			if (!str.equals("")) {
				join5 = join5 + str + ",";
			}
		}
		if (!join5.equals("")) {
			join5 = join5.substring(0, join5.length() - 1);
		}

		String remarks5 = request.getParameter("remarks5");

		// NULLチェック
		if (date5 == null) {
			date5 = "";
		}
		if (loginId5 == null) {
			loginId5 = "";
		}
		if (room5 == null) {
			room5 = "";
		}
		if (period5 == null) {
			period5 = "";
		}
		if (purpose5 == null) {
			purpose5 = "";
		}
		if (number5 == null) {
			number5 = "";
		}
		if (remarks5 == null) {
			remarks5 = "";
		}

		ReserveService reserveService = new ReserveService();

		// 入力値がある場合1
		if (!"".equals(date1) || !"".equals(loginId1) || !"".equals(room1) || !"".equals(period1)
				|| !"".equals(purpose1) || !"".equals(number1)) {

			// 入力情報を取得
			Reserve reserve = new Reserve(0, date1, Integer.parseInt(period1), room1, Integer.parseInt(purpose1),
					Integer.parseInt(number1), join1, remarks1, loginId1);

			// ユーザーを登録
			reserveService.reserveRegister(reserve);

		}

		// 入力値がある場合2
		if (!"".equals(date2) || !"".equals(loginId2) || !"".equals(room2) || !"".equals(period2)
				|| !"".equals(purpose2) || !"".equals(number2)) {

			// 入力情報を取得
			Reserve reserve = new Reserve(0, date2, Integer.parseInt(period2), room2, Integer.parseInt(purpose2),
					Integer.parseInt(number2), join2, remarks2, loginId2);

			// ユーザーを登録
			reserveService.reserveRegister(reserve);

		}

		// 入力値がある場合3
		if (!"".equals(date3) || !"".equals(loginId3) || !"".equals(room3) || !"".equals(period3)
				|| !"".equals(purpose3) || !"".equals(number3)) {

			// 入力情報を取得
			Reserve reserve = new Reserve(0, date3, Integer.parseInt(period3), room3, Integer.parseInt(purpose3),
					Integer.parseInt(number3), join3, remarks3, loginId3);

			// ユーザーを登録
			reserveService.reserveRegister(reserve);

		}

		// 入力値がある場合4
		if (!"".equals(date4) || !"".equals(loginId4) || !"".equals(room4) || !"".equals(period4)
				|| !"".equals(purpose4) || !"".equals(number4)) {

			// 入力情報を取得
			Reserve reserve = new Reserve(0, date4, Integer.parseInt(period4), room4, Integer.parseInt(purpose4),
					Integer.parseInt(number4), join4, remarks4, loginId4);

			// ユーザーを登録
			reserveService.reserveRegister(reserve);

		}

		// 入力値がある場合5
		if (!"".equals(date5) || !"".equals(loginId5) || !"".equals(room5) || !"".equals(period5)
				|| !"".equals(purpose5) || !"".equals(number5)) {

			// 入力情報を取得
			Reserve reserve = new Reserve(0, date5, Integer.parseInt(period5), room5, Integer.parseInt(purpose5),
					Integer.parseInt(number5), join5, remarks5, loginId5);

			// ユーザーを登録
			reserveService.reserveRegister(reserve);

		}

		// 次画面指定
		request.getRequestDispatcher("adminRoomInsert.jsp").forward(request, response);
	}

}
