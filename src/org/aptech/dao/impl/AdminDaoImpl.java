package org.aptech.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.aptech.dao.AdminDao;
import org.aptech.dao.BaseDao;
import org.aptech.pojo.Admin;
import org.aptech.utils.DataUtil;


public class AdminDaoImpl extends BaseDao implements AdminDao{

	@Override
	public int addAdmin(Connection con, Admin a) {
		String sql = "INSERT INTO adminInfo(`type`,aname,apwd)VALUES(?,?,?)";
		return this.exceUpdate(con, sql, a.getType(),a.getAName(),a.getAPwd());
	}

	@Override
	public int updAdmin(Connection con, Admin a) {
		String sqlString  = "update adminInfo set `type`=?,aname=?,apwd=? where aid=?";
		return this.exceUpdate(con, sqlString , a.getType(),a.getAName(),a.getAPwd(),a.getAId());
	}

	@Override
	public int delAdmin(Connection con, int aId) {
		String sqlString = "delete from adminInfo where aid=?";
		return this.exceUpdate(con, sqlString, aId);
	}

	@Override
	public List<Admin> getAdmin() {
		List<Admin> aList = new ArrayList<Admin>();
		Connection con = DataUtil.getCon();
		String sqlString = "select * from adminInfo";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sqlString);
			rs = ps.executeQuery();
			while(rs.next()){
				Admin a = new Admin();
				a.setAId(rs.getInt("aid"));
				a.setType(rs.getInt("type"));
				a.setAName(rs.getString("aname"));
				a.setAPwd(rs.getString("apwd"));
				aList.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return aList;
	}

}
