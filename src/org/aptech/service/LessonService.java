package org.aptech.service;

import java.sql.Connection;
import java.util.List;

import org.aptech.pojo.Lesson;

public interface LessonService {
	/**
	 * 添加课程的方法
	 * @param con 连接对象
	 * @param l 课程对象
	 * @return 受影响的行数
	 */
	public int addLessonDao(Connection con,Lesson l);
	/**
	 * 删除课程的方法
	 * @param lessonId 课程Id
	 * @param con 连接对象
	 * @return 受影响的行数
	 */
	public int delLessonDao(Connection con,int lessonId);
	/**
	 * 修改课程的方法
	 * @param con 连接对象
	 * @param l 课程对象
	 * @return 受影响的行数
	 */
	public int updLessonDao(Connection con,Lesson l);
	/**
	 * 查询课程的方法
	 * @return 课程对象的集合
	 */
	public List<Lesson> getLessons();

}
