package com.scheduler.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity(name = "student_class_session_mapping")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentClassSession {
	@Id  
    //@GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="student_class_session_id", nullable=false)
	Long studentClassSessionId;
	@Column (name="student_id_fk", nullable=false)
	Long studentIdFk;
	@Column (name="class_id_fk", nullable=false)
	Integer classIdFk;
	@Column (name="session_id_fk", nullable=false)
	Integer sessionIdFk;
	@Column (name="is_active", nullable=false)
	Boolean isActive;
	
}
