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
         
		<!--//banner -->

	</div>
	<!--// header_top -->
<!-- top Products -->
	
		<div class="ab_content" style="background:url(images/22.jpg) no-repeat;    background-size: 120%;width:100%;heigth:100%;height:600px;">
		<div class="container" style="width:400px">
						<div class="row">
							<div class="col-md-5 contact_grid_right" style="background-color:rgba(255,255,255,0.6);width: 400px;" >
								<h1 style="border-bottom:solid 3px #000;padding-bottom:15px;margin-bottom:15px;margin-top:20px;margin-left:10px;">添加成员</h1>
								<form action="../Teacher/upload" method="post" enctype="multipart/form-data">
									<input type = "text" name="classname" value="${classname }" style="display:none"/>
									<div class="col-md-12 col-sm-6 contact_left_grid">
										<span style="margin-bottom: 10px;display: inline-block;">班级名称：${classname }</span><br>
										上传excel文件用来添加学生：
										<div class="uploader white">
												<input type="text" class="filename" readonly style="width: 250px;"/>
												<input type="button" name="file" class="button" value="预览文件"/>
												<input type="file" size="30" name="uploadFile" id="uploadFile" accept=".xls,.xlsx" onchange="fileChange(this);"/>
										</div>
										
										<div id="msg"></div>
									</div>
									
									<div style="text-align:center;margin-bottom:10px;">
										<input type="submit" id="submit_upload" value="上传" disabled/>
									</div>
									
								</form>
							</div>
							
							

						</div>

			<div class="clearfix"></div>

		</div>
	</div>
	

	<!-- footer -->
	<footer>
		<div class="footer-top-w3-agileits" >
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

<style>.uploader{
position:relative;
display:inline-block;
overflow:hidden;
cursor:default;
padding:0;
margin:10px 0px;
-moz-box-shadow:0px 0px 5px #ddd;
-webkit-box-shadow:0px 0px 5px #ddd;
box-shadow:0px 0px 5px #ddd;

-moz-border-radius:5px;
-webkit-border-radius:5px;
border-radius:5px;
}

.filename{
float:left;
display:inline-block;
outline:0 none;
height:32px;
width:180px;
margin:0;
padding:8px 10px;
overflow:hidden;
cursor:default;
border:1px solid;
border-right:0;
font:9pt/100% Arial, Helvetica, sans-serif; color:#777;
text-shadow:1px 1px 0px #fff;
text-overflow:ellipsis;
white-space:nowrap;

-moz-border-radius:5px 0px 0px 5px;
-webkit-border-radius:5px 0px 0px 5px;
border-radius:5px 0px 0px 5px;

background:#f5f5f5;
background:-moz-linear-gradient(top, #fafafa 0%, #eee 100%);
background:-webkit-gradient(linear, left top, left bottom, color-stop(0%,#fafafa), color-stop(100%,#f5f5f5));
filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#fafafa', endColorstr='#f5f5f5',GradientType=0);
border-color:#ccc;

-moz-box-shadow:0px 0px 1px #fff inset;
-webkit-box-shadow:0px 0px 1px #fff inset;
box-shadow:0px 0px 1px #fff inset;

-moz-box-sizing:border-box;
-webkit-box-sizing:border-box;
box-sizing:border-box;
}

.button{
float:left;
height:32px;
display:inline-block;
outline:0 none;
padding:8px 12px;
margin:0;
cursor:pointer;
border:1px solid;
font:bold 9pt/100% Arial, Helvetica, sans-serif;

-moz-border-radius:0px 5px 5px 0px;
-webkit-border-radius:0px 5px 5px 0px;
border-radius:0px 5px 5px 0px;

-moz-box-shadow:0px 0px 1px #fff inset;
-webkit-box-shadow:0px 0px 1px #fff inset;
box-shadow:0px 0px 1px #fff inset;
}


.uploader input[type=file]{
position:absolute;
top:0; right:0; bottom:0;
border:0;
padding:0; margin:0;
height:30px;
cursor:pointer;
filter:alpha(opacity=0);
-moz-opacity:0;
-khtml-opacity: 0;
opacity:0;
}

input[type=button]::-moz-focus-inner{padding:0; border:0 none; -moz-box-sizing:content-box;}
input[type=button]::-webkit-focus-inner{padding:0; border:0 none; -webkit-box-sizing:content-box;}
input[type=text]::-moz-focus-inner{padding:0; border:0 none; -moz-box-sizing:content-box;}
input[type=text]::-webkit-focus-inner{padding:0; border:0 none; -webkit-box-sizing:content-box;}

/* White Color Scheme ------------------------ */

.white .button{
color:#555;
text-shadow:1px 1px 0px #fff;
background:#ddd;
background:-moz-linear-gradient(top, #eeeeee 0%, #dddddd 100%);
background:-webkit-gradient(linear, left top, left bottom, color-stop(0%,#eeeeee), color-stop(100%,#dddddd));
filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#eeeeee', endColorstr='#dddddd',GradientType=0);
border-color:#ccc;
}

.white:hover .button{
background:#eee;
background:-moz-linear-gradient(top, #dddddd 0%, #eeeeee 100%);
background:-webkit-gradient(linear, left top, left bottom, color-stop(0%,#dddddd), color-stop(100%,#eeeeee));
filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#dddddd', endColorstr='#eeeeee',GradientType=0);
}
</style>

<script>$(function(){
	$("input[type=file]").change(function(){$(this).parents(".uploader").find(".filename").val($(this).val());});
	$("input[type=file]").each(function(){
	if($(this).val()==""){$(this).parents(".uploader").find(".filename").val("No file selected...");}
	});
});
</script>