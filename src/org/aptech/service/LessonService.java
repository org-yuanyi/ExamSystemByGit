package org.aptech.service;

import java.sql.Connection;
import java.util.List;

import org.aptech.pojo.Lesson;

public interface LessonService {
	/**
	 * ��ӿγ̵ķ���
	 * @param con ���Ӷ���
	 * @param l �γ̶���
	 * @return ��Ӱ�������
	 */
	public int addLessonDao(Connection con,Lesson l);
	/**
	 * ɾ���γ̵ķ���
	 * @param lessonId �γ�Id
	 * @param con ���Ӷ���
	 * @return ��Ӱ�������
	 */
	public int delLessonDao(Connection con,int lessonId);
	/**
	 * �޸Ŀγ̵ķ���
	 * @param con ���Ӷ���
	 * @param l �γ̶���
	 * @return ��Ӱ�������
	 */
	public int updLessonDao(Connection con,Lesson l);
	/**
	 * ��ѯ�γ̵ķ���
	 * @return �γ̶���ļ���
	 */
	public List<Lesson> getLessons();

}
