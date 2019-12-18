package org.aptech.dao;

import java.sql.Connection;
import java.util.List;

import org.aptech.pojo.QuestionInfo;




/**
 * @Date 2019-12-18
 * @author yiming
 * @description
 */
public interface QuestionDao {
	/**
	 * 增加试题的方法
	 * @param 连接数据库
	 * @param 试题对象
	 * @return 受影响的行数
	 */
	public int addQuestion(Connection con,QuestionInfo q);
	/**
	 * 修改试题的方法
	 * @param 连接数据库
	 * @param 试题对象
	 * @return 受影响的行数
	 */
	public int updQuestion(Connection con,QuestionInfo q);
	/**
	 * 删除试题的方法
	 * @param 连接数据库
	 * @param 试题对象
	 * @return 受影响的行数
	 */
	public int delQuestion(Connection con,int qId);
	/**
	 * 得到试题集合的方法
	 * @return 试题集合
	 */
	public List<QuestionInfo> getQuestionInfo();
	/**
	 * 模糊查询试题的方法
	 * @param 试题对象
	 * @return 试题对象的集合
	 */
	public List<QuestionInfo> getQuestionInfosBySomething(QuestionInfo q);
	
	/**
	 * 模糊查询和分页查询试题
	 * @param 试题对象 
	 * @param start 分页查询起始行
	 * @param pageSize 分页查询每页显示的行数
	 * @return 试题对象的集合
	 */
	public List<QuestionInfo> getQuestionInfosBySomeAndPage(QuestionInfo q, int start, int pageSize);
	
	/**
	 * 模糊查询到的总记录数的方法，方便分页查询 
	 * @param q 试题对象
	 * @return 模糊查询到的总记录数
	 */
	public int getCountByLike(QuestionInfo q);
}
