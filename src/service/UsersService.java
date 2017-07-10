package service;

import java.sql.Connection;

import dao.UsersDao;
import util.DbUtil;

public class UsersService {

	public String idByName(String id) {
		try (Connection con = DbUtil.getConnection()) {
			UsersDao UsersDao = new UsersDao(con);
			return UsersDao.idByName(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
