package com.example.demo.beans;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component

public class User {
	@NotBlank(message="Khong Duoc De Trong Ho Ten ")
	private  String hoTen;
	
	@NotBlank(message="Khong Duoc De Trong Dia Chi ")
	private  String diaChi;
	
	@NotNull(message="Khong Duoc De Trong Gioi Tinh ")
	//giới tính chỉ được giá trị 1 và2 
	
	private  int gioiTinh;
	
	@NotBlank(message="Khong Duoc De Trong Password ")
	@Length(min = 6)
	private  String password;
	
	@NotBlank(message="Khong Duoc De Trong Email ")
	@Email(message="Khong Dung Dinh Dang Email")
	@Pattern(regexp="^[A-Za-z0-9]+[A-Za-z0-9]*@fpt.edu.vn", message=" Không Đúng Định dạng Email")
	//email đún định dạng fpt.edu.vn
	private  String email;
	
	@NotBlank(message="Khong Duoc De Trong So Dien Thoai ")
	
	//sdt đúng định adngj : 0[(24)3789]..
	//sdt cí điih dài: 10 số hoặc 11 số
	@Pattern(regexp = "^(024|09|08|07|03)+([0-9]{8})$", message = "Sai định dạng số điện thoại")
	private  String sdt;
	
	@NotBlank(message="Khong Duoc De Trong Avatar ")
	private  String avatar;
	
}


