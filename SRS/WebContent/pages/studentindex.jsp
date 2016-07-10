<%@ page import="util.*,java.util.*,model.*,daoImplsqlite.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<input name="searchAllSectionServlet" type="button"  id="searchAllSectionServlet"  class="Common"   onclick="form5.action='../searchAllSectionServlet';form5.submit()"  value="searchAllSection"/>
			<input name="searchSlectedSectionServlet" type="button"  id="searchSlectedSectionnServlet"  class="Common"   onclick="form5.action='../searchEnrollCourse';form5.submit()"  value="searchSlectedSection"/>
			<input  name="searchTranscriptServlet" type="button"  id="searchTranscriptServlet"  class="Common"   onclick="form5.action='../searchTranscriptServlet';form5.submit()"  value="searchTranscript"/>
            <input  name="searchStudentInformation" type="button"  id="searchStudentInformation"  class="Common"   onclick="form5.action='../searchStudentInformationServlet';form5.submit()"  value="searchStudentInformation"/>
			 </form>		 
			 
		</div>
	</div>
</div>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<ul class="nav nav-tabs">
			
				<li>
					 <a href="scheduleofclasses.jsp">课程选课</a>
				</li>
				<li>
					 <a href="searchprerequisite.jsp">查询先修课</a>
				</li>
			</ul>
		</div>
	</div>
</div>
</body>
</html>