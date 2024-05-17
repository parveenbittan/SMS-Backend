package com.scheduler.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity(name = "post_master")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostMaster {
	@Id  
    //@GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="post_id", nullable=false)
	@JsonProperty("postId")
	private Integer postId;
	@Column (name="post_name", nullable=false)
	@JsonProperty("postName")
	private String postName;
	@Column (name="post_code", nullable=false)
	@JsonProperty("postCode")
	private String postCode;
	@Column (name="is_active", nullable=false)
	@JsonProperty("isActive")
	private Boolean isActive;
	@Column (name="pf", nullable=false)
	@JsonProperty("pf")
	private String pf;
	@Column (name="salary", nullable=false)
	@JsonProperty("salary")
	private String salary;
	
}
