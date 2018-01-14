<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品詳細</title>
</head>
<body>

	<p>
		<s:iterator value="#session.itemdetailDTOList">
			<s:form action="CartAction">
				<tr>
					<td><s:property value="product_name" /></td>
					<td><s:property value="product_name_kana" /></td>
					<td><img src=<s:property value="image_file_path"/> width=auto
						height="200"></td>
					<td><s:property value="price" />円</td>
					<td><select name="count">
							<option value="1" selected="selected">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
					</select></td>
					<td><s:property value="release_company" /></td>
					<td><s:property value="release_date" /></td>
					<td><s:property value="product_description" /></td>
					<td><input type="hidden" name="product_id"
						value="<s:property value='product_id' />"></input></td>
					<td><input type="hidden" name="category_id"
						value="<s:property value='category_id' />"></input></td>
					<td><s:hidden name="addFlg" value="1"></s:hidden></td>
					<td><input type="submit" value="カートに入れる"
						onClick="alert('カートにいれました！');">
					<td>
				</tr>
			</s:form>
		</s:iterator>
	</p>

	<p>
		<s:iterator value="#session.itemdetailDTOList">
			<s:form action="ReviewAction">
				<tr>
					<td><input type="hidden" name="product_id"
						value="<s:property value='product_id' />"></input></td>
					<td><input type="hidden" name="category_id"
						value="<s:property value='category_id' />"></input></td>
					<td><input type="submit" value="レビューを書く"
						<s:if test="%{#session.loginUser !=''}">
					onClick="alert('ログインしてください！');"</s:if>>
				</tr>
			</s:form>
		</s:iterator>


		<s:iterator value="#session.reviewDTO2List">

			<tr>
				<td><s:property value="user_id" /></td>
				<td><s:property value="update_date" /></td>
				<td><s:property value="value" /></td>
				<td><s:property value="review" /></td>
			</tr>
			<br>

		</s:iterator>
	</p>
	<p>
		関連商品
		<s:iterator value="#session.itemrelativeDTOList" begin="0" end="2">
			<s:form action="ItemDetailAction">
				<tr>
					<td><s:property value="product_name" />
					<td><input type="hidden" name="product_id"
						value="<s:property value='product_id' />"></input></td>
					<td><input type="hidden" name="category_id"
						value="<s:property value='category_id' />"></input></td>
					<td><input type="image"
						src="<s:property value="image_file_path"/>" width=auto
						height="100" /></td>
				</tr>
			</s:form>
		</s:iterator>
	</p>
	<s:a href="ItemAction">商品一覧へ</s:a>
</body>
</html>