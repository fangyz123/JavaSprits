<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
	<title>TTool</title>
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
	
</head>

<body >

<script type="text/javascript">
	function searchWord(){
		console.log("a");
		var course=$("#course").val();
		console.log(course);
		$.ajax({
			url:"../create?course="+course,
			type:"post",
			async : true,
			success:function(res){
				var msg = eval("(" + res + ")");
				var s="";
				for(var i=0;i<msg.length;i++){
					s=s+msg[i]+"<br>";
				}
			<!--alert(s);-->
				document.getElementById("msg").innerHTML=s;
			}
		})
	}
	</script>

	<!--script type="text/javascript">
		function add(mytype){
			var mytype,Temo=document.getElementById("weeknode");
			var Inputweek = document.createElement("input");
			Inputweek.type=mytype;
			Inputweek.name="weekday";
			Inputweek.id="week"
			var textnode1=document.createTextNode("星期：");
			Temo.appendChild(textnode1);
			Temo.appendChild(Inputweek);
			var Inputnode = document.createElement("input");
			Inputnode.type=mytype;
			Inputnode.name="node";
			Inputnode.id="node";
			var textnode2=document.createTextNode("节");
			Temo.appendChild(Inputnode);
			Temo.appendChild(textnode2);
			var newline= document.createElement("br"); 
			Temo.appendChild(newline);
		}
	</script-->
	<script type="text/javascript">
		var a = 0;
		function add(){
			a+=1
			var cishu = document.getElementById("cishu");
			cishu.value=a;
			var classci = document.getElementById("classci");
			classci.innerHTML=a;
			var Temo = document.getElementById("weeknode");
			var select = document.createElement("select");
			select.setAttribute('id','weekselect');
			select.setAttribute('name','weekdate'+a);
			select.options[0] = new Option("1", "1");
	        select.options[1] = new Option("2", "2");
	        select.options[2] = new Option("3", "3");
	        select.options[3] = new Option("4", "4");
	        select.options[4] = new Option("5", "5");
	        select.options[5] = new Option("6", "6");
	        select.options[6] = new Option("7", "7");
	        var textnode1=document.createTextNode("星期：");
			Temo.appendChild(textnode1);
			Temo.appendChild(select);
			
			var select2 = document.createElement("select");
			select2.setAttribute('id','nodeselect');
			select2.setAttribute('name','nodeselect'+a);
			select2.options[0] = new Option("1-2", "1-2");
			select2.options[1] = new Option("1-4", "1-4");
	        select2.options[2] = new Option("3-4", "3-4");
	        select2.options[3] = new Option("3-5", "3-5");
	        select2.options[4] = new Option("6-7", "6-7");
	        select2.options[5] = new Option("6-8", "6-8");
	        select2.options[6] = new Option("6-9", "6-9");
	        select2.options[7] = new Option("6-10","6-10");
	        select2.options[8] = new Option("9-10", "9-10");
	        select2.options[9] = new Option("11-12", "11-12");
	        select2.options[10] = new Option("11-13", "11-13");
	    
	        var textnode2=document.createTextNode("第");
	        var textnode3=document.createTextNode("节");
	        
	        Temo.appendChild(textnode2);
	        Temo.appendChild(select2);
	        Temo.appendChild(textnode3);
	        
	        var newline= document.createElement("br"); 
			Temo.appendChild(newline);
	        
		}
	</script>
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript">     
	//班级名称
		function checkclassName(re){
			var rep=false;
			  var classname= document.getElementById("className").value;
			  if(classname==""||classname==null){
				  document.getElementById("classnametip").innerText='请填写班级名称，例如：16级数据库1班';
			  }else{
				$.ajax({
					url:"../Teacher/searchClassName?className="+classname,
					async:re,
					type:"POST",
					success:function(res){
						if("ok"==res){
							$("#classnametip").text("班级名称可用");
							rep=true;
						}else{
							$("#classnametip").text("班级名称已存在，请改名称");
						}
					}
				});  
			  }
			  return rep;
		}
		function clearInfo_classname() {
            document.getElementById("classnametip").innerText=" ";
         }  
	//开课周数
		function checkweek(){
		var weekcount = document.getElementById("weekcount").value;
		if(weekcount==""||weekcount==null){
			document.getElementById("weektip").innerText='请输入开课周数例如1-18';
			console.log("周数为空");
			return false;
		}
		return true;
	}
		function clearInfo_week() {
            document.getElementById("weektip").innerText=" ";
         }  
	//课程名称
		function checkcname(re){
		var rep=false;
		var cname = document.getElementById("course").value;
		if(cname==""||cname==null){
			document.getElementById("cnametip").innerText='请输入课程名称';
		}else{
			$.ajax({
				url:"../Teacher/Courses?course="+cname,
				async:re,
				type:"POST",
				success:function(res){
					if("ok"==res){
						
						rep=true;
					}else{
						$("#cnametip").text("课程不存在");
					}
				}
			});  
		  }
		return rep;
	}
		function clearInfo_cname() {
            document.getElementById("cnametip").innerText=" ";
         }  
	//上课区间
	function checkcishu(){
		var cishu = document.getElementById("cishu").value;
		if(cishu==""||cishu==null){
			document.getElementById("cishutip").innerText='请点击添加按钮，添加上课区间';
			return false;
		}
		return true;
	}
	function clearInfo_cishu() {
        document.getElementById("cishutip").innerText=" ";
     }   
    //校验所有表单元素的内容
    function judgeCorrect(re) {
    	console.log(checkclassName(re));
    	console.log(checkweek());
    	console.log(checkcname(re));
    	console.log(checkcishu());
                if(checkclassName(re)&&checkweek()&&checkcname(re)&&checkcishu()) {
                	console.log("可以提交");
                	return true;
                }
                console.log("不能提交");
               return false;
            }
	</script>
	
	<!-- header_top -->
	<div class="header" id="home">
		<%@include file="head.jsp" %>
		<!-- banner -->
         
		<!--//banner -->
	
	</div>
	<!--// header_top -->
<!-- top Products -->
	<div class="ab_content" style="background:url(images/22.jpg) no-repeat;    background-size: 120%;width:100%;heigth:100%;">
		<div class="container" style="width:400px">
						<div class="row">
							<div class="col-md-5 contact_grid_right" style="background-color:rgba(255,255,255,0.6);width: 400px;" >
								<h1 style="border-bottom:solid 3px #000;padding-bottom:15px;margin-bottom:15px;margin-top:20px;margin-left:10px;">创建班级</h1>
								<form action="../Teacher/createClass" method="post" onSubmit="return judgeCorrect(false);">
								
									<div class="col-md-12 col-sm-6 contact_left_grid">
										班级名称：<input type="text" id="className" name="className" placeholder="班级名称" onblur="checkclassName(true);" onfocus="clearInfo_classname()" style="margin-top:10px;margin-bottom:10px;"><span id="classnametip" style="color:#f00;"> </span><br>
										开课周数：<input type="text" id="weekcount" name="weekcount" placeholder="开课周数(例如：1-18)" onblur="checkweek()" onfocus="clearInfo_week()" style="margin-top:10px;margin-bottom:10px;"><span id="weektip" style=color:#f00></span><br>
										课程名称：<input type="text" id="course" name="cname" placeholder="课程名称"  onblur="checkcname(true);" onfocus="clearInfo_cname()" onKeyUp="searchWord()" style="margin-top:10px;margin-bottom:10px;"><span id="cnametip" style=color:#f00></span><br>
										<div id="msg"></div>
									</div>
									
									
									<div style="margin-top:20px;margin-bottom:5px;margin-left:20px;">
										请添加周几上课及当天对应的上课节数<input type="button" value="增加" onclick="add();" />		
										<br>上课次数:<input type="text" style="display:none" name="cishu" id = "cishu" onblur="checkcishu()" onfocus="clearInfo_cishu()" style="width:50px">
										<span id="classci"></span>	<span id="cishutip" style=color:#f00></span>				
									</div>
									<div id="weeknode" >
										
									</div>
									<div style="text-align:center;margin-bottom:10px;">
										<input type="submit" id="sub" value="提交" >
									</div>
									
								</form>
							</div>
							
							

						</div>

			<div class="clearfix"></div>

		</div>
	</div>
	

	<!-- footer -->
	<footer>
		<div class="footer-top-w3-agileits">
			<div class="container">
				
				<div style="margin-top:0px;color:white;text-align: center">
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