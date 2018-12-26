<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<!--script type="text/javascript">
		onload=function(){
			setTimeout(go,5000);
		};
		function go(){
			location.href="../Teacher/create.jsp"
		}
	</script-->
	<script>
		function changecolor1(){
			var agreebutton = document.getElementById("agree");
			var agreebuttonvalue = agreebutton.value;			
			if(agreebuttonvalue=="同意"){
				agreebutton.style['background-color']='#5F9EA0';
			}
	
		}
		
		function changecolor2(){
			var disagreebutton = document.getElementById("disagree");
			var disagreebuttonvalue = disagreebutton.value;
			if(disagreebuttonvalue=="不同意"){
				disagreebutton.style['background-color']='#5F9EA0';
			}
		}
	</script>
	<!--//tags -->
	<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" property="" />
	<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
	<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
	<link rel="stylesheet" type="text/css" href="css/contact.css">
	<link href="css/font-awesome.css" rel="stylesheet">
	<!-- //for bootstrap working -->
	
</head>

<body>
	<!-- header_top -->
	<div class="header" id="home">
		<%@include file="head.jsp" %>
		<!-- banner -->
          <div class="banner_inner">
                   <div class="services-breadcrumb">
						<div class="inner_breadcrumb">

							<ul class="short">
								<li><a href="index.jsp">首页</a><i>|</i></li>
								<li>修改信息</li>
							</ul>
						</div>
					</div>

		  </div>
		<!--//banner -->

	</div>
	<!--// header_top -->
<!-- top Products -->
	<div class="ab_content"">
		<!--  style=" background-image:url('images/divbg.jpeg') -->
		<div class="container">
			<h3 class="tittle-w3ls">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;未审核请假条</h3>

			<!-- <div class="inner_sec_info_w3ls_agile" > -->
			<div class="row">

				<c:forEach var="leavepaper" items="${statu }">
					<div class="col-md-6 " style="background-color:;margin-bottom:40px;">
						
	
								<ul style="list-style: none;background-color:#F5F5F5 ">
										<li><span style="margin-left:75px;margin-top:10px"><span style="font-weight:bold;font-size:15px;margin-top:15px;margin-bottom:10px;display:inline-block">上传时间：</span>${leavepaper.apply_time }</span><br></li> 
										<li><span style="margin-left:75px"><span style="font-weight:bold;font-size:15px;margin-bottom:10px;display:inline-block">学生姓名：</span>${leavepaper.student.name }</span><br></li>
										
										<li><span style="margin-left:75px"><span style="font-weight:bold;font-size:15px;margin-bottom:10px;display:inline-block">课程名称：</span>${leavepaper.classcourse.course.cname }</span><br></li>
										
										<li><span style="margin-left:75px"><span style="font-weight:bold;font-size:15px;margin-bottom:10px;display:inline-block">班级名称：</span>${leavepaper.classcourse.class_name }</span><br></li>
										
										<li><span style="margin-left:75px"><span style="font-weight:bold;font-size:15px;margin-bottom:20px;display:inline-block">审核状态：</span>未审核</span><br></li>
								
										<li style="text-align:center"><img alt="" src="../${leavepaper.img_src }" width="400px" height="300px"></li>
										<li>
										<form action="" method="post">
											<input type="radio" name="check" value="同意" style="margin-left: 150px;margin-top: 20px; display: inline-block;" />同意
											<input type="radio" name="check" value="不同意"style="margin-left: 100px;margin-top: 20px; display: inline-block;"/>不同意
											<span style="display: inline-block;"><input type="submit"  value="确定" style="background-color:#FFF0F5;border:none;margin-left: 30px;"/></span>
										</form>
										</li>
								</ul>					
					</div>
				</c:forEach>	
					<!-- <div class="col-md-7 contact_grid_right" style="width: 100px;background-color: ">
							lalla
					</div> -->
		
				
				<!-- <div class="col-md-5 contact-left" style="background-color: #E0FFFF">



				</div> -->

				<!-- <div class="clearfix"></div> -->

			</div>


			<div class="clearfix"></div>
			<!-- <div>
				&nbsp<br>&nbsp<br>&nbsp<br>&nbsp<br>&nbsp<br>
			</div> -->
		</div>
	</div>
	

	<!-- footer -->
	<footer>
		<div class="footer-top-w3-agileits">
			<div class="container">
				
				<div class="copy_right">
					<p>© 2018 All rights reserved | Design by SoftwareCollege Of HBNU</p>
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