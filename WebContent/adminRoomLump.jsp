<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予約内容一括更新・削除</title>
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
		return false; // 実行を中止

	}
	else{

		window.alert('実行しました');
		return true; // 実行を実行

	}

}
// -->
</script>
</head>
<body>
<h2 style="text-align: center;">予約内容一括更新・削除</h2>
	<fieldset>
		<table class="table">
			<caption>予約内容一括更新・削除</caption>
			<thead>
				<tr>
					<th class="col-sm-1">月日</th>
					<th class="col-sm-1">予約者ログインID</th>
					<th class="col-sm-1">教室名/<br>使用時間</th>
					<th class="col-sm-1">使用目的/<br>使用人数</th>
					<th class="col-sm-4">備品</th>
					<th class="col-sm-3">備考</th>
					<th class="col-sm-1">削除</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>
						<input type='date' name='date' value='2017-07-07' disabled='disabled'>
					</td>
					<td>
						<input type="text" name="login_id" value='o003' disabled='disabled'>
					</td>
					<td>
						<p>
						<select disabled='disabled'>
							<option selected='selected'>A教室</option>
							<option>B教室</option>
							<option>C教室</option>
							<option>D教室</option>
							<option>E教室</option>
							<option>F教室</option>
						</select>
						</p>
						<select disabled='disabled'>
							<option>1限目</option>
							<option>2限目</option>
							<option>3限目</option>
							<option>4限目</option>
							<option>5限目</option>
							<option>6限目</option>
							<option selected='selected'>7限目以降</option>
						</select>
					</td>
					<td>
						<p>
						<select>
							<option>講義</option>
							<option selected='selected'>課外活動</option>
							<option>備品整備</option>
							<option>その他(備考欄記述)</option>
						</select>
						</p>
						<input name="ninnzuu" type="number" value="50">
					</td>
					<td>
								<input type="text" name="fixtures" value='プロジェクター'>
								<input type="text" name="fixtures" value='スピーカー'>
								<input type="text" name="fixtures" value='マイク'>
								<input type="text" name="fixtures">
								<input type="text" name="fixtures">
								<input type="text" name="fixtures">
					</td>
					<td><textarea name="bikou" rows="5" cols="32">部活動のため一部机を移動します。</textarea></td>
					<td><input name="reserveDelete" type="checkbox" value="1"/><input type="hidden" name="delete" value="on"/></td>
				</tr>
				<tr>
					<td>
						<input type='date' name='date' value='2017-07-08' disabled='disabled'>
					</td>
					<td>
						<input type="text" name="login_id" value='00e0003' disabled='disabled'>
					</td>
					<td>
						<p>
						<select disabled='disabled'>
							<option>A教室</option>
							<option>B教室</option>
							<option selected='selected'>C教室</option>
							<option>D教室</option>
							<option>E教室</option>
							<option>F教室</option>
						</select>
						</p>
						<select disabled='disabled'>
							<option>1限目</option>
							<option>2限目</option>
							<option selected='selected'>3限目</option>
							<option>4限目</option>
							<option>5限目</option>
							<option>6限目</option>
							<option>7限目以降</option>
						</select>
					</td>
					<td>
						<p>
						<select>
							<option selected='selected'>講義</option>
							<option>課外活動</option>
							<option>備品整備</option>
							<option>その他(備考欄記述)</option>
						</select>
						</p>
						<input name="ninnzuu" type="number" value="75">
					</td>
					<td>

								<input type="text" name="fixtures" value='プロジェクター'>
								<input type="text" name="fixtures" value='スピーカー'>
								<input type="text" name="fixtures">
								<input type="text" name="fixtures">
								<input type="text" name="fixtures">
								<input type="text" name="fixtures">

					</td>
					<td><textarea name="bikou" rows="5" cols="32">受講者の人数により、備品の追加申請の可能性有</textarea></td>
					<td><input name="reserveDelete" type="checkbox" value="1"/><input type="hidden" name="delete" value="on"/></td>
				</tr>
				<tr>
					<td>
						<input type='date' name='date' value='2017-07-08' disabled='disabled'>
					</td>
					<td>
						<input type="text" name="login_id" value='00h0023' disabled='disabled'>
					</td>
					<td>
						<p>
						<select disabled='disabled'>
							<option>A教室</option>
							<option>B教室</option>
							<option>C教室</option>
							<option>D教室</option>
							<option selected='selected'>E教室</option>
							<option>F教室</option>
						</select>
						</p>
						<select disabled='disabled'>
							<option>1限目</option>
							<option>2限目</option>
							<option selected='selected'>3限目</option>
							<option>4限目</option>
							<option>5限目</option>
							<option>6限目</option>
							<option>7限目以降</option>
						</select>
					</td>
					<td>
						<p>
						<select>
							<option selected='selected'>講義</option>
							<option>課外活動</option>
							<option>備品整備</option>
							<option>その他(備考欄記述)</option>
						</select>
						</p>
						<input name="ninnzuu" type="number" value="100">
					</td>
					<td>
								<input type="text" name="fixtures" value='プロジェクター'>
								<input type="text" name="fixtures" value='スピーカー'>
								<input type="text" name="fixtures">
								<input type="text" name="fixtures">
								<input type="text" name="fixtures">
								<input type="text" name="fixtures">
					</td>
					<td><textarea name="bikou" rows="5" cols="32"></textarea></td>
					<td><input name="reserveDelete" type="checkbox" value="1"/><input type="hidden" name="delete" value="on"/></td>
				</tr>
				</tbody>
			</table>
		</fieldset>

					    <div class="col-sm-12" style="text-align:center;">

			<div class="btn-group" role="group">
				<a class="btn btn-default" href="adminRoomLump.html?page=1">1</a>
				<a class="btn btn-default" href="adminRoomLump.html?page=2">2</a>
			</div>

		<br>
		</div>

	<form class="form-hrizonatal" method="POST" action="adminRoomLump.html" name="form1" onSubmit="return check()">
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
			<input type="submit" class="btn btn-danger"value="実行">
		</div>
	</form>
	<div class="col-sm-offset-1 col-sm-11">
	<br>
	<br>
		<a href="menu.html" class="btn btn-default">Menu</a>
	</div>
</body>
</html>