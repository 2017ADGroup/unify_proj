<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウント情報更新</title>
<!-- BootstrapのCSS読み込み -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery読み込み -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
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
		return false; // 確認を中止

	}
	else{

		window.alert('更新しました');
		return true; // 確認を実行

	}

}
// -->
</script>
</head>
<body>
<h2 style="text-align: center;">アカウント情報更新</h2>
	<br>
	<div class="col-sm-offset-3 col-sm-9">
	<form class="form-horizontal"method="POST" action="menu.jsp" name="form1" onSubmit="return check()">
		<fieldset>
			<div class="form-group">
				<label for="NAME" class="col-sm-2 control-label">名前</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="NAME" placeholder="名前" name="name" value="${fn:escapeXml(user.name)}">
				</div>
			</div>
			<div class="form-group">
				<label for="NAME" class="col-sm-2 control-label">かな</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="NAME" placeholder="かな" pattern="[ー\u3041-\u3096]*" name="kana" value="${fn:escapeXml(user.kana)}">
				</div>
			</div>
			<div class="form-group">
				<label for="PASS" class="col-sm-2 control-label" >Password</label>
				<div class="col-sm-5">
						<input type="password" class="form-control" id="PASS" placeholder="PASS" name="pass" value="${fn:escapeXml(user.password)}">
				</div>
			</div>
			  <div class="form-group">
     <div class="col-sm-offset-2 col-sm-10">
			  <div class="checkbox">
    		<label>
      			<input type="checkbox" name="check1" value="ok"> この内容でよろしいですか？
    		</label>
  	</div>
  	     </div>
  </div>
		</fieldset>
		<div class="col-sm-offset-2 col-sm-10">
			<input type="submit" class="btn btn-danger" value="更新">
		</div>
		</form>
	</div>
	<div class="col-sm-offset-1 col-sm-11">
		<br>
	<br>
		<a href="back" class="btn btn-default">Menu</a>
	</div>

</body>
</html>