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
						<form user="form" method="POST"
							action='customer-manager?action=search' name="frmSearchuser">

							<div class="row">
								<div class="col-md-3">
									<div class="form-group label-floating">
										<label class="control-label">Customer Name</label> <input
											class="form-control" type="text" name="name"
											value="<c:out value="${customer.name}" />" />
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group label-floating">
										<label class="control-label">Address</label> <input
											class="form-control" type="text" name="address"
											value="<c:out value="${customer.address}" />" />
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group label-floating">
										<label class="control-label">Phone</label> <input
											class="form-control" type="text" name="phone"
											value="<c:out value="${customer.phone}" />" />
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group label-floating">
										<label class="control-label">Email</label> <input
											class="form-control" type="text" name="email"
											value="<c:out value="${customer.email}" />" />
									</div>
								</div>

								<div class="col-md-3">
									<div class="form-group label-floating">
										<label class="control-label">Date</label> <input
											class="form-control" type="text" name="date"
											value="<c:out value="${customer.date}" />" />
									</div>
								</div>
							</div>

							<button type="submit" class="btn btn-primary pull-right">Search
								Infomation</button>
							<div class="clearfix"></div>
						</form>
					</div>
				</div>
			</div>
			<div class="col-md-12">
				<div class="card">
					<div class="card-header" data-background-color="purple">
						<h4 class="title">customer Manager</h4>
						<a class="btn  btn-round btn-info"
							href="<%=request.getContextPath()%>/customer-manager?action=insert">
							<i class="material-icons">add</i> Add
						</a>
						<button class="btn btn-warning btn-round" id="btnSearch">
							<i class="material-icons">search</i>Search
						</button>
					</div>
					<div class="card-content table-responsive">
						<table class="table">
							<thead class="text-primary">
								<th>Customer Id</th>
								<th>Name</th>
								<th>Address</th>
								<th>Phone</th>
								<th>Email</th>
								<th>Date</th>
							</thead>
							<c:forEach items="${customers}" var="customer">
								<tbody>
									<tr>
										<td><c:out value="${customer.customerId }"></c:out></td>
										<td><c:out value="${customer.name }"></c:out></td>
										<td><c:out value="${customer.address }"></c:out></td>
										<td><c:out value="${customer.phone }"></c:out></td>
										<td><c:out value="${customer.email }"></c:out></td>
										<td><c:out value="${customer.date }"></c:out></td>
									</tr>
								</tbody>
							</c:forEach>
						</table>
					</div>

				</div>
				<nav aria-label="...">
					<ul class="pagination pagination-lg pageeco">

						<c:forEach var="i" begin="1" end="${count}">
							<li
								class="pageClick <%=(request.getParameter("page") != null && Integer
						.parseInt(request.getParameter("page")) == ((Long) request.getAttribute("count")).intValue()
								? "active"
								: "")%>  "><a
								href="<%=request.getContextPath()%>/product-manager?action=search&page=<c:out value ='${i}'/>">
									<c:out value="${i}" />
							</a></li>
						</c:forEach>
						<c:set var="pageIndex" value="${pageNumber}" scope="session" />
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
		$("#btnSearch").click(function() {
			$("#searchToggle").toggle();
		});
	});
</script>
<%@include file="footer.jsp"%>
