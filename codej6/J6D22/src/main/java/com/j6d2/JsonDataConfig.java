package com.j6d2;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.j6d2.bean.Student;

@Configuration
public class JsonDataConfig {
	@Bean
	public List<Student> getStudents() throws IOException{
		File file = new ClassPathResource("/static/students.json").getFile();
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<Student>> type = new TypeReference<List<Student>>() {};
		List<Student> list = mapper.readValue(file, type);
		return list;
	}
}
