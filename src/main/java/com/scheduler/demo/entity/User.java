package com.scheduler.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "users")
@NoArgsConstructor
@AllArgsConstructor

@Data
public class User {
	@Id  
   
	@Column (name="user_id", nullable=false)	
	private Long userId;
	@Column (name="user_name", nullable=false)
	
	private String userName;
	@Column (name="user_password", nullable=false)
	
	private String userPassword;
	@Column (name="org_id", nullable=false)
	private Long orgId;	
	@Column (name="role_id", nullable=false)
	
	private Long role_id;
	
}
