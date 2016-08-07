<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加商品</title>
<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
<script type="text/javascript" >
function change(value){
  $.post('classify.do1',{'clf1':value},function(data){
    var arr=data.split(",");
    var html=[];
    for(var i=0;i<arr.length;i++){
    	var tt=arr[i];
    	var arr2=tt.split(":");
    	html.push("<option>"+arr2[0]+"</option>");
    }
    $("#s2").html(html.join(""));
  
  });
}
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
<form  action="admin_goodsAdd.do1"  method="post" onsubmit="return checkTrue();" enctype="multipart/form-data">
                   
		<!--id取默认自增-->
		<table>
		<tr>
		 <td align="center">商品：</td>
		 <td> <input  name="title" id="title" /></td>
		</tr>
		<tr>
		 <td align="center">物品类型：</td>
		 <td> <select name="type" id="type">
		 <option value="全新">全新</option>
		 <option value="二手">二手</option>
		 </select></td>
		</tr>
			<tr>
		 <td align="center">类别1:</td>
		 
		<td> <select id="s1" name="clf1"  onchange="change(this.value);">
<option value="-1" >--请选择--</option>
<option value="家用电器" >家用电器</option>
<option value="书籍">书籍</option>
<option value="手机数码">手机数码</option>
<option value="日用百货">日用百货</option>
</select></td>
		 
		<!--  <td><input  name="clf1" id="clf1" /></td> -->
		</tr>
			<tr>
		 <td align="center">类别2: </td>
		<td> <select id="s2" name="clf2">
</select></td>
		
		</tr>
		<tr>
		 <td align="center">描述：</td>
		 <td> <input  name="desc" id="desc" /></td>
		</tr>
		<tr>
		 <td align="center">图片：</td>
		 <td> <input type="file" name="pic" id="pic" /></td>
		</tr>
		<tr>
		 <td align="center">卖家id：</td>
		 <td> <input  name="saler_id" id="saler_id" onblur="checkSalerId()" /><span id="salerId_msg"></span></td>
		</tr>
		<tr>
		<tr>
		 <td align="center">价格：</td>
		 <td> <input  name="price" id="price" onblur="checkPrice()" /><span id="price_msg"></span></td>
		</tr>
		<tr>
		 <td align="center">折扣：</td>
		 <td> <input  name="discount" id="discount" value="10.0" onblur="checkDiscount()" /><span id="discount_msg"></span></td>
		</tr>
		<tr>
		 <td align="center">运费：</td>
		 <td> <input  name="fee" value="包邮" id="fee" onblur="checkFee()"/><span id="fee_msg"></span></td>
		</tr>
		<tr>
		 <td align="center">本期销量：</td>
		 <td> <input  name="this_num" id="this_num" value="0" onblur="checkthisNum()" /><span id="thisNum_msg"></span></td>
		</tr>
		<tr>
		 <td align="center">累计销量：</td>
		 <td> <input  name="total_num" id="total_num" value="0" onblur="checktotalNum()" /><span id="totalNum_msg"></span></td>
		</tr>
		<tr>
		 <td align="center">浏览量：</td>
		 <td> <input  name="view" id="view" value="0" onblur="checkView()" /><span id="view_msg"></span></td>
		</tr>
		<tr>
		<tr>
		 <td align="center">出售地：</td>
		 <td> <input  name="addr" id="addr" onblur="checkAddr()" /><span id="addr_msg"></span></td>
		</tr>
		<tr>
		 <td align="center">上架时间：</td>
		 <td> <input  name="start_time" id="start_time" onblur="checkstartTime()" /><span id="startTime_msg"></span>(形如：2012-12-01 11:11:11)</td>
		</tr>
		<tr>
		 <td align="center">在架时间：</td>
		 <td> <input  name="keep_time" id="keep_time" value="30" onblur="checkeepTime()" /><span id="keepTime_msg"></span>小时</td>
		</tr>
		<tr>
		<tr>
		 <td align="center"><input  type="submit" value="添加"/></td>
		 <td ><input  type="reset" value="重置"/></td>
		</tr></table>
	</form>
</body>
</html>