package com.contact.manager.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.contact.manager.common.ContactDetails;
import com.contact.manager.common.UserRepo;

@Service
public class UserService {

	@Autowired
	public UserRepo User;
	
	public List<ContactDetails> getAllUsers(){
		List<ContactDetails> users = new ArrayList<ContactDetails>();
		User.findAll().forEach(u -> users.add(u));
		return users;
		
	}
	
	public void addUserInfo(ContactDetails user) {
		User.save(user);
		
	}
}
