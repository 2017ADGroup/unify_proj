<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者情報登録</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
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

		window.alert('登録しました');
		return true; // 更新を実行

	}

}
// -->
</script>
</head>
<body>
<form class="form-hrizonatal" method="POST" action="adminInsert" name="form1" onSubmit="return check()">
<h2 style="text-align: center;">管理者情報登録</h2>
		<div class="col-sm-offset-1 col-sm-10">
		<table class="table">
		<caption>管理者情報登録</caption>
			<thead>
				<tr>
					<th>ID</th>
					<th>名前</th>
					<th>かな</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>
						<input type="text" name="id" class="form-control">
					</td>
					<td>
						<input type="text" name="name" class="form-control">
					</td>
					<td>
						<input type="text" name="kana" class="form-control" pattern="[ー\u3041-\u3096]*">
					</td>
				</tr>
				<tr>
					<td>
						<input type="text" name="id" class="form-control">
					</td>
					<td>
						<input type="text" name="name" class="form-control">
					</td>
					<td>
						<input type="text" name="kana" class="form-control" pattern="[ー\u3041-\u3096]*">
					</td>
				</tr>
				<tr>
					<td>
						<input type="text" name="id" class="form-control">
					</td>
					<td>
						<input type="text" name="name" class="form-control">
					</td>
					<td>
						<input type="text" name="kana" class="form-control" pattern="[ー\u3041-\u3096]*">
					</td>
				</tr>
				<tr>
					<td>
						<input type="text" name="id" class="form-control">
					</td>
					<td>
						<input type="text" name="name" class="form-control">
					</td>
					<td>
						<input type="text" name="kana" class="form-control" pattern="[ー\u3041-\u3096]*">
					</td>
				</tr>
				<tr>
					<td>
						<input type="text" name="id" class="form-control">
					</td>
					<td>
						<input type="text" name="name" class="form-control">
					</td>
					<td>
						<input type="text" name="kana" class="form-control" pattern="[ー\u3041-\u3096]*">
					</td>
				</tr>
				<tr>
					<td>
						<input type="text" name="id" class="form-control">
					</td>
					<td>
						<input type="text" name="name" class="form-control">
					</td>
					<td>
						<input type="text" name="kana" class="form-control" pattern="[ー\u3041-\u3096]*">
					</td>
				</tr>
				<tr>
					<td>
						<input type="text" name="id" class="form-control">
					</td>
					<td>
						<input type="text" name="name" class="form-control">
					</td>
					<td>
						<input type="text" name="kana" class="form-control" pattern="[ー\u3041-\u3096]*">
					</td>
				</tr>
				<tr>
					<td>
						<input type="text" name="id" class="form-control">
					</td>
					<td>
						<input type="text" name="name" class="form-control">
					</td>
					<td>
						<input type="text" name="kana" class="form-control" pattern="[ー\u3041-\u3096]*">
					</td>
				</tr>
				<tr>
					<td>
						<input type="text" name="id" class="form-control">
					</td>
					<td>
						<input type="text" name="name" class="form-control">
					</td>
					<td>
						<input type="text" name="kana" class="form-control" pattern="[ー\u3041-\u3096]*">
					</td>
				</tr>
				<tr>
					<td>
						<input type="text" name="id" class="form-control">
					</td>
					<td>
						<input type="text" name="name" class="form-control">
					</td>
					<td>
						<input type="text" name="kana" class="form-control" pattern="[ー\u3041-\u3096]*">
					</td>
				</tr>
			</tbody>
			</table>
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
<div class="col-sm-offset-5 col-sm-1">
<input type="submit" class="btn btn-info" name="button" value="戻る"
				onclick="location.href='updateInput.jsp'; return false;">

</div>
<div class="col-sm-6">
<input type="submit" class="btn btn-danger"value="登録">
</div>
	<br>
	<br>
	<br>
	<div class="col-sm-offset-1 col-sm-11">
		<br>
	<br>
		<a href="back" class="btn btn-default">Menu</a>
	</div>
</form>
</body>
</html>