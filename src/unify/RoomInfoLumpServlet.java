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
 * Servlet implementation class DeleteConfirmServlet
 */
@WebServlet("/roomInfoLump")
public class RoomInfoLumpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 文字化け対策
		request.setCharacterEncoding("UTF-8");

		RoomsService roomsService = new RoomsService();
		// 全検索
		List<Rooms> list = roomsService.findAll();
		// 検索結果をセッションに保持
		request.setAttribute("roomsList", list);
		// 次画面指定
		request.getRequestDispatcher("roomInfoLump.jsp").forward(request, response);

	}

}

