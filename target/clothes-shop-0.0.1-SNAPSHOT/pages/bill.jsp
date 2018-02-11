<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Bill Manager</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<div class=" row">

	<div class="col-lg-12">

		<div class="panel panel-primary ">
			<div class="panel-heading">Search Infomation</div>
			<div class="panel-body ">
				<div class="row justify-content-md-center">
					<form bill="form" method="POST" action='bill-manager?action=search'
						name="frmSearchbill">
						<div class="col-md-4">
							<div class="form-group">
								<label>Customer Id</label> <input class="form-control"
									type="text" name="customerId"
									value="<c:out value="${bill.customerId}" />" />

							</div>
						</div>


						<div class="col-md-4">
							<div class="form-group">
								<label> Bill Date</label>
								<div class="input-group date datetimepicker">
									<input type="date" class="form-control" name="billDate"
										value="<c:out value="${bill.billDate}" />" /> <span
										class="input-group-addon"> <span
										class="glyphicon glyphicon-calendar"></span>
									</span>
								</div>

							</div>
						</div>

						<div class="col-md-4">
							<div class="form-group">
								<label> Sum</label> <input class="form-control" type="text"
									name="sum" value="<c:out value="${bill.sum}" />" />

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
						href="<%=request.getContextPath()%>/bill-manager?action=insert"
						bill="button"><i class="fa fa-plus" aria-hidden="true"></i>
						Add New</a>
				</div>
			</div>
			<div class="panel-body">
				<div class="table-responsive">

					<table class="table table-hover">
						<thead>
							<tr><th>Bill Id</th>
								<th>Customer Id</th>
								<th>Bill Date</th>
								<th>Sum</th>
								<th style="text-align: center">Action</th>
							</tr>
						</thead>
						<c:forEach items="${bills}" var="bill">
							<tbody>
								<tr>
									<td><c:out value="${bill.billId }"></c:out></td>
									<td><c:out value="${bill.customerId }"></c:out></td>
									<td><c:out value="${bill.billDate }"></c:out></td>
									<td><c:out value="${bill.sum }"></c:out></td>
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
									href="<%=request.getContextPath()%>/bill-manager?action=search&page=<c:out value ='${i}'/>">
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