<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IT16306-List Order</title>
<link rel="stylesheet"
	href="/su22_SOF3021_IT16306/css/bootstrap.min.css" />
</head>
<body>
	<c:if test="${!empty sessionScope.error }">
		<div class=" alert alert-danger">${ sessionScope.error }</div>

		<c:remove var="error" scope="session" />
	</c:if>

	<c:if test="${!empty sessionScope.message }">
		<div class=" alert alert-success">${ sessionScope.message }</div>
		<c:remove var="message" scope="session" />
	</c:if>
	<c:if test="${ empty data }">
		<p class="alert alert-warning">Không có dữ liệu</p>
	</c:if>
	<c:if test="${ !empty data }"></c:if>
	<!-- <div class="row m-2">
		<a href="/su22_SOF3021_IT16306/admin/order/create"
			class=" btn btn-primary"> Thêm </a>
	</div> -->
	<form:form method="POST"
		action="/su22_SOF3021_IT16306/admin/order/store"
		modelAttribute="order">
		<section class="vh-70" style="background-color: #508bfc;">
			<div class=" py-5 h-100">
				<div
					class="row d-flex justify-content-center align-items-center h-100">
					<div class="col-12 col-md-8 col-lg-6 col-xl-5">
						<div class="card shadow-2-strong" style="border-radius: 1rem;">
							<div class="card-body p-5 text-center">
								<div> 
									<label class="form-label">Account_id</label>
									<form:select path="user_id" class="form-control form-control-lg" >
										<form:options itemLabel="username" itemValue="id"
											items="${acc}" />
									</form:select>
								</div>

								<div>
									<label class="form-label" >Ngày</label>
									<form:input path="create_date" class="form-control form-control-lg"  type="date" />
								</div>

								<div>
									<label class="form-label" >Địa chỉ</label>
									<form:input path="address" class="form-control form-control-lg" />
								</div>

								<button class="btn btn-primary btn-lg btn-block m-2">Thêm mới</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</form:form>
	<table class="table table-secondary m-2">
		<thead>
			<tr>
				<th>ID</th>
				<th>User_id</th>
				<th>Date</th>
				<th>Địa chỉ</th>
				<th colspan="2">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ data.content }" var="order">
				<tr>
					<td>${ order.id }</td>
					<td>${ order.user_id.username }</td>
					<td>${ order.create_date }</td>
					<td>${ order.address }</td>



					<td><a
						href="/su22_SOF3021_IT16306/admin/order/edit/${order.id}"
						class="btn btn-primary">Update</a></td>

					<td>
						<button type="button" class="btn btn-danger"
							data-bs-toggle="modal" data-bs-target="#exampleModal">Delete</button>
						<div class="modal fade" id="exampleModal" tabindex="-1"
							aria-labelledby="exampleModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">Message</h5>
										<button type="button" class="btn-close"
											data-bs-dismiss="modal" aria-label="Close"></button>
									</div>
									<div class="modal-body">Bạn có muốn xóa không ?</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-bs-dismiss="modal">Close</button>
										<a class="btn btn-danger"
											href="/su22_SOF3021_IT16306/admin/order/delete/${order.id}">Xóa</a>
									</div>
								</div>
							</div>
						</div>

					</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>


	<div class="row m-2">
		<ul class="pagination">
			<c:forEach var="i" begin="0" end="${ data.totalPages - 1 }">
				<li class="page-item"><a class="page-link"
					href="/su22_SOF3021_IT16306/admin/order/index?page=${ i }"> ${ i + 1 }
				</a></li>
			</c:forEach>
		</ul>
	</div>

	<script src="/su22_SOF3021_IT16306/js/jquery.min.js"></script>
	<script src="/su22_SOF3021_IT16306/js/popper.min.js"></script>
	<script src="/su22_SOF3021_IT16306/js/bootstrap.min.js"></script>
</body>
</html>