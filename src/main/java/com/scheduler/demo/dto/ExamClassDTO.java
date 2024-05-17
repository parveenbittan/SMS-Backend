package com.scheduler.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamClassDTO {
	@JsonProperty("examClassId")
	Integer examClassId;
	@JsonProperty("classId")
    Integer classId ;
	@JsonProperty("className")
    String  className;
	@JsonProperty("examId")
    Integer examId ;
	@JsonProperty("examName")
    String examName;
	@JsonProperty("maxMarks")
    Integer maxMarks ;
}




