<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
 pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>查询所有用户</title>
</head>

<script type="text/javascript" src="${APP_PATH }/static/js/jquery-1.12.4.min.js"></script>
<link href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<body>
<table align='center' border='1' cellspacing='0' class="table table-bordered"
    <th >
        <td>id</td>
        <td>name</td>
        <td>age</td>
        <td>编辑</td>
        <td>删除</td>
    </th>
    <c:forEach items="${userList}" var="u">
        <tr class="active">
            <td >${u.id}</td>
            <td>${u.name}</td>
            <td>${u.age}</td>
            <td><a href="editUser?id=${u.id}">编辑</a></td>
	        <td><a href="deleteUser?id=${u.id}">删除</a></td>
        </tr>
    </c:forEach>
</table>
<div style="text-align:center">
        <a href="?start=0">首  页</a>
        <a href="?start=${page.start-page.count}">上一页</a>
        <a href="?start=${page.start+page.count}">下一页</a>
        <a href="?start=${page.last}">末  页</a>
</div>
<form action="addUser" method="post">
  <div class="form-group">
    <label for="name">用户名</label>
    <input type="text" class="form-control" id="name" name ="name" placeholder="name">
  </div>
  <div class="form-group">
    <label for="age">年龄</label>
    <input type="number" class="form-control" id="age"  name="age" placeholder="age">
  </div>
  <button type="submit" class="btn btn-default">新增用户</button>
</form>

</body>
</html>