<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>测试页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
	$(function(){
		$("#alert").click(function(){
			$.getJSON("alert", function(json){
				  alert(json);
				});
		})
	}); 
	</script>
  </head>
  
  <body>
    <a href="UserList">Get UserList</a><br/><br/><br/>
    <a href="SellerList">Get SellerList</a><br/><br/><br/>
    <a href="equals">SqlSessionFactory</a><br/><br/><br/>
    <input id="alert" type="button" value="alert"><br/><br/><br/>
    <a href="out">out</a>
    <c:forEach var="list" items="${list}">
    	${list.nick_name}<br/>
    </c:forEach>
  </body>
</html>
