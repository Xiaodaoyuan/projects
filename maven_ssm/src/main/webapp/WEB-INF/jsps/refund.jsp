<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
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
   <div class="buy" style="background-color: #FFFFCC;width:980px; height: 350px;" >
     <c:if test="${s!=null }" var="flag" >
       <h1 style="line-height: 150px;" > 对不起，没有找到相应订单... ::>_<:: 
       </h1>
       <h1><br/> <a href="index"> 到商城寻找宝贝吧 </a></h1>
     </c:if>
     <c:if test="${!flag }">
      <h1 style="line-height: 100px;" >退款中心</h1>
     <table width="70%" >
      <thead>
       <th>索引</th>
       <th>订单编号</th>
       <th>收件人</th>
       <th>发货地址</th>
       <th>&nbsp;</th>
      </thead>
       <c:forEach items="${refundList}" var="golist" varStatus="sta" >
         <tr>
          <td><a >${sta.count }</a> </td>
          <td><a href="refundon?order_nub=${golist.order_nub }" >${golist.order_nub }</a> </td>
          <td><a>${golist.receiver }</a> </td>
          <td><a >${golist.rec_add }</a> </td>
          <td><a href="refundon?order_nub=${golist.order_nub  }">查看详情> </td>
        </tr>
       </c:forEach>
     
     
     
     
     </table>
     
     
     
     </c:if>
     
   
   
   

</div>
 <iframe id="footer" src="footer.jsp" width="980" height="150" frameborder="0" scrolling="no" style="background-color: white; " ></iframe>
 
</body>

</html>