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

	public String isbn;

	public String imageLink;

	public String execute() {

		try {
			URL url = new URL("https://www.googleapis.com/books/v1/volumes?q=" + searchname);

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

			isbn = root.get("items").get(0).get("volumeInfo").get("industryIdentifiers").get(1).get("identifier")
					.asText();
			title = root.get("items").get(0).get("volumeInfo").get("title").asText();

			imageLink = root.get("items").get(0).get("volumeInfo").get("imageLinks").get("thumbnail").asText();

			session.put("title", title);
			session.put("isbn", isbn);
			session.put("imageLink", imageLink);
			System.out.println(isbn);
		} catch (ClientAbortException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SUCCESS;

	}

	public String getSearchname() {
		return searchname;
	}

	public void setSearchname(String searchname) {
		this.searchname = searchname;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
