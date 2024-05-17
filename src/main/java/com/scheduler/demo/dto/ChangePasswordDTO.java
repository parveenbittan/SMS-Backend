package com.scheduler.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangePasswordDTO {

	@JsonProperty("username")
	String userName;
	@JsonProperty("old")
	String old;
	@JsonProperty("new")
	String newPass;
	@JsonProperty("confirm")
	String confirm;
	@JsonProperty("message")
	String message;

}
