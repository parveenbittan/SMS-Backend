package com.scheduler.demo.service.Impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scheduler.demo.dto.ChangePasswordDTO;
import com.scheduler.demo.dto.EmployeeDTO;
import com.scheduler.demo.dto.EmployeeSearchFielter;
import com.scheduler.demo.dto.LoginDTO;
import com.scheduler.demo.entity.EmpPostnMapping;
import com.scheduler.demo.entity.EmployeeMaster;
import com.scheduler.demo.entity.PostMaster;
import com.scheduler.demo.entity.User;
import com.scheduler.demo.repository.EmpPostMappingRepository;
import com.scheduler.demo.repository.EmployeeRepository;
import com.scheduler.demo.repository.ManagePostMasterRepository;
import com.scheduler.demo.repository.UserRepository;
import com.scheduler.demo.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {
@Autowired	
EmployeeRepository employeeRepository;
@Autowired	
UserRepository userRepository;
@Autowired
ManagePostMasterRepository managePostMasterRepository;
@Autowired
EmpPostMappingRepository empPostMappingRepository;

	@Override
	public List<EmployeeDTO> findAllEmployee(EmployeeSearchFielter ssf) {
		// TODO Auto-generated method stub
		List<EmployeeDTO> students=new ArrayList<>();
		
		
		
		List<EmpPostnMapping> list;
		if(ssf!=null && ssf.getPostId()!=null &&  ssf.getPostId() >0  ) {
			list=empPostMappingRepository.findAllEmpByPostId(ssf.getPostId());
		}else {
			list=empPostMappingRepository.findByOrderByEmpPostId();
		}
		
		
		list.forEach(scs->{
			Optional<EmployeeMaster> emp=employeeRepository.findById(scs.getEmpIdFk());
			Optional<PostMaster> post=managePostMasterRepository.findById(scs.getPostIdFk());
			
			
			if(emp.isPresent()&&post.isPresent()) {
				 EmployeeDTO stuDto=new EmployeeDTO();
				 stuDto.setEmpId(emp.get().getEmpId());
				 stuDto.setName(emp.get().getName());
				 stuDto.setPostId(post.get().getPostId());
				 stuDto.setPostName(post.get().getPostName());
				
				 stuDto.setFatherName(emp.get().getFatherName());
				
				 stuDto.setActive(emp.get().isActive());
				 stuDto.setContact1(emp.get().getContact1());
				 stuDto.setContact2(emp.get().getContact2());
				 stuDto.setCurrentAddress(emp.get().getCurrentAddress());
				 stuDto.setPermanentAddress(emp.get().getPermanentAddress());
				 stuDto.setAdhar(emp.get().getAdhar());
				 stuDto.setBloodGroup(emp.get().getBloodGroup());
				 stuDto.setJoinDate(emp.get().getJoinDate());
				 stuDto.setReleavingDate(emp.get().getReleavingDate());
				 stuDto.setUpdateDate(emp.get().getUpdateDate());
				 stuDto.setGender(emp.get().getGender());
				 stuDto.setDob(emp.get().getDob());					
				 stuDto.setPhoto(emp.get().getPhoto());
				 if(ssf!=null&& ssf.getName()!=null && !ssf.getName().trim().equals("")) {
					if( stuDto.getName().contains(ssf.getName())) {
						students.add(stuDto); 
					}
				 }else {
					 students.add(stuDto); 
				 }
				
				 
			}
		});
		return students;
	}

	@Override
	public EmployeeDTO findEmpByID(Long id) {
		// TODO Auto-generated method stub
		
		 EmployeeDTO stuDto=new EmployeeDTO();
		Optional<EmployeeMaster> emp=employeeRepository.findById(id);
		
		List<Object[]> post=employeeRepository.postByEmpId(id);
		
		
		if(emp.isPresent()&&post.size()>0) {
			
			 stuDto.setEmpId(emp.get().getEmpId());
			 stuDto.setName(emp.get().getName());
			 stuDto.setPostId(Integer.parseInt(post.get(0)[0].toString()));
			 stuDto.setPostName((String) post.get(0)[1]);
			
			 stuDto.setFatherName(emp.get().getFatherName());
			
			 stuDto.setActive(emp.get().isActive());
			 stuDto.setContact1(emp.get().getContact1());
			 stuDto.setContact2(emp.get().getContact2());
			 stuDto.setCurrentAddress(emp.get().getCurrentAddress());
			 stuDto.setPermanentAddress(emp.get().getPermanentAddress());
			 stuDto.setAdhar(emp.get().getAdhar());
			 stuDto.setBloodGroup(emp.get().getBloodGroup());
			 stuDto.setJoinDate(emp.get().getJoinDate());
			 stuDto.setReleavingDate(emp.get().getReleavingDate());
			 stuDto.setUpdateDate(emp.get().getUpdateDate());
			 stuDto.setGender(emp.get().getGender());
			 stuDto.setDob(emp.get().getDob());					
			 stuDto.setPhoto(emp.get().getPhoto());
			 
			
			 
		}
		return stuDto;
	}

	@Override
	@Transactional
	public EmployeeDTO saveEmp(EmployeeDTO stuDTO) {
		try {
			SimpleDateFormat formDate = new SimpleDateFormat("dd-MM-yyyy");

		      
		       String currentDate = formDate.format(new Date());
			 EmployeeMaster stuMaster=new EmployeeMaster();
			 EmpPostnMapping empPostMapping=new EmpPostnMapping();
			 
			 if(stuDTO !=null && (stuDTO.getEmpId()==null ||stuDTO.getEmpId()==0)) {
					Optional<EmployeeMaster> lastId=employeeRepository.findFirstByOrderByEmpIdDesc();
					stuMaster.setJoinDate(currentDate);
					if(lastId.isPresent()) {
						stuMaster.setEmpId(lastId.get().getEmpId()+1);
						
					}else {
						stuMaster.setEmpId(1l);
						
					}
					Optional<EmpPostnMapping> scslastId=empPostMappingRepository.findFirstByOrderByEmpPostIdDesc();
					if(scslastId.isPresent()) {
						empPostMapping.setEmpPostId(scslastId.get().getEmpPostId()+1);						
					}else {
						empPostMapping.setEmpPostId(1l);
					}
				}else {
					stuMaster.setEmpId(stuDTO.getEmpId());
					stuMaster.setJoinDate(stuDTO.getJoinDate());
					Optional<EmpPostnMapping> scslastId=empPostMappingRepository.findEmpByEmpId(stuDTO.getEmpId());
					if(scslastId.isPresent()) {
						empPostMapping.setEmpPostId(scslastId.get().getEmpPostId());						
					}else {
						Optional<EmpPostnMapping> scslastId1=empPostMappingRepository.findFirstByOrderByEmpPostIdDesc();
						if(scslastId1.isPresent()) {
							empPostMapping.setEmpPostId(scslastId1.get().getEmpPostId()+1);						
						}else {
							empPostMapping.setEmpPostId(1l);
						}
					}
				}
			
			 stuMaster.setName(stuDTO.getName());			 
			 stuMaster.setFatherName(stuDTO.getFatherName());
			
			 stuMaster.setActive(stuDTO.isActive());
			 stuMaster.setContact1(stuDTO.getContact1());
			 stuMaster.setContact2(stuDTO.getContact2());
			 stuMaster.setCurrentAddress(stuDTO.getCurrentAddress());
			 stuMaster.setPermanentAddress(stuDTO.getPermanentAddress());
			 stuMaster.setAdhar(stuDTO.getAdhar());
			 stuMaster.setBloodGroup(stuDTO.getBloodGroup());
			 stuMaster.setGender(stuDTO.getGender());
			 if(stuDTO.isActive()) {
			 stuMaster.setReleavingDate("");
			 }else {
				 stuMaster.setReleavingDate(stuDTO.getReleavingDate()!=null? stuDTO.getReleavingDate():currentDate); 
			 }
			 stuMaster.setUpdateDate(currentDate);
			 stuMaster.setDob(stuDTO.getDob());					
			 stuMaster.setPhoto(stuDTO.getName()+stuDTO.getAdhar()+".jpg");
			 employeeRepository.save(stuMaster);
			 empPostMapping.setPostIdFk(stuDTO.getPostId());
			 empPostMapping.setEmpIdFk(stuMaster.getEmpId());
			 empPostMapping.setIsActive(stuDTO.isActive());
			
			 empPostMappingRepository.save(empPostMapping);
		}catch (Exception e) {
			return null;
		}
		return stuDTO;
	}

	@Override
	public LoginDTO login(LoginDTO login) {
		LoginDTO res=new LoginDTO();
		List<Object[]> loginObj=employeeRepository.login(login.getUserName(),login.getPassword());
		if(loginObj!=null && loginObj.size()==1) {
		for(Object[] obj : loginObj){
			res.setIsAuth(true);
			res.setUserName((String) obj[0]);
			res.setRole((String) obj[1]);
			res.setOrgName((String) obj[2]);
			res.setAffidiateNo((String) obj[3]);
			res.setOwnerName((String) obj[4]);
			res.setOrgAddress((String) obj[5]);
			res.setOrgEmail((String) obj[6]);
			res.setContact1((String) obj[7]);
			res.setContact2((String) obj[8]);
			res.setBoardName((String) obj[9]);
		   
		     }
		
		}else {
			res.setIsAuth(false);
		}
		
		return res;
	}

	@Override
	public ChangePasswordDTO changePassword(ChangePasswordDTO changePasswordDTO) {
		ChangePasswordDTO chDto=new ChangePasswordDTO();
		if(changePasswordDTO!=null && changePasswordDTO.getNewPass().length()>=4) {
		Optional<User> user=userRepository.findUserByNamePassword(changePasswordDTO.getUserName(),changePasswordDTO.getOld());
		if(user.isPresent()) {
			user.get().setUserPassword(changePasswordDTO.getNewPass());
			userRepository.save(user.get());
			chDto.setMessage("Password updated sussessfully");
		}else {
			chDto.setMessage("Old password entered is not correct");	

		}
		}
		else {
			chDto.setMessage("Minimum length of password should be 4 character");	
		}
		return chDto;
	}

	

}
