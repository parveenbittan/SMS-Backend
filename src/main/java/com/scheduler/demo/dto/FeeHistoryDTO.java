package com.scheduler.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeeHistoryDTO {
@JsonProperty("total")
Long total ;
@JsonProperty("lastPaid")
Long lastPaid ;
@JsonProperty("updateDate")
String updateDate;
@JsonProperty("comment")
String comment;
}
