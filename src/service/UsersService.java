package service;

import java.sql.Connection;

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

<<<<<<< HEAD
	// ID検索
		public Users find(String id) {
			try (Connection conn = DbUtil.getConnection()) {
				UsersDao usersDao = new UsersDao(conn);
				return usersDao.find(id);
			} catch (Exception e) {
				e.printStackTrace();
			}

			return null;
		}

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
=======
	public static Users authentication(String login_id, String pass) {
		try (Connection con = DbUtil.getConnection()) {
			UsersDao UsersDao = new UsersDao(con);
			Users users = UsersDao.findByIDAndPassword(login_id, pass);
			return users;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

>>>>>>> 96ec3b36b4f0ceecde826f779bebf6ccb23e6433
}

