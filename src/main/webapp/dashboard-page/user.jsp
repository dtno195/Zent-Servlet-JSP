<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<div class="content">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12" id="searchToggle" style="display: none">
				<div class="card">
					<div class="card-header" data-background-color="purple">
						<h4 class="title">Search</h4>
					</div>
					<div class="card-content">
						<form user="form" method="POST" action='user-manager?action=search'
						name="frmSearchuser">

							<div class="row">
								<div class="col-md-4">
									<div class="form-group label-floating">
										<label class="control-label">Username</label> <input class="form-control" type="text"
									name="username" value="<c:out value="${user.username}" />" />
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group label-floating">
										<label class="control-label">Full Name</label> <input class="form-control"
									type="text" name="fullName"
									value="<c:out value="${user.fullName}" />" />
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group label-floating">
										<label class="control-label">Role Id</label> <input class="form-control" type="text"
									name="roleId" value="<c:out value="${user.roleId}" />" />
									</div>
								</div>
							</div>

							<button type="submit" class="btn btn-primary pull-right">Search Infomation</button>
							<div class="clearfix"></div>
						</form>
					</div>
				</div>
			</div>
			<div class="col-md-12">
				<div class="card">
					<div class="card-header" data-background-color="purple">
						<h4 class="title">User Manager</h4>
						<a class="btn  btn-round btn-info"
							href="<%=request.getContextPath()%>/user-manager?action=insert">
							<i class="material-icons">add</i> Add
						</a>
						<button class="btn btn-warning btn-round" id="btnSearch" >
							<i class="material-icons">search</i>Search
						</button>
					</div>
					<div class="card-content table-responsive">
						<table class="table">
							<thead class="text-primary">
								<th>User Id</th>
								<th>Username</th>
								<th>Password</th>
								<th>Full Name</th>
								<th>Role</th>
								<th style="text-align: center" colspan=2>Action</th>
							</thead>
							<c:forEach items="${listUser}" var="user">

								<tbody>
									<tr>
										<td><c:out value="${user.userId }"></c:out></td>
										<td><c:out value="${user.username }"></c:out></td>
										<td><c:out value="${user.password }"></c:out></td>
										<td><c:out value="${user.fullName }"></c:out></td>
										<td><c:forEach items="${listRole}" var="role">
												<c:if test="${user.roleId eq role.id}">
													<c:out value="${role.name }"></c:out>
												</c:if>
											</c:forEach></td>
										<td><a class="btn btn-md btn-info"
											href="<%=request.getContextPath() %>/user-manager?action=edit&id=<c:out value="${user.userId }"></c:out>"
											user="button"><i class="fa fa-pencil-square-o"></i>&nbsp;
												Edit</a></td>
										<td><a
											onclick="return confirm('Bạn có chắc chắn muốn xóa?')"
											class="btn btn-md btn-danger"
											href="<%=request.getContextPath() %>/user-manager?action=delete&id=<c:out value="${user.userId }"></c:out>"
											user="button"><i class="fa fa-trash"></i>&nbsp;Delete</a></td>
									</tr>
								</tbody>
							</c:forEach>
						</table>
					</div>

				</div>
				<nav aria-label="...">
					<ul class="pagination pagination-lg">

						<c:forEach var="i" begin="1" end="${count}">
							<li
								class="<%=(request.getParameter("page") != null && Integer
						.parseInt(request.getParameter("page")) == ((Long) request.getAttribute("count")).intValue()
								? "active"
								: "")%>"><a
								href="<%=request.getContextPath()%>/user-manager?action=search&page=<c:out value ='${i}'/>">
									<c:out value="${i}" />
							</a></li>
						</c:forEach>

					</ul>
				</nav>
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
