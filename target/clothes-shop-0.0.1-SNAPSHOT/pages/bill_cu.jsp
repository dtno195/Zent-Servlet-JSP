<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Bill Create & Update</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<div class="row">

	<div class="col-lg-12">
		<div class="panel panel-primary">
			<div class="panel-heading">Add New Information</div>
			<div class="panel-body">
				<form bill="form" method="POST" action='bill-manager?action=save'
					name="frmAddbill">
					<div class="form-group">
						<label>Bill Id</label> <input class="form-control" type="text"
							readonly name="id" value="<c:out value="${bill.billId}" />" />
					</div>
					<div class="form-group">
						<label>Customer Id</label> <input class="form-control" type="text"
							name="customerId"  value="<c:out value="${bill.customerId}" />" />
					</div>
					<div class="form-group">
						<div class="input-group date datetimepicker">
								<input type="date" class="form-control" id="billDate" name="billDate" value="<c:out value="${bill.billDate}" />" />
								<span class="input-group-addon"> <span
									class="glyphicon glyphicon-calendar"></span>
								</span>
							</div>
					</div>
					<div class="form-group">
						<label>Sum</label> <input class="form-control" type="text"
							name="sum" value="<c:out value="${bill.sum}" />" />
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-success btn-lg">Save</button>
						<a class="btn btn-danger btn-lg"
							href="<%=request.getContextPath()%>/bill-manager?action=search&page=1" >Cancel</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>

<%@include file="footer.jsp"%>