package org.aptech.dao;

import java.sql.Connection;
import java.util.List;

import org.aptech.pojo.Teacher;

/**
 * @Date 2019-12-17
 * @author yiming
 * @desceiption ��ʦ��Ľӿ�
 */
public interface TeacherDao {
	/**
	 * ������ʦ�ķ���
	 * @param ���Ӷ���
	 * @param ��ʦ����
	 * @return ��Ӱ�������
	 */
	public int addTeacher(Connection con,Teacher t);
	/**
	 * ɾ����ʦ�ķ���
	 * @param ���Ӷ���
	 * @param ��ʦ����
	 * @return ��Ӱ�������
	 */
	public int delTeacher(Connection con, int tId);
	/**
	 * ���������ʦ����ļ���
	 * @return ��ʦ����ļ���
	 */
	public List<Teacher> getTeachers();
	/**
	 * �޸���ʦ�ķ���
	 * @param ���Ӷ���
	 * @param ��ʦ����
	 * @return ��Ӱ�������
	 */
	public int updTeacher(Connection con,Teacher t);
	
}
