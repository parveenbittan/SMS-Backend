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
@Entity(name = "class_master")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClassMaster {
	@Id  
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="class_id", nullable=false)
	@JsonProperty("classId")
	private Integer classId;
	@Column (name="class_name", nullable=false)
	@JsonProperty("className")
	private String className;
	@Column (name="class_desc", nullable=false)
	@JsonProperty("classDesc")
	private String classDesc;
	
	@Column (name="is_active", nullable=false)
	@JsonProperty("isActive")
	private Boolean isActive;
	
}
