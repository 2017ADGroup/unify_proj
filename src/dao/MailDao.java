package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Mail;

public class MailDao {

	private static final String SQL_SELECT = "SELECT * FROM mail";
	private static final String SQL_INSERT = "INSERT INTO user_info (sender, receiver, deytime,subject,message) VALUES ( ?, ?, ?, ?, ?)";
	private static final String SQL_UPDATE = "UPDATE mail SET sender = ?,recever = ?,deytime = ?,subject = ?,message = ? WHERE mail_id = ?";
	private static final String SQL_DELETE = "DELETE FROM mail WHERE mail_id = ?";

	private Connection connection;

	public MailDao(Connection connection) {
		this.connection = connection;
	}

	public List<Mail> mailSelect(){
		List<Mail> list = new ArrayList<Mail>();

		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT)) {
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Mail m = new Mail(rs.getInt("mail_id") ,rs.getString("sender"), rs.getString("receiver"), rs.getString("deytime"), rs.getString("subject"), rs.getString("message"));
				list.add(m);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	public void mailInsert(String to,String from,String time,String subject,String message){
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

	public void mailupdate(int id,String to,String from,String time,String subject,String message){
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
	public void maildelete(int id){
		try (PreparedStatement stmt = connection.prepareStatement(SQL_DELETE)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
