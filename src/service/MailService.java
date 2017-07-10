package service;

import com.sun.corba.se.pept.transport.Connection;

import dao.MailDao;
import entity.Mail;
import util.DbUtil;

public class MailService {

	public Mail mailSelecto() {
		try (Connection con = DbUtil.getConnection()) {
			MailDao mailDao = new MailDao(con);
			Mail mail = mailDao.mailSelect();
			return mail;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
