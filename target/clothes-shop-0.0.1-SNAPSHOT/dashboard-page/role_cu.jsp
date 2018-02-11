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
						<form method="POST" action='role-manager?action=save'
					name="frmAddrole">
							<div class="row">
								<div class="col-md-12">
									<div class="form-group label-floating">
										<label class="control-label">Role Id</label> <input
											type="text" class="form-control" name="id" readonly value="<c:out value="${role.id}" />">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group label-floating">
										<label class="control-label">Name</label> <input
											type="text" class="form-control" name="name" value="<c:out value="${role.name}" />" >
									</div>
								</div>
							</div>
							
							<div class="row">
								<div class="col-md-12">
									<div class="form-group label-floating">
										<label class="control-label">Description</label> <input
											type="text" class="form-control" name="description" value="<c:out value="${role.description}" />" >
									</div>
								</div>
							</div>
							
							
							<a class="btn btn-rose pull-right"
							href="<%=request.getContextPath()%>/role-manager?action=search&page=1" >Cancel</a>
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
