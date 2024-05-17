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

@Entity(name = "org")
@NoArgsConstructor
@AllArgsConstructor

@Data
public class Organisation {
	@Id  
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="org_id", nullable=false)
	@JsonProperty("org_id")
	private Integer orgId;
	@Column (name="org_name", nullable=false)
	@JsonProperty("org_name")
	private String orgName;
	@Column (name="affidate_no", nullable=false)
	@JsonProperty("affidate_no")
	private String affidateNo;
	@Column (name="owner_name", nullable=false)
	@JsonProperty("owner_name")
	private String ownerName;	
	@Column (name="logo", nullable=false)
	@JsonProperty("logo")
	private String logo;
	
}
