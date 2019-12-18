package org.aptech.pojo;

import lombok.Data;

/**
 * @Date 2019-12-18
 * @author yiming
 * @description
 */
@Data
public class TaoTi {
	private Integer taoTiId; // 套题id',
	private String taoTiName; // 套题名称',
	private String joinTime; // 添加时间',
	private Integer lessonId; // 所属课程id'
}
