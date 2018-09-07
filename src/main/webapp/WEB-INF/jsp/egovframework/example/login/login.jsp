<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" 	uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" 	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" 		uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" 		uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" 	uri="http://www.springframework.org/tags"%>
<!-- 
	* ========================================
	* 작성자   | 유재영 
	* 설명     | 로그인 페이지
	* ========================================
 -->
 
<!DOCTYPE html>
<head>

<!-- Basic Page Needs
================================================== -->
<title>Personal Portfolio - Login</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

<!-- CSS
================================================== -->
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/colors/main.css" id="colors">

</head>

<body>

<!-- Wrapper -->
<div id="wrapper">

<!-- Header Container
================================================== -->
<header id="header-container">

	<!-- Header -->
	<div id="header">
		<div class="container">
			
			<!-- Left Side Content -->
			<div class="left-side">
				
				<!-- Logo -->
				<div id="logo">
					<a href="index.html"><img src="images/logo.png" alt=""></a>
				</div>

				<!-- Mobile Navigation -->
				<div class="mmenu-trigger">
					<button class="hamburger hamburger--collapse" type="button">
						<span class="hamburger-box">
							<span class="hamburger-inner"></span>
						</span>
					</button>
				</div>

				<!-- Main Navigation -->
				<div class="clearfix"></div>
				<!-- Main Navigation / End -->
				
			</div>
			<!-- Left Side Content / End -->


			<!-- Right Side Content / End -->
			<div class="right-side">
				<div class="header-widget">
					<a href="#sign-in-dialog" class="sign-in popup-with-zoom-anim"><i class="sl sl-icon-login"></i> Sign In</a>
					<a href="dashboard-add-listing.html" class="button border with-icon">Add Listing <i class="sl sl-icon-plus"></i></a>
				</div>
			</div>
			<!-- Right Side Content / End -->

			<!-- Sign In Popup -->
			<div id="sign-in-dialog" class="zoom-anim-dialog mfp-hide">

				<div class="small-dialog-header">
					<h3>Sign In</h3>
				</div>

				<!--Tabs -->
				<div class="sign-in-form style-1">

					<ul class="tabs-nav">
						<li class=""><a href="#tab1">Log In</a></li>
						<li><a href="#tab2">Register</a></li>
					</ul>

					<div class="tabs-container alt">

						<!-- Login (로그인) -->
						<div class="tab-content" id="tab1" style="display: none;">
							<form method="post" class="login" id="loginFrm">

								<p class="form-row form-row-wide">
									<label for="username">UserId(email):
										<i class="im im-icon-Male"></i>
										<input type="text" class="input-text" name="userId" id="userId" value="" />
									</label>
								</p>

								<p class="form-row form-row-wide">
									<label for="password">Password:
										<i class="im im-icon-Lock-2"></i>
										<input class="input-text" type="password" name="userPw" id="userPw"/>
									</label>
									<span class="lost_password">
										<a href="#" >Lost Your Password?</a>
									</span>
								</p>

								<div class="form-row">
									<input type="button" class="button border margin-top-5" id="loginBtn" name="loginBtn" value="Login" />
									<div class="checkboxes margin-top-10">
										<input id="remember-me" type="checkbox" name="check">
										<label for="remember-me">Remember Me</label>
									</div>
								</div>
								
							</form>
						</div>

						<!-- Register (회원가입) -->
						<div class="tab-content" id="tab2" style="display: none;">
							<form:form commandName="joinVO">
								
								<p class="form-row form-row-wide">
									<label for="mberId">ID (Email Address):
										<i class="im im-icon-Mail"></i>
										<form:input  path="mberId" type="text" class="input-text" value="" />
										<form:errors path="mberId" />
									</label>
								</p>
	
								<p class="form-row form-row-wide">
									<label for="mberPw">Password:
										<i class="im im-icon-Lock-2"></i>
										<form:input  path="mberPw" class="input-text" type="password" />
										<form:errors path="mberPw" />
									</label>
								</p>
	
								<p class="form-row form-row-wide">
									<label for="mberPwChk">Repeat Password:
										<i class="im im-icon-Lock-2"></i>
										<form:input  path="mberPwChk" class="input-text" type="password" />
										<form:errors path="mberPwChk" />
									</label>
								</p>
								
								<p class="form-row form-row-wide">
									<label for="mberNm">Username:
										<i class="im im-icon-Male"></i>
										<form:input  path="mberNm" type="text" class="input-text" value="" />
										<form:errors path="mberNm" />
									</label>
								</p>
								
								<p class="form-row form-row-wide">
									<label for="mberNick">UserNick:
										<i class="im im-icon-Male"></i>
										<form:input  path="mberNick" type="text" class="input-text" value="" />
										<form:errors path="mberNick" />
									</label>
								</p>
								
								<p class="form-row form-row-wide">
									<label for="mberPhone">User Phone:
										<i class="im"></i>
										<form:input  path="mberPhone" class="input-text" type="text" />
										<form:errors path="mberPhone" />
									</label>
								</p>
	
								<input type="button" class="button border fw margin-top-10" id="registerBtn" value="Register" />
	
							</form:form>
						</div>

					</div>
				</div>
			</div>
			<!-- Sign In Popup / End -->

		</div>
	</div>
	<!-- Header / End -->

</header>
<div class="clearfix"></div>
<!-- Header Container / End -->


<!-- Banner
================================================== -->
<div class="main-search-container" data-background-image="images/main-search-background-01.jpg">
	<div class="main-search-inner">

		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h2>Find Nearby Attractions</h2>
					<h4>Expolore top-rated attractions, activities and more</h4>

					<div class="main-search-input">

						<div class="main-search-input-item">
							<input type="text" placeholder="What are you looking for?" value=""/>
						</div>

						<div class="main-search-input-item location">
							<input type="text" placeholder="Location" value=""/>
							<a href="#"><i class="fa fa-dot-circle-o"></i></a>
						</div>

						<div class="main-search-input-item">
							<select data-placeholder="All Categories" class="chosen-select" >
								<option>All Categories</option>	
								<option>Shops</option>
								<option>Hotels</option>
								<option>Restaurants</option>
								<option>Fitness</option>
								<option>Events</option>
							</select>
						</div>

						<button class="button" onclick="window.location.href='listings-half-screen-map-list.html'">Search</button>

					</div>
				</div>
			</div>
		</div>

	</div>
</div>



<!-- Footer
================================================== -->
<div id="footer" class="sticky-footer">
	<!-- Main -->
	<div class="container">
		<div class="row">
			<div class="col-md-5 col-sm-6">
				<img class="footer-logo" src="images/logo.png" alt="">
				<br><br>
				<p>Morbi convallis bibendum urna ut viverra. Maecenas quis consequat libero, a feugiat eros. Nunc ut lacinia tortor morbi ultricies laoreet ullamcorper phasellus semper.</p>
			</div>

			<div class="col-md-4 col-sm-6 ">
				<h4>Helpful Links</h4>
				<ul class="footer-links">
					<li><a href="#">Login</a></li>
					<li><a href="#">Sign Up</a></li>
					<li><a href="#">My Account</a></li>
					<li><a href="#">Add Listing</a></li>
					<li><a href="#">Pricing</a></li>
					<li><a href="#">Privacy Policy</a></li>
				</ul>

				<ul class="footer-links">
					<li><a href="#">FAQ</a></li>
					<li><a href="#">Blog</a></li>
					<li><a href="#">Our Partners</a></li>
					<li><a href="#">How It Works</a></li>
					<li><a href="#">Contact</a></li>
				</ul>
				<div class="clearfix"></div>
			</div>		

			<div class="col-md-3  col-sm-12">
				<h4>Contact Us</h4>
				<div class="text-widget">
					<span>12345 Little Lonsdale St, Melbourne</span> <br>
					Phone: <span>(123) 123-456 </span><br>
					E-Mail:<span> <a href="#">office@example.com</a> </span><br>
				</div>

				<ul class="social-icons margin-top-20">
					<li><a class="facebook" href="#"><i class="icon-facebook"></i></a></li>
					<li><a class="twitter" href="#"><i class="icon-twitter"></i></a></li>
					<li><a class="gplus" href="#"><i class="icon-gplus"></i></a></li>
					<li><a class="vimeo" href="#"><i class="icon-vimeo"></i></a></li>
				</ul>

			</div>

		</div>
		
		<!-- Copyright -->
		<div class="row">
			<div class="col-md-12">
				<div class="copyrights">© 2017 Listeo. All Rights Reserved.</div>
			</div>
		</div>

	</div>

</div>
<!-- Footer / End -->


<!-- Back To Top Button -->
<div id="backtotop"><a href="#"></a></div>


</div>
<!-- Wrapper / End -->



<!-- Scripts
================================================== -->
<script type="text/javascript" src="js/jquery-2.2.0.min.js"></script>
<script type="text/javascript" src="js/mmenu.min.js"></script>
<script type="text/javascript" src="js/chosen.min.js"></script>
<script type="text/javascript" src="js/slick.min.js"></script>
<script type="text/javascript" src="js/rangeslider.min.js"></script>
<script type="text/javascript" src="js/magnific-popup.min.js"></script>
<script type="text/javascript" src="js/waypoints.min.js"></script>
<script type="text/javascript" src="js/counterup.min.js"></script>
<script type="text/javascript" src="js/jquery-ui.min.js"></script>
<script type="text/javascript" src="js/tooltips.min.js"></script>
<script type="text/javascript" src="js/custom.js"></script>
<script type="text/javascript" src="js/common.js"></script>


<!-- Style Switcher
================================================== -->
<script src="js/switcher.js"></script>

<div id="style-switcher">
	<h2>Color Switcher <a href="#"><i class="sl sl-icon-settings"></i></a></h2>
	
	<div>
		<ul class="colors" id="color1">
			<li><a href="#" class="main" title="Main"></a></li>
			<li><a href="#" class="blue" title="Blue"></a></li>
			<li><a href="#" class="green" title="Green"></a></li>
			<li><a href="#" class="orange" title="Orange"></a></li>
			<li><a href="#" class="navy" title="Navy"></a></li>
			<li><a href="#" class="yellow" title="Yellow"></a></li>
			<li><a href="#" class="peach" title="Peach"></a></li>
			<li><a href="#" class="beige" title="Beige"></a></li>
			<li><a href="#" class="purple" title="Purple"></a></li>
			<li><a href="#" class="celadon" title="Celadon"></a></li>
			<li><a href="#" class="red" title="Red"></a></li>
			<li><a href="#" class="brown" title="Brown"></a></li>
			<li><a href="#" class="cherry" title="Cherry"></a></li>
			<li><a href="#" class="cyan" title="Cyan"></a></li>
			<li><a href="#" class="gray" title="Gray"></a></li>
			<li><a href="#" class="olive" title="Olive"></a></li>
		</ul>
	</div>
		
</div>
<!-- Style Switcher / End -->

<script type="text/javascript">
	
	// 로그인 실행
	function loginPcs() {
		
		if (cmmnLib.validNullChk($("#userId").val())) {
			alert("아이디를 입력해주세요.");
			return false;
		}
		
		if (cmmnLib.validNullChk($("#userPw").val())) {
			alert("패스워드를 입력해주세요.");
			return false;
		}
		
		$("#loginFrm").attr("action", "/actionLogin.do");
		
		$("#loginFrm").submit();
	}
	
	$(document).ready(function() {
		var loginSuccessYn	= "${success}";
		
		if (loginSuccessYn === "N") {
			alert("로그인에 실패했습니다.");
		}
		
		<c:if test="${eSangMu == 'Y'}">
			$("#joinVO").attr("action", "/insertUsrInfo.do");
		
			$("#joinVO").submit();
    	</c:if>
    	<c:if test="${eSangMu == 'N'}">
    		$("#registerBtn").trigger("click");
    		alert("회원가입에 실패했습니다.");
    	</c:if>
    
		// 회원 가입 버튼 클릭
		$("#registerBtn").click(function() {
			$("#joinVO").attr("action", "/joinFrmChk.do");
			
			$("#joinVO").submit();
		});
		
		// 로그인 버튼 클릭
		$("#loginBtn").click(function() {
			loginPcs();
		});
		
		// 로그인 엔터키 처리
		$("#userPw").keydown(function(e) {
			
			if (e.keyCode == 13) {
				loginPcs();
			}
		});
		
	});
	
</script>

</body>
</html>