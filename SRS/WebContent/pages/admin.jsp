<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
		  <a href="professorinformationmanagement.jsp">教师信息管理</a>
			<form  name="form5"  method="post">
	
			<input name="searchSectionServlet" type="button"  id="searchSectionServlet"  class="Common"   onclick="form5.action='../searchSectionServlet';form5.submit()"  value="查询课程表"/>
			<input  name="add" type="button"  id="add"  class="Common"   onclick="form5.action='../searchProfessorServlet';form5.submit()"  value="searchProfessor"/>
            <input  name="delete2" type="button"  id="delete2"  class="Common"   onclick="form5.action='../../DeleteUserAuthority';form5.submit()"  value="删除"/>
			 </form>
			 
			 <button class="btn" type="button">按钮</button>
		</div>
	</div>
</div>
div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<ul class="nav nav-tabs">
				<li class="active">
					<a href="#">首页</a>
				</li>
				<li>
					<a href="#">资料</a>
				</li>
				<li class="disabled">
					<a href="#">信息</a>
				</li>
				<li class="dropdown pull-right">
					 <a href="#" data-toggle="dropdown" class="dropdown-toggle">下拉<strong class="caret"></strong></a>
					<ul class="dropdown-menu">
						<li>
							<a href="#">操作</a>
						</li>
						<li>
							<a href="#">设置栏目</a>
						</li>
						<li>
							<a href="#">更多设置</a>
						</li>
						<li class="divider">
						</li>
						<li>
							<a href="#">分割线</a>
						</li>
					</ul>
				</li>
			</ul>
			<ul class="nav nav-list">
				<li class="nav-header">
					列表标题
				</li>
				<li class="active">
					<a href="#">首页</a>
				</li>
				<li>
					<a href="#">库</a>
				</li>
				<li>
					<a href="#">应用</a>
				</li>
				<li class="nav-header">
					功能列表
				</li>
				<li>
					<a href="#">资料</a>
				</li>
				<li>
					<a href="#">设置</a>
				</li>
				<li class="divider">
				</li>
				<li>
					<a href="#">帮助</a>
				</li>
			</ul>
		</div>
	</div>
</div>
</body>
</html>