package com.internousdev.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.library.dto.LoginDTO;
import com.internousdev.library.util.DBConnector;

public class InfochangeDAO {

	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();
	LoginDTO loginDTO = new LoginDTO();

	public LoginDTO getuserinfo1(String NewLoginUserId) {
		String sql = "select * from manager_login where login_id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, NewLoginUserId);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				loginDTO.setLogin_id(rs.getString("login_id"));
				loginDTO.setLogin_password(rs.getString("login_pass"));
				loginDTO.setUsername(rs.getString("user_name"));
			}

		} catch (

		SQLException e) {
			e.printStackTrace();
		}
		return loginDTO;
	}


}
