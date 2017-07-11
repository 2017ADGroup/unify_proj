<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>教室情報更新確認</title>
<!-- BootstrapのCSS読み込み -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery読み込み -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- BootstrapのJS読み込み -->
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
<!--
	function myEnter() {
		alert("更新しました");
	}
// -->
</script>
</head>
<body>
	<h2 style="text-align: center;">教室情報更新確認</h2>

	<br>
	<form class="form-horizontal" action="roomInfoUpdateResult" method="POST">
		<fieldset class="col-md-5 control-label">
			<legend>変更前</legend>
			<div class="form-group">
				<label for="NAME" class="col-sm-2 control-label">名前</label>
				<div class="col-sm-8">
					<input type="text" name="name" class="form-control" id="NAME"
						value="${room.room}" readonly>
				</div>
			</div>
			<div class="form-group">
				<label for="IMAGE" class="col-sm-2 control-label">画像</label>
				<div class="col-sm-8">
					<img src="image/aRoom.jpg" class="img-rounded"
						style="width: 345px; height: 230px;">
				</div>
			</div>
			<div class="form-group">
				<label for="SCALE" class="col-sm-2 control-label">規模</label>
				<div class="col-sm-7">
					<input type="text" name="scale" class="form-control" id="SCALE"
						value="${room.size}" readonly>
				</div>
				<div class="col-sm-1">
					<b>人</b>
				</div>
			</div>
			<c:set var="facility">${room.facility}</c:set>
			<%
				String facility = (String) pageContext.getAttribute("facility");
				String[] facilities = facility.split(",");
				for (int i = 0; i < facilities.length; i++) {
					pageContext.setAttribute("f" + i, facilities[i]);
				}
			%>
			<div class="form-group">
				<label for="FIXTURES" class="col-sm-2 control-label">備品</label>
				<div class="col-sm-4">
					<input type="text" name="pass" class="form-control" id="FIXTURES"
						value="${f0}" readonly>
				</div>
				<div class="col-sm-4">
					<input type="text" name="pass" class="form-control" id="FIXTURES"
						value="${f1}" readonly>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-4">
					<input type="text" name="pass" class="form-control" id="FIXTURES"
						value="${f2}" readonly>
				</div>
				<div class="col-sm-4">
					<input type="text" name="pass" class="form-control" id="FIXTURES"
						value="${f3}" readonly>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-4">
					<input type="text" name="pass" class="form-control" id="FIXTURES"
						value="${f4}" readonly>
				</div>
				<div class="col-sm-4">
					<input type="text" name="pass" class="form-control" id="FIXTURES"
						value="${f5}" readonly>
				</div>
			</div>

			<div class="form-group">
				<label for="REMARKS" class="col-sm-2 control-label">備考</label>
				<div class="col-sm-8">
					<textarea name="remarks" rows="4" class="form-control" id="REMARKS"
						readonly>${room.remarks}</textarea>
				</div>
			</div>
		</fieldset>

		<div class="col-md-2">
			<div
				style="height: 700px; display: flex; justify-content: center; align-items: center;">
				<span class="glyphicon glyphicon-circle-arrow-right"
					style="font-size: 64px;"></span>
			</div>
		</div>

		<fieldset class="col-md-5 control-label">
			<legend>変更後</legend>
			<div class="form-group">
				<label for="NAME" class="col-sm-2 control-label">名前</label>
				<div class="col-sm-8">
					<input type="text" name="name" class="form-control" id="NAME"
						value="${name}" readonly>
				</div>
			</div>
			<div class="form-group">
				<label for="IMAGE" class="col-sm-2 control-label">画像</label>
				<div class="col-sm-8">
					<img src="image/bRoom.jpg" class="img-rounded"
						style="width: 345px; height: 230px;">
				</div>
			</div>
			<div class="form-group">
				<label for="SCALE" class="col-sm-2 control-label">規模</label>
				<div class="col-sm-7">
					<input type="text" name="scale" class="form-control" id="SCALE"
						value="${scale}" readonly>
				</div>
				<div class="col-sm-1">
					<b>人</b>
				</div>
			</div>
			<c:set var="fix">${fix}</c:set>
			<%
				String fixture = (String) pageContext.getAttribute("fix");
				String[] fixtures = fixture.split(",");
				for (int i = 0; i < fixtures.length; i++) {
					pageContext.setAttribute("ff" + i, fixtures[i]);
				}
			%>
			<div class="form-group">
				<label for="FIXTURES" class="col-sm-2 control-label">備品</label>
				<div class="col-sm-4">
					<input type="text" name="pass" class="form-control" id="FIXTURES"
						value="${ff0}" readonly>
				</div>
				<div class="col-sm-4">
					<input type="text" name="pass" class="form-control" id="FIXTURES"
						value="${ff1}" readonly>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-4">
					<input type="text" name="pass" class="form-control" id="FIXTURES"
						value="${ff2}" readonly>
				</div>
				<div class="col-sm-4">
					<input type="text" name="pass" class="form-control" id="FIXTURES"
						value="${ff3}" readonly>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-4">
					<input type="text" name="pass" class="form-control" id="FIXTURES"
						value="${ff4}" readonly>
				</div>
				<div class="col-sm-4">
					<input type="text" name="pass" class="form-control" id="FIXTURES"
						value="${ff5}" readonly>
				</div>
			</div>
			<div class="form-group">
				<label for="REMARKS" class="col-sm-2 control-label">備考</label>
				<div class="col-sm-8">
					<textarea name="remarks" rows="4" class="form-control" id="REMARKS"
						readonly>${remarks}</textarea>
				</div>
			</div>
		</fieldset>
		<br>

		<div class="col-sm-offset-5 col-sm-1">
			<input type="submit" class="btn btn-info" name="button" value="戻る"
				onclick="location.href='roomInfoUpdate.html'; return false;">
		</div>
		<div class="col-sm-6">
			<input type="submit" class="btn btn-danger" value="更新"
				onclick="myEnter()">
		</div>
	</form>

	<div class="col-sm-offset-1 col-sm-11">
		<br> <br> <a href="menu.html" class="btn btn-default">Menu</a>
	</div>
</body>
</html>