<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
	function check() {

		var flag = 0;

		// 設定開始（チェックする項目を設定してください）

		if (!document.form1.check1.checked) {

			flag = 1;

		}

		// 設定終了

		if (flag) {

			window.alert('チェックされていません'); // チェックされていない場合は警告ダイアログを表示
			return false; // 更新を中止

		} else {

			window.alert('予約しました');
			return true; // 予約を実行

		}

	}
// -->
</script>
</head>
<body>
	<h2 style="text-align: center;">教室一括予約</h2>
	<form id="reserveUpdateForm" action="adminRoomInsert" method="POST"
		name="form1" onSubmit="return check()">
		<fieldset>
			<table class="table">
				<caption>予約一覧</caption>
				<thead>
					<tr>
						<th>月日</th>
						<th>予約者ログインID</th>
						<th>教室名/<br>使用時間
						</th>
						<th>使用目的/<br>使用人数
						</th>
						<th>備品</th>
						<th>備考</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input class="form-control" type="date" name="date1"
							min="2017-07-01" max="2017-08-31"></td>
						<td><input class="form-control" type="text" name="loginId1">
						</td>
						<td>
							<p>
								<select class="form-control" name="room1">
									<option></option>
									<option value="A101教室">A101教室</option>
									<option value="A203教室">A203教室</option>
									<option value="B102教室">B102教室</option>
									<option value="B202教室">B202教室</option>
									<option value="C204教室">C204教室</option>
									<option value="C303教室">C303教室</option>
									<option value="D103教室">D103教室</option>
									<option value="D401教室">D401教室</option>
								</select>
							</p> <select class="form-control" name="period1">
								<option></option>
								<option value="1">1限目</option>
								<option value="2">2限目</option>
								<option value="3">3限目</option>
								<option value="4">4限目</option>
								<option value="5">5限目</option>
								<option value="6">6限目</option>
								<option value="7">7限目以降</option>
						</select>
						</td>
						<td>
							<p>
								<select class="form-control" name="purpose1">
									<option></option>
									<option value="1">講義</option>
									<option value="2">課外活動</option>
									<option value="3">備品整備</option>
									<option value="4">その他(備考欄記述)</option>
								</select>
							</p> <input class="form-control" name="number1" type="number">
						</td>

						<td><input type="text" name="fixtures1"><br>
							<input type="text" name="fixtures1"><br>
							<input type="text" name="fixtures1"><br>
							<input type="text" name="fixtures1"><br>
							<input type="text" name="fixtures1"><br>
							<input type="text" name="fixtures1"></td>

						<td><textarea class="form-control" name="remarks1" rows="5"
								cols="32"></textarea></td>

					</tr>
					<tr>
						<td><input class="form-control" type="date" name="date2"
							min="2017-07-01" max="2017-08-31"></td>
						<td><input class="form-control" type="text" name="loginId2">
						</td>
						<td>
							<p>
								<select class="form-control" name="room2">
									<option></option>
									<option value="A101教室">A101教室</option>
									<option value="A203教室">A203教室</option>
									<option value="B102教室">B102教室</option>
									<option value="B202教室">B202教室</option>
									<option value="C204教室">C204教室</option>
									<option value="C303教室">C303教室</option>
									<option value="D103教室">D103教室</option>
									<option value="D401教室">D401教室</option>
								</select>
							</p> <select class="form-control" name="period2">
								<option></option>
								<option value="1">1限目</option>
								<option value="2">2限目</option>
								<option value="3">3限目</option>
								<option value="4">4限目</option>
								<option value="5">5限目</option>
								<option value="6">6限目</option>
								<option value="7">7限目以降</option>
						</select>
						</td>
						<td>
							<p>
								<select class="form-control" name="purpose2">
									<option></option>
									<option value="1">講義</option>
									<option value="2">課外活動</option>
									<option value="3">備品整備</option>
									<option value="4">その他(備考欄記述)</option>
								</select>
							</p> <input class="form-control" name="number2" type="number">
						</td>
						<td><input type="text" name="fixtures2"><br>
							<input type="text" name="fixtures2"><br>
							<input type="text" name="fixtures2"><br>
							<input type="text" name="fixtures2"><br>
							<input type="text" name="fixtures2"><br>
							<input type="text" name="fixtures2"></td>
						<td><textarea class="form-control" name="fixtures2" rows="5"
								cols="32"></textarea></td>

					</tr>
					<tr>
						<td><input class="form-control" type="date" name="date3"
							min="2017-07-01" max="2017-08-31"></td>
						<td><input class="form-control" type="text" name="loginId3">
						</td>
						<td>
							<p>
								<select class="form-control" name="room3">
									<option></option>
									<option value="A101教室">A101教室</option>
									<option value="A203教室">A203教室</option>
									<option value="B102教室">B102教室</option>
									<option value="B202教室">B202教室</option>
									<option value="C204教室">C204教室</option>
									<option value="C303教室">C303教室</option>
									<option value="D103教室">D103教室</option>
									<option value="D401教室">D401教室</option>
								</select>
							</p> <select class="form-control" name="period3">
								<option></option>
								<option value="1">1限目</option>
								<option value="2">2限目</option>
								<option value="3">3限目</option>
								<option value="4">4限目</option>
								<option value="5">5限目</option>
								<option value="6">6限目</option>
								<option value="7">7限目以降</option>
						</select>
						</td>
						<td>
							<p>
								<select class="form-control" name="purpose3">
									<option></option>
									<option value="1">講義</option>
									<option value="2">課外活動</option>
									<option value="3">備品整備</option>
									<option value="4">その他(備考欄記述)</option>
								</select>
							</p> <input class="form-control" name="number3" type="number">
						</td>
						<td><input type="text" name="fixtures3"><br>
							<input type="text" name="fixtures3"><br>
							<input type="text" name="fixtures3"><br>
							<input type="text" name="fixtures3"><br>
							<input type="text" name="fixtures3"><br>
							<input type="text" name="fixtures3"></td>
						<td><textarea class="form-control" name="fixtures3" rows="5"
								cols="32"></textarea></td>

					</tr>
					<tr>
						<td><input class="form-control" type="date" name="date4"
							min="2017-07-01" max="2017-08-31"></td>
						<td><input class="form-control" type="text" name="loginId4">
						</td>
						<td>
							<p>
								<select class="form-control" name="room4">
									<option></option>
									<option value="A101教室">A101教室</option>
									<option value="A203教室">A203教室</option>
									<option value="B102教室">B102教室</option>
									<option value="B202教室">B202教室</option>
									<option value="C204教室">C204教室</option>
									<option value="C303教室">C303教室</option>
									<option value="D103教室">D103教室</option>
									<option value="D401教室">D401教室</option>
								</select>
							</p> <select class="form-control" name="period4">
									<option></option>
								<option value="1">1限目</option>
								<option value="2">2限目</option>
								<option value="3">3限目</option>
								<option value="4">4限目</option>
								<option value="5">5限目</option>
								<option value="6">6限目</option>
								<option value="7">7限目以降</option>
						</select>
						</td>
						<td>
							<p>
								<select class="form-control" name="purpose4">
									<option></option>
									<option value="1">講義</option>
									<option value="2">課外活動</option>
									<option value="3">備品整備</option>
									<option value="4">その他(備考欄記述)</option>
								</select>
							</p> <input class="form-control" name="number4" type="number">
						</td>
						<td><input type="text" name="fixtures4"><br>
							<input type="text" name="fixtures4"><br>
							<input type="text" name="fixtures4"><br>
							<input type="text" name="fixtures4"><br>
							<input type="text" name="fixtures4"><br>
							<input type="text" name="fixtures4"></td>
						<td><textarea class="form-control" name="fixtures4" rows="5"
								cols="32"></textarea></td>

					</tr>
					<tr>
						<td><input class="form-control" type="date" name="date5"
							min="2017-07-01" max="2017-08-31"></td>
						<td><input class="form-control" type="text" name="loginId5">
						</td>
						<td>
							<p>
								<select class="form-control" name="room5">
									<option></option>
									<option value="A101教室">A101教室</option>
									<option value="A203教室">A203教室</option>
									<option value="B102教室">B102教室</option>
									<option value="B202教室">B202教室</option>
									<option value="C204教室">C204教室</option>
									<option value="C303教室">C303教室</option>
									<option value="D103教室">D103教室</option>
									<option value="D401教室">D401教室</option>
								</select>
							</p> <select class="form-control" name="period5">
								<option></option>
								<option value="1">1限目</option>
								<option value="2">2限目</option>
								<option value="3">3限目</option>
								<option value="4">4限目</option>
								<option value="5">5限目</option>
								<option value="6">6限目</option>
								<option value="7">7限目以降</option>
						</select>
						</td>
						<td>
							<p>
								<select class="form-control" name="purpose5">
									<option></option>
									<option value="1">講義</option>
									<option value="2">課外活動</option>
									<option value="3">備品整備</option>
									<option value="4">その他(備考欄記述)</option>
								</select>
							</p> <input class="form-control" name="number5" type="number">
						</td>
						<td><input type="text" name="fixtures5"><br>
							<input type="text" name="fixtures5"><br>
							<input type="text" name="fixtures5"><br>
							<input type="text" name="fixtures5"><br>
							<input type="text" name="fixtures5"><br>
							<input type="text" name="fixtures5"></td>
						<td><textarea class="form-control" name="fixtures5" rows="5"
								cols="32"></textarea></td>

					</tr>
				</tbody>
			</table>
		</fieldset>
		<div class="form-group">
			<div class="col-sm-offset-5 col-sm-7">
				<div class="checkbox">
					<label> <input type="checkbox" name="check1" value="ok">
						この内容でよろしいですか？
					</label>
				</div>
			</div>
		</div>
		<div class="col-sm-12" style="text-align: center;">
			<input type="submit" class="btn btn-primary" value="予約">
		</div>

	</form>
	<div class="col-sm-offset-1 col-sm-11">
		<br> <br> <a href="menu.jsp" class="btn btn-default">Menu</a>
	</div>
	<br>
	<br>
	<br>
</body>
</html>