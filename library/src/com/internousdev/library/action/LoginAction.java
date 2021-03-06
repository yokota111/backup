package com.internousdev.library.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.library.dao.LoginDAO;
import com.internousdev.library.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {

	/**
	 * ログインid
	 */
	private String LoginUserId;

	/**
	 * ログインpassword
	 */
	private String LoginPassword;

	/**
	 * ログイン情報を格納
	 */
	public Map<String, Object> session;

	/**
	 * ログイン情報DAO
	 */
	private LoginDAO loginDAO = new LoginDAO();

	/**
	 * ログイン情報格納DTO
	 */

	private List<LoginDTO> loginDTOList = new ArrayList<LoginDTO>();

	/**
	 * 実行結果
	 */
	private String result;

	/**
	 * 実行メソッド
	 */

	@SuppressWarnings("unchecked")
	public String execute() {
		result = ERROR;

		loginDTOList = loginDAO.getloginuserinfo(LoginUserId, LoginPassword);

		session.put("loginuser", loginDTOList);
		session.put("loginid",LoginUserId);
		session.put("loginpassword",LoginPassword);
	if (((List<LoginDTO>) session.get("loginuser")).get(0).getLoginFlg()) {

			try {
				loginDAO.updatetime(LoginUserId);

			} catch (SQLException e) {
				e.printStackTrace();
			}
			result = SUCCESS;
		}
		return result;
	}

	public String getLoginUserId() {
		return LoginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		LoginUserId = loginUserId;
	}

	public String getLoginPassword() {
		return LoginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		LoginPassword = loginPassword;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
