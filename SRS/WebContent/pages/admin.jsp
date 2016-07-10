<%@ page import="util.*,java.util.*,model.*,daoImplsqlite.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Section</title>
</head>
<body>
<h1>SRS</h1>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<form  name="form5" method="post">	
			<input name="searchCourseServlet" type="button"  id="searchCourseServlet"  class="Common"   onclick="form5.action='../searchCourseServlet';form5.submit()"  value="searchCourse"/>
			<input  name="searchProfessorServlet" type="button"  id="searchProfessorServlet"  class="Common"   onclick="form5.action='../searchProfessorServlet';form5.submit()"  value="searchProfessor"/>
            <input  name="searchPrerequisiteServlet" type="button"  id="searchPrerequisiteServlet"  class="Common"   onclick="form5.action='../searchPrerequisiteServlet';form5.submit()"  value="searchPrerequisite"/>
            <input  name="searchSectionServlet" type="button"  id="searchSectionServlet"  class="Common"   onclick="form5.action='../searchSectionServlet';form5.submit()"  value="searchSection"/>
			 </form>		 
			 
		</div>
	</div>
</div>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<ul class="nav nav-tabs">
				<li class="active">
					  <a href="professorinformationmanagement.jsp">教师信息管理</a>
				</li>
				<li>
					 <a href="courseinformationmanagement.jsp">课程信息管理</a>
				</li>
				<li class="disabled">
					<a href="prerequisiteinformationmanagement.jsp">先修课信息管理</a>
				</li>
				<li class="disabled">
					<a href="sectioninformationmanagement.jsp">选课信息管理</a>
				</li>
			</ul>
			
		</div>
	</div>
</div>
</body>
</html>