package com.internousdev.library.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.library.dao.InfochangeDAO;
import com.internousdev.library.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CreatemanagerConfirmAction extends ActionSupport implements SessionAware {

	private String NewUserId;
	private String NewPassword;
	private String NewUsername;
	private Map<String, Object> session;

	private String errorMessage;
	InfochangeDAO infochangeDAO = new InfochangeDAO();

	public String execute() {
		String result;
		if ((!(NewUserId.equals("")) && !(NewPassword.equals("")) && !(NewUsername.equals("")))) {

			LoginDTO loginDTO = new LoginDTO();
			loginDTO = infochangeDAO.getuserinfo1(NewUserId);

			if ((NewUserId.equals(loginDTO.getLogin_id()))) {
				setErrorMessage("**すでに使われているIDです**");

				result = ERROR;

			} else {

				session.put("NewUserId", NewUserId);
				session.put("NewPassword", NewPassword);
				session.put("NewUsername", NewUsername);
				result = SUCCESS;
			}
		} else {
			setErrorMessage("未入力の項目があります。");
			result = ERROR;
		}

		return result;
	}

	public String getNewUserId() {
		return NewUserId;
	}

	public void setNewUserId(String newUserId) {
		NewUserId = newUserId;
	}

	public String getNewPassword() {
		return NewPassword;
	}

	public void setNewPassword(String newPassword) {
		NewPassword = newPassword;
	}

	public String getNewUsername() {
		return NewUsername;
	}

	public void setNewUsername(String newUsername) {
		NewUsername = newUsername;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}