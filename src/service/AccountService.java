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
		//更新したID取得
		public int regId() {
			try (Connection conn = DbUtil.getConnection()) {
				AccountDao accountDao = new AccountDao(conn);
				return accountDao.maxId();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return 0;
		}
		//一括登録
		public void insert(Users users) {
			// TODO 自動生成されたメソッド・スタブ
			try (Connection con = DbUtil.getConnection()) {
				AccountDao accountDao = new AccountDao(con);
				accountDao.accountInsert(users);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
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

}
