function checkFname() {
	var reg = /^([\u4E00-\u9FA5]){1,}$/;
	if (!reg.test($("#admin_fname").val())) {
		$("#fname_msg").html("姓氏必须是汉字！");
		$("#fname_msg").css({
			color : "red"
		});
		return false;
	}
	$("#fname_msg").html(
			"<img src='images/right.jpg' width='20px' height='20px'/>");
	return true;
}

function checkName() {
	var reg = /^([\u4E00-\u9FA5]){1,}$/;
	if (!reg.test($("#admin_name").val())) {
		$("#name_msg").html("名字必须是汉字！");
		$("#name_msg").css({
			color : "red"
		});
		return false;
	}
	$("#name_msg").html(
			"<img src='images/right.jpg' width='20px' height='20px'/>");
	return true;
}

function checkUsername() {
//	$("#d1").html("");
	var reg = /^\w{4,16}$/;
	if (!reg.test($("#admin_username").val())) {
		$("#username_msg").html("登录名必须由数字、下划线或字母字符组成的4-16位字符");
		$("#username_msg").css({
			color : "red"
		});
		return false;
	}
	$.post('checkUsername', {
		'admin_username' : $("#admin_username").val()
	}, function(data) {
		if (data == "true") {
			$("#username_msg").html("登录名已经被注册！");
			$("#username_msg").css({color : "red"});
			//$("#h1").val("false");
		}else{
			$("#username_msg").html(
			"<img src='images/right.jpg' width='20px' height='20px'/>");
		//	$("#admin_username").removeClass("updatered");
			//$("#h1").val("true");
		}
	});
	return true;
	
}

function checkPassword() {
	var reg = /^[0-9a-zA-Z]{6,}$/;
	if (!reg.test($("#admin_password").val())) {
		$("#password_msg").html("密码必须由字母或数字组成的不少于6位字符！");
		$("#password_msg").css({color : "red"});
		return false;
	}
	//$("#pass").removeClass("updatered");
	$("#password_msg").html(
			"<img src='images/right.jpg' width='20px' height='20px'/>");
	return true;
}



function checkEmail() {
	var reg = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]{2,}(\.[a-z0-9]{2,5}){1,2}$/;
	if (!reg.test($("#admin_email").val())) {
		$("#email_msg").html("邮箱格式不正确！");
		$("#email_msg").css({color : "red"});
		return false;
	}
	//$("#admin_email").removeClass("updatered");
	$("#email_msg").html(
			"<img src='images/right.jpg' width='20px' height='20px'/>");
	return true;
}

function checkBirthdate(){
	var reg = /^\d{4}-\d{2}-d{2}$/;
	if (!reg.test($("#admin_birth").val())) {
	
	
		$("#birthdate_msg").html("出生日期格式不正确！");
		$("#birthdate_msg").css({color : "red"});
		return false;
	}$("#birthdate_msg").html(
			"<img src='images/right.jpg' width='20px' height='20px'/>");
	return true;
}

function checkTrue() {
	if (checkFname() && checkName() && checkUsername() && checkPassword()
			 && checkEmail() && checkBirthdate())
		return true;
	return false;
}