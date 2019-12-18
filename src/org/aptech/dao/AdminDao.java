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
	 * ��ӹ���Ա�ķ���
	 * @param ���Ӷ���
	 * @param ����Ա
	 * @return ��Ӱ�������
	 */
	public int addAdmin(Connection con,Admin a);
	/**
	 * �޸Ĺ���Ա�ķ���
	 * @param ���Ӷ���
	 * @param ����Ա
	 * @return ��Ӱ�������
	 */
	public int updAdmin(Connection con,Admin a);
	/**
	 * ɾ������Ա�ķ���
	 * @param ���Ӷ���
	 * @param ����Ա
	 * @return ��Ӱ�������
	 */
	public int delAdmin(Connection con,int aId);
	/**
	 * ��ù���Ա���ϵķ���
	 * @return ����Ա����
	 */
	public List<Admin> getAdmin();
}
