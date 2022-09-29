<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<c:if test="${ !empty sessionScope.errors }">
	<div class="alert alert-danger">${ sessionScope.errors }</div>
	<c:remove var="error" scope="session"></c:remove>
</c:if>

<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet"
	href="/su22_SOF3021_IT16306/css/bootstrap.min.css" />
</head>
<body>
	<div class="col-10 offset-1 mt-5">
		<c:if test="${ not empty sessionScope.error }">
			<div class="alert alert-danger">${ sessionScope.error }</div>
			<c:remove var="error" scope="session" />
		</c:if>
	</div>
	<form action="/su22_SOF3021_IT16306/login" method="POST">
		<!-- 	<div>
			<h3>email</h3>
			<input type="email" name="email">
		</div>
		<div>
			<h3>password</h3>
			<input type="password" name="password">
		</div>
		<button>submit</button> -->


		<section class="vh-100" style="background-color: #508bfc;">
			<div class="container py-5 h-100">
				<div
					class="row d-flex justify-content-center align-items-center h-100">
					<div class="col-12 col-md-8 col-lg-6 col-xl-5">
						<div class="card shadow-2-strong" style="border-radius: 1rem;">
							<div class="card-body p-5 text-center">

								<h3 class="mb-5">Login</h3>

								<div class="form-outline mb-4">
									<input type="email" class="form-control form-control-lg"
										name="email" /> <label class="form-label">Email</label>
								</div>

								<div class="form-outline mb-4">
									<input type="password" class="form-control form-control-lg"
										name="password" /> <label class="form-label">Password</label>
								</div>



								<button class="btn btn-primary btn-lg btn-block" type="submit">Login</button>




							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</form>
	<script src="/su22_SOF3021_IT16306/js/jquery.min.js"></script>
	<script src="/su22_SOF3021_IT16306/js/popper.min.js"></script>
	<script src="/su22_SOF3021_IT16306/js/bootstrap.min.js"></script>
</body>
</html>