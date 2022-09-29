package com.example.demo.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import Demo_bean_config.UserDaoInterFace;
import Demo_bean_config.UserDaoMySql;

@Configuration
public class DemoBeanUserDao {
	@Bean("user_dao_mysql")
	public UserDaoInterFace getUserDAOMySql()
	{
		return new UserDaoMySql();
	}
	
//	@Bean("user_dao_sqlserver")
//	public UserDaoInterFace getUserDAOSqlServer()
//	{
//		return new UserDAOSqlServer();
//	}
}
