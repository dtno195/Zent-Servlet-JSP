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
						<form method="POST" action='user-manager?action=save'
							name="frmAdduser">
							<div class="row">
								<div class="col-md-12">
									<div class="form-group label-floating">
										<label class="control-label">User Id</label> <input
											type="text" class="form-control" name="id" readonly
											value="<c:out value="${user.userId}" />">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group label-floating">
										<label class="control-label">User Name</label> <input
											type="text" class="form-control" name="username"
											value="<c:out value="${user.username}" />">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group label-floating">
										<label class="control-label">Password</label> <input
											type="password" name="password" class="form-control"
											value="<c:out value="${user.password}" />">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group label-floating">
										<label class="control-label">Full Name</label> <input
											type="text" class="form-control" name="fullName"
											value="<c:out value="${user.fullName}" />">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group label-floating">
										<label class="control-label">Role Id</label>
								
										<select class="form-control" id="exampleFormControlSelect1" name="roleId">
											<c:forEach items="${listRole}" var="role" >
												<option >
													<c:out value="${role.name }"></c:out>
												</option>
											</c:forEach>
										</select>




									</div>
								</div>
							</div>

							<a class="btn btn-rose pull-right"
								href="<%=request.getContextPath()%>/user-manager?action=search&page=1">Cancel</a>
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
