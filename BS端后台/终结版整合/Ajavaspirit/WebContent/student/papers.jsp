<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>

<head>
<title>LeavePapers</title>
<!--/tags -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Surf Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
	Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />

<!--//tags -->
<link rel="stylesheet" href="css/flexslider.css" type="text/css"
	media="screen" property="" />
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" type="text/css" href="css/contact.css">
<link href="css/font-awesome.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script type="application/x-javascript">
	
	
	
	
	
		addEventListener("load", function () {
			setTimeout(hideURLbar, 0);
		}, false);

		function hideURLbar() {
			window.scrollTo(0, 1);
		}

		/* $("#picture").change(function () {
		    var s = $('#picture').val();
		    var start = s.indexOf(".") + 1;
		    var name = s.substring(start, s.length).toLowerCase();
		    if (name != "jpg" && name != "png" && name != "gif") {
		        alert("图片格式必须为jpg、png、gif中的一种");
		        $("[value='上传']").attr("disabled", true);
		        return;
		    }
		    if (this.files[0].size / 1024 / 1024 > 5) {
		        alert("图片不能超过5M");
		        $("[value='上传']").attr("disabled", true);
		        return;
		    }
		    var objUrl = getObjectURL(this.files[0]);
		    if (objUrl) {
		        $("#img0").attr("src", objUrl);
		    }
		    $("[value='上传']").attr("disabled", false);
		});
		 
		//获得file按钮选取文件的路径
		function getObjectURL(file) {
		    var url = null;
		    if (window.createObjectURL != undefined) { // basic
		        url = window.createObjectURL(file);
		    } else if (window.URL != undefined) { // mozilla(firefox)
		        url = window.URL.createObjectURL(file);
		    } else if (window.webkitURL != undefined) { // webkit or chrome
		        url = window.webkitURL.createObjectURL(file);
		    }
		    return url;
		}
 */
		
		
		function test(){
		 	
			var filePath = $("input[name='file']").val(); //获取到input的value，里面是文件的路径
			
			if(filePath==""||filePath==null){
				alert("请上传图片！");
				return false;
			}
			fileFormat=filePath.substring(filePath.lastIndexOf("."));
			
			src = window.URL.createObjectURL($('[name="file"]')[0].files[0] ); //转成可以在本地预览的格式
			
		
		
		// 检查是否是图片
		
		/* hhx */
		/* if(!fileFormat.match(/.png|.jpg|.jpeg/)) {
			//error_prompt_alert('上传错误,文件格式必须为：png/jpg/jpeg');
			alert('上传错误,文件格式必须为：png/jpg/jpeg');
			$('#chooseImage').val()="";
			return false;
		} */
			if($('[name="file"]')[0].files[0].size>200000){
				alert("文件太大，不能超过200KB！");
				return false;
			}else{
				alert("else");
				$('#cropedBigImg').css('display','block');
				$('#cropedBigImg').attr('src', src); 
				//$('.showImg').html('<img class="addImagees" src="'+ window.URL.createObjectURL( $('[name="file"]')[0].files[0])+'"  width="100%" /> ');
				return true;
			}  
 }
		
 	
 
 /* $('#chooseImage').on("change",function() {//当chooseImage的值改变时，执行此函数
 			alert("hello");
			var filePath = $(this).val(); //获取到input的value，里面是文件的路径
 			alert(filePath);
 			fileFormat = filePath.substring(filePath.lastIndexOf(".")).toLowerCase();
 			src = window.URL.createObjectURL(this.files[0]); //转成可以在本地预览的格式
  
 			// 检查是否是图片
 			if(!fileFormat.match(/.png|.jpg|.jpeg/)) {
   				error_prompt_alert('上传错误,文件格式必须为：png/jpg/jpeg');
 				return;
 			}else{
				 $('#cropedBigImg').css('display','block');
 				$('#cropedBigImg').attr('src', src); 
 			} 
		}); */

	





</script>

<!-- //for bootstrap working -->

</head>

<body>
	<!-- header_top -->
	<div class="header" id="home">
		<%@ include file="header.jsp"%>







		<!-- banner -->
		<div class="banner_inner"
			style="background-image: url('images/banner3.jpg')">
			<div class="services-breadcrumb">
				<div class="inner_breadcrumb">

					<ul class="short">
						<li><a href="index.jsp" style="color: #00BFFF">首页</a><i>|</i></li>
						<li>请假</li>
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
			<h3 class="tittle-w3ls">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请假条</h3>

			<!-- <div class="inner_sec_info_w3ls_agile" > -->
			<div class="row">

				<c:forEach var="picture" items="${pictures}">
					<div class="col-md-6 " style="background-color:;margin-bottom:40px;">
						
	
								<ul style="list-style: none;background-color:#F5F5F5 " margin-top:10px;>
									<li><span style="margin-left:75px;margin-top:10px"><span style="font-weight:bold;font-size:15px;margin-top:10px;margin-bottom:10px;display:inline-block">请假时间：</span>${picture.apply_time}</span><br></li> 
									<c:if test="${picture.status==0 }">
										
										<li><span style="margin-left:75px"><span style="font-weight:bold;font-size:15px;margin-top:0px;margin-bottom:10px;display:inline-block">审核状态：</span>未审核</span><br></li>
									</c:if>
									<c:if test="${picture.status==1 }">
										
										<li><span style="margin-left:75px"><span style="font-weight:bold;font-size:15px;margin-top:0px;margin-bottom:10px;display:inline-block">审核状态：</span>同意</span><br></li>
									</c:if>
									<c:if test="${picture.status==2 }">
										
										<li><span style="margin-left:75px"><span style="font-weight:bold;font-size:15px;margin-top:0px;margin-bottom:10px;display:inline-block">审核状态：</span>不同意</span><br></li>
									</c:if>
									<li style="text-align:center"><img alt="" src="../${picture.img_src}" width="400px" height="300px" style="margin-bottom:10px"></li>
								</ul>
	
	
						
					</div>
					<!-- <div class="col-md-7 contact_grid_right" style="width: 100px;background-color: ">
							lalla
					</div> -->
				</c:forEach>
				
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

				<div style="color: white;text-align: center;">
					<p>
						© 2018 TTOOL . All rights reserved | Design by javaspirit
					</p>
				</div>
			</div>
		</div>

	</footer>
	<!-- //footer -->
	<a href="#home" class="scroll" id="toTop" style="display: block;">
		<span id="toTopHover" style="opacity: 1;"> </span>
	</a>
	<!-- js -->
	<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>

	<!--search-bar-->
	<script src="js/search.js"></script>
	<!--//search-bar-->

	<!-- start-smoth-scrolling -->
	<script type="text/javascript" src="js/move-top.js"></script>
	<script type="text/javascript" src="js/jquery.easing.min.js"></script>
	<script type="text/javascript">
		jQuery(document).ready(function($) {
			$(".scroll").click(function(event) {
				event.preventDefault();

				$('html,body').animate({
					scrollTop : $(this.hash).offset().top
				}, 1000);
			});
		});
	</script>
	<!-- //end-smooth-scrolling -->
	<script>
		$('ul.dropdown-menu li').hover(
				function() {
					$(this).find('.dropdown-menu').stop(true, true).delay(200)
							.fadeIn(500);
				},
				function() {
					$(this).find('.dropdown-menu').stop(true, true).delay(200)
							.fadeOut(500);
				});
	</script>

	<!-- flexSlider -->
	<script defer src="js/jquery.flexslider.js"></script>
	<script type="text/javascript">
		$(window).load(function() {
			$('.flexslider').flexslider({
				animation : "slide",
				start : function(slider) {
					$('body').removeClass('loading');
				}
			});
		});
	</script>
	<!-- //flexSlider -->
	<!-- smooth-scrolling-of-move-up -->
	<script type="text/javascript">
		$(document).ready(function() {
			/*
			var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
			};
			 */

			$().UItoTop({
				easingType : 'easeOutQuart'
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