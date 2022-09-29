package com.example.demo.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.intercepters.AuthInterceptor;

@Configuration // đánh dấu đây là một class dùng để cấu hình 
public class InterceptorConiguration implements WebMvcConfigurer {
	
	@Autowired
	private AuthInterceptor authen;
	
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authen)
			.addPathPatterns("/admin/**")
			.excludePathPatterns("/login");
	}
}
