package com.personal.entity;

public class UserPart {
	
	private String uid;
	
	private String nickname;
	
	private String headpicture;

	
	
	@Override
	public String toString() {
		return "UserPart [uid=" + uid + ", nickname=" + nickname + ", headpicture=" + headpicture + "]";
	}

	public UserPart() {

	}
	
	public UserPart(String uid) {

		this.uid = uid;
	}

	public String getUid() {
		return uid;
	}


	public void setUid(String uid) {
		this.uid = uid;
	}



	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getHeadpicture() {
		return headpicture;
	}

	public void setHeadpicture(String headpicture) {
		this.headpicture = headpicture;
	}
	
	
	

}
