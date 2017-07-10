package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Mail;

public class MailDao {

	private static final String SQL_SELECT_ALL = "SELECT * FROM mail";
	private static final String SQL_SELECT_BY_ID = "SELECT * FROM mail WHERE mail_id = ?";
	private static final String SQL_INSERT = "INSERT INTO user_info (sender, receiver, deytime,subject,message) VALUES ( ?, ?, ?, ?, ?)";
	private static final String SQL_UPDATE = "UPDATE mail SET sender = ?,recever = ?,deytime = ?,subject = ?,message = ? WHERE mail_id = ?";
	private static final String SQL_DELETE = "DELETE FROM mail WHERE mail_id = ?";
	private static final Mail Mail = null;

	private Connection connection;

	public MailDao(Connection connection) {
		this.connection = connection;
	}

	public List<Mail> mailFindAll() {
		List<Mail> list = new ArrayList<Mail>();

		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_ALL)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Mail m = new Mail(rs.getInt("mail_id"), rs.getString("sender"), rs.getString("receiver"),
						rs.getString("daytime"), rs.getString("subject"), rs.getString("message"));
				list.add(m);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return list;
	}

	public Mail mailFindById(int mail_id) {
		List<Mail> list = new ArrayList<Mail>();

		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_BY_ID)) {
			stmt.setInt(1, mail_id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				return	new Mail(rs.getInt("mail_id"), rs.getString("sender"), rs.getString("receiver"),rs.getString("daytime"), rs.getString("subject"), rs.getString("message"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}

	public List<Mail> mailFind(String name) {

		List<Mail> list = new ArrayList<Mail>();
		String sql = SQL_SELECT_ALL;
		int count = 0;
		int[] arr = { 0, 0, 0 };
		if (!"-1".equals(id)) {
			if (count == 0) {
				sql += " WHERE user_id = ? ";
			}
			arr[0] = 1;
			count++;
		}
		if (!"".equals(name)) {
			if (count == 0) {
				sql += " WHERE user_name = ?";
			} else {
				sql += " AND user_name = ?";
			}
			arr[1] = 1;
			count++;
		}
		if (!"".equals(tel)) {
			if (count == 0) {
				sql += " WHERE telephone = ?";
			} else {
				sql += " AND telephone = ?";
			}
			arr[2] = 1;
			count++;
		}
		sql += " ORDER BY user_id";

		System.out.println(sql);
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			int count2 = 1;
			for (int i = 0; i < 3; i++) {
				if (arr[i] == 1) {
					switch (i) {
					case 0:
						stmt.setInt(count2, Integer.valueOf(id));
						count2++;
						break;
					case 1:
						stmt.setString(count2, name);
						count2++;
						break;
					case 2:
						stmt.setString(count2, tel);
						count2++;
						break;
					}
				}
			}
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Mail m = new Mail(rs.getInt("mail_id"), rs.getString("sender"), rs.getString("receiver"),
						rs.getString("daytime"), rs.getString("subject"), rs.getString("message"));
				list.add(m);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	public void mailInsert(String to, String from, String time, String subject, String message) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_UPDATE)) {
			stmt.setString(1, to);
			stmt.setString(2, from);
			stmt.setString(3, time);
			stmt.setString(4, subject);
			stmt.setString(5, message);
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void mailupdate(int id, String to, String from, String time, String subject, String message) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_INSERT)) {
			stmt.setString(1, to);
			stmt.setString(2, from);
			stmt.setString(3, time);
			stmt.setString(4, subject);
			stmt.setString(5, message);
			stmt.setInt(5, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void maildelete(int id) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_DELETE)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
