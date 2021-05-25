/**
 * 
 */
var flag=0;
s = new Array("email", "username", "password", "PassTwo");

function emailCheck()
{
	var email = document.getElementById("email");
	if(email.value.length < 2){
		document.getElementById("1").innerHTML="邮箱长度错误";
	}
	else{
		document.getElementById("1").innerHTML="";
		flag++;
	}
}

function usernameCheck()
{
	var username = document.getElementById("username");
	if(username.value.length < 6){
		document.getElementById("2").innerHTML="账号长度错误";
	}
	else{
		document.getElementById("2").innerHTML="";
		flag++;
	}
}

function passwordCheck()
{
	password = document.getElementById("password");
	if(password.value.length < 6){
		document.getElementById("3").innerHTML="密码长度错误";
	}
	else{
		document.getElementById("3").innerHTML="";
		flag++;
	}
}

function PassTwoCheck()
{
	var PassTwo = document.getElementById("PassTwo");
	if(PassTwo.value != password.value){
		document.getElementById("4").innerHTML="两次输入密码不一致";
	}
	else{
		document.getElementById("4").innerHTML="";
		flag++;
	}
}

function SubmitCheck()
{
	var f = true;
	for(i = 0; i < 4; ++i)
		if(document.getElementById(s[i]).value == "")
		{
			f = false;
			break;
		}
	for(j = 1; j <= 4; ++j)
		if(document.getElementById("" + j).innerHTML != ""){
			f = false;
			break;
		}
	if(f) {
		document.getElementById("submit").disabled = false;
		document.getElementById("submit").style.background = "red";
		document.getElementById("恭喜你！注册成功！");
	}
	setTimeout("SubmitCheck()", 1000);
}