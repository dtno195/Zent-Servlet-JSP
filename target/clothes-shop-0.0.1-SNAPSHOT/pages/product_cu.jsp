<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Product Edit</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<div class="row">

	<div class="col-lg-12">
		<div class="panel panel-primary">
			<div class="panel-heading">Add New Information</div>
			<div class="panel-body">
				<form product="form" method="POST" action='product-manager?action=save'
					name="frmAddproduct">
					<div class="form-group">
						<label>Product Id</label> <input class="form-control" type="text"
							readonly name="id" value="<c:out value="${product.productId}" />" />
					</div>
					<div class="form-group">
						<label>Category Id</label> <input class="form-control" type="text"
							name="categoryId" value="<c:out value="${product.categoryId}" />" />
					</div>
					<div class="form-group">
						<label>Name</label> <input class="form-control" type="text"
							name="name" value="<c:out value="${product.name}" />" />
					</div>
					<div class="form-group">
						<label>Code</label> <input class="form-control" type="text"
							name="code" value="<c:out value="${product.code}" />" />
					</div>
					<div class="form-group">
						<label>Quantity</label> <input class="form-control" type="text"
							name="quantity" value="<c:out value="${product.quantity}" />" />
					</div>
					<div class="form-group">
						<label>Price</label> <input class="form-control" type="text"
							name="price" value="<c:out value="${product.price}" />" />
					</div>
					<div class="form-group">
						<label>Description</label> <input class="form-control" type="text"
							name="description" value="<c:out value="${product.description}" />" />
					</div>
					<div class="form-group">
						<label>Image</label> <input class="form-control" type="text"
							name="image" value="<c:out value="${product.image}" />" />
					</div>
					<div class="form-group">
						<label>Size</label> <input class="form-control" type="text"
							name="size" value="<c:out value="${product.size}" />" />
					</div>
					
					<div class="form-group">
						<button type="submit" class="btn btn-success btn-lg">Save</button>
						<a class="btn btn-danger btn-lg"
							href="<%=request.getContextPath()%>/product-manager?action=search&page=1" >Cancel</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>

<%@include file="footer.jsp"%>