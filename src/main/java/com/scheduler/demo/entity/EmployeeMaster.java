package com.scheduler.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity(name = "emp_detail")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeMaster {
	@Id  
	@Column (name="emp_id", nullable=false)
	@JsonProperty("empId")
	Long empId;	
	@Column (name="name", nullable=false)
	@JsonProperty("name")
    String  name;
	@Column (name="father_name", nullable=false)
	@JsonProperty("fatherName")
    String  fatherName;
	
	@Column (name="is_active")
	@JsonProperty("isActive")
    boolean isActive;
	@Column (name="contact1")
	@JsonProperty("contact1")
    String contact1;
	@Column (name="contact2")
	@JsonProperty("contact2")
    String contact2;
	@Column (name="current_address", nullable=false)
	@JsonProperty("currentAddress")
    String currentAddress;
	@Column (name="permanent_address")
	@JsonProperty("permanentAddress")
    String permanentAddress;
	@Column (name="adhar")
	@JsonProperty("adhar")
    String adhar ;
	@Column (name="blood_group")
	@JsonProperty("bloodGroup")
    String  bloodGroup;
	@Column (name="join_date")
	@JsonProperty("joinDate")
	String  joinDate;
	@Column (name="releaving_date")
	@JsonProperty("releavingDate")
	String  releavingDate;
	@Column (name="update_date")
	@JsonProperty("updateDate")
	String  updateDate;
	@Column (name="student_dob")
	@JsonProperty("dob")
	String  dob;
	@Column (name="student_photo")
	@JsonProperty("photo")
    String  photo;
	@JsonProperty("gender")
    String  gender;
}

    