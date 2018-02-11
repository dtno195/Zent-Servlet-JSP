<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>

<div class="content">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="card">
					<div class="card-header" data-background-color="purple">
						<h4 class="title">Edit</h4>
						<p class="product">Complete your profile</p>
					</div>
					<div class="card-content">
						<form method="POST" action='product-manager?action=save'
							name="frmAddproduct" >
							<div class="row">
								<div class="col-md-12">
									<div class="form-group label-floating">
										<label class="control-label">Product Id</label> <input
											type="text" class="form-control" name="id" readonly
											value="<c:out value="${product.productId}" />">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group label-floating">
										<label class="control-label">Category Id</label>
										<%-- <input
											type="text" class="form-control" name="categoryId"
											value="<c:out value="${product.categoryId}" />"> --%>
										<select class="form-control" id="exampleFormControlSelect1"
											name="categoryId">
											<c:forEach items="${categoryP}" var="category">
												<option>
													<c:out value="${category.name }"></c:out>
												</option>
											</c:forEach>
										</select>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group label-floating">
										<label class="control-label">Name</label> <input type="text"
											class="form-control" name="name"
											value="<c:out value="${product.name}" />">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group label-floating">
										<label class="control-label">Code</label> <input type="text"
											class="form-control" name="code"
											value="<c:out value="${product.code}" />">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group label-floating">
										<label class="control-label">Quantity</label> <input
											type="text" class="form-control" name="quantity"
											value="<c:out value="${product.quantity}" />">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group label-floating">
										<label class="control-label">Price</label> <input type="text"
											class="form-control" name="price"
											value="<c:out value="${product.price}" />">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group label-floating">
										<label>Description</label>
										<textarea rows="5" cols="" class="form-control text-tip"
											id="editor<c:out value="${product.description}" />"
											name="description"> 
												<c:out value="${product.description}" />
											</textarea>
									</div>
								</div>
							</div>


							<div class="row">
								<div class="col-md-12">
									<div class="">
										<label class="control-label">image</label> <input type="file"
											class="" name="image"
											value="<c:out value="${product.image}" />">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group label-floating">
										<label class="control-label">size</label> <input type="text"
											class="form-control" name="size"
											value="<c:out value="${product.size}" />">
									</div>
								</div>
							</div>


							<a class="btn btn-rose pull-right"
								href="<%=request.getContextPath()%>/product-manager?action=search&page=1">Cancel</a>
							<button type="submit" class="btn btn-success pull-right">Save</button>
							<div class="clearfix"></div>
						</form>
					</div>
				</div>
			</div>

		</div>
	</div>
</div>

<script>
	CKEDITOR.replace('editor');
	$(document).ready(function() {
		for (var i = 0; i < $('.text-tip').length; i++) {
			var x = $('.text-tip').children()[i].id;
			var instance = CKEDITOR.instances[x];

			if (instance) {
				CKEDITOR.remove(instance)
			}
			CKEDITOR.replace($('.text-tip').children()[i].id);
		}
	})
</script>
<%@include file="footer.jsp"%>
