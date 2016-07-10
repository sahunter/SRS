<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2> <a href="admin.jsp">SRS</a></h2>
<h3>transcript information management</h3>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
	        <form  name="form3"  method="post">
			<input name="add1" type="button"  id="add1"  class="Common"  onclick="form3.action='../addCourseServlet';form3.submit()"  value="add"/>		
			<input  name="update1" type="button"  id="update1"  class="Common"   onclick="form3.action='../updateCourseServlet';form3.submit()"  value="update"/>
			<input  name="delete1" type="button"  id="delete1"  class="Common"   onclick="form3.action='../deleteCourseServlet';form3.submit()"  value="delete"/>											
			<table class="table">
				<thead>
					<tr>							
						<th>
							FullSectionNo
						</th>
						<th>
							sectionNo
						</th>
						<th>
							dayOfWeek
						</th>
						<th>
							timeOfDay
						</th>
						<th>
							room
						</th>
						<th>
							seatingCapacity
						</th>
							<th>
							representedCourse
						</th>
						
					</tr>
				</thead>
				<tbody>
					<tr>		
												<td> <input type="text"  name="add3"></td>
												<td> <input type="text"  name="add3"></td>
												<td><input type="text"  name="add3"></td>
										     	<td> <input type="text"  name="add3"></td>
												<td> <input type="text"  name="add3"></td>
												<td><input type="text"  name="add3"></td>
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