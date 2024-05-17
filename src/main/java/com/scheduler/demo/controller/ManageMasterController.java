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

import com.scheduler.demo.dto.ClassSubjectDTO;
import com.scheduler.demo.dto.ExamClassDTO;
import com.scheduler.demo.entity.ClassMaster;
import com.scheduler.demo.entity.ExamMaster;
import com.scheduler.demo.entity.ItemMaster;
import com.scheduler.demo.entity.PostMaster;
import com.scheduler.demo.entity.SessionMaster;
import com.scheduler.demo.entity.SubjectMaster;
import com.scheduler.demo.service.ManageMasterService;

@RestController
@RequestMapping("/masters")
public class ManageMasterController {
	@Autowired
	ManageMasterService manageMasterService;
	//session management master
	@GetMapping("/sessions")
	public ResponseEntity<List<SessionMaster>> getAllSession() {
		try {
			List<SessionMaster> sessions = manageMasterService.findAllSessions();
			return new ResponseEntity<>(sessions, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	//API to find all job by id.
	@GetMapping("/session/{id}")
	public ResponseEntity<SessionMaster> getSessionById(@PathVariable("id") int id) {
		Optional<SessionMaster> classSessionMaster = manageMasterService.findSessionByID(id);
		if (classSessionMaster.isPresent()) {
			return new ResponseEntity<>(classSessionMaster.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/saveSession")
	public ResponseEntity<SessionMaster> saveSessionMaster(@RequestBody SessionMaster sessionMaster)  {
		SessionMaster sessionMasterSaved=null;
		if(sessionMaster!=null &&sessionMaster.getSessionCode()!=null && !sessionMaster.getSessionCode().equals("") && sessionMaster.getSessionName()!=null && !sessionMaster.getSessionName().equals("") )
		{
			sessionMasterSaved = manageMasterService.saveSessionMaster(sessionMaster);
		}
		if(sessionMasterSaved !=null) {
			return new ResponseEntity<>(sessionMasterSaved, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	//Subject management master
		@GetMapping("/subjects")
		public ResponseEntity<List<SubjectMaster>> getAllSubject() {
			try {
				List<SubjectMaster> subjects = manageMasterService.findAllSubject();
				return new ResponseEntity<>(subjects, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		//API to find all job by id.
		@GetMapping("/subject/{id}")
		public ResponseEntity<SubjectMaster> getSubjectMasterById(@PathVariable("id") int id) {
			Optional<SubjectMaster> subjectMaster = manageMasterService.findSubjectMasterByID(id);
			if (subjectMaster.isPresent()) {
				return new ResponseEntity<>(subjectMaster.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		@PostMapping("/saveSubject")
		public ResponseEntity<SubjectMaster> saveSubjectMaster(@RequestBody SubjectMaster subjectMaster)  {
			SubjectMaster subjectMasterSaved=null;
			if(subjectMaster!=null &&subjectMaster.getSubjectCode()!=null && !subjectMaster.getSubjectCode().equals("") && subjectMaster.getSubjectName()!=null && !subjectMaster.getSubjectName().equals("") )
			{
				subjectMasterSaved = manageMasterService.saveSessionMaster(subjectMaster);
			}
			
			if(subjectMasterSaved !=null) {
				return new ResponseEntity<>(subjectMasterSaved, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
	//class master management
	@GetMapping("/classes")
	public ResponseEntity<List<ClassMaster>> getClasses() {
		try {
			List<ClassMaster> classes = manageMasterService.findAllClassess();
			return new ResponseEntity<>(classes, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	//API to find all job by id.
	@GetMapping("/class/{id}")
	public ResponseEntity<ClassMaster> getClassById(@PathVariable("id") int id) {
		Optional<ClassMaster> classData = manageMasterService.findByID(id);
		if (classData.isPresent()) {
			return new ResponseEntity<>(classData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/saveClass")
	public ResponseEntity<ClassMaster> saveClass(@RequestBody ClassMaster classData)  {
		ClassMaster classSaved=null;
		if(classData!=null &&classData.getClassDesc()!=null && !classData.getClassDesc().equals("") && classData.getClassName()!=null && !classData.getClassName().equals("") )
		{
			classSaved = manageMasterService.saveClass(classData);
		}
		
		if(classSaved !=null) {
			return new ResponseEntity<>(classSaved, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	//Exam master management
	
		@GetMapping("/exams")
		public ResponseEntity<List<ExamMaster>> getExams() {
			try {
				List<ExamMaster> exams = manageMasterService.findAllExam();
				return new ResponseEntity<>(exams, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		//API to find all job by id.
		@GetMapping("/exam/{id}")
		public ResponseEntity<ExamMaster> getExamById(@PathVariable("id") int id) {
			Optional<ExamMaster> classData = manageMasterService.findExamMasterByID(id);
			if (classData.isPresent()) {
				return new ResponseEntity<>(classData.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		@PostMapping("/saveExam")
		public ResponseEntity<ExamMaster> saveExam(@RequestBody ExamMaster examMaster)  {
			ExamMaster examSaved=null;
			if(examMaster!=null &&examMaster.getExamCode()!=null && !examMaster.getExamCode().equals("") && examMaster.getExamName()!=null && !examMaster.getExamName().equals("") )
			{
				examSaved = manageMasterService.saveExamMaster(examMaster);
			}
			
			if(examSaved !=null) {
				return new ResponseEntity<>(examSaved, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		//Post master management
		
			@GetMapping("/posts")
			public ResponseEntity<List<PostMaster>> getPosts() {
				try {
					List<PostMaster> posts = manageMasterService.findAllPost();
					return new ResponseEntity<>(posts, HttpStatus.OK);
				} catch (Exception e) {
					return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
			//API to find all job by id.
			@GetMapping("/post/{id}")
			public ResponseEntity<PostMaster> getPostById(@PathVariable("id") int id) {
				Optional<PostMaster> postsData = manageMasterService.findPostMasterByID(id);
				if (postsData.isPresent()) {
					return new ResponseEntity<>(postsData.get(), HttpStatus.OK);
				} else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
			}
			@PostMapping("/savePost")
			public ResponseEntity<PostMaster> savePost(@RequestBody PostMaster post)  {
				PostMaster postSaved=null;
				if(post!=null &&post.getPostCode()!=null && !post.getPostCode().equals("") && post.getPostName()!=null && !post.getPostName().equals("") )
				{ 
					post.setSalary(post.getSalary()==null||post.getSalary().equals("")?"0":post.getSalary() );
					post.setPf(post.getPf()==null||post.getPf().equals("")?"0":post.getPf() );
					postSaved = manageMasterService.saveExamMaster(post);
				}
				 
				if(postSaved !=null) {
					return new ResponseEntity<>(postSaved, HttpStatus.OK);
				} else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
			}
			@GetMapping("/activeSsession")
			public ResponseEntity<SessionMaster> getActiveSession() {
				try {
					SessionMaster sessions = manageMasterService.getActiveSession();
					if(sessions!=null) {
					return new ResponseEntity<>(sessions, HttpStatus.OK);
					}
					 else {
							return new ResponseEntity<>(HttpStatus.NOT_FOUND);
						}
					
				} catch (Exception e) {
					return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
			@GetMapping("/activeClass")
			public ResponseEntity<List<ClassMaster>> getActiveClass() {
				try {
					List<ClassMaster> classes = manageMasterService.getActiveClasses();
					if(classes!=null) {
					return new ResponseEntity<>(classes, HttpStatus.OK);
					}
					 else {
							return new ResponseEntity<>(HttpStatus.NOT_FOUND);
						}
					
				} catch (Exception e) {
					return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
			@GetMapping("/activeSubject")
			public ResponseEntity<List<SubjectMaster>> getActiveSubject() {
				try {
					List<SubjectMaster> sessions = manageMasterService.getActiveSubject();
					if(sessions!=null) {
					return new ResponseEntity<>(sessions, HttpStatus.OK);
					}
					 else {
							return new ResponseEntity<>(HttpStatus.NOT_FOUND);
						}
					
				} catch (Exception e) {
					return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
			@GetMapping("/activeExam")
			public ResponseEntity<List<ExamMaster>> getActiveExam() {
				try {
					List<ExamMaster> sessions = manageMasterService.getActiveExam();
					if(sessions!=null) {
					return new ResponseEntity<>(sessions, HttpStatus.OK);
					}
					 else {
							return new ResponseEntity<>(HttpStatus.NOT_FOUND);
						}
					
				} catch (Exception e) {
					return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
			@GetMapping("/activeExam/{classId}")
			public ResponseEntity<List<ExamMaster>> getExamByClassId(@PathVariable("classId") int classId ) {
				try {
					List<ExamMaster> sessions = manageMasterService.getExamByClassId(classId);
					if(sessions!=null) {
					return new ResponseEntity<>(sessions, HttpStatus.OK);
					}
					 else {
							return new ResponseEntity<>(HttpStatus.NOT_FOUND);
						}
					
				} catch (Exception e) {
					return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
			@GetMapping("/activePost")
			public ResponseEntity<List<PostMaster>> getActivePost() {
				try {
					List<PostMaster> sessions = manageMasterService.getActivePost();
					if(sessions!=null) {
					return new ResponseEntity<>(sessions, HttpStatus.OK);
					}
					 else {
							return new ResponseEntity<>(HttpStatus.NOT_FOUND);
						}
					
				} catch (Exception e) {
					return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
			@GetMapping("/items")
			public ResponseEntity<List<ItemMaster>> getAllIteams() {
				try {
					List<ItemMaster> sessions = manageMasterService.findAllIteams();
					return new ResponseEntity<>(sessions, HttpStatus.OK);
				} catch (Exception e) {
					return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
			//API to find all job by id.
			@GetMapping("/item/{id}")
			public ResponseEntity<ItemMaster> getIteamById(@PathVariable("id") int id) {
				Optional<ItemMaster> classSessionMaster = manageMasterService.findIteamByID(id);
				if (classSessionMaster.isPresent()) {
					return new ResponseEntity<>(classSessionMaster.get(), HttpStatus.OK);
				} else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
			}
			@PostMapping("/saveItem")
			public ResponseEntity<ItemMaster> saveIteamMaster(@RequestBody ItemMaster sessionMaster)  {
				ItemMaster sessionMasterSaved=null;
				if(sessionMaster!=null &&sessionMaster.getItemName()!=null && !sessionMaster.getItemName().equals("") && sessionMaster.getItemCode()!=null && !sessionMaster.getItemCode().equals("") )
				{
					sessionMasterSaved = manageMasterService.saveIteamMaster(sessionMaster);
				}
				if(sessionMasterSaved !=null) {
					return new ResponseEntity<>(sessionMasterSaved, HttpStatus.OK);
				} else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
			}
			@GetMapping("/activeItem")
			public ResponseEntity<List<ItemMaster>> getActiveIteam() {
				try {
					List<ItemMaster> sessions = manageMasterService.getActiveIteam();
					if(sessions!=null) {
					return new ResponseEntity<>(sessions, HttpStatus.OK);
					}
					 else {
							return new ResponseEntity<>(HttpStatus.NOT_FOUND);
						}
					
				} catch (Exception e) {
					return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
			
			@GetMapping("/classSubjects")
			public ResponseEntity<List<ClassSubjectDTO>> getAllclassSubjects() {
				try {
					List<ClassSubjectDTO> sessions = manageMasterService.getAllclassSubjects();
					return new ResponseEntity<>(sessions, HttpStatus.OK);
				} catch (Exception e) {
					return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
			@GetMapping("/classSubjectsActive")
			public ResponseEntity<List<ClassSubjectDTO>> getAllclassSubjectsActive() {
				try {
					List<ClassSubjectDTO> sessions = manageMasterService.getAllActiveclassSubjects();
					return new ResponseEntity<>(sessions, HttpStatus.OK);
				} catch (Exception e) {
					return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
			@PostMapping("/saveClassSubjects")
			public ResponseEntity<ClassSubjectDTO> saveClassSubjects(@RequestBody ClassSubjectDTO classSubjectDTO)  {
				ClassSubjectDTO clDto=null;
				if(classSubjectDTO!=null &&classSubjectDTO.getSubjectId()!=null && classSubjectDTO.getSubjectId()!=0 && classSubjectDTO.getClassId()!=null && classSubjectDTO.getClassId()!=0 )
				{
					clDto = manageMasterService.saveClassSubjects(classSubjectDTO);
				}
				if(clDto !=null) {
					return new ResponseEntity<>(clDto, HttpStatus.OK);
				} else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
			}
			@GetMapping("/examClasses")
			public ResponseEntity<List<ExamClassDTO>> getAllExamClass() {
				try {
					List<ExamClassDTO> sessions = manageMasterService.getAllExamClass();
					return new ResponseEntity<>(sessions, HttpStatus.OK);
				} catch (Exception e) {
					return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
			@PostMapping("/saveExamClass")
			public ResponseEntity<ExamClassDTO> saveExamClass(@RequestBody ExamClassDTO classSubjectDTO)  {
				ExamClassDTO clDto=null;
				if(classSubjectDTO!=null &&classSubjectDTO.getExamId()!=null && classSubjectDTO.getExamId()!=0 && classSubjectDTO.getClassId()!=null && classSubjectDTO.getClassId()!=0 )
				{
					clDto = manageMasterService.saveExamClass(classSubjectDTO);
				}
				if(clDto !=null) {
					return new ResponseEntity<>(clDto, HttpStatus.OK);
				} else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
			}
}
