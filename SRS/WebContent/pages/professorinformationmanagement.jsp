<%@ page  import="util.*,java.util.*,model.*,daoImplsqlite.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>professor information management</h1>
<%-- <% HttpServletRequest req = (HttpServletRequest) request; 
  ArrayList<Professor>  professor=req.getAttribute("professors");%> --%>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<form  name="form4"  method="post">
			<input name="add1" type="button"  id="add1"  class="Common"   onclick="form4.action='../addProfessorServlet';form4.submit()"  value="add"/>		
			<input  name="update1" type="button"  id="update1"  class="Common"   onclick="form4.action='../updateProfessorServlet';form4.submit()"  value="update"/>
			<input  name="delete1" type="button"  id="delete1"  class="Common"   onclick="form4.action='../deleteProfessorServlet';form4.submit()"  value="delete"/>											
			<table class="table">
				<thead>
					<tr>
							
						<th>
							type
						</th>
						<th>
							ssn
						</th>
						<th>
							name
						</th>
						<th>
							title
						</th>
						<th>
							department
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>		
												<td> <input type="text"  name="add"></td>
												<td> <input type="text"  name="add"></td>
												<td><input type="text"  name="add"></td>
										     	<td> <input type="text"  name="add"></td>
												<td><input type="text"  name="add"> </td>
					</tr>
				</table>
			
			</form>
				
		
		</div>
	</div>
</div>

		
		
		
</body>
</html>