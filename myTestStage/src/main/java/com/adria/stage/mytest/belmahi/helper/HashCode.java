package com.adria.stage.mytest.belmahi.helper;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class HashCode {
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	public String getHashPassword(String password) {
//		passwordEncoder = new BCryptPasswordEncoder(10);
		String hashedPassword = passwordEncoder.encode(password);

		System.out.println(hashedPassword);
		return hashedPassword;
	}
	public static void main(String[] args) {
		new HashCode().getHashPassword("stage");
	}
	public BCryptPasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}
	public void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	
	
	public Boolean passwordVirefication(CharSequence existingPassword, String dbPassword){
		if(passwordEncoder.matches(existingPassword, dbPassword)){
			return true;
		}
		return false;
	}
	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//
//	    int strength = // your strength;
//	    SecureRandom random = // your random
//
//	    PasswordEncoder encoder = new BCryptPasswordEncoder(strength, random);
//	    return encoder;
//	}

}
