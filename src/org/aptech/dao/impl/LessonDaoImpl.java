package org.aptech.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.aptech.dao.BaseDao;
import org.aptech.dao.LessonDao;
import org.aptech.pojo.Lesson;
import org.aptech.utils.DataUtil;

public class LessonDaoImpl extends BaseDao implements LessonDao{

	@Override
	public int addLessonDao(Connection con, Lesson l) {
		String sqlString = "INSERT INTO lesson(lessonName,joinTime)VALUES(?,?)";
		return this.exceUpdate(con, sqlString, l.getLessonName(),l.getJoinTime());
	}

	@Override
	public int delLessonDao(Connection con, int lessonId) {
		String sqlString = "delete from lesson where lessonId=?";
		return this.exceUpdate(con, sqlString, lessonId);
	}

	@Override
	public int updLessonDao(Connection con, Lesson l) {
		String sqlString  = "update lesson set lessonName=?,joinTime=? where lessonId=?";
		return this.exceUpdate(con, sqlString, l.getLessonName(),l.getJoinTime(),l.getLessonId());
	}

	@Override
	public List<Lesson> getLessons() {
		List<Lesson> lList = new ArrayList<Lesson>();
		Connection connection = DataUtil.getCon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sqlString = "SELECT * FROM lesson";
		try {
			ps = connection.prepareStatement(sqlString);
			rs = ps.executeQuery();
			while(rs.next()){
				Lesson l = new Lesson();
				l.setJoinTime(rs.getString("joinTime"));
				l.setLessonId(rs.getInt("lessonId"));
				l.setLessonName(rs.getString("lessonName"));
				lList.add(l);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lList;
	}

}
