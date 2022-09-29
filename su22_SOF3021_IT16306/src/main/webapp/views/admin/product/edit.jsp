<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cập Nhật Sản Phẩm</title>
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
			href="http://localhost:8080/su22_SOF3021_IT16306/admin/product/index"
			class=" btn btn-primary"> Danh Sách </a>
	</div>
	<form:form method="POST"
		action="/su22_SOF3021_IT16306/admin/product/update/${product.id }"
		modelAttribute="product">
		<section class="vh-100" style="background-color: #508bfc;">
			<div class=" py-5 h-100">
				<div
					class="row d-flex justify-content-center align-items-center h-100">
					<div class="col-12 col-md-8 col-lg-6 col-xl-5">
						<div class="card shadow-2-strong" style="border-radius: 1rem;">
							<div class="card-body p-5 text-center">
								<div>
									<label class="form-label">Tên Sản Phẩm</label>
									<form:input path="name" class="form-control form-control" />
								</div>
								<div>
									<label class="form-label">Ảnh</label>
									<form:input path="image" type="file" class="form-control form-control" />
								</div>

								<div>
									<label class="form-label">Ngày tạo</label>
									<form:input path="created_date" type="date"
										class="form-control form-control" />
								</div>
								<div>
									<label class="form-label">Giá</label>
									<form:input path="price" class="form-control form-control" />
								</div>
								<div>
									<label class="form-label">Có Sẵn</label>
									<form:input path="available" class="form-control form-control" />
								</div>

								<label class="form-label">Danh mục</label>
								<form:select path="category_id"
									class="form-control form-control">
									<form:options itemLabel="name" itemValue="id" items="${cate}" />
								</form:select>

								<button class="btn btn-primary btn-lg btn-block m-2">Cập
									Nhật</button>
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