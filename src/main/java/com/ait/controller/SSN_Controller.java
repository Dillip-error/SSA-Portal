package com.ait.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ait.bind.SSN_Bind;
import com.ait.entity.StateEntity;
import com.ait.service.ISSN_Service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.bytebuddy.asm.Advice.This;

@RestController
@RequestMapping(value = "/ssn")
@CrossOrigin("*")
@Api(value = "SSN_Controller", description = "This controller for Save SSN Details n Get All State")
public class SSN_Controller {

	private static final Logger LOGGER = LoggerFactory.getLogger(This.class);

	@Autowired
	private ISSN_Service service;

	@ApiOperation(value = "saveSocialSecurityNumberData")
	@PostMapping(value = "/save", produces = { "application/json", "application/xml" })
	public ResponseEntity<?> saveSocialSecurityNumberData(@RequestBody SSN_Bind bind) {
		try {
			LOGGER.info("saveSocialSecurityNumberData method stated");
			boolean saveSSNdata = service.saveSSNdata(bind);
			LOGGER.info("saveSSN method call");

			if (saveSSNdata) {
				LOGGER.info("inside IF condition of saveSocialSecurityNumberData");
				return new ResponseEntity<>("SSN data Save to DB", HttpStatus.CREATED);
			}

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}

		LOGGER.info("saveSocialSecurityNumberData method Ended");
		return new ResponseEntity<>("Save Faild", HttpStatus.BAD_REQUEST);

	}

	@ApiOperation(value = "Get All state")
	@GetMapping(value = "/allState", produces = { "application/json", "application/xml" })
	public ResponseEntity<?> getAllStateName() {
		List<StateEntity> allState = null;
		try {
			LOGGER.info("getAllStateName method stated");
			allState = service.getAllState();
			LOGGER.info("getAllState method called");
			if(allState != null) {
				return new ResponseEntity<>(allState, HttpStatus.OK);
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		LOGGER.info("getAllStateName method Ended");
		return new ResponseEntity<>(allState, HttpStatus.BAD_REQUEST);

	}

}
