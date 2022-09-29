<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cập Nhật Order Detail</title>
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
	<div class="row m-2">
		<a
			href="http://localhost:8080/su22_SOF3021_IT16306/admin/orderdetail/index"
			class=" btn btn-primary"> Danh Sách </a>
	</div>
	<form:form method="POST"
		action="/su22_SOF3021_IT16306/admin/orderdetail/update/${ orderDetail.id }"
		modelAttribute="orderDetail">
		<section class="vh-100" style="background-color: #508bfc;">
			<div class=" py-5 h-100">
				<div
					class="row d-flex justify-content-center align-items-center h-100">
					<div class="col-12 col-md-8 col-lg-6 col-xl-5">
						<div class="card shadow-2-strong" style="border-radius: 1rem;">
							<div class="card-body p-5 text-center">

								<div>
									<label class="form-label">Địa Chỉ</label>
									<form:select value="${orderDetail.order_id.id }" path="order_id" class="form-control form-control">
										<c:forEach items="${ dsO }" var="order">
											<option value="${order.id }">${ order.address }</option>
										</c:forEach>
									</form:select>
								</div>


								<div>
									<label class="form-label">Sản Phẩm</label>
									<form:select name="product"
										value="${orderDetail.product_id.id }" path="product_id" class="form-control form-control">
										<c:forEach items="${ dsPro }" var="product">
											<option value="${product.id }">${ product.name }</option>
										</c:forEach>
									</form:select>
								</div>

								<div>
									<label class="form-label">Giá</label>
									<form:input path="price"  class="form-control form-control"/>
								</div>

								<div>
									<label class="form-label">Số Lượng</label>
									<form:input path="quantity"  class="form-control form-control"/>
								</div>



								<button class="btn btn-primary btn-lg btn-block m-2">Cập Nhật</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</form:form>
	<script src="/su22_SOF3021_IT16306/js/jquery.min.js"></script>
	<script src="/su22_SOF3021_IT16306/js/popper.min.js"></script>
	<script src="/su22_SOF3021_IT16306/js/bootstrap.min.js"></script>
</body>
</html>