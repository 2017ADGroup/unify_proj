package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dao.UsersDao;
import entity.Users;
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


	// 全件取得
		public List<Users> findAll() {
			List<Users> list = new ArrayList<Users>();
			try (Connection conn = DbUtil.getConnection()) {
				UsersDao usersDao = new UsersDao(conn);
				list = usersDao.findAll();

				return list;

			} catch (SQLException e) {
				e.printStackTrace();
			}

			return Collections.emptyList();
		}

	// ID検索
		/*public Users find(String id) {
			try (Connection conn = DbUtil.getConnection()) {
				UsersDao usersDao = new UsersDao(conn);
				return usersDao.find(id);
			} catch (Exception e) {
				e.printStackTrace();
			}

			return null;
		}*/

	//登録
	public int insert(Users users){
		try (Connection conn = DbUtil.getConnection()){
			UsersDao usersDao = new UsersDao(conn);
			return usersDao.update(users);
		}catch (Exception e){
			e.printStackTrace();
		}
		return 0;
	}

	// ログイン
	public  Users authentication(String login_id, String pass) {
		try (Connection con = DbUtil.getConnection()) {
			UsersDao UsersDao = new UsersDao(con);
			Users users = UsersDao.findByIDAndPassword(login_id, pass);
			return users;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 更新
	public int update(Users user) {
		try (Connection conn = DbUtil.getConnection()) {
			UsersDao usersDao = new UsersDao(conn);
			return usersDao.update(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	//一括削除
	public void delete(int login_id) {
		try (Connection con = DbUtil.getConnection()) {
			UsersDao usersDao = new UsersDao(con);
			usersDao.delete(login_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

