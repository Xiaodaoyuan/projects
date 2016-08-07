<%@page import="com.zrgk.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新用户信息</title>
<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
<script type="text/javascript" >
	function checkFname() {
	var reg = /^([\u4E00-\u9FA5]){1,}$/;
	//alert();
	if($("#admin_fname").val()==""){
	  $("#fname_msg").html("姓氏不能为空！");
		$("#fname_msg").css({
			color : "red"
		});
		return false;
	}
	
	if (!reg.test($("#admin_fname").val())) {
		$("#fname_msg").html("姓氏必须是汉字！");
		$("#fname_msg").css({
			color : "red"
		});
		return false;
	}
	$("#fname_msg").html(
			"<img src='images/right.jpg' width='20px' height='20px'/>");
	return true;
}

function checkName() {
	var reg = /^([\u4E00-\u9FA5]){1,}$/;
	
	if($("#admin_name").val()==""){
	  $("#name_msg").html("名字不能为空！");
		$("#name_msg").css({
			color : "red"
		});
		return false;
	}
	if (!reg.test($("#admin_name").val())) {
		$("#name_msg").html("名字必须是汉字！");
		$("#name_msg").css({
			color : "red"
		});
		return false;
	}
	$("#name_msg").html(
			"<img src='images/right.jpg' width='20px' height='20px'/>");
	return true;
}
/* 
function checkUsername() {
//	$("#d1").html("");
if($("#sname").val()==""){
	  $("#username_msg").html("登录名不能为空！");
		$("#username_msg").css({
			color : "red"
		});
		return false;
	}


	$.post('checkUsername', {
		'sname' : $("#sname").val()
	}, function(data) {
		if (data == "true") {
			$("#username_msg").html("登录名已经被注册！");
			$("#username_msg").css({color : "red"});
			//$("#h1").val("false");
		}else{
			$("#username_msg").html(
			"<img src='images/right.jpg' width='20px' height='20px'/>");
		//	$("#admin_username").removeClass("updatered");
			//$("#h1").val("true");
		}
	});
		var reg = /^\w{4,16}$/;
	if (!reg.test($("#sname").val())) {
		$("#username_msg").html("登录名必须由数字、下划线或字母字符组成的4-16位字符");
		$("#username_msg").css({
			color : "red"
		});
		return false;
	}
	return true;
	
} */

function checkPassword() {

if($("#admin_password").val()==""){
	  $("#password_msg").html("密码不能为空！");
		$("#password_msg").css({
			color : "red"
		});
		return false;
	}
	var reg = /^[0-9a-zA-Z]{6,}$/;
	if (!reg.test($("#admin_password").val())) {
		$("#password_msg").html("密码必须由字母或数字组成的不少于6位字符！");
		$("#password_msg").css({color : "red"});
		return false;
	}
	//$("#pass").removeClass("updatered");
	$("#password_msg").html(
			"<img src='images/right.jpg' width='20px' height='20px'/>");
	return true;
}



function checkEmail() {

if($("#admin_email").val()==""){
	  $("#email_msg").html("邮箱不能为空！");
		$("#email_msg").css({
			color : "red"
		});
		return false;
	}
	var reg = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]{2,}(\.[a-z0-9]{2,5}){1,2}$/;
	if (!reg.test($("#admin_email").val())) {
		$("#email_msg").html("邮箱格式不正确！");
		$("#email_msg").css({color : "red"});
		return false;
	}
	//$("#admin_email").removeClass("updatered");
	$("#email_msg").html(
			"<img src='images/right.jpg' width='20px' height='20px'/>");
	return true;
}

function checkBirthdate(){
if($("#admin_birth").val()==""){
	  $("#birthdate_msg").html("请填写出生日期！");
		$("#birthdate_msg").css({
			color : "red"
		});
		return false;
	}
	var reg = /^\d{4}-\d{2}-\d{2}$/;
	if (!reg.test($("#admin_birth").val())) {
	
	
		$("#birthdate_msg").html("出生日期格式不正确！");
		$("#birthdate_msg").css({color : "red"});
		return false;
	}$("#birthdate_msg").html(
			"<img src='images/right.jpg' width='20px' height='20px'/>");
	return true;
}

function checkTrue() {
	if (checkFname() && checkName() && checkUsername() && checkPassword()
			 && checkEmail() && checkBirthdate())
		return true;
	return false;
}
</script>
</head>
<body>
	<%
	String msg = (String)request.getAttribute("error");
	 User u = (User)request.getAttribute("u");
	%>



	<form  action="admin_userUpdate.do2?id=<%=u.getId()%>"  method="post" enctype="multipart/form-data">
		<%=msg==null?"":msg%>
		<table>
		<tr >
		 <td align="center"> id：</td>
		 <td><input  disabled="disabled"  value="<%=u.getId()%>"/></td>
		</tr>
		<tr >
		<tr >
		 <td align="center"> 姓：</td>
		 <td><input  name="admin_fname" id="admin_fname" value="<%=u.getFamily_name()%>" onblur="checkFname()" /><span id="fname_msg"></span></td>
		</tr>
		<tr>
		 <td align="center">名：</td>
		 <td> <input  name="admin_name" id="admin_name" value="<%=u.getName()%>" onblur="checkName()" /><span id="name_msg"></span></td>
		</tr>
		<tr>
		 <td align="center">用户名 ：</td>
		 <td><input  name="sname" id="sname" value="<%=u.getUser_name()%>" readonly/></td>
		</tr>
		<tr>
		 <td align="center">密码: </td>
		 <td><input type="password" name="admin_password" id="admin_password" value="<%=u.getPassword()%>" onblur="checkPassword()" /><span id="password_msg"></span></td>
		</tr>
		<tr>
		 <td align="center">邮箱：</td>
		 <td> <input  name="admin_email" id="admin_email" value="<%=u.getEmail()%>" onblur="checkEmail()" /><span id="email_msg"></span></td>
		</tr>
		<tr>
		 <td align="center">性别：</td>
		
		<c:if test="${u.sex=='男'}" var="ss">
		 <td><select name="admin_sex" id="admin_sex">
		 <option  selected="selected">男</option>
		 <option >女</option>
		</select> </td>
		</c:if>
		<c:if test="${!ss}">
		 <td><select name="admin_sex" id="admin_sex">
		 <option  selected="selected" value="女">女</option>
		 <option value="男" >男</option>
		</select> </td>
		</c:if>
		
		</tr>
		<tr>
		 <td align="center">照片：</td>
		 <td> <input type="file" name="admin_photo" id="admin_photo" value="<%=u.getPhoto()%>" onblur="checkPhoto()" /><span id="photo_msg"></span></td>
		</tr>
		<tr>
		 <td align="center">爱好：</td>
		 <td><input  name="admin_enjoy" id="admin_enjoy" value="<%=u.getEnjoy()%>" onblur="checkEnjoy()" /><span id="enjoy_msg"></span></td>
		</tr>
		<tr>
		 <td align="center">出生日期：</td>
		 <td><input  name="admin_birth" id="admin_birth" value="<%=u.getBirth_date()%>" onblur="checkBirthdate()" /><span id="birthdate_msg"></span><span>(形式如：2001-01-01)</span></td>
		</tr>
		<tr>
		 <td align="center">权限：</td>
		
		<c:if test="${u.flag=='管理员'}" var="aa">
		 <td><select name="flag">
		 <option  selected="selected" value="管理员">管理员</option>
		 <option value="用户" >用户</option>
		</select> </td>
		</c:if>
		<c:if test="${!aa }">
		 <td><select name="flag">
		 <option  selected="selected" value="用户">用户</option>
		 <option value="管理员" >管理员</option>
		</select> </td>
		</c:if>
		</tr>
		<tr>
		 <td align="center"><input  type="submit" value="修改"/></td>
		 
		</tr><!--
		
		<tr >
		 <td align="center"> id：</td>
		 <td><input  disabled="disabled"  value="<%=u.getId()%>"/></td>
		</tr>
		<tr >
		 <td align="center"> 姓：</td>
		 <td><input name="admin_fname" value="<%=u.getFamily_name()%>"/></td>
		</tr>
		<tr>
		 <td align="center">名：</td>
		 <td> <input  name="admin_name" value="<%=u.getName()%>" /></td>
		</tr>
		<tr>
		 <td align="center">用户名 ：</td>
		 <td><input  name="sname" id="sname" value="<%=u.getUser_name()%>"/></td>
		</tr>
		<tr>
		 <td align="center">密码: </td>
		 <td><input  name="admin_password" type="password" value="<%=u.getPassword()%>"/></td>
		</tr>
		<tr>
		 <td align="center">邮箱：</td>
		 <td> <input  name="admin_email" value="<%=u.getEmail()%>"/></td>
		</tr>
		<tr>
		 <td align="center">性别：</td>
		 <td> <input type="radio"  name="admin_sex" checked="checked" value="<%=u.getSex()%> "/></td>
		</tr>
		<tr>
		 <td align="center">照片：</td>
		 <td> <input  name="admin_photo" value="<%=u.getPhoto()%>"/></td>
		</tr>
		<tr>
		 <td align="center">爱好：</td>
		 <td><input  name="admin_enjoy" value="<%=u.getEnjoy()%>"/></td>
		</tr>
		<tr>
		 <td align="center">出生日期：</td>
		 <td><input  name="admin_birth" value="<%=u.getBirth_date()%>"/></td>
		</tr>
		<tr>
		 <td align="center">权限：</td>
		 <td><input  name="flag" value="<%=u.getFlag()%>"/> </td>
		</tr>
		<tr>
		 <td colspan="2" align="center"><input  type="submit" value="修改"/></td>
		</tr>--></table>
	</form>
</body>
</html>