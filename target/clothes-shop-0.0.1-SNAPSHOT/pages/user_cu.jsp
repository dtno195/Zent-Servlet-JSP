<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">User Create & Update</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<div class="row">

	<div class="col-lg-12">
		<div class="panel panel-primary">
			<div class="panel-heading">Add New Information</div>
			<div class="panel-body">
				<form user="form" method="POST" action='user-manager?action=save'
					name="frmAdduser">
					<div class="form-group">
						<label>User Id</label> <input class="form-control" type="text"
							readonly name="id" value="<c:out value="${user.userId}" />" />
					</div>
					<div class="form-group">
						<label>Username</label> <input class="form-control" type="text"
							name="username" value="<c:out value="${user.username}" />" />
					</div>
					<div class="form-group">
						<label>Password</label> <input class="form-control" type="password"
							name="password" value="<c:out value="${user.password}" />" />
					</div>
					<div class="form-group">
						<label>Full Name</label> <input class="form-control" type="text"
							name="fullName" value="<c:out value="${user.fullName}" />" />
					</div>
					<div class="form-group">
						<label>Role Id</label> <input class="form-control" type="text"
							name="roleId" value="<c:out value="${user.roleId}" />" />
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-success btn-lg">Save</button>
						<a class="btn btn-danger btn-lg"
							href="<%=request.getContextPath()%>/user-manager?action=search&page=1" >Cancel</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>

<%@include file="footer.jsp"%>