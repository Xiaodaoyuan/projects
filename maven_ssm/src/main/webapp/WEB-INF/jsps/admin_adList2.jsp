<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function call(){
  window.location="/guimeishoping/admin_newList.do3";
}
</script>

</head>
<body>
	<table style="width:100%;text-align:center;border:1px">
	<thead>
		<tr style="background-color: #99CCFF; font-size: 14px;">
			<th style=" display: none;">id</th>
			<th >商品</th>
			<th>型号</th>
			<th >类别1</th>
			<th >类别2</th>
			<th >描述</th>
			<th >图片</th>
			<th >卖家</th>
			<th >价格</th>
			<th >折扣价</th>
			<th >运费</th>
			<th >本期销量</th>
			<th >累计销量</th>
			<th >浏览量</th>
			<th >出售地</th>
			<th >上架时间</th>
			<th >在架时间</th>
			
		
			
		</tr>	
		</thead>
		<tbody>
	
	
	<c:forEach items="${goods}" var="g" varStatus="i">
		
		<tr style="background-color: #EEEEEE;">
			<td style="display: none">${g.goods_id}</td>
			<td>${g.title}</td>
			<td>${g.goods_type}</td>
			<td>${g.classify_1}</td>
			<td>${g.classify_2}</td>
			<td>${g.description}</td>
			<td><img alt=""  src="${g.picture}" width="50px" height="50px" >   </td>
			<td>${g.saler_id}</td>
			<td>${g.price}</td>
			<td>${g.discount}</td>
			<td>${g.trsptat_pay}</td>
			<td>${g.curr_sal_nub}</td>
			<td>${g.tol_sal_nub}</td>
			<td>${g.page_view}</td>
			<td>${g.goods_addr}</td>
			<td>${g.sell_star}</td>
			<td>${g.sell_time}</td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
<br/>
<input type="button" value="刷新" onclick="call();"/>
	
</body>
</html>