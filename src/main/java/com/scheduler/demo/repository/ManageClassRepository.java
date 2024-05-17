package com.scheduler.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.scheduler.demo.entity.ClassMaster;
@Repository
public interface ManageClassRepository extends JpaRepository<ClassMaster, Integer>{
	List<ClassMaster> findByOrderByClassId();
	Optional<ClassMaster> findById(Integer id);
	Optional<ClassMaster> findFirstByOrderByClassIdDesc();
	@Query("FROM com.scheduler.demo.entity.ClassMaster cm where cm.isActive =true ORDER BY cm.classId ")
	List<ClassMaster> getActiveClasses();
	
}
