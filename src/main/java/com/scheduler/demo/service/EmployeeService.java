package com.scheduler.demo.service;

import java.util.List;
import java.util.Optional;

import com.scheduler.demo.dto.ChangePasswordDTO;
import com.scheduler.demo.dto.EmployeeDTO;
import com.scheduler.demo.dto.EmployeeSearchFielter;
import com.scheduler.demo.dto.LoginDTO;
import com.scheduler.demo.entity.EmployeeMaster;

public interface EmployeeService {

	List<EmployeeDTO> findAllEmployee(EmployeeSearchFielter ssf);

	EmployeeDTO findEmpByID(Long id);

	EmployeeDTO saveEmp(EmployeeDTO stuDTO);

	LoginDTO login(LoginDTO login);

	ChangePasswordDTO changePassword(ChangePasswordDTO changePasswordDTO);

}
