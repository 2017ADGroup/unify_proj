package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entity.Reserve;

public class ReserveDao {

	private static final String SQL_INSERT = "INSERT INTO reserve (month, day, term, room, purpose, amount, facility, remarks, reserve_host) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	private Connection connection;

	public ReserveDao(Connection connection) {
		this.connection = connection;
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
			throw new RuntimeException(e);
		}
	}

}
