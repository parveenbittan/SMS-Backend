package com.scheduler.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassSubjectDTO {
	@JsonProperty("classSubjectMappingId")
	Integer classSubjectMappingId;
	@JsonProperty("classId")
    Integer classId ;
	@JsonProperty("className")
    String  className;
	@JsonProperty("subjectId")
    Integer subjectId ;
	@JsonProperty("subjectName")
    String subjectName;
	@JsonProperty("isActive")
	Boolean isActive;
}




