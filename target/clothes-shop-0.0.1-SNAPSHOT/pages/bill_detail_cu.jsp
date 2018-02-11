<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Bill Detail Create & Update</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<div class="row">

	<div class="col-lg-12">
		<div class="panel panel-primary">
			<div class="panel-heading">Add New Information</div>
			<div class="panel-body">
				<form bill="form" method="POST" action='bill-detail-manager?action=save'
					name="frmAddbill">
					<div class="form-group">
						<label>Bill Detail Id</label> <input class="form-control" type="text"
							readonly name="id" value="<c:out value="${billDetail.billDetailId}" />" />
					</div>
					<div class="form-group">
						<label>Bill Id</label> <input class="form-control" type="text"
							name="billId"  value="<c:out value="${billDetail.billId}" />" />
					</div>
				
					<div class="form-group">
						<label>Product Id</label> <input class="form-control" type="text"
							name="productId" value="<c:out value="${billDetail.productId}" />" />
					</div>
					<div class="form-group">
						<label>Quantity</label> <input class="form-control" type="text"
							name="quantity" value="<c:out value="${billDetail.quantity}" />" />
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-success btn-lg">Save</button>
						<a class="btn btn-danger btn-lg"
							href="<%=request.getContextPath()%>/bill-detail-manager?action=search&page=1" >Cancel</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>

<%@include file="footer.jsp"%>