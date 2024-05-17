package com.scheduler.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.scheduler.demo.entity.StudentReport;
@Repository
public interface ResulRepository extends JpaRepository<StudentReport, Long>{
	@Query(" FROM com.scheduler.demo.entity.StudentReport s where s.sessionIdFk =:sessionId and s.classIdFk=:classID and s.studentIdFk=:studentID and s.examIdFk=:examID and s.subjectIdFk=:subjectID ORDER BY s.classIdFk limit 1 ")
	Optional<StudentReport> findSessionIdClassIDStudentIdExamIdSubjectId(@Param("sessionId")Integer sessionId ,@Param("classID")Integer classID ,@Param("studentID")Long studentID,@Param("examID")Integer examID,@Param("subjectID")Integer subjectID);
	
	Optional<StudentReport> findById(Long id);
	Optional<StudentReport> findFirstByOrderByReportIdDesc();
	
	
}
