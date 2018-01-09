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
		<div class="panel panel-default">
			<div class="panel-heading">
				<a class="btn btn-md btn-success"
					href="<%=request.getContextPath() %>/UserController?action=insert" role="button"><i class="fa fa-plus" aria-hidden="true"></i> Add New</a>
				
			</div>
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table">
						<thead>
							<tr>
								<th>#</th>
								<th>First Name</th>
								<th>Last Name</th>
								<th>Username</th>
							</tr>
						</thead>
						<tbody>
							<tr class="success">
								<td>1</td>
								<td>Mark</td>
								<td>Otto</td>
								<td>@mdo</td>
							</tr>
							<tr class="info">
								<td>2</td>
								<td>Jacob</td>
								<td>Thornton</td>
								<td>@fat</td>
							</tr>
							<tr class="warning">
								<td>3</td>
								<td>Larry</td>
								<td>the Bird</td>
								<td>@twitter</td>
							</tr>
							<tr class="danger">
								<td>4</td>
								<td>John</td>
								<td>Smith</td>
								<td>@jsmith</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>

<%@include file="footer.jsp"%>