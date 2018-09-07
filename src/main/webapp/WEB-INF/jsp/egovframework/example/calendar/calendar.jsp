<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- 
	* ========================================
	* 작성자   | 유재영 
	* 설명     | 일정 관리 페이지
	* ========================================
 -->   

<link href='css/fullcalendar.min.css' rel='stylesheet' />
<link href='css/fullcalendar.print.min.css' rel='stylesheet' media='print' />
<script src='js/lib/moment.min.js'></script>
<script src='js/lib/jquery.min.js'></script>
<script src='js/fullcalendar.min.js'></script>	
<script type="text/javascript">
	
	$(document).ready(function() {
		var today 	= new Date();
		var dd 		= today.getDate();
		var mm 		= today.getMonth() + 1;
		var yyyy 	= today.getFullYear();

		if (dd < 10) {
		    dd 	= "0" + dd;
		} 

		if (mm < 10) {
		    mm 	= "0" + mm;
		} 

		today 	= yyyy + '-' + mm + '-' + dd;
		
	    $('#calendar').fullCalendar({
	      header			: {
	        left	: 'prev,next today',
	        center	: 'title',
	        right	: 'month,agendaWeek,agendaDay,listMonth'
	      },
	      defaultDate		: today,
	      navLinks			: true,
	      businessHours		: true,
	      editable			: true,
	      monthNames		: ["1월","2월","3월","4월","5월","6월","7월","8월","9월","10월","11월","12월"],
	      monthNamesShort	: ["1월","2월","3월","4월","5월","6월","7월","8월","9월","10월","11월","12월"],
	      dayNames			: ["일요일","월요일","화요일","수요일","목요일","금요일","토요일"],
	      dayNamesShort		: ["일","월","화","수","목","금","토"],
	      buttonText		: {
	      	today 	: "오늘",
	     	month 	: "월별",
	      	week 	: "주별",
	      	day 	: "일별",
	      },
	      events			: [
	        {
	          title: 'Business Lunch',
	          start: '2018-03-03T13:00:00',
	          constraint: 'businessHours'
	        },
	        {
	          title: 'Meeting',
	          start: '2018-03-13T11:00:00',
	          constraint: 'availableForMeeting',
	          color: '#257e4a'
	        },
	        {
	          title: 'Conference',
	          start: '2018-03-18',
	          end: '2018-03-20'
	        },
	        {
	          title: 'Party',
	          start: '2018-03-29T20:00:00'
	        },
	
	        // areas where "Meeting" must be dropped
	        {
	          id: 'availableForMeeting',
	          start: '2018-03-11T10:00:00',
	          end: '2018-03-11T16:00:00',
	          rendering: 'background'
	        },
	        {
	          id: 'availableForMeeting',
	          start: '2018-03-13T10:00:00',
	          end: '2018-03-13T16:00:00',
	          rendering: 'background'
	        },
	
	        // red areas where no events can be dropped
	        {
	          start: '2018-03-24',
	          end: '2018-03-28',
	          overlap: false,
	          rendering: 'background',
	          color: '#ff9f89'
	        },
	        {
	          start: '2018-03-06',
	          end: '2018-03-08',
	          overlap: false,
	          rendering: 'background',
	          color: '#ff9f89'
	        }
	      ]
	    });
	
	});
	
</script>
<style>

  #calendar {
    max-width: 900px;
    margin: 0 auto;
    border: 3px solid white;
    background-color: white;
    margin-bottom: 50px;
    padding: 20px;
  }

</style>
		
	<!-- 스케줄 영역 -->
	<div id="calendar"></div>
	
	<!-- 일정 리스트 -->		
	<div class="row">
		<div class="col-lg-12 col-md-12">
			<div class="dashboard-list-box margin-top-0">
				<h4>"<c:out value="${loginVO.userNick }" />" 님의 일정</h4>
				<ul>
					<li>
						<div class="list-box-listing">
							<div class="list-box-listing-img"><a href="#"><img src="images/listing-item-01.jpg" alt=""></a></div>
							<div class="list-box-listing-content">
								<div class="inner">
									<h3><a href="#">Tom's Restaurant</a></h3>
									<span>964 School Street, New York</span>
									<div class="star-rating" data-rating="3.5">
										<div class="rating-counter">(12 reviews)</div>
									</div>
								</div>
							</div>
						</div>
						<div class="buttons-to-right">
							<a href="#" class="button gray"><i class="sl sl-icon-note"></i> Edit</a>
							<a href="#" class="button gray"><i class="sl sl-icon-close"></i> Delete</a>
						</div>
					</li>
				</ul>
			</div>
		</div>


		<!-- Copyrights -->
		<div class="col-md-12">
			<div class="copyrights">© 2018 한큐에이직. 개인 포트폴리오 작업.</div>
		</div>
	</div>
