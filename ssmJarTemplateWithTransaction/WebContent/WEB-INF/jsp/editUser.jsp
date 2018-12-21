<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
 <div style="width:500px;margin:0px auto;text-align:center">
	
	
	<div style="text-align:center;margin-top:40px">
		
		<form method="post" action="updateUser">
			用户名称： <input name="name" value="${user.name}" type="text"> <br><br>
			用户年龄： <input name="age" value="${user.age}" type="text"> <br><br>
			<input type="hidden" value="${user.id}" name="id">
			<input type="submit" value="编辑用户">
		</form>

	</div>	
 </div>
