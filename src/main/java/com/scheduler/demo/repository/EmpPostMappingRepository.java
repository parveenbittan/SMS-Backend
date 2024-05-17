package com.scheduler.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.scheduler.demo.entity.EmpPostnMapping;
@Repository
public interface EmpPostMappingRepository extends JpaRepository<EmpPostnMapping, Long>{
	
	List<EmpPostnMapping> findByOrderByEmpPostId();
	@Query(" FROM com.scheduler.demo.entity.EmpPostnMapping s where s.postIdFk =:postID  ORDER BY s.postIdFk ")
	List<EmpPostnMapping> findAllEmpByPostId(@Param("postID")Integer postID  );
	@Query(" FROM com.scheduler.demo.entity.EmpPostnMapping s where s.empIdFk =:empID  ORDER BY s.empIdFk limit 1")
	Optional<EmpPostnMapping> findEmpByEmpId(@Param("empID")Long empID  );
	Optional<EmpPostnMapping> findById(Long id);
	Optional<EmpPostnMapping> findFirstByOrderByEmpPostIdDesc();
	
	
	
}
