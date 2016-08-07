
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
.s4{
		background-color: #EEEEEE;
	}
.s3{
		background-color: #CCCCCC;
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
</style>
<script type="text/javascript">
var namearr=new Array();
namearr[1]="id";
namearr[2]="familyname";
namearr[3]="name";
namearr[4]="username";
namearr[5]="password";
namearr[6]="email";
namearr[7]="sex";
namearr[8]="photo";
namearr[9]="enjoy";
namearr[10]="birthdate";
namearr[11]="flag";
var namestr = new Array();
namestr[1]="id";
namestr[2]="姓";
namestr[3]="名";
namestr[4]="用户名";
namestr[5]="密码";
namestr[6]="邮箱";
namestr[7]="性别";
namestr[8]="照片";
namestr[9]="爱好";
namestr[10]="生日";
namestr[11]="权限";
$(document).ready(function(){
var $even=$("tbody tr:nth-child(even)");
 $even.addClass("s2");
 
//var $odd=$("tbody tr:odd");
var $odd=$("tbody tr:nth-child(odd)");
 $odd.addClass("s1");

 var $admin=$("tr:contains('管理员')");
//$obj.addClass("s3");
$admin.toggleClass("s3");
 
 var $firstcol=$("tr td:first-child");
 $firstcol.addClass("s4");
 

 $("tbody tr").mouseover(function(){
	 $(this).addClass("s5").siblings().removeClass("s5"); 
	});
	$("td").bind("dblclick",clickcell);
	$("th").bind("dblclick",clickth );
	

});

function clickth(){
	
	var tr_tharr=$(this).parent().children();
	var this_no=tr_tharr.index($(this)) ;
	if(this_no!=0 & this_no!=12){
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
			$(this).html("<select class='search'><option value='性别' selected='selected' >性别</option><option value='男'>男</option><option value='女'>女</option></select>");
		}else if(this_no==11){
			$(this).html("<select class='search'><option value='权限' selected='selected' >权限</option><option value='用户' >用户</option><option value='管理员'>管理员</option></select>");
		}else{
			$(this).html("<input type='text' value='"+str+"' class='search' />");
		}
		$(".search").bind("blur",onblurth);
		$(this).unbind();
	}
}


function clickcell(){
		
		var tr_tdarr=$(this).parent().children();
		var this_no=tr_tdarr.index($(this)) ;
		if(this_no!=0 & this_no!=12){
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
				$(this).html("<select class='modify'><option value='男' selected='selected' >男</option><option value='女'>女</option></select>");
			}else if(this_no==11){
				$(this).html("<select class='modify'><option value='用户' selected='selected' >用户</option><option value='管理员'>管理员</option></select>");
			}else if(this_no==8){
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
		if(i!=0 & i!=12){
			var str=$(this).html();
			$(this).html(str+"<input type='hidden' name='s"+namearr[i]+"' value='"+str+"' />");
		}
	});
	$("#ff").attr("action","usersearch.up");
	document.ff.submit();
}

function clickonblur(){
	var str=$(this).val();
	var tr_tdarr=$(this).parent().parent().children();
	var this_no=tr_tdarr.index($(this).parent());
	$(this).parent().bind("click",clickcell);
	if(this_no==8){
	$(this).parent().html("<img alt='' src='"+str+"'>");
	}else{
	$(this).parent().html(str);
	}
	tr_tdarr.each(function(i){
		if(i!=0 & i!=12){
			var str=$(this).html();
			if(i==8){
			$(this).html(str+"<input type='hidden' name='"+namearr[i]+"' value='"+$(this).children("img").attr("src")+"' />");
			}else{
			$(this).html(str+"<input type='hidden' name='"+namearr[i]+"' value='"+str+"' />");
			}
		}
	});

	$("th").each(function(i){
		if(i!=0 & i!=12){
			var str=$(this).html();
			$(this).html(str+"<input type='hidden' name='s"+namearr[i]+"' value='"+str+"' />");
		}
	});


document.ff.submit();
	
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
			str=str+$(this).parent().parent().children().eq(1).html()+":";
		}
	});
if(str!=""){
	location="userdelete.up?id="+str;
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

<form action="usermodify.up"  method="post" name="ff" id="ff">
	<table  style="width:100%; border:1px" >
	<thead>
		<tr class="s5" style="background-color:#99CCFF; font-size: 14px;">
			<th><a href=# onclick="selectall()">全选</a>/<a href=# onclick="select()">反选</a>/<a href=# onclick="unselectall()">全不选</a></th>
			
			<c:if test="${pastr[0]!=''}" var="th1">
				<th>${pastr[0]}</th>
			</c:if>
			<c:if test="${!th1}">
				<th>id</th>
			</c:if>
			<c:if test="${pastr[1]!=''}" var="th2">
				<th>${pastr[1]}</th>
			</c:if>
			
			<c:if test="${!th2}">
				<th>姓</th>
			</c:if>
			<c:if test="${pastr[2]!=''}" var="th3">
				<th>${pastr[2]}</th>
			</c:if>
			<c:if test="${!th3}">
				<th>名</th>
			</c:if>
			<c:if test="${pastr[3]!=''}" var="th4">
				<th>${pastr[3]}</th>
			</c:if>
			<c:if test="${!th4}">
				<th>用户名</th>
			</c:if>
			<c:if test="${pastr[4]!=''}" var="th5">
				<th>${pastr[4]}</th>
			</c:if>
			<c:if test="${!th5}">
				<th>密码</th>
			</c:if>
			<c:if test="${pastr[5]!=''}" var="th6">
				<th>${pastr[5]}</th>
			</c:if>
			<c:if test="${!th6}">
				<th>邮箱</th>
			</c:if>
			<c:if test="${pastr[6]!=''}" var="th7">
				<th>${pastr[6]}</th>
			</c:if>
			<c:if test="${!th7}">
				<th>性别</th>
			</c:if>
			<c:if test="${pastr[7]!=''}" var="th8">
				<th>${pastr[7]}</th>
			</c:if>
			<c:if test="${!th8}">
				<th>照片</th>
			</c:if>
			<c:if test="${pastr[8]!=''}" var="th9">
				<th>${pastr[8]}</th>
			</c:if>
			<c:if test="${!th9}">
				<th>爱好</th>
			</c:if>
			<c:if test="${pastr[9]!=''}" var="th10">
				<th>${pastr[9]}</th>
			</c:if>
			<c:if test="${!th10}">
				<th>出生日期</th>
			</c:if>
			<c:if test="${pastr[10]!=''}" var="th11">
				<th>${pastr[10]}</th>
			</c:if>
			<c:if test="${!th11}">
				<th>权限</th>
			</c:if>
			
			<th>操作</th>
			
		</tr>	
		</thead>
		<tbody>
	
	<c:forEach items="${users}" var="u" varStatus="i">
	<tr class="s4" >
		
			<td><input  type="checkbox"  /></td>
			<td>${u.id}</td>
			<td>${u.family_name}</td>
			<td>${u.name}</td>
			<td>${u.user_name}</td>
			<td>${u.password}</td>
			<td>${u.email}</td>
			<td>${u.sex}</td>
			<td><img alt=""  src="${u.photo}" width="50px" height="50px" ></td>
			<td>${u.enjoy}</td>
			<td>${u.birth_date}</td>
			<td>${u.flag}</td>
			<td><a href="admin_userDelete.do2?id=${u.id}" onclick="return confirm('确认要删除吗？');"><font size="3px">删除</font></a> <br/><a href="admin_userLoad.do2?id=${u.id}"><font size="3px">修改</font></a></td>
		
	</tr>
	</c:forEach>
	


	</tbody>
		<input type="hidden" name="this_page" class="this_page" value="${user_p.currPage}"/>
	</table>
</form>	
<c:if test="${user_p==null}" var="page3">
	<font color="gray" size="2px">首页</font>&nbsp;
</c:if>

<c:if test="${!page3}">
	<a href=# onclick="first();">首页</a>&nbsp;
</c:if>






<c:if test="${user_p.currPage==1}" var="page1">
	<font color="gray" size="2px">上一页</font>&nbsp;
</c:if>
<c:if test="${!page1}">
	<a href=# onclick="before(${user_p.currPage});">上一页</a>&nbsp;
</c:if>

第${user_p.currPage}页/共${user_p.tolPage}页
<c:if test="${user_p.currPage==user_p.tolPage}" var="page2">
	<font color="gray" size="2px">下一页</font>&nbsp;
</c:if>
<c:if test="${!page2}">
	<a href="javascript:;" onclick="after(${user_p.currPage});">下一页</a>&nbsp;
</c:if>
<c:if test="${user_p==null}" var="page4">
	<font color="gray" size="2px">尾页</font>&nbsp;
</c:if>

<c:if test="${!page4}">
	<a href=# onclick="last(${user_p.tolPage});">尾页</a>&nbsp;
</c:if>



<input type="text" value="" id="go" size="2"  /><a href="javascript:;" onclick="ensurego();">go</a>
<input type="button" value="导出" style="position: absolute;right: 20px;width: 70px;height: 30px"  onclick="location='userexcel.exl';"/><br/>
<a href=# onclick="deleteall();" style="color: red;font-size: 18px">删除当页选中</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="admin_addUser.jsp" style="font-size: 18px">添加用户</a><br/>
	<form action="admin_userList.do2" method="post" name="f">
		<input type="hidden" name="this_page" class="this_page" value="${user_p.currPage}"/>
	</form>
	
</body>
</html>
