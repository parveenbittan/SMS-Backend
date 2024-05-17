package com.scheduler.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.scheduler.demo.entity.Attendence;
import com.scheduler.demo.entity.Fee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultSaveParameterDTO {
List<StudentDTO> students;
StudentSearchFielter ssf;
}
