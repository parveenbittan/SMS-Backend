package com.scheduler.demo.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scheduler.demo.dto.ClassSubjectDTO;
import com.scheduler.demo.dto.ExamClassDTO;
import com.scheduler.demo.entity.ClassMaster;
import com.scheduler.demo.entity.ClassSujectMapping;
import com.scheduler.demo.entity.ExamClassMapping;
import com.scheduler.demo.entity.ExamMaster;
import com.scheduler.demo.entity.ItemMaster;
import com.scheduler.demo.entity.PostMaster;
import com.scheduler.demo.entity.SessionMaster;
import com.scheduler.demo.entity.SubjectMaster;
import com.scheduler.demo.repository.ManageClassRepository;
import com.scheduler.demo.repository.ManageClassSubjectRepository;
import com.scheduler.demo.repository.ManageExamClassRepository;
import com.scheduler.demo.repository.ManageExamMasterRepository;
import com.scheduler.demo.repository.ManageItemMasterRepository;
import com.scheduler.demo.repository.ManagePostMasterRepository;
import com.scheduler.demo.repository.ManageSessionMasterRepository;
import com.scheduler.demo.repository.ManageSubjectRepository;
import com.scheduler.demo.service.ManageMasterService;
@Service
public class ManageMasterServiceImpl implements ManageMasterService {
@Autowired
ManageClassRepository manageClassRepository;
@Autowired
ManageSubjectRepository manageSubjectRepository;
@Autowired
ManageSessionMasterRepository manageSessionMasterRepository;
@Autowired
ManageExamMasterRepository manageExamMasterRepository;
@Autowired
ManagePostMasterRepository managePostMasterRepository;
@Autowired
ManageItemMasterRepository manageIteamMasterRepository;
@Autowired
ManageClassSubjectRepository manageClassSubjectRepository;
@Autowired
ManageExamClassRepository manageExamClassRepository;
	@Override
	public List<ClassMaster> findAllClassess() {
		List<ClassMaster> classes=manageClassRepository.findByOrderByClassId();
		return classes;
	}

	public Optional<ClassMaster> findByID(Integer id){
		return manageClassRepository.findById(id);
	}

	@Override
	public ClassMaster saveClass(ClassMaster classData) {
		if(classData !=null && (classData.getClassId()==null ||classData.getClassId()==0)) {
			Optional<ClassMaster> lastId=manageClassRepository.findFirstByOrderByClassIdDesc();
			if(lastId.isPresent()) {
				classData.setClassId(lastId.get().getClassId()+1);
			}else {
				classData.setClassId(1);
			}
		}
		// TODO Auto-generated method stub
		return manageClassRepository.save(classData);
	}

	@Override
	public List<SessionMaster> findAllSessions() {
		List<SessionMaster> sessions=manageSessionMasterRepository.findByOrderBySessionId();
		return sessions;
	}

	@Override
	public Optional<SessionMaster> findSessionByID(int id) {
		return manageSessionMasterRepository.findById(id);
	}

	@Override
	public SessionMaster saveSessionMaster(SessionMaster sessionMaster) {
		if(sessionMaster !=null && (sessionMaster.getSessionId()==null ||sessionMaster.getSessionId()==0)) {
			Optional<SessionMaster> lastId=manageSessionMasterRepository.findFirstByOrderBySessionIdDesc();
			if(lastId.isPresent()) {
				sessionMaster.setSessionId(lastId.get().getSessionId()+1);
				
			}else {
				sessionMaster.setSessionId(1);
			}
		}
		// TODO Auto-generated method stub
		return manageSessionMasterRepository.save(sessionMaster);
	}

	@Override
	public List<SubjectMaster> findAllSubject() {
		List<SubjectMaster> subjects=manageSubjectRepository.findByOrderBySubjectId();
		return subjects;
	}

	@Override
	public Optional<SubjectMaster> findSubjectMasterByID(int id) {
		return manageSubjectRepository.findById(id);
	}

	@Override
	public SubjectMaster saveSessionMaster(SubjectMaster subjectMaster) {
		if(subjectMaster !=null && (subjectMaster.getSubjectId()==null ||subjectMaster.getSubjectId()==0)) {
			Optional<SubjectMaster> lastId=manageSubjectRepository.findFirstByOrderBySubjectIdDesc();
			if(lastId.isPresent()) {
				subjectMaster.setSubjectId(lastId.get().getSubjectId()+1);
			}else {
				subjectMaster.setSubjectId(1);
			}
		}
		// TODO Auto-generated method stub
		return manageSubjectRepository.save(subjectMaster);
	}
	@Override
	public List<ExamMaster> findAllExam() {
		List<ExamMaster> exams=manageExamMasterRepository.findByOrderByExamId();
		return exams;
	}
	@Override
	public Optional<ExamMaster> findExamMasterByID(int id) {
		return manageExamMasterRepository.findById(id);
	}
	@Override
	public ExamMaster saveExamMaster(ExamMaster examMaster) {
		if(examMaster !=null && (examMaster.getExamId()==null ||examMaster.getExamId()==0)) {
			Optional<ExamMaster> lastId=manageExamMasterRepository.findFirstByOrderByExamIdDesc();
			if(lastId.isPresent()) {
				examMaster.setExamId(lastId.get().getExamId()+1);
			}else {
				examMaster.setExamId(1);
			}
		}
		// TODO Auto-generated method stub
		return manageExamMasterRepository.save(examMaster);
	}

	@Override
	public List<PostMaster> findAllPost() {
		List<PostMaster> posts=managePostMasterRepository.findByOrderByPostId();
		return posts;
	}

	@Override
	public Optional<PostMaster> findPostMasterByID(int id) {
		return managePostMasterRepository.findById(id);
	}

	@Override
	public PostMaster saveExamMaster(PostMaster post) {
		if(post !=null && (post.getPostId()==null ||post.getPostId()==0)) {
			Optional<PostMaster> lastId=managePostMasterRepository.findFirstByOrderByPostIdDesc();
			if(lastId.isPresent()) {
				post.setPostId(lastId.get().getPostId()+1);
			}else {
				post.setPostId(1);
			}
		}
		// TODO Auto-generated method stub
		return managePostMasterRepository.save(post);
	}

	@Override
	public SessionMaster getActiveSession() {
		
		return manageSessionMasterRepository.getActiveSession();
	}

	@Override
	public List<ClassMaster> getActiveClasses() {
		return manageClassRepository.getActiveClasses();
	}

	@Override
	public List<SubjectMaster> getActiveSubject() {
		return manageSubjectRepository.getActiveSubject();
	}

	@Override
	public List<ExamMaster> getActiveExam() {
		return manageExamMasterRepository.getActiveExam();
	}
	public List<ExamMaster> getExamByClassId(int classId){
		List<ExamClassMapping> list =manageExamClassRepository.getExamClassByclassId(classId);
		List<ExamMaster> result=new ArrayList<>();
		list.forEach(ec->{
			Optional<ExamMaster> em=manageExamMasterRepository.findById(ec.getExamId());
			if(em.isPresent()) {
				result.add(em.get());
			}
		});
		return result;
	}
	@Override
	public List<PostMaster> getActivePost() {
		return managePostMasterRepository.getActivePost();
	}

	@Override
	public List<ItemMaster> getActiveIteam() {		
		return  manageIteamMasterRepository.getActiveItem();
	}

	@Override
	public ItemMaster saveIteamMaster(ItemMaster iteamMaster) {
		if(iteamMaster !=null && (iteamMaster.getItemId()==null ||iteamMaster.getItemId()==0)) {
			Optional<ItemMaster> lastId=manageIteamMasterRepository.findFirstByOrderByItemIdDesc();
			if(lastId.isPresent()) {
				iteamMaster.setItemId(lastId.get().getItemId()+1);
			}else {
				iteamMaster.setItemId(1);
			}
		}
		// TODO Auto-generated method stub
		return manageIteamMasterRepository.save(iteamMaster);
	}

	@Override
	public Optional<ItemMaster> findIteamByID(int id) {
		return manageIteamMasterRepository.findById(id);
	}

	@Override
	public List<ItemMaster> findAllIteams() {
		List<ItemMaster> iteams=manageIteamMasterRepository.findByOrderByItemId();
		return iteams;
	}

	@Override
	public List<ClassSubjectDTO> getAllclassSubjects() {
		List<ClassSubjectDTO> list=new ArrayList<>();
		List<ClassSujectMapping> csl=	manageClassSubjectRepository.findByOrderByClassIdFk();
		csl.forEach(cs->{
			ClassSubjectDTO dto=new ClassSubjectDTO();
			dto.setClassSubjectMappingId(cs.getClassSubjectMappingId());
			Optional<SubjectMaster> subject=manageSubjectRepository.findById(cs.getSubjectIdFk());
			if(subject.isPresent()) {
				dto.setSubjectId(subject.get().getSubjectId());	
				dto.setSubjectName(subject.get().getSubjectName());
			}
			Optional<ClassMaster> clas=manageClassRepository.findById(cs.getClassIdFk());
			if(clas.isPresent()) {
				dto.setClassId(clas.get().getClassId());	
				dto.setClassName(clas.get().getClassName());
			}
			dto.setIsActive(cs.getIsActive());
			list.add(dto);
		});
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public List<ClassSubjectDTO> getAllActiveclassSubjects() {
		List<ClassSubjectDTO> list=new ArrayList<>();
		List<ClassSujectMapping> csl=	manageClassSubjectRepository.getActiveClassSujectMapping();
		csl.forEach(cs->{
			ClassSubjectDTO dto=new ClassSubjectDTO();
			dto.setClassSubjectMappingId(cs.getClassSubjectMappingId());
			Optional<SubjectMaster> subject=manageSubjectRepository.findById(cs.getSubjectIdFk());
			if(subject.isPresent()) {
				dto.setSubjectId(subject.get().getSubjectId());	
				dto.setSubjectName(subject.get().getSubjectName());
			}
			Optional<ClassMaster> clas=manageClassRepository.findById(cs.getClassIdFk());
			if(clas.isPresent()) {
				dto.setClassId(clas.get().getClassId());	
				dto.setClassName(clas.get().getClassName());
			}
			dto.setIsActive(cs.getIsActive());
			list.add(dto);
		});
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	@Transactional
	public ClassSubjectDTO saveClassSubjects(ClassSubjectDTO classSubjectDTO) {
		ClassSujectMapping classSujectMapping=new ClassSujectMapping();
		if(classSubjectDTO !=null && (classSubjectDTO.getClassSubjectMappingId()==null ||classSubjectDTO.getClassSubjectMappingId()==0)) {
			Optional<ClassSujectMapping> lastId=manageClassSubjectRepository.findFirstByOrderByClassSubjectMappingIdDesc();
			if(lastId.isPresent()) {
				classSujectMapping.setClassSubjectMappingId(lastId.get().getClassSubjectMappingId()+1);
			}else {
				classSujectMapping.setClassSubjectMappingId(1);
			}
		}else {
			classSujectMapping.setClassSubjectMappingId(classSubjectDTO.getClassSubjectMappingId());
		}
		classSujectMapping.setClassIdFk(classSubjectDTO.getClassId());
		classSujectMapping.setSubjectIdFk(classSubjectDTO.getSubjectId());
		classSujectMapping.setIsActive(classSubjectDTO.getIsActive());
		manageClassSubjectRepository.save(classSujectMapping);
		
		return classSubjectDTO;
	}

	@Override
	public List<ExamClassDTO> getAllExamClass() {
		List<ExamClassDTO> list=new ArrayList<>();
		List<ExamClassMapping> csl=	manageExamClassRepository.findByOrderByClassId();
		csl.forEach(cs->{
			ExamClassDTO dto=new ExamClassDTO();
			dto.setExamClassId(cs.getExamClassId());
			Optional<ExamMaster> exam=manageExamMasterRepository.findById(cs.getExamId());
			if(exam.isPresent()) {
				dto.setExamId(exam.get().getExamId());	
				dto.setExamName(exam.get().getExamName());
			}
			Optional<ClassMaster> clas=manageClassRepository.findById(cs.getClassId());
			if(clas.isPresent()) {
				dto.setClassId(clas.get().getClassId());	
				dto.setClassName(clas.get().getClassName());
			}
			dto.setMaxMarks(cs.getMaxMarks());
			list.add(dto);
		});
		
		return list;
	}

	@Override
	public ExamClassDTO saveExamClass(ExamClassDTO classSubjectDTO) {
		ExamClassMapping classSujectMapping=new ExamClassMapping();
		if(classSubjectDTO !=null && (classSubjectDTO.getExamClassId()==null ||classSubjectDTO.getExamClassId()==0)) {
			Optional<ExamClassMapping> lastId=manageExamClassRepository.findFirstByOrderByExamClassIdDesc();
			if(lastId.isPresent()) {
				classSujectMapping.setExamClassId(lastId.get().getExamClassId()+1);
			}else {
				classSujectMapping.setExamClassId(1);
			}
		}else {
			classSujectMapping.setExamClassId(classSubjectDTO.getExamClassId());
		}
		classSujectMapping.setClassId(classSubjectDTO.getClassId());
		classSujectMapping.setExamId(classSubjectDTO.getExamId());
		classSujectMapping.setMaxMarks(classSubjectDTO.getMaxMarks());
		manageExamClassRepository.save(classSujectMapping);
		
		return classSubjectDTO;
	}
}
