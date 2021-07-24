package com.contact.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contact.manager.common.ContactDetails;
import com.contact.manager.service.UserService;
@CrossOrigin
@RestController
public class UserResponse {
	@Autowired
	UserService User;
	@GetMapping("/name")
	public ResponseEntity<List<ContactDetails>> getUser(){
		String name ="Subrahmanya";
		
		List<ContactDetails> listUsers = User.getAllUsers();
		
		HttpHeaders header = new HttpHeaders();
		header.add("Auth", "Login");
		
		//return ResponseEntity.().headers(header).body(name)	;
		return ResponseEntity.status(HttpStatus.OK).headers(header).body(listUsers);
		
	}
}
