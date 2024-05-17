package com.scheduler.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.scheduler.demo.entity.StudentMaster;
@Repository
public interface StudentRepository extends JpaRepository<StudentMaster, Long>{
	List<StudentMaster> findByOrderByStudentId();
	Optional<StudentMaster> findById(Long id);
	Optional<StudentMaster> findFirstByOrderByStudentIdDesc();
	@Query("FROM com.scheduler.demo.entity.StudentMaster s where s.isActive =true  ")
	List<StudentMaster> getActiveStudent();
	
}
