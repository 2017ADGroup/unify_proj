package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import entity.Rooms;

public class RoomsDao {

	private Connection connection;

	public RoomsDao(Connection connection) {
		this.connection = connection;
	}

	private static final String SQL_SELECT_ALL = "SELECT * FROM rooms";
	private static final String SQL_SELECT_ID = "SELECT * FROM rooms WHERE room_id=?";
	private static final String SQL_SELECT_FIX = "SELECT * FROM rooms WHERE room=?";
	private static String SQL_SELECT = "SELECT * FROM rooms";
	private static final String SQL_INSERT_WITHOUT_PATH = "INSERT INTO rooms(room,size,facility,remarks) values(?,?,?,?)";
	private static final String SQL_SELECT_MAX_ID = "SELECT MAX(room_id) FROM rooms";
	private static final String SQL_UPDATE_PATH = "UPDATE rooms SET path=? WHERE room_id=?";
	private static final String SQL_INSERT = "INSERT INTO rooms(image_path, room, size, facility, remarks) values(?,?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE rooms SET room=?, size=?, facility=?, remarks=? WHERE room_id=?";
	private static final String SQL_DELETE = "DELETE FROM rooms WHERE room_id=?";

	public List<Rooms> selectAll() {

		List<Rooms> list = new ArrayList<Rooms>();

		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_ALL)) {

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Rooms rooms = new Rooms(rs.getInt("room_id"), rs.getString("image_path"), rs.getString("room"),
						rs.getInt("size"), rs.getString("facility"), rs.getString("remarks"));
				list.add(rooms);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public Rooms select(int id) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_ID)) {
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return new Rooms(rs.getInt("room_id"), rs.getString("image_path"), rs.getString("room"),
						rs.getInt("size"), rs.getString("facility"), rs.getString("remarks"));
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public String selectFix(String room) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_FIX)) {
			stmt.setString(1, room);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return rs.getString("facility");
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void roomsInsertWithoutPath(String room, Integer size, String facility, String remarks) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_INSERT_WITHOUT_PATH)) {
			stmt.setString(1, room);
			stmt.setInt(2, size);
			stmt.setString(3, facility);
			stmt.setString(4, remarks);
			@SuppressWarnings("unused")
			int succcess = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int selectNewRoomsId() {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_MAX_ID)) {
			ResultSet rs = stmt.executeQuery();
			return rs.getInt("max");// 現在行が初期位置のmaxの値を取ってくる……はず
		} catch (SQLException e) {
			return 0;
		}

	}

	public int updateNewRoomsPath(int room_id, String name) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_UPDATE_PATH)) {
			stmt.setString(1, name);
			stmt.setInt(2, room_id);
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public void insert(Rooms rooms) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_INSERT)) {

			stmt.setString(1, rooms.getImage_path());
			stmt.setString(2, rooms.getRoom());
			stmt.setInt(3, rooms.getSize());
			stmt.setString(4, rooms.getFacility());
			stmt.setString(5, rooms.getRemarks());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Rooms rooms) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_UPDATE)) {

			stmt.setString(1, rooms.getRoom());
			stmt.setInt(2, rooms.getSize());
			stmt.setString(3, rooms.getFacility());
			stmt.setString(4, rooms.getRemarks());
			stmt.setInt(5, rooms.getRoom_id());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(int reDel) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_DELETE)) {

			stmt.setInt(1, reDel);

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Rooms> selectRooms(String room, int min, int max, String facility) {
		// TODO 条件に合ったテーブルの取得を行う
		ArrayDeque<String> stack = new ArrayDeque<String>();
		// なんらかの入力がされている場合、WHEREを追加
		if (!room.isEmpty() || min != -1 || max != -1 || !facility.isEmpty()) {
			SQL_SELECT = SQL_SELECT + " WHERE";
		}
		// 入力されているパラメータに応じてプレースホルダーを追加。同時にキューにその順番がストックされる
		if (!room.isEmpty()) {
			if (stack.peek() != null) {
				SQL_SELECT = SQL_SELECT + " AND";
			}
			SQL_SELECT = SQL_SELECT + " room LIKE ?";
			stack.addFirst("room");
		}
		// ストックに検索条件が入っていればＡＮＤを入れる必要性がある
		if (min != -1) {
			if (stack.peek() != null) {
				SQL_SELECT = SQL_SELECT + " AND";
			}
			SQL_SELECT = SQL_SELECT + " size >= ?";
			stack.addFirst("min");
		}
		// ストックに検索条件が入っていればＡＮＤを入れる必要性がある
		if (max != -1) {
			if (stack.peek() != null) {
				SQL_SELECT = SQL_SELECT + " AND";
			}
			SQL_SELECT = SQL_SELECT + " size <= ?";
			stack.addFirst("max");
		}

		if (!facility.isEmpty()) {
			if (stack.peek() != null) {
				SQL_SELECT = SQL_SELECT + " AND";
			}
			SQL_SELECT = SQL_SELECT + " facility LIKE ?";
			stack.addFirst("facility");
		}

		SQL_SELECT = SQL_SELECT + " ORDER BY room_id";
		List<Rooms> roomList = new ArrayList<Rooms>();
		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT)) {
			int d = stack.size();
			@SuppressWarnings("unused")
			String curum;
			for (int c = 1; c <= d; c++) {
				if (stack.getLast().equals("room")) {
					curum = stack.removeLast();
					stmt.setString(c, "%" + room + "%");
				} else if (stack.getLast().equals("min")) {
					curum = stack.removeLast();
					stmt.setInt(c, min);
				} else if (stack.getLast().equals("max")) {
					curum = stack.removeLast();
					stmt.setInt(c, max);
				} else if (stack.getLast().equals("facility")) {
					curum = stack.removeLast();
					stmt.setString(c, "%" + facility + "%");
				} else {
				}
			}
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// パスワードは閲覧不可情報とし、nullを格納しておく
				Rooms rooms = new Rooms(rs.getInt("room_id"), rs.getString("image_path"), rs.getString("room"),
						rs.getInt("size"), rs.getString("facility"), rs.getString("remarks"));
				roomList.add(rooms);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			SQL_SELECT = "SELECT * FROM rooms";
		}
		return roomList;
	}
}