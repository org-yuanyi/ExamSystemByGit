package org.aptech.pojo;

import lombok.*;

/*
    @Data ：getter、setter、toString、EqualsAndHashCode 的集合
    @Setter : Target : 1.type  用于类上。为每个字段都提供 setter 方法
                       2.field 用于字段上，为当前字段提供 setter 方法
    @Getter ：同 Setter
    @toString ：为当前类提供 toString 方法
    @EqualsAndHashCode ： 提供 equals 和 hashCode 方法
    @AllArgsConstructor : 全参构造器
    @NoArgsConstructor : 午餐构造器
    @RequiredArgsConstructor : 会生成一个包含常量，和标识了NotNull的变量 的构造方法。生成的构造方法是private，
                               如何想要对外提供使用可以使用staticName选项生成一个static方法
 */
@Data
public class QuestionInfo {
    private Integer qId;                // 试题id
    private String qInfo;                // 试题名称
    private String qType;                // 试题类型
    private String qAnswer;            // 正确答案
    private String lessonChapter;        // 所属章节名称
    private String lessonBlog;            // 所属知识点
    private int lessonId;                // 所属课程id
    private String qJoinTime;            // 添加时间
    private String optionA;            // 选项A
    private String optionB;                //选项B
    private String optionC;                //选项C
    private String optionD;            //选项D
    private int taoTiId;                //所属套题
    private String qAnalytic;            //答案解析
}
