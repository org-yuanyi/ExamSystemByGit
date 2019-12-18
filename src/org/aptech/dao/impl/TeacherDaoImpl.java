package org.aptech.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.aptech.dao.BaseDao;
import org.aptech.dao.TeacherDao;
import org.aptech.pojo.Teacher;
import org.aptech.utils.DataUtil;


/**
 * @Date 2019-12-18
 * @author yiming
 * @description
 */
public class TeacherDaoImpl extends BaseDao implements TeacherDao {

	@Override
	public int addTeacher(Connection con, Teacher t) {
		String sql = "INSERT INTO teacherInfo(cid,tname,tuname,tpwd,tphone,tlevel)VALUES(?,?,?,?,?,?)";
		return this.exceUpdate(con, sql, t.getCId(),t.getTName(),t.getTUname(),t.getTPwd(),t.getTPhone(),t.getTLevel());
	}

	@Override
	public int delTeacher(Connection con, int tId) {
		String sql = "delete from teacherInfo where tid=?";
		return this.exceUpdate(con, sql, tId);
	}

	@Override
	public List<Teacher> getTeachers() {
		List<Teacher> tList = new ArrayList<Teacher>();
		String sql = "select * from teacherInfo";
		Connection con = DataUtil.getCon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Teacher t = new Teacher();
				t.setCId(rs.getInt("cid"));
				t.setTId(rs.getInt("tid"));
				t.setTLevel(rs.getInt("tlevel"));
				t.setTPhone(rs.getString("tphone"));
				t.setTPwd(rs.getString("tpwd"));
				t.setTName(rs.getString("tname"));
				t.setTUname(rs.getString("tuname"));
				tList.add(t);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tList;
	}

	@Override
	public int updTeacher(Connection con, Teacher t) {
		String sql = "update teacherInfo set cid=?,tname=?,tuname=?,tpwd=?,tlevel=? where tid=?";
		return this.exceUpdate(con, sql, t.getCId(),t.getTName(),t.getTUname(),t.getTPwd(),t.getTLevel(),t.getTId());
	}

}
