package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import entity.Mail;

public class MailDao {

	private static final String SQL_SELECT_ALL = "SELECT * FROM mail";
	private static final String SQL_SELECT_BY_MAILID = "SELECT * FROM mail WHERE mail_id = ?";
	private static final String SQL_SELECT_BY_LOGINID = "SELECT * FROM mail WHERE receiver = ? OR sender = ?";
	private static final String SQL_INSERT = "INSERT INTO user_info (sender, receiver, deytime,subject,message) VALUES ( ?, ?, ?, ?, ?)";
	private static final String SQL_UPDATE = "UPDATE mail SET sender = ?,receiver = ?,deytime = ?,subject = ?,message = ? WHERE mail_id = ?";
	private static final String SQL_DELETE = "DELETE FROM mail WHERE mail_id = ?";
	private static String SQL_SELECT = "SELECT * FROM mail";

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

	public Mail mailFindByMailId(int mail_id) {

		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_BY_MAILID)) {
			stmt.setInt(1, mail_id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				return new Mail(rs.getInt("mail_id"), rs.getString("sender"), rs.getString("receiver"),
						rs.getString("daytime"), rs.getString("subject"), rs.getString("message"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}

	public List<Mail> mailFind() {
		return null;
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

	public List<Mail> mailFindByLoginId(String login_id) {
		List<Mail> list = new ArrayList<Mail>();
		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_BY_LOGINID)) {
			stmt.setString(1, login_id);
			stmt.setString(2, login_id);
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

	// from to双方にチェックがされたidによる検索
	public List<Mail> SelectWhereIdFromTo(String login_id, String keyword, String daytime) {
		// TODO 条件に合ったテーブルの取得を行う
		ArrayDeque<String> stack = new ArrayDeque<String>();
		// なんらかの入力がされている場合、WHEREを追加
		if (!login_id.isEmpty() || !keyword.isEmpty() || !daytime.isEmpty()) {
			SQL_SELECT = SQL_SELECT + " WHERE";
		}
		// 入力されているパラメータに応じてプレースホルダーを追加。同時にキューにその順番がストックされる
		if (!login_id.isEmpty()) {
			if (stack.peek() != null) {
				SQL_SELECT = SQL_SELECT + " AND";
			}
			SQL_SELECT = SQL_SELECT + " (sender=?";
			SQL_SELECT = SQL_SELECT + " OR receiver=?)";
			stack.addFirst("sender");
			stack.addFirst("receiver");
		}
		// ストックに検索条件が入っていればＡＮＤを入れる必要性がある
		if (!keyword.isEmpty()) {
			if (stack.peek() != null) {
				SQL_SELECT = SQL_SELECT + " AND";
			}
			SQL_SELECT = SQL_SELECT + " (subject=?";
			stack.addFirst("subject");
			SQL_SELECT = SQL_SELECT + " OR message=?)";
			stack.addFirst("message");
		}
		// ストックに検索条件が入っていればＡＮＤを入れる必要性がある
		if (!daytime.isEmpty()) {
			if (stack.peek() != null) {
				SQL_SELECT = SQL_SELECT + " AND";
			}
			SQL_SELECT = SQL_SELECT + " daytime=?";
			stack.addFirst("daytime");
		}

		SQL_SELECT = SQL_SELECT + " ORDER BY mail_id";
		List<Mail> mailList = new ArrayList<Mail>();
		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT)) {
			int d = stack.size();
			@SuppressWarnings("unused")
			String curum;
			for (int c = 1; c <= d; c++) {
				if (stack.getLast().equals("sender")) {
					curum = stack.removeLast();
					stmt.setString(c, login_id);
				} else if (stack.getLast().equals("receiver")) {
					curum = stack.removeLast();
					stmt.setString(c, login_id);
				} else if (stack.getLast().equals("subject")) {
					curum = stack.removeLast();
					stmt.setString(c, "%" + keyword + "%");
				} else if (stack.getLast().equals("message")) {
					curum = stack.removeLast();
					stmt.setString(c, "%" + keyword + "%");
				} else if (stack.getLast().equals("daytime")) {
					curum = stack.removeLast();
					stmt.setString(c, "%" + daytime + "%");
				} else {
				}
			}
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// パスワードは閲覧不可情報とし、nullを格納しておく
				Mail mail = new Mail(rs.getInt("mail_id"), rs.getString("receiver"), rs.getString("sender"),
						rs.getString("daytime"), rs.getString("subject"), rs.getString("message"));
				mailList.add(mail);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			SQL_SELECT = "SELECT user_id, user_name, telephone FROM user_info";
		}
		return mailList;
	}

	// from にチェックがされたidによる検索
	public List<Mail> SelectWhereIdFrom(String login_id, String keyword, String daytime) {
		// TODO 条件に合ったテーブルの取得を行う
		ArrayDeque<String> stack = new ArrayDeque<String>();
		// なんらかの入力がされている場合、WHEREを追加
		if (!login_id.isEmpty() || !keyword.isEmpty() || !daytime.isEmpty()) {
			SQL_SELECT = SQL_SELECT + " WHERE";
		}
		// 入力されているパラメータに応じてプレースホルダーを追加。同時にキューにその順番がストックされる
		if (!login_id.isEmpty()) {
			if (stack.peek() != null) {
				SQL_SELECT = SQL_SELECT + " AND";
			}
			SQL_SELECT = SQL_SELECT + " sender=?";
			stack.addFirst("sender");
		}
		// ストックに検索条件が入っていればＡＮＤを入れる必要性がある
		if (!keyword.isEmpty()) {
			if (stack.peek() != null) {
				SQL_SELECT = SQL_SELECT + " AND";
			}
			SQL_SELECT = SQL_SELECT + " (subject=?";
			stack.addFirst("subject");
			SQL_SELECT = SQL_SELECT + " OR message=?)";
			stack.addFirst("message");
		}
		// ストックに検索条件が入っていればＡＮＤを入れる必要性がある
		if (!daytime.isEmpty()) {
			if (stack.peek() != null) {
				SQL_SELECT = SQL_SELECT + " AND";
			}
			SQL_SELECT = SQL_SELECT + " daytime=?";
			stack.addFirst("daytime");
		}

		SQL_SELECT = SQL_SELECT + " ORDER BY mail_id";
		List<Mail> mailList = new ArrayList<Mail>();
		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT)) {
			int d = stack.size();
			@SuppressWarnings("unused")
			String curum;
			for (int c = 1; c <= d; c++) {
				if (stack.getLast().equals("sender")) {
					curum = stack.removeLast();
					stmt.setString(c, login_id);
				} else if (stack.getLast().equals("receiver")) {
					curum = stack.removeLast();
					stmt.setString(c, login_id);
				} else if (stack.getLast().equals("subject")) {
					curum = stack.removeLast();
					stmt.setString(c, "%" + keyword + "%");
				} else if (stack.getLast().equals("message")) {
					curum = stack.removeLast();
					stmt.setString(c, "%" + keyword + "%");
				} else if (stack.getLast().equals("daytime")) {
					curum = stack.removeLast();
					stmt.setString(c, "%" + daytime + "%");
				} else {
				}
			}
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// パスワードは閲覧不可情報とし、nullを格納しておく
				Mail mail = new Mail(rs.getInt("mail_id"), rs.getString("receiver"), rs.getString("sender"),
						rs.getString("daytime"), rs.getString("subject"), rs.getString("message"));
				mailList.add(mail);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			SQL_SELECT = "SELECT user_id, user_name, telephone FROM user_info";
		}
		return mailList;
	}

	// to にチェックがされたidによる検索
	public List<Mail> SelectWhereIdTo(String login_id, String keyword, String daytime) {
		// TODO 条件に合ったテーブルの取得を行う
		ArrayDeque<String> stack = new ArrayDeque<String>();
		// なんらかの入力がされている場合、WHEREを追加
		if (!login_id.isEmpty() || !keyword.isEmpty() || !daytime.isEmpty()) {
			SQL_SELECT = SQL_SELECT + " WHERE";
		}
		// 入力されているパラメータに応じてプレースホルダーを追加。同時にキューにその順番がストックされる
		if (!login_id.isEmpty()) {
			if (stack.peek() != null) {
				SQL_SELECT = SQL_SELECT + " AND";
			}
			SQL_SELECT = SQL_SELECT + " receiver=?)";
			stack.addFirst("receiver");
		}
		// ストックに検索条件が入っていればＡＮＤを入れる必要性がある
		if (!keyword.isEmpty()) {
			if (stack.peek() != null) {
				SQL_SELECT = SQL_SELECT + " AND";
			}
			SQL_SELECT = SQL_SELECT + " (subject=?";
			stack.addFirst("subject");
			SQL_SELECT = SQL_SELECT + " OR message=?)";
			stack.addFirst("message");
		}
		// ストックに検索条件が入っていればＡＮＤを入れる必要性がある
		if (!daytime.isEmpty()) {
			if (stack.peek() != null) {
				SQL_SELECT = SQL_SELECT + " AND";
			}
			SQL_SELECT = SQL_SELECT + " daytime=?";
			stack.addFirst("daytime");
		}

		SQL_SELECT = SQL_SELECT + " ORDER BY mail_id";
		List<Mail> mailList = new ArrayList<Mail>();
		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT)) {
			int d = stack.size();
			@SuppressWarnings("unused")
			String curum;
			for (int c = 1; c <= d; c++) {
				if (stack.getLast().equals("sender")) {
					curum = stack.removeLast();
					stmt.setString(c, login_id);
				} else if (stack.getLast().equals("receiver")) {
					curum = stack.removeLast();
					stmt.setString(c, login_id);
				} else if (stack.getLast().equals("subject")) {
					curum = stack.removeLast();
					stmt.setString(c, "%" + keyword + "%");
				} else if (stack.getLast().equals("message")) {
					curum = stack.removeLast();
					stmt.setString(c, "%" + keyword + "%");
				} else if (stack.getLast().equals("daytime")) {
					curum = stack.removeLast();
					stmt.setString(c, "%" + daytime + "%");
				} else {
				}
			}
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// パスワードは閲覧不可情報とし、nullを格納しておく
				Mail mail = new Mail(rs.getInt("mail_id"), rs.getString("receiver"), rs.getString("sender"),
						rs.getString("daytime"), rs.getString("subject"), rs.getString("message"));
				mailList.add(mail);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			SQL_SELECT = "SELECT user_id, user_name, telephone FROM user_info";
		}
		return mailList;
	}

	// from to双方にチェックがされた名前による検索
	public List<Mail> SelectWhereNameFromTo(String[] login_id, String keyword, String daytime) {
		// TODO 条件に合ったテーブルの取得を行う
		ArrayDeque<String> stack = new ArrayDeque<String>();
		// なんらかの入力がされている場合、WHEREを追加
		if (login_id.length != 0 || !keyword.isEmpty() || !daytime.isEmpty()) {
			SQL_SELECT = SQL_SELECT + " WHERE";
		}
		// 入力されているパラメータに応じてプレースホルダーを追加。同時にキューにその順番がストックされる
		if (login_id.length != 0) {
			if (stack.peek() != null) {// 既に別の条件がある場合ANDを追加
				SQL_SELECT = SQL_SELECT + " AND";
			}

			for (int i = 0; i < login_id.length; i++) {
				if(login_id.length == 1){
					SQL_SELECT = SQL_SELECT + " (sender=?";
					SQL_SELECT = SQL_SELECT + " OR receiver=?)";
					stack.addFirst("sender");
					stack.addFirst("receiver");
				}else{
					if (i == 0) {
						SQL_SELECT = SQL_SELECT + " (sender=?";
						SQL_SELECT = SQL_SELECT + " OR receiver=?";
						stack.addFirst("sender");
						stack.addFirst("receiver");
					} else if (i == login_id.length - 1) {
						SQL_SELECT = SQL_SELECT + " OR sender=?";
						SQL_SELECT = SQL_SELECT + " OR receiver=?)";
						stack.addFirst("sender");
						stack.addFirst("receiver");
					} else {
						SQL_SELECT = SQL_SELECT + " OR sender=?";
						SQL_SELECT = SQL_SELECT + " OR receiver=?)";
						stack.addFirst("sender");
						stack.addFirst("receiver");
					}
				}
			}
		}

		// ストックに検索条件が入っていればＡＮＤを入れる必要性がある
		if (!keyword.isEmpty()) {
			if (stack.peek() != null) {
				SQL_SELECT = SQL_SELECT + " AND";
			}
			SQL_SELECT = SQL_SELECT + " (subject=?";
			stack.addFirst("subject");
			SQL_SELECT = SQL_SELECT + " OR message=?)";
			stack.addFirst("message");
		}
		// ストックに検索条件が入っていればＡＮＤを入れる必要性がある
		if (!daytime.isEmpty()) {
			if (stack.peek() != null) {
				SQL_SELECT = SQL_SELECT + " AND";
			}
			SQL_SELECT = SQL_SELECT + " daytime=?";
			stack.addFirst("daytime");
		}

		SQL_SELECT = SQL_SELECT + " ORDER BY mail_id";
		List<Mail> mailList = new ArrayList<Mail>();

		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT)) {
			@SuppressWarnings("unused")
			String curum;
			for (int c = 1; c <= stack.size(); c++) {
				if (c <= login_id.length * 2) {
					int idCount = 0;
					if (stack.getLast().equals("sender")) {
						curum = stack.removeLast();
						stmt.setString(c, login_id[idCount]);
					} else if (stack.getLast().equals("receiver")) {
						curum = stack.removeLast();
						stmt.setString(c, login_id[idCount]);
					} else {

					}

					if (c % 2 == 0) {// 2回入れるごとに挿入する値を変更する
						idCount++;
					} else {
					}

				} else {// 名前検索を超えた部分
					if (stack.getLast().equals("subject")) {
						curum = stack.removeLast();
						stmt.setString(c, "%" + keyword + "%");
					} else if (stack.getLast().equals("message")) {
						curum = stack.removeLast();
						stmt.setString(c, "%" + keyword + "%");
					} else if (stack.getLast().equals("daytime")) {
						curum = stack.removeLast();
						stmt.setString(c, "%" + daytime + "%");
					} else {
					}
				}
			} // プレースホルダーセット終了

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Mail mail = new Mail(rs.getInt("mail_id"), rs.getString("receiver"), rs.getString("sender"),
						rs.getString("daytime"), rs.getString("subject"), rs.getString("message"));
				mailList.add(mail);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			SQL_SELECT = "SELECT user_id, user_name, telephone FROM user_info";
		}
		return mailList;
	}

	// from にチェックがされた名前による検索
	public List<Mail> SelectWhereNameFrom(String[] login_id, String keyword, String daytime) {
		// TODO 条件に合ったテーブルの取得を行う
		ArrayDeque<String> stack = new ArrayDeque<String>();
		// なんらかの入力がされている場合、WHEREを追加
		if (login_id.length != 0 || !keyword.isEmpty() || !daytime.isEmpty()) {
			SQL_SELECT = SQL_SELECT + " WHERE";
		}
		// 入力されているパラメータに応じてプレースホルダーを追加。同時にキューにその順番がストックされる
		if (login_id.length != 0) {
			if (stack.peek() != null) {// 既に別の条件がある場合ANDを追加
				SQL_SELECT = SQL_SELECT + " AND";
			}

			for (int i = 0; i < login_id.length; i++) {
				if(login_id.length == 0){
					SQL_SELECT = SQL_SELECT + " sender=?";
					stack.addFirst("sender");
				}else{
					if (i == 0) {
						SQL_SELECT = SQL_SELECT + " (sender=?";
						stack.addFirst("sender");
					} else if (i == login_id.length - 1) {
						SQL_SELECT = SQL_SELECT + " OR sender=?";
						stack.addFirst("sender");
					} else {
						SQL_SELECT = SQL_SELECT + " OR sender=?)";
						stack.addFirst("sender");
					}
			}
		}

		// ストックに検索条件が入っていればＡＮＤを入れる必要性がある
		if (!keyword.isEmpty()) {
			if (stack.peek() != null) {
				SQL_SELECT = SQL_SELECT + " AND";
			}
			SQL_SELECT = SQL_SELECT + " (subject=?";
			stack.addFirst("subject");
			SQL_SELECT = SQL_SELECT + " OR message=?)";
			stack.addFirst("message");
		}
		// ストックに検索条件が入っていればＡＮＤを入れる必要性がある
		if (!daytime.isEmpty()) {
			if (stack.peek() != null) {
				SQL_SELECT = SQL_SELECT + " AND";
			}
			SQL_SELECT = SQL_SELECT + " daytime=?";
			stack.addFirst("daytime");
		}

		SQL_SELECT = SQL_SELECT + " ORDER BY mail_id";
		List<Mail> mailList = new ArrayList<Mail>();

		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT)) {
			@SuppressWarnings("unused")
			String curum;
			for (int c = 1; c <= stack.size(); c++) {
				if (c <= login_id.length) {
					if (stack.getLast().equals("sender")) {
						curum = stack.removeLast();
						stmt.setString(c, login_id[c - 1]);
					} else {
					}

				} else {// 名前検索を超えた部分
					if (stack.getLast().equals("subject")) {
						curum = stack.removeLast();
						stmt.setString(c, "%" + keyword + "%");
					} else if (stack.getLast().equals("message")) {
						curum = stack.removeLast();
						stmt.setString(c, "%" + keyword + "%");
					} else if (stack.getLast().equals("daytime")) {
						curum = stack.removeLast();
						stmt.setString(c, "%" + daytime + "%");
					} else {
					}
				}
			} // プレースホルダーセット終了

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Mail mail = new Mail(rs.getInt("mail_id"), rs.getString("receiver"), rs.getString("sender"),
						rs.getString("daytime"), rs.getString("subject"), rs.getString("message"));
				mailList.add(mail);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			SQL_SELECT = "SELECT user_id, user_name, telephone FROM user_info";
		}
		return mailList;
	}


	// from to双方にチェックがされた名前による検索
	public List<Mail> SelectWhereNameTo(String[] login_id, String keyword, String daytime) {
		// TODO 条件に合ったテーブルの取得を行う
		ArrayDeque<String> stack = new ArrayDeque<String>();
		// なんらかの入力がされている場合、WHEREを追加
		if (login_id.length != 0 || !keyword.isEmpty() || !daytime.isEmpty()) {
			SQL_SELECT = SQL_SELECT + " WHERE";
		}
		// 入力されているパラメータに応じてプレースホルダーを追加。同時にキューにその順番がストックされる
		if (login_id.length != 0) {
			if (stack.peek() != null) {// 既に別の条件がある場合ANDを追加
				SQL_SELECT = SQL_SELECT + " AND";
			}

			for (int i = 0; i < login_id.length; i++) {
				if(login_id.length == 0){
					SQL_SELECT = SQL_SELECT + " receiver=?";
					stack.addFirst("receiver");
				}else{
					if (i == 0) {
						SQL_SELECT = SQL_SELECT + "(receiver=?";
						stack.addFirst("receiver");
					} else if (i == login_id.length - 1) {
						SQL_SELECT = SQL_SELECT + " OR receiver=?)";
						stack.addFirst("receiver");
					} else {
						SQL_SELECT = SQL_SELECT + " OR receiver=?)";
						stack.addFirst("receiver");
					}
				}
			}
		}

		// ストックに検索条件が入っていればＡＮＤを入れる必要性がある
		if (!keyword.isEmpty()) {
			if (stack.peek() != null) {
				SQL_SELECT = SQL_SELECT + " AND";
			}
			SQL_SELECT = SQL_SELECT + " (subject=?";
			stack.addFirst("subject");
			SQL_SELECT = SQL_SELECT + " OR message=?)";
			stack.addFirst("message");
		}
		// ストックに検索条件が入っていればＡＮＤを入れる必要性がある
		if (!daytime.isEmpty()) {
			if (stack.peek() != null) {
				SQL_SELECT = SQL_SELECT + " AND";
			}
			SQL_SELECT = SQL_SELECT + " daytime=?";
			stack.addFirst("daytime");
		}

		SQL_SELECT = SQL_SELECT + " ORDER BY mail_id";
		List<Mail> mailList = new ArrayList<Mail>();

		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT)) {
			@SuppressWarnings("unused")
			String curum;
			for (int c = 1; c <= stack.size(); c++) {
				if (c <= login_id.length) {
					if (stack.getLast().equals("sender")) {
						curum = stack.removeLast();
						stmt.setString(c, login_id[login_id.length - 1]);
					} else if (stack.getLast().equals("receiver")) {
						curum = stack.removeLast();
						stmt.setString(c, login_id[login_id.length - 1]);
					} else {
					}

				} else {// 名前検索を超えた部分
					if (stack.getLast().equals("subject")) {
						curum = stack.removeLast();
						stmt.setString(c, "%" + keyword + "%");
					} else if (stack.getLast().equals("message")) {
						curum = stack.removeLast();
						stmt.setString(c, "%" + keyword + "%");
					} else if (stack.getLast().equals("daytime")) {
						curum = stack.removeLast();
						stmt.setString(c, "%" + daytime + "%");
					} else {
					}
				}
			} // プレースホルダーセット終了

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Mail mail = new Mail(rs.getInt("mail_id"), rs.getString("receiver"), rs.getString("sender"),
						rs.getString("daytime"), rs.getString("subject"), rs.getString("message"));
				mailList.add(mail);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			SQL_SELECT = "SELECT user_id, user_name, telephone FROM user_info";
		}
		return mailList;
	}

}// クラスの終了
