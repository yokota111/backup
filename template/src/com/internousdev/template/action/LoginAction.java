package com.internousdev.template.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.BuyItemDAO;
import com.internousdev.template.dao.LoginDAO;
import com.internousdev.template.dto.BuyItemDTO;
import com.internousdev.template.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ログイン認証処理 Login.jspからログインID,ログインパスワードを受け取り DBへ問い合わせを行います。
 *
 *
 * ＠author internous
 *
 * @param loginUserId
 * @param loginPassword
 *
 * @return result
 */

public class LoginAction extends ActionSupport implements SessionAware {

	/**
	 * ログインID
	 */
	private String loginUserId;

	/**
	 * ログインパスワード
	 */

	private String loginPassword;
	/**
	 * 処理結果を格納
	 */

	private String result;

	/**
	 * ログイン情報を格納
	 */

	public Map<String, Object> session;

	/**
	 * ログイン情報DAO
	 */

	private LoginDAO loginDAO = new LoginDAO();

	/**
	 * ログイン情報格納DAO
	 *
	 */

	private LoginDTO loginDTO = new LoginDTO();

	/**
	 * アイテム情報を取得
	 *
	 */

	private BuyItemDAO buyItemDAO = new BuyItemDAO();



	public List<BuyItemDTO> buyItemDTOList = new ArrayList<BuyItemDTO>();

	/**
	 * 実行メソッド
	 */
	public String execute() {

		result = ERROR;

		// ログイン実行
		loginDTO = loginDAO.getLoginUserInfo(loginUserId, loginPassword);

		session.put("loginUser", loginDTO);

		// ログイン情報を比較
		if (((LoginDTO) session.get("loginUser")).getLoginFlg()) {
			result = SUCCESS;

			// アイテム情報を取得

			buyItemDTOList = buyItemDAO.getBuyItemInfo();


			session.put("login_user_id", loginDTO.getLoginId());
			session.put("id", buyItemDTOList.get(0).getId());
			session.put("buyItem_name", buyItemDTOList.get(0).getItemName());
			session.put("buyItem_price", buyItemDTOList.get(0).getItemPrice());
			session.put("buyItem_stock", buyItemDTOList.get(0).getItemStock());

			return result;
		}
		return result;

	}

	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}