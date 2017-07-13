package service;

import java.sql.Connection;
import java.util.Collections;
import java.util.List;

import dao.RoomsDao;
import entity.Rooms;
import util.DbUtil;

public class RoomsService {
	public int roomInfoInsertWithoutPath(String room, Integer size, String facility, String remarks) {

		try (Connection con = DbUtil.getConnection()) {
			RoomsDao roomsDao = new RoomsDao(con);
			roomsDao.roomsInsertWithoutPath(room, size, facility, remarks);
			int room_id = roomsDao.selectNewRoomsId();
			return room_id;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

	public int updateNewRoomsPath(int room_id, String name) {
		try (Connection con = DbUtil.getConnection()) {
			RoomsDao roomsDao = new RoomsDao(con);
			return roomsDao.updateNewRoomsPath(room_id, name);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public Rooms find(int id) {
		try (Connection conn = DbUtil.getConnection()) {
			RoomsDao roomsDao = new RoomsDao(conn);
			return roomsDao.select(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public String findFix(String room) {
		try (Connection conn = DbUtil.getConnection()) {
			RoomsDao roomsDao = new RoomsDao(conn);
			return roomsDao.selectFix(room);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<Rooms> findAll() {
		try (Connection conn = DbUtil.getConnection()) {
			RoomsDao roomsDao = new RoomsDao(conn);
			return roomsDao.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Collections.emptyList();
	}

	public void renew(Rooms rooms) {
		try (Connection con = DbUtil.getConnection()) {
			RoomsDao roomsDao = new RoomsDao(con);
			roomsDao.update(rooms);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void erase(int reDel) {
		try (Connection con = DbUtil.getConnection()) {
			RoomsDao roomsDao = new RoomsDao(con);
			roomsDao.delete(reDel);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Rooms> serchRooms(String room,int min,int max,String facility){
		try (Connection con = DbUtil.getConnection()) {
			RoomsDao roomsDao = new RoomsDao(con);
			return roomsDao.selectRooms(room,min,max,facility);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}