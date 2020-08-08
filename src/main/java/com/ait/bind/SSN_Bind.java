package com.ait.bind;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SSN_Bind {
	private Integer ssnNo;
	private String firstName;
	private String lastName;
	private String gender;
	private String DOB;
	private String state;
	private Date createdDate;
	private Date updatedDate;


}
