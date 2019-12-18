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
		return this.exceUpdate(con, sqlString, q.getQInfo(),q.getQType(),q.getQAnswer(),q.getLessonChapter(),q.getLessonBlog(),q.getLessonId(),q.getQJoinTime(),q.getOptionA(),q.getOptionB(),q.getOptionC(),q.getOptionD(),q.getTaoTiId(),q.getQAnalytic());
	}

	@Override
	public int updQuestion(Connection con, QuestionInfo q) {
		String sqlString = "update questionInfo set qinfo=?,qtype=?,qanswer=?,lessonChapter=?,lessonblog=?,lessonId=?,qjoinTime=?,optionA=?,optionB=?,optionC=?,optionD=?,Taotiid=?,qjiexi=? where qid=?";
		return this.exceUpdate(con, sqlString, q.getQInfo(),q.getQType(),q.getQAnswer(),q.getLessonChapter(),q.getLessonBlog(),q.getLessonId(),q.getQJoinTime(),q.getOptionA(),q.getOptionB(),q.getOptionC(),q.getOptionD(),q.getTaoTiId(),q.getQAnalytic(),q.getQId());
	}

	@Override
	public int delQuestion(Connection con, int qId) {
		String sqlString = "delete from questionInfo where qid=?";
		return this.exceUpdate(con, sqlString, qId);
	}

	@Override
	public List<QuestionInfo> getQuestionInfo() {
		List<QuestionInfo> qList = new ArrayList<QuestionInfo>();
		String sqlString  = "select * from questionInfo";
		Connection con = DataUtil.getCon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sqlString);
			rs = ps.executeQuery();
			while(rs.next()){
				QuestionInfo q = new QuestionInfo();
				q.setLessonBlog(rs.getString("lessonblog"));
				q.setLessonChapter(rs.getString("lessonChapter"));
				q.setLessonId(rs.getInt("lessonId"));
				q.setTaoTiId(rs.getInt("Taotiid"));
				q.setQJoinTime(rs.getString("joinTime"));
				q.setOptionD(rs.getString("optionD"));
				q.setOptionA(rs.getString("optionA"));
				q.setOptionB(rs.getString("optionB"));
				q.setOptionC(rs.getString("optionC"));
				q.setQAnswer(rs.getString("qanswer"));
				q.setQAnalytic(rs.getString("qjiexi"));
				q.setQInfo(rs.getString("qinfo"));
				q.setQType(rs.getString("qtype"));
				q.setQId(rs.getInt("qid"));
				qList.add(q);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return qList;
	}

	@Override
	public List<QuestionInfo> getQuestionInfosBySomething(QuestionInfo qq) {
		List<QuestionInfo> qList = new ArrayList<QuestionInfo>();
		String sql = "SELECT * FROM  (questionInfo q INNER JOIN lesson l ON q.lessonId = l.lessonId ) LEFT JOIN Taoti tt ON q.Taotiid = tt.Taotiid where lessonChapter like ? and lessonblog like ? ";
		if(qq.getTaoTiId() > 0){
			sql += " and Taotiid=?";
		}
		if(qq.getLessonId() > 0){
			sql += " and lessonId=?";
		}
		Connection con = DataUtil.getCon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, qq.getLessonChapter());
			ps.setString(2, qq.getLessonBlog());
			if(qq.getTaoTiId() > 0){
				ps.setInt(3, qq.getTaoTiId());
			}
			if(qq.getLessonId() > 0){
				ps.setInt(4, qq.getLessonId());
			}
			rs = ps.executeQuery();
			while(rs.next()){
				QuestionInfo q = new QuestionInfo();
				q.setLessonBlog(rs.getString("lessonblog"));
				q.setLessonChapter(rs.getString("lessonChapter"));
				q.setLessonId(rs.getInt("lessonId"));
				q.setTaoTiId(rs.getInt("Taotiid"));
				q.setQJoinTime(rs.getString("joinTime"));
				q.setOptionD(rs.getString("optionD"));
				q.setOptionA(rs.getString("optionA"));
				q.setOptionB(rs.getString("optionB"));
				q.setOptionC(rs.getString("optionC"));
				q.setQAnswer(rs.getString("qanswer"));
				q.setQAnalytic(rs.getString("qjiexi"));
				q.setQInfo(rs.getString("qinfo"));
				q.setQType(rs.getString("qtype"));
				q.setQId(rs.getInt("qid"));
				qList.add(q);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return qList;
	}

	@Override
	public List<QuestionInfo> getQuestionInfosBySomeAndPage(QuestionInfo qq,int start, int pageSize) {
		List<QuestionInfo> qList = new ArrayList<QuestionInfo>();
		String sql = "SELECT * FROM  (questionInfo q INNER JOIN lesson l ON q.lessonId = l.lessonId ) LEFT JOIN Taoti tt ON q.Taotiid = tt.Taotiid where lessonChapter like ? and lessonblog like ? ";
		if(qq.getTaoTiId() > 0){
			sql += " and Taotiid=?";
		}
		if(qq.getLessonId() > 0){
			sql += " and lessonId=?";
		}
		sql += " order by qid desc limit ?,?";
		Connection con = DataUtil.getCon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, qq.getLessonChapter());
			ps.setString(2, qq.getLessonBlog());
			if(qq.getTaoTiId() > 0){
				ps.setInt(3, qq.getTaoTiId());
			}
			if(qq.getLessonId() > 0){
				ps.setInt(4, qq.getLessonId());
			}
			rs = ps.executeQuery();
			while(rs.next()){
				QuestionInfo q = new QuestionInfo();
				q.setLessonBlog(rs.getString("lessonblog"));
				q.setLessonChapter(rs.getString("lessonChapter"));
				q.setLessonId(rs.getInt("lessonId"));
				q.setTaoTiId(rs.getInt("Taotiid"));
				q.setQJoinTime(rs.getString("joinTime"));
				q.setOptionD(rs.getString("optionD"));
				q.setOptionA(rs.getString("optionA"));
				q.setOptionB(rs.getString("optionB"));
				q.setOptionC(rs.getString("optionC"));
				q.setQAnswer(rs.getString("qanswer"));
				q.setQAnalytic(rs.getString("qjiexi"));
				q.setQInfo(rs.getString("qinfo"));
				q.setQType(rs.getString("qtype"));
				q.setQId(rs.getInt("qid"));
				qList.add(q);
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
		if(q.getTaoTiId() > 0){
			sql += " and Taotiid=?";
		}
		if(q.getLessonId() > 0){
			sql += " and lessonId=?";
		}
		Connection con = DataUtil.getCon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, q.getLessonChapter());
			ps.setString(2, q.getLessonBlog());
			if(q.getTaoTiId() > 0){
				ps.setInt(3, q.getTaoTiId());
			}
			if(q.getLessonId() > 0){
				ps.setInt(4, q.getLessonId());
			}
			rs = ps.executeQuery();
			while(rs.next()){
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

}
