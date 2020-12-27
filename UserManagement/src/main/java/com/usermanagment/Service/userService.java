package com.usermanagment.Service;

import java.util.Map;

import com.usermanagment.Entity.UserEntity;


public interface userService {
		//Registration
		boolean saveUser(UserEntity user);
	
		public Map<Integer, String> getAllCountries();
		
		public Map<Integer, String> getStatesByCountryId(Integer countryId);
		
		public Map<Integer, String> getCitiesByStateId(Integer stateId) ;
		
		boolean isEmailUnique(String email);
		
		//Login
		
		public String loginCheck(String email, String pwd);
		
		//Unlock Account Operation
		
		public boolean isTempPwdValid(String email,String tempPwd);
		
		public boolean unloclAccount(String email,String newPwd);
		
		//Forgot Password Operations
		
		public String forgotPwd(String email);

}
