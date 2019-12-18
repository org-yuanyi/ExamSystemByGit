package org.aptech.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
// 提供ger、set、tostring、EqualsAndHashCode
@Data @ToString @Getter @Setter @EqualsAndHashCode @AllArgsConstructor @RequiredArgsConstructor
public class QuestionInfo {
	private Integer qId;				// 试题id
	private String qInfo; 				// 试题名称
	private String qType; 				// 试题类型
	private String qAnswer; 			// 正确答案
	private String lessonChapter; 		// 所属章节名称
	private String lessonBlog; 			// 所属知识点
	private int lessonId; 				// 所属课程id
	private String qJoinTime; 			// 添加时间
	private String optionA; 			// 选项A
	private String optionB;				//选项B
	private String optionC;				//选项C
	private String optionD; 			//选项D
	private int taoTiId; 				//所属套题
	private String qAnalytic; 			//答案解析	
	
	
}
