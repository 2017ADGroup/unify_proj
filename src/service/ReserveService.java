package service;

import java.sql.Connection;

import dao.ReserveDao;
import entity.Reserve;
import util.DbUtil;

public class ReserveService {

	public void reserveRegister(Reserve reserve) {
		try (Connection con = DbUtil.getConnection()) {
			ReserveDao reserveDao = new ReserveDao(con);
			reserveDao.reserveInsert(reserve);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
