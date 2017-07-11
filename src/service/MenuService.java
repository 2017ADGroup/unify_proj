package service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dao.ReserveDao;
import entity.Reserve;
import util.DbUtil;

public class MenuService {
	public String scheduleCreate(String login_id,String reserve_date){
		String schedule = "";
		List<Reserve> reserveList = new ArrayList<Reserve>();
		try (Connection con = DbUtil.getConnection()) {
			ReserveDao reserveDao = new ReserveDao(con);
			reserveList = reserveDao.selectReserveLoginIdDay(login_id, reserve_date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<String> flag = new ArrayList<String>();//重複フラグ用配列
		int listSize = 0;
		if(reserveList == null){
		}else{
			listSize = reserveList.size();
		}

		for(int i = 0;i < listSize ;i++){

			if(Arrays.asList(flag).contains(reserveList.get(i).getRoom())){//教室の重複を防ぐための処理)
			}else{
				schedule = schedule + "<tr>";//行を開く
				for(int j= 0;j < 7;j++){
					//教室ごと、タームごとの時間割に該当の予定が存在するかを検索。該当の部分に〇を入れる

					try (Connection con = DbUtil.getConnection()) {
						ReserveDao reserveDao = new ReserveDao(con);
						List<Reserve> reserveTerm = reserveDao.selectReserveLoginIdRoomDayTerm(login_id,reserve_date,j);
						if(reserveTerm.size() == 0){
							schedule = schedule + "<td></td>";
						}else{
							schedule = schedule + "<td>〇</td>";//
						}
					} catch (Exception e) {
						e.printStackTrace();
						return "";
					}
				}
				schedule = schedule + "</tr>";//行を閉じる
				flag.add(reserveList.get(i).getRoom());//重複フラグ用配列の構築
			}
		}
		return schedule;
	}
}
