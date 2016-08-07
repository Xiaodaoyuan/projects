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
<script type="text/JavaScript" src="js/index.js"></script>
<script type="text/javascript">
	function f1() {
		var obj = document.getElementById("s1").value;
		var discount;
		if (obj == 'lenovo')
			discount = 9.5;
		else if (obj == 'dell')
			discount = 9;
		else if (obj == 'acer')
			discount = 8.5;
		alert("折扣为：" + discount + "折");
	}

	function f2() {
		var obj = document.getElementById("s2").value;
		var discount;
		if (obj == 'yd')
			discount = 0.95;
		else if (obj == 'lt')
			discount = 0.9;
		else if (obj == 'dx')
			discount = 0.85;
		var price = document.getElementById("s3").value * discount;
		alert("折扣价为：" + price + "元");
	}
</script>
</head>
<body>
	<div id="container">
		<iframe id="header" runat="server" src="head" width="980"
			height="136" frameborder="0" scrolling="no"></iframe>
		<div id="main">
			<div class="cat">
				<ul>
					<a href="searchlist?class=家用电器" target="_blank"><h1>家用电器</h1> </a>
					<li><a href="searchlist?class=家用电器&name=大家电" target="_blank">大家电</a>
					</li>
					<li><a href="searchlist?class=家用电器&name=洗衣机" target="_blank">洗衣机</a>
					</li>
					<li><a href="searchlist?class=家用电器&name=平板电视" target="_blank">平板电视</a>
					</li>
					<li><a href="searchlist?class=家用电器&name=电热水器" target="_blank">电热水器</a>
					</li>
					<li><a href="searchlist?class=家用电器&name=家庭音响" target="_blank">家庭音响</a>
					</li>
					<li><a href="searchlist?class=家用电器&name=热水器" target="_blank">热水器</a>
					</li>
					<li><a href="searchlist?class=家用电器&name=空调冰箱" target="_blank">空调冰箱</a>
					</li>
					<li><a href="searchlist?class=家用电器&name=冷柜" target="_blank">冷柜</a>
					</li>
					<li><a href="searchlist?class=家用电器&name=DVD" target="_blank">DVD</a>
					</li>
					<li><a href="searchlist?class=家用电器&name=电视附件" target="_blank">电视附件</a>
					</li>
					<li><a href="searchlist?class=家用电器&name=电燃气" target="_blank">电燃气</a>
					</li>
					<li><a href="searchlist?class=家用电器&name=家电下乡" target="_blank">家电下乡</a>
					</li>
					<li><a href="searchlist?class=家用电器&name=家电服务" target="_blank">家电服务</a>
					</li>
					<li><a href="searchlist?class=家用电器&name=电饭煲" target="_blank">电饭煲</a>
					</li>
					<li><a href="searchlist?class=家用电器&name=摄像机" target="_blank">摄像机</a>
					</li>
				</ul>
				<ul>
					<a href="searchlist?class=书籍" target="_blank"><h1>书籍</h1> </a>
					<li><a href="searchlist?class=书籍&name=文学" target="_blank">文学</a>
					</li>
					<li><a href="searchlist?class=书籍&name=小说" target="_blank">小说</a>
					</li>
					<li><a href="searchlist?class=书籍&name=艺术" target="_blank">艺术</a>
					</li>
					<li><a href="searchlist?class=书籍&name=传记" target="_blank">传记</a>
					</li>
					<li><a href="searchlist?class=书籍&name=少儿" target="_blank">少儿</a>
					</li>
					<li><a href="searchlist?class=书籍&name=经济" target="_blank">经济</a>
					</li>
					<li><a href="searchlist?class=书籍&name=金融" target="_blank">金融</a>
					</li>
					<li><a href="searchlist?class=书籍&name=管理" target="_blank">管理</a>
					</li>
					<li><a href="searchlist?class=书籍&name=计算机" target="_blank">计算机</a>
					</li>
					<li><a href="searchlist?class=书籍&name=医学" target="_blank">医学</a>
					</li>
					<li><a href="searchlist?class=书籍&name=建筑" target="_blank">建筑</a>
					</li>
					<li><a href="searchlist?class=书籍&name=教辅" target="_blank">教辅</a>
					</li>
					<li><a href="searchlist?class=书籍&name=考试" target="_blank">考试</a>
					</li>
					<li><a href="searchlist?class=书籍&name=英语" target="_blank">英语</a>
					</li>
					<li><a href="searchlist?class=书籍&name=烹饪" target="_blank">烹饪</a>
					</li>
				</ul>
				<ul>
					<a href="searchlist?class=手机数码" target="_blank"><h1>手机数码</h1> </a>
					<li><a href="searchlist?class=手机数码&name=手机" target="_blank">手机</a>
					</li>
					<li><a href="searchlist?class=手机数码&name=耳机" target="_blank">耳机</a>
					</li>
					<li><a href="searchlist?class=手机数码&name=耳麦" target="_blank">耳麦</a>
					</li>
					<li><a href="searchlist?class=手机数码&name=手机电池" target="_blank">手机电池</a>
					</li>
					<li><a href="searchlist?class=手机数码&name=充电器" target="_blank">充电器</a>
					</li>
					<li><a href="searchlist?class=手机数码&name=移动电源" target="_blank">移动电源</a>
					</li>
					<li><a href="searchlist?class=手机数码&name=手机壳" target="_blank">手机壳</a>
					</li>
					<li><a href="searchlist?class=手机数码&name=手机膜" target="_blank">手机膜</a>
					</li>
					<li><a href="searchlist?class=手机数码&name=U盘" target="_blank">U盘</a>
					</li>
					<li><a href="searchlist?class=手机数码&name=数码相机'" target="_blank">数码相机</a>
					</li>
					<li><a href="searchlist?class=手机数码&name=单反" target="_blank">单反</a>
					</li>
					<li><a href="searchlist?class=手机数码&name=摄像头" target="_blank">摄像头</a>
					</li>
					<li><a href="searchlist?class=手机数码&name=移动硬盘" target="_blank">移动硬盘</a>
					</li>
					<li><a href="searchlist?class=手机数码&name=MP3" target="_blank">MP3</a>
					</li>
					<li><a href="searchlist?class=手机数码&name=MP4" target="_blank">MP4</a>
					</li>
				</ul>
				<ul>
					<a href="searchlist?class=日用百货" target="_blank"><h1>日用百货</h1> </a>
					<li><a href="searchlist?class=日用百货&name=家纺" target="_blank">家纺</a>
					</li>
					<li><a href="searchlist?class=日用百货&name=灯具" target="_blank">灯具</a>
					</li>
					<li><a href="searchlist?class=日用百货&name=>生活用品" target="_blank">生活用品</a>
					</li>
					<li><a href="searchlist?class=日用百货&name=家装" target="_blank">家装</a>
					</li>
					<li><a href="searchlist?class=日用百货&name=清洁用品" target="_blank">清洁用品</a>
					</li>
					<li><a href="searchlist?class=日用百货&name=营养副食" target="_blank">营养副食</a>
					</li>
					<li><a href="searchlist?class=日用百货&name=烹饪锅具" target="_blank">烹饪锅具</a>
					</li>
					<li><a href="searchlist?class=日用百货&name=刀剪菜板" target="_blank">刀剪菜板</a>
					</li>
					<li><a href="searchlist?class=日用百货&name=厨房配件" target="_blank">厨房配件</a>
					</li>
					<li><a href="searchlist?class=日用百货&name=水具器皿" target="_blank">水具器皿</a>
					</li>
					<li><a href="searchlist?class=日用百货&name=餐具" target="_blank">餐具</a>
					</li>
					<li><a href="searchlist?class=日用百货&name=茶具" target="_blank">茶具</a>
					</li>
					<li><a href="searchlist?class=日用百货&name=卧室家具" target="_blank">卧室家具</a>
					</li>
					<li><a href="searchlist?class=日用百货&name=书房家具" target="_blank">书房家具</a>
					</li>
					<li><a href="searchlist?class=日用百货&name=餐厅用具" target="_blank">餐厅用具</a>
					</li>
				</ul>
			</div>
			<!--cat end-->
			<div id="content">
				<div class="content_top">
					<div>
						<c:forEach items="${list4 }" var="l4" varStatus="sta">
							<a href="goodinfo?goods_id=${l4.goods_id }" target="_blank"><img
								src="${l4.en_pic }" alt="" id="div${sta.count }"  width="520px" height="200px"  />
							</a>
						</c:forEach>
					</div>
					<div id="adv">
						<a href="JavaScript:show(1);">1</a>&nbsp;<a class="adv"
							href="JavaScript:show(2);">2</a>&nbsp;<a class="adv"
							href="JavaScript:show(3);">3</a>&nbsp;<a class="adv"
							href="JavaScript:show(4);">4</a>
					</div>
				</div>
				<!-- content_top end -->
				<div class="content_list">
					<c:forEach items="${list1}" var="l1">
						<dl>
							<dt>
								<a href="goodinfo?goods_id=${l1.goods_id }" target="_blank"><img
									src="${l1.en_pic }" alt="alt" width="100px" height="80px"/> </a>
							</dt>
							<dd>
								<a href="goodinfo?goods_id=${l1.goods_id }" target="_blank">${l1.goods_name
									}</a>
							</dd>
						</dl>
					</c:forEach>
				</div>
				<!-- content_list end -->
			</div>
			<!-- content end -->
			<div class="ad">
				<c:forEach items="${list3 }" var="l3">
					<dl>
						<a href="goodinfo?goods_id=${l3.goods_id }" target="_blank">${l3.goods_name}</a>
					</dl>
				</c:forEach>
			</div>
			<div class="sidebar">
				<div class="r1"></div>
				<div class="r2">
					<c:forEach items="${list2 }" var="l2">
						<dl>
							<dt>
								<a href="goodinfo?goods_id=${l2.goods_id }" target="_blank"><img
									src="${l2.en_pic }" alt="alt" /> </a>
							</dt>
							<dd>
								<a href="goodinfo?goods_id=${l2.goods_id}" target="_blank">${l2.goods_name}</a>
							</dd>
						</dl>
					</c:forEach>
				</div>
				<!--r2	end-->
				<div id="tab">
					<div id="tabtitle1" onmouseover="switchMe(1);"></div>
					<div id="tabtitle2" onmouseover="switchMe(2);"></div>
					<div id="tabbody1" algin="center"
						style="display: block;position: absolute;left: 810px;top: 613px;">
						<p>
							品牌： <select id="s1"><option value="lenovo">联想</option>
								<option value="dell">戴尔</option>
								<option value="acer">宏基</option>
							</select>
						</p>
						<p>
							尺寸：<select><option>14英寸</option>
								<option>15英寸</option>
								<option>16英寸</option>
							</select>
						</p>
						<p>
							价格： <select><option>4000以下</option>
								<option>4000-5000</option>
								<option>5000以上</option>
							</select>
						</p>
						<img alt="" class="hand" src="images/scan_discount.jpg"
							onclick="f1()">
					</div>
					<div id="tabbody">
						&nbsp;
						<p>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;运营商：
							<select id="s2"><option value="yd">移动</option>
								<option value="lt">联通</option>
								<option value="dx">电信</option>
							</select>
						</p>
						<p>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;地&nbsp;&nbsp;&nbsp;区：<select><option>北京</option>
								<option>上海</option>
								<option>浙江</option>
								<option>广州</option>
							</select>
						</p>
						<p>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;面&nbsp;&nbsp;&nbsp;值：
							<select id="s3"><option value="30">30元</option>
								<option value="50">50元</option>
								<option value="100">100元</option>
							</select>
						</p>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img alt=""
							class="hand" src="images/scan_discount.jpg" onclick="f2()">
					</div>
				</div>
			</div>
			<!--sidebar end-->
		</div>
		<!--main end-->
		<iframe id="footer" runat="server" src="footer.jsp" width="980"
			height="150" frameborder="0" scrolling="no"></iframe>

	</div>
	<!--container	end-->
</body>
</html>
