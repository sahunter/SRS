<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<title>教授信息</title>     
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
           $("#form1").ligerForm();
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
 
 
 
 
 
    <h1>教授信息</h1>      
       
 
   <div id="form1">
       <table>
            
           <tbody>
           <tr>
               <td>
                   <label for="textbox1">Name：</label>
               </td>
               <td>
                   <div class="l-text" style="width: 178px;"><input name="username" class="ui-textbox l-text-field" id="textbox1" style="width: 174px;" type="text" ligeruiid="textbox1"><div class="l-text-l"></div><div class="l-text-r"></div></div>
               </td>
           </tr>
           <tr>
               <td>
                   <label for="pwd1">Soc. Security No.：</label>
               </td>
               <td>
                   <div class="l-text" style="width: 178px;"><input name="pwd" class="ui-password l-text-field" id="pwd1" style="width: 174px;" type="password" ligeruiid="pwd1"><div class="l-text-l"></div><div class="l-text-r"></div></div>
               </td>
           </tr>
           <tr>
               <td>
                   <label for="textbox1">Title：</label>
               </td>
               <td>
                   <div class="l-text" style="width: 178px;"><input name="username" class="ui-textbox l-text-field" id="textbox1" style="width: 174px;" type="text" ligeruiid="textbox1"><div class="l-text-l"></div><div class="l-text-r"></div></div>
               </td>
           </tr>
           <tr>
               <td>
                   <label for="pwd1">Teaches for Dept.：</label>
               </td>
               <td>
                   <div class="l-text" style="width: 178px;"><input name="pwd" class="ui-password l-text-field" id="pwd1" style="width: 174px;" type="password" ligeruiid="pwd1"><div class="l-text-l"></div><div class="l-text-r"></div></div>
               </td>
           </tr>
           <tr>
               <td>
                   <label for="textbox1">Course No.：</label>
               </td>
               <td>
                   <div class="l-text" style="width: 178px;"><input name="username" class="ui-textbox l-text-field" id="textbox1" style="width: 174px;" type="text" ligeruiid="textbox1"><div class="l-text-l"></div><div class="l-text-r"></div></div>
               </td>
           </tr>
           <tr>
               <td>
                   <label for="pwd1">Section No.：</label>
               </td>
               <td>
                   <div class="l-text" style="width: 178px;"><input name="pwd" class="ui-password l-text-field" id="pwd1" style="width: 174px;" type="password" ligeruiid="pwd1"><div class="l-text-l"></div><div class="l-text-r"></div></div>
               </td>
           </tr>
           <tr>
               <td>
                   <label for="textbox1">Course Name：</label>
               </td>
               <td>
                   <div class="l-text" style="width: 178px;"><input name="username" class="ui-textbox l-text-field" id="textbox1" style="width: 174px;" type="text" ligeruiid="textbox1"><div class="l-text-l"></div><div class="l-text-r"></div></div>
               </td>
           </tr>
           <tr>
               <td>
                   <label for="pwd1">Day and Time：</label>
               </td>
           <tr>
               <td>
                    
               </td>
               <td> 
                   <input onclick="setData()" type="button" value="setData">
                   <input onclick="getData()" type="button" value="getData">
                   <input onclick="submitForm()" type="button" value="jquery获取数据">
                    
               </td>
           </tr>
       </tbody></table>
   </div>
 
     
    
<script type="text/javascript">
   
 
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
        var form = liger.get("form1");
        form.setData(obj);
    }
      
 
    function submitForm()
    {
 
        var data = {};
        $("input,select,textarea").each(function ()
        {
            var name = $(this).attr("name");
            if (name && name.indexOf('ligerui') == -1)
            {
                data[name] = this.value;
            }
        });
        alert(JSON.stringify(data));
 
    }
 
   </script>
    
   

</body>
</html>