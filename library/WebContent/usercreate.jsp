<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>user登録</title>
</head>
<body>
	<s:if test="errormessage !=''">
		<s:property value="errormessage" escape="false" />
	</s:if>

	<s:form action="UsercreateConfirmAction">
		<span>USERNAME</span>
		<s:textfield name="Username" />

		<s:submit value="確認">
		</s:submit>
	</s:form>
	<s:form action="UserAction">
		<s:submit value="戻る">
		</s:submit>
	</s:form>
</body>
</html>