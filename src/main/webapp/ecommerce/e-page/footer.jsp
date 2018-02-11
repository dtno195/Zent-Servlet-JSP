<footer class="footer footer-black footer-big">
		<div class="container">
			<div class="content">
				<div class="row">
					<div class="col-md-4">
						<h5>About Us</h5>
						<p>Zent Clothes is a startup that creates design tools that
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
								src="<%=request.getContextPath()%>/ecommerce/assets/img/faces/card-profile6-square.jpg"
								class="img img-raised rounded" alt=""> <img
								src="<%=request.getContextPath()%>/ecommerce/assets/img/faces/christian.jpg"
								class="img img-raised rounded" alt=""> <img
								src="<%=request.getContextPath()%>/ecommerce/assets/img/faces/card-profile4-square.jpg"
								class="img img-raised rounded" alt=""> <img
								src="<%=request.getContextPath()%>/ecommerce/assets/img/faces/card-profile1-square.jpg"
								class="img img-raised rounded" alt=""> <img
								src="<%=request.getContextPath()%>/ecommerce/assets/img/faces/marc.jpg"
								class="img img-raised rounded" alt=""> <img
								src="<%=request.getContextPath()%>/ecommerce/assets/img/faces/kendall.jpg"
								class="img img-raised rounded" alt=""> <img
								src="<%=request.getContextPath()%>/ecommerce/assets/img/faces/card-profile5-square.jpg"
								class="img img-raised rounded" alt=""> <img
								src="<%=request.getContextPath()%>/ecommerce/assets/img/faces/card-profile2-square.jpg"
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
				Simple D All Rights Reserved.
			</div>
		</div>
	</footer>
	<!--   Core JS Files   -->
	<script
		src="<%=request.getContextPath()%>/ecommerce/assets/js/core/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/ecommerce/assets/js/core/popper.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/ecommerce/assets/js/bootstrap-material-design.js"></script>
	<!--  Plugin for Date Time Picker and Full Calendar Plugin-->
	<script
		src="<%=request.getContextPath()%>/ecommerce/assets/js/plugins/moment.min.js"></script>
	<!--	Plugin for Select, full documentation here: http://silviomoreto.github.io/bootstrap-select -->
	<script
		src="<%=request.getContextPath()%>/ecommerce/assets/js/plugins/bootstrap-selectpicker.js"></script>
	<!--	Plugin for Tags, full documentation here: http://xoxco.com/projects/code/tagsinput/  -->
	<script
		src="<%=request.getContextPath()%>/ecommerce/assets/js/plugins/bootstrap-tagsinput.js"></script>
	<!--	Plugin for Fileupload, full documentation here: http://www.jasny.net/bootstrap/javascript/#fileinput -->
	<script
		src="<%=request.getContextPath()%>/ecommerce/assets/js/plugins/jasny-bootstrap.min.js"></script>
	<!--	Plugin for Small Gallery in Product Page -->
	<script
		src="<%=request.getContextPath()%>/ecommerce/assets/js/plugins/jquery.flexisel.js"></script>
	<!--	Plugin for the Datepicker, full documentation here: https://github.com/Eonasdan/bootstrap-datetimepicker -->
	<script
		src="<%=request.getContextPath()%>/ecommerce/assets/js/plugins/bootstrap-datetimepicker.min.js"></script>
	<!--	Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
	<script
		src="<%=request.getContextPath()%>/ecommerce/assets/js/plugins/nouislider.min.js"></script>
	<!-- Material Kit Core initialisations of plugins and Bootstrap Material Design Library -->
	<script
		src="<%=request.getContextPath()%>/ecommerce/assets/js/material-kit.js?v=2.0.0"></script>
	<!-- Fixed Sidebar Nav - js With initialisations For Demo Purpose, Don't Include it in your project -->
	<script
		src="<%=request.getContextPath()%>/ecommerce/assets/assets-for-demo/js/material-kit-demo.js"></script>
	<!-- Plugins for presentation and navigation  -->
	<script
		src="<%=request.getContextPath()%>/ecommerce/assets/assets-for-demo/js/modernizr.js"></script>
	<script
		src="<%=request.getContextPath()%>/ecommerce/assets/assets-for-demo/js/vertical-nav.js"></script>
	<!--  Google Maps Plugin    -->
	<script type="text/javascript"
		src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
	<script>
		$(document).ready(
				function() {

					var slider2 = document.getElementById('sliderRefine');

					noUiSlider.create(slider2, {
						start : [ 101, 790 ],
						connect : true,
						range : {
							'min' : [ 30 ],
							'max' : [ 900 ]
						}
					});

					var limitFieldMin = document.getElementById('price-left');
					var limitFieldMax = document.getElementById('price-right');

					slider2.noUiSlider.on('update', function(values, handle) {
						if (handle) {
							limitFieldMax.innerHTML = $('#price-right').data(
									'currency')
									+ Math.round(values[handle]);
						} else {
							limitFieldMin.innerHTML = $('#price-left').data(
									'currency')
									+ Math.round(values[handle]);
						}
					});
				});
	</script>
</body>

</html>