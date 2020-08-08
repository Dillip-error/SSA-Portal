package com.ait.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "STATE_ENTITY")
public class StateEntity {
	@Id
	@Column(name = "STATE_ID")
	private Integer stateId;
	@Column(name = "STATE_CODE")
	private String stateCode;
	@Column(name = "STATE_NAME")
	private String stateName;

}
