package service;

import java.sql.Connection;

import dao.RoomsDao;
import util.DbUtil;

public class RoomsService {
	public int roomInfoInsertWithoutPath(String room,Integer size,String facility,String remarks){

		try (Connection con = DbUtil.getConnection()) {
			RoomsDao roomsDao = new RoomsDao(con);
			roomsDao.roomsInsertWithoutPath(room,size,facility,remarks);
			int room_id = roomsDao.selectNewRoomsId();
			return room_id;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

	public int updateNewRoomsPath(int room_id,String name){
		try (Connection con = DbUtil.getConnection()) {
			RoomsDao roomsDao = new RoomsDao(con);
			return roomsDao.updateNewRoomsPath(room_id, name);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}


}
