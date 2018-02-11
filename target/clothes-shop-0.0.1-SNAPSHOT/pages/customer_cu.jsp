<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Customer Create & Update</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<div class="row">

	<div class="col-lg-12">
		<div class="panel panel-primary">
			<div class="panel-heading">Add New Information</div>
			<div class="panel-body">
				<form category="form" method="POST" action='customer-manager?action=save'
					name="frmAddcategory">
					<div class="form-group">
						<label>Customer Id</label> <input class="form-control" type="text"
							readonly name="id" value="<c:out value="${customer.customerId}" />" />
					</div>
					<div class="form-group">
						<label>Name</label> <input class="form-control" type="text"
							name="name" value="<c:out value="${customer.name}" />" />
					</div>
					<div class="form-group">
						<label>Address</label> <input class="form-control" type="text"
							name="address" value="<c:out value="${customer.address}" />" />
					</div>
					<div class="form-group">
						<label>Phone</label> <input class="form-control" type="text"
							name="phone" value="<c:out value="${customer.phone}" />" />
					</div>
					<div class="form-group">
						<label>Email</label> <input class="form-control" type="text"
							name="email" value="<c:out value="${customer.email}" />" />
					</div>
					<div class="form-group">
						<label>Giới tính</label> <label class="radio-inline"> <input
								type="radio" name="gender" value="1"
								<c:out value="${customer.gender eq 1?'checked':''}"/>>Nam
							</label> <label class="radio-inline"> <input type="radio"
								name="gender" value="0"
								<c:out value="${customer.gender eq 0?'checked':''}"/>>Nữ
							</label>
					</div>
					<div class="form-group">
						<div class="input-group date datetimepicker">
								<input type="date" class="form-control" name="birthday" value="<c:out value="${customer.birth}" />" />
								<span class="input-group-addon"> <span
									class="glyphicon glyphicon-calendar"></span>
								</span>
							</div>
					</div>
					
					<div class="form-group">
						<button type="submit" class="btn btn-success btn-lg">Save</button>
						<a class="btn btn-danger btn-lg"
							href="<%=request.getContextPath()%>/customer-manager?action=search&page=1" >Cancel</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>

<%@include file="footer.jsp"%>