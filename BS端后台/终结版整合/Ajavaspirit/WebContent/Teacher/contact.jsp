<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
	<title>Ttool</title>
	<!--/tags -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="Surf Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
	<script type="application/x-javascript">
		addEventListener("load", function () {
			setTimeout(hideURLbar, 0);
		}, false);

		function hideURLbar() {
			window.scrollTo(0, 1);
		}
	</script>
	<!--//tags -->
	<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" property="" />
	<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
	<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
	<link rel="stylesheet" type="text/css" href="css/contact.css">
	<link href="css/font-awesome.css" rel="stylesheet">
	<!-- //for bootstrap working -->
	<script type="text/javascript">
		function checkPassword(){
			//获取表单name存储的值
			var word0=document.getElementById("password").value;
			var word1=document.getElementById("password1").value;
			if(word0==""||word1==""){
				document.getElementById("msg").innerHTML="密码不可以为空！";
				return false;
			} else{
				
				if(word0==word1){
					document.getElementById("msg").innerHTML="您的密码一致 ！";
					return true;
				}else{
					document.getElementById("msg").innerHTML="您的密码不一致 ！";
					return false;
				}  
			}
		}
	</script>
</head>

<body>
	<!-- header_top -->
	<div class="header" id="home">
		<%@include file="head.jsp" %>
		<!-- banner -->
          <!-- <div class="banner_inner">
                   <div class="services-breadcrumb">
						<div class="inner_breadcrumb">

							<ul class="short">
								<li><a href="index.jsp">首页</a><i>|</i></li>
								<li>修改信息</li>
							</ul>
						</div>
					</div>

		  </div> -->
		<!--//banner -->

	</div>
	<!--// header_top -->
<!-- top Products -->
	<div class="ab_content" style="background:url(images/banner1.jpg) no-repeat;    background-size: 120%;width:100%;heigth:100%;">
		<div class="container" style="width:400px;">
			<div class="row">
							<div class="col-md-5 contact_grid_right" style="background-color:rgba(255,255,255,0.6);width: 400px;" >
								<h1 style="border-bottom:solid 3px #000;padding-bottom:15px;margin-bottom:15px;margin-top:20px;margin-left:10px;">修改信息</h1>
								<form action="../Teacher/password" method="post" style=""onsubmit="return checkPassword();">
								<div class="col-md-12 col-sm-6 contact_left_grid">
											<span>姓名：&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp ${name}</span><br>
										密码：&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input  type="password" id="password" name="password" onblur="checkPassword();"  style="margin-top:10px;margin-bottom:10px;"><span id="weektip" style=color:#f00></span><br>
										确认密码：<input type="password" id="password1" style="margin-bottom:8px"name="password1"  required="" onblur="checkPassword();"><span id="cnametip" style=color:#f00></span><br>
										<span id="msg" style="color: red; font-size: 14px;text-align: center"></span>
										<br>
										<div class="clearfix"> </div>
										<input type="submit" value="提交" style=" font-size: 14px;width: 240px;background-color:#FFA07A;margin-top:8px;padding-left:0px;margin-bottom:20px">
									 
										
										
									</div>
								</form>
								
								
								
								
								
			
			
			
			<!-- <h3 class="tittle-w3ls">&nbsp&nbsp修改信息</h3>
					
						<div class="inner_sec_info_w3ls_agile">
							<div class="col-md-7 contact_grid_right">
								<h6>请填写如下表格的信息.</h6>
								<form action="../Teacher/password" method="post" style=""onsubmit="return checkPassword();">
									<div class="col-md-6 col-sm-6 contact_left_grid">
										<input type="text" name="name" placeholder="姓名" required="">
										<span>姓名：&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp ${name}</span><br>
										<span>&nbsp</span><br>
										密码：&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
										<input type="password" id="password" name="password" onblur="checkPassword();" placeholder="密码" required="">
										
										<br>
										<span>&nbsp</span><br>
										确认密码：
										<input type="password" id="password1" style="margin-bottom:8px"name="password1" placeholder="密码" required="" onblur="checkPassword();">
										<br>
										
										<span id="msg" style="color: red; font-size: 14px;text-align: center"></span>
										<br>
										
									</div>
									
									<div class="clearfix"> </div>
										<input type="submit" value="提交" style=" font-size: 14px;width: 240px;background-color:#FFA07A;margin-top:8px;padding-left:0px">
									 
								</form>
							</div>
							<div class="col-md-5 contact-left">
								<h6>信息列表</h6>
								<div class="visit">
									<div class="col-md-2 col-sm-2 col-xs-2 contact-icon">
										<span class="fa fa-home" aria-hidden="true"></span>
									</div>
									<div class="col-md-10 col-sm-10 col-xs-10 contact-text">
										<h4>学校地址</h4>
										<p>河北师范大学</p>
									</div>
									<div class="clearfix"></div>
								</div>
								<div class="mail-us">
									<div class="col-md-2 col-sm-2 col-xs-2 contact-icon">
										<span class="fa fa-envelope" aria-hidden="true"></span>
									</div>
									<div class="col-md-10 col-sm-10 col-xs-10 contact-text">
										<h4>联系邮箱</h4>
										<p><a href="mailto:info@example.com">henunavy@gmail.com</a></p>
									</div>
									<div class="clearfix"></div>
								</div>
								<div class="call">
									<div class="col-md-2 col-sm-2 col-xs-2 contact-icon">
										<span class="fa fa-phone" aria-hidden="true"></span>
									</div>
									<div class="col-md-10 col-sm-10 col-xs-10 contact-text">
										<h4>联系电话</h4>
										<p>+(86)15227129157</p>
									</div>
									<div class="clearfix"></div>
								</div>
								
							</div>
							<div class="clearfix"> </div>

						</div>

			<div class="clearfix"></div> -->
			
		</div>
	</div>
	</div>
	</div>
	<div class="clearfix"></div>

	<!-- footer -->
	<footer>
		<div class="footer-top-w3-agileits">
			<div class="container">
				
				<div style="margin-top:0px;color:white;text-align: center">
					<p>© 2018 TTOOL . All rights reserved | Design by javaspirit</p>
				</div>
			</div>
		</div>

	</footer>
	<!-- //footer -->
	<a href="#home" class="scroll" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
	<!-- js -->
	<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>

	<!--search-bar-->
	<script src="js/search.js"></script>
	<!--//search-bar-->
			
<!-- start-smoth-scrolling -->
	<script type="text/javascript" src="js/move-top.js"></script>
	<script type="text/javascript" src="js/jquery.easing.min.js"></script>
	<script type="text/javascript">
		jQuery(document).ready(function ($) {
			$(".scroll").click(function (event) {
				event.preventDefault();

				$('html,body').animate({
					scrollTop: $(this.hash).offset().top
				}, 1000);
			});
		});
	</script>
	<!-- //end-smooth-scrolling -->
	<script>
		$('ul.dropdown-menu li').hover(function () {
			$(this).find('.dropdown-menu').stop(true, true).delay(200).fadeIn(500);
		}, function () {
			$(this).find('.dropdown-menu').stop(true, true).delay(200).fadeOut(500);
		});
	</script>
   
	<!-- flexSlider -->
	<script defer src="js/jquery.flexslider.js"></script>
	<script type="text/javascript">
		$(window).load(function () {
			$('.flexslider').flexslider({
				animation: "slide",
				start: function (slider) {
					$('body').removeClass('loading');
				}
			});
		});
	</script>
	<!-- //flexSlider -->
	<!-- smooth-scrolling-of-move-up -->
	<script type="text/javascript">
		$(document).ready(function () {
			/*
			var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
			};
			*/

			$().UItoTop({
				easingType: 'easeOutQuart'
			});

		});
	</script>
	<!-- //smooth-scrolling-of-move-up -->
	<!-- Pricing-Popup-Box-JavaScript -->
	<script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
	<!-- //Pricing-Popup-Box-JavaScript -->
	<script type="text/javascript" src="js/bootstrap.js"></script>
</body>

</html>