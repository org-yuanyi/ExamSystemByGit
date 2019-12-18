package org.aptech.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.aptech.dao.BaseDao;
import org.aptech.dao.TaoTiDao;
import org.aptech.pojo.TaoTi;
import org.aptech.utils.DataUtil;

public class TaoTiDaoImpl extends BaseDao implements TaoTiDao {

	@Override
	public int addTaoTi(Connection con, TaoTi tt) {
		String sqlString = "INSERT INTO Taoti(TaotiName,joinTime,lessonId)VALUES(?,?,?)";
		return this.exceUpdate(con, sqlString, tt.getTaoTiName(),tt.getJoinTime(),tt.getLessonId());
	}

	@Override
	public int delTaoTi(Connection con, int taoTiId) {
		String sql = "delete from Taoti where Taotiid=?";
		return this.exceUpdate(con, sql, taoTiId);
	}

	@Override
	public int updTaoTi(Connection con, TaoTi tt) {
		String sqlString = "update Taoti set TaotiName=?,joinTime=?,lessonId=? where Taotiid=? ";
		return this.exceUpdate(con, sqlString, tt.getTaoTiName(),tt.getJoinTime(),tt.getLessonId(),tt.getTaoTiId());
	}

	@Override
	public List<TaoTi> getTaoTis() {
		List<TaoTi> tList = new ArrayList<TaoTi>();
		Connection connection = DataUtil.getCon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sqlString = "SELECT * FROM Taoti";
		try {
			ps = connection.prepareStatement(sqlString);
			rs = ps.executeQuery();
			while(rs.next()){
				TaoTi t = new TaoTi();
				t.setJoinTime(rs.getString("joinTime"));
				t.setLessonId(rs.getInt("lessonId"));
				t.setTaoTiId(rs.getInt("Taotiid"));
				t.setTaoTiName(rs.getString("TaotiName"));
				tList.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tList;
	}

}
