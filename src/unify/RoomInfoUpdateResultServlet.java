package unify;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import entity.Rooms;
import service.RoomsService;

/**
 * Servlet implementation class RoomInfoUpdateResultServlet
 */
@WebServlet("/roomInfoUpdateResult")
@MultipartConfig(location = "", maxFileSize = 1024 * 1024 * 2)
public class RoomInfoUpdateResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RoomInfoUpdateResultServlet() {
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

		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		String roomsId = (String) session.getAttribute("roomsId");
		Rooms room = (Rooms) session.getAttribute("rooms");

		Part part = request.getPart("file");
		String name = this.getFileName(part);
		if (!name.equals("")) {
			part.write(getServletContext().getRealPath("/image") + "/" + name);
		} else {
			name = room.getImage_path();
		}

		String[] fixtures = request.getParameterValues("newFix");

		String fix = "";
		for (String str : fixtures) {
			if (!str.equals("")) {
				fix = fix + str + ",";
			}
		}
		if (!fix.equals("")) {
			fix = fix.substring(0, fix.length() - 1);
		}

		Rooms rooms = new Rooms(Integer.parseInt(roomsId), name, request.getParameter("newName"),
				Integer.parseInt(request.getParameter("newSize")), fix, request.getParameter("newRemarks"));

		RoomsService roomService = new RoomsService();
		roomService.renew(rooms);

		request.getRequestDispatcher("roomInfoLump").forward(request, response);

	}

	private String getFileName(Part part) {
		String name = null;
		for (String dispotion : part.getHeader("Content-Disposition").split(";")) {
			if (dispotion.trim().startsWith("filename")) {
				name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
				name = name.substring(name.lastIndexOf("\\") + 1);
				break;
			}
		}
		return name;
	}

}
