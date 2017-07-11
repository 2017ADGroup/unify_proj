package unify;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Rooms;
import service.RoomsService;

/**
 * Servlet implementation class RoomInfoDeleteServlet
 */
@WebServlet("/roomInfoDelete")
public class RoomInfoDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomInfoDeleteServlet() {
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

		// 削除するIDの取得
		String[] roomDelete = request.getParameterValues("roomDelete");

		RoomsService roomsService = new RoomsService();

		// 一括削除
		if (roomDelete != null) {
			for (String roomDel : roomDelete) {

				// roomを削除
				roomsService.erase(Integer.parseInt(roomDel));

			}
		}
		// 全検索
		List<Rooms> list = roomsService.findAll();
		// 検索結果をセッションに保持
		request.setAttribute("roomsList", list);

		request.getRequestDispatcher("roomInfoLump.jsp").forward(request, response);
	}

}
