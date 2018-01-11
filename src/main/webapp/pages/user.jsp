<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">User Manager</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<div class="row">

	<div class="col-lg-12">

		<div class="panel panel-primary ">
			<div class="panel-heading">Search Infomation</div>
			<div class="panel-body ">
				<div class="row justify-content-md-center">
					<form role="form" method="POST" action='user-manager?action=search'
						name="frmSearchUser">
						<div class="col-md-4">
							<div class="form-group">
								<label> Username</label> <input class="form-control" type="text"
									name="name" value="<c:out value="${user.username}" />" />

							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label> Full Name</label> <input class="form-control"
									type="text" name="description"
									value="<c:out value="${user.fullName}" />" />

							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label> Role Name</label> <input class="form-control"
									type="text" name="description"
									value="<c:out value="${user.roleId}" />" />
							</div>
						</div>
						<div class="col-md-4 ">
							<div class="form-group">
								<button type="submit" class="btn btn-primary btn-md">Tìm
									kiếm</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="panel panel-primary">
			<div class="panel-heading">
				<div>
					<a class="btn btn-md btn-success"
						href="<%=request.getContextPath()%>/user-manager?action=insert"
						role="button"><i class="fa fa-plus" aria-hidden="true"></i>
						Add New</a>
				</div>
			</div>
			<div class="panel-body">
				<div class="table-responsive">

					<table class="table table-striped">
						<thead>
							<tr>
								<th>User Id</th>
								<th>Username</th>
								<th>Password</th>
								<th>Full Name</th>
								<th>Role Id</th>
								<th colspan=3 style="text-align: center">Action</th>
							</tr>
						</thead>
						<c:forEach items="${users}" var="user">
							<tbody>
								<tr>
									<td><c:out value="${user.userId }"></c:out></td>
									<td><c:out value="${user.username }"></c:out></td>
									<td><c:out value="${user.password }"></c:out></td>
									<td><c:out value="${user.fullName }"></c:out></td>
									<td><c:out value="${user.roleId }"></c:out></td>
									<td><a class="btn btn-md btn-info"
										href="<%=request.getContextPath() %>/user-manager?action=edit&id=<c:out value="${user.userId }"></c:out>"
										role="button"><i class="fa fa-pencil-square-o"></i>&nbsp;
											Edit</a></td>
									<td><a class="btn btn-md btn-danger"
										href="<%=request.getContextPath() %>/user-manager?action=delete&id=<c:out value="${user.userId }"></c:out>"
										role="button"><i class="fa fa-trash"></i>&nbsp;Delete</a></td>
									<td><a class="btn btn-md btn-danger" href="" role="button"><i
											class="fa fa-wrench"></i>&nbsp;Update Role</a></td>
								</tr>
							</tbody>
						</c:forEach>

					</table>
				</div>
			</div>
		</div>
	</div>
</div>

<%@include file="footer.jsp"%>