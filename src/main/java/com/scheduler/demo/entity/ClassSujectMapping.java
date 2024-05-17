package com.scheduler.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity(name = "class_subject_mapping")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClassSujectMapping {
	@Id  
    //@GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="class_subject_id", nullable=false)
	Integer classSubjectMappingId;
	@Column (name="subject_id_fk", nullable=false)
	Integer subjectIdFk;
	@Column (name="class_id_fk", nullable=false)
	Integer classIdFk;
	
	@Column (name="is_active", nullable=false)
	Boolean isActive;
	
}
