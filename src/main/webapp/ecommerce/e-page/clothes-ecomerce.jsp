<%@include file="header.jsp"%>
<div class="page-header header-filter header-small" data-parallax="true"
	style="background-image: url(&apos;<%=request.getContextPath()%>/ecommerce/assets/img/examples/clark-street-merc.jpg&apos;);">
	<div class="container">
		<div class="row">
			<div class="col-md-8 ml-auto mr-auto text-center">
				<div class="brand">
					<h1 class="title">Well Come To Zent Clothes !</h1>
					<h4>
						Free global delivery for all products. Use coupon <b>25summer</b>
						for an extra 25% Off
					</h4>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="main main-raised">
	<div class="section">
		<div class="searchEco">
			<form action="ecommerce?action=search" method="post">
				<div class="row">
					<div class="col-md-12">
						<div class="form-group label-floating floated">
							<label class="control-label">Name</label> <input type="text"
								class="form-control" name="name" value="" />
						</div>
						<div class="form-group label-floating floated">
							<label class="control-label">Code</label> <input type="text"
								class="form-control" name="code" value="" />
						</div>
						<button type="submit"
							class="btn btn-primary btn-fab btn-fab-mini btn-round searchIcon">
							<i class="material-icons">search</i>
						</button>
					</div>
				</div>
			</form>
		</div>
		<div class="container">
			<h2 class="section-title">Latest Offers</h2>
			<div class="row">

				<!-- Product  -->
				<c:forEach var="product" items="${ proEco }">
					<div class="col-md-4">
						<div class="card card-product card-plain">
							<div class="card-header card-header-image">
								<a
									href="<%=request.getContextPath() %>/product-detail?id=<c:out value="${product.productId }"></c:out>">
									<img src="<%=request.getContextPath() %>/<c:out value="${product.image }"/>" alt="" width="100px"
									height="350px">
								</a>
							</div>
							<div class="card-body">
								<h4 class="card-title">
									<a
										href="<%=request.getContextPath() %>/product-detail?id=<c:out value="${product.productId }"></c:out>">
										<c:out value="${product.name }"></c:out>
									</a>
								</h4>
								<p class="card-description">
									Code :
									<c:out value="${product.code}"></c:out>
								</p>
							</div>
							<div class="card-footer">
								<div class="price-container">
									<span class="price price-new"> <c:out
											value="${product.price }"></c:out>$
									</span>
								</div>
								<div class="stats ml-auto">
									<a type="button" rel="tooltip" title=""
										href="<%=request.getContextPath() %>/product-detail?id=<c:out value="${product.productId }"></c:out>&action="
										class="btn  btn-round btn-info"
										data-original-title="Saved to Wishlist" style="color: white">
										Infomation </a>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<nav aria-label="..." class="page-eco">
				<ul class="pagination pagination-lg">

					<c:forEach var="i" begin="1" end="${count}">
						<li
							class="pageClick <%=(request.getParameter("page") != null && Integer
						.parseInt(request.getParameter("page")) == ((Long) request.getAttribute("count")).intValue()
								? "active"
								: "")%>  "><a
							href="<%=request.getContextPath()%>/ecommerce?action=search&page=<c:out value ='${i}'/>">
								<c:out value="${i}" />
						</a></li>
					</c:forEach>
					<c:set var="pageIndex" value="${pageNumber}" scope="session" />
				</ul>
			</nav>
			<script>
				$(document).ready(function() {
					$('.pageClick').click(function() {
						$(".active").removeClass("active");
						$(this).addClass("active");
					});
				});
			</script>
		</div>
	</div>
</div>
<!-- end-main-raised -->
<div class="section section-blog">
	<div class="container">
		<h2 class="section-title">Latest Articles</h2>
		<div class="row">
			<div class="col-md-4">
				<div class="card card-blog">
					<div class="card-header card-header-image">
						<a href="#pablo"> <img
							src="<%=request.getContextPath()%>/ecommerce/assets/img/dg6.jpg"
							alt="">
						</a>
					</div>
					<div class="card-body">
						<h6 class="card-category text-rose">Trends</h6>
						<h4 class="card-title">
							<a href="#pablo">Learn how to wear your scarf with a floral
								print shirt</a>
						</h4>
						<p class="card-description">Don't be scared of the truth
							because we need to restart the human foundation in truth And I
							love you like Kanye loves Kanye I love Rick Owens’ bed design but
							the back is...</p>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="card card-blog">
					<div class="card-header card-header-image">
						<a href="#pablo"> <img
							src="<%=request.getContextPath()%>/ecommerce/assets/img/dg6.jpg"
							alt="">
						</a>
					</div>
					<div class="card-body">
						<h6 class="card-category text-rose">Trends</h6>
						<h4 class="card-title">
							<a href="#pablo">Learn how to wear your scarf with a floral
								print shirt</a>
						</h4>
						<p class="card-description">Don't be scared of the truth
							because we need to restart the human foundation in truth And I
							love you like Kanye loves Kanye I love Rick Owens’ bed design but
							the back is...</p>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="card card-blog">
					<div class="card-header card-header-image">
						<a href="#pablo"> <img
							src="<%=request.getContextPath()%>/ecommerce/assets/img/dg6.jpg"
							alt="">
						</a>
					</div>
					<div class="card-body">
						<h6 class="card-category text-rose">Trends</h6>
						<h4 class="card-title">
							<a href="#pablo">Learn how to wear your scarf with a floral
								print shirt</a>
						</h4>
						<p class="card-description">Don't be scared of the truth
							because we need to restart the human foundation in truth And I
							love you like Kanye loves Kanye I love Rick Owens’ bed design but
							the back is...</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- section -->
<div class="subscribe-line subscribe-line-image" data-parallax="true"
	style="background-image: url(&apos;<%=request.getContextPath()%>/assets/img/examples/ecommerce-header.jpg&apos;);">
	<div class="container">
		<div class="row">
			<div class="col-md-6 ml-auto mr-auto">
				<div class="text-center">
					<h3 class="title">Subscribe to our Newsletter</h3>
					<p class="description">Join our newsletter and get news in your
						inbox every week! We hate spam too, so no worries about this.</p>
				</div>
				<div class="card card-raised card-form-horizontal">
					<div class="card-body">
						<form method="" action="">
							<div class="row">
								<div class="col-sm-8">
									<div class="input-group">
										<span class="input-group-addon"> <i
											class="material-icons">mail</i>
										</span>
										<div class="form-group has-default bmd-form-group">
											<input type="text" class="form-control"
												placeholder="Your Email...">
										</div>
									</div>
								</div>
								<div class="col-sm-4">
									<button type="button" class="btn btn-rose btn-block">Subscribe</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%@include file="footer.jsp"%>