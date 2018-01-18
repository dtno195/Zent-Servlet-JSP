<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Product Manager</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<div class=" row">

	<div class="col-lg-12">

		<div class="panel panel-primary ">
			<div class="panel-heading">Search Infomation</div>
			<div class="panel-body ">
				<div class="row justify-content-md-center">
					<form product="form" method="POST"
						action='product-manager?action=search' name="frmSearchproduct">

						<div class="col-md-3">
							<div class="form-group">
								<label> Category Id</label> <input class="form-control"
									type="text" name="categoryId"
									value="<c:out value="${product.categoryId}" />" />

							</div>
						</div>
						<div class="col-md-3">
							<div class="form-group">
								<label> Name</label> <input class="form-control" type="text"
									name="name" value="<c:out value="${product.name}" />" />

							</div>
						</div>
						<div class="col-md-3">
							<div class="form-group">
								<label> Code</label> <input class="form-control" type="text"
									name="code" value="<c:out value="${product.code}" />" />

							</div>
						</div>
						<div class="col-md-3">
							<div class="form-group">
								<label> Quantity</label> <input class="form-control" type="text"
									name="quantity" value="<c:out value="${product.quantity}" />" />

							</div>
						</div>
						<div class="col-md-3">
							<div class="form-group">
								<label> Price</label> <input class="form-control" type="text"
									name="price" value="<c:out value="${product.price}" />" />

							</div>
						</div>

						<div class="col-md-3">
							<div class="form-group">
								<label> Description</label> <input class="form-control"
									type="text" name="description"
									value="<c:out value="${product.description}" />" />

							</div>
						</div>
						<div class="col-md-3">
							<div class="form-group">
								<label> Size</label> <input class="form-control" type="text"
									name="size" value="<c:out value="${product.size}" />" />
							</div>
						</div>

						<div class="col-md-12 ">
							<div class="form-group">
								<button type="submit" class="btn btn-primary btn-md">Tìm
									kiếm</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="panel panel-primary">
			<div class="panel-heading">
				<div>
					<a class="btn btn-md btn-success"
						href="<%=request.getContextPath()%>/product-manager?action=insert"
						product="button"><i class="fa fa-plus" aria-hidden="true"></i>
						Add New</a>
				</div>
			</div>
			<div class="panel-body">
				<div class="table-responsive">

					<table class="table table-hover">
						<thead>
							<tr>
								<th>P_Id</th>
								<th>C_Id</th>
								<th>Name</th>
								<th>Code</th>
								<th>Quantity</th>
								<th>Price</th>
								<th>Description</th>
								<th>Image</th>
								<th>Size</th>
								<th style="text-align: center">Action</th>
							</tr>
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
					<!-- /.table-responsive -->
					<hr>
					<div class=" col-md-4 ">
						<ul class="pagination pagination-lg ">
							<c:forEach var="i" begin="1" end="${count}">
								<li
									class="<%=(request.getParameter("page") != null && Integer
						.parseInt(request.getParameter("page")) == ((Long) request.getAttribute("count")).intValue()
								? "active"
								: "")%>"><a
									href="<%=request.getContextPath()%>/product-manager?action=search&page=<c:out value ='${i}'/>">
										<c:out value="${i}" />
								</a></li>
							</c:forEach>

						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<%@include file="footer.jsp"%>
<script>
	$(document).ready(function() {
		$('.pagination li').click(function() {
			$(".active").removeClass("active");
			$(this).addClass("active");
		});
	});
</script>