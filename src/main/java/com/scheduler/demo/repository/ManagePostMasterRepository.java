package com.scheduler.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.scheduler.demo.entity.PostMaster;
@Repository
public interface ManagePostMasterRepository extends JpaRepository<PostMaster, Integer>{
	List<PostMaster> findByOrderByPostId();
	Optional<PostMaster> findById(Integer id);
	Optional<PostMaster> findFirstByOrderByPostIdDesc();
	@Query("FROM com.scheduler.demo.entity.PostMaster s where s.isActive =true  ")
	List<PostMaster> getActivePost();
	
}
