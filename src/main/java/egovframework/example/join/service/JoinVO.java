package egovframework.example.join.service;

/**
 * ========================================
 * 작성자       | 유재영
 * 최초생성일   | 2018-08-03
 * 페이지       | JoinVO.java
 * 설명         | 회원가입 인자값 리스트
 * ========================================
 */
public class JoinVO {
	public String mberId	= ""; /* 회원 아이디(이메일 아이디)  */
	public String mberPw	= ""; /* 회원 비밀번호               */
	public String mberPwChk	= ""; /* 회원 비밀번호 확인          */
	public String mberPhone	= ""; /* 회원 폰번호                 */
	public String mberNm	= ""; /* 회원 명                     */
	public String mberNick	= ""; /* 회원 닉네임                 */
	
	public String getMberNick() {
		return mberNick;
	}
	public void setMberNick(String mberNick) {
		this.mberNick = mberNick;
	}
	public String getMberId() {
		return mberId;
	}
	public void setMberId(String mberId) {
		this.mberId = mberId;
	}
	public String getMberPw() {
		return mberPw;
	}
	public void setMberPw(String mberPw) {
		this.mberPw = mberPw;
	}
	public String getMberPwChk() {
		return mberPwChk;
	}
	public void setMberPwChk(String mberPwChk) {
		this.mberPwChk = mberPwChk;
	}
	public String getMberPhone() {
		return mberPhone;
	}
	public void setMberPhone(String mberPhone) {
		this.mberPhone = mberPhone;
	}
	public String getMberNm() {
		return mberNm;
	}
	public void setMberNm(String mberNm) {
		this.mberNm = mberNm;
	}
	@Override
	public String toString() {
		return "JoinVO [mberId=" + mberId + ", mberPw=" + mberPw + ", mberPwChk=" + mberPwChk + ", mberPhone="
				+ mberPhone + ", mberNm=" + mberNm + ", mberNick=" + mberNick + "]";
	}
	
}
