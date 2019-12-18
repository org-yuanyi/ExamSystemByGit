package org.aptech.service;

import java.sql.Connection;
import java.util.List;

import org.aptech.pojo.QuestionInfo;
import org.aptech.utils.PageUtil;

/**
 * @Date 2019-12-18
 * @author yiming
 * @description
 */
public interface QuesthionService {
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
	public PageUtil<QuestionInfo> getQuestionInfosBySomeAndPage(QuestionInfo q, int start, int pageSize);
}
