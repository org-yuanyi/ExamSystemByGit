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
	 * ��������ķ���
	 * @param �������ݿ�
	 * @param �������
	 * @return ��Ӱ�������
	 */
	public int addQuestion(Connection con,QuestionInfo q);
	/**
	 * �޸�����ķ���
	 * @param �������ݿ�
	 * @param �������
	 * @return ��Ӱ�������
	 */
	public int updQuestion(Connection con,QuestionInfo q);
	/**
	 * ɾ������ķ���
	 * @param �������ݿ�
	 * @param �������
	 * @return ��Ӱ�������
	 */
	public int delQuestion(Connection con,int qId);
	/**
	 * �õ����⼯�ϵķ���
	 * @return ���⼯��
	 */
	public List<QuestionInfo> getQuestionInfo();
	/**
	 * ģ����ѯ����ķ���
	 * @param �������
	 * @return �������ļ���
	 */
	public List<QuestionInfo> getQuestionInfosBySomething(QuestionInfo q);
	
	/**
	 * ģ����ѯ�ͷ�ҳ��ѯ����
	 * @param ������� 
	 * @param start ��ҳ��ѯ��ʼ��
	 * @param pageSize ��ҳ��ѯÿҳ��ʾ������
	 * @return �������ļ���
	 */
	public List<QuestionInfo> getQuestionInfosBySomeAndPage(QuestionInfo q, int start, int pageSize);
	
	/**
	 * ģ����ѯ�����ܼ�¼���ķ����������ҳ��ѯ 
	 * @param q �������
	 * @return ģ����ѯ�����ܼ�¼��
	 */
	public int getCountByLike(QuestionInfo q);
}
