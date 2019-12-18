package org.aptech.dao;

import java.sql.Connection;
import java.util.List;

import org.aptech.pojo.Teacher;

/**
 * @Date 2019-12-17
 * @author yiming
 * @desceiption 老师类的接口
 */
public interface TeacherDao {
	/**
	 * 增加老师的方法
	 * @param 连接对象
	 * @param 老师对象
	 * @return 受影响的行数
	 */
	public int addTeacher(Connection con,Teacher t);
	/**
	 * 删除老师的方法
	 * @param 连接对象
	 * @param 老师对象
	 * @return 受影响的行数
	 */
	public int delTeacher(Connection con, int tId);
	/**
	 * 获得所有老师对象的集合
	 * @return 老师对象的集合
	 */
	public List<Teacher> getTeachers();
	/**
	 * 修改老师的方法
	 * @param 连接对象
	 * @param 老师对象
	 * @return 受影响的行数
	 */
	public int updTeacher(Connection con,Teacher t);
	
}
