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
<title>LeavePaper</title>
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
		if(!fileFormat.match(/.png|.jpg|.jpeg|.gif|.bmp/)) {
			//error_prompt_alert('上传错误,文件格式必须为：png/jpg/jpeg/gif/bmp');
			alert('上传错误,文件格式必须为：png/jpg/jpeg/gif/bmp');
			//$('#chooseImage').val()="";
			return false;
		} 
			
			
			if($('[name="file"]')[0].files[0].size>5000000){
				alert("文件太大，不能超过200KB！");
				return false;
			}else{
				
				$('#cropedBigImg').css('display','block');
				$('#cropedBigImg').attr('src', src); 
				//$('.showImg').html('<img class="addImagees" src="'+ window.URL.createObjectURL( $('[name="file"]')[0].files[0])+'"  width="100%" /> ');
				return true;
			}  
 }
		
 	
 
 	function checkCourse(){
 		var course = $("#course").val();
 		
 		var result=false;
		if(course==""||course==null){
			$("#checkCourse").text("课程名为空！");
	
		}else{
			
			$.ajax({
				url : "../judgeCourse?course="+course,
				async : false,
				type : "POST",
				success : function(res) {
					if (res == "ok") {

							$("#checkCourse").text("");
						
						result=true;
					} else {
						
						$("#checkCourse").text("没有此课程！");
						
						result=false;
					}
				}
			});
		}
		
		return result;
	
 	}
	function checkTeacher(){
		var teacher = $("#tea").val();
 		
 		var result=false;
 		if(teacher==""||teacher==null){
			$("#checkTeacher").text("任课老师不能为空");
	
		}else{
			
			$.ajax({
				url : "../judgeTeacher?teacher="+teacher,
				async : false,
				type : "POST",
				success : function(res) {
					if (res == "ok") {

							$("#checkTeacher").text("");
						
						result=true;
					} else {
						
						$("#checkTeacher").text("没有此老师!");
						
						result=false;
					}
				}
			});
		}
		
		return result;
	}
	
	function checkSubmit(){
 		if(test()&&checkCourse()&&checkTeacher()){
 			var teacher = $("#tea").val();
 			var course = $("#course").val();
 			var s=false;
 			
 			$.ajax({
				url : "../judgeSubmit?teacher="+teacher+"&course="+course,
				async : false,
				type : "POST",
				success : function(res) {
					if (res == "ok") {

							
						
						s=true;
					} else {
						
						alert("课程名与教师不匹配");
						
						s=false;
					}
				}
			});
 			return s;
 		}else{
 			return false;
 		}
 	}





</script>

<!-- //for bootstrap working -->

</head>

<body>
	<!-- header_top -->
	<div class="header" id="home">
		<%@ include file="header.jsp"%>







		<!-- banner -->
		<div class="banner_inner"  style="background-image: url('images/banner3.jpg');">
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
			<div class="row">
			<!-- <div class="inner_sec_info_w3ls_agile"> -->
				<!-- <div class="col-md-7 contact_grid_right" style="width: 50px">

				</div> -->
				
				<!-- <div class="col-md-7 contact_grid_right"style="background-color:#E0FFFF;width:220px;height:400px">
					<span>&nbsp</span><br>
					
					<h3><a href="../qingjia" style="color:#4169E1" >&nbsp上传假条</a></h3><br>
					
					<h3><a href="../changedown" style="color:black" >&nbsp查看历史假条</a></h3><br>
					
				</div> -->

				<div class="col-md-6 contact_grid_right" style="background-color: ;padding-left:80px"><!-- style="width: 400px" -->
					<c:if test="${exists=='up'}">
						<!-- hhx -->
						<!-- <span>&nbsp</span><br> -->
						<h6 style="color: red">请选择上传假条的照片</h6>
						<form action="../leave" method="post"
							enctype="multipart/form-data" onsubmit="return checkSubmit();">
							<div style="margin-bottom: 1em;padding-left:1em">
								<span style="font-size: 20px;">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：&nbsp;</span><span> ${name}</span><br>
							
								
							</div>
							<div style="margin-bottom: 1em;padding-left:1em">
								<span style="font-size: 20px">课&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;程：&nbsp;</span>
								<input type="text" id="course" name="course" 
								style="width:150px;height:30px" onblur="checkCourse();">
								<span id="checkCourse"></span>
								
							</div>
							<div style="margin-bottom: 1em;padding-left:1em">
								<span style="font-size: 20px">任课老师：</span>
								<input type="text" id="tea" name="tea"
								style="width:150px;height:30px" onblur="checkTeacher();">
								<span id="checkTeacher"></span>
							</div>	
							<div style="margin-bottom: 1em;padding-left:1em">
								
							
								<input type="file" name="file" id="chooseImage"
									onchange="test();" accept="image/*" />
								
							</div>		
								<!-- <span>提交假条照片</span> -->
								<!-- <span>&nbsp&nbsp&nbsp&nbsp&nbsp</span><br> -->
							

							<div class="clearfix"></div>
							<!-- <textarea name="Message" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Message...';}" required="">请假理由...</textarea> -->



							<div id="imgPreview">
								<img src="#" id="cropedBigImg"
									style="width: 400px; display: none;margin-bottom:1em" />
							</div>
							
							 <input type="submit" value="确认上传"
								style="width: 260px; background-color: #FFA07A;margin-left:1em">
							<!-- <input type="reset" value="清除"> -->

						</form>
						<!-- hhx -->
					</c:if>
					
				</div>
				<!-- <div class="col-md-7 contact_grid_right" style="width: 200px">

				</div> -->
				<div class="col-md-6 contact-left" style="background-color: ;padding-left:100px">

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
							<p>
								<a href="mailto:info@example.com">henunavy@gmail.com</a>
							</p>
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
				<!-- <div class="col-md-5 contact-left" style="background-color: #E0FFFF">



				</div> -->

				<div class="clearfix"></div>

			</div>


			<div class="clearfix"></div>
			
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