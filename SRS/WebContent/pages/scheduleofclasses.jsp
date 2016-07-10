
<%@ page  import="util.*,java.util.*,model.*"  language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
				<a href="index.jsp">SRS</a>
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
		<div class="span4">
		
		<form  action="../scheduleOfClassServlet" method="post">
				<fieldset>
					 <legend>学生选课</legend> 
					  <label>学期：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>	
					  <select name="semester">
	 			<option value=""></option>
	 			<option value="SP2005">SP2005</option>
	 			<option value="SP2006">SP2006</option>
	 			<option value="SP2007">SP2007</option>
	 			<option value="SP2008">SP2008</option>
	 		  </select>
	 		
					  <br>
					  	<input type="submit" name="查询选课" value="查询选课"/>	 	
			          
				</fieldset>
			</form>
		</div>
		<div class="span4">
		</div>
		<div class="span4">
		</div>
	</div>
	
	 <%-- <div class="row-fluid">
		<div class="span12">
		
		 <c:forEach var="bh" items="${requestScope.matchingGuitars}">
		
		<table class="table">
				<thead>
					<tr>
						<th>
						serialNumber
						</th>
						<th>
						price
						</th>
						<th>
						builder
						</th>
						<th>
						   model
						</th>
						
					    <th>
						type
						</th>
						<th>
							numStrings
						</th>	
					<th>
							backWood
						</th>		
						<th>
							topWood
						</th>	
					</tr>
				</thead>
				<tbody>
			
					<tr>
					<td>
							<input type="text" name="serialNumble" value="${bh.serialNumber}"/>
						</td>
						<td>
							<input type="text" name="price" value="${bh.price}"/>
						</td>
						<td>
							<input type="text" name="builder" value="${bh.spec.builder}"/>
						</td>
						<td>
							<input type="text" name="model" value="${bh.spec.model}"/>
						</td>
						<td>
							<input type="text" name="type" value="${bh.spec.type }"/>
						</td>
						<td>
							<input type="text" name="numStrings" value="${bh.spec.numStrings }"/>
						</td>
			<td>
							<input type="text" name="backwood" value="${bh.spec.backWood}"/>
						</td>
						
					<td>
							<input type="text" name="topWood" value="${bh.spec.topWood}"/>
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
			</table> --%>
			
	
	 <!-- <div class="pagination">
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
			</div> -->

		
		</div>
	</div>
</div>
	
</body>
</html>