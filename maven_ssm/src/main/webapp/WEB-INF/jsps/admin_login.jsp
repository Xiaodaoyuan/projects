<%@page import="com.zrgk.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"
     %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台登陆</title>
<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="js/admin_check.js"></script>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background_color:#1D3647;
	
}
-->

</style>
<script type="text/javascript">
function f(){

 var a=document.getElementById("image");

 a.src="admin_checkcode?dt="+Math.random();
}

</script>


<link href="css_admin/skin.css" rel="stylesheet" type="text/css"><link rel="stylesheet" href="css/layout.css" type="text/css"></link>

</head>
<body>
<table width="100%" height="166" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td height="42" valign="top"><table width="100%" height="42" border="0" cellpadding="0" cellspacing="0" class="login_top_bg">
      <tr>
        <td width="1%" height="21">&nbsp;</td>
        <td height="42">&nbsp;</td>
        <td width="17%">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td valign="top"><table width="100%" height="532" border="0" cellpadding="0" cellspacing="0" class="login_bg">
      <tr>
        <td width="49%" align="right"><table width="91%" height="532" border="0" cellpadding="0" cellspacing="0" class="login_bg2">
            <tr>
              <td height="138" valign="top"><table width="89%" height="427" border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td height="149">&nbsp;</td>
                </tr>
               
                <tr>
                  <td height="198" align="right" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="35%">&nbsp;</td>
                      <td width="65%" height="25" class="left_txt"><img src="images_admin/login.jpg" width="500" height="300"></td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                      <td height="25" class="left_txt"><p>&nbsp;</p></td>
                    </tr>
                  </table></td>
                </tr>
              </table></td>
            </tr>
            
        </table></td>
        <td width="1%" >&nbsp;</td>
        <td width="50%" valign="bottom"><table width="100%" height="59" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
              <td width="4%">&nbsp;</td>
              <td width="96%" height="38"></td>
            </tr>
            <tr>
              <td>&nbsp;</td>
              <td height="21"><table cellSpacing="0" cellPadding="0" width="100%" border="0" id="table211" height="328">
                  <tr>
                    <td height="164" colspan="2" align="middle">
                        <form name="myform" action="submit2.dologin" method="post" onsubmit="return checkTrue();">
                    <input type="hidden" id="h1" /><input type="hidden" id="h2" /><input type="hidden" id="h3" />
                        <table cellSpacing="0" cellPadding="0" width="100%" border="0" height="143" id="table212">
                          <tr>
                            <td width="13%" height="38" class="top_hui_text"><span class="login_txt">用户名：&nbsp;&nbsp; </span></td>
                            <td height="38" colspan="2" class="top_hui_text"><input name="admin_username" id="admin_username" class="editbox4" value="" size="20"onfocus="updateRed('admin_username')" onblur="checkAdmin_name()" /><span id="admin_name_msg"></span></td>
                          </tr>
                          <tr>
                            <td width="13%" height="35" class="top_hui_text" ><span class="login_txt"> 密 码： &nbsp;&nbsp; </span></td>
                            <td height="35" colspan="2" class="top_hui_text"><input class="editbox4" id="admin_password" type="password" size="20" name="admin_password" onfocus="updateRed('admin_password')" onblur="checkAdmin_password()"/><span id="admin_password_msg"></span>	         
                          </tr>
                          <tr>
                            <td width="13%" height="35" ><span class="login_txt">验证码：</span></td>
                            <td height="35" colspan="2" class="top_hui_text"><input class="wenbenkuang" name="vericode" id="vericode" onfocus="updateRed('vericode')" type="text" onblur="checkCode();"><img src="admin_checkcode" id="image"/>
<a href="javascript:;" id="a" onclick="f();">看不清，换一个</a><span id="code_msg"></span></td>
                          </tr>
                          <tr>
                            <td height="35" >&nbsp;</td>
                            <td width="20%" height="35" ><input name="dl" type="submit"  id="dl" value="登 陆" /> </td>
                            <td width="67%" class="top_hui_text"><input name="zc" type="reset"  id="zc" /></td>
                          </tr>
                        </table>
                        <br>
                    </form></td>
                  </tr>
                  <tr>
                    <td width="433" height="164" align="right" valign="bottom"><img src="images_admin/login-wel.gif" width="242" height="138"></td>
                    <td width="57" align="right" valign="bottom">&nbsp;</td>
                  </tr>
              </table></td>
            </tr>
          </table>
          </td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="20"><table width="100%" border="0" cellspacing="0" cellpadding="0" class="login-buttom-bg">
      <tr>
        <td align="center"><span class="login-buttom-txt">&copy;商城管理系统</span></td>
      </tr>
    </table></td>
  </tr>
</table>


</body>
</html>