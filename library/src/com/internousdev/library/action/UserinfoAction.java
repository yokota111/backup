package com.internousdev.library.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class UserinfoAction extends ActionSupport implements SessionAware {

	/**
	 * ログイン情報を格納
	 */
	public Map<String, Object> session;

	public String execute() {
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
