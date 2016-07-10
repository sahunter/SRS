<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2> <a href="studentindex.jsp">SRS</a></h2>
<div class="row-fluid">
		<div class="span4">
		
		<form  action="../searchPrerequisiteServlet" method="post">
		<h3>presentcourse</h3>
				<input type="text" name="course">
					  	<input type="submit" name="searchprerequisite" value="searchprerequisite"/>	 	
			          
				</fieldset>
			</form>
		</div>
		<div class="span4">
		</div>
		<div class="span4">
		</div>
	</div>
	
</body>
</html>