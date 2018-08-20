<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles"  prefix="tiles"%>
<!doctype html>
<html class="no-js" lang="en">
	<head>
   		<tiles:insertAttribute name="header"/>
	</head>
	<body>
		<!-- Wrapper -->
		<div id="wrapper">
			<tiles:insertAttribute name="nav"/>
			<!-- Dashboard -->
			<div id="dashboard">
				<tiles:insertAttribute name="left"/>
				<tiles:insertAttribute name="content"/>
			</div>
			<!-- Dashboard / END -->
		</div>
	</body>
	
	<!-- 사용자 정의 스크립트 (공통 포함) -->
	<script type="text/javascript" src="js/common.js"></script>
	<script type="text/javascript" src="js/custom/jcy.js"></script>
	<script type="text/javascript" src="js/custom/jjm.js"></script>
	<script type="text/javascript" src="js/custom/yjy.js"></script>
	<script type="text/javascript" src="js/custom/kdy.js"></script>
	<script type="text/javascript" src="js/custom/kmj.js"></script>
	<!-- // 사용자 정의 스크립트 -->
	
	<!-- 부트스트랩 js Start -->
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
</html>
