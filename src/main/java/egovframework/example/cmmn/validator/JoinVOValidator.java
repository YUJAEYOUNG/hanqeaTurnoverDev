package egovframework.example.cmmn.validator;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import egovframework.example.cmmn.Constants;
import egovframework.example.join.service.JoinVO;

/**
 * ========================================
 * 작성자       | 유재영
 * 최초생성일   | 2018-08-10
 * 페이지       | JoinVOValidator.java
 * 설명         | 회원가입 벨리데이터 생성
 * ========================================
 */
@Component("joinVOValidator")
public class JoinVOValidator implements Validator {
	
	@Resource(name = "messageSource")
	private MessageSource message;
	
	/*@Value("${NotEmpty}")
    private String jaeyoung;*/
	
	// 타입 검사
	@Override
	public boolean supports(Class<?> clazz) {
		// System.out.println("jaeyoung ::: " + jaeyoung);
		return JoinVO.class.equals(clazz); // supports 는 해당 검사대상이 오브젝트인지 아닌지 검사함 (오브젝트 여야함)
	}
	
	/**
	 * 아이디, 이름, 비밀번호, 비밀번호 재 확인, 폰 번호 유효성 체크 (닉네임 진행중)
	 * @param target
	 * @param errors
	 */
	@Override
	public void validate(Object target, Errors errors) {
		JoinVO joinVO = (JoinVO) target;
		
		mberIdValidChk("joinVO.mberId", 		joinVO.getMberId(), 	joinVO, errors);
		mberNmValidChk("joinVO.mberNm", 		joinVO.getMberNm(), 	joinVO, errors);
		mberPwValidChk("joinVO.mberPw", 		joinVO.getMberPw(), 	joinVO, errors);
		mberPwChkValidChk("joinVO.mberPw", 		joinVO.getMberPwChk(), 	joinVO, errors);
		mberPhoneValidChk("joinVO.mberPhone", 	joinVO.getMberPhone(), 	joinVO, errors);
	}
	
	/**
	 * 회원 아이디 체크
	 * @param string
	 * @param mberId
	 * @param joinVO
	 * @param errors
	 */
	private void mberIdValidChk(String string, String mberId, JoinVO joinVO, Errors errors) {
		boolean chk = false;
		
		String 	fieldName		= "mberId",
				errorCode		= Constants.errorRequired,
				propFieldName	= getPropMessage(string);
		
		chk	= nullOrEmptyChk(mberId);
		
		if (!chk) {
			errors.rejectValue(fieldName, errorCode, new Object[] {propFieldName}, null);
		}
		
		// 이메일 유효성 체크 시작
		errorCode	= Constants.errorEmail;
		
		chk = emailChk(mberId);
		
		if (!chk) {
			errors.rejectValue(fieldName, errorCode, new Object[] {propFieldName}, null);
			
			return;
		}
	}
	
	/**
	 * 메일 형식 체크
	 * @param mberId
	 * @return
	 */
	private boolean emailChk(String mberId) {
		String regex	= Constants.errorRegex;
		
		if (!mberId.matches(regex)) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * 회원 명 체크
	 * @param string
	 * @param mberNm
	 * @param serverSideVO
	 * @param errors
	 */
	private void mberNmValidChk(String string, String mberNm, JoinVO joinVO, Errors errors) {
		boolean chk = false;
		
		String 	fieldName		= "mberNm",
				errorCode		= Constants.errorRequired,
				propFieldName	= getPropMessage(string);
		
		chk	= nullOrEmptyChk(mberNm);
		
		if (!chk) {
			errors.rejectValue(fieldName, errorCode, new Object[] {propFieldName}, null);
		}
	}
	
	/**
	 * 패스워드 유효성 체크
	 * @param string
	 * @param password
	 * @param serverSideVO
	 * @param errors
	 */
	private void mberPwValidChk(String string, String password, JoinVO joinVO, Errors errors) {
		boolean chk = false;
		
		String 	fieldName		= "mberPw",
				errorCode		= Constants.errorRequired,
				propFieldName	= getPropMessage(string);
		
		chk	= nullOrEmptyChk(password);
		
		if (!chk) {
			errors.rejectValue(fieldName, errorCode, new Object[] {propFieldName}, null);
		}
		
		// 최소 글자 유효성 체크 시작
		int minLengthCnt	= 6;
		int maxLengthCnt	= 16;
		int cnt				= 0;	// 구분자
		
		if (password.length() < 6) {
			errorCode	= Constants.errorMinLength;
			chk	= minLengthChk(password, minLengthCnt);
			cnt	= minLengthCnt;
		} else if (password.length() > 16) {
			errorCode	= Constants.errorMaxLength;
			chk	= maxLengthChk(password, maxLengthCnt);
			cnt	= maxLengthCnt;
		}
		
		if (!chk) {
			errors.rejectValue(fieldName, errorCode, new Object[] {propFieldName, cnt}, null);
			
			return;
		}
		
		// 비밀번호 네자리 연속 불가능 유효성 체크 시작
		errorCode	= Constants.ERROR_SAME_CHAR;
		
		int sameCharCnt = 4;
		
		chk	= sameCharChk(password, sameCharCnt);
		
		if (!chk) {
			errors.rejectValue(fieldName, errorCode, new Object[] {propFieldName, sameCharCnt}, null);
			
			return;
		}
		
		// 비밀번호 연속된 문자 여부 유효성 체크 시작 (ex. asdf 같은..)
		errorCode	= Constants.ERROR_CONTINUOUSCHAR;
		
		int continuousCharCnt	= 4;
		
		chk = continuousCharChk(password, continuousCharCnt);
		
		if (!chk) {
			errors.rejectValue(fieldName, errorCode, new Object[] {propFieldName, continuousCharCnt}, null);
			
			return;
		}
		
		// 비밀번호 입력시 아이디와 겹치지 않게 유효성 체크 시작
		errorCode	= Constants.ERROR_OVERLAP_CHAR;
		
		int overlapCharCnt	= 6;
		
		chk	= overlapCharChk(password, joinVO.getMberId(), overlapCharCnt);
		
		if (!chk) {
			errors.rejectValue(fieldName, errorCode, new Object[] {propFieldName, overlapCharCnt}, null);
			
			return;
		}
		
		// 키보드배열의 연속된 숫자 4자리 이상 겹치지 않게 체크
		errorCode	= Constants.ERROR_QWERTY;
		
		int qwertyCharCnt	= 4;
		
		chk	= qwertyCharChk(password, qwertyCharCnt);
		
		if (!chk) {
			errors.rejectValue(fieldName, errorCode, new Object[] {propFieldName, qwertyCharCnt}, null);
			
			return;
		}
	}
	
	/**
	 * 패스워드 재 확인
	 * @param string
	 * @param passwordConfirm
	 * @param joinVO
	 * @param errors
	 */
	private void mberPwChkValidChk(String string, String passwordConfirm, JoinVO joinVO,
			Errors errors) {
		boolean chk = false;
		
		String 	fieldName		= "mberPwChk",
				errorCode		= Constants.errorRequired,
				propFieldName	= getPropMessage(string);
		
		chk	= nullOrEmptyChk(passwordConfirm);
		
		if (!chk) {
			errors.rejectValue(fieldName, errorCode, new Object[] {propFieldName}, null);
		}
		
		// 비밀번호 일치여부 유효성 체크 시작
		errorCode	= Constants.errorPwConfirm;
		
		chk	= pwConfirm(passwordConfirm, joinVO.getMberPw());
		
		if (!chk) {
			errors.rejectValue(fieldName, errorCode, new Object[] {propFieldName}, null);
			
			return;
		}
	}
	
	/**
	 * 키보드 배열 4자리 연속 같은 숫자 X (EX). abcd, efgh 등)
	 * @param password
	 * @param qwertyCharCnt
	 * @return
	 */
	private boolean qwertyCharChk(String password, int qwertyCharCnt) {
		String qwertyChar	= Constants.QWERTY_STRING;
		
		String group	= password.substring(0, qwertyCharCnt);
		
		StringBuilder build = new StringBuilder();
		build.append("(" + group + ")");
		
		int endIdx		= 0,
			pwLength	= password.length();
		
		for (int i = 1; i <= pwLength - qwertyCharCnt; i++) {
			endIdx	= (i + qwertyCharCnt);
			
			group = password.substring(i, endIdx);
			build.append("|(" + group +")");
		}
		
		Pattern pattern	= Pattern.compile(build.toString());
		Matcher matcher	= pattern.matcher(qwertyChar);
		
		if (matcher.find()) {
			boolean findChk	= ((matcher.end() - matcher.start()) == qwertyCharCnt);
			
			if (findChk) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * 아이디와 비밀번호 동일 4글자 이상 중복 X
	 * @param password
	 * @param mberId
	 * @param overlapCharCnt
	 * @return
	 */
	private boolean overlapCharChk(String password, String mberId, int overlapCharCnt) {
		String group	= password.substring(0, overlapCharCnt);
		
		StringBuilder build = new StringBuilder();
		build.append("(" + group + ")");
		
		int endIdx		= 0,
			pwLength	= password.length();
		
		for (int i = 1; i <= pwLength - overlapCharCnt; i++) {
			endIdx	= (i + overlapCharCnt);
			
			group = password.substring(i, endIdx);
			build.append("|(" + group +")");
		}
		
		Pattern pattern	= Pattern.compile(build.toString());
		Matcher matcher	= pattern.matcher(mberId);
		
		if (matcher.find()) {
			boolean findChk	= ((matcher.end() - matcher.start()) == overlapCharCnt);
			
			if (findChk) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * 연속된 수 X (EX). asdf, qwer 등)
	 * @param password
	 * @param continuousCharCnt
	 * @return
	 */
	private boolean continuousCharChk(String password, int continuousCharCnt) {
		int	totCnt1	= 0,
			totCnt2	= 0,
			cnt1	= 0,
			cnt2	= 0;
		
		for (int i = 0; i < password.length() - 1; i++) {
			cnt1	= Character.codePointAt(password, i);
			cnt2	= Character.codePointAt(password, i + 1);
			
			totCnt1	= (cnt1 - cnt2 == 1) ? totCnt1 + 1 : 0;
			totCnt2	= (cnt2 - cnt1 == 1) ? totCnt2 + 1 : 0;
			
			if (totCnt1 >= continuousCharCnt - 1 || totCnt2 >= continuousCharCnt - 1) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * 같은 글자 4연속 방지
	 * @param password
	 * @param sameCharCnt
	 * @return
	 */
	private boolean sameCharChk(String password, int sameCharCnt) {
		int index	= 0;
		
		char checkPassword, checkPassword2;
		
		for (int i = 0; i < password.length() - 1; i++) {
			checkPassword	= password.charAt(i);
			checkPassword2	= password.charAt(i + 1);
			
			if (checkPassword == checkPassword2) {
				index ++;
			} else {
				index = 0;
			}
			
			if (index >= sameCharCnt - 1) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * 비밀번호 재확인 true / false 반환
	 * @param passwordConfirm
	 * @param password
	 * @return
	 */
	private boolean pwConfirm(String passwordConfirm, String password) {
		
		if (!passwordConfirm.equals(password)) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * 전화번호 밸리데이션 유효성 체크
	 * @param string
	 * @param phoneNumber
	 * @param serverSideVO
	 * @param errors
	 */
	private void mberPhoneValidChk(String string, String phoneNumber, JoinVO joinVO, Errors errors) {
		boolean chk = false;
		
		String 	fieldName		= "mberPhone",
				errorCode		= Constants.errorRequired,
				propFieldName	= getPropMessage(string);
		
		chk	= nullOrEmptyChk(phoneNumber);
		
		if (!chk) {
			errors.rejectValue(fieldName, errorCode, new Object[] {propFieldName}, null);
			
			return;
		}
		
		// 전화번호 형식 유효성 체크 시작
		errorCode	= Constants.errorPhoneNumber;
		
		chk	= phoneNumberChk(phoneNumber);
		
		if (!chk) {
			errors.rejectValue(fieldName, errorCode, new Object[] {propFieldName}, null);
			
			return;
		}
	}
	
	/**
	 * 전화번호 정규식 체크
	 * @param phoneNumber
	 * @return
	 */
	private boolean phoneNumberChk(String phoneNumber) {
		String regex	= Constants.phoneNumberRegex;
		
		if (!phoneNumber.matches(regex)) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * 메시지 프로퍼티 값 가져오기
	 * @param string
	 * @return
	 */
	private String getPropMessage(String string) {
		return message.getMessage(string, null, Locale.KOREA);
	}
	
	/**
	 * 빈 값 벨리데이션 체크
	 * @param fieldValue
	 * @return
	 */
	private boolean nullOrEmptyChk(String fieldValue) {
		
		if ("".equals(fieldValue) || fieldValue == null) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * 최대 길이 체크
	 * @param password
	 * @param maxLengthCnt
	 * @return
	 */
	private boolean maxLengthChk(String password, int maxLengthCnt) {
		
		if (password.length() > maxLengthCnt) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * 최소 길이 체크
	 * @param password
	 * @param minLengthCnt
	 * @return
	 */
	private boolean minLengthChk(String password, int minLengthCnt) {
		
		if (password.length() < minLengthCnt) {
			return false;
		}
		
		return true;
	}
}
