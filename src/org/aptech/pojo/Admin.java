package org.aptech.pojo;

import lombok.Data;

/**
 * @Date 2019-12-18
 * @author yiming
 * @description 
 */
@Data
public class Admin {
	private Integer aId;			//  ����Աid',
	private Integer type; 			//  ����Ա���� 1,����, 0�ӹ���Ա',
	private String aName; 			//  ����Ա�˺�',
	private String aPwd; 			//  ����Ա����'
}
