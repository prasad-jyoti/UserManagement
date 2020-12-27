package com.usermanagment.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_MASTER")

public class UserEntity {
	
	@Id
	@Column(name = "userId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	@Column(name = "accStatus")
	private String accStatus;
	
	@Column(name="userFname")
	private String userFname;	
	
	@Column(name="userLname")
	private String userLname;
	
	@Column(name="userPwd")
	 private String userPwd;
	
	@Column(name="userEmail")
	private String userEmail;	
	
	@Column(name="userPhone")
	private Integer userPhone;
	
	@Column(name="DOB")
	private Date DOB;
	
	@Column(name="userGender")
	private String userGender;
	
	@Column(name="countryId")
	private countryEntity countryId ;
	
	@Column(name="stateId")
	private stateEntity stateId ;	
	
	@Column(name="cityId")
	private cityEntity cityId ;
	
	@Column(name="createdDate")
	private Date createdDate;
	
	@Column(name="updatedDate")
	private Date updatedDate;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getAccStatus() {
		return accStatus;
	}

	public void setAccStatus(String accStatus) {
		this.accStatus = accStatus;
	}

	public String getUserFname() {
		return userFname;
	}

	public void setUserFname(String userFname) {
		this.userFname = userFname;
	}

	public String getUserLname() {
		return userLname;
	}

	public void setUserLname(String userLname) {
		this.userLname = userLname;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Integer getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(Integer userPhone) {
		this.userPhone = userPhone;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public countryEntity getCountryId() {
		return countryId;
	}

	public void setCountryId(countryEntity countryId) {
		this.countryId = countryId;
	}

	public stateEntity getStateId() {
		return stateId;
	}

	public void setStateId(stateEntity stateId) {
		this.stateId = stateId;
	}

	public cityEntity getCityId() {
		return cityId;
	}

	public void setCityId(cityEntity cityId) {
		this.cityId = cityId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", accStatus=" + accStatus + ", userFname=" + userFname + ", userLname="
				+ userLname + ", userPwd=" + userPwd + ", userEmail=" + userEmail + ", userPhone=" + userPhone
				+ ", DOB=" + DOB + ", userGender=" + userGender + ", countryId=" + countryId + ", stateId=" + stateId
				+ ", cityId=" + cityId + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
	}

	public UserEntity(Integer userId, String accStatus, String userFname, String userLname, String userPwd,
			String userEmail, Integer userPhone, Date dOB, String userGender, countryEntity countryId,
			stateEntity stateId, cityEntity cityId, Date createdDate, Date updatedDate) {
		super();
		this.userId = userId;
		this.accStatus = accStatus;
		this.userFname = userFname;
		this.userLname = userLname;
		this.userPwd = userPwd;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		DOB = dOB;
		this.userGender = userGender;
		this.countryId = countryId;
		this.stateId = stateId;
		this.cityId = cityId;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
