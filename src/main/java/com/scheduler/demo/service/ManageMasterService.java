package com.scheduler.demo.service;

import java.util.List;
import java.util.Optional;

import com.scheduler.demo.dto.ClassSubjectDTO;
import com.scheduler.demo.dto.ExamClassDTO;
import com.scheduler.demo.entity.ClassMaster;
import com.scheduler.demo.entity.ExamMaster;
import com.scheduler.demo.entity.ItemMaster;
import com.scheduler.demo.entity.PostMaster;
import com.scheduler.demo.entity.SessionMaster;
import com.scheduler.demo.entity.SubjectMaster;

public interface ManageMasterService {
	public List<ClassMaster> findAllClassess();
	public Optional<ClassMaster> findByID(Integer id);
	public ClassMaster saveClass(ClassMaster classData);
	public List<SessionMaster> findAllSessions();
	public Optional<SessionMaster> findSessionByID(int id);
	public SessionMaster saveSessionMaster(SessionMaster sessionMaster);
	public List<SubjectMaster> findAllSubject();
	public Optional<SubjectMaster> findSubjectMasterByID(int id);
	public SubjectMaster saveSessionMaster(SubjectMaster subjectMaster);
	public List<ExamMaster> findAllExam();
	public Optional<ExamMaster> findExamMasterByID(int id);
	public ExamMaster saveExamMaster(ExamMaster examMaster);
	public List<PostMaster> findAllPost();
	public Optional<PostMaster> findPostMasterByID(int id);
	public PostMaster saveExamMaster(PostMaster post);
	public SessionMaster getActiveSession();
	public List<ClassMaster> getActiveClasses();
	public List<SubjectMaster> getActiveSubject();
	public List<ExamMaster> getActiveExam();
	public List<ExamMaster> getExamByClassId(int classId);
	public List<PostMaster> getActivePost();
	public List<ItemMaster> getActiveIteam();
	public ItemMaster saveIteamMaster(ItemMaster sessionMaster);
	public Optional<ItemMaster> findIteamByID(int id);
	public List<ItemMaster> findAllIteams();
	public List<ClassSubjectDTO> getAllclassSubjects();
	public List<ClassSubjectDTO> getAllActiveclassSubjects();
	public ClassSubjectDTO saveClassSubjects(ClassSubjectDTO classSubjectDTO);
	public List<ExamClassDTO> getAllExamClass();
	public ExamClassDTO saveExamClass(ExamClassDTO classSubjectDTO);
}
