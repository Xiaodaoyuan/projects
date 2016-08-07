<%@page import="com.zrgk.entity.Goods"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改商品</title>
<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
<script type="text/javascript" >
function checkAddr() {
	var reg = /^([\u4E00-\u9FA5]){1,}$/;
	if (!reg.test($("#addr").val())) {
		$("#addr_msg").html("出售地必须是汉字形式！");
		$("#addr_msg").css({
			color : "red"
		});
		return false;
	}
	$("#addr_msg").html(
			"<img src='images/right.jpg' width='20px' height='20px'/>");
	return true;
}
	function checkSalerId() {
	var reg = /^\d+$/;
	//alert();
	if($("#saler_id").val()==""){
	  $("#salerId_msg").html("id不能为空！");
		$("#salerId_msg").css({
			color : "red"
		});
		return false;
	}
	
	if (!reg.test($("#saler_id").val())) {
		$("#salerId_msg").html("id格式不正确，只能由数字组成！");
		$("#salerId_msg").css({
			color : "red"
		});
		return false;
	}
	$("#salerId_msg").html(
			"<img src='images/right.jpg' width='20px' height='20px'/>");
	return true;
}

function checkthisNum() {
	var reg = /^\d+$/;
	//alert();
	if($("#this_num").val()==""){
	  $("#thisNum_msg").html("数量不能为空！");
		$("#thisNum_msg").css({
			color : "red"
		});
		return false;
	}
	
	if (!reg.test($("#this_num").val())) {
		$("#thisNum_msg").html("格式不正确，只能由数字组成！");
		$("#thisNum_msg").css({
			color : "red"
		});
		return false;
	}
	$("#thisNum_msg").html(
			"<img src='images/right.jpg' width='20px' height='20px'/>");
	return true;
}


function checkFee() {
	var reg1 = /^\u5305\u90ae$/;
	var reg2=/^\d+$/;
	//alert();
	if($("#fee").val()==""){
	  $("#fee_msg").html("运费不能为空！");
		$("#fee_msg").css({
			color : "red"
		});
		return false;
	}
	
	if (!(reg1.test($("#fee").val())||reg2.test($("#fee").val()))) {
		$("#fee_msg").html("格式不正确！");
		$("#fee_msg").css({
			color : "red"
		});
		return false;
	}
	$("#fee_msg").html(
			"<img src='images/right.jpg' width='20px' height='20px'/>");
	return true;
}

function checkPrice() {
	var reg = /^\d+.?\d+$/;
	//alert();
	if($("#price").val()==""){
	  $("#price_msg").html("价格不能为空！");
		$("#price_msg").css({
			color : "red"
		});
		return false;
	}
	
	if (!reg.test($("#price").val())) {
		$("#price_msg").html("格式不正确！");
		$("#price_msg").css({
			color : "red"
		});
		return false;
	}
	$("#price_msg").html(
			"<img src='images/right.jpg' width='20px' height='20px'/>");
	return true;
}
function checktotalNum() {
	var reg = /^\d+$/;
	//alert();
	if($("#total_num").val()==""){
	  $("#totalNum_msg").html("数量不能为空！");
		$("#totalNum_msg").css({
			color : "red"
		});
		return false;
	}
	
	if (!reg.test($("#total_num").val())) {
		$("#totalNum_msg").html("格式不正确，只能由数字组成！");
		$("#totalNum_msg").css({
			color : "red"
		});
		return false;
	}
	$("#totalNum_msg").html(
			"<img src='images/right.jpg' width='20px' height='20px'/>");
	return true;
}

function checkView() {
	var reg = /^\d+$/;
	//alert();
	if($("#view").val()==""){
	  $("#view_msg").html("数量不能为空！");
		$("#view_msg").css({
			color : "red"
		});
		return false;
	}
	
	if (!reg.test($("#view").val())) {
		$("#view_msg").html("格式不正确，只能由数字组成！");
		$("#view_msg").css({
			color : "red"
		});
		return false;
	}
	$("#view_msg").html(
			"<img src='images/right.jpg' width='20px' height='20px'/>");
	return true;
}

function checkDiscount() {
	var reg = /^\d+.?\d+$/;
	
	if($("#discount").val()==""){
	  $("#discount_msg").html("折扣不能为空！");
		$("#discount_msg").css({
			color : "red"
		});
		return false;
	}
	if (!reg.test($("#discount").val())) {
		$("#discount_msg").html("请输入正确的格式！");
		$("#discount_msg").css({
			color : "red"
		});
		return false;
	}
	$("#discount_msg").html(
			"<img src='images/right.jpg' width='20px' height='20px'/>");
	return true;
}
function checkstartTime() {
	var reg = /^\d{4}-\d{2}-\d{2}\s+\d{2}:\d{2}:\d{2}$/;
	
	if($("#start_time").val()==""){
	  $("#startTime_msg").html("上架时间不能为空！");
		$("#startTime_msg").css({
			color : "red"
		});
		return false;
	}
	if (!reg.test($("#start_time").val())) {
		$("#startTime_msg").html("请输入正确的格式！");
		$("#startTime_msg").css({
			color : "red"
		});
		return false;
	}
	$("#startTime_msg").html(
			"<img src='images/right.jpg' width='20px' height='20px'/>");
	return true;
}

function checkeepTime() {
//	$("#d1").html("");
if($("#keep_time").val()==""){
	  $("#keepTime_msg").html("请输入在架时间！");
		$("#keepTime_msg").css({
			color : "red"
		});
		return false;
	}

	var reg = /^\d+$/;
	if (!reg.test($("#keep_time").val())) {
		$("#keepTime_msg").html("格式不正确，只能由数字组成！");
		$("#keepTime_msg").css({
			color : "red"
		});
		return false;
	}
	$("#keepTime_msg").html(
			"<img src='images/right.jpg' width='20px' height='20px'/>");
	return true;
	}
	function checkTrue(){
 if(checkAddr()&checkSalerId()&checkthisNum()&checkFee()&checkPrice()&checktotalNum()&checkView()&checkDiscount()&checkstartTime()&checkeepTime())
 return true;
 return false;
}
</script></head>
<body>
<%
	String msg = (String)request.getAttribute("error");
	Goods g = (Goods)request.getAttribute("g");
	%>


<form  action="admin_goodsUpdate.do1?goods_id=<%=g.getGoods_id()%>"  method="post" onsubmit="return checkTrue()" enctype="multipart/form-data">
       <%=msg==null?"":msg%> 
       <img src="${g.picture }" style="position: absolute;left:290px;top:5px;width:200px;height:180px;"/>           
		<table><tr>
		 <td align="center">卖家id：</td>
		 <td> <input  name="saler_id" id="saler_id" onblur="checkSalerId()" value="<%=g.getSaler_id()%>"/><span id="salerId_msg"></span></td>
		</tr>
		<tr>
		 <td align="center">所属类别1:</td>
		 <td><input  name="clf1" id="clf1"  value="<%=g.getClassify_1() %>" readonly /></td>
		</tr>
		<tr>
		 <td align="center">所属类别2: </td>
		 <td><input  name="clf2" id="clf2" value="<%=g.getClassify_2() %>" readonly  /></td>
		</tr>
		<tr>
		 <td align="center">商品名：</td>
		 <td> <input  name="title" id="title" value="<%=g.getTitle() %>" /></td>
		</tr>
		<tr>
		 <td align="center">描述：</td>
		 <td> <input  name="desc" id="desc" value="<%=g.getDescription() %>" /></td>
		</tr>
		<tr>
		 <td align="center">图片：</td>
		 <td> <input type="file" name="pic" id="pic"  value="<%=g.getPicture() %>"/></td>
		</tr>
		<tr>
		<tr>
		 <td align="center">价格：</td>
		 <td> <input  name="price" id="price" onblur="checkPrice()" value="<%=g.getPrice() %>"/><span id="price_msg"></span></td>
		</tr>
		<tr>
		 <td align="center">运费：</td>
		 <td> <input  name="fee"  id="fee" onblur="checkFee()" value="<%=g.getTrsptat_pay() %>"/><span id="fee_msg"></span></td>
		</tr>
		<tr>
		 <td align="center">本期售出量：</td>
		 <td> <input  name="this_num" id="this_num" onblur="checkthisNum()" value="<%=g.getCurr_sal_nub() %>" /><span id="thisNum_msg"></span></td>
		</tr>
		<tr>
		 <td align="center">累计售出量：</td>
		 <td> <input  name="total_num" id="total_num" onblur="checktotalNum()" value="<%=g.getTol_sal_nub() %>" /><span id="totalNum_msg"></span></td>
		</tr>
		<tr>
		 <td align="center">浏览量：</td>
		 <td> <input  name="view" id="view" onblur="checkView()" value="<%=g.getPage_view() %>"/><span id="view_msg"></span></td>
		</tr>
		<tr>
		<tr>
		 <td align="center">出售地：</td>
		 <td> <input  name="addr" id="addr" onblur="checkAddr()" value="<%=g.getGoods_addr()%>" /><span id="addr_msg"></span></td>
		</tr>
		<tr>
		 <td align="center">商品类型：</td>
		 <td> <input  name="type" id="type" value="<%=g.getGoods_type()%>"/></td>
		</tr>
		<tr>
		<tr>
		 <td align="center">折扣：</td>
		 <td> <input  name="discount" id="discount" onblur="checkDiscount()" value="<%=g.getDiscount()%>" /><span id="discount_msg"></span></td>
		</tr>
		<tr>
		<tr>
		 <td align="center">上架时间：</td>
		 <td> <input  name="start_time" id="start_time" onblur="checkstartTime()" value="${sellstart}"/><span id="startTime_msg"></span>(形如：2012-12-01 11:11:11)</td>
		</tr>
		<tr>
		 <td align="center">上架持续时间：</td>
		 <td> <input  name="keep_time" id="keep_time"  onblur="checkeepTime()" value="<%=g.getSell_time()%>"/><span id="keepTime_msg"></span>小时</td>
		</tr>
		<tr>
		
		<tr>
		 <td align="center"><input  type="submit" value="修改"/></td>
		
		</tr></table>
	</form>
</body>
</html>