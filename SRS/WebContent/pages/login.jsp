<%@page import="util.*,java.util.*,model.*,daoImplsqlite.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
<link href="../script/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" />
    <script src="../script/jquery/jquery-1.7.1.min.js"></script>
    <script src="../script/ligerUI/js/ligerui.min.js"></script>

    <script src="../script/jquery-validation/jquery.validate.min.js"></script>
    <script src="../script/jquery-validation/jquery.metadata.js"></script>
    <script src="../script/jquery-validation/messages_cn.js"></script>
    <script src="../script/json2.js"></script>
    <style type="text/css">
        .middle input {
            display: block;
            width: 30px;
            margin: 2px;
        }
    </style>
    <script type="text/javascript">
       $(function ()
       {
           $("#form1").ligerForm({
               validate: true
           });
       });
 
 
   </script>
   <style type="text/css">
           body
           {
               padding-left:10px;
               font-size:13px;
           }
           h1
           {
               font-size:20px;
               font-family:Verdana;
           }
           h4
           {
               font-size:16px;
               margin-top:25px;
               margin-bottom:10px;
           }
 
           .description
           {
               padding-bottom:30px;
               font-family:Verdana;
           }
           .description h3
           {
               color:#CC0000;
               font-size:16px;
               margin:0 30px 10px 0px;
               padding:45px 0 8px;
               border-bottom:solid 1px #888;
           }
       td {
           padding: 5px;
       }
 
   </style>
 
    
</head>
<body>
  <h1>学生选课系统</h1>   
   <form id="formid" method = "post"  action = "../loginServlet" >   
  <table>
           <tbody><tr>
               <td>
                   <label for="textbox1">用户名：</label>
               </td>
               <td>
                   <div class="l-text" style="width: 178px;"><input id="textbox1" name="username" type="text" class="ui-textbox l-text-field" validate="{required:true}" ligeruiid="textbox1" style="width: 174px;"><div class="l-text-l"></div><div class="l-text-r"></div></div>
               </td>
           </tr>
           <tr>
               <td>
                   <label for="pwd1">密码：</label>
               </td>
               <td>
                   <div class="l-text" style="width: 178px;"><input id="pwd1" name="password" type="password" class="ui-password l-text-field" validate="{required:true}" ligeruiid="pwd1" style="width: 174px;"><div class="l-text-l"></div><div class="l-text-r"></div></div>
               </td>
           </tr>
     
           <tr>
       <td>
							 <input name="select" type="radio" id="checkbox1" value="Student"/>学生
							 
							 
						</td>
                   <td>
							 <input name="select" type="radio" id="checkbox1" value="Professor"/>教师
							 
							 
						</td> 
						<td>
							 <input name="select" type="radio" id="checkbox1" value="admin"/>系主任
							 
							 
						</td>
           
               </tr>
               <tr>
               <td> 
                     <!--  <input value="valid" type="button" onclick="valid()">
                   <input value="setData" type="button" onclick="setData()">
                   <input value="getData" type="button" onclick="getData()"> -->
                  <!--  <input value="jquery获取数据" type="button" onclick="submitForm()"> -->
                      <input  type="submit" value="登录">
                 
               </td>
           </tr>
       </tbody></table>
    
 </form>
     
    
<script type="text/javascript">
   
    function valid()
    {
        var form = liger.get("form1");
        alert(form.valid());
    }
    function getData()
    {
        var form = liger.get("form1");
        var data = form.getData();
        alert(JSON.stringify(data));
    }
    function setData()
    {
        var obj = {
            username: "abc",
            pwd: "1234",
            area : "广东",
            birthDay: "2020-11-12",
            age : 45,
            married: true,
            depart : "2",
            country1: "en",
            country1_mul: "en;cn",
            country2: "en",
            country3: "en",
            country4: "en",
            country4_mul: "en;cn",
        };
        var form = new liger.get("form1");
        form.setData(obj);
    }   

   /*  function submitForm()
    {
        var data = {};
        $("input").each(function ()
        {
            var name = $(this).attr("name");
            if (name && name.indexOf('ligerui') == -1)
            {
                data[name] = this.value;
            }
        });
        alert(JSON.stringify(data));
        document.getElementById("formid").submit();
    } */

   </script>
</body>
</html>