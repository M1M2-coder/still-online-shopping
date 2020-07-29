<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- Getting the application context path  -->
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!-- Loading the static resources -->
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />


<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<title>Online Shopping - ${title}</title>

<script type="text/javascript">
	window.menu = '${title}';

	window.contextRoot = '${contextRoot}';
</script>

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
		<%@include file="./shared/navbar.jsp"%>

		<!--*************************** End Section: NAVBAR ************************-->

		<div class="content">

			<!-- Section: HOME PAGE -->
			<c:if test="${userClickHome == true}">
				<%@include file="./home.jsp"%>
			</c:if>

			<!--*************************** End Section: HOME PAGE ************************-->


			<!-- Section: ABOUT US PAGE -->
			<c:if test="${userClickAbout == true}">
				<%@include file="./about.jsp"%>
			</c:if>

			<!--*************************** End Section: ABOUT US ************************-->


			<!-- Section: CONTACT US PAGE -->
			<c:if test="${userClickContact == true}">
				<%@include file="./contact.jsp"%>
			</c:if>

			<!--*************************** End Section: CONTACT US PAGE ************************-->


			<!-- Section: ALL PRODUCTS & CATEGORY PRODUCTS PAGE -->
			<c:if
				test="${userClickAllProducts == true or userClickCategoryProducts == true}">
				<%@include file="./listProducts.jsp"%>
			</c:if>

			<!--***************** End Section: ALL PRODUCTS & CATEGORY PRODUCTS PAGE *************-->

			<!-- Section: User click SHOW SINGLE PRODUCT PAGE -->
			<c:if
				test="${userClickShowProduct == true}">
				<%@include file="./singleProduct.jsp"%>
			</c:if>

			<!--***************** End Section: SHOW SINGLE PRODUCTS PAGE ************************-->


		</div>

		<!-- Section: FOOTER -->
		<%@include file="./shared/footer.jsp"%>

		<!--**************************** End Section: FOOTER ******************************-->



		<!-- JavaScript -->
		<script src="${js}/jquery.js"></script>
		<script src="${js}/bootstrap.js"></script>
		<!-- DataTable Plugin -->
		<script src="${js}/jquery.dataTables.js"></script>

		<!-- DataTable Bootstrap -->
		<script src="${js}/dataTables.bootstrap.js"></script>

		<script type="text/javascript" src="${js}/myapp.js"></script>
	</div>
</body>

</html>
