<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
      <script type="text/javascript">
      		$(function(){
      			$("#insertFormBtn").click(function(){
      				location.href="/board/boardInsertForm";
      			});
      		});
      </script>
   </head>
   <body>
   		<div class="container">
   			<h1 class="text-center">자유게시판</h1>
   			<hr>
   			<div id="boardList">
   				<table class="table">
   					<thead>
   						<tr>
   							<th class="text-center">글번호</th>
   							<th class="text-center">제목</th>
   							<th class="text-center">내용</th>
   							<th class="text-center">등록일</th>
   							<th class="text-center">조회수</th>
   						</tr>
   					</thead>
   					<tbody>
   						<c:choose>
   							<c:when test="${not empty boardList}">
   								<c:forEach var="board" items="${boardList}" varStatus="status">
   									<tr>
   										<td class="text-center">${board.boardNo}</td>
   										<td class="text-center">${board.boardTitle}</td>
   										<td class="text-center">${board.boardContent}</td>
   										<td class="text-center">${board.boardRegdate}</td>
   										<td class="text-center">${board.boardReadcnt}</td>
   									</tr>
   								</c:forEach>
   							</c:when>
   							<c:otherwise>
   								<tr>
   									<td colspan="4">등록된 게시글이 없습니다.</td>
   								</tr>
   							</c:otherwise>
   						</c:choose>
   					</tbody>
   				</table>
   			</div>
   			<div>
	   			<button type="button" id="insertFormBtn">글작성</button>
   			</div>
   		</div>
   </body>
</html>