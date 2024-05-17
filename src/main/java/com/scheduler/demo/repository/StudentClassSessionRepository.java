package com.scheduler.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.scheduler.demo.entity.StudentClassSession;
@Repository
public interface StudentClassSessionRepository extends JpaRepository<StudentClassSession, Long>{
	@Query(" FROM com.scheduler.demo.entity.StudentClassSession s where s.sessionIdFk =:sessionId and s.classIdFk=:classID ORDER BY s.classIdFk ")
	List<StudentClassSession> findSessionIdClassID(@Param("sessionId")Integer sessionId ,@Param("classID")Integer classID);
	@Query(" FROM com.scheduler.demo.entity.StudentClassSession s where s.sessionIdFk =:sessionId  ORDER BY s.classIdFk ")
	List<StudentClassSession> findAllStudentBySessionId(@Param("sessionId")Integer sessionId  );
	
	Optional<StudentClassSession> findById(Long id);
	Optional<StudentClassSession> findFirstByOrderByStudentClassSessionIdDesc();
	@Query(" FROM com.scheduler.demo.entity.StudentClassSession s where s.isActive =true and s.sessionIdFk =:sessionId  ORDER BY s.classIdFk  ")
	List<StudentClassSession> getActiveStudentClassSession(@Param("sessionId")Integer sessionId );
	@Query(" FROM com.scheduler.demo.entity.StudentClassSession s where s.studentIdFk =:stuId and s.sessionIdFk=:sessionId ORDER BY s.sessionIdFk LIMIT 1  ")
	Optional<StudentClassSession> findByStudentAndSession(@Param("stuId")Long stuId ,@Param("sessionId")Integer sessionId );
	
}
