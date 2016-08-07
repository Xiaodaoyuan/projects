<%@page import="com.zrgk.entity.CartItem"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>贵美商城-商品购买页</title>
		<link rel="stylesheet" type="text/css" href="css/global.css" />
		<link rel="stylesheet" type="text/css" href="css/layout.css" />
		<script type="text/javascript" src="js/jquery-1.8.2.js"></script>


		<script type="text/javascript">
		
	
	

function openWindow(){
    var address=window.showModalDialog("address.htm","","dialogWidth=340px;dialogHeight=270px");
	  document.getElementById("address").value=address;	
		}
  	function remove(oThis){
  		oFather=oThis.parentNode;
  		oFather.parentNode.parentNode.removeChild(oFather.parentNode);
  		priceCalc();
		}
//	window.onload=priceCalc();
 
 </script>
		<script type="text/javascript">
	//数量
	function strip(str) {
		var reg = /(^\s*)|(\s*$)/;
		return str.replace(reg, '');
	}
	function priceCalc(obj) {
		var id = $(obj).next().attr("href");
		var qty = obj.value;
		if (strip(qty).length == 0) {
			alert("数量必须输入");
			return;
		}
		var reg = /^[0-9]+$/;
		if (!reg.test(strip(qty))) {
			alert("必须是数字");
			return;
		}
		if (qty == 0) {
			alert("数量必须大于0");
			return;
		}
		$.post('update.do', {'goods_id' : id,'qty' : qty}, 
		function(data) {
		});
	}

	//分页 
	function jump_to(frm, no) {
		frm.pageNo.value = no;
		frm.submit();
	}
	function go(frm) {
		var pageno = $("#page").val();
		var regexp = /^\d+$/;
		if (!regexp.test(pageno)) {
			alert("请输入 正确的数字！");
			return false;
		} else {
			jump_to(frm, pageno);
		}
	}
	function goes(frm) {
		var pageno = $("#pages").val();
		var regexp = /^\d+$/;
		if (!regexp.test(pageno)) {
			alert("请输入 正确的数字！");
			return false;
		} else {
			jump_to(frm, pageno);
		}
	}
</script>
		<script type="text/javascript">
//添加姓名
  function aname(){
    var $val = $("#anm").next().val();
    $("#username").attr("value",$val); 
   }
//表单验证
   function check(){
      var regexp =/^([\u4E00-\u9FA5])+$/;
     var $unme =  $("#username").val();
     var $ads  = $("#address").val();
 //----------------------------------------------    
   var reno =/^\d+$/;
    var $tel1  = $("#code").val();
    var $tel2  = $("#telnumber").val();
    var $tel3  = $("#branchnumber").val();
   var arr =document.getElementsByName("item");
    if(reno.test($tel1)&&reno.test($tel2)&&
    reno.test($tel3)&&regexp.test($unme)&&regexp.test($ads)&&(arr.length!=0)){
     
      return true;
    }
    return  false;
   }
</script>



	</head>
	<body>

		<form action="cartpage.do" method="post">
			<input type="hidden" name="pageNo" value="1">

		</form>
		<form action="carttemppage.do" method="post">
			<input type="hidden" name="pageNo" value="1">

		</form>

		<div id="container">
			<iframe id="header" src="header.jsp" width="980" height="136"
				frameborder="0" scrolling="no"></iframe>
			<div class="buy">
				<h4>
					<img src="images/mycart.gif" alt="alt" />
					<a href="#">全场运费一律2元</a>
					<a href="#" class="b"
						onclick="JavaScript:window.open('calc.htm','计算器','width=200,height=200,toolbar=no,scrollbars=no,menubar=no,screenX=100,screenY=100')">简易计算器</a>
				</h4>

				<table class="buy" cellpadding="0" cellspacing="0">
					<tbody id="priceTable">

						<tr class="buytitle">
							<td colspan="6" class="b">
								确认商品价格与交易条件
							</td>
						</tr>
						<tr>
							<td class="w364 b">
								&nbsp;&nbsp;&nbsp;&nbsp;商品名
							</td>
							<td class="w100 b">
								原价
							</td>
							<td class="w100 b">
								优惠价
							</td>
							<td class="w100 b">
								打折
							</td>
							<td class="w100 b">
								数量
							</td>
							<td class="w81 b">
								删除
							</td>
						</tr>
						<c:forEach items="${pagecart.items}" var="item">
							<tr class="h26 blue">

								<td>
									<a href="#" name="item">${item.g.title }</a>
								</td>
								<td>
									<span class="c9">￥${item.g.price }</span>
								</td>

								<td>
									<span class="red">￥${item.g.price*item.g.discount/10}</span>
								</td>
								<td>
									<span class="black">${item.g.discount}折</span>
								</td>

								<td>
									<input type="text" value=${item.qty } maxlength="4" size="3"
										onblur="priceCalc(this);">
									<a href=${item.g.goods_id}></a>
								</td>

								<td>

									<a href="delete.do?goods_id=${item.g.goods_id }">删除</a>
								</td>
							</tr>
						</c:forEach>

						<tr>
							<td colspan="6"
								style="text-align: center; font-weight: 900; color: gray;">
								<c:if test="${pagecart.items==null}" var="sp">
       		    首页&nbsp;
       		</c:if>
								<c:if test="${!sp}">

									<a href="javascript:jump_to(document.forms[0],1)">首页</a>&nbsp;
       			</c:if>
								<c:if test="${p.currPage-1>0}" var="pp">
									<a href="javascript:jump_to(document.forms[0],${p.currPage-1})"><font
										color="blue">上一页</font> </a>&nbsp;
       			</c:if>
								<c:if test="${!pp}">
									<font color="gray">上一页</font>  &nbsp;
        		</c:if>
								<c:if test="${p.currPage<p.tolPage}" var="ppp">
									<a href="javascript:jump_to(document.forms[0],${p.currPage+1})"><font
										color="blue">下一页</font> </a>&nbsp;
       			</c:if>
								<c:if test="${!ppp}">
									<font color="gray">下一页 </font> &nbsp;
        		</c:if>
								${p.currPage}/${p.tolPage}
								<c:if test="${cart==null}" var="sp2">
       		    尾页&nbsp;
       		</c:if>
								<c:if test="${!sp2}">
									<a href="javascript:jump_to(document.forms[0],${p.tolPage })">
										尾页 </a>

								</c:if>
								<c:if test="${cart!=null}">
       			&nbsp;
       			<input id="page" type="text" style="width: 30px;">
									<input type="button" value="go"
										style="width: 30px; height: 20px;"
										onclick="go(document.forms[0])">
								</c:if>
							</td>
						</tr>
						<tr class="h26">
							<td>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="index">继续挑选商品</a>
							</td>
							<td class="a_c" colspan="2" id="sum" class="pl58">
								<label id="l1">
									总价￥${cart.cost}
								</label>
							</td>
							<td colspan="3">
								<label id="l2">
									你共节省：￥${cart.jieSheng}
								</label>
							</td>
						</tr>
						<!-------恢复区------------------------------------------------------------------------------------------------------------------------------------------------------>

						<tr class="buytitle">
							<td colspan="6" class="b">
								恢复区
							</td>
						</tr>

						<tr>
							<td class="w364 b">
								&nbsp;&nbsp;&nbsp;&nbsp;商品名
							</td>
							<td class="w100 b">
								原价
							</td>
							<td class="w100 b">
								优惠价
							</td>
							<td class="w100 b">
								打折
							</td>
							<td class="w100 b">
								数量
							</td>
							<td class="w81 b">
								&nbsp;&nbsp;
							</td>
						</tr>
						<c:forEach items="${pagecart.tempitems}" var="tempitem">
							<tr>
								<td>
									<a href="#">${tempitem.g.title }</a>
								</td>
								<td>
									<span class="c9">￥${tempitem.g.price }</span>
								</td>
								<td>
									<span class="red">￥${tempitem.g.price*tempitem.g.discount/10}</span>
								</td>
								<td>
									<span class="black">${tempitem.g.discount}折</span>
								</td>
								<td>
									<input type="text" value=${tempitem.qty } maxlength="4"
										size="3" id="qty" disabled="disabled" />
								</td>
								<td>
									<a href="remove.do?goods_id=${tempitem.g.goods_id }">移除</a>
									&nbsp;&nbsp;
									<a href="recover.do?goods_id=${tempitem.g.goods_id }">恢复</a>
								</td>
							</tr>
						</c:forEach>
						<tr>
							<td colspan="6"
								style="text-align: center; font-weight: 900; color: gray;">
								<c:if test="${pagecart.tempitems==null}" var="tsp">
       		    首页&nbsp;
       		</c:if>
								<c:if test="${!tsp}">

									<a href="javascript:jump_to(document.forms[1],1)">首页</a>&nbsp;
       			</c:if>
								<c:if test="${p2.currPage-1>0}" var="tp1">
									<a
										href="javascript:jump_to(document.forms[1],${p2.currPage-1})"><font
										color="blue">上一页</font> </a>&nbsp;
       			</c:if>
								<c:if test="${!tp1}">
									<font color="gray">上一页</font>  &nbsp;
        		</c:if>
								<c:if test="${p2.currPage<p2.tolPage}" var="tp2">
									<a
										href="javascript:jump_to(document.forms[1],${p2.currPage+1})"><font
										color="blue">下一页</font> </a>&nbsp;
       			</c:if>
								<c:if test="${!tp2}">
									<font color="gray">下一页 </font> &nbsp;
        		</c:if>
								${p2.currPage}/${p2.tolPage}
								<c:if test="${cart==null}" var="tsp2">
       		    尾页&nbsp;
       		</c:if>
								<c:if test="${!tsp2}">
									<a href="javascript:jump_to(document.forms[1],${p2.tolPage })">
										尾页 </a>
								</c:if>
								<c:if test="${cart!=null}">
       			&nbsp;
       			<input id="pages" type="text" style="width: 30px;">
									<input type="button" value="go"
										style="width: 30px; height: 20px;"
										onclick="goes(document.forms[1])">
								</c:if>
							</td>
						</tr>
					</tbody>
				</table>
				<form id="buyForm" method="post" action="order"
					onsubmit="return check();">
					<c:forEach items="${cart.items}" var="i">
						<input type="hidden" value="${i.g.goods_id},${i.qty }"
							name="orders" />
					</c:forEach>
					<table class="buy">
						<tbody>
							<tr class="buytitle">
								<td colspan="2">
									补充您的邮件地址和联系人基本信息
								</td>
							</tr>
							<tr>
								<td class="a_r">
									<label for="username">
										收件人：
									</label>
								</td>
								<td>
									<input type="text" name="username" id="username" maxlength="5" />
									<a class="b" href="javascript:aname()" id="anm">点击添加真实姓名</a>
									<input type="hidden" value="${user.family_name}${user.name}" />
							</tr>
							<tr>
								<td class="a_r">
									<label for="address">
										地&nbsp;&nbsp;&nbsp;址：
									</label>
								</td>
								<td id="selectPlace">
									<input type="text" name="address" id="address" maxlength="20" />
									<a href="javascript:openWindow()" class="b">请点击填写地址</a>
								</td>
							</tr>
							<tr>
								<td class="a_r">
									<label for="tel">
										电&nbsp;&nbsp;&nbsp;话：
									</label>
								</td>
								<td>
									<input class="w30" type="text" name="code" size="4"
										maxlength="4" id="code" />
									-
									<input class="w81" type="text" name="telnumber" size="8"
										maxlength="8" id="telnumber" />
									-
									<input class="w30" type="text" name="branchnumber" size="4"
										maxlength="4" id="branchnumber" />
									<span class="red b"></span>（区号-电话号码-分机）
								</td>
							</tr>
							<tr>
								<td class="h65">
									&nbsp;
								</td>
								<td>
									<input class="imginput" type="image" src="images/submit.gif" />
								</td>

							</tr>
						</tbody>
					</table>
				</form>
				<iframe id="footer" src="footer.jsp" width="980" height="150"
					frameborder="0" scrolling="no"></iframe>
			</div>
			<!--container	end-->
	</body>