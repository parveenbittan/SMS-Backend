package com.scheduler.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.scheduler.demo.entity.FeeHistory;

public interface FeeHistoryRepository extends JpaRepository<FeeHistory, Long>{
	
	@Query(" FROM com.scheduler.demo.entity.FeeHistory s where s.sessionIdFk =:sessionId and s.classIdFk=:classId and s.studentIdFk=:studentId ")
	List<FeeHistory> findBySessClassStudentFeeHistory(@Param("sessionId")Integer sessionId,@Param("classId")Integer classId ,@Param("studentId")Long studentId );

	
}
