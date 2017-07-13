package servlet;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Users;
import service.MenuService;

/**
 * Servlet implementation class menuServlet
 */
@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MenuServlet() {
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
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("login_user");
		MenuService menuService = new MenuService();
		prepData(request);
		// カレンダー生成過程で生まれた日付を利用してスケジュールを生成
		String scheduleDay = String.valueOf(session.getAttribute("year")) + "-" + String.valueOf(session.getAttribute("month")) + "-"
				+  String.valueOf(session.getAttribute("date"));
		request.setAttribute("schedule",
				menuService.scheduleCreate(user.getLogin_id(), scheduleDay));

		RequestDispatcher dispatcher = request.getRequestDispatcher("menu.jsp");
		// フォワードによるページ遷移
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void prepData(HttpServletRequest request) {
		// 変数初期化
		HttpSession session = request.getSession();
		int startday;
		int lastday;
		// カレンダーの取得
		Calendar cal = Calendar.getInstance();
		// 年が設定されていれば、その値を取得。そうでなければ、今年の年号を入れる
		if (request.getParameter("year") == null) {
			session.setAttribute("year", cal.get(Calendar.YEAR)); // 現在の年

		} else {
			session.setAttribute("year", request.getParameter("year")); // 現在の年
		}
		if (request.getParameter("month") == null) {
			session.setAttribute("month", cal.get(Calendar.MONTH) + 1); // 現在の月
		} else {
			session.setAttribute("month", request.getParameter("month")); // 与えらられた月
		}
		if (request.getParameter("days") == null) {
			session.setAttribute("date", cal.get(Calendar.DATE) + 1); // 現在の日
		} else {
			session.setAttribute("date", Integer.parseInt(request.getParameter("days"))); // 与えらられた日
		}
		int year = Integer.parseInt(session.getAttribute("year").toString());
		int month = Integer.parseInt(session.getAttribute("month").toString());
		// 月初めの曜日(日-> 1)
		cal.set(year, month - 1, 1);
		startday = cal.get(Calendar.DAY_OF_WEEK);
		// 月末の日付
		cal.add(Calendar.MONTH, 1);
		cal.add(Calendar.DATE, -1);
		lastday = cal.get(Calendar.DATE);
		// カレンダーのデータを作成する
		int date = 1;
		int maxday = 6 * 7;
		StringBuilder sb = new StringBuilder();
		sb.append("<table  class=\"table table-bordered\">");
		sb.append("<tr>");
		sb.append("<th style=\"color:red;\">日</th>");
		sb.append("<th>月</th><th>火</th><th>水</th><th>木</th><th>金</th>");
		sb.append("<th style=\"color:blue;\">土</th>");
		sb.append("</tr>");
		sb.append("<tr>");
		for (int num = 1; num <= maxday; num++) {
			if (num < startday || num > lastday + startday - 1) {
				sb.append("<td></td>");
			} else {
				sb.append("<td><a href=\"Calender.jsp\" onclick=\"document." + "day" + date
						+ ".submit(); return false;\">" + date + "</a>" + "<form name=\"day" + date
						+ "\" action=\"menu\" method=\"get\">" + "<input type=hidden name=\"days\" value=\"" + date
						+ "\" >" + "</form></td>");
				date++;
			}

			if (num % 7 == 0) {
				sb.append("</tr>");
				if (num > startday + lastday - 1) {
					break;
				}
				if (date < lastday) {
					sb.append("<tr>");
				} else {
					// 最後だったら、ループから抜ける
					break;
				}
			}
		}
		sb.append("</table>");
		// パラメータを設定
		request.setAttribute("calender", sb);
		return;
	}

}
