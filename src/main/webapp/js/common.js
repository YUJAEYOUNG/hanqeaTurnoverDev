/**
 * =========================================
 * 작성자      | 유재영
 * 최초생성일  | 2018.08.13
 * 파일명      | common.js
 * 설명        | cmmnLib 공통 JS
 * =========================================
 */

/**
 * @Author 유재영
 * =========================================
 * cmmnLib 객체 생성
 * =========================================
 */
var cmmnLib = {
	
	/**
	 * @Author 유재영
	 * =========================================
	 * 공통 ajax 호출
	 * =========================================
	 * 전달값     | Object (4개 Property)
	 * url        | 호출 url
	 * param      | 전달값 
	 * type       | POST or GET
	 * onSuccess  | 성공 시 실행 함수
	 * =========================================
	 */
	callAjax		: function(url, param, type, onSuccess) {
		this.excuteAjax(url, param, type, onSuccess);
	},
	
	/**
	 * @Author 유재영
	 * =========================================
	 * 공통 ajax
	 * =========================================
	 */
	excuteAjax		: function(url, param, type, onSuccess) {
		
		$.ajax({
			url		: url,
			data	: param,
			type	: type,
			cache	: false,
			success	: onSuccess,
			
			error	: function(xhr, errMsg) {
				console.log("ajax error: " , errMsg);
			}
		});
	},
	
	/**
	 * @Author 유재영
	 * =========================================
	 * 공통 multipart-ajax 호출
	 * =========================================
	 * 전달값     | url, formdata, onSuccess
	 * url        | 호출 url
	 * formdata   | 전달값 
	 * onSuccess  | 성공 시 실행 함수
	 * =========================================
	 */
	callMultipart	: function(url, formdata, onSuccess) {
		
		$.ajax({
			url				: url,
			type			: "POST",
			data			: formdata,
			contentType		: false,	
			cache			: false,
			processData		: false,
			success			: onSuccess,
			error			: function(xhr, errMsg) {
				console.log("ajax error : ", errMsg);
			}
		});
	},
	
	/**
	 * @Author 유재영
	 * ======================================================
	 * 밸리데이션   | 빈 값(null, "", undefined) 체크
	 * return       | true / false
	 * 빈 값시 true
	 * ======================================================
	 */
	validNullChk	: function(param) {
		return (param === null || param === undefined || param === "" || param === false);
	},

	/**
	 * @Author 유재영
	 * ======================================================
	 * 밸리데이션   | 숫자(실수) 체크
	 * return       | true / false
	 * 실수 시 true
	 * ======================================================
	 */
	validFloatChk	: function(param) {

		if (cmmnLib.validNullChk(param)) {
			return false;
		}

		return !isNaN(Number(param));
	}
};

