package org.aptech.pojo;

import lombok.Data;

/**
 * @Date 2019-12-18
 * @author yiming
 * @description 
 */
@Data
public class Admin {
	private Integer aId;			//  管理员id',
	private Integer type; 			//  管理员种类 1,超管, 0子管理员',
	private String aName; 			//  管理员账号',
	private String aPwd; 			//  管理员密码'
}
