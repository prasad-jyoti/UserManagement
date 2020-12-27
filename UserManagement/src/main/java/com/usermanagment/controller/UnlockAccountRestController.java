package com.usermanagment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usermanagment.Service.userService;

@RestController
public class UnlockAccountRestController {
	
	@Autowired
	   userService userService;
	
	@PostMapping("/unlockAcount")
	public String emailAcc(@RequestParam String email,@RequestParam  String tempPwd,@RequestParam  String newPwd) {
		if(userService.isTempPwdValid(email, tempPwd)) {
			userService.unloclAccount(email, newPwd);
			return "ACCOUNT_UNLOCKED";
		}
		else {
			return "TEMPRORAY PASSWORD INVALID";
		}
	}
	
	@PostMapping("/login")
	public String login(String email, String pwd) {
		return userService.loginCheck(email, pwd);
	}
	
	@GetMapping("/forgotPwd")
	public String forgotPwd(@RequestParam String email) {
		if(userService.forgotPwd(email)!=null) {
		
		return userService.forgotPwd(email);
		}
		else {
			return "PLEASE ENTER CORRECT EMAIL ID";
		}
	}

}
