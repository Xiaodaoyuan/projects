<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户</title>
<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
<script type="text/javascript" >
	function checkGname() {
	
	if($("#gname").val()==""){
	  $("#gname_msg").html("商品名不能为空！");
		$("#gname_msg").css({
			color : "red"
		});
		return false;
	}

	return true;
}


</script></head>
<body>
<form  action="admin_addAd.do1"  method="post" onsubmit="" enctype="multipart/form-data">
                   
		<!--id取默认自增-->
		<table><tr>
		 <td align="center">广告分区:</td>
		 <td> <select name="sele">
		 <option selected="selected" value="疯狂抢购">疯狂抢购</option>
		 <option value="新品上架">新品上架</option>
		 <option value="公告栏">公告栏</option>
		 <option value="滚动广告">滚动广告</option>
		 </select></td>
		</tr>
		<tr>
		 <td align="right">商品id:</td>
		 <td><input  name="gid" id="gid" value="${param.goods_id }" readonly /></td>
		</tr>
		<tr>
		 <td align="right">商品广告名:</td>
		 <td><input type="text" name="gname" id="gname" onblur="checkGname();"/><span id="gname_msg"></span></td>
		</tr>
		<tr>
		 <td align="right">图片:</td>
		 <td> <input type="file" name="pic" /></td>
		</tr>
		<tr>
		 <td align="right"><input  type="submit" value="添加"/></td>
		 <td ><input  type="reset" value="重置"/></td>
		</tr></table>
	</form>
</body>
</html>