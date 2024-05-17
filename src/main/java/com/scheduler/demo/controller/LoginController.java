package com.scheduler.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scheduler.demo.dto.ChangePasswordDTO;
import com.scheduler.demo.dto.LoginDTO;
import com.scheduler.demo.service.EmployeeService;

@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired
	EmployeeService employeeService;
	//session management master
	@PostMapping("/")
	public ResponseEntity<LoginDTO> getAllEmployee(@RequestBody LoginDTO login) {
		try {
			LoginDTO sessions = employeeService.login(login);
			return new ResponseEntity<>(sessions, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/changePassword")
	public ResponseEntity<ChangePasswordDTO> changePassword(@RequestBody ChangePasswordDTO changePasswordDTO) {
		try {
			ChangePasswordDTO sessions = employeeService.changePassword(changePasswordDTO);
			return new ResponseEntity<>(sessions, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
}