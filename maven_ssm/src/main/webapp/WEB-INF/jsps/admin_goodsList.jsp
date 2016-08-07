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
tr td{

left:5px;
right:5px;
width:50px;
height:30px;
border-bottom:1px red silver ;

}
.s3{
		background-color: #001133;
	}
	.s4{
		background-color: #EEEEEE;
	}
	.s5{
		background-color: #DDDDDD;
	}
.modify{
	width: 70px; height: 35px; border: 0px white silver ; color: #333333;font-size: 17px;
}
.search{
	width: 70px; height: 35px; border: 0px white silver ; color: #333333;font-size: 17px;
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
var namearr=new Array();
namearr[1]="goods_id";
namearr[2]="saler_id";
namearr[3]="classify_1";
namearr[4]="classify_2";
namearr[5]="title";
namearr[6]="description";
namearr[7]="picture";
namearr[8]="price";
namearr[9]="trsptat_pay";
namearr[10]="curr_sal_nub";
namearr[11]="tol_sal_nub";
namearr[12]="page_view";
namearr[13]="goods_addr";
namearr[14]="goods_type";
namearr[15]="discount";
namearr[16]="sell_star";
namearr[17]="sell_time";

$(document).ready(function(){

 $("tbody tr").mouseover(function(){
	 //  $(this).addClass("s").$(":radio").attr("checked",true);  
	 $(this).addClass("s5").siblings().removeClass("s5"); 
	//  $(this).find(":radio").attr("checked",true);
	});
	
$("td").bind("dblclick",clickcell);
$("th").bind("dblclick",clickth );
	
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
}

else{
var no=parseInt($no);
go(no);
}


}




function go(no){

$(".this_page").val(no);
document.f.submit();


}

function clickth(){
		

	var tr_tharr=$(this).parent().children();
	var this_no=tr_tharr.index($(this)) ;
	if(this_no!=0 & this_no!=18){
		var $thtxt = $("th").children(":input");
		var $th= $thtxt.parent();
		$th.html($thtxt.val());
		$th.bind("dblclick",clickth);
		var $tdtxt = $("td").children(":input");
		var $td= $tdtxt.parent();
		$td.html($tdtxt.val());
		$td.bind("dblclick",clickcell);
		var str= $(this).html();
		$(this).html("<input type='text' value='"+str+"' class='search' />");
		$(".search").bind("blur",onblurth);
		$(this).unbind();
	}
}


function clickcell(){
		
		var tr_tdarr=$(this).parent().children();
		var this_no=tr_tdarr.index($(this)) ;
		if(this_no!=0 & this_no!=18){
			var $thtxt = $("th").children(":input");
		var $th= $thtxt.parent();
		$th.html($thtxt.val());
		$th.bind("dblclick",clickth);
		var $tdtxt = $("td").children(":input");
		var $td= $tdtxt.parent();
		$td.html($tdtxt.val());
		$td.bind("dblclick",clickcell);
			var str= $(this).html();
			if(this_no==7){
				$(this).html("<input type='text' value='"+$(this).children("img").attr("src")+"' class='modify' />");
			}else{
				$(this).html("<input type='text' value='"+str+"' class='modify' />");
			}
			$(".modify").bind("blur",clickonblur);
			$(this).unbind();
		}
		
}

function onblurth(){
	var str=$(this).val();
	var tr_tharr=$(this).parent().parent().children();
	var this_no=tr_tharr.index($(this).parent());
	$(this).parent().bind("click",clickth);
	$(this).parent().html(str);
	tr_tharr.each(function(i){
		if(i!=0 & i!=18){
			var str=$(this).html();
			$(this).html(str+"<input type='hidden' name='s"+namearr[i]+"' value='"+str+"' />");
		}
	});
	$("#ff").attr("action","goodssearch.up");
	
	document.ff.submit();
}

function clickonblur(){
	var str=$(this).val();
	var tr_tdarr=$(this).parent().parent().children();
	var this_no=tr_tdarr.index($(this).parent());
	$(this).parent().bind("click",clickcell);
	if(this_no==7){
	$(this).parent().html("<img alt='' src='"+str+"'>");
	}else{
	$(this).parent().html(str);
	}
	tr_tdarr.each(function(i){
		if(i!=0 & i!=18){
			var str=$(this).html();
			if(i==7){
			$(this).html(str+"<input type='hidden' name='"+namearr[i]+"' value='"+$(this).children("img").attr("src")+"' />");
			}else{
			$(this).html(str+"<input type='hidden' name='"+namearr[i]+"' value='"+str+"' />");
			}
		}
	});

	$("th").each(function(i){
		if(i!=0 & i!=18){
			var str=$(this).html();
			$(this).html(str+"<input type='hidden' name='s"+namearr[i]+"' value='"+str+"' />");
		}
	});


document.ff.submit();
	
}

function selectall(){
	$(":checkbox").attr("checked",true);
}

function unselectall(){
	$(":checkbox").attr("checked",false);
}

function select(){
	for(i=0;i<$(":checkbox").length;i++){
		if($(":checkbox").eq(i).attr("checked")!="checked"){
			$(":checkbox").eq(i).attr("checked",true);
		}else{
			$(":checkbox").eq(i).attr("checked",false);
		}
	}
}

function deleteall(){

var str="";
	$(":checkbox").each(function(i){
		
		if($(this).attr("checked")=="checked"){
			str=str+$(this).parent().parent().children().eq(1).html()+"|";
		}
	});
if(str!=""){
	location="goodsdelete.up?id="+str;
}else{
	alert("请先选择！");
}

}



</script><!--

 <script type="text/javascript">
	function add(){
		window.location="/guimeishoping/admin_addUser.jsp";
	}
</script> 

</head>
<body>
	<!-- 遍历users集合 -->
<form action="goodsmodify.up" method="post" name ="ff" id="ff">
	<table  style="width:100%;text-align:center;border:1px"  >
	<thead>
		<tr class="s5" style="background-color: #99CCFF; font-size: 14px;">
		<th><a href=# onclick="selectall()">全选</a>/<a href=# onclick="select()">反选</a>/<a href=# onclick="unselectall()">全不选</a></th>
			<c:forEach items="${pastr}" var="pa" varStatus="i">
			
				<c:if test="${pa!=''}" var="panull">
					<th>${pa}</th>
				</c:if>
				<c:if test="${!panull}">
					<th>${nv[i.count-1]}</th>
				</c:if>
				
			</c:forEach>
			<th style="width:50px;">操作</th>
			
		</tr>	
		</thead>
		<tbody>
	
	
	<c:forEach items="${goods}" var="g" varStatus="i">
		
		<tr class="s4" >
			
			<td> <input type="checkbox" > </td>
			<td >${g.goods_id}</td>
			<td>${g.saler_id}</td>
			<td>${g.classify_1}</td>
			<td>${g.classify_2}</td>
			<td>${g.title}</td>
			<td>${g.description}</td>
			<td><img alt=""  src="${g.picture}" width="50px" height="50px" >  </td>
			<td>${g.price}</td>
			<td>${g.trsptat_pay}</td>
			<td>${g.curr_sal_nub}</td>
			<td>${g.tol_sal_nub}</td>
			<td>${g.page_view}</td>
			<td>${g.goods_addr}</td>
			<td>${g.goods_type}</td>
			<td>${g.discount}</td>
			<td>${g.sell_star}</td>
			<td>${g.sell_time}</td>
			
			<td><a href="admin_goodsDelete.do1?

			goods_id=${g.goods_id}" onclick="return confirm('确认要删除吗？');">删除</a> <br/><br/><a href="admin_goodsLoad.do1?goods_id=${g.goods_id}">修改</a>
			 <br/><br/><a href="admin_addAd.jsp?goods_id=${g.goods_id}">添加为广告商品</a></td>
		</tr>
	</c:forEach>
		<input type="hidden" name="this_page" class="this_page" value="${goods_p.currPage}"/>
	</tbody>
	</table>
</form>
	<c:if test="${goods_p==null}" var="page3">
	<font color="gray" size="2px">首页</font>&nbsp;
</c:if>

<c:if test="${!page3}">
	<a href=# onclick="first();">首页</a>&nbsp;
</c:if>






<c:if test="${goods_p.currPage==1}" var="page1">
	<font color="gray" size="2px">上一页</font>&nbsp;
</c:if>
<c:if test="${!page1}">
	<a href=# onclick="before(${goods_p.currPage});">上一页</a>&nbsp;
</c:if>

第${goods_p.currPage}页/共${goods_p.tolPage}页
<c:if test="${goods_p.currPage==goods_p.tolPage}" var="page2">
	<font color="gray" size="2px">下一页</font>&nbsp;
</c:if>
<c:if test="${!page2}">
	<a href="javascript:;" onclick="after(${goods_p.currPage});">下一页</a>&nbsp;
</c:if>
<c:if test="${goods_p==null}" var="page4">
	<font color="gray" size="2px">尾页</font>&nbsp;
</c:if>

<c:if test="${!page4}">
	<a href=# onclick="last(${goods_p.tolPage});">尾页</a>&nbsp;
</c:if>



<input type="text" value="" id="go" size="2"  /><a href="javascript:;" onclick="ensurego();">go</a> 
<input type="button" value="导出" style="position: absolute;right: 20px;width: 70px;height: 30px"  onclick="location='goodsexcel.exl';"/><br/>
<a href=# onclick="deleteall();" style="color: red;font-size: 18px">删除当页选中</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="admin_addGoods.jsp" style="font-size: 18px" >添加商品</a>
		
			
	<form action="admin_goodsList.do1" method="post" name="f">
		<input type="hidden" name="this_page" class="this_page" value="${goods_p.currPage}"/>
	</form>
</body>
</html>