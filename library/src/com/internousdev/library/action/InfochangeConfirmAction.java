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

	public String execute() {
		String result = null;
		LoginDTO loginDTO = new LoginDTO();

		if (!(NewLoginUserId.equals(""))) {
			loginDTO = infochangeDAO.getuserinfo1(NewLoginUserId);
			System.out.println(loginDTO.getLogin_id());
			if ((NewLoginUserId.equals(loginDTO.getLogin_id()))) {
				setErrorMessage("**すでに使われているIDです**");
				result = ERROR;

			} else {
				result = SUCCESS;
			}
		} else {
			setErrorMessage("**未入力の項目があります。**");
			result = ERROR;

		}

		if (!(NewLoginPassword.equals(""))) {
			loginDTO = infochangeDAO.getuserinfo2(NewLoginPassword);
			System.out.println(loginDTO.getLogin_id());
			if ((NewLoginPassword.equals(loginDTO.getLogin_id()))) {
				setErrorMessage("**すでに使われているIDです**");
				result = ERROR;

			} else {
				result = SUCCESS;
			}
		} else {
			setErrorMessage("**未入力の項目があります。**");
			result = ERROR;

		}

		if (!(NewLoginUserId.equals(""))) {
			loginDTO = infochangeDAO.getuserinfo3(NewUserName);
			System.out.println(loginDTO.getLogin_id());
			if ((NewUserName.equals(loginDTO.getLogin_id()))) {
				setErrorMessage("**すでに使われているIDです**");
				result = ERROR;

			} else {
				result = SUCCESS;
			}
		} else {
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
