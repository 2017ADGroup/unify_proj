<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>教室情報更新・削除</title>
<!-- BootstrapのCSS読み込み -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery読み込み -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- BootstrapのJS読み込み -->
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript"><!--
function myEnter(){
alert("削除しました。");
}
function check(){

	var flag = 0;

	// 設定開始（チェックする項目を設定してください）

	if(!document.form1.check1.checked){

		flag = 1;

	}

	// 設定終了


	if(flag){

		window.alert('チェックされていません'); // チェックされていない場合は警告ダイアログを表示
		return false; // 確認を中止

	}
	else{

		window.alert('削除しました');
		return true; // 確認を実行

	}

}
// --></script>
</head>
<body>
<h2 style="text-align: center;">教室情報更新・削除</h2>
<form class="form-hrizonatal" method="POST" action="roomInfoLump.html" name="form1" onSubmit="return check()">

	<div class="col-sm-offset-1 col-sm-10">
		<table class="table">
		<caption>教室情報更新・削除</caption>
			<thead>
				<tr>
					<th>名前</th>
					<th>画像</th>
					<th>規模</th>
					<th>備品</th>
					<th>削除</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
					<tr>
						<td>A教室</td>
						<td><img src="image/bRoom.jpg" class="img-rounded" style="width: 210px; height: 140px;"></td>
						<td><input name="ninnzuu" type="number" value="100" disabled='disabled' /></td>
						<td>
						<button type="button" class="btn btn-default" disabled='disabled'>プロジェクター</button>
								<button type="button" class="btn btn-default" disabled='disabled'>スピーカー</button><br>
							<button type="button" class="btn btn-default" disabled='disabled'>スクリーン</button></td>
						<td><input type="checkbox" name="lumpDel" ></td>
						<td><a href='roomInfoUpdate' class="btn btn-danger">更新</a></td>
					</tr>
										<tr>
						<td>B教室</td>
						<td><img src="image/bRoom.jpg" class="img-rounded" style="width: 210px; height: 140px;"></td>
						<td><input name="ninnzuu" type="number" value="100" disabled='disabled' /></td>
						<td>
						<button type="button" class="btn btn-default" disabled='disabled'>プロジェクター</button>
								<button type="button" class="btn btn-default" disabled='disabled'>スピーカー</button><br>
							<button type="button" class="btn btn-default" disabled='disabled'>スクリーン</button></td>
						<td ><input type="checkbox"
							name="lumpDel" ></td>
						<td><a href='roomInfoUpdate' class="btn btn-danger">更新</a></td>
					</tr>
										<tr>
						<td>C教室</td>
						<td><img src="image/bRoom.jpg" class="img-rounded" style="width: 210px; height: 140px;"></td>
						<td><input name="ninnzuu" type="number" value="100" disabled='disabled' /></td>
						<td>
						<button type="button" class="btn btn-default" disabled='disabled'>プロジェクター</button>
								<button type="button" class="btn btn-default" disabled='disabled'>スピーカー</button><br>
							<button type="button" class="btn btn-default" disabled='disabled'>スクリーン</button></td>
						<td ><input type="checkbox"
							name="lumpDel" ></td>
						<td><a href='roomInfoUpdate' class="btn btn-danger">更新</a></td>
					</tr>
										<tr>
						<td>D教室</td>
						<td><img src="image/bRoom.jpg" class="img-rounded" style="width: 210px; height: 140px;"></td>
						<td><input name="ninnzuu" type="number" value="100" disabled='disabled' /></td>
						<td>
						<button type="button" class="btn btn-default" disabled='disabled'>プロジェクター</button>
								<button type="button" class="btn btn-default" disabled='disabled'>スピーカー</button><br>
							<button type="button" class="btn btn-default" disabled='disabled'>スクリーン</button></td>
						<td ><input type="checkbox"
							name="lumpDel" ></td>
						<td><a href='roomInfoUpdate' class="btn btn-danger">更新</a></td>
					</tr>
										<tr>
						<td>E教室</td>
						<td><img src="image/bRoom.jpg" class="img-rounded" style="width: 210px; height: 140px;"></td>
						<td><input name="ninnzuu" type="number" value="100" disabled='disabled' /></td>
						<td>
						<button type="button" class="btn btn-default" disabled='disabled'>プロジェクター</button>
								<button type="button" class="btn btn-default" disabled='disabled'>スピーカー</button><br>
							<button type="button" class="btn btn-default" disabled='disabled'>スクリーン</button></td>
						<td ><input type="checkbox"
							name="lumpDel" ></td>
						<td><a href='roomInfoUpdate' class="btn btn-danger">更新</a></td>
					</tr>
										<tr>
						<td>F教室</td>
						<td><img src="image/bRoom.jpg" class="img-rounded" style="width: 210px; height: 140px;"></td>
						<td><input name="ninnzuu" type="number" value="100" disabled='disabled' /></td>
						<td>
						<button type="button" class="btn btn-default" disabled='disabled'>プロジェクター</button>
								<button type="button" class="btn btn-default" disabled='disabled'>スピーカー</button><br>
							<button type="button" class="btn btn-default" disabled='disabled'>スクリーン</button></td>
						<td ><input type="checkbox"
							name="lumpDel" ></td>
						<td><a href='roomInfoUpdate' class="btn btn-danger">更新</a></td>
					</tr>
										<tr>
						<td>G教室</td>
						<td><img src="image/bRoom.jpg" class="img-rounded" style="width: 210px; height: 140px;"></td>
						<td><input name="ninnzuu" type="number" value="100" disabled='disabled' /></td>
						<td>
						<button type="button" class="btn btn-default" disabled='disabled'>プロジェクター</button>
								<button type="button" class="btn btn-default" disabled='disabled'>スピーカー</button><br>
							<button type="button" class="btn btn-default" disabled='disabled'>スクリーン</button></td>
						<td><input type="checkbox"
							name="lumpDel" ></td>
						<td><a href='roomInfoUpdate' class="btn btn-danger">更新</a></td>
					</tr>
			</tbody>
		</table>
		</div>



					    <div class="col-sm-12" style="text-align:center;">

			<div class="btn-group" role="group">
				<a class="btn btn-default" href="roomInfoLump.html?page=1">1</a>
				<a class="btn btn-default" href="roomInfoLump.html?page=2">2</a>
			</div>

		<br>
		</div>

 <div class="form-group">
      <div class="col-sm-offset-5 col-sm-7">
		 <div class="checkbox">
    		<label>
      			<input type="checkbox" name="check1" value="ok"> この内容でよろしいですか？
    		</label>
  		</div>
  	</div>
  </div>
  <br>
	<div class="col-sm-12" style="text-align: center;">
		<input type="submit" class="btn btn-danger"value="削除">
	</div>

	<div class="col-sm-offset-1 col-sm-11">
		<br>
	<br>
		<a href="menu.html" class="btn btn-default">Menu</a>
	</div>

</form>
</body>
</html>