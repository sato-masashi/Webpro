<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="./css/style.css">
		<title>LoginError</title>
	</head>
<body>
	<h1>エラーが発生しました</h1>
	<br>
	<h3>ログインできません</h3>

	<s:if test='(#session.loginDTOList.get(0).username)=="該当なし"'>
	該当者はいませんでした。
	</s:if>

	<br>
	<table>
		<tbody>
			<tr>
				<th>USERNAME</th>
				<th>PASSWORD</th>
			</tr>

			<s:iterator value="#session.loginDTOList"/>

			<tr>
				<td><s:property value="username"/></td>
				<td><s:property value="password"/></td>
			</tr>
		</tbody>
	</table>


</body>
</html>