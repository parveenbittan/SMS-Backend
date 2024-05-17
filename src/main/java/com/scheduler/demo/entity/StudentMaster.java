package com.scheduler.demo.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity(name = "student_admission_detail")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentMaster {
	@Id  
	@Column (name="student_id", nullable=false)
	@JsonProperty("studentId")
	Long studentId;	
	@Column (name="student_name", nullable=false)
	@JsonProperty("name")
    String  name;
	@Column (name="father_name", nullable=false)
	@JsonProperty("fatherName")
    String  fatherName;
	@Column (name="mother_name", nullable=false)
	@JsonProperty("motherName")
    String  motherName;
	@Column (name="is_active")
	@JsonProperty("isActive")
    boolean isActive;
	@Column (name="student_contact1")
	@JsonProperty("contact1")
    String contact1;
	@Column (name="student_contact2")
	@JsonProperty("contact2")
    String contact2;
	@Column (name="student_current_address", nullable=false)
	@JsonProperty("currentAddress")
    String currentAddress;
	@Column (name="student_permanent_address")
	@JsonProperty("permanentAddress")
    String permanentAddress;
	@Column (name="student_adhar")
	@JsonProperty("adhar")
    String adhar ;
	@Column (name="student_blood_group")
	@JsonProperty("bloodGroup")
    String  bloodGroup;
	@Column (name="student_admission_date")
	@JsonProperty("admissionDate")
	String  admissionDate;
	@Column (name="student_releaving_date")
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
	@Column (name="gender")
    String  gender;
	@JsonProperty("boardRegistration")
	@Column (name="board_registration")
    String  boardRegistration;
}

    