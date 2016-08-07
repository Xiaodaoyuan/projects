<%@page import="com.zrgk.entity.Goods"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
<script type="text/javascript">

function call(){
  window.location="/guimeishoping/admin_adList.do3";
}
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
//alert($no);
if(isNaN($no)){
alert("请输入数字");
 $("#go").val("");
}else if($no==""){
  alert("请输入页码！");
}
else{
var no=parseInt($no);
go(no);
}
}
function go(no){
$("#this_page").val(no);
document.f.submit();
}
</script>
<style type="text/css">
	.s4{
		background-color: #EEEEEE;
	}
	.s5{
		background-color: #DDDDDD;
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
 $(function(){
    $("tbody tr").mouseover(function(){
   // alert("dd");
	  $(this).addClass("s5").siblings().removeClass("s5"); 
	
	});
 
 
 });
</script>
<body>
	<table style="width:100%;text-align:center;border:1px"><thead>
		<tr style="background-color: #99CCFF; font-size: 14px;">
		<th style="display: none">广告id</th>
		<th>广告分区</th>
		<th>商品id</th>
		<th>商品描述</th>
		<th>备选图片</th>
		<th>操作</th>
		</tr>
		</thead>
		<tbody>
		 <c:forEach items="${ads}" var="a" varStatus="i">
		 <tr class="s4">
		 <td style="display: none">${a.ad_id}</td>
		 <td>${a.ad_name}</td>
		 <td>${a.goods_id}</td>
		 <td>${a.goods_name}</td>
		 <td><img alt=""src="${a.en_pic}" width="50px" height="50px" ></td>
		 <td><a href="admin_adDelete.do3?id=${a.ad_id}" onclick="return confirm('确认要移除吗？');"><font size="3px">移除</font></a></td>
		</tr>
		 </c:forEach>
		</tbody>
		</table>

<c:if test="${ads_p==null}" var="page3">
	<font color="gray" size="2px">首页</font>&nbsp;
</c:if>

<c:if test="${!page3}">
	<a href=# onclick="first();">首页</a>&nbsp;
</c:if>

<c:if test="${ads_p.currPage==1}" var="page1">
	<font color="gray" size="2px">上一页</font>&nbsp;
</c:if>
<c:if test="${!page1}">
	<a href=# onclick="before(${ads_p.currPage});">上一页</a>&nbsp;
</c:if>

第${ads_p.currPage}页/共${ads_p.tolPage}页
<c:if test="${ads_p.currPage==ads_p.tolPage}" var="page2">
	<font color="gray" size="2px">下一页</font>&nbsp;
</c:if>
<c:if test="${!page2}">
	<a href="javascript:;" onclick="after(${ads_p.currPage});">下一页</a>&nbsp;
</c:if>
<c:if test="${ads_p==null}" var="page4">
	<font color="gray" size="2px">尾页</font>&nbsp;
</c:if>

<c:if test="${!page4}">
	<a href=# onclick="last(${ads_p.tolPage});">尾页</a>&nbsp;
</c:if>
<input type="text" value="" id="go" size="2"  /><a href="javascript:;" onclick="ensurego();">go</a>
<input type="button" value="导出" style="position: absolute;right: 20px;width: 70px;height: 30px"  onclick="location='adexcel.exl';"/><br/>
	<form action="admin_adList.do3" method="post" name="f">
		<input type="hidden" name="this_page" id="this_page" value="${ads_p.currPage}"/>
	</form>
	

	
</body>
</html>