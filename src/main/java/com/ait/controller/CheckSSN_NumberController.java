package com.ait.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ait.customexception.InvalidSocialSecurityNumberException;
import com.ait.service.ISSN_Service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import net.bytebuddy.asm.Advice.This;

@RestController
@RequestMapping(value = "/checkssn")
@Api(value = "CheckSSN_NumberController", description = "This controller for checking SSN")
public class CheckSSN_NumberController {

	private static final Logger LOGGER = LoggerFactory.getLogger(This.class);

	@Autowired
	private ISSN_Service service;

	@ApiOperation(value = "Read SSN number from path param and return idValid or not")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "SSN is valid") })
	@GetMapping(value = "/ssn/{ssnNo}",produces = {"application/json","application/xml"})
	public ResponseEntity<?> ssnIsValid(@PathVariable("ssnNo") Integer ssn) {
		LOGGER.info(" ssnIsValid Method stated");
		try {
			Long validateSSN = service.validateSSN(ssn);
			LOGGER.info("validateSSN method call");

			if (validateSSN != 0) {
				LOGGER.info("inside the IF condition of ssnIsValid");
				return new ResponseEntity<>("Valid SSN ", HttpStatus.ACCEPTED);
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw new InvalidSocialSecurityNumberException("INVALID SSN ");
		}
		LOGGER.info(" ssnIsValid Method Ended");
		return new ResponseEntity<>("Invalid SSN", HttpStatus.BAD_REQUEST);

	}

}
