package com.contact.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.contact.manager.common.ContactDetails;
import com.contact.manager.service.UserService;

@CrossOrigin
@RestController
public class PostUserInfo {


	@Autowired
	UserService userService;
	@PostMapping("/create")
	public ResponseEntity<String> postUser(@RequestBody ContactDetails user){
		
		userService.addUserInfo(user);
		HttpHeaders header = new HttpHeaders();
		header.add("desc", "UserCreation");
		
		return ResponseEntity.status(HttpStatus.OK).headers(header).build()	;
		
	}
}
