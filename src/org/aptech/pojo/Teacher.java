package org.aptech.pojo;

import lombok.Data;

/**
 * 
 * @author yiming
 *@date 2019-12-17
 *@description 
 */
@Data
public class Teacher {
	private Integer tId; 		// 教师ID 
	private Integer cId; 		// 班级ID
	private String tName; 		// 老师姓名
	private String tUname; 		// 老师账号
	private String tPwd; 		// 密码
	private String tPhone; 		// 电话号码
	private Integer tLevel; 	//教师等级:2高级，1普通
	
	

	
	
}


