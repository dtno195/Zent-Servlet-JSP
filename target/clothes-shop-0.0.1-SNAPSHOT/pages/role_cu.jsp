<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Role Create & Update</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<div class="row">

	<div class="col-lg-12">
		<div class="panel panel-primary">
			<div class="panel-heading">Add New Information</div>
			<div class="panel-body">
				<form role="form" method="POST" action='role-manager?action=save'
					name="frmAddRole">
					<div class="form-group">
						<label>Role Id</label> <input class="form-control" type="text"
							readonly name="id" value="<c:out value="${role.id}" />" />
					</div>
					<div class="form-group">
						<label>Name</label> <input class="form-control" type="text"
							name="name" value="<c:out value="${role.name}" />" />
					</div>
					<div class="form-group">
						<label>Description</label> <input class="form-control" type="text"
							name="description" value="<c:out value="${role.description}" />" />
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-success btn-lg">Save</button>
						<a class="btn btn-danger btn-lg"
							href="<%=request.getContextPath()%>/role-manager?action=search&page=1" >Cancel</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>

<%@include file="footer.jsp"%>