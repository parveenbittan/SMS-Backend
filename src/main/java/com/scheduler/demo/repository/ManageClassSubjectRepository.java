package com.scheduler.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.scheduler.demo.entity.ClassSujectMapping;
import com.scheduler.demo.entity.ItemMaster;
@Repository
public interface ManageClassSubjectRepository extends JpaRepository<ClassSujectMapping, Integer>{
	List<ClassSujectMapping> findByOrderByClassIdFk();	
	Optional<ClassSujectMapping> findFirstByOrderByClassSubjectMappingIdDesc();
	@Query(" FROM com.scheduler.demo.entity.ClassSujectMapping s where s.isActive =true ORDER By s.classIdFk ")
	List<ClassSujectMapping> getActiveClassSujectMapping();
	@Query(" FROM com.scheduler.demo.entity.ClassSujectMapping s where s.classIdFk=:classID and s.isActive =true ORDER By s.classIdFk ")
	List<ClassSujectMapping> getClassSujectByclassId(@Param("classID")Integer classID);
	
}
