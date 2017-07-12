package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Users;

public class UsersDao {

		private static final String SQL_UPDATE = "UPDATE users SET";
		private static final String SQL_ID_BY_NAME = "SELECT * FROM users WHERE login_id = ?";
		private static final String SQL_IDS_BY_NAME = "SELECT * FROM users WHERE name = ?";
		private static final String SQL_SELECT_ID_AND_PASS = "SELECT * FROM users WHERE login_id = ? AND password = ?";
		private static final String SQL_DELETE_LOGINID = "DELETE FROM users WHERE user_id = ?";
		private static final String SQL_SELECT = "SELECT * FROM users ORDER BY kana";

		private Connection connection;

		public UsersDao(Connection connection) {
			this.connection = connection;
		}

		// ログイン
		public Users findByIDAndPassword(String login_id, String password) {
			try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_ID_AND_PASS)) {
				stmt.setString(1, login_id);
				stmt.setString(2, password);
				ResultSet rs = stmt.executeQuery();

				if (rs.next()) {
					return new Users(rs.getInt("user_id"), rs.getString("login_id"), rs.getString("password"),
							rs.getInt("property"), rs.getString("name"), rs.getString("kana"), rs.getInt("authority"), rs.getString("organization"));
				} else {
					return null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}

		//名前からidを割り出す
		public List<String> idsByName(String name) {
			System.out.println(name);
			try (PreparedStatement stmt = connection.prepareStatement(SQL_IDS_BY_NAME)) {
				stmt.setString(1, name);
				ResultSet rs = stmt.executeQuery();
				List<String> names = new ArrayList<String>();
				while (rs.next()) {
					names.add(rs.getString("login_id"));
				}
				return names;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}


		public String idByName(String id) {
			System.out.println(id);
			try (PreparedStatement stmt = connection.prepareStatement(SQL_ID_BY_NAME)) {
				stmt.setString(1, id);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					return rs.getString("name");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}

		public String nameById(String id) {
			System.out.println(id);
			try (PreparedStatement stmt = connection.prepareStatement(SQL_ID_BY_NAME)) {
				stmt.setString(1, id);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					return rs.getString("name");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}


		//全件取得
		public List<Users> findAll() {
			List<Users> list = new ArrayList<Users>();

			try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT)) {
				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					Users users = new Users(
						rs.getInt("user_id"),
						rs.getString("login_id"),
						rs.getString("name"),
						rs.getString("kana")

						);
					list.add(users);
				}


			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			return list;
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

			try (PreparedStatement stmt = connection.prepareStatement(sql_update)) {
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

		public void delete(int login_id) {

			try (PreparedStatement stmt = connection.prepareStatement(SQL_DELETE_LOGINID)) {

				stmt.setInt(1, login_id);

				stmt.executeUpdate();

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}

		}
}
