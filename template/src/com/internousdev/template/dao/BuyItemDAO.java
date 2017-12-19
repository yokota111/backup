package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.template.dto.BuyItemDTO;
import com.internousdev.template.util.DBConnector;

public class BuyItemDAO {

	private DBConnector dbConnector = new DBConnector();

	private Connection connection = dbConnector.getConnection();

	private BuyItemDTO buyItemDTO = new BuyItemDTO();

	public List<BuyItemDTO> buyItemDTOList = new ArrayList<BuyItemDTO>();

	/**
	 * 商品情報取得メソッド
	 *
	 * @return BuyItemDTO
	 */
	public List<BuyItemDTO> getBuyItemInfo() {

		String sql = "SELECT id,item_name,item_price,item_stock FROM item_info_transaction";
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);

			ResultSet resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				buyItemDTO.setId(resultSet.getInt("id"));
				buyItemDTO.setItemName(resultSet.getString("item_name"));
				buyItemDTO.setItemPrice(resultSet.getString("item_price"));
				buyItemDTO.setItemstock(resultSet.getInt("item_stock"));
				buyItemDTOList.add(buyItemDTO);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return buyItemDTOList;
	}

	public BuyItemDTO getBuyItemDTO() {
		return buyItemDTO;
	}

}