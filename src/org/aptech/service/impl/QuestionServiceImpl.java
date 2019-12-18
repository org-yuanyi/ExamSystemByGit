package org.aptech.service.impl;

import org.aptech.dao.QuestionDao;
import org.aptech.dao.impl.QuestionDaoImpl;
import org.aptech.pojo.QuestionInfo;
import org.aptech.service.QuesthionService;
import org.aptech.utils.PageUtil;

import java.sql.Connection;
import java.util.List;

public class QuestionServiceImpl implements QuesthionService {

    private QuestionDao qd = new QuestionDaoImpl();

    @Override
    public int addQuestion(Connection con, QuestionInfo q) {

        return qd.addQuestion(con, q);
    }

    @Override
    public int updQuestion(Connection con, QuestionInfo q) {
        return qd.updQuestion(con, q);
    }

    @Override
    public int delQuestion(Connection con, int qId) {
        return qd.delQuestion(con, qId);
    }

    @Override
    public List<QuestionInfo> getQuestionInfo() {
        return qd.getQuestionInfo();
    }

    @Override
    public List<QuestionInfo> getQuestionInfosBySomething(QuestionInfo q) {
        QuestionInfo questionInfo = new QuestionInfo();
        questionInfo.setLessonBlog("%" + questionInfo.getLessonBlog() + "%");
        questionInfo.setLessonChapter("%" + questionInfo.getLessonChapter() + "%");
        questionInfo.setTaoTiId(questionInfo.getTaoTiId());
        questionInfo.setLessonId(questionInfo.getLessonId());
        return qd.getQuestionInfosBySomething(questionInfo);
    }

    @Override
    public PageUtil<QuestionInfo> getQuestionInfosBySomeAndPage(QuestionInfo q,int pageNo, int pageSize) {
    	PageUtil<QuestionInfo> qPageUtil = new PageUtil<QuestionInfo>();
    	QuestionInfo questionInfo = new QuestionInfo();
        questionInfo.setLessonBlog("%" + questionInfo.getLessonBlog() + "%");
        questionInfo.setLessonChapter("%" + questionInfo.getLessonChapter() + "%");
        questionInfo.setTaoTiId(questionInfo.getTaoTiId());
        questionInfo.setLessonId(questionInfo.getLessonId());
        int start = (pageNo - 1) * pageSize;
        List<QuestionInfo> qList = qd.getQuestionInfosBySomeAndPage(questionInfo, start, pageSize);
        int count = qd.getCountByLike(questionInfo);
        qPageUtil.setPageNo(pageNo);
        qPageUtil.setPageSize(pageSize);
        qPageUtil.setTotalCount(count);
        qPageUtil.setPageList(qList);
        return qPageUtil;
    }

}
