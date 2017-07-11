<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>教室情報更新</title>
<!-- BootstrapのCSS読み込み -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery読み込み -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- BootstrapのJS読み込み -->
<script src="js/bootstrap.min.js"></script>

</head>
<body>
	<h2 style="text-align: center;">教室情報更新</h2>
	<br>
	<form class="form-horizontal" action="roomInfoUpdateConfirm.html">
		<fieldset>
			<div class="form-group">
				<label for="NAME" class="col-sm-3 control-label">名前</label>
				<div class="col-sm-6">
					<input type="text" name="name" class="form-control" id="NAME"
						placeholder="名前" value="A教室">
				</div>
			</div>
			<div class="form-group">
				<label for="IMAGE" class="col-sm-3 control-label">画像</label>
				<div class="col-sm-3">
					<img src="image/bRoom.jpg" class="img-rounded"
						style="width: 300px; height: 200px;">
				</div>
				<div class="col-sm-3">
					<input type="file" name="file" id="IMAGE"
						style="position: relative; top: 175px;" />
				</div>
			</div>
			<div class="form-group">
				<label for="SCALE" class="col-sm-3 control-label">規模</label>
				<div class="col-sm-6">
					<input type="number" name="scale" class="form-control" id="SCALE"
						placeholder="人数" value="100">
				</div>
			</div>
			<div class="form-group">
				<label for="FIXTURES" class="col-sm-3 control-label">備品</label>
				<div class="col-sm-3">
					<input type="text" name="pass" class="form-control" id="FIXTURES"
						placeholder="備品" value="スピーカー">
				</div>
				<div class="col-sm-3">
					<input type="text" name="pass" class="form-control" id="FIXTURES"
						placeholder="備品" value="プロジェクター">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-3 col-sm-3">
					<input type="text" name="pass" class="form-control" id="FIXTURES"
						placeholder="備品">
				</div>
				<div class="col-sm-3">
					<input type="text" name="pass" class="form-control" id="FIXTURES"
						placeholder="備品">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-3 col-sm-3">
					<input type="text" name="pass" class="form-control" id="FIXTURES"
						placeholder="備品">
				</div>
				<div class="col-sm-3">
					<input type="text" name="pass" class="form-control" id="FIXTURES"
						placeholder="備品">
				</div>
			</div>

			<div class="form-group">
				<label for="REMARKS" class="col-sm-3 control-label">備考</label>
				<div class="col-sm-6">
					<textarea name="remarks" rows="4" class="form-control" id="REMARKS"
						placeholder="その他何かあれば書いてください"></textarea>
				</div>
			</div>
		</fieldset>
		<div class="col-sm-offset-5 col-sm-1">
			<input type="submit" class="btn btn-info" name="button" value="戻る"
				onclick="location.href='roomInfoLump.html'; return false;">
		</div>
		<div class="col-sm-6">

			<input type="submit" class="btn btn-primary" value="確認">
		</div>
	</form>
	<br>
	<br>
	<br>
	<div class="col-sm-offset-1 col-sm-11">
		<a href="menu.html" class="btn btn-default">Menu</a>
	</div>
</body>
</html>