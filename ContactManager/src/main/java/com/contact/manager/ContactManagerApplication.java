package com.contact.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.contact.manager.common.ContactDetails;
import com.contact.manager.common.UserRepo;

@SpringBootApplication
@ComponentScan({"com.contact.manager.common","com.contact.manager.controller","com.contact.manager.service"})
@EntityScan("com.contact.manager.common")
//,"com.contact.manager.controller")
@EnableJpaRepositories("com.contact.manager.common")
// https://stackoverflow.com/questions/40384056/consider-defining-a-bean-of-type-package-in-your-configuration-spring-boot

public class ContactManagerApplication implements CommandLineRunner {

	@Autowired
	public UserRepo User;
	public static void main(String[] args) {
		SpringApplication.run(ContactManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<ContactDetails> listUsers = User.findAll();
		listUsers.forEach(s -> System.out.println(s.toString()));
	}

}
