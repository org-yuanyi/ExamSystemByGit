package org.aptech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.aptech.utils.DataUtil;

public class BaseDao {
	public int exceUpdate(Connection con,String sql,Object...objects){
		int rows = 0;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			for(int i = 0;i < objects.length;i++){
				ps.setObject(i + 1, objects[i]);
			}
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DataUtil.closeCon(null, ps, null);
		}
		return rows;
	}
}
