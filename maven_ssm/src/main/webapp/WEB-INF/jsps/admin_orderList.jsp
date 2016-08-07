<%@page import="com.zrgk.entity.Goods"%>
<%@page import="java.util.List"%>
<%@page import="com.zrgk.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
<style type="text/css">
.s7{
		background-color: #EEEEEE;
	}
	.s5{
		background-color:#DDDDDD;
	}
	.s4{
		background-color:#66CCFF;
	}
	
	
	a:visited{
	text-decoration: underline;
	font-size: 12px;
	color: blue;
}
a:link{
	text-decoration: none;
	color: blue;
	font-size: 12px;
}
a:hover{
	text-decoration: underline;
	font-size: 12px;
	color: #AA4444;
}
</style>
<script type="text/javascript">
$(document).ready(function(){
 var $firstrow=$("tr:first");
 $firstrow.addClass("s4");
 $("tbody tr").mouseover(function(){
	 $(this).addClass("s5").siblings().removeClass("s5"); 
	});
});
function first(){
go(1);
}
function last(no){
go(no);
}
function before(no){
 go(no-1);;
}
 function after(no){
go(no+1);
}
function ensurego(){
var $no= $("#go").val();
if(isNaN($no)){
alert("请输入数字");
 $("#go").val("");
}else if($no==""){
  alert("请输入页码！");
}else{
var no=parseInt($no);
go(no);
}
}
function go(no){
$("#this_page").val(no);
document.f.submit();
}
</script>
</head>
<body>
<table style="width:100%;text-align:center;border:1px">
	<thead>
		<tr style="background-color:#99CCFF; font-size: 14px;">
			<th style=" display: none;">id</th>
			<th >订单编号</th>
			<th>买家id</th>
			<th >购买商品</th>
			<th >购买数量</th>
			<th >收件人</th>
			<th >收件地址</th>
			<th >联系电话</th>
			<th >总价</th>
			<th> 实付金额</th>
			<th>操作</th>
		</tr>	
		</thead>
		<tbody>
	<c:forEach items="${orders}" var="o" varStatus="i">
		<tr class="s7">
			<td style="display: none">${o.order_id}</td>
			<td>${o.order_nub}</td>
			<td>${o.buyer_id}</td>
			<td>${o.buy_goods}</td>
			<td>${o.buy_qutity}</td>
			<td>${o.receiver}</td>
			<td>${o.rec_add}</td>
			<td> ${o.rec_pho} </td>
			<td>${o.tol_pays}</td>
			<td>${o.acc_paid}</td>
			<td><a href="admin_orderDelete.do4?
			order_id=${o.order_id}" onclick="return confirm('确认要删除吗？');"><font size="3px">删除</font></a><br/><a href="admin_orderLoad.do4?order_id=${o.order_id}"><font size="3px">修改</font></a></td>
		</tr>
	</c:forEach>
		
	</tbody>
	</table>
	<c:if test="${order_p==null}" var="page3">
	<font color="gray" size="2px">首页</font>&nbsp;
</c:if>

<c:if test="${!page3}">
	<a href=# onclick="first();">首页</a>&nbsp;
</c:if>


<c:if test="${order_p.currPage==1}" var="page1">
	<font color="gray" size="2px">上一页</font>&nbsp;
</c:if>
<c:if test="${!page1}">
	<a href=# onclick="before(${order_p.currPage});">上一页</a>&nbsp;
</c:if>

第${order_p.currPage}页/共${order_p.tolPage}页
<c:if test="${order_p.currPage==order_p.tolPage}" var="page2">
	<font color="gray" size="2px">下一页</font>&nbsp;
</c:if>
<c:if test="${!page2}">
	<a href="javascript:;" onclick="after(${order_p.currPage});">下一页</a>&nbsp;
</c:if>
<c:if test="${order_p==null}" var="page4">
	<font color="gray" size="2px">尾页</font>&nbsp;
</c:if>

<c:if test="${!page4}">
	<a href=# onclick="last(${order_p.tolPage});">尾页</a>&nbsp;
</c:if>



<input type="text" value="" id="go" size="2"  /><a href="javascript:;" onclick="ensurego();">go</a>

<input type="button" value="导出" style="position: absolute;right: 20px;width: 70px;height: 30px"  onclick="location='goodsOrderexcel.exl';"/><br/>




	<form action="admin_orderList.do4" method="post" name="f">
		<input type="hidden" name="this_page" id="this_page" value="${order_p.currPage}"/>
	</form>
</body>
</html>