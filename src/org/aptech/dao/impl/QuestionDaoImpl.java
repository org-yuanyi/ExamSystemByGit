package org.aptech.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.aptech.dao.BaseDao;
import org.aptech.dao.QuestionDao;
import org.aptech.pojo.QuestionInfo;
import org.aptech.utils.DataUtil;

public class QuestionDaoImpl extends BaseDao implements QuestionDao {

	@Override
	public int addQuestion(Connection con, QuestionInfo q) {
		String sqlString = "INSERT INTO questionInfo(qinfo,qtype,qanswer,lessonChapter,lessonblog,lessonId,qjoinTime,optionA,optionB,optionC,optionD,Taotiid,qjiexi)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		return this.exceUpdate(con, sqlString, q.getQInfo(), q.getQType(),
				q.getQAnswer(), q.getLessonChapter(), q.getLessonBlog(),
				q.getLessonId(), q.getQJoinTime(), q.getOptionA(),
				q.getOptionB(), q.getOptionC(), q.getOptionD(), q.getTaoTiId(),
				q.getQAnalytic());
	}

	@Override
	public int updQuestion(Connection con, QuestionInfo q) {
		String sqlString = "update questionInfo set qinfo=?,qtype=?,qanswer=?,lessonChapter=?,lessonblog=?,lessonId=?,qjoinTime=?,optionA=?,optionB=?,optionC=?,optionD=?,Taotiid=?,qjiexi=? where qid=?";
		return this.exceUpdate(con, sqlString, q.getQInfo(), q.getQType(),
				q.getQAnswer(), q.getLessonChapter(), q.getLessonBlog(),
				q.getLessonId(), q.getQJoinTime(), q.getOptionA(),
				q.getOptionB(), q.getOptionC(), q.getOptionD(), q.getTaoTiId(),
				q.getQAnalytic(), q.getQId());
	}

	@Override
	public int delQuestion(Connection con, int qId) {
		String sqlString = "delete from questionInfo where qid=?";
		return this.exceUpdate(con, sqlString, qId);
	}

	@Override
	public List<QuestionInfo> getQuestionInfo() {
		List<QuestionInfo> qList = new ArrayList<QuestionInfo>();
		String sqlString = "select * from questionInfo";
		Connection con = DataUtil.getCon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sqlString);
			rs = ps.executeQuery();
			while (rs.next()) {
				QuestionInfo q = new QuestionInfo();
				q.setLessonBlog(rs.getString("lessonblog"));
				q.setLessonChapter(rs.getString("lessonChapter"));
				q.setLessonId(rs.getInt("lessonId"));
				q.setTaoTiId(rs.getInt("Taotiid"));
				q.setQJoinTime(rs.getString("qjoinTime"));
				q.setOptionD(rs.getString("optionD"));
				q.setOptionA(rs.getString("optionA"));
				q.setOptionB(rs.getString("optionB"));
				q.setOptionC(rs.getString("optionC"));
				q.setQAnswer(rs.getString("qanswer"));
				q.setQAnalytic(rs.getString("qjiexi"));
				q.setQInfo(rs.getString("qinfo"));
				q.setQType(rs.getString("qtype"));
				q.setQId(rs.getInt("qid"));
				q.setTaotiName(rs.getString("TaotiName"));
				q.setLessonName(rs.getString("lessonName"));
				qList.add(q);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return qList;
	}

	@Override
	public List<QuestionInfo> getQuestionInfosBySomething(QuestionInfo q) {
		List<QuestionInfo> qList = new ArrayList<QuestionInfo>();
		String sql = "SELECT * FROM  (questionInfo q INNER JOIN lesson l ON q.lessonId = l.lessonId ) LEFT JOIN Taoti tt ON q.Taotiid = tt.Taotiid where lessonChapter like ? and lessonblog like ? ";
		if (q.getTaoTiId() > 0) {
			sql += " and Taotiid=?";
		}
		if (q.getLessonId() > 0) {
			sql += " and lessonId=?";
		}
		Connection con = DataUtil.getCon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, q.getLessonChapter());
			ps.setString(2, q.getLessonBlog());
			if (q.getTaoTiId() > 0) {
				ps.setInt(3, q.getTaoTiId());
			}
			if (q.getLessonId() > 0) {
				ps.setInt(4, q.getLessonId());
			}
			rs = ps.executeQuery();
			while (rs.next()) {
				QuestionInfo questionInfo = new QuestionInfo();
				questionInfo.setLessonBlog(rs.getString("lessonblog"));
				questionInfo.setLessonChapter(rs.getString("lessonChapter"));
				questionInfo.setLessonId(rs.getInt("lessonId"));
				questionInfo.setTaoTiId(rs.getInt("Taotiid"));
				questionInfo.setQJoinTime(rs.getString("joinTime"));
				questionInfo.setOptionD(rs.getString("optionD"));
				questionInfo.setOptionA(rs.getString("optionA"));
				questionInfo.setOptionB(rs.getString("optionB"));
				questionInfo.setOptionC(rs.getString("optionC"));
				questionInfo.setQAnswer(rs.getString("qanswer"));
				questionInfo.setQAnalytic(rs.getString("qjiexi"));
				questionInfo.setQInfo(rs.getString("qinfo"));
				questionInfo.setQType(rs.getString("qtype"));
				questionInfo.setQId(rs.getInt("qid"));
				questionInfo.setTaotiName(rs.getString("TaotiName"));
				questionInfo.setLessonName(rs.getString("lessonName"));
				qList.add(questionInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return qList;
	}

	@Override
	public List<QuestionInfo> getQuestionInfosBySomeAndPage(QuestionInfo q,
			int start, int pageSize) {
		List<QuestionInfo> qList = new ArrayList<QuestionInfo>();
		Connection con = DataUtil.getCon();
		// 根据所属课程和所属知识点查询
		String sql = "SELECT * FROM  (questionInfo q INNER JOIN lesson l ON q.lessonId = l.lessonId ) LEFT JOIN Taoti tt ON q.Taotiid = tt.Taotiid where lessonChapter like ? and lessonblog like ? ";
		if (q.getTaoTiId() > 0) { // 判断是否根据套题ID查询后加分页
			sql += " and Taotiid=?";
		}
		if (q.getLessonId() > 0) {
			sql += " and lessonId=?";
		}
		sql += " order by qid desc limit ?,?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, q.getLessonChapter());
			ps.setString(2, q.getLessonBlog());
			if (q.getTaoTiId() > 0) {
				ps.setInt(3, q.getTaoTiId());
				ps.setInt(4, start);
				ps.setInt(5, pageSize);
			} else if (q.getLessonId() > 0) { // 判断是否根据课程ID查询后加分页
				ps.setInt(4, q.getLessonId());
				ps.setInt(5, start);
				ps.setInt(6, pageSize);
			} else if (q.getLessonId() > 0 && q.getTaoTiId() > 0) { // 都有的情况
				ps.setInt(3, q.getLessonId());
				ps.setInt(4, q.getTaoTiId());
				ps.setInt(5, start);
				ps.setInt(6, pageSize);
			} else { // 都没有的情况下加分页
				ps.setInt(3, start);
				ps.setInt(4, pageSize);
			}
			rs = ps.executeQuery();
			while (rs.next()) {
				QuestionInfo qq = new QuestionInfo();
				qq.setLessonBlog(rs.getString("lessonblog"));
				qq.setLessonChapter(rs.getString("lessonChapter"));
				qq.setLessonId(rs.getInt("lessonId"));
				qq.setTaoTiId(rs.getInt("Taotiid"));
				qq.setQJoinTime(rs.getString("joinTime"));
				qq.setOptionD(rs.getString("optionD"));
				qq.setOptionA(rs.getString("optionA"));
				qq.setOptionB(rs.getString("optionB"));
				qq.setOptionC(rs.getString("optionC"));
				qq.setQAnswer(rs.getString("qanswer"));
				qq.setQAnalytic(rs.getString("qjiexi"));
				qq.setQInfo(rs.getString("qinfo"));
				qq.setQType(rs.getString("qtype"));
				qq.setQId(rs.getInt("qid"));
				qq.setTaotiName(rs.getString("TaotiName"));
				qq.setLessonName(rs.getString("lessonName"));
				qList.add(qq);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return qList;
	}

	@Override
	public int getCountByLike(QuestionInfo q) {
		int count = 0;
		String sql = "SELECT count(1) FROM  (questionInfo q INNER JOIN lesson l ON q.lessonId = l.lessonId ) LEFT JOIN Taoti tt ON q.Taotiid = tt.Taotiid where lessonChapter like ? and lessonblog like ? ";
		if (q.getTaoTiId() > 0) {
			sql += " and Taotiid=?";
		}
		if (q.getLessonId() > 0) {
			sql += " and lessonId=?";
		}
		Connection con = DataUtil.getCon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, q.getLessonChapter());
			ps.setString(2, q.getLessonBlog());
			if (q.getTaoTiId() > 0) {
				ps.setInt(3, q.getTaoTiId());
			}
			if (q.getLessonId() > 0) {
				ps.setInt(4, q.getLessonId());
			}
			rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

}
