<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<meta charset="UTF-8">
<title>メール詳細</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
<h2 style="text-align: center;">メール詳細</h2>
<br>
	<form class="form-horizontal">
			<fieldset>
			<div class="form-group">
				<label for="SENDER" class="col-sm-3 control-label">送信者</label>
				<div class="col-sm-6">
					<!-- senderName mailオブジェクトとは別にsenderに対応する名前を取得しておく -->
					<input type="text" name="sender" class="form-control" id="SENDER" value="${mailViewList.get(status.index).sendername}(ID:${fn:escapeXml(mail.sender)})" readonly>
				</div>
			</div>
						<div class="form-group">
				<label for="TIME" class="col-sm-3 control-label">受信日時</label>
				<div class="col-sm-6">
					<input type="text" name="daytime" class="form-control" id="TIME" value="${fn:escapeXml(mail.daytime)}" readonly>
				</div>
			</div>
			<div class="form-group">
				<label for="SUBJECT" class="col-sm-3 control-label">件名</label>
				<div class="col-sm-6">
					<input type="text" name="subject" class="form-control" id="SUBJECT" value="${fn:escapeXml(mail.subject)}" readonly>
				</div>
			</div>
			<div class="form-group">
				<label for="TEXT" class="col-sm-3 control-label"></label>
				<div class="col-sm-6">
						<textarea name="text" rows="10" class="form-control" id="TEXT"
						placeholder="本文" readonly='readonly'>${fn:escapeXml(mail.message)}</textarea>
				</div>
			</div>
			</fieldset>
			<br>
			<div class="col-sm-offset-3 col-sm-9">
<c:choose>
			<c:when test="${backDoor == 'mailBox'}">
				<input type="submit" class="btn btn-info" name="button" value="戻る"
				onclick="location.href='mail'; return false;">
			</c:when>
			<c:when test="${backDoor == 'allMailDisplay'}">
				<input type="submit" class="btn btn-info" name="button" value="戻る"
				onclick="location.href='allMailDisplay'; return false;">
			</c:when>
		</c:choose>
		</div>

	</form>
	<br>
	<br>
	<br>
	<div class="col-sm-offset-1 col-sm-11">
		<a href="back" class="btn btn-default">Menu</a>
	</div>
</body>
</html>