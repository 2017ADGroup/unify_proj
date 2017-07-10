<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メール新規作成</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript"><!--
function myEnter(){
alert("送信しました");
}
// --></script>
</head>
<body>
<h2 style="text-align: center;">メール新規作成</h2>
<br>
	<form class="form-horizontal" action="mailCreate">
		<fieldset>
              <div class="form-group">
                <label for="SELECT" class="col-sm-3 control-label">宛先</label>
                <div class="col-sm-6">
                	<select class="form-control" id="SELECT" name="receiver">
						<c:forEach var="users" items="${userList}">
						<!-- 全ユーザーを取得し、kanaで並び替えたものをuserListとして使用 -->
						<option value="${fn:escapeXml(users.login_id)}">${fn:escapeXml(users.name)}(ID:${fn:escapeXml(users.login_id)})</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="SUBJECT" class="col-sm-3 control-label">件名</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="SUBJECT" placeholder="件名" name="subject">
				</div>
			</div>
			<div class="form-group">
				<label for="TEXT" class="col-sm-3 control-label">本文</label>
				<div class="col-sm-6">
						<textarea rows="10" class="form-control" id="TEXT"
						placeholder="本文" name="message"></textarea>
				</div>
			</div>
			</fieldset>
			<br>
<div class="col-sm-offset-3 col-sm-9">
		<input type="submit" class="btn btn-success" value="送信" onclick="myEnter()">
		</div>
	</form>

	<div class="col-sm-offset-1 col-sm-11">
		<br>
	<br>
	<br>
		<a href="back" class="btn btn-default">Menu</a>
	</div>
</body>
</html>