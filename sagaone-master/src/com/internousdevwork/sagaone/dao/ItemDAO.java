package com.internousdevwork.sagaone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import com.internousdevwork.sagaone.dto.ItemDTO;
import com.internousdevwork.sagaone.util.DBConnector;

public class ItemDAO {
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();

	private List<ItemDTO> itemDTOList2 = new ArrayList<ItemDTO>();
	NumberFormat nfNum = NumberFormat.getNumberInstance();

	/**
	 * 商品情報取得
	 */

	public List<ItemDTO> getiteminfo1() {
		String sql = "select a.*,round(avg(b.value),1) as avgvalue ,count(b.value) as countvalue from product_info a left join review_info b on a.product_id=b.product_id group by a.product_id order by a.id asc;";

		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ItemDTO itemdto = new ItemDTO();

				itemdto.setId(rs.getInt("id"));
				itemdto.setProductId(rs.getInt("product_id"));
				itemdto.setProductName(rs.getString("product_name"));
				itemdto.setProductNameKana(rs.getString("product_name_kana"));
				itemdto.setProductDescription(rs.getString("product_description"));
				itemdto.setCategoryId(rs.getInt("category_id"));
				itemdto.setPrice(nfNum.format(rs.getInt("price")));
				itemdto.setImageFilePath(rs.getString("image_file_path"));
				itemdto.setImageFileName(rs.getString("image_file_name"));
				itemdto.setReleaseDate(rs.getString("release_date"));
				itemdto.setReleaseCompany(rs.getString("release_company"));
				itemdto.setStatus(rs.getInt("status"));
				itemdto.setRegistDate(rs.getString("regist_date"));
				itemdto.setUpdateDate(rs.getString("update_date"));
				itemdto.setAvgValue(rs.getFloat("avgvalue"));
				itemdto.setCountValue(rs.getInt("countvalue"));

				itemDTOList2.add(itemdto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return itemDTOList2;
	}


}
