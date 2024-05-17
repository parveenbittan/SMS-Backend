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
@Entity(name = "exam_master")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExamMaster {
	@Id  
    //@GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="exam_id", nullable=false)
	@JsonProperty("examId")
	private Integer examId;
	@Column (name="exam_name", nullable=false)
	@JsonProperty("examName")
	private String examName;
	@Column (name="exam_code", nullable=false)
	@JsonProperty("examCode")
	private String examCode;
	@Column (name="is_active", nullable=false)
	@JsonProperty("isActive")
	private Boolean isActive;
	
}
