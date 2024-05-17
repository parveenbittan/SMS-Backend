package com.scheduler.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity(name = "student_report")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentReport {
	@Id  
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="report_id", nullable=false)
	Long reportId;
	@Column (name="student_id_fk", nullable=false)
	Long studentIdFk;
	@Column (name="class_id_fk", nullable=false)
	Integer classIdFk;
	@Column (name="session_id_fk", nullable=false)
	Integer sessionIdFk;
	@Column (name="exam_id_fk", nullable=false)
	Integer examIdFk;
	@Column (name="subject_id_fk", nullable=false)
	Integer subjectIdFk;
	@Column (name="max_marks", nullable=false)
	String maxMarks;
	@Column (name="marks_obtain", nullable=false)
	String marksObtain;
}
