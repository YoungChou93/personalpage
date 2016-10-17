package com.personal.entity;

import com.personal.entity.User;

public class UserCustom extends User {

	/* 验证码*/
	private String verifyCode;
	
	/* 确认密码*/
	private String confirmPassword;
	
	/* 原密码*/
	private String oldPassword;
	
	public UserCustom() {
		super();
	}

	public UserCustom(String uid) {
		super(uid);
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	
}
