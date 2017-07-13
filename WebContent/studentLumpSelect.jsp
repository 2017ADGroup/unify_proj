<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>生徒情報削除</title>
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
			return false; // 削除を中止

		} else {

			window.alert('削除しました');
			return true; // 削除

		}

	}
// -->
</script>
</head>
<body>
	<h2 style="text-align: center;">生徒情報削除</h2>
	<form class="form-hrizonatal" method="POST"
		action="studentLumpSelect" name="form1" onSubmit="return check()">
		<div class="col-sm-offset-1 col-sm-10">

			<table class="table">
				<caption>生徒情報削除</caption>
				<thead>
					<tr>

						<th>ID</th>
						<th>名前</th>
						<th>かな</th>
						<th>削除</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach var="student" items="${studentList}" varStatus="status">
						<tr>
							<td><input type="text" name="id" class="form-control"
								value="${student.login_id}" readonly="readonly"></td>
							<td><input type="text" name="name" class="form-control"
								value="${student.name}" readonly="readonly"></td>
							<td><input type="text" name="kana" class="form-control"
								value="${student.kana}" readonly="readonly"></td>
							<td><input type="checkbox" name="studentDelete"></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<div class="col-sm-12" style="text-align: center;">


			<br>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-5 col-sm-7">
				<div class="checkbox">
					<label> <input type="checkbox" name="check1" value="ok">
						この内容でよろしいですか？
					</label>
				</div>
			</div>
		</div>
		<br>
		<div class="col-sm-12" style="text-align: center;">
			<input type="submit" class="btn btn-danger" value="削除">
		</div>
			</form>
		<br> <br> <br>
		<div class="col-sm-offset-1 col-sm-11">
			<a href="back" class="btn btn-default">Menu</a>
		</div>
</body>
</html>