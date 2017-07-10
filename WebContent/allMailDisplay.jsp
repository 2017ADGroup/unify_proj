<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<meta charset="UTF-8">
<title>全メール閲覧</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>

	<h2 style="text-align: center;">全メール閲覧</h2>
	<br>

	<form class="form-inline">
		<div class="col-sm-offset-1 col-sm-11">
			<div class="form-group">
				<label for="NAME">名前</label> <input type="text" name="name"
					class="form-control" id="NAME" placeholder="名前">
			</div>

			<div class="form-group">
				<label for="ID">ID</label> <input type="text" name="id"
					class="form-control" id="ID" placeholder="ID">
			</div>

			<div class="form-group">
				<label for="KEYWORD">キーワード</label> <input type="text" name="keyword"
					class="form-control" id="KEYWORD" placeholder="キーワード">
			</div>
			<div class="form-group">
				<label for="TIME">日時</label> <input type="date" name="time"
					class="form-control" id="TIME">
			</div>
			<input type="submit" class="btn btn-danger" value="検索">
		</div>

		<div class="col-sm-offset-4 col-sm-8">

			<div class="form-group">
				<div class="checkbox">
					<label> <input type="checkbox" name="checkbox" value="to"><b>To</b>
					</label>
				</div>
			</div>
			<div class="form-group">
				<div class="checkbox">
					<label> <input type="checkbox" name="checkbox" value="from"><b>From</b>
					</label>
				</div>
			</div>
		</div>
	</form>

	<br>
	<div class="col-sm-offset-1 col-sm-10">
		<table class="table">
			<caption>メール一覧</caption>
			<thead>
				<tr>
					<th>To</th>
					<th>FROM</th>
					<th>件名</th>
					<th>日時</th>
				</tr>
			</thead>
			<tbody>
				<%
					request.getAttribute("mailList");
					request.getAttribute("mailViewList");
					int count = 0;
				%>
				<c:forEach var="mail" items="${mailList}" varStatus="status">
					<tr>
						<td>${mailViewList.get(status.index).sendername}(ID:${mail.sender})</td>
						<td>${mailViewList.get(status.index).receivername}(ID:${mail.receiver})</td>
						<td><a href="MailDetail?mail_id=${mail.mail_id}">${mail.subject}</a></td>
						<td>${mail.daytime}</td>
						<%
						count++;
						%>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<div class="col-sm-12" style="text-align: center;">
		<br>
		<form action="AllMailDisplay" method="get">

			<div class="btn-group" role="group">
				<button type="submit" class="btn btn-default" name="page" value="1">1</button>
				<button type="submit" class="btn btn-default" name="page" value="2">2</button>
			</div>

		</form>
	</div>

	<div class="col-sm-offset-1 col-sm-11">
		<br> <br> <br> <a href="menu.jsp"
			class="btn btn-default">Menu</a>
	</div>
</body>
</html>