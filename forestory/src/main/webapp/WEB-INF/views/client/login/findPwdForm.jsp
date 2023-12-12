<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jspf"%>
<link rel="stylesheet" type="text/css" href="/resources/include/css/login.css">

</head>
<body>
	<div id="container">
		<h3 class="text-center findPwd-title">FIND PASSWORD</h3>
		<h5 class="text-center">입력된 이메일로 임시 비밀번호가 전송됩니다.</h5>
		<hr>
		<form id="findPwdForm">
			<div class="form-group">
				<input type="text" id="member_id" name="member_id" placeholder="ID"
					class="form-control" />
			</div>
			<div class="form-group">
				<input type="text" id="member_email" name="member_email"
					placeholder="EMAIL" class="form-control" />
			</div>
			<div class="form-group">
				<input type="button" class="form-control button" id="findPwdBtn"
					value="확인" />
			</div>
		</form>
		<br>
		<div>
			<h5 class="text-center">입력된 이메일로 임시 비밀번호가 전송되었습니다.<br>
				다시 로그인하여 비밀번호를 변경해주세요.</h5>
			<button type="button" id="loginFormBtn" class="form-control button">로그인</button>
		</div>
	</div>
</body>
</html>