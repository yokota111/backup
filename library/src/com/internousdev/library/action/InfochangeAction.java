package com.internousdev.library.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class InfochangeAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;

	public String aaa() {
		String selectmessage;
		selectmessage = "a";
		session.put("selectmessage", selectmessage);

		return SUCCESS;
	}

	public String bbb() {
		String selectmessage;
		selectmessage = "b";
		session.put("selectmessage", selectmessage);
		return SUCCESS;
	}

	public String ccc() {
		String selectmessage;
		selectmessage = "c";
		session.put("selectmessage", selectmessage);
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
