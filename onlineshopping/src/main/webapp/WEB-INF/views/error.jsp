<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- Getting the application context path  -->
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!-- Loading the static resources -->
<spring:url var="css" value="/resources/css" />



<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<title>Online Shopping - ${title}</title>


<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.css" rel="stylesheet">

<!-- Bootstrap Readable THEME CSS -->
<link href="${css}/bootstrap-read-theme.min.css" rel="stylesheet">

<!-- Bootstrap DataTable CSS -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">


<!-- Add custom CSS here -->
<link href="${css}/myapp.css" rel="stylesheet">
</head>

<body>

	<div class="wrapper">
	
		<!-- Section: NAVBAR -->
	
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="container">
				<div class="navbar-header">

					<a class="navbar-brand" href="${contextRoot}/home">Home</a>
				</div>
			</div>
		</nav>
		<!--*************************** End Section: NAVBAR ************************-->
		
		<div class="content">
			<div class="container">
				<div class="row">
					<div class="col-xs-12">
						<div class="jumbotron">
							 <h1>${errorTitle}</h1>
							<hr>
							<blockquote>
								${errorDescription}								
							
							</blockquote>
						
						</div>
					</div>
				
				</div>
			</div>
		</div>
		
		
		<!-- Section: FOOTER -->
		<%@include file="./shared/footer.jsp"%>

		<!--**************************** End Section: FOOTER ******************************-->
	</div>

</body>
</html>

