<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="style.css">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<meta charset="UTF-8">
	<title>メニュー</title>
	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
<!-- BootstrapのCSS読み込み -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery読み込み -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- BootstrapのJS読み込み -->
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript"><!--
function myEnter(){
alert("ログアウトします");
}
// --></script>
</head>
<body>
<%-- <c:choose> --%>
<%-- 			<c:when test="${login_user.authority == 1}"> --%>

		<br>
	<br>
	<p>
		<a href="adminInsert.jsp" class="btn btn-success btn-lg btn-block" style="width: 40%; margin: auto;">管理者情報登録</a>
	</p>
	<br>
	<p>
		<a href="AdminLumpServlet" class="btn btn-warning btn-lg btn-block" style="width: 40%; margin: auto;">管理者情報削除</a>
	</p>
<%-- 	</c:when> --%>
<%-- <c:otherwise> --%>
<%-- 				<c:redirect url="login.jsp" /> --%>
<%-- 			</c:otherwise> --%>
<%-- 	</c:choose> --%>
	<br>
	<br>
	<br>
	<div class="col-sm-offset-1 col-sm-11">
	<form action="login.jsp" method="post">
		<input type="submit" value="ログアウト" class="btn btn-default" onclick="myEnter()">
	</form>
	</div>
	<br>
	<br>
	<br>
	<br>

</body>
</html>