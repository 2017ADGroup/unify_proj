<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>教室予約</title>
<style type="text/css">

img {
width:210px;
height:140px;
;}
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
function check(){

	var flag = 0;

	// 設定開始（チェックする項目を設定してください）

	if(!document.form1.check1.checked){

		flag = 1;

	}

	// 設定終了


	if(flag){

		window.alert('チェックされていません'); // チェックされていない場合は警告ダイアログを表示
		return false; // 予約を中止

	}
	else{

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
<form class="form-horizontal" method="POST">

			<div class="form-group">
				<label for="roomName" class=" col-sm-4 control-label">教室名</label>
				<div class="col-sm-5">
					<input type="text" name="room" class="form-control" id="roomName" placeholder="教室名">
				</div>
			</div>

						<div class="form-group">
				<label for="SCALE" class="col-sm-4 control-label">規模</label>
				<div class="col-sm-2">
					<input type="number" name="sizeMin" class="form-control" id="SCALE" placeholder="人数">
				</div>
				<div class="col-sm-1">
					<p style="text-align: center;"><b>～</b></p>
				</div>
				<div class="col-sm-2">
					<input type="number" name="sizeMax" class="form-control" id="FIXTURES" placeholder="人数">
				</div>
			</div>

						<div class="form-group">
				<label for="FIXTURES" class="col-sm-4 control-label">備品</label>
				<div class="col-sm-5">
					<input type="text" name="fixtures" class="form-control" id="FIXTURES" placeholder="備品">
				</div>
			</div>
		<div class="col-sm-offset-5 col-sm-7">
			<input type="submit" class="btn btn-info" value="検索" onclick="myEnter()">
			</div>
			<br>
<br>
<div class="col-sm-offset-1 col-sm-10">

<table class="table">
<caption>教室一覧</caption>
	<tr>
		<td>A教室</td><td>B教室</td><td>C教室</td><td>D教室</td>
	</tr>
	<!-- 浅井さん担当部分。教室を横に並べて表示する部分 -->
</table>
</div>
 <div class="form-group">
 <label for="PUTRPOSE" class="col-sm-5 control-label">使用日</label>
 <div class="col-sm-1">
<select  class="form-control" id="PURPOSE" name="reserve_month">
	<option value="${thisMonth}">${thisMonth}</option>	<!-- 今月の日時を取得してその月の1日から翌月末までを指定する -->
	<option value="${thisMonth + 1}">${thisMonth + 1}</option>
	</select>
	</div>
	<div class="col-sm-1">
	<b>月</b>
	</div>
	<div class="col-sm-1">
	<select class="form-control" id="PURPOSE" name="reserve_month">
	<option>1</option><option>2</option><option>3</option><option>4</option><option>5</option><option>6</option><option>7</option>
	<option>8</option><option>9</option><option>10</option><option>11</option><option>12</option><option>13</option><option>14</option>
	<option>15</option><option>16</option><option>17</option><option>18</option><option>19</option><option>20</option><option>21</option>
	<option>22</option><option>23</option><option>24</option><option>25</option><option>26</option><option>27</option><option>28</option>
	<option>29</option><option>30</option><option>31</option>
	</select>
</div>
	<div class="col-sm-1">
	<b>日</b>
	</div></div>
<div class="col-sm-offset-1 col-sm-10">

<table class="table">
<caption>予約状況</caption>
	<tr>
		<th></th><th>1限</th><th>2限</th><th>3限</th><th>4限</th><th>5限</th><th>6限</th><th>7限以降</th>
	</tr>
	<!-- この部分にスケジュールの<tr>行部分が入ります。JavaのStringで作り、スコープで受け渡して生成する予定 -->
</table>
</form>
		<form class="form-horizontal" method="POST" action="menu.html" name="form1" onSubmit="return check()">
 <div class="form-group">
 <label for="PUTRPOSE" class="col-sm-4 control-label">使用目的</label>
 <div class="col-sm-5">
<select class="form-control" id="PURPOSE">
	<option>講義</option>
	<option>課外活動</option>
	<option>備品整備</option>
	<option>その他(備考欄記述)</option>
</select>
</div></div>
			<div class="form-group">
				<label for="NUMBER" class=" col-sm-4 control-label">使用人数</label>
				<div class="col-sm-5">
					<input type="text" name="name" class="form-control" id="NUMBER" placeholder="使用人数">
				</div>
			</div>
			 <div class="form-group">
<label for="FIXTURES" class=" col-sm-4 control-label">備品使用</label>
 <div class="col-sm-5">
  <div class="checkbox">
    <label>
      <input type="checkbox" id="FIXTURES">プロジェクター
    </label>
        <label>
      <input type="checkbox" id="FIXTURES">アンプ
    </label>
  </div></div></div>

			<div class="form-group">
				<label for="REMARKS" class="col-sm-4 control-label">備考</label>
				<div class="col-sm-5">
						<textarea name="remarks" rows="4" class="form-control" id="REMARKS"
						placeholder="その他何かあれば書いてください" ></textarea>
				</div>
			</div>

		<div class="col-sm-offset-5 col-sm-7">
			  <div class="checkbox">
    		<label>
      			<input type="checkbox" name="check1" value="ok"> この内容でよろしいですか？
    		</label>
  		</div><br></div>
  				<div class="col-sm-offset-5 col-sm-7">
			<input type="submit" class="btn btn-primary" value="予約">
			</div>
			</form>
	<div class="col-sm-offset-1 col-sm-11">
	<br>
	<br>
	<br>
		<a href="menu.html" class="btn btn-default">Menu</a>
	</div>

</body>
</html>