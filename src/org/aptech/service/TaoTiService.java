package org.aptech.service;

import java.sql.Connection;
import java.util.List;

import org.aptech.pojo.TaoTi;

public interface TaoTiService {
	/**
	 * 添加套題的方法
	 * @param con 连接对象
	 * @param tt 套题对象	
	 * @return 受影响的行数
	 */
	public int addTaoTi(Connection con,TaoTi tt);
	/**
	 * 删除套题的方法
	 * @param con 连接对象
	 * @param taoTiId 套题ID	
	 * @return 受影响的行数
	 */
	public int delTaoTi(Connection con,int taoTiId);
	/**
	 * 修改套题的方法
	 * @param con 连接对象
	 * @param tt 套题对象	
	 * @return 受影响的行数
	 */
	public int updTaoTi(Connection con,TaoTi tt);
	/**
	 * 查询套题对象的方法
	 * @return 套题对象的集合
	 */
	public List<TaoTi> getTaoTis();
}
