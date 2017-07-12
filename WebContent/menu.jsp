<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="style.css">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<meta charset="UTF-8">
	<title>メニュー</title>
	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
<script type="text/javascript"><!--
function myEnter(){
alert("ログアウトします");
}
// --></script>
<title>メニュー</title>
</head>
<body>
<h2 style="text-align: center;">マイページ</h2>
<br>
	<div class="col-sm-3">
		<!-- ログインしたユーザーの権限によって -->
		<c:choose>
			<c:when test="${login_user.property == 2}">
				<b>教室予約情報</b><br>
				・<a href="adminRoomInsert.jsp">教室一括予約</a><br>
				・<a href="adminRoom">予約内容一括更新・削除</a><br>
				<b>ミニメール</b><br>
				・<a href="mailCreate">メール新規作成</a><br>
				・<a href="mail">メールボックス</a><br>
				・<a href="allMailDisplay">全メール閲覧</a><br>
				<b>教室情報管理</b><br>
				・<a href="roomInfoInsert.jsp">教室情報登録</a><br>
				・<a href="roomInfoLump">教室情報更新・削除</a><br>
				<b>アカウント管理</b><br>
				・<a href="myInfoUpdate">アカウント情報更新</a><br>
				・<a href="accountInsert">団体・教員情報登録</a><br>
				・<a href="accountLump">団体・教員情報更新・削除</a><br>
				<br>
			</c:when>
			<c:when test="${login_user.property == 3}">
				<b>教室予約情報</b><br>
				・<a href="roomInsert.jsp">教室予約</a><br>
				・<a href="roomLump">予約内容更新・削除</a><br>
				<b>ミニメール</b><br>
				・<a href="mailCreate">メール新規作成</a><br>
				・<a href="mail">メールボックス</a><br>
				<b>アカウント管理</b><br>
				・<a href="myInfoUpdate">アカウント情報更新</a><br>
				・<a href="studentInsert">生徒情報登録</a><br>
				・<a href="studentLumpSelect">生徒情報削除</a><br>
				<br>
			</c:when>
			<c:when test="${login_user.property == 4}">
				<b>教室予約情報</b><br>
				・<a href="roomInsert.jsp">教室予約</a><br>
				・<a href="roomLump">予約内容更新・削除</a><br>
				<b>ミニメール</b><br>
				・<a href="mailCreate">メール新規作成</a><br>
				・<a href="mail">メールボックス</a><br>
				<b>アカウント管理</b><br>
				・<a href="myInfoUpdate">アカウント情報更新</a><br>
				<br>
			</c:when>
			<c:when test="${login_user.property == 5}">
				<b>ミニメール</b><br>
				・<a href="mail">メールボックス</a><br>
				<b>アカウント管理</b><br>
				・<a href="myInfoUpdate">アカウント情報更新</a><br>
				<br>
			</c:when>
			<c:otherwise>
				<c:redirect url="login.jsp" />
			</c:otherwise>
		</c:choose>
			<form action="logout" method="post">
		<input type="submit" class="btn btn-default" value="ログアウト" onclick="myEnter()">
		</form>
	</div>
		<div class="col-sm-offset-2 col-sm-6">

	<form class="form-inline" action="menu" method="get">
	<div class="form-group">
<select class="form-control" id="year" name="year">
<%
    int year = Integer.parseInt(request.getAttribute("year").toString());
    int month = Integer.parseInt(request.getAttribute("month").toString());
    for(int i = year; i <= year+10; i++){
%>
<option value="<%=i %>"
<%
        if(i == year){
%>
selected
<%
        }
%>
><%=i %>年</option>
<%
    }
%>
</select>
</div>
<div class="form-group">
<select class="form-control" id="moneth" name="month">
<%
    for(int i = 1; i <= 12; i++){
%>
<option value="<%=i %>"
<%
        if(i == month){
%>
selected
<%
        }
%>
><%=i %>月</option>
<%
    }
%>
</select>
</div>
<input  class="btn btn-danger" type="submit" id="ok" name="ok" value="変更"/>
</form>
<br>
</div>
	<div class="col-sm-8">
		<%= request.getAttribute("calender") %>
			</div>
<div class="col-sm-offset-3 col-sm-8">
	${requestScope.schedule}
	</div>
</body>
</html>