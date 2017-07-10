package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Users;

public class UsersDao {

	private static final String SQL_UPDATE = "UPDATE users SET";
	private static final String SQL_ID_BY_NAME = "SELECT * FROM users WHERE login_id = ?";
	private static final String SQL_SELECT_ID_AND_PASS = "SELECT * FROM users WHERE users_id = ? AND password = ?";

	private Connection connection;

	public UsersDao(Connection connection) {
		this.connection = connection;
	}

	//ログイン
	public Users findByIDAndPassword(String login_id, String password) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_ID_AND_PASS)) {
			stmt.setString(1, login_id);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return new Users(rs.getString("login_id"), rs.getString("password"));
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


	public String idByName(String id){
		System.out.println(id);
		try (PreparedStatement stmt =  connection.prepareStatement(SQL_ID_BY_NAME)) {
			stmt.setString(1,id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				return rs.getString("name");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public String nameById(String id){
		System.out.println(id);
		try (PreparedStatement stmt =  connection.prepareStatement(SQL_ID_BY_NAME)) {
			stmt.setString(1,id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				return rs.getString("name");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public int update(Users user) {
		String sql_update = SQL_UPDATE;

		Integer id = user.getUser_id();
		String name = user.getName();
		String kana = user.getKana();
		String pass = user.getPassword();

		int ptn = 0;
		if (name != null) {
			sql_update += " name = ?";
			ptn = 1;
			if (kana != null) {
				sql_update += ", kana = ?";
				ptn = 2;
				if (pass != null) {
					sql_update += ", password = ?";
					ptn = 3;
				}
			} else if (pass != null) {
				sql_update += ", password = ?";
				ptn = 4;
			}
		} else if (kana != null) {
			sql_update += " kana = ?";
			ptn = 5;
			if (pass != null) {
				sql_update += ", password = ?";
				ptn = 6;
			}
		} else if (pass != null) {
			sql_update += " password = ?";
			ptn = 7;
		}

		sql_update += " WHERE login_id = ?";

		try (PreparedStatement stmt =  connection.prepareStatement(sql_update)) {
			switch (ptn) {
			case 1:
				stmt.setString(1, name);
				stmt.setInt(2, id);
				break;
			case 2:
				stmt.setString(1, name);
				stmt.setString(2, kana);
				stmt.setInt(3, id);
				break;
			case 3:
				stmt.setString(1, name);
				stmt.setString(2, kana);
				stmt.setString(3, pass);
				stmt.setInt(4, id);
				break;
			case 4:
				stmt.setString(1, name);
				stmt.setString(2, pass);
				stmt.setInt(3, id);
				break;
			case 5:
				stmt.setString(1, kana);
				stmt.setInt(2, id);
				break;
			case 6:
				stmt.setString(1, kana);
				stmt.setString(2, pass);
				stmt.setInt(3, id);
				break;
			case 7:
				stmt.setString(1, pass);
				stmt.setInt(2, id);
				break;
			default:
				break;
			}

			return stmt.executeUpdate();
		} catch (

		SQLException e) {
			throw new RuntimeException(e);
		}
	}


}
