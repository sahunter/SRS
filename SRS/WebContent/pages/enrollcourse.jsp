
<%@ page  import="util.*,java.util.*,model.*,daoImplsqlite.*"  language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>Insert title here</title>
<!-- Bootstrap Core CSS -->
<link href="bower_components/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
	<link
	href="bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.css"
	rel="stylesheet">
	<link href="bower_components/bootstrap.min.js"
	rel="stylesheet">
	
</head>


<body>

<%									//?????????????
     HttpServletRequest req = (HttpServletRequest) request; 
    %> 

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
		
		<h3 class="text-center">
					<a href="index.jsp">SRS</a>
			</h3>
		</div>
	</div>
	<!-- <div class="row-fluid">
		<div class="span12">
			<form class="form-search">
				<input class="input-medium search-query" type="text" /> <button type="submit" class="btn">查找</button>
			</form>
		</div>
	</div> -->
	 <div class="row-fluid">
		<div class="span12">
		
		<!--  	<form  name="form"  method="post">
	
			<input  name="enroll" type="button"  id="enroll"  class="Common"   onclick="form.action='../enrollCourseServlet';form.submit()"  value="选课"/>
					
		<table class="table">
				<thead>
					<tr>
					<th>
						choose
						</th>
						<th>
						section
						</th>
						
							<th>
							operation
						</th>
						<th>
							operation
						</th>		
					</tr>
				</thead>
				<tbody>
		
		
			
					<tr>
						
				</tr>
					
							
				</tr>
					
				
					<tr>
						<td>
							 <input name="select" type="checkbox" id="checkbox1" value="CMP101-1"/>
						</td>
							<td>
							CMP101 - 1
						</td>
							<td>
							 <input name="select" type="checkbox" id="checkbox1" value="CMP283-1"/>
						</td>
							<td>
							CMP101 - 1
						</td>
				</tbody>
			</table>
			
			</form> -->
			<form>
				<form  name="form"  method="post">
	
			<input  name="enroll" type="button"  id="enroll"  class="Common"   onclick="form.action='../enrollCourseServlet';form.submit()"  value="选课"/>
				<table class="table">
				<thead>
					<tr>
					<th>
						choose
						</th>
						<th>
						section
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
				<c:forEach var="bh" items="${requestScope.keys}">
					<tr>
						<td>
							 <input name="select" type="checkbox" id="checkbox1" value="${bh}"/>
						</td>
					<td>
							${bh}
						</td>	
						
					</tr>	
					</c:forEach>	
				</tbody>
			</table>
			
			</form>
			
			<table class="table">
				<thead>
					<tr>
					<!-- <th>
						choose
						</th> -->
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
				<c:forEach var="bh" items="${requestScope.secs}">
				<tr>
					<%-- <td>
							 <input name="select" type="checkbox" id="checkbox1" value="${bh.FullSectionNo}"/>
						</td>
							<td>
							${bh.sectionFullSectionNo}
						</td> --%>
							
						
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
				</tr>
				</c:forEach>
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
				
			<h3>刚选的课程	</h3>
			<h3><%=request.getAttribute("alert")%></h3>
		   	
			<table class="table">
				<thead>
					<tr>
					<th>
						choose
						</th>	
						<th>
						FullSectionNo
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
		
			
			<c:forEach var="bh" items="${requestScope.section}">   
					<tr>
					<td>
							 <input name="select" type="checkbox" id="checkbox1" value="CMP101-1"/>
						</td>
						
					<td>
								${bh.FullSectionNo}
						</td>
						</tr>
						</c:forEach>
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
		
	<%-- <div class="row-fluid">
		<div class="span12">
		
		
		
	<!--	<table class="table">
				<thead>
					<tr>
						<th>
							序列号
						</th>
						<th>
							制造商
						</th>
						<th>
						   尺寸
						</th>
						<th>
							类型
						</th>
					    <th>
						 价格
						</th>
						<th>
							背面材质
						</th>	
					<th>
							梢头材质
						</th>		
						
					</tr>
				</thead>
				<tbody>
				
				-->	<tr class="error">
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
					</tr>
				</tbody>
			</table>
			<div class="pagination">
				<ul>
					<li>
						<a href="#">上一页</a>
					</li>
					<li>
						<a href="#">1</a>
					</li>
					<li>
						<a href="#">2</a>
					</li>
					<li>
						<a href="#">3</a>
					</li>
					<li>
						<a href="#">4</a>
					</li>
					<li>
						<a href="#">5</a>
					</li>
					<li>
						<a href="#">下一页</a>
					</li>
				</ul>
			</div>
<table class="table">
				<thead>
					<tr>
						<th>
							序列号
						</th>
						<th>
							制造商
						</th>
						<th>
						   尺寸
						</th>
						<th>
							类型
						</th>
					    <th>
						 价格
						</th>
						<th>
							背面材质
						</th>	
					<th>
							梢头材质
						</th>		
						
					</tr>
				</thead>
				<tbody>
				<%
				for (int i = 0; i < blahs.size(); i++) { 
			 		Guitar bh = blahs.get(i);
			 %>
				 
					<tr>
					<td>
							<input type="text" name="SerialNumble" value="<%=bh.getSerialNumble() %>"/>
						</td>
						<td>
							<input type="text" name="Type" value="<%=bh.getType() %>"/>
						</td>
						<td>
							<input type="text" name="Builder" value="<%=bh.getBuilder() %>"/>
						</td>
						<td>
							<input type="text" name="Model" value="<%=bh.getModel() %>"/>
						</td>
						
						<td>
							<input type="text" name="Price" value="<%=bh.getPrice() %>"/>
						</td>
						
						
					
						<td>
							<input type="text" name="backwood" value="<%=bh.getBackWood() %>"/>
						</td>
						
					<td>
							<input type="text" name="TopWood(" value="<%=bh.getTopWood() %>"/>
						</td>
						
					</tr>
					
					
					<tr class="error">
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
					</tr>
				</tbody>
			</table>
			
				
			<div class="pagination">
				<ul>
					<li>
						<a href="#">上一页</a>
					</li>
					<li>
						<a href="#">1</a>
					</li>
					<li>
						<a href="#">2</a>
					</li>
					<li>
						<a href="#">3</a>
					</li>
					<li>
						<a href="#">4</a>
					</li>
					<li>
						<a href="#">5</a>
					</li>
					<li>
						<a href="#">下一页</a>
					</li>
				</ul>
			</div>

		 --%>
		
		</div>
	</div>
</div>
</body>
</html>