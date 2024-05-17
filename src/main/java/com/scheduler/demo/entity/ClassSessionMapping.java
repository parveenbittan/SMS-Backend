package com.scheduler.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity(name = "class_session_detail")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClassSessionMapping {
	@Id  
    //@GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="class_session_id", nullable=false)
	Long classSessionId;
	@Column (name="session_id_fk", nullable=false)
	Long sessionIdFk;
	@Column (name="class_id_fk", nullable=false)
	Integer classIdFk;
	
	@Column (name="is_active", nullable=false)
	Boolean isActive;
	
}
