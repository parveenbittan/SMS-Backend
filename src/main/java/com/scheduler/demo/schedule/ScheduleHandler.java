package com.scheduler.demo.schedule;

import java.time.LocalDateTime;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.scheduler.demo.entity.JobDetail;

@Configuration
@EnableScheduling
@EnableAsync(proxyTargetClass = true)
public class ScheduleHandler {
	 static LinkedList<JobDetail> list=new LinkedList<>();
	 static Deque<JobDetail> dqlist=new LinkedList<>();
	static boolean running =false;
	
	@Bean("schedulePool1")
	public Executor jobPool() {
		
		ThreadPoolTaskExecutor exec = new ThreadPoolTaskExecutor();
		exec.setCorePoolSize(1);
		exec.setMaxPoolSize(1);
		exec.setQueueCapacity(10);
		exec.setThreadNamePrefix("first-");
		exec.initialize();
		return exec;
	}

	@Bean("schedulePool2")
	public Executor jobPool2() {
		ThreadPoolTaskExecutor exec = new ThreadPoolTaskExecutor();
		exec.setCorePoolSize(1);
		exec.setMaxPoolSize(1);
		exec.setQueueCapacity(10);
		exec.setThreadNamePrefix("second-");
		exec.initialize();
		return exec;
	}

	@Bean("schedulePool3")
	public Executor jobPool3() {
		ThreadPoolTaskExecutor exec = new ThreadPoolTaskExecutor();
		exec.setCorePoolSize(1);
		exec.setMaxPoolSize(1);
		exec.setQueueCapacity(10);
		exec.setThreadNamePrefix("second-");
		exec.initialize();
		return exec;
	}

	@Async("schedulePool1")
	// @Scheduled(fixedRateString = "${fixed-rate.in.milliseconds}")
	public void Job1(JobDetail job) {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			public void run() {
				System.out.println("First job is running." + job.getJobName() + "  time : "
						+ LocalDateTime.now().toLocalTime());
			}
		};
		// Schedule the task to run repeatedly after an interval of job detail
		timer.schedule(task, Integer.valueOf(job.getScheduleInMinutes()) * 1000,
				Integer.valueOf(job.getScheduleInMinutes()) * 1000);

	   

	}

	@Async("schedulePool2")
	// @Scheduled(fixedDelayString = "${fixed-delay.in.milliseconds}")
	public void Job2(JobDetail job) {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			public void run() {
				System.out.println("Second job is running." + job.getJobName() + "  time : "
						+ LocalDateTime.now().toLocalTime());
			}
		};
		// Schedule the task to run repeatedly after an interval of job detail
		timer.schedule(task, Integer.valueOf(job.getScheduleInMinutes()) * 1000,
				Integer.valueOf(job.getScheduleInMinutes()) * 1000);
	}

	@Async("schedulePool3")
	// @Scheduled(cron = "${cron.expression}")
	public void Job3(JobDetail job) {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			public void run() {
				System.out.println( "Third job is running." + job.getJobName()
						+ "  time : " + LocalDateTime.now().toLocalTime());
			}
		};
		// Schedule the task to run repeatedly after an interval of job detail
		timer.schedule(task, Integer.valueOf(job.getScheduleInMinutes()) * 1000,
				Integer.valueOf(job.getScheduleInMinutes()) * 1000);
	}

	@Async("schedulePool1")
	// @Scheduled(fixedDelay = 30000 )
	public void Job4(JobDetail job) {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			public void run() {
				System.out.println("Forth job is running." + job.getJobName() + "  time : "
						+ LocalDateTime.now().toLocalTime());
			}
		};
		// Schedule the task to run repeatedly after an interval of job detail
		timer.schedule(task, Integer.valueOf(job.getScheduleInMinutes()) * 1000,
				Integer.valueOf(job.getScheduleInMinutes()) * 1000);
	}

	@Async("schedulePool2")
	// @Scheduled(fixedDelay = 120000 )
	public void Job5(JobDetail job) {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			public void run() {
				System.out.println("Fifth job is running." + job.getJobName() + "  time : "
						+ LocalDateTime.now().toLocalTime());
			}
		};
		// Schedule the task to run repeatedly after an interval of job detail
		timer.schedule(task, Integer.valueOf(job.getScheduleInMinutes()) * 1000,
				Integer.valueOf(job.getScheduleInMinutes()) * 1000);

	}
	public static void scenario3(JobDetail job) {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			public void run() {
			try {
				if(!running) {
					running=true;
					//list.add(job);
					System.out.println(job.getJobName()+" starts.");	
				System.out.println("Running job is  " + job.getJobName() + "  time : "
						+ LocalDateTime.now().toLocalTime());
				Thread.currentThread().sleep(10000);
				System.out.println(job.getJobName()+" complete.");				
				
				//list.remove(job);
				running=false;
				}else {
					System.out.println(job.getJobName()+" is already running");
				}
				
			} catch (InterruptedException e) {
				System.out.println(job.getJobName()+" is already running");
				
			}
			}
			};
			
			timer.schedule(task, Integer.valueOf(job.getScheduleInMinutes()) * 1000,
					Integer.valueOf(job.getScheduleInMinutes()) * 1000);
	}
	public static void scenario4(List<JobDetail> jobs) {
		
		
		jobs.forEach(n->{System.out.println("------->"+n.getJobName());});
		Timer timer = new Timer();
		
		
			TimerTask task = new TimerTask() {
			public void run() {
				if(list.size()==0) {
				list.addAll(jobs);
				}
				while (list.size()>0) {
				JobDetail job=list.getFirst();
				try {
					if(!running) {
						running=true;
						//list.add(job);
						System.out.println(job.getJobName()+" starts.");	
					System.out.println("Running job is  " + job.getJobName() + "  time : "
							+ LocalDateTime.now().toLocalTime());
					Thread.currentThread().sleep(1000);
					System.out.println(job.getJobName()+" complete.");
					
					list.addLast(job);
					list.removeFirst();
					running=false;
					}else {
						System.out.println(job.getJobName()+" is already running");
					}
					
				} catch (InterruptedException e) {
					System.out.println(job.getJobName()+" is already running");
					
				}
				}
			}
		};	
		
		
		timer.schedule(task, 6000,6000);
	}
}
