package service;

import java.sql.Connection;
import java.util.List;

import dao.MailDao;
import dao.UsersDao;
import entity.Mail;
import util.DbUtil;

public class MailService {

	public List<Mail> mailFind() {
		try (Connection con = DbUtil.getConnection()) {
			MailDao mailDao = new MailDao(con);
			return mailDao.mailFindAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Mail> mailFindAll() {
		try (Connection con = DbUtil.getConnection()) {
			MailDao mailDao = new MailDao(con);
			return mailDao.mailFindAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Mail mailFindByMailId(int mail_id) {
		try (Connection con = DbUtil.getConnection()) {
			MailDao mailDao = new MailDao(con);
			return mailDao.mailFindByMailId(mail_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void mailInsert(String to, String login_user, String time, String subject, String message) {
		try (Connection con = DbUtil.getConnection()) {
			MailDao mailDao = new MailDao(con);
			mailDao.mailInsert(to, login_user, time, subject, message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void mailUpdate(int id, String to, String from, String time, String subject, String message) {
		try (Connection con = DbUtil.getConnection()) {
			MailDao mailDao = new MailDao(con);
			mailDao.mailupdate(id, to, from, time, subject, message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Mail mailDelete(int id) {
		try (Connection con = DbUtil.getConnection()) {
			MailDao mailDao = new MailDao(con);
			mailDao.maildelete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Mail> mailFindByLoginId(String login_id) {
		try (Connection con = DbUtil.getConnection()) {
			MailDao mailDao = new MailDao(con);
			return mailDao.mailFindByLoginId(login_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// キーワード、日付のみ
	public List<Mail> mailFindBy(String keyword, String daytime) {
		try (Connection con = DbUtil.getConnection()) {
			MailDao mailDao = new MailDao(con);
			return mailDao.SelectWhereIdFromTo("", keyword, daytime);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 名前、キーワード、日付、From
	public List<Mail> mailFindByNameFrom(String name, String keyword, String daytime) {
		try (Connection con = DbUtil.getConnection()) {
			UsersDao usersDao = new UsersDao(con);// 先に名前からidの中身を検索
			List<String> nameList = usersDao.idsByName(name);
			String names[] = new String[nameList.size()];
			for (int i = 0; i < nameList.size(); i++) {
				names[i] = nameList.get(i);
			}
			MailDao mailDao = new MailDao(con);
			return mailDao.SelectWhereNameFrom(names, keyword, daytime);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 名前、キーワード、日付、To
	public List<Mail> mailFindByNameTo(String name, String keyword, String daytime) {
		try (Connection con = DbUtil.getConnection()) {
			UsersDao usersDao = new UsersDao(con);// 先に名前からidの中身を検索
			List<String> nameList = usersDao.idsByName(name);
			String names[] = new String[nameList.size()];
			for (int i = 0; i < nameList.size(); i++) {
				names[i] = nameList.get(i);
			}
			MailDao mailDao = new MailDao(con);
			return mailDao.SelectWhereNameTo(names, keyword, daytime);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// ID,キーワード、日付、両方
	public List<Mail> mailFindByName(String name, String keyword, String daytime) {
		try (Connection con = DbUtil.getConnection()) {
			UsersDao usersDao = new UsersDao(con);// 先に名前からidの中身を検索
			List<String> nameList = usersDao.idsByName(name);
			String names[] = new String[nameList.size()];
			for (int i = 0; i < nameList.size(); i++) {
				names[i] = nameList.get(i);
			}
			MailDao mailDao = new MailDao(con);
			return mailDao.SelectWhereNameFromTo(names, keyword, daytime);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// ID、キーワード、日付、From
	public List<Mail> mailFindByIdFrom(String id, String keyword, String daytime) {
		try (Connection con = DbUtil.getConnection()) {
			MailDao mailDao = new MailDao(con);
			return mailDao.SelectWhereIdFrom(id, keyword, daytime);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// ID、キーワード、日付、To
	public List<Mail> mailFindByIdTo(String id, String keyword, String daytime) {
		try (Connection con = DbUtil.getConnection()) {
			MailDao mailDao = new MailDao(con);
			return mailDao.SelectWhereIdTo(id, keyword, daytime);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Mail> mailFindById(String id, String keyword, String daytime) {
		try (Connection con = DbUtil.getConnection()) {
			MailDao mailDao = new MailDao(con);
			return mailDao.SelectWhereIdFromTo(id, keyword, daytime);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
