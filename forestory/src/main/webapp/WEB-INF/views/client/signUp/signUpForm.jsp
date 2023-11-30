<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css"
	href="/resources/include/css/client/login.css">
<style>
	.chkDiv{
		font-size:10pt;
		color:gray;
	}
	.paddingBottom{
		padding-bottom: 20px;
	}
	
	#signUpContainer{
		padding: 40px 0;
	}
</style>	

<script type="text/javascript">

	function message(id, color, msg){
		$(id).prev().css({'outline-color':color});
		$(id).css('color',color);
		$(id).children('span').text(msg);
	}
	
	function valueStay(value,inputId){
		if(value !=''){ inputId.val(value);}
	}
	
	function postAjax(noDuplicate,chk,word){
		$.ajax({
			url: "/client/"+noDuplicate+"Vaild",
			type: "post",
			data: JSON.stringify({userEmail : $("#"+noDuplicate).val()},
								{userNick : $("#"+noDuplicate).val()}),
			contentType: 'application/json; charset=utf-8',
			dataType: "text",
			error: function(){
				alert('시스템 오류')
			},
			success: function(result){
				if(result == "1"){
					message('#'+chk,'blue','사용 가능한 '+word+'입니다.')
				}else if(result == "0"){
					message('#'+chk,'red','이미 사용중인 '+word+'입니다.')
				}
			}
		});
	}
	
	$(function(){
		
		// 값 유지
		valueStay("<c:out value='${userDto.userEmail}' />",$("#userEmail"))
		valueStay("<c:out value='${userDto.userPw}' />",$("#userPw"))
		valueStay("<c:out value='${userDto.userNick}' />",$("#userNick"))
		valueStay("<c:out value='${userDto.userPhone}' />",$("#userPhone"))
		
		
		// 서버에서 유효성 검사
		if("${validErrors['userEmail']}" != ""){
			alert("${validErrors['userEmail']}")
			$("#userEmail").focus();
		} else if("${validErrors['userPw']}" != "") {
			alert("${validErrors['userPw']}")
			$("#userPw").focus();
		} else if("${validErrors['userNick']}" != "") {
			alert("${validErrors['userNick']}")
			$("#userNick").focus();
		} else if("${validErrors['userPhone']}" != "") {
			alert("${validErrors['userPhone']}")
			$("#userPhone").focus();
		}
		
			
		//이메일 유효성 검사 
		const emailRegExp = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
		$("#userEmail").on("blur",function(){
			if($("#userEmail").val()==""){
				message('#chkEmail','red','이메일을 입력하세요.')
			}else if(!emailRegExp.test($("#userEmail").val())){
				message('#chkEmail','red','지원하지 않는 이메일 형식입니다.')
			}else {
				postAjax('userEmail','chkEmail','이메일')
			}
		});
		
		//비밀번호 유효성 검사: 영문+숫자+특수문자, 8~16
		const pwRegExp = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[@$!%*?&^])[A-Za-z\d@$!%*?&^]{8,16}$/;
		$("#userPw").on("blur",function(){
			console.log($("#userPw").val());
			if($("#userPw").val()==""){
				message('#chkPw','red','비밀번호를 입력하세요.')
			}else if(!pwRegExp.test($("#userPw").val())){
				message('#chkPw','red','영문/숫자/특수문자를 사용하여 8~16자 사이로 입력하세요.')
			}else {
				message('#chkPw','blue','사용가능한 비밀번호 입니다.')
			}
		})
		
		//비밀번호 확인
		let pwConfirm = 0;
		let userPwCheck ;
		const pwCheckExp = /^\s+|\s+$/g;
		$("#userPwCheck").on("blur",function(){
			userPwCheck = $("#userPwCheck").val();
			if(!userPwCheck || userPwCheck.trim() ===''){
				message('#doubleChkPw','gray','비밀번호를 입력해주세요.')
				pwConfirm = 0;
			} else if(userPwCheck !== $("#userPw").val()){
				message('#doubleChkPw','red','비밀번호가 일치하지 않습니다.')
				pwConfirm = 0;
			} else {
				message('#doubleChkPw','blue','비밀번호가 일치합니다.')
				pwConfirm = 1;
			}
		})
		
		// 닉네임 유효성 검사: 특수문자 제외, 2~10
		const nickRegExp = /[ㄱ-ㅎ가-힣a-zA-Z0-9-_]{2,10}$/;
		$("#userNick").on("blur",function(){
			if($("#userNick").val()==""){
				message("#chkNick",'red','닉네임을 입력하세요.')
			}else if(!nickRegExp.test($("#userNick").val())){
				message('#chkNick','red','닉네임은 특수문자를 제외한 2~10자리로 입력해주세요.')
			}else {
				postAjax('userNick','chkNick','닉네임')
			}
		})
		
		// 전화번호 유효성 검사
		const phoneRegExp = /^[0-9]+$/;
		$("#userPhone").on("blur",function(){
			if($("#userPhone").val()==""){
				message("#chkPhone",'red','전화번호를 입력하세요.')
			}else if(!phoneRegExp.test($("#userPhone").val())){
				message('#chkPhone','red',"숫자만 입력해주세요('-'포함 모든 특수문자 불가)")
			}else {
				message('#chkPhone','blue','사용가능한 전화번호 입니다.')
			}
		})
		
		// 회원가입 
		$("#signUpBtn").click(function(){
			if(pwConfirm==1){
				$("#signUpForm").attr({
					"method":"post",
					"action":"/client/signUp"
				});
				$("#signUpForm").submit();
			} else {
				alert('비밀번호가 일치하지 않습니다.')
				$("#userPwCheck").focus();
			}
			
		});
	});
	
	
</script>

<body>
	<div id="signUpContainer">
		<h3 class="text-center">회원가입 기본정보입력</h3>
		<div class="d-flex justify-content-center" >
			<form id="signUpForm">
				<div class="row form-group paddingBottom">
					<div class="col-md-4">
						<label class="label">이메일</label>
					</div>
					<div class="col-md-8">
						<input type="text" class="form-control gray" id="userEmail" name="userEmail" />
						<div class="chkDiv" id="chkEmail">
							<span>보유하신 이메일을 입력해주세요</span>
						</div>
					</div>
				</div>
				
				
				<div class="row form-group paddingBottom">
					<div class="col-md-4">
						<label class="label">비밀번호</label> 
					</div>
					<div class="col-md-8">
						<input type="password" class="form-control gray" id="userPw" name="userPw" />
						<div class="chkDiv" id="chkPw">
							<span>영문/숫자/특수문자를 사용하여 8~16자 사이로 비밀번호를 입력해주세요</span>
						</div>
					</div>
				</div>
				
				<div class="row form-group paddingBottom">
					<div class="col-md-4">
						<label class="label">비밀번호 확인</label> 
					</div>
					<div class="col-md-8">
						<input type="password" class="form-control " id="userPwCheck" name="userPwCheck" />
						<div class="chkDiv" id="doubleChkPw">
							<span>비밀번호를 입력해주세요.</span>
						</div>
					</div>
				</div>
				<!--  
				<div class="row form-group paddingBottom">
					<div class="col-md-4">
						<label class="label">이름</label>
					</div>
					<div class="col-md-8"> 
						<input type="text" class="form-control" id="userName" name="userName" />
						<div class="chkDiv" id="chkName">
							<span>이름를 입력해주세요</span>
						</div>
					</div>
				</div>
				-->
				<div class="row form-group paddingBottom">
					<div class="col-md-4">
						<label class="label">닉네임</label> 
					</div>
					<div class="col-md-8"> 
						<input type="text" class="form-control" id="userNick" name="userNick" />
						<div class="chkDiv" id="chkNick">
							<span>닉네임를 입력해주세요</span>
						</div>
					</div>
				</div>
				
				<div class="row form-group paddingBottom">
					<div class="col-md-4">
						<label class="label">전화번호</label> 
					</div>
					<div class="col-md-8"> 
						<input type="text" class="form-control" id="userPhone" name="userPhone" />
						<div class="chkDiv" id="chkPhone">
								<span>전화번호를 숫자만 입력해주세요</span>
						</div>
					</div>
					<button type="button" class="form-control button" id="phoneCheckBtn">전화번호 인증</button>
				</div>
				
				<!-- <div class="row form-group">
					<label class="label">생년월일</label> 
					<input type="date" class="form-control" id="user_birth" name="user_birth" />
				</div> -->
				
				<!-- <div class="row form-group">
					<label class="label">주소</label> 
					<input type="text" class="form-control" id="user_addr" name="user_addr" />
				</div> -->
				
				
				<div class="row form-group paddingBottom">
					<input type="button" class="form-control button" id="signUpBtn" name="signUpBtn" value="회원가입" />
				</div>
			</form>
		</div>
	</div>
</body>
</html>