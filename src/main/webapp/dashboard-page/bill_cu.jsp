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
						<p class="category">Complete your profile</p>
					</div>
					<div class="card-content">
						<form method="POST" action='bill-manager?action=save'
					name="frmAddbill">
							<div class="row">
								<div class="col-md-12">
									<div class="form-group label-floating">
										<label class="control-label">Bill Id</label> <input
											type="text" class="form-control" name="id" readonly value="<c:out value="${bill.id}" />">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group label-floating">
										<label class="control-label">Customer Id</label> <input
											type="text" class="form-control" name="customerId" value="<c:out value="${bill.customerId}" />" >
									</div>
								</div>
							</div>
							
							<div class="row">
								<div class="col-md-12">
									<div class="form-group label-floating">
										<label class="control-label">Bill Date</label> <input
											type="text" class="form-control" name="billDate" value="<c:out value="${bill.billDate}" />" >
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group label-floating">
										<label class="control-label">Sum</label> <input
											type="text" class="form-control" name="sum" value="<c:out value="${bill.sum}" />" >
									</div>
								</div>
							</div>
							
							
							<a class="btn btn-rose pull-right"
							href="<%=request.getContextPath()%>/bill-manager?action=search&page=1" >Cancel</a>
							<button type="submit" class="btn btn-success pull-right">Save</button>
							<div class="clearfix"></div>
						</form>
					</div>
				</div>
			</div>

		</div>
	</div>
</div>
<%@include file="footer.jsp"%>
