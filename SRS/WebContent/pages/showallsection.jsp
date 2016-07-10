
<%@ page  import="util.*,java.util.*,model.*"  language="java" contentType="text/html; charset=utf-8"
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
		
		<h1 class="text-center">
			<a href="index.jsp">	SRS</a>
			</h1>
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
		
		
		<c:forEach var="bh" items="${requestScope.secs}">
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
				<tr>
				<%-- 	<td>
							 <input name="select" type="checkbox" id="checkbox1" value="${bh.FullSectionNo}"/>
						</td> --%>
						<%-- 	<td>
							${bh.FullSectionNo}
						</td>
							 --%>
						
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
				
				 <form  name="form"  method="post">
			<input name="add" type="button"  id="add"  class="Common"   onclick="form.action='。。/addProfessorServlet';form.submit()"  value="AddProfessor"/>
			<input  name="delete" type="button"  id="delete"  class="Common"   onclick="form.action='。。/deleteProfessorServlet';form.submit()"  value="deleteProfessor"/>
			<input name="update" type="button"  id="update"  class="Common"   onclick="form.action='。。/updateProfessorSectionServlet';form.submit()"  value="updateProfessor"/> 
								
				<c:forEach var="bh" items="${requestScope.keys}">
				<table class="table">
				<thead>
					<tr>
					<th>
						choose
						</th>
						<th>
						FullSectionNo
						</th>
						<th>
						FullSectionNo
						</th>
							<th>
						Professor
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
							 <input name="select" type="checkbox" id="checkbox1" value="${bh}"/>
						</td>
						<td>
							 ${bh }
						</td>
						<td>
						<input type="text" name="FullSectionNo"/>
						</td>
						<td>
						<input type="text" name="professor"/>
						</td>
					</tr>		
				</tbody>
			</table>
			</c:forEach>
			</form>
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