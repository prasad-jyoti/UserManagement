package com.usermanagment.controller;
import com.usermanagment.Entity.UserEntity;
import com.usermanagment.Service.*;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RegistrationRestController {
	
	@Autowired
	   userService userService;

	
	@GetMapping("/getCountries")
	public Map<Integer, String> getCountries( ) {
			return userService.getAllCountries();
		}
	
	@GetMapping("/getStates/{countryId}")
	public Map<Integer, String> getStatesByCountryId(@PathVariable Integer countryId) {
		return userService.getStatesByCountryId(countryId);
	}

	@GetMapping("/getCities/{stateId}")
	public Map<Integer, String> getCitiesByStateId(@PathVariable Integer stateId) {
		return userService.getCitiesByStateId(stateId);
	}
	
	@GetMapping("/checkEmail/{email}")
	public String isEmailUnique(@PathVariable String email) {
		if(userService.isEmailUnique(email)) {
			return "UNIQUE";
		}else {
			return "DUPLICATE";
		}
	}
	
	@PostMapping(value="/registration",consumes={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> userRegistration(@RequestBody UserEntity user) {
		if(userService.isEmailUnique(user.getUserEmail())) {
		 userService.saveUser(user);
		 return new ResponseEntity<String>("REGISTRATION_SUCCESSFUL",HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("REGISTRATION_FAILED",HttpStatus.BAD_REQUEST);
	}
	
	
	

}
