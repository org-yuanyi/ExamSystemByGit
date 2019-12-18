package org.aptech.pojo;

import lombok.Data;


/**
 * @author yiming
 * @Date 2019-12-17
 * @description
 */
@Data
public class ClassInfo {
    private int cId;  // 班级ID',
    private String cType; //班级类型 A,J,Q班',
    private String cName; //班级名称'
}
