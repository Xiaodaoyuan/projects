<%@page import="com.zrgk.entity.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>贵美商城后台管理</title>
<%
 User u=(User)request.getSession().getAttribute("u");
 if(u==null)response.sendRedirect("admin_login.jsp");
 %>
</head>
<frameset rows="80,*"  frameborder="NO" border="0" framespacing="0">
	<frame src="jsp_admin/admin_top.jsp" noresize="noresize" frameborder="NO" name="topFrame" scrolling="no" marginwidth="0" marginheight="0" target="main" />
  <frameset cols="200,*"  rows="560,*" id="frame">
	<frame src="jsp_admin/admin_left.jsp" name="leftFrame" noresize="noresize" marginwidth="0" marginheight="0" frameborder="0" scrolling="no" target="main" />
	<frame src="jsp_admin/admin_right.jsp" name="main" marginwidth="0" marginheight="0" frameborder="0" scrolling="auto" target="_self" />

  </frameset>
<noframes>
  <body></body>
    </noframes>
</html>
