<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="./css/style.css">
		<title>TEST</title>
	</head>
<body>
	<br>
	<h1>以下の新規ユーザーが登録されました。</h1>

	<br>
	<table>
		<tbody>
			<tr>
				<th>USERNAME</th>
				<th>PASSWORD</th>
			</tr>
			<s:iterator value="loginDTOList">
				<tr>
					<td><s:property value="username" /></td>
					<td><s:property value="password" /></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</body>
</html>