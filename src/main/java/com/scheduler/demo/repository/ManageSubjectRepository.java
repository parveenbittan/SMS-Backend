package com.scheduler.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.scheduler.demo.entity.SubjectMaster;
@Repository
public interface ManageSubjectRepository extends JpaRepository<SubjectMaster, Integer>{
	List<SubjectMaster> findByOrderBySubjectId();
	Optional<SubjectMaster> findById(Integer id);
	Optional<SubjectMaster> findFirstByOrderBySubjectIdDesc();
	@Query(" FROM com.scheduler.demo.entity.SubjectMaster s where s.isActive =true  ")
	List<SubjectMaster> getActiveSubject();
	
}
