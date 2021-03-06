package com.internousdev.library.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.library.dao.InfochangeConpleteDAO;
import com.internousdev.library.dao.LoginDAO;
import com.internousdev.library.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class InfochangeConpleteAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;

	InfochangeConpleteDAO infochangeConpleteDAO = new InfochangeConpleteDAO();

	private List<LoginDTO> loginDTOList = new ArrayList<LoginDTO>();

	private LoginDAO loginDAO = new LoginDAO();

	public String result;

	public String aaa() {

		if (!((session.get("NewLoginUserId").toString()) == null)) {
			infochangeConpleteDAO.getloginuserinfo1(session.get("loginid").toString(),
					session.get("NewLoginUserId").toString());

			loginDTOList = loginDAO.getloginuserinfo(session.get("NewLoginUserId").toString(),
					session.get("loginpassword").toString());

			session.put("loginuser", loginDTOList);
			session.put("NewLoginUserId", null);
			result = SUCCESS;

		}
		return result;
	}

	public String bbb() {
		if (!((session.get("NewLoginPassword").toString()) == null)) {
			infochangeConpleteDAO.getloginuserinfo2(session.get("loginid").toString(),
					session.get("NewLoginPassword").toString());

			loginDTOList = loginDAO.getloginuserinfo(session.get("loginid").toString(),
					session.get("NewLoginPassword").toString());

			session.put("loginuser", loginDTOList);
			session.put("NewLoginPassword", null);
			result = SUCCESS;
		}
		return result;
	}

	public String ccc() {
		if (!((session.get("NewUserName").toString()) == null)) {
			infochangeConpleteDAO.getloginuserinfo3(session.get("loginid").toString(),
					session.get("NewUserName").toString());

			loginDTOList = loginDAO.getloginuserinfo(session.get("loginid").toString(),
					session.get("loginpassword").toString());

			session.put("loginuser", loginDTOList);
			session.put("NewUserName", null);
			result = SUCCESS;
		}

		return result;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
