package egovframework.example.login.service;

public class LoginVO {
	public String userId	= ""; /* 사용자 아이디     */
	public String userNm	= ""; /* 사용자 이름       */
	public String userNick	= ""; /* 사용자 닉네임     */
	public String userPhone	= ""; /* 사용자 폰 번호    */
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	public String getUserNick() {
		return userNick;
	}
	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	
	@Override
	public String toString() {
		return "LoginVO [userId=" + userId + ", userNm=" + userNm + ", userNick=" + userNick + ", userPhone="
				+ userPhone + "]";
	}
}
