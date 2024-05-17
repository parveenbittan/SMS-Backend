package com.scheduler.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity(name = "student_fee")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Fee {
	@Id  
    //@GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="fee_id", nullable=false)
	@JsonProperty("feeId")
	Long feeId;
	@Column (name="student_id_fk", nullable=false)
	@JsonProperty("studentIdFk")
	Long studentIdFk;
	@Column (name="class_id_fk", nullable=false)
	@JsonProperty("classIdFk")
	int classIdFk;
	@Column (name="session_id_fk", nullable=false)
	@JsonProperty("sessionIdFk")
	int sessionIdFk;
	@Column (name="apr_f")
	@JsonProperty("aprF")
	int aprF;
	@Column (name="may_f")
	@JsonProperty("mayF")
	int mayF;
	@Column (name="june_f")
	@JsonProperty("juneF")
	int juneF;
	
	@Column (name="july_f")
	@JsonProperty("julyF")
	int julyF;
	
	@Column (name="aug_f")
	@JsonProperty("augF")
	int augF;
	@Column (name="sept_f")
	@JsonProperty("septF")
	int septF;
	@Column (name="oct_f")
	@JsonProperty("octF")
	int octF;
	@Column (name="nov_f")
	@JsonProperty("novF")
	int novF;
	@Column (name="decem")
	@JsonProperty("decemF")
	int decemF;
	@Column (name="jan_f")
	@JsonProperty("janF")
	int janF;
	@Column (name="feb_f")
	@JsonProperty("febF")
	int febF;
	@Column (name="mar_f")
	@JsonProperty("marF")
	int marF;
	@Column (name="is_transport")
	@JsonProperty("isTransport")
	boolean isTransport;
	
	@Column (name="apr_t")
	@JsonProperty("aprT")
	int aprT;
	@Column (name="may_t")
	@JsonProperty("mayT")
	int mayT;
	@Column (name="june_t")
	@JsonProperty("juneT")
	int juneT;
	
	@Column (name="july_t")
	@JsonProperty("julyT")
	int julyT;
	
	@Column (name="aug_t")
	@JsonProperty("augT")
	int augT;
	@Column (name="sept_t")
	@JsonProperty("septT")
	int septT;
	@Column (name="oct_t")
	@JsonProperty("octT")
	int octT;
	@Column (name="nov_t")
	@JsonProperty("novT")
	int novT;
	@Column (name="decem_t")
	@JsonProperty("decemT")
	int decemT;
	@Column (name="jan_t")
	@JsonProperty("janT")
	int janT;
	@Column (name="feb_t")
	@JsonProperty("febT")
	int febT;
	@Column (name="mar_t")
	@JsonProperty("marT")
	int marT;
	
	@Column (name="addmission_fee")
	@JsonProperty("addmissionFee")
	int  addmissionFee;
	@Column (name="other_fee")
	@JsonProperty("otherFee")
	int otherFee;
	@Column (name="create_date")
	@JsonProperty("createDate")
	String  createDate;
	@Column (name="update_date")
	@JsonProperty("updateDate")
	String  updateDate;
	@Column (name="comment")
	@JsonProperty("comment")
	String  comment;
	
}
