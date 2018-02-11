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
<title>Cart</title>
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
<link
	href="<%=request.getContextPath()%>/ecommerce/assets/css/styleCart.css"
	rel="stylesheet" />
<script src="http://code.jquery.com/jquery-3.3.1.js"
	integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
	crossorigin="anonymous"></script>
</head>

<body class="pricing ">
	<nav
		class="navbar navbar-color-on-scroll navbar-transparent fixed-top  navbar-expand-lg "
		color-on-scroll="100" id="sectionsNav">
		<div class="container">
			<div class="navbar-translate">
				<a class="navbar-brand"
					href="<%=request.getContextPath()%>/ecommerce"></a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span> <span
						class="navbar-toggler-icon"></span> <span
						class="navbar-toggler-icon"></span>
				</button>
			</div>

		</div>
	</nav>
	<div class="page-header header-filter header-small"
		data-parallax="true"
		style="background-image: url(&apos;<%=request.getContextPath()%>/assets/img/bg2.jpg&apos;);">
		<div class="container">
			<div class="row">
				<div class="col-md-8 ml-auto mr-auto text-center">
					<h1 class="title">Cart Detail</h1>
				</div>
			</div>
		</div>
	</div>
	<div class="main main-raised">
		<div class="container">
			<div class="pricing-2">
				<div class="row">
					<div class="col-md-6 ml-auto mr-auto text-center">
						<ul class="navbar-nav ml-auto">

							<c:if test="${size ne 0 }">
								<li class="button-container nav-item"><a
									href="<%=request.getContextPath()%>/form-manager"
									class="btn  btn-rose   btn-round btn-block"> <i
										class="material-icons">shopping_cart</i> Pay

								</a></li>
							</c:if>
							<h1>
								Total :<small>$</small> ${sum }
							</h1>
						</ul>
					</div>
				</div>


				<div class="card-content table-responsive">
					<table class="table">
						<thead class="text-primary">
							<th>#</th>
							<th>Name</th>
							<th>Code</th>
							<th>Image</th>
							<th>Price</th>
							<th>Quantity</th>
							<th>Action</th>
						</thead>
						<c:forEach items="${cart}" var="pro" varStatus="count">
							<tbody>
								<tr>
									<td>${count.count}</td>
									<td><c:out value="${pro.pro.name }"></c:out></td>
									<td><c:out value="${pro.pro.code }"></c:out></td>
									<td><img alt=""
										src="<%=request.getContextPath() %>/<c:out value="${pro.pro.image }"/>"
										style="width: 100px; height: 100px;"></td>
									<td>$&nbsp;<c:out value="${pro.pro.price }"></c:out></td>
									<td><font style="text-align: center"><c:out
												value="${pro.quantityBuy }"></c:out></font></td>
									<td><a
										onclick="return confirm('Bạn có chắc chắn muốn xóa?')"
										class="btn btn-md btn-danger"
										href="<%=request.getContextPath() %>/cart-controller?action=delete&id=<c:out value="${pro.pro.productId }"></c:out>"
										role="button"><i class="fa fa-trash"> </i>&nbsp;Delete</a></td>


								</tr>
							</tbody>
						</c:forEach>
					</table>
				</div>
			</div>

			<hr>
			<div class="features-2">
				<div class="text-center">
					<h3 class="title">Frequently Asked Questions</h3>
				</div>
				<div class="row">
					<div class="col-md-4 ml-auto">
						<div class="info info-horizontal">
							<div class="icon icon-info">
								<i class="material-icons">card_membership</i>
							</div>
							<div class="description">
								<h4 class="info-title">Can I cancel my subscription?</h4>
								<p>Yes, you can cancel and perform other actions on your
									subscriptions via the My Account page.</p>
							</div>
						</div>
					</div>
					<div class="col-md-4 mr-auto">
						<div class="info info-horizontal">
							<div class="icon icon-success">
								<i class="material-icons">card_giftcard</i>
							</div>
							<div class="description">
								<h4 class="info-title">Is there any discount for an annual
									subscription?</h4>
								<p>Yes, we offer a 40% discount if you choose annual
									subscription for any plan.</p>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4 ml-auto">
						<div class="info info-horizontal">
							<div class="icon icon-success">
								<i class="material-icons">attach_money</i>
							</div>
							<div class="description">
								<h4 class="info-title">Which payment methods do you take?</h4>
								<p>WooCommerce comes bundled with PayPal (for accepting
									credit card and PayPal account payments), BACS, and cash on
									delivery for accepting payments.</p>
							</div>
						</div>
					</div>
					<div class="col-md-4 mr-auto">
						<div class="info info-horizontal">
							<div class="icon icon-rose">
								<i class="material-icons">question_answer</i>
							</div>
							<div class="description">
								<h4 class="info-title">Any other questions we can answer?</h4>
								<p>We are happy to help you. Contact us.</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<footer class="footer ">
		<div class="container">
			<nav class="pull-left">
				<ul>
					<li><a href="https://www.creative-tim.com"> Creative Tim </a>
					</li>
					<li><a href="http://presentation.creative-tim.com"> About
							Us </a></li>
					<li><a href="http://blog.creative-tim.com"> Blog </a></li>
					<li><a href="https://www.creative-tim.com/license">
							Licenses </a></li>
				</ul>
			</nav>
			<div class="copyright pull-right">
				&copy;
				<script>
					document.write(new Date().getFullYear())
				</script>
				, made with <i class="material-icons">favorite</i> by <a
					href="https://www.creative-tim.com" target="_blank">Simple D</a>
				for a better web.
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
</body>

</html>