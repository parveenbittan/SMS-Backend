package com.scheduler.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "job_detail")


@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobDetail {
	@Id  
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="job_id", nullable=false)
	@JsonProperty("job_id")
	private Integer jobId;
	@Column (name="job_name", nullable=false)
	@JsonProperty("job_name")
	private String jobName;
	@Column (name="schedule_in_seconds", nullable=false)
	@JsonProperty("schedule_in_seconds")
	private String scheduleInMinutes;
	@Column (name="priority", nullable=false)
	@JsonProperty("priority")
	private String priority;
	/*
	 * public Integer getJobId() { return jobId; } public void setJobId(Integer
	 * jobId) { this.jobId = jobId; } public String getJobName() { return jobName; }
	 * public void setJobName(String jobName) { this.jobName = jobName; } public
	 * String getScheduleInMinutes() { return scheduleInMinutes; } public void
	 * setScheduleInMinutes(String scheduleInMinutes) { this.scheduleInMinutes =
	 * scheduleInMinutes; } public String getPriority() { return priority; } public
	 * void setPriority(String priority) { this.priority = priority; }
	 */
	
}
