<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h2> <a href="professorindex.jsp">SRS</a></h2>
   <form id="formid" method = "post"  action = "../postGradeServlet" >   
  <table>
           <tbody><tr>
               <td>
                   <label for="textbox1">sectionID</label>
               </td>
               <td>
                   <div class="l-text" style="width: 178px;"><input id="textbox1" name="sectionID" type="text" class="ui-textbox l-text-field" validate="{required:true}" ligeruiid="textbox1" style="width: 174px;"><div class="l-text-l"></div><div class="l-text-r"></div></div>
               </td>
           </tr>
           <tr>
               <td>
                   <label for="pwd1">Grade</label>
               </td>
               <td>
                   <div class="l-text" style="width: 178px;"><input id="pwd1" name="Grade" type="text" class="ui-password l-text-field" validate="{required:true}" ligeruiid="pwd1" style="width: 174px;"><div class="l-text-l"></div><div class="l-text-r"></div></div>
               </td>
           </tr>
     
           <tr>
    
               </tr>
               <tr>
               <td> 
                     <!--  <input value="valid" type="button" onclick="valid()">
                   <input value="setData" type="button" onclick="setData()">
                   <input value="getData" type="button" onclick="getData()"> -->
                  <!--  <input value="jquery获取数据" type="button" onclick="submitForm()"> -->
                      <input  type="submit" value="postgrade">
                 
               </td>
           </tr>
       </tbody></table>
    
 </form>
     
</body>
</html>