<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jspf"%>
<link rel="stylesheet" type="text/css" href="/resources/include/css/login.css">

</head>
<body>
	<div id="container">
		<h3 class="text-center">FIND ID</h3>
		<form id="findIdForm">
			<div class="form-group">
				<input type="text" id="member_name" name="member_name"
					placeholder="NAME" class="form-control" />
			</div>
			<div class="form-group">
				<input type="text" id="member_phone" name="member_phone"
					placeholder="PHONE" class="form-control" />
			</div>
			<div class="form-group">
				<input type="button" class="form-control button" id="findIdBtn"
					value="찾기" />
			</div>

		</form>
		<br>
		<div id="findIdSuccess">
			<h4 class="text-center">입력하신 정보와 일치하는 아이디입니다.</h4>
			<br>
			<table class="table">
				<tr>
					<td class="text-center">아이디</td>
					<td>id1234</td>
				</tr>
				<tr>
					<td class="text-center">가입일</td>
					<td>2023-08-27</td>
				</tr>
				<tr>
					<td colspan="2">
						<button type="button" id="loginFormBtn" class="form-control button">로그인</button>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>