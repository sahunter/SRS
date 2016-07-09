<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
	<form  name="form2"  method="post">
			<input name="add1" type="button"  id="add1"  class="Common"  onclick="form2.action='../addCourseServlet';form2.submit()"  value="add"/>		
			<input  name="update1" type="button"  id="update1"  class="Common"   onclick="form2.action='../updateCourseServlet';form2.submit()"  value="update"/>
			<input  name="delete1" type="button"  id="delete1"  class="Common"   onclick="form2.action='../deleteCourseServlet';form2.submit()"  value="delete"/>											
			<table class="table">
				<thead>
					<tr>							
						<th>
							courseNo
						</th>
						<th>
							courseName
						</th>
						<th>
							credits
						</th>
						
					</tr>
				</thead>
				<tbody>
					<tr>		
												<td> <input type="text"  name="add3"></td>
												<td> <input type="text"  name="add3"></td>
												<td><input type="text"  name="add3"></td>
										     	
					</tr>
					</tbody>
				</table>
			</form>
	
		</div>
	</div>
</div>
		
</body>
</html>