package com.scheduler.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
	@JsonProperty("empId")
	Long empId;
	@JsonProperty("postId")
    Integer postId ;
	@JsonProperty("postName")
    String  postName;
	
	@JsonProperty("name")
    String  name;
	@JsonProperty("fatherName")
    String  fatherName;
	
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
	
	@JsonProperty("joinDate")
    String  joinDate;
	
	@JsonProperty("releavingDate")
	String  releavingDate;
	
	@JsonProperty("updateDate")
	String  updateDate;
	
	@JsonProperty("dob")
	String  dob;
	
	@JsonProperty("photo")
    String  photo;

	@JsonProperty("gender")
	String gender;
}
