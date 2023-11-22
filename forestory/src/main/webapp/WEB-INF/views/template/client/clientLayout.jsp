<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jspf" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		
		<title>index</title>
		
		<link rel="shortcut icon" href="/resources/images/icon.png" />
		<link rel="apple-touch-icon" href="resources/images/icon.png" />
		
		<!--[if lt IE 9]>
		<script src="../js/html5shiv.js"></script>
		<![endif]-->
		
		<!-- jQuery -->
		<script src="/resources/include/js/jquery-3.7.1.min.js" type="text/javascript"></script>		
		<!-- BootStrap Core CSS Files -->
		<link href="/resources/include/bootstrap-5.3.2-dist/css/bootstrap.min.css" rel="stylesheet"/>
		<!-- client-common CSS File  -->
		<link href="/resources/include/css/client/client-common.css" rel="stylesheet"/>
		<!-- BootStrap Core JS Files -->
		<script src="/resources/include/bootstrap-5.3.2-dist/js/bootstrap.bundle.js"></script>		

	</head>
	<body> 
      	<tiles:insertAttribute name="header" />
      	<tiles:insertAttribute name="main" />
      	<tiles:insertAttribute name="footer" />
   	</body>
</html>