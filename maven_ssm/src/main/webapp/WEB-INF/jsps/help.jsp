<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>贵美商城</title>
<link rel="stylesheet" type="text/css" href="css/global.css" />
<link rel="stylesheet" type="text/css" href="css/layout.css" />
<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="js/check.js"></script>

<script type="text/javascript">
	var str = new Array();
	var stastr = new Array();
	var flagstr = new Array();
	str[0] = "<a href='javascript:change(\"reg\");'><img src='images/reg.jpg' /></a><a href='register.jsp'>点此注册</a><a href='javascript:change(\"reg\");'>认证中心</a>";
	str[1] = " <a href='javascript:change(\"buy\");'><img src='images/buy.jpg' /></a><a href='javascript:change(\"consult\");'> 咨询</a><a href='javascript:change(\"complain\");'> 投诉</a><a href='javascript:change(\"report\");'> 举报</a><a href='refund'> 退款</a>";
	str[2] = "<a href='javascript:change(\"sale\");'><img src='images/sale.jpg' /></a><a href=#> 安全中心</a><a href=#> 物流中心</a><a href=#> 资金流动</a><a href=#> 纠纷处理</a></div>";
	stastr[0] = "<a href='javascript:change(\"reg\");'><img src='images/reg.jpg' /></a>";
	stastr[1] = "<a href='javascript:change(\"buy\");'><img src='images/buy.jpg' /></a>";
	stastr[2] = "<a href='javascript:change(\"sale\");'><img src='images/sale.jpg' /></a>";
	flagstr[0] = "images/reg.jpg";
	flagstr[1] = "images/buy.jpg";
	flagstr[2] = "images/sale.jpg";
	$(document).ready(function() {
		$(".i").each(function(i) {
			$(this).html(stastr[i]);
			$(this).bind("click", enter);

		});
		$("#reg").css("display", "none");
		$("#buy").css("display", "none");
		$("#sale").css("display", "none");
		$("#user").css("display", "none");
		$("#consult").css("display", "none");
		$("#complain").css("display", "none");
		$("#report").css("display", "none");
		$("#oldpass").css("display", "none");
		$("#modifypass").css("display", "none");
		$("li a").toggle(function() {
			$(this).siblings().slideDown('fast');
		}, function() {
			$(this).siblings().slideUp('fast');
		});
	});

	function enter() {

		var flag = $(this).children().eq(0).children("img").attr("src");
		if ($(this).children().length == 1) {
			for (var i = 0; i < 3; i++) {
				if (flag == flagstr[i]) {
					$(this).html(str[i]);
				} else {

					$(".i").eq(i).html(stastr[i]);
				}
			}
		} else {
			for ( var i = 0; i < 3; i++) {
				if (flag == flagstr[i]) {
					$(this).html(stastr[i]);
				} else {

					$(".i").eq(i).html(stastr[i]);
				}
			}
		}
	}
	function Reset() {
		document.forms[0].reset();
		$("span:eq(0)").html("");
		$("span:eq(1)").html("");
		$("span:eq(2)").html("格式如：xxx@xx.xx（.xx）");
		$("span:eq(3)").html("");
		$("input").removeClass("updatered");
		$("span").css({
			color : "black"
		});
	}
	function change(id) {
		$(".s1").css("display", "none");
		$("#" + id).css("display", "block");
	}
function checkoldpassword(){
		var $obj =$("#oldpasswordmsg");
		
		//$obj.css("color","blue");
		//$obj.html("正在验证");
		
		
		
		
		$.post("checkoldpass",{"oldpassword":$("#oldpassword").val()},function(data){
			if(data=="true"){
				change("modifypass");
			}else{
				alert("密码输入错误！！！");
			}
			var $obj =$("#oldpasswordmsg");
			$obj.css("color","blue");
			$obj.html("");
		});
		
}

function checknewPass() {
	var reg = /^[0-9a-zA-Z]{6,}$/;
	var $obj =$("#oldpasswordmsg");
	if (!reg.test($("#newpassword").val())) {
		$("#pass_msg").html("密码必须由字母或数字组成的不少于6位字符！");
		$("#pass_msg").css({
			color : "red"
		});
		return false;
	}
	$("#newpassword").removeClass("updatered");
	$("#pass_msg").html(
			"<img src='images/right.jpg' width='20px' height='20px'/>");
	return true;
}
function checknewRpass() {
	if ($("#newpassword").val() != $("#newpasswordagn").val()) {
		$("#rpass_msg").html("两次密码不一致！");
		$("#rpass_msg").css({
			color : "red"
		});
		return false;
	}
	if ($("#newpasswordagn").val() == "") {
		$("#rpass_msg").html("密码不能为空！");
		$("#rpass_msg").css({
			color : "red"
		});
		return false;
	}
	
	$("#newpasswordagn").removeClass("updatered");
	$("#rpass_msg").html("<img src='images/right.jpg' width='20px' height='20px'/>");
	return true;
}

function modifypass(){
if(checknewPass()&&checknewRpass()){
	$.post("modifypass",{"newpassword":$("#newpassword").val()},function(data){
		if(data=="true"){
			alert("修改成功");
			change("reg");
		}else{
			alert("修改失败");
		}
	});
}
	
}


	
	
	
	
</script>
</head>

<body>
	<div id="container">
		<iframe id="header" src="header.jsp" width="980" height="136"
			frameborder="0" scrolling="no"></iframe>
		<div class="helpmenu f_l">
			<div class="i"></div>

			<div class="i"></div>
			<div class="i"></div>
       <c:if test="${user!=null }">
			<a href="javascript:change('user');"><img src="images/person.jpg"
				alt="alt" />
			</a>
			</c:if>
		</div>
		<div class="help f_l">
			<div id="firpage" class="s1">
				<h1>知识堂首页</h1>
				<p><img src="images/reg_line.jpg" alt="alt" /></p>
				<p>&nbsp;&nbsp;&nbsp;&nbsp; 工作忙？没时间去逛商场？没时间陪女盆友疯狂购物？<b style="color:red;">网上购物哪家强？</b><b style="color:blue;">贵美</b>为您解决难题，足不出户，就可以买到任何您需要的商品。</p>
				<p>&nbsp;&nbsp;&nbsp;&nbsp; 本站提供365天每天长达10小时的免费电话服务，免除顾客外出逛街之苦，享受居家购物送货上门的人性化服务，训练有素的专业客
				         户服务人员亲切、迅速的服务态度一直受到消费者的认同，为您带来轻松 、便捷、快乐的居家购物。</p>
                <p>&nbsp;&nbsp;&nbsp;&nbsp; 另外本站高效的物流配送系统，遍布全国近2000个主要城市的送货网络，全方位的配送方式适应不同地区的您，高效、快速、优质的
                                                        服务保障网上订购的商品及时配送到客户手中。实乃居家上网必备网站。</p>
                <h3 align="center"><p>详情请根据需要点击左侧链接，祝您购物愉快！</p></h3>
			</div>
			<div id="reg" class="s1">
				<h2>
					<a href="javascript:change('firpage');">知识堂首页</a> &gt;&gt; 注册＆认证
				</h2>
				<p>
					<img src="images/reg_line.jpg" alt="alt" />
				</p>
				<p>享受贵美网免费网上交易乐趣，并且在超人气的社区尽情交流您的网上购物经验，您需要先注册成为贵美的会员，具体的步骤如下：</p>
				<p>
					<img src="images/reg_step.jpg" alt="alt" />
				</p>
				<ul type="square">
					<li><a href="javascript:;">如何激活会员名？</a>
					<p style="display:none;color:blue;font-style: italic;font-weight: bold;">登录注册邮箱即可激活。</p>
					</li>
					<li><a href="javascript:;">如何注册贵美会员？</a>
					<p style="display:none;color:blue;font-style: italic;font-weight: bold;">点击注册进入注册页面填写信息即可注册。</p>
					</li>
					<li><a href="javascript:;">注册时密码设置有什么要求？</a>
					<p style="display:none;color:blue;font-style: italic;font-weight: bold;">密码必须由字母和数字组成的不少于六位的字符。</p>
					</li>
					<li><a href="javascript:;">贵美认证</a>
					<p style="display:none;color:blue;font-style: italic;font-weight: bold;">完成贵美认证即可享受贵美商城商品优惠。</p>
					</li>
					<li><a href="javascript:;">为什么校验码明明是对的，却提示我输入错误？</a>
					<p style="display:none;color:blue;font-style: italic;font-weight: bold;">请仔细确认校验码或者稍后重试。</p>
					</li>
				</ul>
			</div>
			<!-- reg end -->
			<div id="buy" class="s1">
				<h2>
					<a href="javascript:change('firpage');">知识堂首页</a>&gt;&gt;买家帮助
				</h2>
				<p>
					<img src="images/reg_line.jpg" alt="alt" />
				</p>
				<p>享受贵美网免费网上购物乐趣，您需要了解贵美贝的网上安全交易流程和网上购物的4步曲：</p>
				<h4>网上安全交易流程如下：</h4>
				<p>
					<img src="images/buy_sep1.jpg" alt="alt" />
				</p>
				<h4>客户交易演示4步曲：</h4>
				<p>
					<img src="images/buy_sep2.jpg" alt="alt" />
				</p>
			</div>
			<!-- buy end -->
			<div id="consult" class="s1">
				<h2>
					<a href="javascript:change('firpage');">知识堂首页</a>&gt;&gt;咨询
				</h2>
				<p>
					<img src="images/reg_line.jpg" alt="alt" />
				</p>
				<p>Q:</p>
				<p>A:</p>
				<p>Q:</p>
				<p>A:</p>
				<p>Q:</p>
				<p>A:</p>

			</div>
			<div id="complain" class="s1">
				<h2>
					<a href="javascript:change('firpage');">知识堂首页</a>&gt;&gt;投诉
				</h2>
				<p>
					<img src="images/reg_line.jpg" alt="alt" />
				</p>
				<p>Q:</p>
				<p>A:</p>
				<p>Q:</p>
				<p>A:</p>
				<p>Q:</p>
				<p>A:</p>

			</div>
			<div id="report" class="s1">
				<h2>
					<a href="javascript:change('firpage');">知识堂首页</a>&gt;&gt;举报
				</h2>
				<p>
					<img src="images/reg_line.jpg" alt="alt" />
				</p>
					<p>Q:</p>
				<p>A:</p>
				<p>Q:</p>
				<p>A:</p>
				<p>Q:</p>
				<p>A:</p>

			</div>
			<div id="sale" class="s1">
				<h2>
					<a href="javascript:change('firpage');">知识堂首页</a>&gt;&gt; 商家帮助
				</h2>
				<p>
					<img src="images/reg_line.jpg" alt="alt" />
				</p>
				<p>做贵美网的商家，拥有自己的个性小店，您需要了解贵美网上交易要点，请看出售商品的步骤：</p>
				<p>
					<img src="images/sale_step.jpg" alt="alt" />
				</p>
			</div>
			<!-- sale end -->
				<div id="user" class="s1">
					<h2>
						<a href="javascript:change('firpage');">知识堂首页</a>&gt;&gt; 个人资料修改
					</h2>
					<p>
						<img src="images/reg_line.jpg" alt="alt" />
					</p>
					<form action="modifyuserinfo" method="post"
						enctype="multipart/form-data">
						<table cellspacing="0px" cellpadding="0px" width="100%"
							padding-top="65px" height="400px">
							<tr>
								<td></td>
								<td>
									<input type="hidden" name="id" value="${user.id}">
								</td>
							</tr>
							<tr>
								<td class="a_r">
									头像：

								</td>
								<td>
									<input type="file" name="photo" />
									<div
										style="width: 100px; height: 100px; position: absolute; top: 265px; left: 220px;">
										<img alt="" src="${user.photo }" style="width: 80px;height: 80px;">
									</div>
								</td>
							</tr>
							<tr>
								<td class="a_r ">
									<label for="fname">
										名字：
									</label>
								</td>
								<td>
									<input name="fname" id="fname" value="${user.name}" type="text"
										onfocus="updateRed('fname')" onblur="checkFname()" />
									<span id="fname_msg"></span>
								</td>
							</tr>
							<tr>
								<td class="a_r">
									<label for="lname">
										姓氏：
									</label>
								</td>
								<td>
									<input name="lname" id="lname" value="${user.family_name}"
										type="text" onfocus="updateRed('lname')" onblur="checkLname()" />
									<span id="lname_msg"></span>
								</td>
							</tr>
							<tr>
								<td class="a_r">
									<label for="email">
										电子邮箱：
									</label>
								</td>
								<td>
									<input name="email" id="email" value="${user.email}"
										type="text" onfocus="updateRed('email')" onblur="checkEmail()" />
									<span id="email_msg">格式如：xxx@xx.xx（.xx）</span>
								</td>
							</tr>
							<tr>
								<td class="a_r">
									<label for="gender">
										性别：
									</label>
								</td>
								<td>
									<c:if test="${user.sex=='男'}" var="sex">
										<input name="gender" id="gender" class="b0" type="radio"
											value="男" checked="checked" />
										<img src="images/Male.gif" alt="alt" />男&nbsp; 
    	   						<input name="gender" class="b0" type="radio" value="女" />
										<img src="images/Female.gif" alt="alt" />女
								</c:if>
									<c:if test="${!sex}">
										<input name="gender" id="gender" class="b0" type="radio"
											value="男" />
										<img src="images/Male.gif" alt="alt" />男&nbsp; 
    	   						<input name="gender" class="b0" type="radio" value="女"
											checked="checked" />
										<img src="images/Female.gif" alt="alt" />女
								</c:if>
								</td>
							</tr>

							<tr>
								<td class="a_r">
									<label for="hobby">
										爱好：
									</label>
								</td>
								<td>
									<c:forEach items="${enjoy}" var="e" varStatus="i">
										<c:if test="${i.count==1}">
											<c:if test="${e!=''}" var="e1">
												<input class="b0" type="checkbox" name="hobby" id="hobby"
													value="sports" checked="checked" />&nbsp;运动&nbsp;&nbsp;
									</c:if>
											<c:if test="${!e1}">
												<input class="b0" type="checkbox" name="hobby" id="hobby"
													value="sports" />&nbsp;运动&nbsp;&nbsp;
									</c:if>
										</c:if>
										<c:if test="${i.count==2}">
											<c:if test="${e!=''}" var="e2">
												<input class="b0" type="checkbox" name="hobby" value="chat"
													checked="checked" />&nbsp;聊天&nbsp;&nbsp;
									</c:if>
											<c:if test="${!e2}">
												<input class="b0" type="checkbox" name="hobby" value="chat" />&nbsp;聊天&nbsp;&nbsp;
									</c:if>
										</c:if>
										<c:if test="${i.count==3}">
											<c:if test="${e!=''}" var="e3">
												<input class="b0" type="checkbox" name="hobby"
													value="playgames" checked="checked" />&nbsp;玩游戏
									</c:if>
											<c:if test="${!e3}">
												<input class="b0" type="checkbox" name="hobby"
													value="playgames" />&nbsp;玩游戏
									</c:if>
										</c:if>
										<c:if test="${i.count==4}">
											<c:if test="${e!=''}" var="e4">
												<input class="b0" type="checkbox" name="hobby"
													value="readbook" checked="checked" />&nbsp;看书
									</c:if>
											<c:if test="${!e4}">
												<input class="b0" type="checkbox" name="hobby"
													value="readbook" />&nbsp;看书
									</c:if>
										</c:if>


									</c:forEach>
								</td>
							</tr>
							<tr>
								<td class="a_r">
									<label for="nYear">
										出生日期：
									</label>
								</td>
								<td>
									<input name="nYear" id="nYear" class="w40" maxlength="4"
										value="${birth[0]}" />
									&nbsp;年&nbsp;&nbsp;
									<select name="nMonth" id="nMonth">
										<option value="">
											[选择月份]
										</option>
										<c:if test="${birth[1]=='01'}" var="b1">
											<option value="1" selected="selected">
												一月
											</option>
										</c:if>
										<c:if test="${!b1}">
											<option value="1">
												一月
											</option>
										</c:if>
										<c:if test="${birth[1]=='02'}" var="b2">
											<option value="2" selected="selected">
												二月
											</option>
										</c:if>
										<c:if test="${!b2}">
											<option value="2">
												二月
											</option>
										</c:if>
										<c:if test="${birth[1]=='03'}" var="b3">
											<option value="3" selected="selected">
												三月
											</option>
										</c:if>
										<c:if test="${!b3}">
											<option value="3">
												三月
											</option>
										</c:if>
										<c:if test="${birth[1]=='04'}" var="b4">
											<option value="4" selected="selected">
												四月
											</option>
										</c:if>
										<c:if test="${!b4}">
											<option value="4">
												四月
											</option>
										</c:if>
										<c:if test="${birth[1]=='05'}" var="b5">
											<option value="5" selected="selected">
												五月
											</option>
										</c:if>
										<c:if test="${!b5}">
											<option value="5">
												五月
											</option>
										</c:if>
										<c:if test="${birth[1]=='06'}" var="b6">
											<option value="6" selected="selected">
												六月
											</option>
										</c:if>
										<c:if test="${!b6}">
											<option value="6">
												六月
											</option>
										</c:if>
										<c:if test="${birth[1]=='07'}" var="b7">
											<option value="7" selected="selected">
												七月
											</option>
										</c:if>
										<c:if test="${!b7}">
											<option value="7">
												七月
											</option>
										</c:if>
										<c:if test="${birth[1]=='08'}" var="b8">
											<option value="8" selected="selected">
												八月
											</option>
										</c:if>
										<c:if test="${!b8}">
											<option value="8">
												八月
											</option>
										</c:if>
										<c:if test="${birth[1]=='09'}" var="b9">
											<option value="9" selected="selected">
												九月
											</option>
										</c:if>
										<c:if test="${!b9}">
											<option value="9">
												九月
											</option>
										</c:if>
										<c:if test="${birth[1]=='10'}" var="b10">
											<option value="10" selected="selected">
												十月
											</option>
										</c:if>
										<c:if test="${!b10}">
											<option value="10">
												十月
											</option>
										</c:if>
										<c:if test="${birth[1]=='11'}" var="b11">
											<option value="11" selected="selected">
												十一月
											</option>
										</c:if>
										<c:if test="${!b11}">
											<option value="11">
												十一月
											</option>
										</c:if>
										<c:if test="${birth[1]=='12'}" var="b12">
											<option value="12" selected="selected">
												十二月
											</option>
										</c:if>
										<c:if test="${!b12}">
											<option value="12">
												十二月
											</option>
										</c:if>
									</select>
									<input name="nDay" id="nDay" class="w40" maxlength="2"
										value="${birth[2]}" />
									日
									<span id="birth_msg"></span>
								</td>
							</tr>
							<tr>
								<td colspan="2" class="pl150">
									<input type="image" name="submit" class="b0"
										src="images/submit.gif" />
									<img src="images/reset.gif" class="hand" alt="重填"
										onclick="Reset()" />
								</td>
							</tr>


							<tr>
								<td>
									<a href="javascript:change('oldpass');"> <font color="red"
										size="4">修改密码</font> </a>
								</td>
							</tr>

						</table>
					</form>
				</div>
				<div id="oldpass" class="s1">
				<h2>
						<a href="javascript:change('firpage');">知识堂首页</a>&gt;&gt;<a href="javascript:change('user');">个人资料修改</a>&gt;&gt;用户密码确认
				</h2>
				<p>
					<img src="images/reg_line.jpg" alt="alt" />
				</p>
					<!-- 输入密码已确认修改 -->
					<table align="center">
						<tr>
							<td>
								<p style="color: blue;">请输入您的密码:</p>
							</td>
							<td>
								<input type="password" id="oldpassword" />
								<span id="oldpasswordmsg"></span>
								<input type="button" value="确认" style="background-color: orange;"  onclick="checkoldpassword();" />
							</td>
						</tr>
					</table>
				</div>
				<!-- 输入密码借书 -->

				<div id="modifypass" class="s1">
				<h2>
						<a href="javascript:change('firpage');">知识堂首页</a>&gt;&gt;<a href="javascript:change('user');">个人资料修改</a>&gt;&gt;<a href="javascript:change('oldpass');">用户密码确认&gt;&gt;</a>修改新密码
				</h2>
				<p>
					<img src="images/reg_line.jpg" alt="alt" />
				</p>
					<!-- 开始修改密码 -->
						<table>
							<tr>
								<td>
									<p style="color: blue;">请输入新的密码:</p>
								</td>
								<td>
									<input type="password" id="newpassword" name="newpassword" onblur="checknewPass();" />
									<span id="pass_msg"></span>
								</td>
							</tr>
							<tr>
								<td>
									<p style="color: blue;">再次输入密码:</p>
								</td>
								<td>
									<input type="password" id="newpasswordagn"
										name="newpasswordagn" onblur="checknewRpass();"/>
										<span id="rpass_msg"></span>
								</td>
							</tr>
							<tr>
								<td colspan="2">
								<input type="button" value="提交" style="background-color: orange;" onclick="modifypass();" />
							</td>
							</tr>
						</table>
					
				</div>

			</div>
		<iframe id="footer" src="footer.jsp" width="980" height="150"
			frameborder="0" scrolling="no"></iframe>
	</div>
	<!--container	end-->
</body>
</html>
