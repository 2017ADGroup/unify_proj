<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>教室一括予約</title>
<!-- BootstrapのCSS読み込み -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery読み込み -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- BootstrapのJS読み込み -->
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
<!--
function check(){

	var flag = 0;

	// 設定開始（チェックする項目を設定してください）

	if(!document.form1.check1.checked){

		flag = 1;

	}

	// 設定終了


	if(flag){

		window.alert('チェックされていません'); // チェックされていない場合は警告ダイアログを表示
		return false; // 更新を中止

	}
	else{

		window.alert('予約しました');
		return true; // 予約を実行

	}

}
// -->
</script>
</head>
<body>
<h2 style="text-align: center;">教室一括予約</h2>
<form id="reserveUpdateForm" action="menu.html" method="POST" name="form1" onSubmit="return check()">
	<fieldset>
		<table class="table">
			<caption>予約一覧</caption>
			<thead>
				<tr>
					<th>月日</th>
					<th>予約者ログインID</th>
					<th>教室名/<br>使用時間</th>
					<th>使用目的/<br>使用人数</th>
					<th>備品</th>
					<th>備考</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>
						<input class="form-control" type="date" name="date" max="2017-08-31" min="2017-07-01">
					</td>
					<td>
						<input class="form-control" type="text" name="login_id">
					</td>
					<td>
						<p>
						<select class="form-control">
							<option>A教室</option>
							<option>B教室</option>
							<option>C教室</option>
							<option>D教室</option>
							<option>E教室</option>
							<option>F教室</option>
						</select>
						</p>
						<select class="form-control">
							<option>1限目</option>
							<option>2限目</option>
							<option>3限目</option>
							<option>4限目</option>
							<option>5限目</option>
							<option>6限目</option>
							<option>7限目以降</option>
						</select>
					</td>
					<td>
						<p><select class="form-control">
							<option>講義</option>
							<option>課外活動</option>
							<option>備品整備</option>
							<option>その他(備考欄記述)</option>
						</select>
						</p>
						<input class="form-control" name="ninnzuu" type="number">
					</td>
					<td><input type="checkbox" name="riyu" value="1">プロジェクター<br>
							<input type="checkbox" name="riyu" value="2">スピーカー<br>
							<input type="checkbox" name="riyu" value="3">マイク</td>
					<td><textarea class="form-control" name="bikou" rows="5" cols="32"></textarea></td>

				</tr>
								<tr>
					<td>
						<input class="form-control" type="date" name="date" max="2017-08-31" min="2017-07-01">
					</td>
					<td>
						<input class="form-control" type="text" name="login_id">
					</td>
					<td>
						<p>
						<select class="form-control">
							<option>A教室</option>
							<option>B教室</option>
							<option>C教室</option>
							<option>D教室</option>
							<option>E教室</option>
							<option>F教室</option>
						</select>
						</p>
						<select class="form-control">
							<option>1限目</option>
							<option>2限目</option>
							<option>3限目</option>
							<option>4限目</option>
							<option>5限目</option>
							<option>6限目</option>
							<option>7限目以降</option>
						</select>
					</td>
					<td>
						<p><select class="form-control">
							<option>講義</option>
							<option>課外活動</option>
							<option>備品整備</option>
							<option>その他(備考欄記述)</option>
						</select>
						</p>
						<input class="form-control" name="ninnzuu" type="number">
					</td>
					<td><input type="checkbox" name="riyu" value="1">プロジェクター<br>
							<input type="checkbox" name="riyu" value="2">スピーカー<br>
							<input type="checkbox" name="riyu" value="3">マイク</td>
					<td><textarea class="form-control" name="bikou" rows="5" cols="32"></textarea></td>

				</tr>
								<tr>
					<td>
						<input class="form-control" type="date" name="date" max="2017-08-31" min="2017-07-01">
					</td>
					<td>
						<input class="form-control" type="text" name="login_id">
					</td>
					<td>
						<p>
						<select class="form-control">
							<option>A教室</option>
							<option>B教室</option>
							<option>C教室</option>
							<option>D教室</option>
							<option>E教室</option>
							<option>F教室</option>
						</select>
						</p>
						<select class="form-control">
							<option>1限目</option>
							<option>2限目</option>
							<option>3限目</option>
							<option>4限目</option>
							<option>5限目</option>
							<option>6限目</option>
							<option>7限目以降</option>
						</select>
					</td>
					<td>
						<p><select class="form-control">
							<option>講義</option>
							<option>課外活動</option>
							<option>備品整備</option>
							<option>その他(備考欄記述)</option>
						</select>
						</p>
						<input class="form-control" name="ninnzuu" type="number">
					</td>
					<td><input type="checkbox" name="riyu" value="1">プロジェクター<br>
							<input type="checkbox" name="riyu" value="2">スピーカー</td>
					<td><textarea class="form-control" name="bikou" rows="5" cols="32"></textarea></td>

				</tr>
								<tr>
					<td>
						<input class="form-control" type="date" name="date" max="2017-08-31" min="2017-07-01">
					</td>
					<td>
						<input class="form-control" type="text" name="login_id">
					</td>
					<td>
						<p>
						<select class="form-control">
							<option>A教室</option>
							<option>B教室</option>
							<option>C教室</option>
							<option>D教室</option>
							<option>E教室</option>
							<option>F教室</option>
						</select>
						</p>
						<select class="form-control">
							<option>1限目</option>
							<option>2限目</option>
							<option>3限目</option>
							<option>4限目</option>
							<option>5限目</option>
							<option>6限目</option>
							<option>7限目以降</option>
						</select>
					</td>
					<td>
						<p><select class="form-control">
							<option>講義</option>
							<option>課外活動</option>
							<option>備品整備</option>
							<option>その他(備考欄記述)</option>
						</select>
						</p>
						<input class="form-control" name="ninnzuu" type="number">
					</td>
					<td><input type="checkbox" name="riyu" value="1">プロジェクター<br>
							<input type="checkbox" name="riyu" value="2">スピーカー<br>
							<input type="checkbox" name="riyu" value="3">マイク</td>
					<td><textarea class="form-control" name="bikou" rows="5" cols="32"></textarea></td>

				</tr>
								<tr>
					<td>
						<input class="form-control" type="date" name="date" max="2017-08-31" min="2017-07-01">
					</td>
					<td>
						<input class="form-control" type="text" name="login_id">
					</td>
					<td>
						<p>
						<select class="form-control">
							<option>A教室</option>
							<option>B教室</option>
							<option>C教室</option>
							<option>D教室</option>
							<option>E教室</option>
							<option>F教室</option>
						</select>
						</p>
						<select class="form-control">
							<option>1限目</option>
							<option>2限目</option>
							<option>3限目</option>
							<option>4限目</option>
							<option>5限目</option>
							<option>6限目</option>
							<option>7限目以降</option>
						</select>
					</td>
					<td>
						<p><select class="form-control">
							<option>講義</option>
							<option>課外活動</option>
							<option>備品整備</option>
							<option>その他(備考欄記述)</option>
						</select>
						</p>
						<input class="form-control" name="ninnzuu" type="number">
					</td>
					<td><input type="checkbox" name="riyu" value="1">プロジェクター<br>
							<input type="checkbox" name="riyu" value="2">スピーカー<br>
							<input type="checkbox" name="riyu" value="3">マイク</td>
					<td><textarea class="form-control" name="bikou" rows="5" cols="32"></textarea></td>

				</tr>
								<tr>
					<td>
						<input class="form-control" type="date" name="date" max="2017-08-31" min="2017-07-01">
					</td>
					<td>
						<input class="form-control" type="text" name="login_id">
					</td>
					<td>
						<p>
						<select class="form-control">
							<option>A教室</option>
							<option>B教室</option>
							<option>C教室</option>
							<option>D教室</option>
							<option>E教室</option>
							<option>F教室</option>
						</select>
						</p>
						<select class="form-control">
							<option>1限目</option>
							<option>2限目</option>
							<option>3限目</option>
							<option>4限目</option>
							<option>5限目</option>
							<option>6限目</option>
							<option>7限目以降</option>
						</select>
					</td>
					<td>
						<p><select class="form-control">
							<option>講義</option>
							<option>課外活動</option>
							<option>備品整備</option>
							<option>その他(備考欄記述)</option>
						</select>
						</p>
						<input class="form-control" name="ninnzuu" type="number">
					</td>
					<td><input type="checkbox" name="riyu" value="1">プロジェクター<br>
							<input type="checkbox" name="riyu" value="2">スピーカー<br>
							<input type="checkbox" name="riyu" value="3">マイク</td>
					<td><textarea class="form-control" name="bikou" rows="5" cols="32"></textarea></td>

				</tr>
				</tbody>
			</table>
		</fieldset>
		<div class="form-group">
     <div class="col-sm-offset-5 col-sm-7">
			  <div class="checkbox">
    		<label>
      			<input type="checkbox" name="check1" value="ok"> この内容でよろしいですか？
    		</label>
  	</div>
  	     </div>
  </div>
		<div class="col-sm-12" style="text-align: center;">
			<input type="submit" class="btn btn-primary" value="予約">
		</div>

	</form>
	<div class="col-sm-offset-1 col-sm-11">
		<br>
	<br>
		<a href="menu.html" class="btn btn-default">Menu</a>
	</div>
		<br>
	<br>
	<br>
</body>
</html>