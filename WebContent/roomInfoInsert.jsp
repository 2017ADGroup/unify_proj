<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>教室情報登録</title>
<!-- BootstrapのCSS読み込み -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery読み込み -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- BootstrapのJS読み込み -->
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
<!--
	function check() {

		var flag = 0;

		// 設定開始（チェックする項目を設定してください）

		if (!document.form1.check1.checked) {

			flag = 1;

		}

		// 設定終了

		if (flag) {

			window.alert('チェックされていません'); // チェックされていない場合は警告ダイアログを表示
			return false; // 実行を中止

		} else {

			window.alert('実行しました');
			return true; // 実行を実行

		}

	}
// -->
</script>
<script>
	$(function() {
		//画像ファイルプレビュー表示のイベント追加 fileを選択時に発火するイベントを登録
		$('form')
				.on(
						'change',
						'input[type="file"]',
						function(e) {
							var file = e.target.files[0], reader = new FileReader(), $preview = $(".preview");
							t = this;

							// 画像ファイル以外の場合は何もしない
							if (file.type.indexOf("image") < 0) {
								return false;
							}

							// ファイル読み込みが完了した際のイベント登録
							reader.onload = (function(file) {
								return function(e) {
									//既存のプレビューを削除
									$preview.empty();
									// .prevewの領域の中にロードした画像を表示するimageタグを追加
									$preview.append($('<img>').attr({
										src : e.target.result,
										width : "270px",
										class : "preview",
										title : file.name
									}));
								};
							})(file);

							reader.readAsDataURL(file);
						});
	});
</script>
</head>
<body>
	<h2 style="text-align: center;">教室情報登録</h2>
	<br>

	<div class="col-sm-offset-2 col-sm-10">
		<form class="form-horizontal" action="roomInfoInsert" method="POST"
			enctype="multipart/form-data" name="form1" onSubmit="return check()">
			<fieldset>
				<div class="form-group">
					<label for="NAME" class="col-sm-2 control-label">名前</label>
					<div class="col-sm-6">
						<input type="text" name="room" class="form-control" id="NAME"
							placeholder="名前" required='required'><font color="red">※必須</font>
					</div>
				</div>
				<div class="form-group">
					<label for="IMAGE" class="col-sm-2 control-label">画像</label>
					<div class="col-sm-6">
						<input type="file" name="file" id="IMAGE" />
					</div>
				</div>
				<div class="form-group">
					<label for="SCALE" class="col-sm-2 control-label">規模</label>
					<div class="col-sm-6">
						<input type="number" name="size" class="form-control" id="SCALE"
							required='required'>
					</div>
				</div>
				<div class="form-group">
					<label for="FIXTURES" class="col-sm-2 control-label">備品</label>
					<div class="col-sm-3">
						<input type="text" name="facility" class="form-control"
							id="FIXTURES" placeholder="備品">
					</div>
					<div class="col-sm-3">
						<input type="text" name="facility" class="form-control"
							id="FIXTURES" placeholder="備品">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-3">
						<input type="text" name="facility" class="form-control"
							id="FIXTURES" placeholder="備品">
					</div>
					<div class="col-sm-3">
						<input type="text" name="facility" class="form-control"
							id="FIXTURES" placeholder="備品">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-3">
						<input type="text" name="facility" class="form-control"
							id="FIXTURES" placeholder="備品">
					</div>
					<div class="col-sm-3">
						<input type="text" name="facility" class="form-control"
							id="FIXTURES" placeholder="備品">
					</div>
				</div>
				<div class="form-group">
					<label for="REMARKS" class="col-sm-2 control-label">備考</label>
					<div class="col-sm-6">
						<textarea name="remarks" rows="4" class="form-control"
							id="REMARKS" placeholder="その他何かあれば書いてください"></textarea>
					</div>
				</div>
			</fieldset>
			<div class="form-group">
				<div class="col-sm-offset-3 col-sm-9">
					<div class="checkbox">
						<label> <input type="checkbox" name="check1" value="ok">
							この内容でよろしいですか？
						</label>
					</div>
				</div>
			</div>
			<div class="col-sm-offset-4 col-sm-8">
				<button type="submit" class="btn btn-primary" value="確認">確認</button>
			</div>
		</form>
	</div>
	<div class="col-sm-offset-1 col-sm-11">
		<br> <br> <a href="back" class="btn btn-default">Menu</a>
	</div>
</body>
</html>