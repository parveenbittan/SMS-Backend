package com.scheduler.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.scheduler.demo.entity.Fee;

public interface FeeRepository extends JpaRepository<Fee, Long>{
	
	@Query(" FROM com.scheduler.demo.entity.Fee s where s.sessionIdFk =:sessionId and s.classIdFk=:classId and s.studentIdFk=:studentId order by s.studentIdFk Limit 1")
	Optional<Fee> findBySessClassStudent(@Param("sessionId")Integer sessionId,@Param("classId")Integer classId ,@Param("studentId")Long studentId );

	Optional<Fee> findFirstByOrderByFeeIdDesc();
}
