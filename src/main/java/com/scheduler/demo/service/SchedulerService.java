package com.scheduler.demo.service;

import java.util.List;
import java.util.Optional;

import com.scheduler.demo.entity.JobDetail;

public interface SchedulerService {
	public List<JobDetail> findAllJobs();
	public Optional<JobDetail> findByID(Integer id);
	public List<JobDetail> findByOrderByPriorityAsc();
}
