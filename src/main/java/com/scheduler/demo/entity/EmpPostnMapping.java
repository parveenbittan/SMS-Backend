package com.scheduler.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity(name = "emp_post_mapping")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmpPostnMapping {
	@Id  
    //@GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="emp_post_id", nullable=false)
	Long empPostId;
	@Column (name="emp_id_fk", nullable=false)
	Long empIdFk;
	@Column (name="post_id_fk", nullable=false)
	Integer postIdFk;
	
	@Column (name="is_active", nullable=false)
	Boolean isActive;
	
	
}
