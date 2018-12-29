<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>

<head>
	<title> PassWord</title>
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
	
	
	
		<%@ include file="header.jsp" %>
		
		
		
		
		<!-- banner -->
          <div class="banner_inner" style="background-image:url('images/banner3.jpg')">
                   <div class="services-breadcrumb">
						<div class="inner_breadcrumb">

							<ul class="short">
								<li><a href="index.jsp" style="color:#00BFFF">首页</a><i>|</i></li>
								<li>修改信息</li>
							</ul>
						</div>
					</div>

		  </div>
		<!--//banner -->

		
	</div>
	<!--// header_top -->
<!-- top Products -->

<!--hhx  -->
	<div class="ab_content">
		<div class="container">
			<h3 class="tittle-w3ls">&nbsp&nbsp修改信息</h3>
					
						<div class="inner_sec_info_w3ls_agile">
							<div class="col-md-7 contact_grid_right">
								<h6>请填写如下表格的信息.</h6>
								<form action="../change" method="post" onsubmit="return checkPassword();">
									<div class="col-md-6 col-sm-6 contact_left_grid">
										<!-- <input type="text" name="name" placeholder="姓名" required=""> -->
										<span>姓名：&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp ${name}</span><br>
										<span>&nbsp</span><br>
										密码：&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
										<input type="password" id="password" name="password" onblur="checkPassword();" placeholder="密码" required="">
										
										<br>
										<span>&nbsp</span><br>
										确认密码：
										<input type="password" id="password1" name="password1" placeholder="密码" required="" onblur="checkPassword();">
										<br>
										<span id="msg" style="color: red; font-size: 14px"></span>
										<br>
										<span>&nbsp</span>
									</div>
									<!-- <div class="col-md-6 col-sm-6 contact_left_grid">
										<input type="text" name="password" placeholder="密码" required="">
										<input type="text" name="subject" placeholder="专业" required="">
									</div> -->
									<div class="clearfix"> </div>
				<!-- 					<textarea name="Message" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Message...';}" required="">Message...</textarea>
									 --><input type="submit" value="提交" style=" font-size: 14px;width: 240px;background-color:#FFA07A">
									 <!-- style=" font-size: 14px;width: 240px;background-color:#FFA07A" -->
									<!-- <input type="reset" value="清除"> -->
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
								<!-- <div class="visit">
									<div class="col-md-2 col-sm-2 col-xs-2 contact-icon">
										<span class="fa fa-fax" aria-hidden="true"></span>
									</div>
									<div class="col-md-10 col-sm-10 col-xs-10 contact-text">
										<h4>QQ</h4>
										<p>6666666666</p>
									</div>
									<div class="clearfix"></div>
								</div> -->
							</div>
							
							
							
						<!-- 	<div class="clearfix"> </div> -->

						</div>

		<!-- 	<div class="clearfix"></div> -->

		</div>
	</div>
	

	<!-- footer -->
	<footer>
		<div class="footer-top-w3-agileits">
			<div class="container">
				
				<div style="color: white;text-align: center;">
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