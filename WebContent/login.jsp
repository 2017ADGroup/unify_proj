<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
<!-- BootstrapのCSS読み込み -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery読み込み -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- BootstrapのJS読み込み -->
<script src="js/bootstrap.min.js"></script>
</head>
<body
	style="background-image: url(image/book.jpg); background-size: cover;">
<header style="background-color: #28d; height:60px;">
<h1><font color="white">東京大学</font></h1><br>
</header>
	<div class="login">
		<div class="login-triangle"></div>

		<h2 class="login-header">UniFy</h2>

		<form class="login-container" action="login" method="POST">
			<p>
				<input type="text" placeholder="ID" name="id"
					value="${fn:escapeXml(param.id)}">
			</p>
			<p>
				<input type="password" placeholder="Password" name="pass"
					value="${fn:escapeXml(param.pass)}">
			</p>
			<p>
				<input type="submit" value="Login">
			</p>
		</form>
	</div>
</body>
</html>