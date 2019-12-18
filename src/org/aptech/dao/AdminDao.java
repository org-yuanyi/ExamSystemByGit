package org.aptech.dao;

import java.sql.Connection;
import java.util.List;

import org.aptech.pojo.Admin;

/**
 * @Date 2019-12-18
 * @author yiming
 * @description 
 */
public interface AdminDao {
	/**
	 * 添加管理员的方法
	 * @param 连接对象
	 * @param 管理员
	 * @return 受影响的行数
	 */
	public int addAdmin(Connection con,Admin a);
	/**
	 * 修改管理员的方法
	 * @param 连接对象
	 * @param 管理员
	 * @return 受影响的行数
	 */
	public int updAdmin(Connection con,Admin a);
	/**
	 * 删除管理员的方法
	 * @param 连接对象
	 * @param 管理员
	 * @return 受影响的行数
	 */
	public int delAdmin(Connection con,int aId);
	/**
	 * 获得管理员集合的方法
	 * @return 管理员集合
	 */
	public List<Admin> getAdmin();
}
