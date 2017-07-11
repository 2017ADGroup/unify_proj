package service;

import java.sql.Connection;
import java.util.List;

import dao.MailDao;
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

	public void mailInsert(String to,String from,String time,String subject,String message) {
		try (Connection con = DbUtil.getConnection()) {
			MailDao mailDao = new MailDao(con);
			mailDao.mailInsert(to, from, time, subject, message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void mailUpdate(int id,String to,String from,String time,String subject,String message) {
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
}
