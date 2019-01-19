<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
 pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
    </th>
    <c:forEach items="${userList}" var="u">
        <tr class="active">
            <td >${u.id}</td>
            <td>${u.name}</td>
            <td>${u.age}</td>
              
        </tr>
    </c:forEach>
</table>
  </body>
</html>