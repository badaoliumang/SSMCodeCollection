<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
 pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">  
<title>用AJAX以JSON方式提交数据</title>  
</head>  
<script type="text/javascript" src="${APP_PATH }/static/js/jquery-1.12.4.min.js"></script>
<link href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<body>  
    <!-- <form >  
       id：<input type="text" id="id" value="123" class="form-control"/><br/>  
       名称：<input type="text" id="name" value="category xxx" class="form-control"/><br/>  
        <input type="button" value="提交" id="sender" class="btn btn-default">   
    </form>   -->
    <form >
	  <div class="form-group">
	    <label for="name">用户名</label>
	    <input type="text" class="form-control" id="name" name ="name" placeholder="name">
	  </div>
	  <div class="form-group">
	    <label for="age">年龄</label>
	    <input type="number" class="form-control" id="age"  name="age" placeholder="age">
	  </div>
	  <button type="submit" class="btn btn-default" id="sender">提交</button>
	</form>
    <div id="messageDiv"></div>  
       
    <script>  
    $('#sender').click(function(){  
    	var name=document.getElementById('name').value;  
        var age=document.getElementById('age').value;  
        var user={"name":name,"age":age};  
        var jsonData = JSON.stringify(user);
        var page="submitUser";  
        
        $.ajax({
        	   type:"post",
        	   url: page,
        	   data:jsonData,
               dataType:"json",
               contentType : "application/json;charset=UTF-8",
        	   success: function(result){
        	   }
        	});
		   alert("提交成功，请在Tomcat控制台查看服务端接收到的数据");

    });
    </script>  
</body>  
   
</body>
</html>