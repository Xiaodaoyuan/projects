<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>贵美商城</title>
<link rel="stylesheet" type="text/css" href="css/global.css" />
<link rel="stylesheet" type="text/css" href="css/layout.css" />
<script type="text/javascript">
	function go(s1, s2, s3, s4) {
		var reg = /^\d+$/;
		if (!reg.test(s3)) {
			alert("必须输入数字！");
			return;
		}
		if (parseInt(s3) > parseInt(s4))
			s3 = s4;
		if (parseInt(s3) < 1)
			s3 = 1;
		if (s2 == '') {
			window.location = "searchlist?class=" + s1 + "&pageNo=" + s3;
		} else {
			window.location = "searchlist?class=" + s1 + "&name=" + s2
					+ "&pageNo=" + s3;
		}
	}
</script>
</head>
<body>

	<div id="container">
		<iframe id="header" runat="server" src="header.jsp" width="980"
			height="136" frameborder="0" scrolling="no"></iframe>
		<h4>
			<font color="orange" size="3pt">你现在的位置</font>&gt;&gt;<a href='searchlist?class=${class }'>${class}</a>
			<c:if test="${name !='' }">>>${name}</c:if>
		</h4>
		<c:if test="${name=='' && class=='家用电器'}">
			<h4>
				<b style="color:red;">分类:</b>&nbsp;|&nbsp; <a
					href="searchlist?class=家用电器&name=大家电">大家电</a>&nbsp;|&nbsp; <a
					href="searchlist?class=家用电器&name=洗衣机">洗衣机</a> &nbsp;|&nbsp;<a
					href="searchlist?class=家用电器&name=平板电视">平板电视</a>&nbsp;|&nbsp;<a
					href="searchlist?class=家用电器&name=电热水器">电热水器</a>&nbsp;|&nbsp;<a
					href="searchlist?class=家用电器&name=家庭音响">家庭音响</a>&nbsp;|&nbsp;<a
					href="searchlist?class=家用电器&name=热水器">热水器</a>&nbsp;|&nbsp; <a
					href="searchlist?class=家用电器&name=空调冰箱">空调冰箱</a>&nbsp;|&nbsp; <a
					href="searchlist?class=家用电器&name=冷柜">冷柜</a>&nbsp;|&nbsp;<a
					href="searchlist?class=家用电器&name=DVD">DVD</a>&nbsp;|&nbsp; <a
					href="searchlist?class=家用电器&name=电视附件">电视附件</a>&nbsp;|&nbsp;<a
					href="searchlist?class=家用电器&name=电燃气">电燃气</a>&nbsp;|&nbsp; <a
					href="searchlist?class=家用电器&name=家电下乡">家电下乡</a>&nbsp;|&nbsp; <a
					href="searchlist?class=家用电器&name=家电服务">家电服务</a>&nbsp;|&nbsp; <a
					href="searchlist?class=家用电器&name=电饭煲">电饭煲</a>&nbsp;|&nbsp; <a
					href="searchlist?class=家用电器&name=摄像机">摄像机</a>
			</h4>
		</c:if>
		<c:if test="${name=='' &&class=='书籍'}">
			<h4>
				<b style="color:red;">分类:</b>&nbsp;|&nbsp;<a
					href="searchlist?class=书籍&name=文学">文学</a>&nbsp;|&nbsp; <a
					href="searchlist?class=书籍&name=小说">小说</a>&nbsp;|&nbsp; <a
					href="searchlist?class=书籍&name=艺术">艺术</a>&nbsp;|&nbsp; <a
					href="searchlist?class=书籍&name=传记">传记</a>&nbsp;|&nbsp; <a
					href="searchlist?class=书籍&name=少儿">少儿</a>&nbsp;|&nbsp; <a
					href="searchlist?class=书籍&name=经济">经济</a>&nbsp;|&nbsp; <a
					href="searchlist?class=书籍&name=金融">金融</a>&nbsp;|&nbsp; <a
					href="searchlist?class=书籍&name=管理">管理</a>&nbsp;|&nbsp; <a
					href="searchlist?class=书籍&name=计算机">计算机</a>&nbsp;|&nbsp; <a
					href="searchlist?class=书籍&name=医学">医学</a>&nbsp;|&nbsp; <a
					href="searchlist?class=书籍&name=建筑">建筑</a>&nbsp;|&nbsp; <a
					href="searchlist?class=书籍&name=教辅">教辅</a>&nbsp;|&nbsp; <a
					href="searchlist?class=书籍&name=考试">考试</a>&nbsp;|&nbsp; <a
					href="searchlist?class=书籍&name=英语">英语</a>&nbsp;|&nbsp; <a
					href="searchlist?class=书籍&name=烹饪">烹饪</a>
			</h4>
		</c:if>
		<c:if test="${name=='' &&class=='手机数码'}">
			<h4>
				<b style="color:red;">分类:</b>&nbsp;|&nbsp;<a
					href="searchlist?class=手机数码&name=手机">手机</a>&nbsp;|&nbsp; <a
					href="searchlist?class=手机数码&name=耳机">耳机</a>&nbsp;|&nbsp; <a
					href="searchlist?class=手机数码&name=耳麦">耳麦</a>&nbsp;|&nbsp; <a
					href="searchlist?class=手机数码&name=手机电池">手机电池</a>&nbsp;|&nbsp; <a
					href="searchlist?class=手机数码&name=充电器">充电器</a>&nbsp;|&nbsp; <a
					href="searchlist?class=手机数码&name=移动电源">移动电源</a>&nbsp;|&nbsp; <a
					href="searchlist?class=手机数码&name=手机壳">手机壳</a>&nbsp;|&nbsp; <a
					href="searchlist?class=手机数码&name=手机膜">手机膜</a>&nbsp;|&nbsp; <a
					href="searchlist?class=手机数码&name=U盘">U盘</a>&nbsp;|&nbsp; <a
					href="searchlist?class=手机数码&name=数码相机'">数码相机</a>&nbsp;|&nbsp; <a
					href="searchlist?class=手机数码&name=单反">单反</a>&nbsp;|&nbsp; <a
					href="searchlist?class=手机数码&name=摄像头">摄像头</a>&nbsp;|&nbsp; <a
					href="searchlist?class=手机数码&name=移动硬盘">移动硬盘</a>&nbsp;|&nbsp; <a
					href="searchlist?class=手机数码&name=MP3">MP3</a>&nbsp;|&nbsp; <a
					href="searchlist?class=手机数码&name=MP4">MP4</a>
			</h4>
		</c:if>
		<c:if test="${name=='' &&class=='日用百货'}">
			<h4>
				<b style="color:red;">分类:</b>&nbsp;|&nbsp;<a
					href="searchlist?class=日用百货&name=家纺">家纺</a>&nbsp;|&nbsp; <a
					href="searchlist?class=日用百货&name=灯具">灯具</a>&nbsp;|&nbsp; <a
					href="searchlist?class=日用百货&name=>生活用品">生活用品</a>&nbsp;|&nbsp; <a
					href="searchlist?class=日用百货&name=家装">家装</a>&nbsp;|&nbsp; <a
					href="searchlist?class=日用百货&name=清洁用品">清洁用品</a>&nbsp;|&nbsp; <a
					href="searchlist?class=日用百货&name=营养副食">营养副食</a>&nbsp;|&nbsp; <a
					href="searchlist?class=日用百货&name=烹饪锅具">烹饪锅具</a>&nbsp;|&nbsp; <a
					href="searchlist?class=日用百货&name=刀剪菜板">刀剪菜板</a>&nbsp;|&nbsp; <a
					href="searchlist?class=日用百货&name=厨房配件">厨房配件</a>&nbsp;|&nbsp; <a
					href="searchlist?class=日用百货&name=水具器皿">水具器皿</a>&nbsp;|&nbsp; <a
					href="searchlist?class=日用百货&name=餐具">餐具</a>&nbsp;|&nbsp; <a
					href="searchlist?class=日用百货&name=茶具">茶具</a>&nbsp;|&nbsp; <a
					href="searchlist?class=日用百货&name=卧室家具">卧室家具</a>&nbsp;|&nbsp; <a
					href="searchlist?class=日用百货&name=书房家具">书房家具</a>&nbsp;|&nbsp; <a
					href="searchlist?class=日用百货&name=餐厅用具">餐厅用具</a>
			</h4>
		</c:if>
		<div class="catlist a_c">
			<ul class="w10p ">
				<h3>编号</h3>
				<c:forEach items="${goods}" var="g" varStatus="sta">
					<li>${sta.count+(pageNo-1)*pageNub }</li>
				</c:forEach>
			</ul>
			<ul class="w15p ">
				<h3>商品名称</h3>
				<c:forEach items="${goods}" var="g">
					<li><a href="goodinfo?goods_id=${g.goods_id }" target="_blank">${g.title}</a>
					</li>
				</c:forEach>
			</ul>
			<ul class="w20p">
				<h3>商品图片</h3>
				<c:forEach items="${goods }" var="g">
				<li><a href="goodinfo?goods_id=${g.goods_id }"
					target="_blank"><img src="${g.picture }" width="120px"
						height="100px" /> </a>
				</li></c:forEach>
			</ul>
			<ul class="w40p info">
				<h3>商品介绍/出售者</h3>
				<c:forEach items="${goods}" var="g" varStatus="sta">
					<li><a href="goodinfo?goods_id=${g.goods_id }" target="_blank">${g.description
							}</a><br />出售者：${salers[sta.index] }<br />
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
					<a
						href="searchlist?class=${class }<c:if test="${name!=''}">&name=${name}</c:if>&pageNo=1"><font
						color="blue">首页</font>
					</a>
					<a
						href="searchlist?class=${class }<c:if test="${name!=''}">&name=${name}</c:if>&pageNo=${pageNo-1}"><font
						color="blue">上一页</font>
					</a>
				</c:if>
				<c:if test="${!flag}">
					<span>首页</span>&nbsp;<span>上一页</span>
				</c:if>
				&nbsp;&nbsp;当前第${pageNo }页&nbsp;&nbsp;
				<c:if test="${pageNo lt totalpage }" var="flag1">
					<a
						href="searchlist?class=${class }<c:if test="${name!=''}">&name=${name}</c:if>&pageNo=${pageNo+1}"><font
						color="blue">下一页</font>
					</a>
					<a
						href="searchlist?class=${class }<c:if test="${name!=''}">&name=${name}</c:if>&pageNo=${totalpage}"><font
						color="blue">最后一页</font>
					</a>
				</c:if>
				<c:if test="${!flag1 }">
					<span>下一页</span>&nbsp;<span>最后一页</span>
				</c:if>
				&nbsp;&nbsp;&nbsp;跳转至：<input name="num" id="num" size="3"
					style="border: 1px orange solid;" />页&nbsp;&nbsp;
				<button
					onclick="go('${class}','${name}',document.getElementById('num').value,'${totalpage }')">GO</button>
			</h4>
		</div>
		<iframe id="footer" runat="server" src="footer.jsp" width="980"
			height="136" frameborder="0" scrolling="no"></iframe>
	</div>
	<!--container end-->
</body>
</html>
