package egovframework.example.cmmn;

public interface Constants {
	static final String errorRequired			= "errors.required";
	static final String errorEmail				= "errors.email";
	static final String errorMinLength			= "errors.minLength";
	static final String errorMaxLength			= "errors.maxLength";
	static final String errorPwConfirm			= "errors.pwConfirm";
	static final String errorPhoneNumber		= "errors.PhoneNumber";
	static final String ERROR_SAME_CHAR			= "errors.sameChar";
	static final String ERROR_CONTINUOUSCHAR	= "errors.ERROR_CONTINUOUSCHAR";
	static final String ERROR_OVERLAP_CHAR		= "errors.ERROR_OVERLAP_CHAR";
	static final String ERROR_QWERTY			= "errors.ERROR_QWERTY";
	static final String FAIL					= "fail";
	static final String SUCCESS					= "success";

	static final String errorRegex				= "^[_0-9a-zA-Z-\\.]+@[_0-9a-zA-Z-]+\\.([\\._0-9a-zA-Z-]+)*$";
	static final String phoneNumberRegex		= "^(01[016789]{1}|02|03[12]{1}" + "|04[1234]{1}|05]12345]{1}|06[1234]{1})[1-9]{3,4}[1-9]{4}$";
	static final String QWERTY_STRING			= "1234567890-=!@#$%^&*()_+qwertyuiop[]" + "QWERTYUIOP{}asdfghjkl;'ASDFGHJKL:zxcvbnm,./ZXCVBNM<>?";
}
