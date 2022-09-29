<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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

	<form:form method="POST"
		action="/su22_SOF3021_IT16306/admin/product/store"
		modelAttribute="product">
		<section class="vh-70" style="background-color: #508bfc;">
			<div class=" py-5 h-100">
				<div
					class="row d-flex justify-content-center align-items-center h-100">
					<div class="col-12 col-md-8 col-lg-6 col-xl-5">
						<div class="card shadow-2-strong" style="border-radius: 1rem;">
							<div class="card-body p-5 text-center">
								<div>
									<label class="form-label">Name</label>
									<form:input path="name" class="form-control form-control-lg" />
									<form:errors path="name" class="text-danger" style="color: red" />
								</div>
								<div>
									<label class="form-label">image</label>
									<form:input path="image" type="file" class="form-control form-control-lg"/>
									<form:errors path="image" class="text-danger"
										style="color: red" />
								</div>
								<div>
									<label class="form-label">Date</label>
									<form:input path="created_date" type="date" class="form-control form-control-lg"/>
								</div>
								<div>
									<label class="form-label">price</label>
									<form:input path="price" class="form-control form-control-lg"/>
									<form:errors path="price" class="text-danger"
										style="color: red" />
								</div>
								<div>
									<label class="form-label">availabel</label>
									<form:input path="available" class="form-control form-control-lg"/>
								</div>
								<div>
									<label class="form-label">Category_id</label>
									<form:select path="category_id" class="form-control form-control-lg">
										<form:options itemLabel="name" itemValue="id" items="${cate}" />
									</form:select>
								</div>
								<button>Save</button>
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