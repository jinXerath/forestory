<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jspf"%>
<link rel="stylesheet" type="text/css" href="/resources/include/css/client/login.css">
</head>
<body>
	<div id="container">
		<h3 class="text-center">Have an account?</h3>
		<div class="d-flex justify-content-center">
			<form id="loginForm" class="loginForm">
				<div class="form-group text-center">
					<input type="text" id="member_id" name="member_id" placeholder="ID"
						class="form-control" />
				</div>
				<div class="form-group text-center">
					<input type="password" id="member_pwd" name="member_pwd"
						placeholder="PASSWORD" class="form-control" />
				</div>
				<div class="form-group text-center">
					<input type="button" class="form-control button btn-secondary" id="loginBtn"
						value="로그인" />
				</div>
				<div class="text-center">
					<button type="button" class="btn" id="findIdBtn">아이디 찾기</button>|
					<button type="button" class="btn" id="findPwdBtn">비밀번호 찾기</button>|
					<button type="button" class="btn" id="signUpFormBtn">회원가입</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>