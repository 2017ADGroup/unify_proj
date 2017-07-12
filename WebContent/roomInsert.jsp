<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>教室予約</title>
<style type="text/css">
img {
	width: 210px;
	height: 140px;
	;
}
</style>
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
			return false; // 予約を中止

		} else {

			window.alert('予約しました');
			return true; // 登録を実行

		}

	}
// -->
</script>
</head>
<body>
	<h2 style="text-align: center;">教室予約</h2>
	<br>
	<form name="serch_form" class="form-horizontal" action="roomSerch"
		method="GET">

		<div class="form-group">
			<label for="roomName" class=" col-sm-4 control-label">教室名</label>
			<div class="col-sm-5">
				<input type="text" name="room" class="form-control" id="roomName"
					placeholder="教室名">
			</div>
		</div>

		<div class="form-group">
			<label for="SCALE" class="col-sm-4 control-label">規模</label>
			<div class="col-sm-2">
				<input type="number" name="sizeMin" class="form-control" id="SCALE"
					placeholder="人数">
			</div>
			<div class="col-sm-1">
				<p style="text-align: center;">
					<b>～</b>
				</p>
			</div>
			<div class="col-sm-2">
				<input type="number" name="sizeMax" class="form-control"
					id="FIXTURES" placeholder="人数">
			</div>
		</div>

		<div class="form-group">
			<label for="FIXTURES" class="col-sm-4 control-label">備品</label>
			<div class="col-sm-5">
				<input type="text" name="fixtures" class="form-control"
					id="FIXTURES" placeholder="備品">
			</div>
		</div>
		<div class="col-sm-offset-5 col-sm-7">
			<input type="submit" class="btn btn-info" value="検索"
				onclick="myEnter()">
		</div>
		<br> <br>
	</form>
	<c:if test="${not empty roomList}">
		<form class="form-horizontal" name="schedule_form" action="roomSerch"
			method="POST">
			<div class="col-sm-offset-1 col-sm-10">
				<table class="table">
					<caption>教室一覧</caption>
					<c:forEach var="rooms" items="${roomList}" varStatus="status">
						<tr>
							<td>${rooms.room}</td>
							<td><img src="image/aRoom.jpg"></td>
							<td>規模:${rooms.size}人<br>備品:<br>${rooms.facility}</td>
							<td><button type="submit" name="roomSelect"
									value="${rooms.room}">この教室を選択する</button></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="form-group">
				<label for="PUTRPOSE" class="col-sm-4 control-label">使用日</label>
				<div class="col-sm-2">
					<select class="form-control" id="PURPOSE" name="reserve_month">
						<option value="${thisMonth}">${thisMonth}</option>
						<!-- 今月の日時を取得してその月の1日から翌月末までを指定する -->
						<c:choose>
							<c:when test="${thisMonth != 12}">
								<option value="${thisMonth + 1}">${thisMonth + 1}</option>
							</c:when>
							<c:when test="${thisMonth == 12}">
								<option value="1">1</option>
							</c:when>
						</c:choose>
					</select>
				</div>
				<div class="col-sm-1">
					<b>月</b>
				</div>
				<div class="col-sm-2">
					<select class="form-control" id="PURPOSE" name="reserve_date">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
						<option value="13">13</option>
						<option value="14">14</option>
						<option value="15">15</option>
						<option value="16">16</option>
						<option value="17">17</option>
						<option value="18">18</option>
						<option value="19">19</option>
						<option value="20">20</option>
						<option value="21">21</option>
						<option value="22">22</option>
						<option value="23">23</option>
						<option value="24">24</option>
						<option value="25">25</option>
						<option value="26">26</option>
						<option value="27">27</option>
						<option value="28">28</option>
						<option value="29">29</option>
						<option value="30">30</option>
						<option value="31">31</option>
					</select>
				</div>
				<div class="col-sm-1">
					<b>日</b>
				</div>
			</div>
		</form>
	</c:if>
	<c:if test="${room != null}">
		<form class="form-horizontal" method="POST" action="roomInsert"
			name="reserve_form" onSubmit="return check()">
			<div class="col-sm-offset-1 col-sm-10">
				<table class="table">
					<caption>予約状況</caption>
					<tr>
						<th></th>
						<th>1限</th>
						<th>2限</th>
						<th>3限</th>
						<th>4限</th>
						<th>5限</th>
						<th>6限</th>
						<th>7限以降</th>
					</tr>
					<tr>${schedule}
					</tr>
				</table>
			</div>

			<div class="form-group">
				<label for="PUTRPOSE" class="col-sm-4 control-label">使用目的</label>
				<div class="col-sm-5">
					<select class="form-control" id="PURPOSE" name="purpose">
						<option value="1">講義</option>
						<option value="2">課外活動</option>
						<option value="3">備品整備</option>
						<option value="4">その他(備考欄記述)</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="NUMBER" class=" col-sm-4 control-label">使用人数</label>
				<div class="col-sm-5">
					<input type="number" name="amount" class="form-control" id="NUMBER"
						placeholder="使用人数" required='required'>
				</div>
			</div>
			<div class="form-group">
				<label for="FIXTURES" class=" col-sm-4 control-label">備品使用</label>
				<div class="col-sm-5">
					<div class="checkbox">
						<c:forEach var="facilities" items="${facility}">
							<!-- 直前のServletで予め配列として渡しておく -->
							<label> <input name="facilities" type="checkbox"
								id="FIXTURES" value="${fn:escapeXml(facilities)}">${fn:escapeXml(facilities)}
							</label>
						</c:forEach>
					</div>
				</div>
			</div>

			<div class="form-group">
				<label for="REMARKS" class="col-sm-4 control-label">備考</label>
				<div class="col-sm-5">
					<textarea name="remarks" rows="4" class="form-control" id="REMARKS"
						placeholder="その他何かあれば書いてください"></textarea>
				</div>
			</div>

			<div class="col-sm-offset-5 col-sm-7">
				<div class="checkbox">
					<label> <input type="checkbox" name="check1" value="ok">
						この内容でよろしいですか？
					</label>
				</div>
				<br>
			</div>
			<div class="col-sm-offset-5 col-sm-7">
				<input type="submit" class="btn btn-primary" value="予約">
			</div>
		</form>
	</c:if>
	<div class="col-sm-offset-1 col-sm-11">
		<br> <br> <br> <a href="back" class="btn btn-default">Menu</a>
	</div>

</body>
</html>