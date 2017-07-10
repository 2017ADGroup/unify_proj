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
	private static final String SQL_INSERT = "INSERT INTO reserve (month, day, term, room, purpose, amount, facility, remarks, reserve_host) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String SQL_SELECT_LOGINID_DAYTIME = "SELECT * FROM reserve WHERE login_id=? AND reserve_date=?";
	private static final String SQL_SELECT_LOGINID_DAYTIME_TERM = "SELECT * FROM reserve WHERE login_id=? AND reserve_date=? AND term=?";

	private Connection connection;

	public ReserveDao(Connection connection) {
		this.connection = connection;
	}

	public List<Reserve> selectAll(){
		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_ALL)) {

			ResultSet rs = stmt.executeQuery();
			List<Reserve> reserveList = new ArrayList<Reserve>();
			while (rs.next()) {
				Reserve reserve = new Reserve(
					rs.getInt("reserve_id"),
					rs.getInt("month"),
					rs.getInt("day"),
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

	public void reserveInsert(Reserve reserve){
		try (PreparedStatement stmt = connection.prepareStatement(SQL_INSERT)) {
			stmt.setInt(1, reserve.getMonth());
			stmt.setInt(2, reserve.getDay());
			stmt.setInt(3, reserve.getTerm());
			stmt.setString(4, reserve.getRoom());
			stmt.setInt(5, reserve.getPurpose());
			stmt.setInt(6, reserve.getAmount());
			stmt.setString(7, reserve.getFacility());
			stmt.setString(8, reserve.getRemarks());
			stmt.setString(9, reserve.getReserve_host());

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
					rs.getInt("month"),
					rs.getInt("day"),
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
					rs.getInt("month"),
					rs.getInt("day"),
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
