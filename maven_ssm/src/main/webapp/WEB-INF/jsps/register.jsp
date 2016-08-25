<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>贵美商城</title>
<link rel="stylesheet" type="text/css" href="../css/global.css" />
<link rel="stylesheet" type="text/css" href="../css/layout.css" />
<script type="text/javascript" src="../js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="../js/check.js"></script>
</head>
<body>
	<div id="container">
		<jsp:include page="header.jsp" />
		<form id="form1" method="post" action="/maven_ssm/users/register"
			onsubmit="return 1checkTrue()" >
			<input type="hidden" id="h1" /><input type="hidden" id="h2" />
			<table class="reg" cellspacing="0px" cellpadding="0px">
				<tbody>
					<tr>
						<td class="a_r w15p"><label for="fname">名字：</label>
						</td>
						<td class="w500"><input name="nickName" id="fname" type="text"
							onfocus="updateRed('fname')" onblur="1checkFname()" /><span
							id="fname_msg"></span>
						</td>
						<td class="protocol" rowspan="12">
							<h4>
								<img src="../images/read.gif" alt="alt" />阅读贵美网服务协议
							</h4> <textarea name="textarea" cols="35" rows="15"
								disabled="disabled">欢迎阅读服务条款协议，本协议阐述之条款和条件适用于您使用Gmgw.com网站的各种工具和服务。

  本服务协议双方为贵美与贵美网用户，本服务协议具有合同效力。 
  贵美的权利和义务
    1.贵美有义务在现有技术上维护整个网上交易平台的正常运行，并努力提升和改进技术，使用户网上交易活动的顺利。 
    2.对用户在注册使用贵美网上交易平台中所遇到的与交易或注册有关的问题及反映的情况，贵美应及时作出回复。 
    3.对于在贵美网网上交易平台上的不当行为或其它任何贵美认为应当终止服务的情况，贵美有权随时作出删除相关信息、终止服务提供等处理，而无须征得用户的同意。 
    4.因网上交易平台的特殊性，贵美没有义务对所有用户的注册资料、所有的交易行为以及与交易有关的其他事项进行事先审查。 	
				  </textarea></td>
					</tr>
					<tr>
						<td class="a_r"><label for="lname">姓氏：</label>
						</td>
						<td><input name="lname" id="lname" type="text"
							onfocus="updateRed('lname')" onblur="1checkLname()" /><span
							id="lname_msg"></span>
						</td>
					</tr>
					<tr>
						<td class="a_r"><label for="sname">登录名：</label>
						</td>
						<td><input name="userName" id="sname" type="text"
							onfocus="updateRed('sname')" onblur="1checkSname()" /><span
							id="sname_msg">（可包含字母数字和下划线的4至16位）</span>
						</td>
					</tr>
					<tr>
						<td class="a_r"><label for="pass">密码：</label>
						</td>
						<td><input name="password" id="pass" type="password"
							onfocus="updateRed('pass')" onblur="1checkPass()" /><span
							id="pass_msg">（至少包含 6 个字符）</span>
						</td>
					</tr>
					<tr>
						<td class="a_r"><label for="rpass">再次输入密码：</label>
						</td>
						<td><input name="rpass" id="rpass" type="password"
							onfocus="updateRed('rpass')" onblur="1checkRpass()" /><span
							id="rpass_msg"></span>
						</td>
					</tr>
					<tr>
						<td class="a_r"><label for="email">电子邮箱：</label>
						</td>
						<td><input name="email" id="email" type="text"
							onfocus="updateRed('email')" onblur="1checkEmail()" /><span
							id="email_msg">格式如：xxx@xx.xx（.xx）</span>
						</td>
					</tr>
					<tr>
						<td class="a_r"><label for="gender">性别：</label>
						</td>
						<td><input name="gender" id="gender" class="b0" type="radio"
							value="男" checked="checked" /> <img src="../images/Male.gif"
							alt="alt" />男&nbsp; <input name="gender" class="b0" type="radio"
							value="女" /> <img src="../images/Female.gif" alt="alt" />女</td>
					</tr>
					<tr>
						<td class="a_r">头像：</td>
						<td><input type="file" name="photo" />
						</td>
					</tr>
					<tr>
						<td class="a_r"><label for="hobby">爱好：</label>
						</td>
						<td><input class="b0" type="checkbox" name="hobby" id="hobby"
							value="sports" />&nbsp;运动&nbsp;&nbsp; <input class="b0"
							type="checkbox" name="hobby" value="chat" />&nbsp;聊天&nbsp;&nbsp;
							<input class="b0" type="checkbox" name="hobby" value="playgames" />&nbsp;玩游戏
							<input class="b0" type="checkbox" name="hobby" value="readbook" />&nbsp;看书


						</td>
					</tr>
					<tr>
						<td class="a_r"><label for="nYear">出生日期：</label>
						</td>
						<td><input name="nYear" id="nYear" class="w40" maxlength="4" />&nbsp;年&nbsp;&nbsp;
							<select name="nMonth" id="nMonth">
								<option value="" selected="selected">[选择月份]</option>
								<option value="1">一月</option>
								<option value="2">二月</option>
								<option value="3">三月</option>
								<option value="4">四月</option>
								<option value="5">五月</option>
								<option value="6">六月</option>
								<option value="7">七月</option>
								<option value="8">八月</option>
								<option value="9">九月</option>
								<option value="10">十月</option>
								<option value="11">十一月</option>
								<option value="12">十二月</option>
						</select> <input name="nDay" id="nDay" class="w40" maxlength="2" />日<span
							id="birth_msg"></span></td>
					</tr>
					<tr>
						<td class="a_r"><label for="code">验证码：</label>
						</td>
						<td><input name="code" id="code" type="text" onfocus="updateRed('code')" onblur="1checkCode()"/> <a href="javascript:;"
							onclick="document.getElementById('num').src = 'image?'+(new Date()).getTime()"><img
								id="num" src="image" />
						</a> <a href="javascript:;"
							onclick="document.getElementById('num').src = 'image?'+(new Date()).getTime()">换一张</a>&nbsp;<span id="code_msg"></span>
						</td>
					</tr>
					<tr>
						<td colspan="2" class="pl150"><input type="image"
							name="submit" class="b0" src="../images/submit.gif" /><img
							src="../images/reset.gif" class="hand" alt="重填" onclick="Reset()" />
						</td>
					</tr>
				</tbody>
			</table>
		</form>
		<jsp:include page="footer.jsp" />
	</div>
	<!--container	end-->
</html>