package com.internousdev.library.dto;

public class LoginDTO {

	public String Login_id;
	public String Login_password;
	public String Username;
	public boolean LoginFlg = false;

	public String getLogin_id() {
		return Login_id;
	}

	public void setLogin_id(String login_id) {
		this.Login_id = login_id;
	}

	public String getLogin_password() {
		return Login_password;
	}

	public void setLogin_password(String login_password) {
		this.Login_password = login_password;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		this.Username = username;
	}

	public boolean getLoginFlg() {
		return LoginFlg;
	}

	public void setLoginFlg(boolean loginFlg) {
		this.LoginFlg = loginFlg;
	}

}
