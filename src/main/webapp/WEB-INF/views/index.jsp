<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/test.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div
					style="border: 2px solid blue; border-radius: 5px; height: 55px;">
					<a href="#"><button type="button" class="btn btn-link"
						style="font-size: 20px; margin-top: 8px;">
						Link Sharing
					</button></a>
					<div class="search" style="width: 35%">
						<i class="glyphicon glyphicon-search "></i> <input type="text"
							name="search" placeholder="Search" class="form-control"
							style="padding-left: 20px;" /> <i
							class="glyphicon glyphicon-remove" style="padding-left: 5px;"></i>
					</div>
				</div>
			</div>
		</div>


		<div class="row">
			<div class="col-md-7">
				<%@ include file="recentShares.jsp"%>
				<%@ include file="topPosts.jsp"%>
			</div>
			<div class="col-md-5">
				<%@ include file="login.jsp"%>
				<%@ include file="registration.jsp"%>
			</div>
		</div>
	</div>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>