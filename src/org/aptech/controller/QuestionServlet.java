package org.aptech.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aptech.pojo.Lesson;
import org.aptech.pojo.QuestionInfo;
import org.aptech.pojo.TaoTi;
import org.aptech.service.LessonService;
import org.aptech.service.QuesthionService;
import org.aptech.service.TaoTiService;
import org.aptech.service.impl.LessonServiceImpl;
import org.aptech.service.impl.QuestionServiceImpl;
import org.aptech.service.impl.TaoTiServiceImpl;
import org.aptech.utils.PageUtil;

import com.alibaba.fastjson.JSON;

public class QuestionServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String op = request.getParameter("op");
		System.out.println(op);
		if ("add".equals(op)) {

		}else if("selLesson".equals(op)){
			selLesson(request,out);
		} else if("sel".equals(op)) {
			seeAllQuestion(request, out);
		} else if("selTaoti".equals(op)){
			selTaoti(request,out);
		}
	}
	
	private void selTaoti(HttpServletRequest request, PrintWriter out) 
			throws ServletException, IOException {
			List<TaoTi> tList = ts.getTaoTis();
			String pageJson = JSON.toJSONString(tList, true);
			System.out.println(pageJson);
			out.print(pageJson);
			out.flush();
			out.close();
		
	}

	private void seeAllQuestion(HttpServletRequest request, PrintWriter out) 
			throws ServletException, IOException {
			QuestionInfo q = new QuestionInfo();
			q.setLessonBlog(request.getParameter("lessonBlog"));
			q.setLessonChapter(request.getParameter("lessonChapter"));
			q.setTaoTiId(Integer.valueOf(request.getParameter("TaotiId")));
			q.setLessonId(Integer.valueOf(request.getParameter("lessonId")));
			String pageNoStr = request.getParameter("pageNo");
			String pageSizeStr = request.getParameter("pageSize");
			Integer pageNo = 1;
			Integer pageSize = 5;
			if(pageNoStr != null){
				pageNo = Integer.valueOf(pageNoStr);
			}
			if(pageSizeStr != null){
				pageSize = Integer.valueOf(pageSizeStr);
			}
			PageUtil<QuestionInfo> qPage = qs.getQuestionInfosBySomeAndPage(q, pageNo, pageSize);
			System.out.println(qPage.getPageList());
			String pageJson = JSON.toJSONString(qPage,true);
			System.out.println(pageJson);
			out.print(pageJson);
			out.flush();
			out.close();
	}

	private void selLesson(HttpServletRequest request, PrintWriter out) 
			throws ServletException, IOException {
			List<Lesson> lList = ls.getLessons();
			String pageJson = JSON.toJSONString(lList, true);
			System.out.println(pageJson);
			out.print(pageJson);
			out.flush();
			out.close();
		
	}

	QuesthionService qs = new QuestionServiceImpl();
	LessonService ls = new LessonServiceImpl();
	TaoTiService ts = new TaoTiServiceImpl();

}
