package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Accounts;

public interface AccountRepository extends JpaRepository<Accounts, Integer> {
	
	@Query("select acc from Accounts acc where acc.email like %:email%")
	public Accounts findByEmail(@Param("email") String  emails);
	//lấy giá trị của emails để truyèn vào email
	
	
}

