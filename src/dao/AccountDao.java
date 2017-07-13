package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Users;

public class AccountDao {

	private static final String SQL_INSERT = "INSERT INTO users (login_id, password, property, name, kana, authority, organization) VALUES ( ?, ?, ?, ?, ?, ?, ?)";
	private static final String SQL_ID_BY_NAME = "SELECT * FROM users WHERE login_id = ?";
	private static final String SQL_USERS_SELECT = "SELECT * FROM users";
	private static final String SQL_MAXID = "SELECT MAX(login_id) FROM users";
	private static final String SQL_UPDATE = "UPDATE users SET password= ?, name= ?, kana= ? WHERE login_id=?";
	private Connection connection;

	public AccountDao(Connection connection) {
		this.connection = connection;
	}

	//団体・教員登録用
	//全件取得
	public List<Users> findAll() {
		List<Users> list = new ArrayList<Users>();

		try (PreparedStatement stmt = connection.prepareStatement(SQL_USERS_SELECT)) {
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Users users = new Users(

						rs.getInt("user_id"),
						rs.getString("login_id"),
						rs.getString("password"),
						rs.getInt("property"),
						rs.getString("name"),
						rs.getString("kana"),
						rs.getInt("authority"),
						rs.getString("organization")

					);
				list.add(users);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	// 更新したID(IDの最大値)を取得
	public int maxId() {
		int max = 0;
		try (PreparedStatement stmt = connection.prepareStatement(SQL_MAXID)) {

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				max = rs.getInt("MAX");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return max;
	}

	// ID検索
			public String find(String id) {

				try (PreparedStatement stmt = connection.prepareStatement(SQL_ID_BY_NAME)) {

					stmt.setInt(1, Integer.parseInt(id));
					ResultSet rs = stmt.executeQuery();

					if (rs.next()) {
						return rs.getString("name");
					}
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
				return null;
			}


	public void accountInsert(Users users){
		try (PreparedStatement stmt = connection.prepareStatement(SQL_INSERT)) {

			stmt.setString(1, users.getLogin_id());
			stmt.setString(2, users.getPassword());
			stmt.setInt(3, users.getProperty());
			stmt.setString(4, users.getName());
			stmt.setString(5, users.getKana());
			stmt.setInt(6,  users.getAuthority());
			stmt.setString(7, users.getOrganization());
			stmt.setInt(8, users.getUser_id());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void Update(Users users){
		try (PreparedStatement stmt = connection.prepareStatement(SQL_UPDATE)) {

			stmt.setString(1, users.getPassword());
			stmt.setString(2, users.getName());
			stmt.setString(3, users.getKana());
			stmt.setString(4, users.getLogin_id());

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}