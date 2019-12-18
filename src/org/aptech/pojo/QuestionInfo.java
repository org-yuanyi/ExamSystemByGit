package org.aptech.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
// �ṩger��set��tostring��EqualsAndHashCode
@Data @ToString @Getter @Setter @EqualsAndHashCode @AllArgsConstructor @RequiredArgsConstructor
public class QuestionInfo {
	private Integer qId;				// ����id
	private String qInfo; 				// ��������
	private String qType; 				// ��������
	private String qAnswer; 			// ��ȷ��
	private String lessonChapter; 		// �����½�����
	private String lessonBlog; 			// ����֪ʶ��
	private int lessonId; 				// �����γ�id
	private String qJoinTime; 			// ���ʱ��
	private String optionA; 			// ѡ��A
	private String optionB;				//ѡ��B
	private String optionC;				//ѡ��C
	private String optionD; 			//ѡ��D
	private int taoTiId; 				//��������
	private String qAnalytic; 			//�𰸽���	
	
	
}
