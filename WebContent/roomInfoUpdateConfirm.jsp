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
										width : "345px",
										height: "230px",
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
	<h2 style="text-align: center;">教室情報更新確認</h2>

	<br>
	<form class="form-horizontal" action="roomInfoUpdateResult"
		method="POST" enctype="multipart/form-data" name="form1"
		onSubmit="return check()">
		<fieldset class="col-md-5 control-label">
			<legend>変更前</legend>
			<div class="form-group">
				<label for="NAME" class="col-sm-2 control-label">名前</label>
				<div class="col-sm-8">
					<input type="text" name="name" class="form-control" id="NAME"
						value="${rooms.room}" readonly>
				</div>
			</div>
			<div class="form-group">
				<label for="IMAGE" class="col-sm-2 control-label">画像</label>
				<div class="col-sm-8">
					<img src="image/${rooms.image_path}"
						style="width: 345px; height: 230px;"><br> <br> <br>
				</div>
			</div>
			<div class="form-group">
				<label for="SCALE" class="col-sm-2 control-label">規模</label>
				<div class="col-sm-7">
					<input type="text" name="scale" class="form-control" id="SCALE"
						value="${rooms.size}" readonly>
				</div>
				<div class="col-sm-1">
					<b>人</b>
				</div>
			</div>
			<c:set var="facility">${rooms.facility}</c:set>
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
						readonly>${rooms.remarks}</textarea>
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
					<input type="text" name="newName" class="form-control" id="NAME">
				</div>
			</div>
			<div class="form-group">
				<label for="IMAGE" class="col-sm-2 control-label">画像</label>
				<div class="col-sm-8">
					<div class="preview"></div>
					<br> <input type="file" name="file" id="IMAGE" />
				</div>
			</div>
			<div class="form-group">
				<label for="SCALE" class="col-sm-2 control-label">規模</label>
				<div class="col-sm-7">
					<input type="number" name="newSize" class="form-control" id="SCALE">
				</div>
				<div class="col-sm-1">
					<b>人</b>
				</div>
			</div>
			<div class="form-group">
				<label for="FIXTURES" class="col-sm-2 control-label">備品</label>
				<div class="col-sm-4">
					<input type="text" name="newFix" class="form-control" id="FIXTURES">
				</div>
				<div class="col-sm-4">
					<input type="text" name="newFix" class="form-control" id="FIXTURES">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-4">
					<input type="text" name="newFix" class="form-control" id="FIXTURES">
				</div>
				<div class="col-sm-4">
					<input type="text" name="newFix" class="form-control" id="FIXTURES">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-4">
					<input type="text" name="newFix" class="form-control" id="FIXTURES">
				</div>
				<div class="col-sm-4">
					<input type="text" name="newFix" class="form-control" id="FIXTURES">
				</div>
			</div>
			<div class="form-group">
				<label for="REMARKS" class="col-sm-2 control-label">備考</label>
				<div class="col-sm-8">
					<textarea name="newRemarks" rows="4" class="form-control"
						id="REMARKS"></textarea>
				</div>
			</div>
		</fieldset>
		<br>
		<div class="form-group">
			<div class="col-sm-offset-5 col-sm-7">
				<div class="checkbox">
					<label> <input type="checkbox" name="check1" value="ok">
						この内容でよろしいですか？
					</label>
				</div>
			</div>
		</div>

		<div class="col-sm-offset-5 col-sm-1">
			<input type="submit" class="btn btn-info" name="button" value="戻る"
				onclick="location.href='roomInfoLump; return false;">
		</div>
		<div class="col-sm-6">
			<input type="submit" class="btn btn-danger" value="更新"
				onclick="myEnter()">
		</div>
	</form>

	<div class="col-sm-offset-1 col-sm-11">
		<br> <br> <a href="back" class="btn btn-default">Menu</a>
	</div>
</body>
</html>