package com.scheduler.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scheduler.demo.dto.EmployeeDTO;
import com.scheduler.demo.dto.EmployeeSearchFielter;
import com.scheduler.demo.dto.StudentDTO;
import com.scheduler.demo.entity.EmployeeMaster;
import com.scheduler.demo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	//session management master
	@PostMapping("/employees")
	public ResponseEntity<List<EmployeeDTO>> getAllEmployee(@RequestBody EmployeeSearchFielter ssf) {
		try {
			List<EmployeeDTO> sessions = employeeService.findAllEmployee(ssf);
			return new ResponseEntity<>(sessions, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/emp/{id}")
	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") Long id) {
		EmployeeDTO classSessionMaster = employeeService.findEmpByID(id);
		if (classSessionMaster!=null) {
			return new ResponseEntity<>(classSessionMaster, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/saveEmp")
	public ResponseEntity<EmployeeDTO> saveEmp(@RequestBody EmployeeDTO stuDTO)  {
		EmployeeDTO stuSaved=null;
		if(stuDTO!=null &&stuDTO.getName()!=null && !stuDTO.getName().equals("") && stuDTO.getFatherName()!=null && !stuDTO.getFatherName().equals("")  
				 && stuDTO.getDob()!=null && !stuDTO.getDob().equals("") )
		{
			stuSaved = employeeService.saveEmp(stuDTO);
		}
		if(stuSaved !=null) {
			return new ResponseEntity<>(stuSaved, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}