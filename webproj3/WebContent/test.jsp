<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TEST</title>
</head>
<body>
	<br>
	<h1>以下の新規ユーザーが登録されました。</h1>
	<s:property value="username" />
	<br>
	<s:property value="password" />
</body>
</html>