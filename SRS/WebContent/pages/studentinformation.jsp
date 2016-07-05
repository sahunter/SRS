<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<title>学生信息</title>     
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
 
 
 
 
 
    <h1>学生信息</h1>      
       
 
   <div id="form1">
       <table>
            
           <tbody><tr>
               <td>
                   <label for="textbox1">TextBox：</label>
               </td>
               <td>
                   <div class="l-text" style="width: 178px;"><input name="username" class="ui-textbox l-text-field" id="textbox1" style="width: 174px;" type="text" ligeruiid="textbox1"><div class="l-text-l"></div><div class="l-text-r"></div></div>
               </td>
           </tr>
           <tr>
               <td>
                   <label for="pwd1">Password：</label>
               </td>
               <td>
                   <div class="l-text" style="width: 178px;"><input name="pwd" class="ui-password l-text-field" id="pwd1" style="width: 174px;" type="password" ligeruiid="pwd1"><div class="l-text-l"></div><div class="l-text-r"></div></div>
               </td>
           </tr>
           <tr>
               <td>
                   <label for="textarea1">TextArea：</label>
               </td>
               <td>
                   <textarea name="area" class="ui-textarea l-textarea" id="textarea1"></textarea>
               </td>
           </tr>
           <tr>
               <td>                   
                   <label for="date1">DatePicker：</label>
               </td>
               <td>
                   <div class="l-text-wrapper" style="width: 178px;"><div class="l-text l-text-date" style="width: 178px;"><input name="birthDay" class="ui-datepicker l-text-field" id="date1" style="width: 158px;" type="text" value="2010-10-12" ligeruiid="date1"><div class="l-text-l"></div><div class="l-text-r"></div><div class="l-trigger"><div class="l-trigger-icon"></div></div><div class="l-trigger l-trigger-cancel" style="display: none;"><div class="l-trigger-icon"></div></div></div></div>
               </td>
           </tr>
           <tr>
               <td>
                   Spinner：
               </td>
               <td>
                   <div class="l-text" style="width: 178px;"><input name="age" class="ui-spinner l-text-field" style="width: 158px;" type="text" value="22" ligeruiid="Spinner1000"><div class="l-text-l"></div><div class="l-text-r"></div><div class="l-trigger"><div class="l-spinner-up"><div class="l-spinner-icon"></div></div><div class="l-spinner-split"></div><div class="l-spinner-down"><div class="l-spinner-icon"></div></div></div></div>
               </td>
           </tr>
           <tr>
               <td>
                   CheckBox：
               </td>
               <td>
                   <div class="l-checkbox-wrapper"><a class="l-checkbox"></a><input name="married" class="ui-checkbox l-hidden" type="text" value="Y" ligeruiid="CheckBox1001" text="婚否"></div>
               </td>
           </tr>
            <tr>
               <td>
                   ComboBox(select)：
               </td>
               <td>
                 <select name="depart" style="display: none;" ligeruiid="ligerui1002">
                   <option selected="selected" value="1">主席</option>
                   <option value="2">研发中心</option>
                   <option value="3">销售部</option>
                   <option value="4">市场部</option>
                   <option value="5">顾问组</option>
               </select><div class="l-text-wrapper"><div class="l-text l-text-combobox" style="width: 178px;"><input class="l-text-field" id="_txt" style="width: 158px;" type="text" readonly="true" data-comboboxid="ligerui1002" validate="{required:true}"><div class="l-text-l"></div><div class="l-text-r"></div><div class="l-trigger"><div class="l-trigger-icon"></div></div></div><input name="_txt_val" id="_txt_val" type="hidden" value="1" data-ligerid="ligerui1002"></div>
               </td>
           </tr>
 
           <tr>
               <td>
                   ComboBox：
               </td>
               <td>
                   <div class="l-text-wrapper"><div class="l-text l-text-combobox" style="width: 178px;"><input class="l-text-field" id="_txt" style="width: 158px;" type="text" readonly="true" data-comboboxid="ligerui1004"><div class="l-text-l"></div><div class="l-text-r"></div><div class="l-trigger"><div class="l-trigger-icon"></div></div><div class="l-trigger l-trigger-cancel" style="display: none;"><div class="l-trigger-icon"></div></div></div><input name="country1" class="ui-combobox" type="hidden" value="de" ligeruiid="ligerui1004" data-ligerid="ligerui1004" data-valuefield="id" data-textfield="text" data-url="data/countrys.txt" data-ajaxtype="get" data-value="de"></div> 
               </td>
           </tr>
             <tr>
               <td>
                   ComboBox(多选)：
               </td>
               <td>
                   <div class="l-text-wrapper"><div class="l-text l-text-combobox" style="width: 178px;"><input class="l-text-field" id="_txt" style="width: 158px;" type="text" readonly="true" data-comboboxid="ligerui1006"><div class="l-text-l"></div><div class="l-text-r"></div><div class="l-trigger"><div class="l-trigger-icon"></div></div><div class="l-trigger l-trigger-cancel" style="display: none;"><div class="l-trigger-icon"></div></div></div><input name="country1_mul" class="ui-combobox" type="hidden" value="de" ligeruiid="ligerui1006" data-ligerid="ligerui1006" data-valuefield="id" data-textfield="text" data-url="data/countrys.txt" data-ajaxtype="get" data-value="de" data-ismultiselect="true"></div> 
               </td>
           </tr>
           <tr>
               <td>
                   CheckBoxList：
               </td>
               <td>
                   <div class="l-checkboxlist" style="width: 178px;"><div class="l-checkboxlist-inner"><table class="l-checkboxlist-table" border="0" cellspacing="0" cellpadding="0"></table></div><input name="country2" class="ui-checkboxlist" type="hidden" value="cn" ligeruiid="ligerui1008" data-ligerid="ligerui1008" data-valuefield="id" data-textfield="text" data-url="data/countrys.txt" data-ajaxtype="get" data-value="cn"></div> 
               </td>
           </tr>
           <tr>
               <td>
                   RadioButtonList：
               </td>
               <td>
                   <div class="l-radiolist" style="width: 178px;"><div class="l-radiolist-inner"><table class="l-radiolist-table" border="0" cellspacing="0" cellpadding="0"></table></div><input name="country3" class="ui-radiolist" type="hidden" value="fr" ligeruiid="ligerui1009" data-ligerid="ligerui1009" data-valuefield="id" data-textfield="text" data-url="data/countrys.txt" data-ajaxtype="get" data-value="fr"></div> 
               </td>
           </tr>
           <tr>
               <td>
                   ListBox：
               </td>
               <td>
                   <div class="l-listbox" style="width: 178px; height: 100px;"><div class="l-listbox-inner"><table class="l-listbox-table l-table-nocheckbox" border="0" cellspacing="0" cellpadding="0"></table></div><input name="country4" class="ui-listbox" type="hidden" value="cn" ligeruiid="ligerui1010" data-ligerid="ligerui1010" data-valuefield="id" data-textfield="text" data-url="data/countrys.txt" data-ajaxtype="get" data-value="cn"></div> 
               </td>
           </tr>
            <tr>
               <td>
                   ListBox(多选)：
               </td>
               <td>
                   <div class="l-listbox" style="width: 178px; height: 100px;"><div class="l-listbox-inner"><table class="l-listbox-table l-table-nocheckbox" border="0" cellspacing="0" cellpadding="0"></table></div><input name="country4_mul" class="ui-listbox" type="hidden" value="cn" ligeruiid="ligerui1011" data-ligerid="ligerui1011" data-valuefield="id" data-textfield="text" data-url="data/countrys.txt" data-ajaxtype="get" data-value="cn" data-ismultiselect="true"></div> 
               </td>
           </tr>
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