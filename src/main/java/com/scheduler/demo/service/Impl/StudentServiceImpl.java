package com.scheduler.demo.service.Impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.scheduler.demo.dto.FeeHistoryDTO;
import com.scheduler.demo.dto.ResultDTO;
import com.scheduler.demo.dto.ResultSaveParameterDTO;
import com.scheduler.demo.dto.StudentDTO;
import com.scheduler.demo.dto.StudentSearchFielter;
import com.scheduler.demo.entity.Attendence;
import com.scheduler.demo.entity.ClassMaster;
import com.scheduler.demo.entity.ClassSujectMapping;
import com.scheduler.demo.entity.ExamClassMapping;
import com.scheduler.demo.entity.ExamMaster;
import com.scheduler.demo.entity.Fee;
import com.scheduler.demo.entity.FeeHistory;
import com.scheduler.demo.entity.SessionMaster;
import com.scheduler.demo.entity.StudentClassSession;
import com.scheduler.demo.entity.StudentMaster;
import com.scheduler.demo.entity.StudentReport;
import com.scheduler.demo.entity.SubjectMaster;
import com.scheduler.demo.repository.AttendenceRepository;
import com.scheduler.demo.repository.FeeHistoryRepository;
import com.scheduler.demo.repository.FeeRepository;
import com.scheduler.demo.repository.ManageClassRepository;
import com.scheduler.demo.repository.ManageClassSubjectRepository;
import com.scheduler.demo.repository.ManageExamClassRepository;
import com.scheduler.demo.repository.ManageExamMasterRepository;
import com.scheduler.demo.repository.ManageSessionMasterRepository;
import com.scheduler.demo.repository.ManageSubjectRepository;
import com.scheduler.demo.repository.ResulRepository;
import com.scheduler.demo.repository.StudentClassSessionRepository;
import com.scheduler.demo.repository.StudentRepository;
import com.scheduler.demo.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {
@Autowired	
StudentRepository studentRepository;
@Autowired
ManageClassRepository classRepository;
@Autowired
ManageSessionMasterRepository manageSessionMasterRepository;
@Autowired
StudentClassSessionRepository studentClassSessionRepository;
@Autowired
ResulRepository resultRepository;
@Autowired
ManageExamMasterRepository manageExamMasterRepository;
@Autowired
ManageSubjectRepository manageSubjectRepository;
@Autowired
ManageClassSubjectRepository manageClassSubjectRepository;
@Autowired
FeeRepository feeRepository;
@Autowired
FeeHistoryRepository feeHistoryRepository;
@Autowired
AttendenceRepository attendenceRepository;
@Autowired
ManageExamClassRepository manageExamClassRepository;
@Autowired
org.springframework.core.env.Environment environment;
	@Override
	public List<StudentDTO> findAllStudent(StudentSearchFielter ssf) {
		// TODO Auto-generated method stub
		List<StudentDTO> students=new ArrayList<>();
		SessionMaster sessionMaster= manageSessionMasterRepository.getActiveSession();
		
		if(ssf!=null && ssf.getSessionId()!=null &&  ssf.getSessionId() >0) {
			
		}else {
			ssf.setSessionId(sessionMaster.getSessionId());
		}
		List<StudentClassSession> list;
		if(ssf!=null && ssf.getClassId()!=null &&  ssf.getClassId() >0  ) {
			list=studentClassSessionRepository.findSessionIdClassID(ssf.getSessionId(),ssf.getClassId());
		}else {
			list=studentClassSessionRepository.findAllStudentBySessionId(ssf.getSessionId());
		}
		
		
		list.forEach(scs->{
			Optional<StudentMaster> stum=studentRepository.findById(scs.getStudentIdFk());
			Optional<SessionMaster> session=manageSessionMasterRepository.findById(scs.getSessionIdFk());
			Optional<ClassMaster> classMaster=classRepository.findById(scs.getClassIdFk());
			
			if(stum.isPresent()&&session.isPresent()&&classMaster.isPresent()) {
				 StudentDTO stuDto=new StudentDTO();
				 stuDto.setStudentId(stum.get().getStudentId());
				 stuDto.setName(stum.get().getName());
				 stuDto.setClassId(classMaster.get().getClassId());
				 stuDto.setClassName(classMaster.get().getClassName());
				 stuDto.setSessionId(session.get().getSessionId());
				 stuDto.setSessionName(session.get().getSessionName());
				 stuDto.setFatherName(stum.get().getFatherName());
				 stuDto.setMotherName(stum.get().getMotherName());
				 stuDto.setActive(stum.get().isActive());
				 stuDto.setContact1(stum.get().getContact1());
				 stuDto.setContact2(stum.get().getContact2());
				 stuDto.setCurrentAddress(stum.get().getCurrentAddress());
				 stuDto.setPermanentAddress(stum.get().getPermanentAddress());
				 stuDto.setAdhar(stum.get().getAdhar());
				 stuDto.setBloodGroup(stum.get().getBloodGroup());
				 stuDto.setAdmissionDate(stum.get().getAdmissionDate());
				 stuDto.setReleavingDate(stum.get().getReleavingDate());
				 stuDto.setUpdateDate(stum.get().getUpdateDate());
				 stuDto.setGender(stum.get().getGender());
				 stuDto.setDob(stum.get().getDob());					
				 stuDto.setPhoto(stum.get().getPhoto());
				 stuDto.setBoardRegistraion(stum.get().getBoardRegistration());
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
	public Optional<StudentMaster> findStudentByID(Long id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id);
	}

	@Override
	@Transactional
	public StudentDTO saveStudent(StudentDTO stuDTO) {
		try {
			SimpleDateFormat formDate = new SimpleDateFormat("dd-MM-yyyy");

		      
		       String currentDate = formDate.format(new Date());
			 StudentMaster stuMaster=new StudentMaster();
			 StudentClassSession stcClassSession=new StudentClassSession();
			 
			 if(stuDTO !=null && (stuDTO.getStudentId()==null ||stuDTO.getStudentId()==0)) {
					Optional<StudentMaster> lastId=studentRepository.findFirstByOrderByStudentIdDesc();
					stuMaster.setAdmissionDate(currentDate);
					if(lastId.isPresent()) {
						stuMaster.setStudentId(lastId.get().getStudentId()+1);
						
					}else {
						stuMaster.setStudentId(1l);
						
					}
					Optional<StudentClassSession> scslastId=studentClassSessionRepository.findFirstByOrderByStudentClassSessionIdDesc();
					if(scslastId.isPresent()) {
						stcClassSession.setStudentClassSessionId(scslastId.get().getStudentClassSessionId()+1);						
					}else {
						stcClassSession.setStudentClassSessionId(1l);
					}
				}else {
					stuMaster.setStudentId(stuDTO.getStudentId());
					stuMaster.setAdmissionDate(stuDTO.getAdmissionDate());
					Optional<StudentClassSession> scslastId=studentClassSessionRepository.findByStudentAndSession(stuDTO.getStudentId(),stuDTO.getSessionId());
					if(scslastId.isPresent()) {
					stcClassSession.setStudentClassSessionId(scslastId.get().getStudentClassSessionId());
					}else {
						Optional<StudentClassSession> scslastIdUpdate=studentClassSessionRepository.findFirstByOrderByStudentClassSessionIdDesc();
						stcClassSession=new StudentClassSession();
						if(scslastIdUpdate.isPresent()) {
							stcClassSession.setStudentClassSessionId(scslastIdUpdate.get().getStudentClassSessionId()+1);						
						}else {
							stcClassSession.setStudentClassSessionId(1l);
						}
					}
				}
			
			 stuMaster.setName(stuDTO.getName());			 
			 stuMaster.setFatherName(stuDTO.getFatherName());
			 stuMaster.setMotherName(stuDTO.getMotherName());
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
				 stuMaster.setReleavingDate(currentDate); 
			 }
			 stuMaster.setUpdateDate(currentDate);
			 stuMaster.setDob(stuDTO.getDob());	
			 stuMaster.setBoardRegistration(stuDTO.getBoardRegistraion());	
			 stuMaster.setPhoto(stuDTO.getName()+stuDTO.getAdhar()+".jpg");
			 studentRepository.save(stuMaster);
			 stcClassSession.setClassIdFk(stuDTO.getClassId());
			 stcClassSession.setStudentIdFk(stuMaster.getStudentId());
			 stcClassSession.setIsActive(stuDTO.isActive());
			 stcClassSession.setSessionIdFk(stuDTO.getSessionId());
			 studentClassSessionRepository.save(stcClassSession);
		}catch (Exception e) {
			return null;
		}
		return stuDTO;
	}

	@Override
	public List<StudentDTO> findResultByClass(StudentSearchFielter ssf) {

		// TODO Auto-generated method stub
		List<StudentDTO> students=new ArrayList<>();
		SessionMaster sessionMaster= manageSessionMasterRepository.getActiveSession();
		
		
		List<StudentClassSession> list;		
			list=studentClassSessionRepository.findSessionIdClassID(ssf.getSessionId(),ssf.getClassId());	
		
		list.forEach(scs->{
			Optional<StudentMaster> stum=studentRepository.findById(scs.getStudentIdFk());
			Optional<SessionMaster> session=manageSessionMasterRepository.findById(scs.getSessionIdFk());
			Optional<ClassMaster> classMaster=classRepository.findById(scs.getClassIdFk());
			
			if(stum.isPresent()&&session.isPresent()&&classMaster.isPresent()) {
				 StudentDTO stuDto=new StudentDTO();
				 stuDto.setStudentId(stum.get().getStudentId());
				 stuDto.setName(stum.get().getName());
				 stuDto.setClassId(classMaster.get().getClassId());
				 stuDto.setClassName(classMaster.get().getClassName());
				 stuDto.setSessionId(session.get().getSessionId());
				 stuDto.setSessionName(session.get().getSessionName());
				 stuDto.setFatherName(stum.get().getFatherName());
				 stuDto.setMotherName(stum.get().getMotherName());
				 stuDto.setActive(stum.get().isActive());
				 stuDto.setContact1(stum.get().getContact1());
				 stuDto.setContact2(stum.get().getContact2());
				 stuDto.setCurrentAddress(stum.get().getCurrentAddress());
				 stuDto.setPermanentAddress(stum.get().getPermanentAddress());
				 stuDto.setAdhar(stum.get().getAdhar());
				 stuDto.setBloodGroup(stum.get().getBloodGroup());
				 stuDto.setAdmissionDate(stum.get().getAdmissionDate());
				 stuDto.setReleavingDate(stum.get().getReleavingDate());
				 stuDto.setUpdateDate(stum.get().getUpdateDate());
				 stuDto.setDob(stum.get().getDob());					
				 stuDto.setPhoto(stum.get().getPhoto());
				 stuDto.setSmesterSystem(ssf.getIsSmesterSystem());
				 stuDto.setGender(stum.get().getGender());
				 stuDto.setBoardRegistraion(stum.get().getBoardRegistration());
				 List<ClassSujectMapping> csl=	manageClassSubjectRepository.getClassSujectByclassId(ssf.getClassId());
				 List<ResultDTO> rlist=new ArrayList<>();
				 csl.forEach(rl->{
					 Optional<StudentReport> report=resultRepository.findSessionIdClassIDStudentIdExamIdSubjectId( ssf.getSessionId() ,ssf.getClassId() ,stuDto.getStudentId(),ssf.getExamId(),rl.getSubjectIdFk());
					 ResultDTO dto=new ResultDTO();
					 dto.setClassId(ssf.getClassId());
					 dto.setStudentId(stuDto.getStudentId());
					 dto.setSessionId(ssf.getSessionId());
					 dto.setExamId(ssf.getExamId());
					 Optional<ExamMaster> examMaster=manageExamMasterRepository.findById(ssf.getExamId());
					 dto.setExamName(examMaster.isPresent()?examMaster.get().getExamName():"" );
					 stuDto.setExamType(dto.getExamName());
					 dto.setSubjectId(rl.getSubjectIdFk());
					 Optional<SubjectMaster> subjectMaster=manageSubjectRepository.findById(rl.getSubjectIdFk());
					 dto.setSubjectName(subjectMaster.isPresent()?subjectMaster.get().getSubjectName():"");
					 if(report.isPresent()) {
						 dto.setResultId(report.get().getReportId());
						 dto.setMaxMark(report.get().getMaxMarks());
						 dto.setObtainMark(report.get().getMarksObtain()); 
						 
					 }else {
						 Optional<ExamClassMapping> ecm= manageExamClassRepository.getExamClassByExamclassId(ssf.getExamId(),ssf.getClassId());
						 dto.setResultId(0l);
						 if(ecm.isPresent()) {
						 dto.setMaxMark(ecm.get().getMaxMarks()!=null?ecm.get().getMaxMarks().toString():"");

						 }
						 dto.setObtainMark("");
					 }
					 rlist.add(dto);
					
					 
				 });
				 stuDto.setResult(rlist);
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
	public List<StudentDTO> saveResult(ResultSaveParameterDTO data) {

		
		data.getStudents().forEach(scs->{
		
			
				List<ClassSujectMapping> csl=	manageClassSubjectRepository.getClassSujectByclassId(scs.getClassId());
				 
				 scs.getResult().forEach(rl->{
					 Optional<StudentReport> report=resultRepository.findSessionIdClassIDStudentIdExamIdSubjectId( data.getSsf().getSessionId() ,data.getSsf().getClassId() ,scs.getStudentId(),data.getSsf().getExamId(),rl.getSubjectId());
					 
					 if(report.isPresent()) {
						 report.get().setMarksObtain(rl.getObtainMark());
						 report.get().setMaxMarks(rl.getMaxMark());						 
						 resultRepository.save(report.get());
					 }else {
						 StudentReport newrepot=new StudentReport();
						 newrepot.setClassIdFk(data.getSsf().getClassId());
						 newrepot.setExamIdFk(data.getSsf().getExamId());
						 newrepot.setSessionIdFk(data.getSsf().getSessionId());
						 newrepot.setSubjectIdFk(rl.getSubjectId());
						 newrepot.setStudentIdFk(scs.getStudentId());
						 newrepot.setMarksObtain(rl.getObtainMark());
						 newrepot.setMaxMarks(rl.getMaxMark());
						 resultRepository.save(newrepot);
					 }
					
					 
				 });
				 
				 
				 
			
		});
		return data.getStudents();
	
	}
	@Override
	public StudentDTO getStudentFee(StudentSearchFielter ssf) {
		// TODO Auto-generated method stub
		StudentDTO stuDto=new StudentDTO();
		Optional<SessionMaster> sessionMaster= manageSessionMasterRepository.findById(ssf.getSessionId());
		if(sessionMaster.isPresent()) {
			stuDto.setSessionId(sessionMaster.get().getSessionId());
			stuDto.setSessionName(sessionMaster.get().getSessionName());
		}
		Optional<ClassMaster> classMaster=classRepository.findById(ssf.getClassId());
		if(classMaster.isPresent()) {
			stuDto.setClassId(classMaster.get().getClassId());
			stuDto.setClassName(classMaster.get().getClassName());
		}
		
			Optional<StudentMaster> stum=studentRepository.findById(ssf.getStudentId());
			
			
			if(stum.isPresent()) {
				
				 stuDto.setStudentId(stum.get().getStudentId());
				 stuDto.setName(stum.get().getName());
				 stuDto.setClassId(classMaster.get().getClassId());
				 stuDto.setClassName(classMaster.get().getClassName());
				
				 stuDto.setFatherName(stum.get().getFatherName());
				 stuDto.setMotherName(stum.get().getMotherName());
				 stuDto.setActive(stum.get().isActive());
				 stuDto.setContact1(stum.get().getContact1());
				 stuDto.setContact2(stum.get().getContact2());
				 stuDto.setCurrentAddress(stum.get().getCurrentAddress());
				 stuDto.setPermanentAddress(stum.get().getPermanentAddress());
				 stuDto.setAdhar(stum.get().getAdhar());
				 stuDto.setBloodGroup(stum.get().getBloodGroup());
				 stuDto.setAdmissionDate(stum.get().getAdmissionDate());
				 stuDto.setReleavingDate(stum.get().getReleavingDate());
				 stuDto.setUpdateDate(stum.get().getUpdateDate());
				 stuDto.setDob(stum.get().getDob());					
				 stuDto.setPhoto(stum.get().getPhoto());
				
				 stuDto.setGender(stum.get().getGender());
				 stuDto.setBoardRegistraion(stum.get().getBoardRegistration());
				
				Optional<Fee> fee=feeRepository.findBySessClassStudent(ssf.getSessionId(),ssf.getClassId(),ssf.getStudentId());
				Fee feeValue;
				if(fee.isPresent()) {
					feeValue=fee.get();
					stuDto.setFee(fee.get());	
				}else {
					feeValue=new Fee();
					stuDto.setFee(feeValue);
				}
				
				stuDto.setTotal(perStudentTotal(feeValue));	 
			}
			
		return stuDto;
	}
	@Override
	@Transactional
	public StudentDTO saveFee(StudentDTO ssf) {
		// TODO Auto-generated method stub
		StudentDTO stuDto=new StudentDTO();
		Optional<SessionMaster> sessionMaster= manageSessionMasterRepository.findById(ssf.getSessionId());
		if(sessionMaster.isPresent()) {
			stuDto.setSessionId(sessionMaster.get().getSessionId());
			stuDto.setSessionName(sessionMaster.get().getSessionName());
		}
		Optional<ClassMaster> classMaster=classRepository.findById(ssf.getClassId());
		if(classMaster.isPresent()) {
			stuDto.setClassId(classMaster.get().getClassId());
			stuDto.setClassName(classMaster.get().getClassName());
		}
		
			Optional<StudentMaster> stum=studentRepository.findById(ssf.getStudentId());
			
			
			if(stum.isPresent()) {
				
				 stuDto.setStudentId(stum.get().getStudentId());
				 stuDto.setName(stum.get().getName());
				 stuDto.setClassId(classMaster.get().getClassId());
				 stuDto.setClassName(classMaster.get().getClassName());
				
				 stuDto.setFatherName(stum.get().getFatherName());
				 stuDto.setMotherName(stum.get().getMotherName());
				 stuDto.setActive(stum.get().isActive());
				 stuDto.setContact1(stum.get().getContact1());
				 stuDto.setContact2(stum.get().getContact2());
				 stuDto.setCurrentAddress(stum.get().getCurrentAddress());
				 stuDto.setPermanentAddress(stum.get().getPermanentAddress());
				 stuDto.setAdhar(stum.get().getAdhar());
				 stuDto.setBloodGroup(stum.get().getBloodGroup());
				 stuDto.setAdmissionDate(stum.get().getAdmissionDate());
				 stuDto.setReleavingDate(stum.get().getReleavingDate());
				 stuDto.setUpdateDate(stum.get().getUpdateDate());
				 stuDto.setDob(stum.get().getDob());					
				 stuDto.setPhoto(stum.get().getPhoto());
				
				 stuDto.setGender(stum.get().getGender());
				 stuDto.setBoardRegistraion(stum.get().getBoardRegistration());
				
				Fee fee=feeDetailAdd(ssf ) ;
				
				stuDto.setTotal(perStudentTotal(fee));
				stuDto.setFee(fee);
				 
			}
			stuDto.setMsg("Fee saved sucessfully");
		return stuDto;
	}
	private Fee feeDetailAdd(StudentDTO stuDto ) {
		Optional<Fee> feeExist=feeRepository.findBySessClassStudent(stuDto.getSessionId(),stuDto.getClassId(),stuDto.getStudentId());
		Fee fee=new Fee();
		SimpleDateFormat formDate = new SimpleDateFormat("dd-MM-yyyy");

	      
	       String currentDate = formDate.format(new Date());
		if(feeExist.isPresent()) {					
			fee.setFeeId(feeExist.get().getFeeId());
			fee.setCreateDate(feeExist.get().getCreateDate());
			fee.setUpdateDate(currentDate);
		}else {
				Optional<Fee> lastId=feeRepository.findFirstByOrderByFeeIdDesc();
				if(lastId.isPresent()) {							
					fee.setFeeId(lastId.get().getFeeId()+1);						
					
				}else {
					fee.setFeeId(1l);
				}
			
				fee.setCreateDate(currentDate);
				fee.setUpdateDate(currentDate);
		}
		fee.setClassIdFk(stuDto.getClassId());
		fee.setSessionIdFk(stuDto.getSessionId());
		fee.setStudentIdFk(stuDto.getStudentId());
		fee.setAprF(stuDto.getFee().getAprF());
		fee.setMayF(stuDto.getFee().getMayF());
		fee.setJuneF(stuDto.getFee().getJuneF());
		fee.setJulyF(stuDto.getFee().getJulyF());
		fee.setAugF(stuDto.getFee().getAugF());
		fee.setSeptF(stuDto.getFee().getSeptF());
		fee.setOctF(stuDto.getFee().getOctF());
		fee.setNovF(stuDto.getFee().getNovF());
		fee.setDecemF(stuDto.getFee().getDecemF());
		fee.setJanF(stuDto.getFee().getJanF());
		fee.setFebF(stuDto.getFee().getFebF());
		fee.setMarF(stuDto.getFee().getMarF());
		fee.setAprT(stuDto.getFee().getAprT());
		  fee.setMayT(stuDto.getFee().getMayT());
			fee.setJuneT(stuDto.getFee().getJuneT());
			fee.setJulyT(stuDto.getFee().getJulyT());
			fee.setAugT(stuDto.getFee().getAugT());
			fee.setSeptT(stuDto.getFee().getSeptT());
			fee.setOctT(stuDto.getFee().getOctT());
			fee.setNovT(stuDto.getFee().getNovT());
			fee.setDecemT(stuDto.getFee().getDecemT());
			fee.setJanT(stuDto.getFee().getJanT());
			fee.setFebT(stuDto.getFee().getFebT());
			fee.setMarT(stuDto.getFee().getMarT());
			fee.setAddmissionFee(stuDto.getFee().getAddmissionFee());
			fee.setOtherFee(stuDto.getFee().getOtherFee());
			fee.setComment(stuDto.getFee().getComment());
		feeRepository.save(fee);
		return fee;
	}

	private long perStudentTotal(Fee fee) {
		long result = 0l;
		result = fee.getAddmissionFee() + fee.getOtherFee() + fee.getAprF() + fee.getMayF() + fee.getJuneF()
				+ fee.getJulyF() + fee.getAugF() + fee.getSeptF() + fee.getOctF() + fee.getNovF() + fee.getDecemF()
				+ fee.getJanF() + fee.getFebF() + fee.getMarF() + fee.getAprT() + fee.getMayT() + fee.getJuneT()
				+ fee.getJulyT() + fee.getAugT() + fee.getSeptT() + fee.getOctT() + fee.getNovT() + fee.getDecemT()
				+ fee.getJanT() + fee.getFebT() + fee.getMarT();
		return result;
	}

	@Override
	public List<StudentDTO> findAllStudentWithFee(StudentSearchFielter ssf) {

		// TODO Auto-generated method stub
		List<StudentDTO> students=new ArrayList<>();
		SessionMaster sessionMaster= manageSessionMasterRepository.getActiveSession();
		
		if(ssf!=null && ssf.getSessionId()!=null &&  ssf.getSessionId() >0) {
			
		}else {
			ssf.setSessionId(sessionMaster.getSessionId());
		}
		List<StudentClassSession> list;
		if(ssf!=null && ssf.getClassId()!=null &&  ssf.getClassId() >0  ) {
			list=studentClassSessionRepository.findSessionIdClassID(ssf.getSessionId(),ssf.getClassId());
		}else {
			list=studentClassSessionRepository.findAllStudentBySessionId(ssf.getSessionId());
		}
		
		
		list.forEach(scs->{
			Optional<StudentMaster> stum=studentRepository.findById(scs.getStudentIdFk());
			Optional<SessionMaster> session=manageSessionMasterRepository.findById(scs.getSessionIdFk());
			Optional<ClassMaster> classMaster=classRepository.findById(scs.getClassIdFk());
			
			if(stum.isPresent()&&session.isPresent()&&classMaster.isPresent()) {
				 StudentDTO stuDto=new StudentDTO();
				 stuDto.setStudentId(stum.get().getStudentId());
				 stuDto.setName(stum.get().getName());
				 stuDto.setClassId(classMaster.get().getClassId());
				 stuDto.setClassName(classMaster.get().getClassName());
				 stuDto.setSessionId(session.get().getSessionId());
				 stuDto.setSessionName(session.get().getSessionName());
				 stuDto.setFatherName(stum.get().getFatherName());
				 stuDto.setMotherName(stum.get().getMotherName());
				 stuDto.setActive(stum.get().isActive());
				 stuDto.setContact1(stum.get().getContact1());
				 stuDto.setContact2(stum.get().getContact2());
				 stuDto.setCurrentAddress(stum.get().getCurrentAddress());
				 stuDto.setPermanentAddress(stum.get().getPermanentAddress());
				 stuDto.setAdhar(stum.get().getAdhar());
				 stuDto.setBloodGroup(stum.get().getBloodGroup());
				 stuDto.setAdmissionDate(stum.get().getAdmissionDate());
				 stuDto.setReleavingDate(stum.get().getReleavingDate());
				 stuDto.setUpdateDate(stum.get().getUpdateDate());
				 stuDto.setGender(stum.get().getGender());
				 stuDto.setDob(stum.get().getDob());					
				 stuDto.setPhoto(stum.get().getPhoto());
				 stuDto.setBoardRegistraion(stum.get().getBoardRegistration());
				 Optional<Fee> feeExist=feeRepository.findBySessClassStudent(stuDto.getSessionId(),stuDto.getClassId(),stuDto.getStudentId());
				 if(feeExist.isPresent()) {
					 stuDto.setFee(feeExist.get()); 
					 stuDto.setTotal(perStudentTotal(feeExist.get()));
				 }else {
					 Fee fee=new Fee();
					 stuDto.setFee(fee); 
					 stuDto.setTotal(perStudentTotal(fee));
				 }
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
	public List<FeeHistoryDTO> getFeeHistory(Integer sessionId, Integer classId, Long studentId) {
		// TODO Auto-generated method stub
		List<FeeHistoryDTO> result=new ArrayList<>();
		List<FeeHistory> list= feeHistoryRepository.findBySessClassStudentFeeHistory(sessionId, classId, studentId);
		Optional<Fee> fee= feeRepository.findBySessClassStudent(sessionId, classId, studentId);
	if(list!=null && list.size()>0) {
		for(int i=0 ;i<list.size();i++) {
			FeeHistoryDTO dto=new FeeHistoryDTO();
			dto.setTotal((long) (list.get(i).getAddmissionFee() + list.get(i).getOtherFee() + list.get(i).getAprF() + list.get(i).getMayF() + list.get(i).getJuneF()
					+ list.get(i).getJulyF() + list.get(i).getAugF() + list.get(i).getSeptF() + list.get(i).getOctF() + list.get(i).getNovF() + list.get(i).getDecemF()
					+ list.get(i).getJanF() + list.get(i).getFebF() + list.get(i).getMarF() + list.get(i).getAprT() + list.get(i).getMayT() + list.get(i).getJuneT()
					+ list.get(i).getJulyT() + list.get(i).getAugT() + list.get(i).getSeptT() + list.get(i).getOctT() + list.get(i).getNovT() + list.get(i).getDecemT()
					+ list.get(i).getJanT() + list.get(i).getFebT() + list.get(i).getMarT()));
			if(i==0) {
				
				dto.setLastPaid(dto.getTotal());
			}else {
				
				dto.setLastPaid((long) (list.get(i).getAddmissionFee() + list.get(i).getOtherFee() + list.get(i).getAprF() + list.get(i).getMayF() + list.get(i).getJuneF()
						+ list.get(i).getJulyF() + list.get(i).getAugF() + list.get(i).getSeptF() + list.get(i).getOctF() + list.get(i).getNovF() + list.get(i).getDecemF()
						+ list.get(i).getJanF() + list.get(i).getFebF() + list.get(i).getMarF() + list.get(i).getAprT() + list.get(i).getMayT() + list.get(i).getJuneT()
						+ list.get(i).getJulyT() + list.get(i).getAugT() + list.get(i).getSeptT() + list.get(i).getOctT() + list.get(i).getNovT() + list.get(i).getDecemT()
						+ list.get(i).getJanT() + list.get(i).getFebT() + list.get(i).getMarT())-((long) (list.get(i-1).getAddmissionFee() + list.get(i-1).getOtherFee() + list.get(i-1).getAprF() + list.get(i-1).getMayF() + list.get(i-1).getJuneF()
								+ list.get(i-1).getJulyF() + list.get(i-1).getAugF() + list.get(i-1).getSeptF() + list.get(i-1).getOctF() + list.get(i-1).getNovF() + list.get(i-1).getDecemF()
								+ list.get(i-1).getJanF() + list.get(i-1).getFebF() + list.get(i-1).getMarF() + list.get(i-1).getAprT() + list.get(i-1).getMayT() + list.get(i-1).getJuneT()
								+ list.get(i-1).getJulyT() + list.get(i-1).getAugT() + list.get(i-1).getSeptT() + list.get(i-1).getOctT() + list.get(i-1).getNovT() + list.get(i-1).getDecemT()
								+ list.get(i-1).getJanT() + list.get(i-1).getFebT() + list.get(i-1).getMarT())));
			}
			dto.setUpdateDate(list.get(i).getUpdateDate());
			dto.setComment(list.get(i).getComment());
			result.add(dto);
			
		}
	}
	if(fee.isPresent()) {
		FeeHistoryDTO dto=new FeeHistoryDTO();	
		dto.setTotal((long) fee.get().getAddmissionFee() + fee.get().getOtherFee() + fee.get().getAprF() + fee.get().getMayF() + fee.get().getJuneF()
				+ fee.get().getJulyF() + fee.get().getAugF() + fee.get().getSeptF() + fee.get().getOctF() + fee.get().getNovF() + fee.get().getDecemF()
				+ fee.get().getJanF() + fee.get().getFebF() + fee.get().getMarF() + fee.get().getAprT() + fee.get().getMayT() + fee.get().getJuneT()
				+ fee.get().getJulyT() + fee.get().getAugT() + fee.get().getSeptT() + fee.get().getOctT() + fee.get().getNovT() + fee.get().getDecemT()
				+ fee.get().getJanT() + fee.get().getFebT() + fee.get().getMarT());
	if(result.size()>0) {
		dto.setLastPaid(dto.getTotal()-result.get(result.size()-1).getTotal());
	}else {
		dto.setLastPaid(dto.getTotal());
	}
	dto.setUpdateDate(fee.get().getUpdateDate());
	dto.setComment(fee.get().getComment());
	result.add(dto);
	}
	return result;
	}

	@Override
	public List<StudentDTO> getAttendence(StudentSearchFielter ssf) {

		// TODO Auto-generated method stub
		List<StudentDTO> students=new ArrayList<>();
		SessionMaster sessionMaster= manageSessionMasterRepository.getActiveSession();
		
		if(ssf!=null && ssf.getSessionId()!=null &&  ssf.getSessionId() >0) {
			
		}else {
			ssf.setSessionId(sessionMaster.getSessionId());
		}
		List<StudentClassSession> list;
		if(ssf!=null && ssf.getClassId()!=null &&  ssf.getClassId() >0  ) {
			list=studentClassSessionRepository.findSessionIdClassID(ssf.getSessionId(),ssf.getClassId());
		}else {
			list=studentClassSessionRepository.findAllStudentBySessionId(ssf.getSessionId());
		}
		
		
		list.forEach(scs->{
			Optional<StudentMaster> stum=studentRepository.findById(scs.getStudentIdFk());
			Optional<SessionMaster> session=manageSessionMasterRepository.findById(scs.getSessionIdFk());
			Optional<ClassMaster> classMaster=classRepository.findById(scs.getClassIdFk());
			
			if(stum.isPresent()&&session.isPresent()&&classMaster.isPresent()) {
				 StudentDTO stuDto=new StudentDTO();
				 stuDto.setStudentId(stum.get().getStudentId());
				 stuDto.setName(stum.get().getName());
				 stuDto.setClassId(classMaster.get().getClassId());
				 stuDto.setClassName(classMaster.get().getClassName());
				 stuDto.setSessionId(session.get().getSessionId());
				 stuDto.setSessionName(session.get().getSessionName());
				 stuDto.setFatherName(stum.get().getFatherName());
				 stuDto.setMotherName(stum.get().getMotherName());
				 stuDto.setActive(stum.get().isActive());
				 stuDto.setContact1(stum.get().getContact1());
				 stuDto.setContact2(stum.get().getContact2());
				 stuDto.setCurrentAddress(stum.get().getCurrentAddress());
				 stuDto.setPermanentAddress(stum.get().getPermanentAddress());
				 stuDto.setAdhar(stum.get().getAdhar());
				 stuDto.setBloodGroup(stum.get().getBloodGroup());
				 stuDto.setAdmissionDate(stum.get().getAdmissionDate());
				 stuDto.setReleavingDate(stum.get().getReleavingDate());
				 stuDto.setUpdateDate(stum.get().getUpdateDate());
				 stuDto.setGender(stum.get().getGender());
				 stuDto.setDob(stum.get().getDob());					
				 stuDto.setPhoto(stum.get().getPhoto());
				 stuDto.setBoardRegistraion(stum.get().getBoardRegistration());
				 Optional<Attendence> feeExist=attendenceRepository.findByDateAndStudent(ssf.getAttendenceDate(),stuDto.getStudentId());
				 if(feeExist.isPresent()) {
					 stuDto.setAttendence(feeExist.get()) ;
					
				 }else {
					 stuDto.setAttendence(new Attendence()) ;
				 }
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
	@Transactional
	public void saveAttendence(List<StudentDTO> studentDTOs) {
		for( StudentDTO studentDTO : studentDTOs) {
		 Optional<Attendence> feeExist=attendenceRepository.findByDateAndStudent(studentDTO.getAttendence().getAttendenceeDate(),studentDTO.getStudentId());
		 SimpleDateFormat formDate = new SimpleDateFormat("dd-MM-yyyy");

	      
	       String currentDate = formDate.format(new Date());
		 if(feeExist.isPresent()) {
			 feeExist.get().setPresent(studentDTO.getAttendence().isPresent());
			 feeExist.get().setUpdateDate(currentDate);
			 attendenceRepository.save(feeExist.get());
			
		 }else {
			 Attendence attendence=new Attendence();
				/*
				 * Optional<Attendence> lastId=
				 * attendenceRepository.findFirstByOrderByAttendenceIdDesc();
				 * if(lastId.isPresent()) {
				 * attendence.setAttendenceId(lastId.get().getAttendenceId()+1); }else {
				 * attendence.setAttendenceId(1l); }
				 */
			 attendence.setPresent(studentDTO.getAttendence().isPresent());
			 attendence.setUpdateDate(currentDate);
			 attendence.setStudentIdFk(studentDTO.getStudentId());
			 attendence.setCreateDate(currentDate);
			 attendence.setAttendenceeDate(studentDTO.getAttendence().getAttendenceeDate());
			 attendenceRepository.save(attendence);
			
		 }
		}
		
	}
	public String savePhoto(Long id, MultipartFile file) {
		Optional<StudentMaster> student = studentRepository.findById(id);
		
		
	      
		if(student.isPresent()) {
			 File directory = new File(environment.getProperty("photoPath"));
	   try {
		   
		if (! directory.exists()){
            directory.mkdir();
           
			file.transferTo(new File(environment.getProperty("photoPath")+File.separatorChar+student.get().getStudentId()+".jpg"));
		
        }else {
        	file.transferTo(new File(environment.getProperty("photoPath")+File.separatorChar+student.get().getStudentId()+".jpg"));
        }
		
	     } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return "success";
	}
	
	
}
