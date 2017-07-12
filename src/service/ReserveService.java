package service;

import java.sql.Connection;
import java.util.Collections;
import java.util.List;

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

	public void reserveRenew(Reserve reserve) {
		try (Connection con = DbUtil.getConnection()) {
			ReserveDao reserveDao = new ReserveDao(con);
			reserveDao.reserveUpdate(reserve);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void reserveErase(int reDel) {
		try (Connection con = DbUtil.getConnection()) {
			ReserveDao reserveDao = new ReserveDao(con);
			reserveDao.reserveDelete(reDel);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public List<Reserve> findAll() {
		try (Connection conn = DbUtil.getConnection()) {
			ReserveDao reserveDao = new ReserveDao(conn);
			return reserveDao.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Collections.emptyList();
	}

	public List<Reserve> findById(String id) {
		try (Connection conn = DbUtil.getConnection()) {
			ReserveDao reserveDao = new ReserveDao(conn);
			return reserveDao.selectById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Collections.emptyList();
	}

	public Reserve findByReserve(int id) {
		try (Connection conn = DbUtil.getConnection()) {
			ReserveDao reserveDao = new ReserveDao(conn);
			return reserveDao.selectByReserve(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public Reserve findByDateRoomTerm(String date, String room, int term){
		try (Connection conn = DbUtil.getConnection()) {
			ReserveDao reserveDao = new ReserveDao(conn);
			return reserveDao.selectDateRoomTerm(date,room,term);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
