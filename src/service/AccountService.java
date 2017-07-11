package service;

import java.sql.Connection;

import dao.AccountDao;
import entity.Users;
import util.DbUtil;

public class AccountService {

	public void account(Users account) {
		try (Connection conn = DbUtil.getConnection()) {
			AccountDao accountDao = new AccountDao(conn);
			accountDao.accountInsert(account);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ID検索
		@SuppressWarnings("static-access")
		public Users find(String id) {
			try (Connection conn = DbUtil.getConnection()) {
				AccountDao accountDao = new AccountDao(conn);
				return accountDao.find(id);
			} catch (Exception e) {
				e.printStackTrace();

			return null;
		}

		}
}
