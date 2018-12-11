<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<meta name="keywords"
	content="Flat Dark Web Login Form Responsive Templates, Iphone Widget Template, Smartphone login forms,Login form, Widget Template, Responsive Templates, a Ipad 404 Templates, Flat Responsive Templates" />
<link href="css/style.css" rel='stylesheet' type='text/css' />
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
<body>
	<script type="text/javascript">
		/* $(document).ready(function(c) {
			$('.close').on('click', function(c) {
				$('.login-form').fadeOut('slow', function(c) {
					$('.login-form').remove();
				});
			});
		}); */
		//检查用户名是否为空
		
		function checkUserName(){
			var name=$("#username").val();
			var role=$("#identity").val();
			
			var req=false;
			if(name==""||name==null){
				$("#checkUserName").text("用户名为空！");
			}else{
				$.ajax({
					url : "judgeUserName?username="+name+"&role="+role,
					async : true,
					type : "POST",
					success : function(res) {
						if (res == "ok") {
							$("#checkUserName").text("初始密码为“1111”!");
							req = true;
						} else {
							$("#checkUserName").text("未注册!");
							req = false;
						}
					}
				});
			}
			return req;	
		};
		function checkPassword(){
			var word=$("#password").val();
			var news=false;
			if(word==""||word==null){
				$("#checkPassword").text("密码为空！");
			}else{
				news=true;
			}
			return news;
		}
		function checkLogin(){
			var name=$("#username").val();
			var word=$("#password").val();
			var role=$("#identity").val();
			if(checkUserName()&&checkPassword()){
				$.ajax({
					url : "judgeLogin?username="+name+"&password="+word+"&role="+role,
					async : true,
					type : "POST",
					success : function(res) {
						if (res == "ok") {
							$("#checkLogin").text("");
							return true;
						} else {
							$("#checkLogin").text("密码不正确！");
							return false;
						}
					}
				});
			}else{
				return false;
			}
		}
		function chooseRole(){
			var role=$("#identity").val();
			return role;
		}
		//ajax提交信息
		/* $("#login_test").submit(
				function() {
					//parent.layer.close(index); //再执行关闭
					String identity = document.getElementById("identity").value;
					String username = document.getElementById("username").value;
					String password = document.getElementById("password").value;
					$.ajax({
						async : false,
						type : "POST",
						url : "login",
						/*  contentType : "application/x-www-form-urlencoded; charset=utf-8", */
						/* data : $("#apply_link_form").serialize(),
						dataType : "text",
						success : function(data) {
							if(data=="ok"){
								$("#news").text("邮箱为空");
							}else{
								
							}
						},
						error : function() {
						}
					})
				}) */ 
	</script>
	
	
	
	<!--SIGN UP-->
	<h1>Login Interface of Teaching Platform</h1>
	<div class="login-form">
		<div class="head-info"></div>
		<div class="clear"></div>
		<div class="avtar">
			<img src="images/avtar.png" />
		</div>
		<!--登陆界面角色选择-->
		<form id="login_test" action="login" method="post" onsubmit="checkLogin();">
			<select name="identity" id="identity" >
				<option value="teacher">教师</option>
				<option value="student">学生</option>
				<option value="manager">管理员</option>
			</select>
			<input type="text" class="text" name="username" id="username" onblur="checkUserName();">
			<span id="checkUserName" style="color: white; font-size: 20px"></span>
				<!--onfocus="this.value = '';"  -->
			<input type="password" name="password" id="password" onblur="checkPassword();">
			<span id="checkPassword" style="color: white; font-size: 20px"></span>
			<div class="key">
			</div>
			<div class="signin">
				<input type="submit" id="submit" value="submit"><span id="checkLogin" style="color: white; font-size: 20px"></span>
				
			</div>
		</form>
	</div>
	<div class="copy-rights">
		<p>Copyright &copy; 2015.Company name All rights reserved.</p>
	</div>

</body>
</html>