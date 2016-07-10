<%@ page import="util.*,java.util.*,model.*,daoImplsqlite.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2> <a href="admin.jsp">SRS</a></h2>
<h3>professor information</h3>
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
				<c:forEach var="bh" items="${requestScope.professors}">
						<%-- <%
			 	for (int i = 0; i < req.getAttribute("professors").size(); i++) { 
			 		Professor bh = professors.get(i);%> --%>
			 		
				<tr>
				<td>professor</td>
						<td>
						${bh.ssn}
						</td>
						<td>
						${bh.name}
						</td>
						<td>
						${bh.title}
						</td>
						<td>
						${bh.department}
						</td>
					</tr>
					<%-- <% }%> --%>
					</c:forEach> 
				
					
		
				</tbody>
			</table>
			
</body>
</html>