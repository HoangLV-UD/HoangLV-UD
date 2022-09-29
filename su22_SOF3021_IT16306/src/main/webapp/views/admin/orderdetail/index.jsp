<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IT16306-List Order Detail</title>
<link rel="stylesheet"
	href="/su22_SOF3021_IT16306/css/bootstrap.min.css">
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
		<a href="/su22_SOF3021_IT16306/admin/orderdetail/create"
			class=" btn btn-primary"> Thêm </a>
	</div> -->
	<form:form method="POST"
		action="/su22_SOF3021_IT16306/admin/orderdetail/store"
		modelAttribute="orderdetail">
		<section class="vh-70" style="background-color: #508bfc;">
			<div class=" py-5 h-100">
				<div
					class="row d-flex justify-content-center align-items-center h-100">
					<div class="col-12 col-md-8 col-lg-6 col-xl-5">
						<div class="card shadow-2-strong" style="border-radius: 1rem;">
							<div class="card-body p-5 text-center">

								<div>
									<label class="form-label">Địa Chỉ</label>
									<form:select path="order_id" class="form-control form-control-lg">
										<form:options itemLabel="address" itemValue="id"
											items="${oder}" />
									</form:select>
								</div>

								<div>
									<label class="form-label">Loại Sản Phẩm</label>
									<form:select path="product_id" class="form-control form-control-lg">
										<form:options itemLabel="name" itemValue="id"
											items="${product}" />
									</form:select>
								</div>

								<div>
									<label class="form-label">Giá</label>
									<form:input path="price" class="form-control form-control-lg" />
								</div>

								<div>
									<label class="form-label">Số Lượng</label>
									<form:input path="quantity" class="form-control form-control-lg" />
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
				<th>Địa Chỉ</th>
				<th>Loại Sản Phẩm</th>
				<th>Giá</th>
				<th>Số Lượng</th>

				<th colspan="2">Hành Động</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ data.content }" var="orderdetail">
				<tr>
					<td>${ orderdetail.id }</td>
					<td>${ orderdetail.order_id.address }</td>
					<td>${ orderdetail.product_id.name }</td>
					<td>${ orderdetail.price }</td>
					<td>${ orderdetail.quantity }</td>



					<td><a
						href="/su22_SOF3021_IT16306/admin/orderdetail/edit/${ orderdetail.id }"
						class="btn btn-primary">Sửa</a></td>

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
											href="/su22_SOF3021_IT16306/admin/orderdetail/delete/${orderdetail.id}">Xóa</a>
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
					href="/su22_SOF3021_IT16306/admin/orderdetail/index?page=${ i }">
						${ i + 1 } </a></li>
			</c:forEach>
		</ul>
	</div>


	<script src="/su22_SOF3021_IT16306/js/jquery.min.js"></script>
	<script src="/su22_SOF3021_IT16306/js/popper.min.js"></script>
	<script src="/su22_SOF3021_IT16306/js/bootstrap.min.js"></script>
</body>
</html>