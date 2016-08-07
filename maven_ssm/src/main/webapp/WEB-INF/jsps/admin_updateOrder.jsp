<%@page import="com.zrgk.entity.Goods_order"%>
<%@page import="com.zrgk.entity.Goods"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改订单</title>
<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
<script type="text/javascript" >

/* function checkNub() {
	var reg = /^\w+$/;
	//alert();
	if($("#nub").val()==""){
	  $("#nub_msg").html("订单号不能为空！");
		$("#nub_msg").css({
			color : "red"
		});
		return false;
	} */
	
/* 	if (!reg.test($("#nub").val())) {
		$("#nub_msg").html("格式不正确,只能由字母和数字组成！");
		$("#nub_msg").css({
			color : "red"
		});
		return false;
	}
	$("#nub_msg").html(
			"<img src='images/right.jpg' width='20px' height='20px'/>");
	return true;
}
 */

function checkPerson(){
	if($("#person").val()==""){
	  $("#person").html("收件人不能为空！");
		$("#person_msg").css({
			color : "red"
		});
		return false;
	}
	
	$("#person_msg").html(
			"<img src='images/right.jpg' width='20px' height='20px'/>");
	return true;
}

function checkAddr(){
	if($("#addr").val()==""){
	  $("#addr").html("收件地址不能为空！");
		$("#addr_msg").css({
			color : "red"
		});
		return false;
	}
	
	$("#addr_msg").html(
			"<img src='images/right.jpg' width='20px' height='20px'/>");
	return true;
}
function checkPhone(){
	if($("#phone").val()==""){
	  $("#phone").html("联系电话不能为空！");
		$("#phone_msg").css({
			color : "red"
		});
		return false;
	}
	
	$("#phone_msg").html(
			"<img src='images/right.jpg' width='20px' height='20px'/>");
	return true;
}

function checkTol() {
	var reg = /^\d+.?\d+$/;
	//alert();
	if($("#tol").val()==""){
	  $("#tol_msg").html("总价不能为空！");
		$("#tol_msg").css({
			color : "red"
		});
		return false;
	}
	
	if (!reg.test($("#tol").val())) {
		$("#tol_msg").html("格式不正确！");
		$("#tol_msg").css({
			color : "red"
		});
		return false;
	}
	$("#tol_msg").html(
			"<img src='images/right.jpg' width='20px' height='20px'/>");
	return true;
}

function checkPaid() {
	var reg = /^\d+.?\d+$/;
	//alert();
	if($("#paid").val()==""){
	  $("#paid_msg").html("实付金额不能为空！");
		$("#paid_msg").css({
			color : "red"
		});
		return false;
	}
	
	if (!reg.test($("#paid").val())) {
		$("#paid_msg").html("格式不正确！");
		$("#paid_msg").css({
			color : "red"
		});
		return false;
	}
	$("#paid_msg").html(
			"<img src='images/right.jpg' width='20px' height='20px'/>");
	return true;
}


function checkQuti() {
	var reg = /^(\d+\|)+$/;
	//alert();
	if($("#quti").val()==""){
	  $("#quti_msg").html("数量不能为空！");
		$("#quti_msg").css({
			color : "red"
		});
		return false;
	}
	
	if (!reg.test($("#quti").val())) {
		$("#quti_msg").html("格式不正确！");
		$("#quti_msg").css({
			color : "red"
		});
		return false;
	}
	$("#quti_msg").html(
			"<img src='images/right.jpg' width='20px' height='20px'/>");
	return true;
}

	function checkTrue(){
	
 if(checkAddr()&checkQuti()&checkTol()&checkPaid()&checkPerson()&checkPhone())
 return true;
 return false;
}
</script></head>
<body>
<%
	String msg = (String)request.getAttribute("error");
	Goods_order o = (Goods_order)request.getAttribute("order");
	%>

<form  action="admin_orderUpdate.do4"  method="post" onsubmit="return checkTrue()" >
       <%=msg==null?"":msg%>            
		<table>
		<tr>
		<td align="center"  style="display: none">订单号：</td>
		 <td> <input  name="order_id" id="order_id"value="<%=o.getOrder_id() %>" style="display: none"/></td>
		</tr>
		<tr>
		 <td align="center">订单编号：</td>
		 <td> <input  name="nub" id="nub"value="<%=o.getOrder_nub() %>" readonly/></td>
		</tr>
		<tr>
		 <td align="center">买家id:</td>
		 <td><input  name="buyer_id" id="buyer_id"  value="<%=o.getBuyer_id() %>" readonly /><span id="buyer_msg"></span></td>
		</tr>
		<tr>
		 <td align="center">购买商品: </td>
		 <td><input name="goods" id="goods" value="<%=o.getBuy_goods() %>"  /></td>
		</tr>
		<tr>
		 <td align="center">购买数量：</td>
		 <td> <input  name="quti" id="quti" value="<%=o.getBuy_qutity() %>" onblur="checkQuti();"/><span id="quti_msg"></span>形如:3|4|5|</td>
		</tr>
		<tr>
		 <td align="center">收件人：</td>
		 <td> <input  name="person" id="person" value="<%=o.getReceiver() %>" onclick="checkPerson();" /><span id="person_msg"></span></td>
		</tr>
		<tr>
		 <td align="center">收件地址：</td>
		 <td> <input  name="addr" id="addr"  value="<%=o.getRec_add() %>" onclick="checkAddr();" /><span id="addr_msg"></span></td>
		</tr>
		<tr>
		<tr>
		 <td align="center">联系电话：</td>
		 <td> <input  name="phone" id="phone" onblur="checkPhone()" value="<%=o.getRec_pho() %>"/><span id="phone_msg"></span></td>
		</tr>
		<tr>
		 <td align="center">总价：</td>
		 <td> <input  name="tol" value="<%=o.getTol_pays() %>" id="tol" onblur="checkTol()" /><span id="tol_msg"></span></td>
		</tr>
		<tr>
		 <td align="center">实付金额：</td>
		 <td> <input  name="paid" id="paid" value="<%=o.getAcc_paid() %>" onblur="checkPaid()" /><span id="paid_msg"></span></td>
		</tr>
		<tr>
		 <td align="center"><input  type="submit" value="修改"/></td>
		
		</tr></table>
	</form>
</body>
</html>