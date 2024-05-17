package com.scheduler.demo.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scheduler.demo.entity.JobDetail;
import com.scheduler.demo.repository.SchedulerRepository;
import com.scheduler.demo.service.SchedulerService;
@Service
public class SchedulerServiceImpl implements SchedulerService {
	@Autowired
	SchedulerRepository schedulerRepository;
	public List<JobDetail> findAllJobs(){
		return schedulerRepository.findAll();
	}
	public Optional<JobDetail> findByID(Integer id){
		return schedulerRepository.findById(id);
	}
	@Override
	public List<JobDetail> findByOrderByPriorityAsc() {
		return schedulerRepository.findByOrderByPriorityAsc();
	}
}
