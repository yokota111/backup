<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>メニュー</title>
</head>
<body>
	<s:form action="BooksearchAction">
		<s:submit value="書物検索">
		</s:submit>
	</s:form>

	<s:form action="BookaddplaceAction">
		<s:submit value="書物登録">
		</s:submit>
	</s:form>
	<s:form action="BookdeleteAction">
		<s:submit value="書物削除">
		</s:submit>
	</s:form>
	<s:form action="MainpagebackAction">
		<s:submit value="戻る">
		</s:submit>
	</s:form>

</body>
</html>