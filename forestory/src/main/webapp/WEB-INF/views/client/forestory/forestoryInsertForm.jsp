<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jspf" %>
		<script type="text/javascript" src="/resources/smarteditor/js/HuskyEZCreator.js" charset="utf-8"></script>
		<script>
			let oEditors = [];
			
			$(function(){
			    smartEditor();
			});
			
			function smartEditor() {
				console.log("Naver SmartEditor");
				nhn.husky.EZCreator.createInIFrame({
					oAppRef : oEditors,
					elPlaceHolder : "editorTxt",
					sSkinURI : "/resources/smarteditor/SmartEditor2Skin.html",
					fCreator : "createSEditor2"
				});
			};
		</script>
		<h3>우리의 숲</h3>
	    <form action="insertStudentInfoForm" method="post">
	      <div id="smarteditor">
	        <textarea name="editorTxt" id="editorTxt" 
	                  rows="20" cols="10" 
	                  placeholder="내용을 입력해주세요"
	                  style="width: 500px"></textarea>
	      </div>
	      <input type="button" />
	    </form>
