package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Users;

public class AccountDao {

	private static final String SQL_INSERT = "INSERT INTO users (login_id, password, property, name, kana, authority) VALUES ( ?, ?, ?, ?, ?, ?)";
	private static final String SQL_ID_BY_NAME = "SELECT * FROM users WHERE login_id = ?";

	private static Connection connection;

	public AccountDao(Connection connection) {
		AccountDao.connection = connection;
	}


	// ID検索
		public static Users find(String id) {

			try (PreparedStatement stmt = connection.prepareStatement(SQL_ID_BY_NAME)) {

				stmt.setInt(1, Integer.parseInt(id));
				ResultSet rs = stmt.executeQuery();

				if (rs.next()) {
					return new Users();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}

			return null;
		}

	public void accountInsert(Users account){
		try (PreparedStatement stmt = connection.prepareStatement(SQL_INSERT)) {
			stmt.setString(1, account.getLogin_id());
			stmt.setString(2, account.getPassword());
			stmt.setInt(3, account.getProperty());
			stmt.setString(4, account.getName());
			stmt.setString(5, account.getKana());
			stmt.setInt(6, account.getAuthority());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}