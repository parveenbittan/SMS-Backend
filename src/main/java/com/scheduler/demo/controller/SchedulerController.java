package com.scheduler.demo.controller;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scheduler.demo.entity.JobDetail;
import com.scheduler.demo.schedule.ScheduleHandler;
import com.scheduler.demo.service.SchedulerService;

@RestController
@RequestMapping("/scheduler")
public class SchedulerController {
	@Autowired
	SchedulerService schedulerService;
    //API to find all jobs.
	@GetMapping("/jobs")
	public ResponseEntity<List<JobDetail>> getAllJobs() {
		try {
			List<JobDetail> jobs = schedulerService.findAllJobs();
			return new ResponseEntity<>(jobs, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	//API to find all job by id.
	@GetMapping("/job/{id}")
	public ResponseEntity<JobDetail> getTutorialById(@PathVariable("id") int id) {
		Optional<JobDetail> tutorialData = schedulerService.findByID(id);
		if (tutorialData.isPresent()) {
			return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//Scenario1 : API to consume job detail for execution.
		@GetMapping("/executeJob/{id}")
		public ResponseEntity<String> executeJob(@PathVariable("id") int id) {
			Optional<JobDetail> tutorialData = schedulerService.findByID(id);
			if (tutorialData.isPresent()) {
				try {
					JobDetail job=tutorialData.get();
					ScheduleHandler instance = new ScheduleHandler();
					Method method = ScheduleHandler.class.getMethod(job.getJobName(), JobDetail.class);
					method.invoke(instance, job);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return new ResponseEntity<>("Job :"+id+" started" , HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		//Scenario2 : API to consume job detail for execution.
		@GetMapping("/executeJobs")
		public ResponseEntity<String> executeJobs() {
			try {

				List<JobDetail> jobs = schedulerService.findAllJobs();
				jobs.forEach(j -> {
					try {

						ScheduleHandler instance = new ScheduleHandler();
						Method method = ScheduleHandler.class.getMethod(j.getJobName(), JobDetail.class);
						method.invoke(instance, j);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
				return new ResponseEntity<>("All Jobs started" , HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		//Scenario3 : API to consume job detail for execution.
				@GetMapping("/scenario3/{id}")
				public ResponseEntity<String> scenario3(@PathVariable("id") int id) {
					Optional<JobDetail> tutorialData = schedulerService.findByID(id);
					if (tutorialData.isPresent()) {
						try {
							JobDetail job=tutorialData.get();
							ScheduleHandler.scenario3(job);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return new ResponseEntity<>("Job :"+id+" started" , HttpStatus.OK);
					} else {
						return new ResponseEntity<>(HttpStatus.NOT_FOUND);
					}
				}
				//Scenario4 : API to consume job detail for execution.
				@GetMapping("/scenario4")
				public ResponseEntity<String> scenario4() {
					List<JobDetail> jobs = schedulerService.findByOrderByPriorityAsc();
					
						try {
							
							ScheduleHandler.scenario4(jobs);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return new ResponseEntity<>("Job  started" , HttpStatus.OK);
					
				}
}
