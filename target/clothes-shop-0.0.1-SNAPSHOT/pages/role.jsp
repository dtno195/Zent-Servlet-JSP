<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Role Manager</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<div class=" row">
	
	<div class="col-lg-12">
		<div class="panel panel-primary ">
			<div class="panel-heading">Search Infomation</div>
			<div class="panel-body ">
				<div class="row justify-content-md-center">
					<form role="form" method="POST" action='role-manager?action=search'
						name="frmSearchRole">
						<div class="col-md-6">
							<div class="form-group">
								<label> Name</label> <input class="form-control" type="text"
									name="name" value="<c:out value="${role.name}" />" />

							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label> Description</label> <input class="form-control"
									type="text" name="description"
									value="<c:out value="${role.description}" />" />

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
						href="<%=request.getContextPath()%>/role-manager?action=insert"
						role="button"><i class="fa fa-plus" aria-hidden="true"></i>
						Add New</a>
				</div>
			</div>
			<div class="panel-body">
				<div class="table-responsive">

					<table class="table table-hover">
						<thead>
							<tr>
								<th>Role Id</th>
								<th>Name</th>
								<th>Description</th>
								<th style="text-align: center">Action</th>
							</tr>
						</thead>
						<c:forEach items="${roles}" var="role">
							<tbody>
								<tr>
									<td><c:out value="${role.id }"></c:out></td>
									<td><c:out value="${role.name }"></c:out></td>
									<td><c:out value="${role.description }"></c:out></td>
									<td><a class="btn btn-md btn-info"
										href="<%=request.getContextPath() %>/role-manager?action=edit&id=<c:out value="${role.id }"></c:out>"
										role="button"><i class="fa fa-pencil-square-o"></i>&nbsp;
											Edit</a></td>
									<td><a
										onclick="return confirm('Bạn có chắc chắn muốn xóa?')"
										class="btn btn-md btn-danger"
										href="<%=request.getContextPath() %>/role-manager?action=delete&id=<c:out value="${role.id }"></c:out>"
										role="button"><i class="fa fa-trash"></i>&nbsp;Delete</a></td>


								</tr>
							</tbody>
						</c:forEach>
					</table>
					<!-- /.table-responsive -->
					<hr>
					<div class=" col-md-4 ">
						<ul class="pagination pagination-lg ">
							<c:forEach var="i" begin="1" end="${count}">
								<li
									class="<%=(request.getParameter("page") != null && Integer
						.parseInt(request.getParameter("page")) == ((Long) request.getAttribute("count")).intValue()
								? "active"
								: "")%>"><a
									href="<%=request.getContextPath()%>/role-manager?action=search&page=<c:out value ='${i}'/>">
										<c:out value="${i}" />
								</a></li>
							</c:forEach>

						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
	$(document).ready(function() {
		$('.pagination li').click(function() {
			$(".active").removeClass("active");
			$(this).addClass("active");
		});
	});
	$(document).ready(function() {
		$("#btnSearch").click(function(){
			$("#searchToggle").toggle();
		});
	});
</script>

<%@include file="footer.jsp"%>
