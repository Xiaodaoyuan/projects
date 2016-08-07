function updateRed(obj) {
	$("#" + obj).addClass("updatered");
}

function checkAdmin_name() {
	
	$.post('username.dologin',{
		'admin_username' : $("#admin_username").val()
	
	}, function(data) {
		//alert(data);
		//alert(typeof data);
		if (data == "the administer is not exist") {
			//alert("fff");
			$("#admin_name_msg").html("该管理员不存在！");
			$("#admin_name_msg").css({color : "red"});
			$("#h1").val("false");
			return false;
		}else if(data == "the administer is null"){
			$("#admin_name_msg").html("管理员用户名不能为空！");
			$("#admin_name_msg").css({color : "red"});
			$("#h1").val("false");
			return false;
		}else {
			$("#admin_name_msg").html("");
			$("#admin_username").removeClass("updatered");
			$("#h1").val("true");
			return true;
		}
			
	});
}

function checkAdmin_password() {
	$.post('password.dologin',{'admin_username' : $("#admin_username").val(),
		'admin_password' : $("#admin_password").val()
	}, function(data) {
		if (data == "the password is null") {
			$("#admin_password_msg").html("密码不能为空!");
			$("#admin_password_msg").css({color : "red"});
			$("#h2").val("false");
			return false;
		}else if(data == "error password"){
			$("#admin_password_msg").html("密码错误!");
			$("#admin_password_msg").css({color : "red"});
			$("#h2").val("false");
			return false;
		}else if(data == "the administer is null"){
			$("#admin_password_msg").html("请先输入管理员用户名!");
			$("#admin_password_msg").css({color : "red"});
			$("#h2").val("false");
			return false;
		}else{
			$("#admin_password_msg").html("");
			$("#admin_password").removeClass("updatered");
			$("#h2").val("true");
			return true;
		}
	});
}
function checkCode() {
	$.post('code.dologin',{'admin_username' : $("#admin_username").val(),
		'admin_password' : $("#admin_password").val(),'vericode' : $("#vericode").val()
	}, function(data) {
		
		if (data == "false") {
			
			$("#code_msg").html("验证码错误!");
			$("#code_msg").css({color : "red"});
			$("#h3").val("false");
			return false;
		}else {
			$("#code_msg").html("");
			$("#vericode").removeClass("updatered");
			$("#h3").val("true");
			return true;
		}
	});
}

function checkTrue(){

	if($("#h1").val()=="true"&&$("#h2").val()=="true"&&$("#h3").val()=="true"){
		return true;
	}
		
//		return true;
	return false;
	
}

