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

@Entity(name = "exam_class_mapping")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExamClassMapping {
	@Id  
   // @GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="exam_class_id", nullable=false)
	@JsonProperty("examClassId")
	private Integer examClassId;
	@Column (name="exam_id_fk", nullable=false)
	@JsonProperty("examId")
	private Integer examId;
	@Column (name="class_id_fk", nullable=false)
	@JsonProperty("classId")
	private Integer classId;
	@Column (name="max_marks", nullable=false)
	@JsonProperty("max_marks")
	private Integer maxMarks;
	
}

