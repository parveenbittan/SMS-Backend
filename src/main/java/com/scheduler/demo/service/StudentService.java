package com.scheduler.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.scheduler.demo.dto.FeeHistoryDTO;
import com.scheduler.demo.dto.ResultSaveParameterDTO;
import com.scheduler.demo.dto.StudentDTO;
import com.scheduler.demo.dto.StudentSearchFielter;
import com.scheduler.demo.entity.Attendence;
import com.scheduler.demo.entity.StudentMaster;

public interface StudentService {

	List<StudentDTO> findAllStudent(StudentSearchFielter ssf);

	Optional<StudentMaster> findStudentByID(Long id);

	StudentDTO saveStudent(StudentDTO stuDTO);

	List<StudentDTO> findResultByClass(StudentSearchFielter ssf);

	StudentDTO getStudentFee(StudentSearchFielter ssf);

	StudentDTO saveFee(StudentDTO stdto);

	List<StudentDTO> findAllStudentWithFee(StudentSearchFielter ssf);

	List<FeeHistoryDTO> getFeeHistory(Integer sessionId, Integer classId, Long studentId);

	List<StudentDTO> getAttendence(StudentSearchFielter ssf);

	void saveAttendence(List<StudentDTO> studentDTOs);

	List<StudentDTO> saveResult(ResultSaveParameterDTO data);

	String savePhoto(Long id, MultipartFile file);

}
