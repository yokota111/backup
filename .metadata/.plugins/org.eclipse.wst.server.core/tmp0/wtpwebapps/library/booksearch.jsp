<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>書物検索</title>
</head>
<body>
	<s:form action="BooksearchresultAction">

		<s:submit value="検索">
		</s:submit>
	</s:form>

	<s:form action="BookpageAction">
		<s:submit value="戻る">
		</s:submit>
	</s:form>
</body>
</html>