<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>団体・教員情報登録</title>
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
		return false; // 登録を中止

	}
	else{

		window.alert('登録しました');
		return true; // 登録を実行

	}

}
// -->
</script>
</head>
<body>
<h2 style="text-align: center;">団体・教員情報登録</h2>

		<form class="form-hrizonatal" method="POST" action="accountInsert" name="form1" onSubmit="return check()">
		<div class="col-sm-offset-1 col-sm-10">
		<table class="table">
		<caption>団体・教員情報登録</caption>
			<thead>
				<tr>
					<th>ID</th>
					<th>名前</th>
					<th>かな</th>
					<th>属性</th>
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
					<td>
						<select name="property" class="form-control">
						<option value='3'>団体</option>
						<option value='4'>教員</option>
						</select>
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
					<td>
						<select name="property" class="form-control">
						<option value='3'>団体</option>
						<option value='4'>教員</option>
						</select>
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
					<td>
						<select name="property" class="form-control">
						<option value='3'>団体</option>
						<option value='4'>教員</option>
						</select>
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
					<td>
						<select name="property" class="form-control">
						<option value='3'>団体</option>
						<option value='4'>教員</option>
						</select>
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
					<td>
						<select name="property" class="form-control">
						<option value='3'>団体</option>
						<option value='4'>教員</option>
						</select>
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
					<td>
						<select name="property" class="form-control">
						<option value='3'>団体</option>
						<option value='4'>教員</option>
						</select>
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
					<td>
						<select name="property" class="form-control">
						<option value='3'>団体</option>
						<option value='4'>教員</option>
						</select>
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
					<td>
						<select name="property" class="form-control">
						<option value='3'>団体</option>
						<option value='4'>教員</option>
						</select>
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
					<td>
						<select name="property" class="form-control">
						<option value='3'>団体</option>
						<option value='4'>教員</option>
						</select>
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
					<td>
						<select name="property" class="form-control">
						<option value='3'>団体</option>
						<option value='4'>教員</option>
						</select>
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
				<div class="col-sm-12" style="text-align: center;">
<input type="submit" class="btn btn-danger"value="登録">
	</div>
	</form>

	<div class="col-sm-offset-1 col-sm-11">
		<br>
			<br>
		<a href="menu.jsp" class="btn btn-default">Menu</a>
	</div>
</body>
</html>