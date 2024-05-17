package com.scheduler.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentSearchFielter {
	Integer sessionId;
	Integer classId;
	Integer examId;
	String name;
	Boolean isSmesterSystem;
	Long studentId;
	String attendenceDate;
	

}
