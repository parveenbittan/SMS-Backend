package com.scheduler.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.scheduler.demo.dto.FeeHistoryDTO;

import com.scheduler.demo.dto.ResultSaveParameterDTO;
import com.scheduler.demo.dto.StudentDTO;
import com.scheduler.demo.dto.StudentSearchFielter;
import com.scheduler.demo.entity.StudentMaster;
import com.scheduler.demo.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService studentService;
	//session management master
	@PostMapping("/students")
	public ResponseEntity<List<StudentDTO>> getAllStudentInCurrentSession(@RequestBody StudentSearchFielter ssf) {
		try {
			List<StudentDTO> sessions = studentService.findAllStudent(ssf);
			return new ResponseEntity<>(sessions, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/studentsWithFee")
	public ResponseEntity<List<StudentDTO>> getAllStudentWithFeeInCurrentSession(@RequestBody StudentSearchFielter ssf) {
		try {
			List<StudentDTO> sessions = studentService.findAllStudentWithFee(ssf);
			return new ResponseEntity<>(sessions, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/studentFee")
	public ResponseEntity<StudentDTO> getStudentFee(@RequestBody StudentSearchFielter ssf) {
		try {
			StudentDTO sessions = studentService.getStudentFee(ssf);
			return new ResponseEntity<>(sessions, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/saveFee")
	public ResponseEntity<StudentDTO>  saveFee(@RequestBody StudentDTO stdto) {
		try {
			StudentDTO sessions = studentService.saveFee(stdto);
			return new ResponseEntity<>(sessions, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	//API to find all job by id.
	@GetMapping("/student/{id}")
	public ResponseEntity<StudentMaster> getStudentById(@PathVariable("id") Long id) {
		Optional<StudentMaster> classSessionMaster = studentService.findStudentByID(id);
		if (classSessionMaster.isPresent()) {
			return new ResponseEntity<>(classSessionMaster.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/saveStudent")
	public ResponseEntity<StudentDTO> saveStudent(@RequestBody StudentDTO stuDTO)  {
		StudentDTO stuSaved=null;
		if(stuDTO!=null &&stuDTO.getName()!=null && !stuDTO.getName().equals("") && stuDTO.getFatherName()!=null && !stuDTO.getFatherName().equals("") && stuDTO.getMotherName()!=null 
				&& !stuDTO.getMotherName().equals("") && stuDTO.getDob()!=null && !stuDTO.getDob().equals("") )
		{
			stuSaved = studentService.saveStudent(stuDTO);
		}
		if(stuSaved !=null) {
			return new ResponseEntity<>(stuSaved, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(path = "/upload/{id}", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE})
	  public ResponseEntity<String> savePhoto(@PathVariable("id") Long id,@RequestPart("file") MultipartFile file) {
	    String message = "";
	    System.out.println("handling request parts: {}"+ file);
	    message=studentService.savePhoto(id,file);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
	//session management master
		@PostMapping("/result")
		public ResponseEntity<List<StudentDTO>> getResultByClassCurrentSession(@RequestBody StudentSearchFielter ssf) {
			try {
				List<StudentDTO> sessions = studentService.findResultByClass(ssf);
				return new ResponseEntity<>(sessions, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		@PostMapping("/saveResult")
		public ResponseEntity<List<StudentDTO>> saveResult(@RequestBody ResultSaveParameterDTO stds) {
			try {
				List<StudentDTO> sessions = studentService.saveResult(stds);
				return new ResponseEntity<>(sessions, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		@GetMapping("/feeHistory/{sessionId}/{classId}/{studentId}")
		public ResponseEntity<List<FeeHistoryDTO>> getFeeHistory(@PathVariable("sessionId")Integer sessionId,@PathVariable("classId")Integer classId,@PathVariable("studentId")Long studentId) {
			try {
				List<FeeHistoryDTO> feeHistory = studentService.getFeeHistory(sessionId,classId,studentId);
				return new ResponseEntity<>(feeHistory, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		@PostMapping("/studentAttendence")
		public ResponseEntity<List<StudentDTO>> getAttendence(@RequestBody StudentSearchFielter ssf) {
			try {
				List<StudentDTO> sessions = studentService.getAttendence(ssf);
				return new ResponseEntity<>(sessions, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		@PostMapping("/saveAttendence")
		public void  saveAttendence(@RequestBody List<StudentDTO> studentDTO) {
			try {
				studentService.saveAttendence(studentDTO);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
}