package org.aptech.pojo;

import lombok.*;

/*
    @Data ��getter��setter��toString��EqualsAndHashCode �ļ���
    @Setter : Target : 1.type  �������ϡ�Ϊÿ���ֶζ��ṩ setter ����
                       2.field �����ֶ��ϣ�Ϊ��ǰ�ֶ��ṩ setter ����
    @Getter ��ͬ Setter
    @toString ��Ϊ��ǰ���ṩ toString ����
    @EqualsAndHashCode �� �ṩ equals �� hashCode ����
    @AllArgsConstructor : ȫ�ι�����
    @NoArgsConstructor : ��͹�����
    @RequiredArgsConstructor : ������һ�������������ͱ�ʶ��NotNull�ı��� �Ĺ��췽�������ɵĹ��췽����private��
                               �����Ҫ�����ṩʹ�ÿ���ʹ��staticNameѡ������һ��static����
 */
@Data
public class QuestionInfo {
    private Integer qId;                // ����id
    private String qInfo;                // ��������
    private String qType;                // ��������
    private String qAnswer;            // ��ȷ��
    private String lessonChapter;        // �����½�����
    private String lessonBlog;            // ����֪ʶ��
    private int lessonId;                // �����γ�id
    private String qJoinTime;            // ���ʱ��
    private String optionA;            // ѡ��A
    private String optionB;                //ѡ��B
    private String optionC;                //ѡ��C
    private String optionD;            //ѡ��D
    private int taoTiId;                //��������
    private String qAnalytic;            //�𰸽���
}
