package com.scheduler.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {
	@JsonProperty("isAuth")
	Boolean isAuth;
	@JsonProperty("username")
	String userName;
	@JsonProperty("password")
	String password;
	@JsonProperty("role")
	String role;
	@JsonProperty("orgname")
	String orgName;
	@JsonProperty("affidiateno")
	String affidiateNo;
	@JsonProperty("ownername")
	String ownerName;
	@JsonProperty("orgaddress")
	String orgAddress;
	@JsonProperty("orgemail")
	String orgEmail;
	@JsonProperty("contact")
	String contact1;
	@JsonProperty("contact2")
	String contact2;
	@JsonProperty("board")
	String boardName;

}
