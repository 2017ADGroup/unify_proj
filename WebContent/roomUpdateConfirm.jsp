<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予約内容更新確認</title>
    <!-- BootstrapのCSS読み込み -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
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

		window.alert('更新しました');
		return true; // 更新を実行

	}

}
// -->
</script>
</head>
<body>
<form class="form-hrizonatal" method="POST" action="roomLump.html" name="form1" onSubmit="return check()">
	<fieldset>
	<legend>変更前</legend>
		<table class="table">
			<thead>
				<tr>
					<th class="col-sm-1">月日</th>
					<th class="col-sm-1">教室名</th>
					<th class="col-sm-1">時間</th>
					<th class="col-sm-2">使用目的/使用人数</th>
					<th class="col-sm-4">備品</th>
					<th class="col-sm-3">備考</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type='date' name='date' value='${fn:escapeXml(reserve.date)}' disabled='disabled'></td>
					<td>
						<select disabled='disabled'>
						<option selected='selected'>${fn:escapeXml(reserve.room)}</option>
						</select>
					</td>
					<td>
						<select disabled='disabled'>
						<option selected='selected'>${fn:escapeXml(reserve.term)}限目</option>
						</select></td>
					<td>
						<select class="select" disabled='disabled'>
						<option selected='selected'>${fn:escapeXml(purpose)}</option><!-- reserve.purposeはint型なのでStringに直す必要がある -->
						</select>
						<input type="number" value="${reserve.amount}" disabled='disabled'>
					</td>
					<td>
						<c:forEach var="reserveFacilities" items="${reserveFacilityList}"><!-- 既に予約されている設備リストをここで展開 -->
						<button type="button" class="btn btn-default" disabled='disabled'>${reserveFacilities.facility}</button><br>
						</c:forEach>
					</td>
					<td>
						<textarea name="bikou" rows="4" cols="36" readonly='readonly'>${reserve.remarks}</textarea></td>
				</tr>
			</tbody>
		</table>
			<div style="display: flex; justify-content: center; align-items: center; ">
			<span class="glyphicon glyphicon-circle-arrow-down" style="font-size: 64px; "></span>
			</div>

<legend>変更後</legend>
		<table class="table">
			<thead>
				<tr>
					<th class="col-sm-1">月日</th>
					<th class="col-sm-1">教室名</th>
					<th class="col-sm-1">時間</th>
					<th class="col-sm-2">使用目的/使用人数</th>
					<th class="col-sm-4">備品</th>
					<th class="col-sm-3">備考</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type='date' name='date' value='${fn:escapeXml(year)}-${fn:escapeXml(reserve.month)}-${fn:escapeXml(reserve.day)}' disabled='disabled'></td>
					<td><select disabled='disabled'>
							<option selected='selected'>${fn:escapeXml(reserve.room)}</option>
						</select>
					</td>
					<td><select disabled='disabled'>
							<option selected='selected'>${fn:escapeXml(reserve.term)}限目</option>
						</select></td>
					<td>
						<select class="select" name="purpose">
							<option value="1">講義</option>
							<option value="2">課外活動</option>
							<option value="3">備品整備</option>
							<option value="4">その他(備考欄記述)</option>
						</select>
						<input name="amount" type="number" />
					</td>
					<td>
						<c:forEach var="facilities" items="${facilityList}"><!-- 設備リストをここで展開 -->
						<input type="checkbox" name="${facilities}" value="${facilities}">
						</c:forEach>
					</td>
					<td>
					<textarea name="bikou" rows="4" cols="36"></textarea></td>
				</tr>
			</tbody>
		</table>
	</fieldset>
	<br>
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
 	<div class="col-sm-offset-5 col-sm-1">
<input type="submit" class="btn btn-info" name="button" value="戻る"
				onclick="location.href='roomLump'; return false;">
	</div>
		<div class="col-sm-6">
			<input type="submit" class="btn btn-danger" value="更新">
		</div>
	</form>
	<br>
	<br>
	<br>
		<div class="col-sm-offset-1 col-sm-11">
		<a href="back" class="btn btn-default">Menu</a>
	</div>
</body>
</html>