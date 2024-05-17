package com.scheduler.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.scheduler.demo.entity.ExamClassMapping;
@Repository
public interface ManageExamClassRepository extends JpaRepository<ExamClassMapping, Integer>{
	List<ExamClassMapping> findByOrderByClassId();	
	Optional<ExamClassMapping> findFirstByOrderByExamClassIdDesc();
	@Query(" FROM com.scheduler.demo.entity.ExamClassMapping s  ORDER By s.classId ")
	List<ExamClassMapping> getExamClassMapping();
	@Query(" FROM com.scheduler.demo.entity.ExamClassMapping s where s.classId=:classID  ORDER By s.classId ")
	List<ExamClassMapping> getExamClassByclassId(@Param("classID")Integer classID);
	@Query(" FROM com.scheduler.demo.entity.ExamClassMapping s where s.classId=:classID and s.examId=:examID  ORDER By s.classId Limit 1")
	Optional<ExamClassMapping> getExamClassByExamclassId(@Param("examID")Integer examID,@Param("classID")Integer classID);
	
}
