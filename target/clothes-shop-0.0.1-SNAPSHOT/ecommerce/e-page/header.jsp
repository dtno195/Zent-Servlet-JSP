<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0"
	name="viewport" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<!-- Favicons -->
<link rel="apple-touch-icon"
	href="<%=request.getContextPath()%>/ecommerce/assets/img/apple-icon.png">
<link rel="icon"
	href="<%=request.getContextPath()%>/ecommerce/assets/img/favicon.png">
<title>Zent Clothes Shop</title>
<!--     Fonts and icons     -->
<link rel="stylesheet" type="text/css"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/ecommerce/assets/css/material-kit.css?v=2.0.0">
<!-- Documentation extras -->
<!-- CSS Just for demo purpose, don't include it in your project -->
<link
	href="<%=request.getContextPath()%>/ecommerce/assets/assets-for-demo/demo.css"
	rel="stylesheet" />
<link
	href="<%=request.getContextPath()%>/ecommerce/assets/assets-for-demo/vertical-nav.css"
	rel="stylesheet" />
</head>
<body class="ecommerce ">
	<nav
		class="navbar navbar-color-on-scroll navbar-transparent    fixed-top  navbar-expand-lg "
		color-on-scroll="100" id="sectionsNav">
		<div class="container">
			<div class="navbar-translate">
				<a class="navbar-brand"
					href="<%=request.getContextPath()%>/ecommerce"><b>Zent
						Clothes</b></a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span> <span
						class="navbar-toggler-icon"></span> <span
						class="navbar-toggler-icon"></span>
				</button>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="navbar-nav ml-auto">

					
					<li class="button-container nav-item"><a href="<%=request.getContextPath() %>/cart-controller"
						target="_blank" class="btn  btn-rose   btn-round btn-block"> <i
							class="material-icons">shopping_cart</i> Cart

					</a></li>
				</ul>
			</div>
		</div>
	</nav>