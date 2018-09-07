<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" 	uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" 	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" 		uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" 		uri="http://java.sun.com/jsp/jstl/functions"%>

	<script type="text/javascript">
		// 메뉴 객체 생성
		var Menu	= {
			$menuTarget	: $("#menuStart"),
			// 메뉴 리스트 생성
			menuInit	: function() {
				var that		= this;
				var paramData	= {};
				
				cmmnLib.callAjax("/mainMenuList.do", paramData, "get", function(result) {
					
					$.each(result, function(i, item) {
						var strMenu	= "";
						// 하위 메뉴 없을 시
						if (item.menuChildYn === "N") { 
                    		strMenu	+=	'<li class="">'
                    				+		'<a href="' + item.menuUrl + '">'
                    				+			'<i class="' + item.menuClass + '"></i> '
                    				+			item.menuNm
                    				+		'</a>'
                    				+	'</li>';
						} else {
							strMenu	+=	'<li class="">'
                					+		'<a>'
                					+			'<i class="' + item.menuClass + '"></i> '
                					+			item.menuNm
                					+		'</a>'
                					+		'<ul>' + that.subMenuInit(item.menuId) + '</ul>'
                					+	'</li>';
						}
						
						$("#menuStart").append(strMenu);
					});
					
				});
			},
			// 서브 메뉴리스트 생성
			subMenuInit	: function(obj) {
				var that 		= this;
				var paramData	= {"menuId" : obj};
				var strSubMenu	= "";
				
				cmmnLib.callAjax("/subMenuList.do", paramData, "get", function(result) {
					
					$.each(result, function(i, item) {
						// 하위 메뉴 없을 시
						if (item.menuChildYn === "N") {
							strSubMenu	+=	'<li>'
										+		'<a href="' + item.menuUrl + '">'
										+			'' + item.menuNm + ' <span class="' + item.menuClass + '"></span>'
										+		'</a>'
										+	'</li>';
						}
						/*  ※ 하위 메뉴 레벨 별 구현 되어 있으나, 부트스트랩은 2 뎁스 모양까지만 구현!
						else {
							strSubMenu	+=	'<li>'
										+		'<a>'
										+			'' + item.menuNm + ' <span class="' + item.menuClass + '"></span>'
										+		'</a>'
										+       '<ul>' + that.subMenuInit(item.menuId) + '</ul>'
										+	'</li>';
						} */
					});
				});
				
				return strSubMenu;
			}
		};
	
		$(document).ready(function() {
			Menu.menuInit();
		});
		
	</script>
	
    <!-- Navigation (레프트 메뉴)
	================================================== -->

	<!-- Responsive Navigation Trigger -->
	<a href="#" class="dashboard-responsive-nav-trigger"><i class="fa fa-reorder"></i> Dashboard Navigation</a>

	<div class="dashboard-nav">
		<div class="dashboard-nav-inner">

			<ul data-submenu-title="개인 포트폴리오" id="menuStart">
			</ul>
			
		</div>
	</div>
	<!-- Navigation / End -->