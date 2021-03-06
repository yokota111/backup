package com.internousdev.library.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.library.dao.InfochangeDAO;
import com.internousdev.library.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class InfochangeConfirmAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;

	public String NewLoginUserId;
	public String NewLoginPassword;
	public String NewUserName;
	public List<LoginDTO> loginDTOList = new ArrayList<LoginDTO>();
	private String errorMessage;
	InfochangeDAO infochangeDAO = new InfochangeDAO();
	public String result = null;

	public String aaa() {

		LoginDTO loginDTO = new LoginDTO();

		loginDTO = infochangeDAO.getuserinfo1(NewLoginUserId);
		if ((NewLoginUserId.equals(loginDTO.getLogin_id()))) {
			setErrorMessage("**すでに使われているIDです**");
			result = ERROR;

		} else if ((NewLoginUserId.equals(""))) {
			setErrorMessage("**未入力の項目があります。**");
			result = ERROR;

		} else if (!(NewLoginUserId.equals(""))) {
			session.put("NewLoginUserId", NewLoginUserId);
			result = SUCCESS;

		}
		return result;
	}

	public String bbb() {
		if (!(NewLoginPassword.equals(""))) {
			session.put("NewLoginPassword", NewLoginPassword);
			result = SUCCESS;

		} else if ((NewLoginPassword.equals(""))) {
			setErrorMessage("**未入力の項目があります。**");
			result = ERROR;
		}
		return result;

	}

	public String ccc() {
		if (!(NewUserName.equals(""))) {
			session.put("NewUserName", NewUserName);
			result = SUCCESS;

		} else if ((NewUserName.equals(""))) {
			setErrorMessage("**未入力の項目があります。**");
			result = ERROR;

		}
		return result;

	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
