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
@Entity(name = "comes_under")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ComesUnder {
	@Id  
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="comes_under_id", nullable=false)
	@JsonProperty("comes_under_id")
	private Integer comesUnderId;
	@Column (name="comes_under_name", nullable=false)
	@JsonProperty("comes_under_name")
	private String comesUnderName;
	@Column (name="code", nullable=false)
	@JsonProperty("code")
	private String code;
	
}
