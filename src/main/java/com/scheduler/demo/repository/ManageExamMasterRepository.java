package com.scheduler.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.scheduler.demo.entity.ExamMaster;
@Repository
public interface ManageExamMasterRepository extends JpaRepository<ExamMaster, Integer>{
	List<ExamMaster> findByOrderByExamId();
	Optional<ExamMaster> findById(Integer id);
	Optional<ExamMaster> findFirstByOrderByExamIdDesc();
	@Query("FROM com.scheduler.demo.entity.ExamMaster s where s.isActive =true  ")
	List<ExamMaster> getActiveExam();
	
}
