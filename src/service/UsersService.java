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
}
