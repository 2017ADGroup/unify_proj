package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Reserve;

public class ReserveDao {

	private static final String SQL_SELECT_ALL = "SELECT * FROM reserve";
	private static final String SQL_INSERT = "INSERT INTO reserve (reserve_date, term, room, purpose, amount, facility, remarks, reserve_host) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String SQL_UPDATE = "UPDATE reserve SET purpose=?, amount=?, facility=?, remarks=? WHERE reserve_id=?";
	private static final String SQL_DELETE = "DELETE FROM reserve WHERE reserve_id=?";
	private static final String SQL_SELECT_LOGINID_DAYTIME = "SELECT * FROM reserve WHERE reserve_host=? AND reserve_date=?";
	private static final String SQL_SELECT_LOGINID_DAYTIME_TERM = "SELECT * FROM reserve WHERE reserve_host=? AND reserve_date=? AND term=?";
	private static final String SQL_SELECT_ROOM_DAYTIME = "SELECT * FROM reserve WHERE room=? AND reserve_date=?";

	private Connection connection;

	public ReserveDao(Connection connection) {
		this.connection = connection;
	}

	public List<Reserve> selectAll(){

		List<Reserve> reserveList = new ArrayList<Reserve>();

		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_ALL)) {

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Reserve reserve = new Reserve(
					rs.getInt("reserve_id"),
					rs.getString("reserve_date"),
					rs.getInt("term"),
					rs.getString("room"),
					rs.getInt("purpose"),
					rs.getInt("amount"),
					rs.getString("facility"),
					rs.getString("remarks"),
					rs.getString("reserve_host")
					);
				reserveList.add(reserve);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reserveList;
	}

	public void reserveInsert(Reserve reserve){
		try (PreparedStatement stmt = connection.prepareStatement(SQL_INSERT)) {

			stmt.setString(1, reserve.getReserve_date());
			stmt.setInt(2, reserve.getTerm());
			stmt.setString(3, reserve.getRoom());
			stmt.setInt(4, reserve.getPurpose());
			stmt.setInt(5, reserve.getAmount());
			stmt.setString(6, reserve.getFacility());
			stmt.setString(7, reserve.getRemarks());
			stmt.setString(8, reserve.getReserve_host());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void reserveUpdate(Reserve reserve){
		try (PreparedStatement stmt = connection.prepareStatement(SQL_UPDATE)) {

			stmt.setInt(1, reserve.getPurpose());
			stmt.setInt(2, reserve.getAmount());
			stmt.setString(3, reserve.getFacility());
			stmt.setString(4, reserve.getRemarks());
			stmt.setInt(5, reserve.getReserve_id());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void reserveDelete(int reDel){
		try (PreparedStatement stmt = connection.prepareStatement(SQL_DELETE)) {

			stmt.setInt(1, reDel);

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//MenuServletにて使用
	public List<Reserve> selectReserveLoginIdDay(String login_id,String reserve_date){
		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_LOGINID_DAYTIME)) {
			stmt.setString(1, login_id);
			stmt.setString(2, reserve_date);
			ResultSet rs = stmt.executeQuery();
			List<Reserve> reserveList = new ArrayList<Reserve>();
			while (rs.next()) {
				Reserve reserve = new Reserve(
					rs.getInt("reserve_id"),
					rs.getString("reserve_date"),
					rs.getInt("term"),
					rs.getString("room"),
					rs.getInt("purpose"),
					rs.getInt("amount"),
					rs.getString("facility"),
					rs.getString("Remarks()"),
					rs.getString("reserve_host")
					);
				reserveList.add(reserve);
				return reserveList;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	//MenuServletにて使用
	public List<Reserve> selectReserveLoginIdRoomDayTerm(String login_id,String reserve_date,int term){
		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_LOGINID_DAYTIME_TERM)) {
			stmt.setString(1, login_id);
			stmt.setString(2, reserve_date);
			stmt.setInt(3, term);

			ResultSet rs = stmt.executeQuery();
			List<Reserve> reserveList = new ArrayList<Reserve>();
			while (rs.next()) {
				Reserve reserve = new Reserve(
						rs.getInt("reserve_id"),
						rs.getString("reserve_date"),
						rs.getInt("term"),
						rs.getString("room"),
						rs.getInt("purpose"),
						rs.getInt("amount"),
						rs.getString("facility"),
						rs.getString("Remarks()"),
						rs.getString("reserve_host")
						);
				reserveList.add(reserve);
				return reserveList;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Reserve> selectDateRoom(String date,String room){

	try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_ROOM_DAYTIME)) {
		stmt.setString(1, room);
		stmt.setString(2, date);
		ResultSet rs = stmt.executeQuery();
		List<Reserve> reserveList = new ArrayList<Reserve>();
		while (rs.next()) {
			Reserve reserve = new Reserve(
				rs.getInt("reserve_id"),
				rs.getString("reserve_date"),
				rs.getInt("term"),
				rs.getString("room"),
				rs.getInt("purpose"),
				rs.getInt("amount"),
				rs.getString("facility"),
				rs.getString("Remarks()"),
				rs.getString("reserve_host")
				);
			reserveList.add(reserve);
			return reserveList;
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
	}
}
