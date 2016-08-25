<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html	xmlns="http://www.w3.org/1999/xhtml">
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8"	/>
 <title>贵美商城</title>
 <link rel="stylesheet"	type="text/css"	href="../css/global.css"	/>
 <link rel="stylesheet"	type="text/css"	href="../css/layout.css"	/>
	
<script type="text/javascript" src="../js/jquery-1.8.2.js"></script>	
<script type="text/javascript">
  
 

</script> 	
</head>
  
<body>
<div id="container">
	<jsp:include page="header.jsp" />
	<form action="/maven_ssm/users/login" method="post">
	<div class="login">
		<ul class="form f_l">
			<h1><img src="../images/logintitle.gif" alt="会员登录" /></h1>
			
			<span style="color: red; font-weight: 900; text-align: center; " >${ha }</span>
			<li class="login_list"><label>会员名：</label><input type="text" name="userName"   />
			   <span id="passMsg"></span>
			</li>
			
			<li class="login_list"><label>密&nbsp;&nbsp;&nbsp;码：</label><input type="password" name="password" /><span style="color: red; font-weight: 900;"> ${login_error}</span></li>
			<li class="a_c"><input type="image" src="../images/login.gif" alt="登录" style="height: 30px;width: 80px; border: 0px;" id="img" onclick="document.forms[0].submit;" >
			</li>
			
			<li class="desc">&delta;&nbsp;&nbsp;<a href="#">密码安全贴士</a>。</li>
			<li class="desc">&delta;&nbsp;&nbsp;防止病毒或者木马窃取您的账户信息，<a href="#">在线检查</a>您的电脑是否安全。</li>						
		</ul>
			<h1><img src="../images/register.gif" alt="注册会员" /></h1>
		<ul class="aside f_l">
			<li class="regpic"><span>便宜有好货！</span>超过7000万件商品任您选。</li>
		 	<li class="regpic regpic2"><span>买卖更安全！</span>交易超安全。</li>
			<li class="regpic regpic3"><span>免费开网店！</span>轻松赚钱交友。</li>
			<li class="regpic regpic4"><span>超人气社区！</span>彩活动每一天</li>
			<li class="a_c"><a href="register"><img src="../images/registernow.gif" alt="现在就注册" /></a></li>
			<ul class="reged">
			<li class="regpic regpic5">您已经是会员？<a href="#">由此登入</a></li>
			<li class="regpic regpic6">繁体中文用户由此<a href="#">注册</a></li>
			</ul>
		</ul>
	</div>
	</form>
	<jsp:include page="footer.jsp" />
</div> <!--container end-->	
</body>
</html>
