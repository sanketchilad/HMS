package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Admin;
import com.app.entity.Person;
import com.app.services.AdminService;
import com.app.services.PersonService;

@RestController
@RequestMapping("/admin")
public class AdminController 
{
	@Autowired
	private AdminService adminservice;
		
	@PutMapping(value="/{id}")
	public Admin updateAdmin(@RequestBody Admin admin,@PathVariable Long id) {
		System.out.println("Admin is Updated");
		return adminservice.updateAdmin(admin, id);
	}

}
