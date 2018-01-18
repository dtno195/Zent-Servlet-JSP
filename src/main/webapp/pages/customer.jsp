<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Customer Manager</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<div class=" row">

	<div class="col-lg-12">

		<div class="panel panel-primary ">
			<div class="panel-heading">Search Infomation</div>
			<div class="panel-body ">
				<div class="row justify-content-md-center">
					<form customer="form" method="POST"
						action='customer-manager?action=search' name="frmSearchcustomer">
						<div class="col-md-4">
							<div class="form-group">
								<label>Customer Name</label> <input class="form-control"
									type="text" name="name"
									value="<c:out value="${customer.name}" />" />

							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label> Address</label> <input class="form-control" type="text"
									name="address" value="<c:out value="${customer.address}" />" />

							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label> Phone</label> <input class="form-control" type="text"
									name="phone" value="<c:out value="${customer.phone}" />" />

							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label> Email</label> <input class="form-control" type="text"
									name="email" value="<c:out value="${customer.email}" />" />

							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label>Giới tính</label> <label class="radio-inline"> <input
									type="radio" name="gender" value="1"
									<c:out value="${customer.gender eq 1?'checked':''}"/>>Nam
								</label> <label class="radio-inline"> <input type="radio"
									name="gender" value="0"
									<c:out value="${customer.gender eq 0?'checked':''}"/>>Nữ
								</label>
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label> Birthday</label>
								<div class="input-group date datetimepicker">
									<input type="date" class="form-control" name="birthday"
										value="<c:out value="${customer.birth}" />" /> <span
										class="input-group-addon"> <span
										class="glyphicon glyphicon-calendar"></span>
									</span>
								</div>

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
						href="<%=request.getContextPath()%>/customer-manager?action=insert"
						customer="button"><i class="fa fa-plus" aria-hidden="true"></i>
						Add New</a>
				</div>
			</div>
			<div class="panel-body">
				<div class="table-responsive">

					<table class="table table-hover">
						<thead>
							<tr>
								<th>Customer Id</th>
								<th>Name</th>
								<th>Address</th>
								<th>Phone</th>
								<th>Email</th>
								<th>Gender</th>
								<th>Birthday</th>
								<th style="text-align: center">Action</th>
							</tr>
						</thead>
						<c:forEach items="${customers}" var="customer">
							<tbody>
								<tr>
									<td><c:out value="${customer.customerId }"></c:out></td>
									<td><c:out value="${customer.name }"></c:out></td>
									<td><c:out value="${customer.address }"></c:out></td>
									<td><c:out value="${customer.phone }"></c:out></td>
									<td><c:out value="${customer.email }"></c:out></td>
									<td><c:if test="${user.gender eq 1}">
											Nam
										</c:if> <c:if test="${user.gender ne 1}">
											Nữ
										</c:if></td>
									<td><c:out value="${customer.birthday }"></c:out></td>
									<td><a class="btn btn-md btn-info"
										href="<%=request.getContextPath() %>/customer-manager?action=edit&id=<c:out value="${customer.customerId }"></c:out>"
										customer="button"><i class="fa fa-pencil-square-o"></i>&nbsp;
											Edit</a></td>
									<td><a
										onclick="return confirm('Bạn có chắc chắn muốn xóa?')"
										class="btn btn-md btn-danger"
										href="<%=request.getContextPath() %>/customer-manager?action=delete&id=<c:out value="${customer.customerId }"></c:out>"
										customer="button"><i class="fa fa-trash"></i>&nbsp;Delete</a></td>


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
									href="<%=request.getContextPath()%>/customer-manager?action=search&page=<c:out value ='${i}'/>">
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

<%@include file="footer.jsp"%>
<script>
	$(document).ready(function() {
		$('.pagination li').click(function() {
			$(".active").removeClass("active");
			$(this).addClass("active");
		});
	});
</script>