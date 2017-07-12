<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>教室情報登録確認</title>
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
		alert("登録しました");
	}
// -->
</script>
</head>
<body>
	<h2 style="text-align: center;">教室情報登録確認</h2>

	<br>
	<form class="form-horizontal" action="roomInfoLump">

		<fieldset>
			<div class="form-group">
				<label for="NAME" class="col-sm-4 control-label">名前</label>
				<div class="col-sm-4">
					<input type="text" name="room" class="form-control" id="NAME"
						value='F教室' readonly="readonly">
				</div>
			</div>
			<div class="form-group">
				<label for="IMAGE" class="col-sm-4 control-label">画像</label>
				<div class="col-sm-4">
					<img src="image/bRoom.jpg" class="img-rounded"
						style="width: 429px; height: 286px;">
				</div>
			</div>
			<div class="form-group">
				<label for="SCALE" class="col-sm-4 control-label">規模</label>
				<div class="col-sm-4">
					<input type="text" name="size" class="form-control" id="SCALE"
						value="200" readonly="readonly">
				</div>
			</div>
			<div class="form-group">
				<label for="FIXTURES" class="col-sm-4 control-label">備品</label>
				<div class="col-sm-2">
					<input type="text" name="facility" class="form-control" id="FIXTURES"
						value="プロジェクター" readonly="readonly">
				</div>
				<div class="col-sm-2">
					<input type="text" name="facility" class="form-control" id="FIXTURES"
						value="スクリーン" readonly="readonly">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-2">
					<input type="text" name="facility" class="form-control" id="FIXTURES"
						value="スピーカー" readonly="readonly">
				</div>
				<div class="col-sm-2">
					<input type="text" name="facility" class="form-control" id="FIXTURES"
						value="マイク" readonly="readonly">
				</div>
			</div>

			<div class="form-group">
				<label for="REMARKS" class="col-sm-4 control-label">備考</label>
				<div class="col-sm-4">
					<textarea name="remarks" rows="4" class="form-control" id="REMARKS"
						readonly="readonly">左最奥のディスプレイが使用不可</textarea>
				</div>
			</div>
		</fieldset>
		<br>
		<div class="col-sm-offset-5 col-sm-1">
			<input type="submit" class="btn btn-info" name="button" value="戻る"
				onclick="location.href='roominfoInsert.jsp'; return false;">
		</div>
		<div class="col-sm-6">
			<input type="submit" class="btn btn-danger" value="登録"
				onclick="myEnter()">
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