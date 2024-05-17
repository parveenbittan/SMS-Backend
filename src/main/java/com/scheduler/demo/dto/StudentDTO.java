package com.scheduler.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.scheduler.demo.entity.Attendence;
import com.scheduler.demo.entity.Fee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
	@JsonProperty("studentId")
	Long studentId;
	@JsonProperty("classId")
    Integer classId ;
	@JsonProperty("className")
    String  className;
	@JsonProperty("sessionId")
    Integer sessionId ;
	@JsonProperty("sessionName")
    String sessionName;
	@JsonProperty("name")
    String  name;
	@JsonProperty("fatherName")
    String  fatherName;
	@JsonProperty("motherName")
    String  motherName;
	@JsonProperty("isActive")
    boolean isActive;
	@JsonProperty("contact1")
    String contact1;
	@JsonProperty("contact2")
    String contact2;
	@JsonProperty("currentAddress")
    String currentAddress;
	@JsonProperty("permanentAddress")
    String permanentAddress;
	@JsonProperty("adhar")
    String adhar ;
	@JsonProperty("bloodGroup")
    String  bloodGroup;
	
	@JsonProperty("admissionDate")
    String  admissionDate;
	
	@JsonProperty("releavingDate")
	String  releavingDate;
	
	@JsonProperty("updateDate")
	String  updateDate;
	
	@JsonProperty("dob")
	String  dob;
	
	@JsonProperty("photo")
    String  photo;
	@JsonProperty("result")
	List<ResultDTO> result;
	@JsonProperty("isSmesterSystem")
	boolean isSmesterSystem;
	@JsonProperty("examType")
	String examType;
	@JsonProperty("gender")
	String gender;
	@JsonProperty("boardRegistraion")
	String  boardRegistraion;
	@JsonProperty("fee")
	Fee fee;
	@JsonProperty("msg")
	String msg;
	@JsonProperty("total")
	Long total ;
	@JsonProperty("attendence")
	Attendence attendence;
}

