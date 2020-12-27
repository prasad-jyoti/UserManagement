package com.usermanagment.Service;

import java.util.LinkedHashMap;


import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import com.usermanagment.Entity.UserEntity;
import com.usermanagment.Entity.cityEntity;
import com.usermanagment.Entity.countryEntity;
import com.usermanagment.Entity.stateEntity;
import com.usermanagment.Repository.cityRepository;
import com.usermanagment.Repository.countryRepository;
import com.usermanagment.Repository.stateRepository;
import com.usermanagment.Repository.userRepository;


public class userServiceImpl implements userService {
	
	@Autowired
	private userRepository userRepo;
	@Autowired
	private countryRepository countryRepo;
	@Autowired
	private stateRepository stateRepo;
	@Autowired
	private cityRepository cityRepo;

	

	@Override
	public Map<Integer, String> getAllCountries() {
		// TODO Auto-generated method stub
		
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();

		List<countryEntity> countriesList = countryRepo.findAll();
		countriesList.forEach(countryEntity -> {
			map.put(countryEntity.getCountryId(), countryEntity.getCountryName());
		});

		return map;
		
	}

	@Override
	public Map<Integer, String> getStatesByCountryId(Integer countryId) {
		Map<Integer, String> statesMap = new LinkedHashMap();
		List<stateEntity> states = stateRepo.findAllByCountryId(countryId);

		states.forEach(state -> {
			statesMap.put(state.getStateId(), state.getStateName());
		});

		return statesMap;
	}

	@Override
	public Map<Integer, String> getCitiesByStateId(Integer stateId) {
		Map<Integer, String> citiesMap = new LinkedHashMap();

		List<cityEntity> entitiesList = cityRepo.findAllByStateId(stateId);

		entitiesList.forEach(entity -> {
			citiesMap.put(entity.getCityId(), entity.getCityName());
		});

		return citiesMap;
	}

	@Override
	public boolean isEmailUnique(String email) {
		
		UserEntity user=userRepo.findByEmail(email);
		
		if(	user.getUserEmail()!=null) {
			return true;
		}
					
		return false;
				
	}
	
	
	public boolean saveUser(UserEntity user) {
		
		user.setUserPwd(passwordGenerator());
		user.setAccStatus("LOCKED");
		UserEntity userObj=userRepo.save(user);
		
		return userObj.getUserId()!=null;
	}

	private String passwordGenerator() {
		
		char[] password= new char[5];
		String alphanumeric= "ABCDEFGabcdefg1234567890";
		Random randomPwd = new Random();
		for(int i=0;i<5;i++) {
			password[i]=alphanumeric.charAt(randomPwd.nextInt(alphanumeric.length()));
			
		}
		
		
		return password.toString();
	}

	@Override
	public String loginCheck(String email, String pwd) {
		UserEntity userDetails=userRepo.findByEmailAndPassword(email, pwd);
		if(userDetails!=null) {
			if(userDetails.getAccStatus().equals("LOCKED")) {
				return "ACCOUNT LOCKED";
				
			}
			else {
				return "LOGIN SUCCESSFULL";
			}
			
		}
		return "INVALID CREDENTIALS";
	}
	

	@Override
	public boolean isTempPwdValid(String email, String tempPwd) {
		UserEntity userDetails=userRepo.findByEmailAndPassword(email, tempPwd);
		
		return userDetails.getUserId()!=null;
	}

	@Override
	public boolean unloclAccount(String email, String newPwd) {
		UserEntity userDetails=userRepo.findByEmail(email);
		userDetails.setAccStatus("UNLOCKED");
		userDetails.setUserPwd(newPwd);
		try {
			userRepo.save(userDetails);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
			
		}
		
	
	}

	@Override
	public String forgotPwd(String email) {
		UserEntity user=userRepo.findByEmail(email);
		if(user!=null) {
			user.getUserPwd();
		}
		return null;
	}

}
