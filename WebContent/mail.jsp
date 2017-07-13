<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<meta charset="UTF-8">
<title>メールボックス</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>

	<h2 style="text-align: center;">メールボックス</h2>
	<div class="col-sm-offset-1 col-sm-10">
		<table class="table">
			<caption>メール一覧</caption>
			<thead>
				<tr>
					<th>To</th>
					<th>From</th>
					<th>件名</th>
					<th>日時</th>
				</tr>
			</thead>
			<tbody>
				<%
					request.getAttribute("mailList");
					request.getAttribute("mailViewList");
				%>
				<c:forEach var="mail" items="${mailList}" varStatus="status">
					<tr>
						<td>${mailViewList.get(status.index).sendername}(ID:${mail.sender})</td>
						<td>${mailViewList.get(status.index).receivername}(ID:${mail.receiver})</td>
						<td><a href="MailDetail?mail_id=${mail.mail_id}">${mail.subject}</a></td>
						<td>${mail.daytime}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="col-sm-12" style="text-align: center;">
		<br>
		<form action="Mail" method="get">
	</div>

	<div class="col-sm-offset-1 col-sm-11">
		<br> <br> <br> <a href="back" class="btn btn-default">Menu</a>
	</div>
</body>
</html>