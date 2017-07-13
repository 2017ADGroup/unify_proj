package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Reserve;
import entity.Users;
import service.ReserveService;

/**
 * Servlet implementation class roomInsertServlet
 */
@WebServlet("/roomInsert")
public class roomInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public roomInsertServlet() {
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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Users login_user = (Users) session.getAttribute("login_user");
		String reserve_host = login_user.getLogin_id();//ログインIDの取得
		String room = (String)session.getAttribute("room");
		String reserve_date = (String) session.getAttribute("reserve_date");
		ReserveService reserveService = new ReserveService();
		int amount = Integer.parseInt(request.getParameter("amount"));
		int purpose = Integer.parseInt(request.getParameter("purpose"));
		String[] facilities = request.getParameterValues("facilities");
		//設備配列をStringに直す
		String facility = "";
		if(facilities == null){
		}else{
			for(int i = 0; i < facilities.length;i++){
				if(facilities.length == 1){
					facility = facility + facilities[0];
				}else{
					if(i == facilities.length - 1){
						facility = facility + facilities[i];
					}else{
						facility = facility + facilities[i];
						facility = facility + ",";
					}
				}
			}
		}
		String remarks = request.getParameter("remarks");
		String[] reserve_term = request.getParameterValues("reserve_term");
		//登録処理
		Reserve reserve = new Reserve();
		if(reserve_term != null){
			for(int i = 0;i < reserve_term.length ;i++){
				reserve.setReserve_id(0);
				reserve.setReserve_date(reserve_date);
				reserve.setTerm(Integer.parseInt(reserve_term[i]));
				reserve.setRoom(room);
				reserve.setPurpose(purpose);
				reserve.setAmount(amount);
				reserve.setFacility(facility);
				reserve.setRemarks(remarks);
				reserve.setReserve_host(reserve_host);
				reserveService.reserveRegister(reserve);
			}
		}

		RequestDispatcher dispatch = request.getRequestDispatcher("roomLump");

		  dispatch.forward(request, response);
		/*RequestDispatcher dispatch = request.getRequestDispatcher("menu.jsp");//Menuを経由する
		dispatch.forward(request, response);*/
	}



}
