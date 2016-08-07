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
   
  <c:if test="${ss ==null}" var="flag">
   <table width="60%">
     <thead>
       <th> 索引</th>
       <th>物品名</th>
       <th>购买数量</th>
       <th>&nbsp;</th>
       
     </thead>
    <tbody>
     <c:forEach items="${qtys}" var="qty" varStatus="i" >
        <tr>
         <td>${i.count }</td>
         <td>${titles[i.index]}</td>
         <td>${qty}</td>
        </tr>
     
     </c:forEach>
     <tr>
       <td colspan="4">
          总价￥${GO.tol_pays} <a href="refundsuccess?order_id=${GO.order_id }" style="float: right;" >退款</a>  
       </td>
     </tr>
    </tbody>
   
   </table>
  </c:if>
   <c:if test="${!flag }">
      <h1 style="line-height: 300px" >${ss }
             <a href="refund" style="font-size: 20px;" >继续查看</a>
      </h1>
   
   </c:if>  
     
    
   
   
   

</div>
 <iframe id="footer" src="footer.jsp" width="980" height="150" frameborder="0" scrolling="no" style="background-color: white; " ></iframe>
 
</body>

</html>