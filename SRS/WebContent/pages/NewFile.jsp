<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../script/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" />
 <script src="../script/jquery/jquery-1.7.1.min.js"></script>
    <script src="../script/ligerUI/js/ligerui.min.js"></script>


 <style type="text/css">
  </style>
  
  <script src="../script/ligerUI/js/core/base.js" type="text/javascript"></script>
  <script src="../script/ligerUI/js/plugins/ligerCheckBox.js" type="text/javascript"></script>
  <script src="../script/ligerUI/js/plugins/ligerComboBox.js" type="text/javascript"></script>
  <script src="../script/ligerUI/js/plugins/ligerResizable.js" type="text/javascript"></script> 
  

</head>
<body>
  <select ligeruiid="select2" name="select2" id="select2">
  
                <option selected="selected" value="opt1"></option>
                <option value="opt2">Option 2</option>
                <option value="opt3">Option 3</option>
                <option value="opt4">Option 4</option>
                <option value="opt5">Option 5</option>
                <option value="opt6">Option 6</option>
                <option value="opt7">Option 7</option>
                <option value="opt8">Option 8</option>
            </select>
           
      <br>
          
<a href="javascript:clickee()" class="l-button" style="width:100px">获取</a> 
 <div style="display:none;">
  
</div>
</body>
 <script type="text/javascript">
        $(function ()
        { 
            $("#select2").ligerComboBox(); 
        });
        function clickee()
        {
            alert($("#select2").val());
        }
    </script>
 

</html>