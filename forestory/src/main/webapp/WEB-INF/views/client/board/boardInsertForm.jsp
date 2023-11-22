<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		
		<title>Insert title here</title>
		
		<link rel="shortcut icon" href="/resources/image/icon.png" />
		<link rel="apple-touch-icon" href="resources/image/icon.png" />
		
		<!--[if lt IE 9]>
		<script src="../js/html5shiv.js"></script>
		<![endif]-->
		      
		<script type="text/javascript" src="/resources/include/js/jquery-3.7.0.min.js"></script>
		<script type="text/javascript" src="/resources/smarteditor/js/HuskyEZCreator.js" charset="utf-8"></script>
		<script type="text/javascript">
			$(function(){
				smartEditor();
				
				$("#submitBtn").click(function(){
					oEditors.getById["boardContent"].exec("UPDATE_CONTENTS_FIELD", []);
					
					//let content = $("#boardContent").val();
					//console.log(content);
					
					$("#boardWriteForm").attr({
						"method":"post",
						"action":"/board/boardInsert"
					});
					
					$("#boardWriteForm").submit();
					
					
				});
			});
			
			let oEditors = []
			
			function smartEditor(){
				console.log("Naver SmartEditor")
				nhn.husky.EZCreator.createInIFrame({
					oAppRef : oEditors,
					elPlaceHolder : "boardContent",
					sSkinURI : "/resources/smarteditor/SmartEditor2Skin.html",
					fCreator : "createSEditor2"
				});
			};
		</script>
	</head>
	<body>
		<div class="container">
			<h1 class="text-center">자유게시판</h1>
			<hr>
			<form class="form" id="boardWriteForm">
				<div>
					<label>분류</label>
					<select name="boardCategory" id="boardCategory">
						<option value="공지사항">공지사항</option>
						<option value="이벤트">이벤트</option>
						<option value="나눔">나눔</option>
						<option value="질문">질문</option>
					</select>
					<label>제목</label>
					<input type="text" name="boardTitle" id="boardTitle">
				</div>
				<div>
					<label>내용</label><br>
					<div id="smarteditor">
						<textarea name="boardContent" id="boardContent" 
									rows="20" cols="10"
									placeholder="내용을 입력해주세요" 
									style="width:800px"></textarea>
					</div>
				</div>
				
				<button type="button" id="submitBtn">작성</button>
			</form>
		</div>
	</body>
</html>