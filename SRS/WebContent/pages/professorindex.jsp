<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>SRS</h1>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<form  name="form5" method="post">	
			<input name="searchSectionServlet" type="button"  id="searchSectionServlet"  class="Common"   onclick="form5.action='../searchProfessorSectionServlet';form5.submit()"  value="searchSection"/>
			<input  name="searchTranscriptServlet" type="button"  id=searchTranscriptServlet"  class="Common"   onclick="form5.action='../searchTranscriptByProfessorServlet';form5.submit()"  value="searchTranscript"/>
            <input  name="searchProfessorServlet" type="button"  id="searchProfessorServlet"  class="Common"   onclick="form5.action='../searchProfessorServlet';form5.submit()"  value="searchProfessorinformation"/>
			 </form>		 
			 
		</div>
	</div>
</div>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<ul class="nav nav-tabs">
				<li class="active">
					  <a href="Transcriptinformationmanagement.jsp">postGrade</a>
				</li>
				
			</ul>
			
		</div>
	</div>
</div>
</body>
</html>