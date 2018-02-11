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
	href="<%=request.getContextPath()%>/assets/img/apple-icon.png">
<link rel="icon"
	href="<%=request.getContextPath()%>/assets/img/favicon.png">
<title>Product</title>
<!--     Fonts and icons     -->
<link rel="stylesheet" type="text/css"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/assets/css/material-kit.css?v=2.0.0">
<!-- Documentation extras -->
<!-- CSS Just for demo purpose, don't include it in your project -->
<link
	href="<%=request.getContextPath()%>/assets/assets-for-demo/demo.css"
	rel="stylesheet" />
<link
	href="<%=request.getContextPath()%>/assets/assets-for-demo/vertical-nav.css"
	rel="stylesheet" />
</head>

<body class="product-page ">
	<nav
		class="navbar navbar-color-on-scroll navbar-transparent bg-rose fixed-top navbar-expand-lg "
		color-on-scroll="100" id="sectionsNav">
		<div class="container">
			<div class="navbar-translate">
				<a class="navbar-brand"
					href="<%=request.getContextPath()%>/ecommerce">Zent Clothes</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span> <span
						class="navbar-toggler-icon"></span> <span
						class="navbar-toggler-icon"></span>
				</button>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="navbar-nav ml-auto">


					<li class="button-container nav-item"><a
						href="<%=request.getContextPath()%>/cart-controller"
						target="_blank"
						class="btn  btn-rose  btn-white  btn-round btn-block"> <i
							class="material-icons">shopping_cart</i> Cart
					</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="page-header header-filter" data-parallax="true"
		filter-color="rose"
		style="background-image: url(&apos;<%=request.getContextPath()%>/assets/img/bg6.jpg&apos;);">
		<div class="container">
			<div class="row title-row">
				<div class="col-md-4 ml-auto">
					<button class="btn btn-white float-right">
						<i class="material-icons">shopping_cart</i>
					</button>
				</div>
			</div>
		</div>
	</div>
	<div class="section section-gray">
		<div class="container">
			<div class="main main-raised main-product">
				<form action="product-detail?action=addToCart&id=<c:out value="${productId.productId }"></c:out>" name="formAddToCart" method="POST">
					<div class="row">
						<div class="col-md-6 col-sm-6">
							<div class="tab-content">
								<div class="tab-pane active" id="product-page1">
									<img src="<c:out value="${productId.image }"></c:out>">
								</div>

							</div>

						</div>
						<div class="col-md-6 col-sm-6">
							<h1 class="title">
								<c:out value="${productId.name }"></c:out>
							</h1>

							<h3 class="main-price">
								Price:
								<c:out value="${productId.price }"></c:out>
								$
							</h3>
							<h5 class="main-price">
								Quantity:
								<c:out value="${productId.quantity }"></c:out>
							</h5>
							<h5 class="main-price">
								Size:
								<c:out value="${productId.size }"></c:out>
							</h5>
							<h5 class="main-price">
								Code:
								<c:out value="${productId.code }"></c:out>
							</h5>
							<div id="accordion" role="tablist">
								<div class="card card-collapse">
									<div class="card-header" role="tab" id="headingOne">
										<h5 class="mb-0">
											<a data-toggle="collapse" href="#collapseOne"
												aria-expanded="true" aria-controls="collapseOne">
												Description <i class="material-icons">keyboard_arrow_down</i>
											</a>
										</h5>
									</div>
									<div id="collapseOne" class="collapse show" role="tabpanel"
										aria-labelledby="headingOne" data-parent="#accordion">
										<div class="card-body">
											<p>
												<c:out value="${productId.description }"></c:out>
											</p>
										</div>
									</div>
								</div>


							</div>

							<div class="row pull-right">
								<button class="btn btn-rose btn-round" type="submit" >
									Add to Cart &#xA0;<i class="material-icons">shopping_cart</i>
								</button>
							</div>
						</div>

					</div>
				</form>
			</div>
			<div class="features text-center">
				<div class="row">
					<div class="col-md-4">
						<div class="info">
							<div class="icon icon-info">
								<i class="material-icons">local_shipping</i>
							</div>
							<h4 class="info-title">2 Days Delivery</h4>
							<p>Divide details about your product or agency work into
								parts. Write a few lines about each one. A paragraph describing
								a feature will be enough.</p>
						</div>
					</div>
					<div class="col-md-4">
						<div class="info">
							<div class="icon icon-success">
								<i class="material-icons">verified_user</i>
							</div>
							<h4 class="info-title">Refundable Policy</h4>
							<p>Divide details about your product or agency work into
								parts. Write a few lines about each one. A paragraph describing
								a feature will be enough.</p>
						</div>
					</div>
					<div class="col-md-4">
						<div class="info">
							<div class="icon icon-rose">
								<i class="material-icons">favorite</i>
							</div>
							<h4 class="info-title">Popular Item</h4>
							<p>Divide details about your product or agency work into
								parts. Write a few lines about each one. A paragraph describing
								a feature will be enough.</p>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
	<footer class="footer footer-black footer-big">
		<div class="container">
			<div class="content">
				<div class="row">
					<div class="col-md-4">
						<h5>About Us</h5>
						<p>Creative Tim is a startup that creates design tools that
							make the web development process faster and easier.</p>
						<p>We love the web and care deeply for how users interact with
							a digital product. We power businesses and individuals to create
							better looking web projects around the world.</p>
					</div>
					<div class="col-md-4">
						<h5>Social Feed</h5>
						<div class="social-feed">
							<div class="feed-line">
								<i class="fa fa-twitter"></i>
								<p>How to handle ethical disagreements with your clients.</p>
							</div>
							<div class="feed-line">
								<i class="fa fa-twitter"></i>
								<p>The tangible benefits of designing at 1x pixel density.</p>
							</div>
							<div class="feed-line">
								<i class="fa fa-facebook-square"></i>
								<p>A collection of 25 stunning sites that you can use for
									inspiration.</p>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<h5>Instagram Feed</h5>
						<div class="gallery-feed">
							<img
								src="<%=request.getContextPath()%>/assets/img/faces/card-profile6-square.jpg"
								class="img img-raised rounded" alt=""> <img
								src="<%=request.getContextPath()%>/assets/img/faces/christian.jpg"
								class="img img-raised rounded" alt=""> <img
								src="<%=request.getContextPath()%>/assets/img/faces/card-profile4-square.jpg"
								class="img img-raised rounded" alt=""> <img
								src="<%=request.getContextPath()%>/assets/img/faces/card-profile1-square.jpg"
								class="img img-raised rounded" alt=""> <img
								src="<%=request.getContextPath()%>/assets/img/faces/marc.jpg"
								class="img img-raised rounded" alt=""> <img
								src="<%=request.getContextPath()%>/assets/img/faces/kendall.jpg"
								class="img img-raised rounded" alt=""> <img
								src="<%=request.getContextPath()%>/assets/img/faces/card-profile5-square.jpg"
								class="img img-raised rounded" alt=""> <img
								src="<%=request.getContextPath()%>/assets/img/faces/card-profile2-square.jpg"
								class="img img-raised rounded" alt="">
						</div>
					</div>
				</div>
			</div>
			<hr>
			<ul class="float-left">
				<li><a href="#pablo"> Blog </a></li>
				<li><a href="#pablo"> Presentation </a></li>
				<li><a href="#pablo"> Discover </a></li>
				<li><a href="#pablo"> Payment </a></li>
				<li><a href="#pablo"> Contact Us </a></li>
			</ul>
			<div class="copyright float-right">
				Copyright &#xA9;
				<script>
					document.write(new Date().getFullYear())
				</script>
				Creative Tim All Rights Reserved.
			</div>
		</div>
	</footer>
	<!--   Core JS Files   -->
	<script
		src="<%=request.getContextPath()%>/assets/js/core/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/js/core/popper.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/js/bootstrap-material-design.js"></script>
	<!--  Plugin for Date Time Picker and Full Calendar Plugin-->
	<script
		src="<%=request.getContextPath()%>/assets/js/plugins/moment.min.js"></script>
	<!--	Plugin for Select, full documentation here: http://silviomoreto.github.io/bootstrap-select -->
	<script
		src="<%=request.getContextPath()%>/assets/js/plugins/bootstrap-selectpicker.js"></script>
	<!--	Plugin for Tags, full documentation here: http://xoxco.com/projects/code/tagsinput/  -->
	<script
		src="<%=request.getContextPath()%>/assets/js/plugins/bootstrap-tagsinput.js"></script>
	<!--	Plugin for Fileupload, full documentation here: http://www.jasny.net/bootstrap/javascript/#fileinput -->
	<script
		src="<%=request.getContextPath()%>/assets/js/plugins/jasny-bootstrap.min.js"></script>
	<!--	Plugin for Small Gallery in Product Page -->
	<script
		src="<%=request.getContextPath()%>/assets/js/plugins/jquery.flexisel.js"></script>
	<!--	Plugin for the Datepicker, full documentation here: https://github.com/Eonasdan/bootstrap-datetimepicker -->
	<script
		src="<%=request.getContextPath()%>/assets/js/plugins/bootstrap-datetimepicker.min.js"></script>
	<!--	Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
	<script
		src="<%=request.getContextPath()%>/assets/js/plugins/nouislider.min.js"></script>
	<!-- Material Kit Core initialisations of plugins and Bootstrap Material Design Library -->
	<script
		src="<%=request.getContextPath()%>/assets/js/material-kit.js?v=2.0.0"></script>
	<!-- Fixed Sidebar Nav - js With initialisations For Demo Purpose, Don't Include it in your project -->
	<script
		src="<%=request.getContextPath()%>/assets/assets-for-demo/js/material-kit-demo.js"></script>
	<!-- Plugins for presentation and navigation  -->
	<script
		src="<%=request.getContextPath()%>/assets/assets-for-demo/js/modernizr.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/assets-for-demo/js/vertical-nav.js"></script>
	<!--  Google Maps Plugin    -->
	<script type="text/javascript"
		src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
	<script>
		$(document).ready(function() {
			$("#flexiselDemo1").flexisel({
				visibleItems : 4,
				itemsToScroll : 1,
				animationSpeed : 400,
				enableResponsiveBreakpoints : true,
				responsiveBreakpoints : {
					portrait : {
						changePoint : 480,
						visibleItems : 3
					},
					landscape : {
						changePoint : 640,
						visibleItems : 3
					},
					tablet : {
						changePoint : 768,
						visibleItems : 3
					}
				}
			});
		});
	</script>
</body>

</html>