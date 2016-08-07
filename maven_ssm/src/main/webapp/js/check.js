function updateRed(obj) {
	$("#" + obj).addClass("updatered");
}

function checkFname() {
	var reg = /^([\u4E00-\u9FA5]){1,}$/;
	if (!reg.test($("#fname").val())) {
		$("#fname_msg").html("名字必须是汉字！");
		$("#fname_msg").css({color : "red"});
		return false;
	}
	$("#fname").removeClass("updatered");
	$("#fname_msg").html(
			"<img src='images/right.jpg' width='20px' height='20px'/>");
	return true;
}

function checkLname() {
	var reg = /^([\u4E00-\u9FA5]){1,}$/;
	if (!reg.test($("#lname").val())) {
		$("#lname_msg").html("姓氏必须是汉字！");
		$("#lname_msg").css({color : "red"});
		return false;
	}
	$("#lname").removeClass("updatered");
	$("#lname_msg").html(
			"<img src='images/right.jpg' width='20px' height='20px'/>");
	return true;
}

function checkSname() {
	$("#d1").html("");
	var reg = /^\w{4,16}$/;
	if (!reg.test($("#sname").val())) {
		$("#sname_msg").html("登录名必须由数字、下划线或字母字符组成的4-16位字符");
		$("#sname_msg").css({color : "red"});
		return false;
	}
	$.post('checkUsername',{'sname' : $("#sname").val()},
	  function(data) {
		if (data == "true") {
			$("#sname_msg").html("登录名已经被注册！");
			$("#sname_msg").css({color : "red"});
			$("#h1").val("false");
		} else {
			$("#sname_msg").html("<img src='images/right.jpg' width='20px' height='20px'/>");
			$("#sname").removeClass("updatered");
			$("#h1").val("true");
		}
	});
	return true;

}

function checkPass() {
	var reg = /^[0-9a-zA-Z]{6,}$/;
	if (!reg.test($("#pass").val())) {
		$("#pass_msg").html("密码必须由字母或数字组成的不少于6位字符！");
		$("#pass_msg").css({
			color : "red"
		});
		return false;
	}
	$("#pass").removeClass("updatered");
	$("#pass_msg").html(
			"<img src='images/right.jpg' width='20px' height='20px'/>");
	return true;
}

function checkRpass() {
	if ($("#pass").val() != $("#rpass").val()) {
		$("#rpass_msg").html("两次密码不一致！");
		$("#rpass_msg").css({
			color : "red"
		});
		return false;
	}
	if ($("#rpass").val() == "") {
		$("#rpass_msg").html("密码不能为空！");
		$("#rpass_msg").css({
			color : "red"
		});
		return false;
	}
	$("#rpass").removeClass("updatered");
	$("#rpass_msg").html(
			"<img src='images/right.jpg' width='20px' height='20px'/>");
	return true;
}

function checkEmail() {
	var reg = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]{2,}(\.[a-z0-9]{2,5}){1,2}$/;
	if (!reg.test($("#email").val())) {
		$("#email_msg").html("邮箱格式不正确！");
		$("#email_msg").css({
			color : "red"
		});
		return false;
	}
	$("#email").removeClass("updatered");
	$("#email_msg").html(
			"<img src='images/right.jpg' width='20px' height='20px'/>");
	return true;
}

function checkBirthdate() {
	if ($("#nYear").val() == "" || $("#nMonth").val() == ""
			|| $("#nDay").val() == "") {
		$("#birth_msg").html("出生日期不完整！");
		$("#birth_msg").css({
			color : "red"
		});
		return false;
	} else {
		var reg = /^19[0-9][0-9]$|^200[0-9]$|^201[0-4]$/;
		var reg1 = /^[0-9]$|^[0-2][0-9]$|^3[0-1]$/;
		if (!reg.test($("#nYear").val()) || !reg1.test($("#nDay").val())) {
			$("#birth_msg").html("出生日期格式不正确！");
			$("#birth_msg").css({
				color : "red"
			});
			return false;
		}
	}
	return true;
}

function checkCode(){
	$.ajax({
		'url':'checkCode',
		'type':'post',
		'data':'usercode=' + $("#code").val(),
		'dataType':'text',
		'success':function(data){
		if (data == "true") {
			$("#code_msg").html("验证码错误！");
			$("#code_msg").css({color : "red"});
			$("#h2").val("false");
		} else {
			$("#code_msg").html("<img src='images/right.jpg' width='20px' height='20px'/>");
			$("#code").removeClass("updatered");
			$("#h2").val("true");
		}
	}});
}

function checkTrue() {
	if (checkFname() && checkLname() && checkSname() && checkPass()
			&& checkRpass() && checkEmail() && $("#h1").val() == "true" 
			&&$("#h2").val() == "true"&& checkBirthdate())
		return true;
	return false;
}

function Reset() {
	document.forms[0].reset();
	$("span:eq(0)").html("");
	$("span:eq(1)").html("");
	$("span:eq(2)").html("（可包含字母数字和下划线的4至16位）");
	$("span:eq(3)").html("（至少包含 6 个字符）");
	$("span:eq(4)").html("");
	$("span:eq(5)").html("格式如：xxx@xx.xx（.xx）");
	$("span:eq(6)").html("");
	$("span:eq(7)").html("");
	$("input").removeClass("updatered");
	$("span").css({
		color : "black"
	});
}