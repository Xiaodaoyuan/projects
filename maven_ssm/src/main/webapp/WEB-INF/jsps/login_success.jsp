<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录成功 贵美商城</title>
<link rel="stylesheet" type="text/css" href="css/global.css" />
<link rel="stylesheet" type="text/css" href="css/layout.css" />
<script type="text/javascript">
	function f1() {
		setTimeout(function() {
			location = "/maven_ssm/app/index";
		}, 5000);
	}
</script>
</head>
<body onload="f1()">
	<%
		HttpSession s = request.getSession();
	%>
	<div id="container">
		<jsp:include page="header.jsp" />
		<p class="a_c lh24">
			<img src="../images/logo.jpg" alt="alt" /><br /> 祝贺 !!! <br />
			您已经成功登录！！！<br /> 欢迎来到 <a href="/maven_ssm/app/index"><font
				size="3" color="red">拍卖天堂</font></a>
		</p>
		<p><%=s.getAttribute("userName") %></p>
		<jsp:include page="footer.jsp" />
	</div>
	<!--container	end-->
</body>
</html>
