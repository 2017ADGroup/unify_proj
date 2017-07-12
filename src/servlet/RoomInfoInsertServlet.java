package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import entity.Rooms;
import service.RoomsService;

/**
 * Servlet implementation class roomInfoInsert
 */
@WebServlet("/roomInfoInsert")
@MultipartConfig(location = "/tmp", maxFileSize = 1048576)
public class RoomInfoInsertServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		Part part = request.getPart("file");
		System.out.println(part);
		String name = this.getFileName(part);
		if (!name.equals("")) {
			part.write(getServletContext().getRealPath("/image") + "/" + name);
		} else {
			name = "noimage.png";
		}

		String room = request.getParameter("room");
		String size = request.getParameter("size");
		String[] facility = request.getParameterValues("facility");
		String remarks = request.getParameter("remarks");

		String join1 = "";
		for (String str : facility) {
			if (!str.equals("")) {
				join1 = join1 + str + ",";
			}
		}
		if (!join1.equals("")) {
			join1 = join1.substring(0, join1.length() - 1);
		}

		Rooms rooms = new Rooms(0, name, room, Integer.parseInt(size), join1, remarks);

		RoomsService roomsService = new RoomsService();
		roomsService.register(rooms);

		request.getRequestDispatcher("roomInfoInsert.jsp").forward(request, response);

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
