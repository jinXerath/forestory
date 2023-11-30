<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jspf" %>
	  	<!-- ======= Header/Navbar ======= -->
	  	<header>
	    	<nav class="navbar navbar-default navbar-trans navbar-expand-lg">
	      		<div class="container">
	        		<button class="navbar-toggler collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#navbarDefault" aria-controls="navbarDefault" aria-expanded="false" aria-label="Toggle navigation">
	          			<span></span>
	          			<span></span>
	          			<span></span>
	        		</button>
	        		<a class="navbar-brand text-brand" href="index.html"><span class="color-b">Forestory</span></a>
	
	        		<div class="navbar-collapse collapse justify-content-center" id="navbarDefault">
	          			<ul class="navbar-nav">
				            <li class="nav-item">
				              	<a class="nav-link" href="">우리의 숲</a>
				            </li>
	            			<li class="nav-item">
	              				<a class="nav-link " href="">자유게시판</a>
	            			</li>
	            			<li class="nav-item">
	              				<a class="nav-link " href="">마이페이지</a>
	            			</li>
	
	          			</ul>
	        		</div>
	
	        		<div>
	          			<div class="small" style="display: inline-block; margin-left: 10px;">
	            			<button type="button" id="logout" class="btn btn-light" onclick = "location.href = '/client/login/loginForm'">
	              				<i class="fa-solid fa-door-open"></i>로그인
	            			</button>
	          			</div>
	          			|
	          			<div class="small" style="display: inline-block; margin-left: 10px;">
	          				<button type="button" id="logout" class="btn btn-light" onclick = "location.href = '/client/signUp/signUpForm'">
	            				<i class="fa-solid fa-door-open"></i>회원가입
	          				</button>
	        			</div>
	        		</div> 
	      		</div>
	    	</nav><!-- End Header/Navbar -->
	  	</header>