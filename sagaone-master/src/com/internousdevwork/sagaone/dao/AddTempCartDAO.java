package com.internousdevwork.sagaone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import com.internousdevwork.sagaone.dto.CartDTO;
import com.internousdevwork.sagaone.util.DBConnector;
import com.internousdevwork.sagaone.util.DateUtil;

public class AddTempCartDAO{
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();
	private DateUtil dateUtil = new DateUtil();
	private CartDTO cartDTO = new CartDTO();
	public Map<String,Object> session;

	public CartDTO getTempCartInfo(int product_id){

		String sql = "SELECT * FROM product_info WHERE product_id = ?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, product_id);

			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				cartDTO.setId(rs.getString("id"));
				cartDTO.setPrice(rs.getString("price"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return cartDTO;
	}

	public void addTempCartInfo(String id, String temp_user_id, int product_id, String product_count, String price) throws SQLException{

		String sql = "INSERT INTO cart_info(temp_user_id, product_id, product_count, price, regist_date) VALUES(?, ?, ?, ?, ?)";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, temp_user_id);
			ps.setInt(2, product_id);
			ps.setString(3, product_count);
			ps.setString(4, price);
			ps.setString(5, dateUtil.getDate());

			ps.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
	}

	public CartDTO getAddCart(String user_id, int product_id){

		String sql = "SELECT * FROM cart_info WHERE temp_user_id = ? AND product_id = ?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user_id);
			ps.setInt(2, product_id);

			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				cartDTO.setProductId(rs.getInt("product_id"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return cartDTO;
	}

	public void addUpdateCart(String count, int product_id)throws SQLException{

		String sql = "UPDATE cart_info set product_count = product_count + ? WHERE product_id = ?";

		try{
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, count);
		ps.setInt(2, product_id);

		ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}