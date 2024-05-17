package com.scheduler.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.scheduler.demo.entity.SessionMaster;
@Repository
public interface ManageSessionMasterRepository extends JpaRepository<SessionMaster, Integer>{
	List<SessionMaster> findByOrderBySessionId();
	Optional<SessionMaster> findById(Integer id);
	Optional<SessionMaster> findFirstByOrderBySessionIdDesc();
	@Query(" FROM com.scheduler.demo.entity.SessionMaster s where s.isActive =true ORDER BY s.sessionId LIMIT 1 ")
	SessionMaster getActiveSession();
	
}
