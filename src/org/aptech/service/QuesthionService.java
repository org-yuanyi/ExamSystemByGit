package org.aptech.service;

import org.aptech.pojo.QuestionInfo;
import org.aptech.utils.PageUtil;

import java.sql.Connection;
import java.util.List;

/**
 * @author yiming
 * @Date 2019-12-18
 * @description
 */
public interface QuesthionService {
    /**
     * 增加试题的方法
     *
     * @param 连接数据库
     * @param 试题对象
     * @return 受影响的行数
     */
    public int addQuestion(Connection con, QuestionInfo q);

    /**
     * 修改试题的方法
     *
     * @param 连接数据库
     * @param 试题对象
     * @return 受影响的行数
     */
    public int updQuestion(Connection con, QuestionInfo q);

    /**
     * 删除试题的方法
     *
     * @param 连接数据库
     * @param 试题对象
     * @return 受影响的行数
     */
    public int delQuestion(Connection con, int qId);

    /**
     * 得到试题集合的方法
     *
     * @return 试题集合
     */
    public List<QuestionInfo> getQuestionInfo();

    /**
     * 模糊查询试题的方法
     *
     * @param 试题对象
     * @return 试题对象的集合
     */
    public List<QuestionInfo> getQuestionInfosBySomething(QuestionInfo q);

    /**
     * 模糊查询和分页查询试题
     *
     * @param 试题对象
     * @param pageNo 起始页
     * @param pageSize 分页查询每页显示的行数
     * @return 试题对象的集合
     */
    public PageUtil<QuestionInfo> getQuestionInfosBySomeAndPage(QuestionInfo q, int pageNo, int pageSize);
}
