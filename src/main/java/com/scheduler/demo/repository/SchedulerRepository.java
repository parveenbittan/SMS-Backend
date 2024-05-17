package com.scheduler.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scheduler.demo.entity.JobDetail;
@Repository
public interface SchedulerRepository extends JpaRepository<JobDetail, Integer> {
	
	List<JobDetail> findAll();
	Optional<JobDetail> findById(Integer id);
	List<JobDetail> findByOrderByPriorityAsc();

}
