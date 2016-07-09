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
<form method="post" action="">
	<c:forEach var="bh" items="${requestScope.secs}">
			<table class="table">
				<thead>
					<tr>
					<th>
						choose
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
					
						<!-- 	<th>
							operation
						</th>
						<th>
							operation
						</th>		 -->
					</tr>
				</thead>
				<tbody>
		
			
			
					<tr>
					<td>
							 <input name="select" type="checkbox" id="checkbox1" value="${bh.sectionFullSectionNo}"/>
						</td>
							<td>
							${bh.sectionFullSectionNo}
						</td>
							
						
					<td>
							${bh.sectionNo}
						</td>
						
						<td>
							${bh.dayOfWeek}
						</td>
							<td>
							${bh.timeOfDay}
						</td>
						
						<td>
							${bh.room}
						</td> 
						<td>
							${bh.seatingCapacity}
						</td>
						
						<td>
							${bh.representedCourse}
						</td> 
				
					<tr class="error">
						<td>
							
						</td>
						<td>
							
						</td>
						<td>
							
						</td>
						<td>
							
						</td>
						<td>
							
						</td>
						<td>
							
						</td>
						<td>
							
						</td>
					</tr>
					<tr class="warning">
						<td>
						
						</td>
						<td>
							
						</td>
						<td>
						
						</td>
						<td>
						
						</td>
						<td>
							
						</td>
						<td>
							
						</td>
						<td>
							
						</td>
					</tr>
					<tr class="info">
						<td>
							
						</td>
						<td>
							
						</td>
						<td>
							
						</td>
						<td>
							
						</td>
						<td>
							
						</td>
						<td>
							
						</td>
						<td>
							
						</td>
					</tr>
				</tbody>
			</table>
			</c:forEach>
		</form>	
</body>
</html>