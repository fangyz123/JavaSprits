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
	<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
	<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
	<link href="css/font-awesome.css" rel="stylesheet">
	<!-- //for bootstrap working -->
	
</head>

<body>
	<!-- header_top -->
	<div class="header" id="home">
		<%@include file="head.jsp" %>
		<!-- banner -->
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1" class=""></li>
				<li data-target="#myCarousel" data-slide-to="2" class=""></li>
				<li data-target="#myCarousel" data-slide-to="3" class=""></li>
			</ol>
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<div class="container">
						<div class="carousel-caption">
							<h3>Ttool is a <span>perfect</span></h3>
							<h4>TeachingAssistantPlatform</h4>
							<p>Ttool perfect 最完美的教学工具</p>

						</div>
					</div>
				</div>
				<div class="item item2">
					<div class="container">
						<div class="carousel-caption">
							<h3>Ttool is a <span>perfect</span></h3>
							<h4>TeachingAssistantPlatform</h4>
							<p>Ttool perfect 最完美的教学工具</p>
						</div>
					</div>
				</div>
				<div class="item item3">
					<div class="container">
						<div class="carousel-caption">
							<h3>Ttool is a <span>perfect</span></h3>
							<h4>TeachingAssistantPlatform</h4>
							<p>Ttool perfect 最完美的教学工具</p>

						</div>
					</div>
				</div>
				<div class="item item4">
					<div class="container">
						<div class="carousel-caption">
							<h3>Ttool is a <span>perfect</span></h3>
							<h4>TeachingAssistantPlatform</h4>
							<p>Ttool perfect 最完美的教学工具</p>
						</div>
					</div>
				</div>
			</div>
			<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
			<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
			<span class="sr-only">Previous</span>
		</a>
			<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
			<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
			<!-- The Modal -->
		</div>
		<!--//banner -->
		<!--//banner -->

	</div>
	<!--// header_top -->
	<!--about-->
	
	<!--//about-->
	<!--/works-->
	
	<!--/works-->
	<!-- /portfolio-->
	

	<!--/ pricing-->
	
	<!-- Popup-Box -->
<!-- Modal2 -->
		<div class="modal fade" id="myModal4" tabindex="-1" role="dialog">
			<div class="modal-dialog">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>

			<div class="pop_up">
				<div class="payment-online-form-left">
					<form action="#" method="post">
						<h4>Personal Details</h4>
						<ul>
							<li><input type="text" name="First Name" placeholder="First Name" required=""></li>
							<li><input type="text" name="Last Name" placeholder="Last Name" required=""></li>
						</ul>
						<ul>
							<li><input type="email" class="email" name="Email" placeholder="Email" required=""></li>
							<li><input type="text" name="Number" placeholder="Mobile Number" required=""></li>
						</ul>
						<textarea name="Message" placeholder="Address..." required=""></textarea>
						<div class="clearfix"></div>

						<ul class="payment-sendbtns">
							<li><input type="reset" value="Reset"></li>
							<li><input type="submit" name="Send" value="Send"></li>
						</ul>
						<div class="clearfix"></div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
</div>
	<!-- //Popup-Box -->

	<!--// pricing-->

	<!-- Testimonials -->
	
	<!-- //Testimonials -->
	<!-- footer -->
	<footer>
		<div class="footer-top-w3-agileits">
			<div class="container">
				
				<div class="copy_right">
					<p>©  2018 All rights reserved | Design by SoftwareCollege Of HBNU</p>
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
	<!-- Pricing-Popup-Box-JavaScript -->
	<script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
	<!-- //Pricing-Popup-Box-JavaScript -->
	<script>
		$('ul.dropdown-menu li').hover(function () {
			$(this).find('.dropdown-menu').stop(true, true).delay(200).fadeIn(500);
		}, function () {
			$(this).find('.dropdown-menu').stop(true, true).delay(200).fadeOut(500);
		});
	</script>
 <!-- js for portfolio lightbox -->
	<script src="js/jquery.chocolat.js "></script>
	<link rel="stylesheet " href="css/chocolat.css " type="text/css " media="screen ">
	<!--light-box-files -->
	<script type="text/javascript ">
		$(function () {
			$('.portfolio-grids a').Chocolat();
		});
	</script>
	<!-- /js for portfolio lightbox -->

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

	<script type="text/javascript" src="js/bootstrap.js"></script>
</body>

</html>