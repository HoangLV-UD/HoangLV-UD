<%@ page language="java" contentType="text/html; charset=UTF-8"
	session="true" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IT16306-Trang Chủ</title>
<link rel="stylesheet"
	href="/su22_SOF3021_IT16306/css/bootstrap.min.css" />
</head>

<body>
	<section class="vh-100" style="background-color: #508bfc;">
		<div class=" py-5 h-100">

			<div class="card shadow-2-strong" style="border-radius: 1rem;">
				<div class="card-body p-5 text-center">
					<div class="container">
						<div class="row">
							<nav class="navbar navbar-expand-lg navbar-light bg-secondary">

								<a class="navbar-brand" href="/su22_SOF3021_IT16306/home/index">Trang
									Chủ</a>
								<button class="navbar-toggler" type="button"
										data-bs-toggle="collapse"
										data-bs-target="#navbarSupportedContent"
										aria-controls="navbarSupportedContent" 
										aria-expanded="false"
										aria-label="Toggle navigation">
									<span class="navbar-toggler-icon"></span>
								</button>
								<div class="collapse navbar-collapse"
									id="navbarSupportedContent">
									<ul class="navbar-nav me-auto ">



										<li class="nav-item dropdown"><a
											class="nav-link dropdown-toggle " href="#"
											id="navbarDropdown" role="button" data-bs-toggle="dropdown"
											aria-expanded="false"> Tài khoản </a>
											<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
												<c:if test="${empty  sessionScope.user }">

													<li>
														<a class="dropdown-item"
														href="/su22_SOF3021_IT16306/login">Đăng nhập</a>
													</li>
												</c:if>
											</ul>
										</li>
										
										<li class="nav-item"><a class="nav-link active"
											aria-current="page"
											href="/su22_SOF3021_IT16306/admin/accounts/index">
												người dùng</a></li>
										<li class="nav-item"><a class="nav-link active"
											aria-current="page"
											href="/su22_SOF3021_IT16306/admin/category/index">
												danh mục</a></li>
										<li class="nav-item"><a class="nav-link active"
											aria-current="page"
											href="/su22_SOF3021_IT16306/admin/product/index">
												sản phẩm</a></li>
										<li class="nav-item"><a class="nav-link active"
											aria-current="page"
											href="/su22_SOF3021_IT16306/admin/order/index">
												hóa đơn</a></li>
										<li class="nav-item"><a class="nav-link active"
											aria-current="page"
											href="/su22_SOF3021_IT16306/admin/orderdetail/index">hóa đơn chi tiết</a></li>

										<li class="nav-item"><a class="nav-link active"
											aria-current="page"
											href="/su22_SOF3021_IT16306/admin/cart/index">Giỏ hàng</a></li>
									</ul>

								</div>

							</nav>
						</div>
					</div>
					<div class="container">
						<div class="row ">
							<c:forEach items="${ data.content }" var="pro">

								<div class="card col-2 m-2" style="width: 18rem;">
									<div >
									<img src="${pro.image}" class="card-img">
									</div>
									<div class="card-body">
										<h5 class="card-title">Tên : ${pro.name }</h5>
									</div>
									<div class='card-footer'>
										<h4>Giá : ${pro.price} VND</h4>
									</div>
									<div class="m-2">
										<a href="/su22_SOF3021_IT16306/admin/cart/create/${pro.id}"
											class="btn btn-primary">Thêm vào giỏ hàng</a>
									</div>

								</div>

							</c:forEach>
						</div>
						<div class="row">
							<ul class="pagination">
								<c:forEach var="i" begin="0" end="${ data.totalPages - 1 }">
									<li class="page-item"><a class="page-link"
										href="/su22_SOF3021_IT16306/home/index?page=${ i }"> ${ i + 1 }
									</a></li>
								</c:forEach>
							</ul>
						</div>
					</div>

				</div>
			</div>
		</div>


	</section>
	<script src="/su22_SOF3021_IT16306/js/jquery.min.js"></script>
	<script src="/su22_SOF3021_IT16306/js/popper.min.js"></script>
	<script src="/su22_SOF3021_IT16306/js/bootstrap.min.js"></script>
</body>
</html>