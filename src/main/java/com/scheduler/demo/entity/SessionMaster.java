package com.scheduler.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity(name = "session_master")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SessionMaster {
	@Id  
    //@GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="session_id", nullable=false)
	@JsonProperty("sessionId")
	private Integer sessionId;
	@Column (name="session_name", nullable=false)
	@JsonProperty("sessionName")
	private String sessionName;
	
	@Column (name="session_code", nullable=false)
	@JsonProperty("sessionCode")
	private String sessionCode;

	@Column (name="is_active", nullable=false)
	@JsonProperty("isActive")
	private Boolean isActive;
	
}
