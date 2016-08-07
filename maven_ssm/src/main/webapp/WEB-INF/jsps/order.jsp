<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
 
  h1{
    text-align: center;
    margin: 0px;
  }
  table {
	 text-align: center;
}
td{
  border-bottom: 1px black dotted;
}
#a1{
  text-decoration: none;
 
}
</style>

</head>
<body >
<div align="center">
<div id="container">
	<iframe id="header" src="header.jsp" width="980" height="136" frameborder="0" scrolling="no"></iframe>
   <div class="buy" style="background-color: #FFFFCC;width:980px;" >
   <c:if test="${g_o ==null}" var="f">
    <div style=" height: 350px; line-height: 300px; color: red; ">
   <h1> 订单已失效 </h1>
   </div>
   </c:if>
  <c:if test="${!f }">
    <c:if test="${success==null }" var="flag">
    <h1>订单(${date}${user.id})</h1>
<h3>&nbsp;&nbsp;&nbsp;&nbsp;收件人：${username }</h3><br/>
<h3>&nbsp;&nbsp;&nbsp;&nbsp;地址：${address }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 
电话：${tel }</h3><br/>

 <table  align="center"  >
  <thead>
     <th>商品名称</th>
     <th>数量（个）</th>
     <th>原价/实收款</th>
  </thead>
   <tbody>
  <c:forEach items="${cart.items}" var="itm" >
    <tr>
     <td>${itm.g.title }</td>
     <td>${itm.qty }</td>
     <td><label > ￥ ${itm.g.price}/</label>￥${itm.g.price*itm.g.discount/10}</td>
    </tr>
  </c:forEach>
  </tbody>
 
 </table>

<h3>&nbsp;&nbsp;&nbsp;&nbsp;总计：￥ ${cart.cost} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   实收：￥${cart.cost} &nbsp;&nbsp;&nbsp;&nbsp;  
  <a href="order_success" id="a1" ><h3 style="font-weight: 900; text-align: right;" >确定&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h3></a>
    </c:if>
    <c:if test="${!flag }">
   <div style=" height: 350px; line-height: 300px; color: red; ">
   <h1> ${success} </h1>
   <% session.removeAttribute("g_o");
  
    %>
   </div>
    </c:if>
   </c:if>
</div>
 <iframe id="footer" src="footer.jsp" width="980" height="150" frameborder="0" scrolling="no" style="background-color: white; " ></iframe>
 </div>
</div>
</body>

</html>