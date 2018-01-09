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

				<button type="button" class="btn btn-primary" >
					<i class="fa fa-plus" aria-hidden="true"></i> Add New
				</button>
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
						
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>

<%@include file="footer.jsp"%>