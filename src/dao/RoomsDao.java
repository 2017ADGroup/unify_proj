package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Rooms;

public class RoomsDao {

	private Connection connection;

	public RoomsDao(Connection connection) {
		this.connection = connection;
	}

	private static final String SQL_SELECT_ALL = "SELECT * FROM rooms";
	private static final String SQL_INSERT_WITHOUT_PATH = "INSERT INTO rooms(room,size,facility,remarks) values(?,?,?,?)";
	private static final String SQL_SELECT_MAX_ID = "SELECT MAX(room_id) FROM rooms";
	private static final String SQL_UPDATE_PATH = "UPDATE rooms SET path=? WHERE room_id=?";
	private static final String SQL_DELETE = "DELETE FROM rooms WHERE room_id=?";

	public List<Rooms> selectAll(){

		List<Rooms> list = new ArrayList<Rooms>();

		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_ALL)) {

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Rooms rooms = new Rooms(
					rs.getInt("room_id"),
					rs.getString("image_path"),
					rs.getString("room"),
					rs.getString("size"),
					rs.getString("facility"),
					rs.getString("remarks")
					);
				list.add(rooms);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void roomsInsertWithoutPath(String room,Integer size,String facility,String remarks){
		try (PreparedStatement stmt = connection.prepareStatement(SQL_INSERT_WITHOUT_PATH)) {
			stmt.setString(1, room);
			stmt.setInt(2, size);
			stmt.setString(3, facility);
			stmt.setString(4, remarks);
			@SuppressWarnings("unused")
			int succcess = stmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public int selectNewRoomsId(){
		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_MAX_ID)) {
			ResultSet rs = stmt.executeQuery();
			return rs.getInt("max");//現在行が初期位置のmaxの値を取ってくる……はず
		}catch(SQLException e){
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

	public void delete(int reDel){
		try (PreparedStatement stmt = connection.prepareStatement(SQL_DELETE)) {

			stmt.setInt(1, reDel);

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
