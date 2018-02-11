<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<div class="content">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12" id="searchToggle" style="display: none">
				<div class="card">
					<div class="card-header" data-background-color="purple">
						<h4 class="title">Search</h4>
					</div>
					<div class="card-content">
						<form user="form" method="POST"
							action='product-manager?action=search' name="frmSearchuser">

							<div class="row">	
							<div class="col-md-4">
									<div class="form-group label-floating">
										<label class="control-label">Product Id</label> <input
											class="form-control" type="text" name="productId"
											value="<c:out value="${product.productId}" />" />
									</div>
								</div>				
								<div class="col-md-4">
									<div class="form-group label-floating">
										<label class="control-label">Category Id</label> <input
											class="form-control" type="text" name="categoryId"
											value="<c:out value="${product.categoryId}" />" />
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group label-floating">
										<label class="control-label">name</label> <input
											class="form-control" type="text" name="Name"
											value="<c:out value="${product.name}" />" />
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group label-floating">
										<label class="control-label">code</label> <input
											class="form-control" type="text" name="Code"
											value="<c:out value="${product.code}" />" />
									</div>
								</div>
								
							</div>

							<button type="submit" class="btn btn-primary pull-right">Search
								Infomation</button>
							<div class="clearfix"></div>
						</form>
					</div>
				</div>
			</div>
			<div class="col-md-12">
				<div class="card">
					<div class="card-header" data-background-color="purple">
						<h4 class="title">Product Manager</h4>
						<a class="btn  btn-round btn-info"
							href="<%=request.getContextPath()%>/product-manager?action=insert">
							<i class="material-icons">add</i> Add
						</a>
						<button class="btn btn-warning btn-round" id="btnSearch" >
							<i class="material-icons">search</i>Search
						</button>
					</div>
					<div class="card-content table-responsive">
						<table class="table">
							<thead class="text-primary">
								<th>P_Id</th>
								<th>C_Id</th>
								<th>Name</th>
								<th>Code</th>
								<th>Quantity</th>
								<th>Price</th>
								<th>Description</th>
								<th>Image</th>
								<th>Size</th>
								<th style="text-align: center" colspan=2>Action</th>
							</thead>
							<c:forEach items="${products}" var="product">
								<tbody>
									<tr>
									<td><c:out value="${product.productId }"></c:out></td>
									<td><c:out value="${product.categoryId }"></c:out></td>
									<td><c:out value="${product.name }"></c:out></td>
									<td><c:out value="${product.code }"></c:out></td>
									<td><c:out value="${product.quantity }"></c:out></td>
									<td><c:out value="${product.price }"></c:out></td>
									<td><c:out value="${product.description }"></c:out></td>
									<td><c:out value="${product.image }"></c:out></td>
									<td><c:out value="${product.size }"></c:out></td>
										<td><a class="btn btn-md btn-info"
											href="<%=request.getContextPath() %>/product-manager?action=edit&id=<c:out value="${product.productId }"></c:out>"
											product="button"><i class="fa fa-pencil-square-o"></i>&nbsp;
												Edit</a></td>
										<td><a
											onclick="return confirm('Bạn có chắc chắn muốn xóa?')"
											class="btn btn-md btn-danger"
											href="<%=request.getContextPath() %>/product-manager?action=delete&id=<c:out value="${product.productId }"></c:out>"
											product="button"><i class="fa fa-trash"></i>&nbsp;Delete</a></td>


									</tr>
								</tbody>
							</c:forEach>
						</table>
					</div>

				</div>
				<nav aria-label="Page navigation example">
					<ul class="pagination justify-content-center">
						<li class="page-item disabled"><a class="page-link" href="#"
							tabindex="-1">Previous</a></li>
						<li class="page-item"><a class="page-link" href="#">1</a></li>
						<li class="page-item active"><a class="page-link" href="#">2
								<span class="sr-only">(current)</span>
						</a></li>
						<li class="page-item"><a class="page-link" href="#">3</a></li>
						<li class="page-item"><a class="page-link" href="#">Next</a>
						</li>
					</ul>
				</nav>
			</div>

		</div>
	</div>
</div>
<script>
	$(document).ready(function() {
		$('.pagination li').click(function() {
			$(".active").removeClass("active");
			$(this).addClass("active");
		});
	});
	$(document).ready(function() {
		$("#btnSearch").click(function() {
			$("#searchToggle").toggle();
		});
	});
</script>
<%@include file="footer.jsp"%>
