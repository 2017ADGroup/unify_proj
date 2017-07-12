package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dao.AccountDao;
import entity.Users;
import util.DbUtil;

public class AccountService {

	/*
	public void account(Users account) {
		try (Connection conn = DbUtil.getConnection()) {
			AccountDao accountDao = new AccountDao(conn);
			accountDao.accountInsert(account);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
*/

	// 全件取得
		public static List<Users> findAll() {
			List<Users> list = new ArrayList<Users>();
			try (Connection conn = DbUtil.getConnection()) {
				AccountDao accountDao = new AccountDao(conn);
				list = accountDao.findAll();

				return list;

			} catch (SQLException e) {
				e.printStackTrace();
			}

			return Collections.emptyList();
		}


	// ID検索
		public String find(String id) {
			try (Connection conn = DbUtil.getConnection()) {
				AccountDao accountDao = new AccountDao(conn);
				return accountDao.find(id);
			} catch (Exception e) {
				e.printStackTrace();

			return null;
			}

		}

		public int regId() {
			try (Connection conn = DbUtil.getConnection()) {
				AccountDao accountDao = new AccountDao(conn);
				return accountDao.maxId();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return 0;
		}

		public void insert(Users users) {
			// TODO 自動生成されたメソッド・スタブ
			try (Connection con = DbUtil.getConnection()) {
				AccountDao accountDao = new AccountDao(con);
				accountDao.accountInsert(users);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
<<<<<<< HEAD
		//更新
		public int update(Users users) {
			try (Connection conn = DbUtil.getConnection()) {
				AccountDao accountDao = new AccountDao(conn);
				accountDao.Update(users);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return 0;
		}
=======
>>>>>>> 0c77fae2e766e719aad0caa27b250ef34f888aac

}
