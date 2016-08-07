<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.zrgk.servlet.*"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html	xmlns="http://www.w3.org/1999/xhtml">
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <title>贵美商城-商品分类页</title>
 <link rel="stylesheet"	type="text/css"	href="css/global.css"	/>
 <link rel="stylesheet"	type="text/css"	href="css/layout.css"	/>
 <script type="text/JavaScript" defer="true">
 function change(){
	var oImg=document.getElementById("show").getElementsByTagName("img");
	for(var i=1;i<=(oImg.length-3);i++){
		oImg[i].onmouseover=function(){
		oImg[0].src=this.src.replace('.jpg','_big.jpg');
			this.style.border='2px #ff7300 solid';}
		oImg[i].onmouseout=function(){this.style.border='2px #ccc solid';}
 	}
 }
 
 </script>
 <script type="text/javascript">
 
	
 </script>
 
</head>
<body>
<div id="container">
	<iframe id="header" runat="server" src="header.jsp" width="980" height="136" frameborder="0" scrolling="no"></iframe>
	<div class="good">
		<h1>${g.title }&nbsp;&nbsp;${g.description}</h1>
		<ul class="f_l" id="show">
			<li class="bigimg"><a href="yanzheng.y?goods_id=${g.goods_id }"><img src="${g.picture }" width="300px" height="220px" alt="笔记本大图" /></a></li>
		    <li class="smallimg"><img src="${g.picture }"width="60px" height="40px" alt="小图1" /></li>
			<li class="op clear f_l"><a href="#"><img src="images/share.gif" alt="分享" /></a></li>
			<li class="op f_l"><a href="#"><img src="images/favthis.gif" alt="藏" /></a></li>			
		</ul>
		<ul class="goodinfo f_l">
			<li>一 口 价：<span>${g.price }&nbsp;元</span></li>
			<li>运　　费：<span>${g.trsptat_pay }</span></li>
			<li class="h74 buynow"><a  href="yanzheng.y?goods_id=${g.goods_id }"><img src="images/buynow.gif" alt="alt" /></a></li>
			<li class="onlinepay">此商品支持<a href="#">网银支付</a>，网上汇款免手续费。<br />收货满意后出售者才能拿钱，货款都安全！</li>
			<li>剩余时间：<span>${t}&nbsp;小时</span></li>
			<li>本期售出：<span>${g.curr_sal_nub }&nbsp;件</span></li>
			<li>累计售出：<span>${g.tol_sal_nub }&nbsp;件</span></li>
			<li>商品类型：<span>${g.goods_type }</span></li>
			<li class="f_l w175">所 在 地：<span>${g.goods_addr }</span></li>
			<li>浏 览 量：<span>${g.page_view }&nbsp;次</span></li>			
		</ul>
	</div>
	
	<iframe id="footer" src="footer.jsp" width="980" height="136" frameborder="0" scrolling="no"></iframe>
</div> <!--container end-->	
</body>
</html>
