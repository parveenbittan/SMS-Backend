package com.scheduler.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultDTO {
	@JsonProperty("resultId")
	Long resultId;
	@JsonProperty("studentId")
	Long studentId;
	@JsonProperty("classId")
    Integer classId ;
	@JsonProperty("className")
    String  className;
	@JsonProperty("sessionId")
    Integer sessionId ;
	@JsonProperty("examId")
    Integer examId ;
	@JsonProperty("examName")
    String  examName;
	@JsonProperty("subjectId")
    Integer subjectId ;
	@JsonProperty("subjectName")
    String  subjectName;
	@JsonProperty("maxMark")
    String  maxMark;
	@JsonProperty("obtainMark")
    String  obtainMark;
	
}
