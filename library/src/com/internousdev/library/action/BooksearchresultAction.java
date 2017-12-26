package com.internousdev.library.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import org.apache.catalina.connector.ClientAbortException;
import org.apache.struts2.interceptor.SessionAware;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.xwork2.ActionSupport;

public class BooksearchresultAction extends ActionSupport implements SessionAware {
	public Map<String, Object> session;

	public String searchname;

	public String title;

	public String execute() {

		try {
			URL url = new URL("https://www.googleapis.com/books/v1/volumes?q=ISBN=夏目漱石");

			StringBuilder builder = new StringBuilder();
			HttpURLConnection connection = null;
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();

			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			String line;
			while ((line = reader.readLine()) != null) {
				builder.append(line);
			}
			ObjectMapper mapper = new ObjectMapper();
			JsonNode root = mapper.readTree(builder.toString());


			title = root.get("items").get(0).get("volumeInfo").get("author").asText();

			session.put("title", title);

		} catch (ClientAbortException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SUCCESS;

	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
