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

@Entity(name = "attendence")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Attendence {
	@Id  
    @GeneratedValue(strategy=GenerationType.AUTO)
	
	@Column (name="attendence_id", nullable=false)
	@JsonProperty("attendenceId")
	Long attendenceId;
	@Column (name="student_id_fk", nullable=false)
	@JsonProperty("studentIdFk")
	Long studentIdFk;
	
	@Column (name="attendence_date")
	@JsonProperty("attendenceDate")
	String  attendenceeDate;
	@Column (name="create_date")
	@JsonProperty("createDate")
	String  createDate;
	@Column (name="update_date")
	@JsonProperty("updateDate")
	String  updateDate;
	@Column (name="is_present")
	@JsonProperty("isPresent")
	boolean  isPresent;
	
}
