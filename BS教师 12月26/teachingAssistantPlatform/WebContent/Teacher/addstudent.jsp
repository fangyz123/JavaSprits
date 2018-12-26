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
	<script type="text/javascript">
		function fileChange(target){
			//检测上传文件类型
			var filename = document.all.uploadFile.value;
			var ext,idx;
			if(filename == ''){
				document.all.submit_upload.disabled=true;
				alert("请选择要上传的文件！");
				return;
			}else{
				idx = filename.lastIndexOf(".");
				if(idx!=-1){
					ext = filename.substr(idx+1).toUpperCase();
					ext = ext.toLowerCase();
					if(ext != 'xls' && ext != 'xlsx'){
						document.all.submit_upload.disabled = true;
						alert("只能上传 .xls .xlsx类型的文件");
						return;
					}
				}else{
					document.all.submit_upload.disabled = true;
					alert("只能上传  .xls .xlsx类型的文件");
					return;
				}
			}
			
			//检测上传文件的大小
			var isIE = /msie/i.test(navigator.userAgent) && !window.opera; 
			  var fileSize = 0;           
			    if (isIE && !target.files){       
			        var filePath = target.value;       
			        var fileSystem = new ActiveXObject("Scripting.FileSystemObject");          
			        var file = fileSystem.GetFile (filePath);       
			        fileSize = file.Size;      
			    } else {      
			        fileSize = target.files[0].size;       
			    }     

			    var size = fileSize / 1024*1024;   

			    if(size>(1024*200)){    
			    document.all.submit_upload.disabled=true;
			        alert("文件大小不能超过200KB");   
			    }else{
			    document.all.submit_upload.disabled=false;
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
								<li>添加学生</li>
							</ul>
						</div>
					</div>

		  </div>
		<!--//banner -->

	</div>
	<!--// header_top -->
<!-- top Products -->
	<div style="margin-top: 20px">
						
								<h3 style="color: red;text-align: center;font-weight: bolder;">成员管理</h3>
								
								
								<div class="visit" style="margin: 0 auto;margin-top:20px;">
									
									<div  style="text-align: center;">
										<div style="margin-bottom:20px">
										<h5><span style="font-weight:bold;font-size:15px;">班级名称：</span>${classname }	</h5>									
										</div>
										<form action="../Teacher/upload" method="post" enctype="multipart/form-data">
										<input type = "text" name="classname" value="${classname }" style="display:none"/>
										<span>上传excel文件用来添加学生:</span><input type="file" name="uploadFile" id="uploadFile" accept=".xls,.xlsx" onchange="fileChange(this);" style=""><br/>
										<input type="submit" id="submit_upload" value="上传" disabled/>										
										</form>
									</div>
									<div class="clearfix"></div>
								</div>
							
	</div>
	

	<!-- footer -->
	<footer>
		<div class="footer-top-w3-agileits"  style="margin-top:100px">
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