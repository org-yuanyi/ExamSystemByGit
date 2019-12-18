package org.aptech.service.impl;

import java.sql.Connection;
import java.util.List;

import org.aptech.dao.LessonDao;
import org.aptech.dao.impl.LessonDaoImpl;
import org.aptech.pojo.Lesson;
import org.aptech.service.LessonService;

public class LessonServiceImpl implements LessonService {

	private LessonDao ld = new LessonDaoImpl();
	
	@Override
	public int addLessonDao(Connection con, Lesson l) {
		// TODO Auto-generated method stub
		return ld.addLessonDao(con, l);
	}

	@Override
	public int delLessonDao(Connection con, int lessonId) {
		// TODO Auto-generated method stub
		return ld.delLessonDao(con, lessonId);
	}

	@Override
	public int updLessonDao(Connection con, Lesson l) {
		// TODO Auto-generated method stub
		return ld.updLessonDao(con, l);
	}

	@Override
	public List<Lesson> getLessons() {
		// TODO Auto-generated method stub
		return ld.getLessons();
	}

}
