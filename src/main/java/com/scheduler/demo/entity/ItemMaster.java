package com.scheduler.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity(name = "item_master")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemMaster {
	@Id  
    //@GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="item_id", nullable=false)
	@JsonProperty("itemId")
	private Integer itemId;
	@Column (name="item_name", nullable=false)
	@JsonProperty("itemName")
	private String itemName;
	@Column (name="item_code", nullable=false)
	@JsonProperty("itemCode")
	private String itemCode;
	@Column (name="is_active", nullable=false)
	@JsonProperty("isActive")
	private Boolean isActive;
	
}
