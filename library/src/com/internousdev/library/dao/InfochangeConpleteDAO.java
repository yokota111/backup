package com.internousdev.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.library.dto.LoginDTO;
import com.internousdev.library.util.DBConnector;
import com.internousdev.library.util.DateUtil;

public class InfochangeConpleteDAO {

	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();
	public List<LoginDTO> loginDTOList = new ArrayList<LoginDTO>();
	private DateUtil dateUtil = new DateUtil();

	public void getloginuserinfo1(String loginid, String NewLoginUserId) {
		String sql = "update manager_login set login_id=?,updated_time=? where login_id=?";
		try {

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, NewLoginUserId);
			ps.setString(2, dateUtil.getDate());
			ps.setString(3, loginid);
			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void getloginuserinfo2(String loginid, String NewLoginPassword) {
		String sql = "update manager_login set login_pass=?,updated_time=? where login_id=?";
		try {

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, NewLoginPassword);
			ps.setString(2, dateUtil.getDate());
			ps.setString(3, loginid);
			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void getloginuserinfo3(String loginid, String NewUserName) {
		String sql = "update manager_login set user_name=?,updated_time=? where login_id=?";
		try {

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, NewUserName);
			ps.setString(2, dateUtil.getDate());
			ps.setString(3, loginid);
			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}