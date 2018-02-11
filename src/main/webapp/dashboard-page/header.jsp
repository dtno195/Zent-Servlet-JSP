<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8" />
<link rel="apple-touch-icon" sizes="76x76"
	href="<%=request.getContextPath()%>/assets/img/apple-icon.png" />
<link rel="icon" type="image/png"
	href="<%=request.getContextPath()%>/assets/img/favicon.png" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>Clothes Shop</title>
<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width" />
<!-- Bootstrap core CSS     -->
<link href="<%=request.getContextPath()%>/assets/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="<%=request.getContextPath()%>/assets/css/style.css"
	rel="stylesheet" />
<!--  Material Dashboard CSS    -->
<link
	href="<%=request.getContextPath()%>/assets/css/material-dashboard.css?v=1.2.0"
	rel="stylesheet" />
<!--  CSS for Demo Purpose, don't include it in your project     -->
<link href="<%=request.getContextPath()%>/assets/css/demo.css"
	rel="stylesheet" />

<!--     Fonts and icons     -->
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css"
	rel="stylesheet">
<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,700,300|Material+Icons'
	rel='stylesheet' type='text/css'>
<script src="https://code.jquery.com/jquery-3.3.1.js"
	integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
	crossorigin="anonymous"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>

<script src="<%=request.getContextPath()%>/ckeditor/ckeditor.js"
	type="text/javascript"></script>
</head>
<body>
	<div class="wrapper">
		<div class="sidebar" data-color="purple"
			data-image="<%=request.getContextPath()%>/assets/img/sidebar-1.jpg">
			<!--
        Tip 1: You can change the color of the sidebar using: data-color="purple | blue | green | orange | red"

        Tip 2: you can also add an image using data-image tag
    -->
			<div class="logo ">
				<a
					href="<%=request.getContextPath()%>/ecommerce?action=search&page=1"
					class="simple-text ">Zent Shop </a>
			</div>
			<div class="sidebar-wrapper">
				<ul class="nav">
					<li class="active"><a href="<%=request.getContextPath()%>/dashboard-page/dashboard.jsp"> <i
							class="material-icons">dashboard</i>
							<p>Dashboard</p>
					</a></li>
					<li><a
						href="<%=request.getContextPath()%>/product-manager?action=search&page=1">
							<i class="material-icons">work</i>
							<p>Product</p>
					</a></li>

					<li><a
						href="<%=request.getContextPath()%>/category-manager?action=search&page=1">
							<i class="material-icons">bubble_chart</i>
							<p>Category</p>
					</a></li>
					<c:if test="${roleId eq 4 || roleId eq 1}">
						<li><a
							href="<%=request.getContextPath()%>/bill-manager?action=search&page=1">
								<i class="material-icons">library_books</i>
								<p>Bill</p>
						</a></li>
					</c:if>
					<c:if test="${roleId eq 4 || roleId eq 1}">
						<li><a
							href="<%=request.getContextPath()%>/customer-manager?action=search&page=1">
								<i class="material-icons">face</i>
								<p>Customer</p>
						</a></li>
					</c:if>
					<c:if test="${roleId eq 4 }">
						<li><a
							href="<%=request.getContextPath()%>/role-manager?action=search&page=1">
								<i class="material-icons">business</i>
								<p>Role</p>
						</a></li>
					</c:if>
					<c:if test="${roleId eq 4 }">
						<li><a
							href="<%=request.getContextPath()%>/user-manager?action=search&page=1">
								<i class="material-icons">person</i>
								<p>User</p>
						</a></li>
					</c:if>

				</ul>
			</div>
		</div>
		<div class="main-panel">
			<nav class="navbar navbar-transparent navbar-absolute">
				<div class="container-fluid">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>

					</div>
					<form action="login?action=logout" method="post">
						<div class="collapse navbar-collapse">
							<ul class="nav navbar-nav navbar-right">
								<li><a href="<%=request.getContextPath()%>/index.jsp"
									class="dropdown-toggle" data-toggle="dropdown"> <i
										class="material-icons">dashboard</i>
										<p class="hidden-lg hidden-md">Dashboard</p>
								</a></li>

								<li><a href="#pablo" class="dropdown-toggle"
									data-toggle="dropdown"> <i class="material-icons">person</i>
										<span style="color: blue">Hello , </span> <c:out
											value="${username.username}"></c:out> !
										<p class="hidden-lg hidden-md">Profile</p>
								</a>
									<ul class="dropdown-menu logout-s">
										<li><button type="submit"
												class="btn btn-success pull-right">Logout</button></li>

									</ul></li>
							</ul>
							<!--  <form class="navbar-form navbar-right" role="search">
                            <div class="form-group  is-empty">
                                <input type="text" class="form-control" placeholder="Search">
                                <span class="material-input"></span>
                            </div>
                            <button type="submit" class="btn btn-white btn-round btn-just-icon">
                                <i class="material-icons">search</i>
                                <div class="ripple-container"></div>
                            </button>
                        </form> -->
						</div>
					</form>
				</div>
			</nav>