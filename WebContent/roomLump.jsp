<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予約内容更新・削除</title>
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

			window.alert('削除しました');
			return true; // 更新を実行

		}

	}
// -->
</script>
</head>
<body>
	<h2 style="text-align: center;">予約内容更新・削除</h2>
	<form action="roomDelete" class="form-hrizonatal" method="POST"
		name="form1" onSubmit="return check()">
		<table class="table">
			<caption>予約内容更新・削除</caption>
			<thead>
				<tr>
					<th class="col-sm-1">月日</th>
					<th class="col-sm-1">予約者ログインID</th>
					<th class="col-sm-1">教室名/<br>使用時間
					</th>
					<th class="col-sm-1">使用目的/<br>使用人数
					</th>
					<th class="col-sm-4">備品</th>
					<th class="col-sm-3">備考</th>
					<th class="col-sm-1">予約<br>取消
					</th>
					<th class="col-sm-1"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="reserve" items="${reserveList}">
					<tr>
						<td><input type='date' name='date'
							value='${reserve.reserve_date}' disabled='disabled'></td>
						<td><input type="text" name="login_id"
							value='${reserve.reserve_host}' disabled='disabled'></td>
						<td>
							<p>
								<select disabled='disabled'>
									<option selected='selected'>${reserve.room}</option>
								</select>
							</p> <select disabled='disabled'>
								<option selected='selected'>${reserve.term}限目</option>
						</select>
						</td>
						<td>
							<p>
								<select disabled='disabled'>
									<option selected='selected'>${reserve.purpose}</option>
								</select>
							</p> <input name="ninnzuu" type="number" value="50"
							disabled="disabled">
						</td>
						<td><c:set var="facility">${reserve.facility}</c:set> <%
 	String facility = (String) pageContext.getAttribute("facility");
 		String[] facilities = facility.split(",");
 		for (String fa : facilities) {
 			pageContext.setAttribute("fa", fa);
 %>
							<button type="button" class="btn btn-default" disabled='disabled'>${fa}</button>
							<%
								}
							%></td>
						<td><textarea name="bikou" rows="5" cols="32"
								disabled="disabled">${reserve.remarks}</textarea></td>
						<td><input name="reserveDelete" type="checkbox"
							value="${reserve.reserve_id}" /></td>
						<td><a href='roomUpdate?reserveId="${reserve.reserve_id}"'
							class="btn btn-danger">更新</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="col-sm-12" style="text-align: center;">

			<div class="btn-group" role="group">
				<a class="btn btn-default" href="roomLump.html?page=1">1</a> <a
					class="btn btn-default" href="roomLump.html?page=2">2</a>
			</div>

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
		<div class="col-sm-12" style="text-align: center;">
			<input type="submit" class="btn btn-danger" value="削除">
		</div>
		<div class="col-sm-offset-1 col-sm-11">
			<br> <br> <a href="menu.html" class="btn btn-default">Menu</a>
		</div>
	</form>
</body>
</html>