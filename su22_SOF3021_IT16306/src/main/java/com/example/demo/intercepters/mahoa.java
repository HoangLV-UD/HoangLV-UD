package com.example.demo.intercepters;

import org.mindrot.jbcrypt.BCrypt;

public class mahoa {
	public static String hash(String plain) {
		String salt = BCrypt.gensalt();
		return BCrypt.hashpw(plain, salt);
	}
	
	public static boolean verify(String plain, String hashed) {
		return BCrypt.checkpw(plain, hashed);
	}
}
