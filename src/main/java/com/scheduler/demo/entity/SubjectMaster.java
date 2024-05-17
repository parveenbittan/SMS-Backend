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
@Entity(name = "subject_master")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SubjectMaster {
	@Id  
    //@GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="subject_id", nullable=false)
	@JsonProperty("subjectId")
	private Integer subjectId;
	@Column (name="subject_name", nullable=false)
	@JsonProperty("subjectName")
	private String subjectName;
	@Column (name="subject_code", nullable=false)
	@JsonProperty("subjectCode")
	private String subjectCode;
	@Column (name="is_active", nullable=false)
	@JsonProperty("isActive")
	private Boolean isActive;
	
}
