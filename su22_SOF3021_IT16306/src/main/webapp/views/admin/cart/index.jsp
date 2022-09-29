<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IT16306-Danh Sách Sản Phẩm</title>
<link rel="stylesheet"
	href="/su22_SOF3021_IT16306/css/bootstrap.min.css" />
</head>
<body>


	


	<table class="table table-secondary m-2">
		<thead>
			<tr>

				<th>Tên Sản Phẩm</th>
				<th>Số Lượng</th>
				<th>Giá</th>
				<th>Tổng Giá</th>
				<th colspan="2">Action</th>
			</tr>
		</thead>
		
		
		<c:forEach var="item" items="${cartItems }">
			<form:form action="/su22_SOF3021_IT16306/admin/cart/update"
				method="POST">
				<tr>
					<td>${item.name }</td>
					<td><input type="hidden" name="productId"
						value="${item.productId }"> 
						<input type="number"
						value="${item.quantity }" name="quantity"
						onblur="this.form.submit()" /></td>
					<td name="price">${item.price} VND</td>

					<td>${item.price*item.quantity} VND</td>
					<td>
						<button type="button" class="btn btn-danger"
							data-bs-toggle="modal"
							data-bs-target="#exampleModal_dl_${item.productId }">Xóa</button>
						<!-- Modal -->
						<div class="modal fade" id="exampleModal_dl_${item.productId }"
							tabindex="-1" aria-labelledby="exampleModalLabel"
							aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title text-danger fs-2 "
											id="exampleModalLabel">Nguy Hiểm</h5>
										<button type="button" class="btn-close"
											data-bs-dismiss="modal" aria-label="Close"></button>
									</div>
									<div class="modal-body">Bạn Có Muốn Xóa Sản Phẩm Này Khỏi Giỏ Hàng Không?</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-bs-dismiss="modal">Thoát</button>
										<a class="btn btn-danger"
											href="/su22_SOF3021_IT16306/admin/cart/delete/${item.productId }"
											role="button">Xóa</a>
									</div>
								</div>
							</div>
						</div>
					</td>
				</tr>
			</form:form>
		</c:forEach>
	</table>
	<a type="button" href="/su22_SOF3021_IT16306/home/index"
		class="btn btn-primary m-2">Home</a>
	<a type="button" href="/su22_SOF3021_IT16306/admin/cart/pay"
		class="btn btn-success">Thanh toán</a>


	<script src="/ASM_J5/js/jquery.min.js"></script>
	<script src="/ASM_J5/js/popper.min.js"></script>
	<script src="/ASM_J5/js/bootstrap.min.js"></script>
</body>
</html>