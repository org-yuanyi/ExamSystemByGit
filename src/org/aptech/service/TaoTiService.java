package org.aptech.service;

import java.sql.Connection;
import java.util.List;

import org.aptech.pojo.TaoTi;

public interface TaoTiService {
	/**
	 * ������}�ķ���
	 * @param con ���Ӷ���
	 * @param tt �������	
	 * @return ��Ӱ�������
	 */
	public int addTaoTi(Connection con,TaoTi tt);
	/**
	 * ɾ������ķ���
	 * @param con ���Ӷ���
	 * @param taoTiId ����ID	
	 * @return ��Ӱ�������
	 */
	public int delTaoTi(Connection con,int taoTiId);
	/**
	 * �޸�����ķ���
	 * @param con ���Ӷ���
	 * @param tt �������	
	 * @return ��Ӱ�������
	 */
	public int updTaoTi(Connection con,TaoTi tt);
	/**
	 * ��ѯ�������ķ���
	 * @return �������ļ���
	 */
	public List<TaoTi> getTaoTis();
}
