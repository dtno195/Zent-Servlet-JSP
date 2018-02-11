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
							action='bill-manager?action=search' name="frmSearchuser">

							<div class="row">
								<div class="col-md-3">
									<div class="form-group label-floating">
										<label class="control-label">Bill Id</label> <input
											class="form-control" type="text" name="billId"
											value="<c:out value="${bill.billId}" />" />
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group label-floating">
										<label class="control-label">Customer Id</label> <input
											class="form-control" type="text" name="customerId"
											value="<c:out value="${bill.customerId}" />" />
									</div>
								</div>
								<div class="col-md-3">
									<%-- <div class="form-group label-floating">
										<label class="control-label">Bill Date</label> <input
											class="form-control" type="text" name="billDate"
											value="<c:out value="${bill.billDate}" />" />
									</div> --%>
									<div class="form-group label-floating">
										<label class="control-label">Bill Date</label> <input
											type="text" class="form-control datetimepicker"
											value="<c:out value="${bill.billDate}" />" />
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group label-floating">
										<label class="control-label">Sum</label> <input
											class="form-control" type="text" name="sum"
											value="<c:out value="${bill.sum}" />" />
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
						<h4 class="title">Bill Manager</h4>
						<a class="btn  btn-round btn-info"
							href="<%=request.getContextPath()%>/bill-manager?action=insert">
							<i class="material-icons">add</i> Add
						</a>
						<button class="btn btn-warning btn-round" id="btnSearch">
							<i class="material-icons">search</i>Search
						</button>
					</div>
					<div class="card-content table-responsive">
						<table class="table">
							<thead class="text-primary">
								<th>Bill Id</th>
								<th>Customer Id</th>
								<th>Bill Date</th>
								<th>Sum</th>
								<th style="text-align: center" colspan=2>Action</th>
							</thead>
							<c:forEach items="${bills}" var="bill">
								<tbody>
									<tr>
										<td><c:out value="${bill.billId}"></c:out></td>
										<td><c:out value="${bill.customerId}"></c:out></td>
										<td><c:out value="${bill.billDate}"></c:out></td>
										<td><c:out value="${bill.sum}"></c:out></td>
										<td><a class="btn btn-md btn-info"
											href="<%=request.getContextPath() %>/bill-manager?action=edit&id=<c:out value="${bill.billId }"></c:out>"
											bill="button"><i class="fa fa-pencil-square-o"></i>&nbsp;
												Edit</a></td>
										<td><a
											onclick="return confirm('Bạn có chắc chắn muốn xóa?')"
											class="btn btn-md btn-danger"
											href="<%=request.getContextPath() %>/bill-manager?action=delete&id=<c:out value="${bill.billId }"></c:out>"
											bill="button"><i class="fa fa-trash"></i>&nbsp;Delete</a></td>
									</tr>
								</tbody>
							</c:forEach>
						</table>
					</div>

				</div>
				<nav aria-label="Page navigation example">
					<ul class="pagination justify-content-center">
						<li class="page-item disabled"><a class="page-link" href="#"
							tabindex="-1">Previous</a></li>
						<li class="page-item"><a class="page-link" href="#">1</a></li>
						<li class="page-item active"><a class="page-link" href="#">2
								<span class="sr-only">(current)</span>
						</a></li>
						<li class="page-item"><a class="page-link" href="#">3</a></li>
						<li class="page-item"><a class="page-link" href="#">Next</a>
						</li>
					</ul>
				</nav>
			</div>

		</div>
	</div>
</div>
<script>
	$(document).ready(function() {
		$(".pagination li").click(function() {
			$(".active").removeClass("active");
			$(this).addClass("active");
		});
	});
	$(document).ready(function() {
		$("#btnSearch").click(function() {
			$("#searchToggle").toggle();
		});
	});
	$(document).ready(function() {
		$(".datetimepicker").datetimepicker({
		    icons: {
		        time: "fa fa-clock-o",
		        date: "fa fa-calendar",
		        up: "fa fa-chevron-up",
		        down: "fa fa-chevron-down",
		        previous: 'fa fa-chevron-left',
		        next: 'fa fa-chevron-right',
		        today: 'fa fa-screenshot',
		        clear: 'fa fa-trash',
		        close: 'fa fa-remove'
		    }
		});
	});
	
</script>
<%@include file="footer.jsp"%>
