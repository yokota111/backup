package com.internousdev.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.library.dto.LoginDTO;
import com.internousdev.library.util.DBConnector;
import com.internousdev.library.util.DateUtil;

public class UsercreateConpleteDAO {

	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();
	public List<LoginDTO> loginDTOList = new ArrayList<LoginDTO>();
	private DateUtil dateUtil = new DateUtil();
	private String sql = "insert into user_info(name,create_day) value(?,?)";

	public void adduser(String Username) throws SQLException {

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, Username);
			ps.setString(2, dateUtil.getDate());
			ps.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
	}
}
