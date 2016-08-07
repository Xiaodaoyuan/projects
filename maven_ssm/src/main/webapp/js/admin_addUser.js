function checkFname() {
	var reg = /^([\u4E00-\u9FA5]){1,}$/;
	if (!reg.test($("#admin_fname").val())) {
		$("#fname_msg").html("���ϱ����Ǻ��֣�");
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
		$("#name_msg").html("���ֱ����Ǻ��֣�");
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
		$("#username_msg").html("��¼�����������֡��»��߻���ĸ�ַ���ɵ�4-16λ�ַ�");
		$("#username_msg").css({
			color : "red"
		});
		return false;
	}
	$.post('checkUsername', {
		'admin_username' : $("#admin_username").val()
	}, function(data) {
		if (data == "true") {
			$("#username_msg").html("��¼���Ѿ���ע�ᣡ");
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
		$("#password_msg").html("�����������ĸ��������ɵĲ�����6λ�ַ���");
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
		$("#email_msg").html("�����ʽ����ȷ��");
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
	
	
		$("#birthdate_msg").html("�������ڸ�ʽ����ȷ��");
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