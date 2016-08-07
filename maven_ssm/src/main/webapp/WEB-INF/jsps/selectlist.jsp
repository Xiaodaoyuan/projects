<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>贵美商城</title>
<link rel="stylesheet" type="text/css" href="css/global.css" />
<link rel="stylesheet" type="text/css" href="css/layout.css" />
<script type="text/javascript">
	function go(s1, s2,fm) {
		var reg = /^\d+$/;
		if (!reg.test(s1)) {
			alert("必须输入数字！");
			return;
		}
		if (parseInt(s1) > parseInt(s2))
			s1 = s2;
		if (parseInt(s1) < 1)
			s1 = 1;
		fm.pageNo.value=s1;
		fm.submit();
	}
</script>
</head>
<body>
	<div id="container">
		<iframe id="header" runat="server" src="header.jsp" width="980"
			height="136" frameborder="0" scrolling="no"></iframe>
		<div class="catlist a_c">
			<c:if test="${empty goods}" var="flag">
				<h3>
					未搜到你要查询的商品!<br />
					<font color="red">请重新搜索!</font>
				</h3>
			</c:if>
			<c:if test="${!flag }">
			<form action="select" method="post">
			<input type="hidden" name="keywords" value='${keywords }'/>
			<input type="hidden" name="pageNo" />
				<h2>
					<font color="blue">以下为你要搜索的商品</font>
				</h2>
				<ul class="w10p ">
					<h3>编号</h3>
					<c:forEach items="${goods}" var="g" varStatus="sta">
						<li>${sta.count+(pageNo-1)*pageNub }</li>
					</c:forEach>
				</ul>
				<ul class="w15p ">
					<h3>商品名称</h3>
					<c:forEach items="${goods}" var="g">
						<li><a href="goodinfo?goods_id=${g.goods_id }"
							target="_blank">${g.title}</a></li>
					</c:forEach>
				</ul>
				<ul class="w20p">
					<h3>商品图片</h3>
					<c:forEach items="${goods }" var="g">
						<li><a href="goodinfo?goods_id=${g.goods_id }"
							target="_blank"><img src="${g.picture }" width="120px"
								height="100px" /> </a>
						</li>
					</c:forEach>
				</ul>
				<ul class="w40p info">
					<h3>商品介绍/出售者</h3>
					<c:forEach items="${goods}" var="g" varStatus="sta">
						<li><a href="goodinfo?goods_id=${g.goods_id }"
							target="_blank">${g.description }</a><br />出售者：${salers[sta.index]
							}<br />
					</c:forEach>

				</ul>
				<ul class="w15p price">
					<h3>价格</h3>
					<c:forEach items="${goods}" var="g">
						<li>一口价：<br />${g.price }</li>
					</c:forEach>
				</ul>
				<h4>
					共${totalpage }页&nbsp;&nbsp;
					<c:if test="${pageNo gt 1}" var="flag">
						<a href="javascript:go(1,'${totalpage }',document.forms[0]);"><font
							color="blue">首页</font> </a>
						<a href="javascript:go(${pageNo-1 },'${totalpage }',document.forms[0]);"><font
							color="blue">上一页</font> </a>
					</c:if>
					<c:if test="${!flag}">
						<span>首页</span>&nbsp;<span>上一页</span>
					</c:if>
					&nbsp;&nbsp;当前第${pageNo }页&nbsp;&nbsp;
					<c:if test="${pageNo lt totalpage }" var="flag1">
						<a href="javascript:go(${pageNo+1 },'${totalpage }',document.forms[0]);"><font
							color="blue">下一页</font> </a>
						<a href="javascript:go('${totalpage }','${totalpage }',document.forms[0]);"><font
							color="blue">最后一页</font> </a>
					</c:if>
					<c:if test="${!flag1 }">
						<span>下一页</span>&nbsp;<span>最后一页</span>
					</c:if>
					&nbsp;&nbsp;&nbsp;跳转至：<input name="num" id="num" size="3"
						style="border: 1px orange solid;" />页&nbsp;&nbsp;
					<button
						onclick="go(document.getElementById('num').value,'${totalpage }',document.forms[0])">GO</button>
				</h4>
				</form>
			</c:if>
		</div>
		<iframe id="footer" runat="server" src="footer.jsp" width="980"
			height="136" frameborder="0" scrolling="no"></iframe>
	</div>
	<!--container end-->
</body>
</html>