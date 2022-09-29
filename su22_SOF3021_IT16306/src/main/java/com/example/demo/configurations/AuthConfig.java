package com.example.demo.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.intercepters.AuthInterceptor;

@Configuration
public class AuthConfig implements WebMvcConfigurer{
	/*
	 * @Autowired AuthInterceptor authinterceptor;
	 * 
	 * @Override public void addInterceptors(InterceptorRegistry registry) {
	 * registry.addInterceptor(authinterceptor)
	 * .addPathPatterns("/accounts/edit/**", "/categories/**", "/order/**",
	 * "/orderdetail/**" ) .addPathPatterns("/admin/**") //cấu hình các đường dẫn mà
	 * AuthInterceptor được lọc .excludePathPatterns("admin/home/index"); //cấu hình
	 * đường dẫn AuthInterceptor không lọc }
	 */
}
