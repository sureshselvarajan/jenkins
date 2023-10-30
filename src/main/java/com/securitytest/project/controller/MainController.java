package com.securitytest.project.controller;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.securitytest.project.entity.MainEntity;
import com.securitytest.project.service.UserService;

@RestController
@RequestMapping("/api")
public class MainController {

	private UserService userService;

	public MainController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("/user")
	public List<MainEntity> listStudents() {
		return userService.getAllUser();
	}

	@PostMapping("/adduser")
	public MainEntity adduser(@RequestBody MainEntity user) {
		try {
			return userService.saveUser(user);
		} catch (DataIntegrityViolationException e) {
			// TODO: handle exception
			throw new RuntimeException("Email Address is already in use");
		}
	}
	@PutMapping("edituser/{userId}")
	public MainEntity updateuser(@PathVariable Long userId, @RequestBody MainEntity updateUser) {
		return userService.updateUser(userId, updateUser);
	}
	
	@DeleteMapping("deleteuser/{userId}")
	public MainEntity deleteuser(@PathVariable Long userId) {
		return userService.deleteUser(userId);
	}

}
