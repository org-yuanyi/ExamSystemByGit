<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>测试</title>
	
  <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
  <script type="text/javascript">
  		$(function(){
  			function selTaoti(){
  			
  			}
  		});
  </script>
  </head>
  
  <body>
    	<div>
    		<table>
    			<thead>
    			<tr>
		    		<td colspan="10">
		    			<form id="form1" action="">
		    				<input name="op" type="hidden" value="sel">
		    				课程名称：<select name="lessonId"></select>&nbsp;&nbsp;&nbsp;
		    				套题名称：<select name="TaotiId"></select>&nbsp;&nbsp;&nbsp;
		    				所属章节：<input name="lessonChapter"/>&nbsp;&nbsp;&nbsp;
		    				所属知识点：<input  name="lessonblog" />&nbsp;&nbsp;&nbsp;
		    				<input type="button" id="btnSel" value="查询" />
		    			</form>
		    		</td>
		    	</tr>
		    	<tr>
		    		<td>套题编号</td>
		    		<td>课程名称</td>
		    		<td>课程ID</td>
		    		<td>套题名称</td>
		    	</tr>
    		</thead>
	    	
	    	<tbody><!-- 数据，分页标签 --></tbody>
	    	<tfoot>
	    		<tr>
		    		<th colspan="10" align="right">
		    			<a href="QuestionServlet?op=add">添加试题</a>
		    		</th>
		    	</tr>
	    	</tfoot>
    	</table>
    	</div>
  </body>
</html>
