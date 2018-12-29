<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="css/style1.css" rel='stylesheet' type='text/css' />
<!--webfonts-->

<!--//webfonts-->
<!-- js -->
<script src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
<!-- //js -->
<!-- cart -->
<script src="js/simpleCart.min.js"> </script>
<!-- cart -->
<!-- hhx -->
</head>
<body style="position:fixed;width:100%;background-size: cover;height:100%;background-image: url('images/login1.jpg')">
	<script type="text/javascript">
		function checkUserName(q){
			var name=$("#username").val();
			var role=$("#identity").val();
			var result=false;
			
			if(name==""||name==null){
				$("#checkUserName").text("用户名为空！");
				
				
			}else{
				
				$.ajax({
					url : "judgeUserName?username="+name+"&role="+role,
					async : q,
					type : "POST",
					success : function(res) {
						if (res == "ok") {
							if(role=="student"){
								
								$("#checkUserName").text("初始密码为“1111”!");
							}else{
								$("#checkUserName").text(" ");
							}
							result=true;
						} else {
							
							$("#checkUserName").text("无权限访问!");
							
							result=false;
						}
					}
				});
			}
			
			return result;
		};
		function checkPassword(){
			var word=$("#password").val();
			var news=false;
			if(word==""||word==null){
				$("#checkPassword").text("密码为空！");
			}else{
				news=true;
				$("#checkPassword").text("");
			}
			return news;
		}
		function checkLogin(){
			
			var name=$("#username").val();
			var word=$("#password").val();
			var role=$("#identity").val();
			
			var result=false;
			if(checkUserName(false)&&checkPassword()){
				
				$.ajax({
					url : "judgeLogin?username="+name+"&password="+word+"&role="+role,
					async : false,
					type : "POST",
					success : function(res) {
						if (res == "ok") {
							
							$("#checkLogin").text("");
							result=true;
						} else {
							//alert("密码不正确！");
							$("#checkPassword").text("密码不正确！");
							result=false;
						}
					}
				});
			}else{
				
				return false;
			}
			return result;
		}
		function chooseRole(){
			var role=$("#identity").val();
			return role;
		}
	</script>
	<div style="height:100px;">
		<img alt="" src="images/logo7.png" width="180px";height="140px" style="margin-top:15px;margin-left:60px">
	</div>
	<!-- <h1 style="font-family: 'Exo 2', sans-serif;
	  text-align: center;
	  padding-top: 0em;
	  font-weight: 40;
	  color: #EBEBEB;
	  font-size: 3em;">&nbsp;t</h1> -->
	<div class="login-form" style="" >
		<!-- <div class="head-info"></div>#40E0D0 -->
		<!-- <div class="clear"></div> -->
		
		<!--登陆界面角色选择-->
		<form id="login_test" action="login" method="post" onsubmit=" return checkLogin();" style="opacity: 1;">
			<div style="width:600px">
				<span style="width:60px;font-size: 20px;font-family: 'Exo 2', sans-serif;">用户名</span>
				<input type="text" class="text" name="username" style=" "id="username" onblur="checkUserName(false);">
			</div>
			<div style="width:600px;height:2em;text-align: center">
				<span id="checkUserName" style="color:red; font-size: 20px;margin-top:1em;"></span>
			</div>
				<!--onfocus="this.value = '';"  -->
			<div style="width:600px">
				<span style="width:60px;font-size: 20px;font-family: 'Exo 2', sans-serif;">密&nbsp;&nbsp;&nbsp;码</span>
				<input type="password" name="password"style=" " id="password" onblur="checkPassword();">
			</div>
			<span id="checkPassword" style="color:red; font-size: 20px;margin-top:1em;"></span><br>
			<select name="identity" id="identity" onclick="checkUserName(false);"
			style="width:100px;height:30px;margin-bottom:1em;margin-left:auto; margin-right:auto;margin-top:1em;opacity: 1;">
				<option value="teacher">教师</option>
				<option value="student">学生</option>
				<option value="manager">管理员</option>
			</select>
			<!-- <div class="key">
				
			</div> -->
			<div class="signin">
				<input type="submit" id="submit" value="submit" style="">
				<span id="checkLogin" style="color: black; font-size: 20px"></span>
				
			</div>
		</form>
		
		
	</div>
	
	<div class="copy-rights" style="text-align: center;margin-top:3em;color:white">
		<p>Copyright &copy; 2018.team javaScript All rights reserved.</p>
	</div>
</body>
</html>