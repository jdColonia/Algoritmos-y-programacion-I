package model;

import java.util.Date;

public abstract class User {
	
	private String nameUser;
	private String identificationNumber;
	private Date bondingDate;
	
	public User(String nameUser,  String identificationNumber, Date bondingDate) {
		this.nameUser = nameUser;
		this.identificationNumber = identificationNumber;
		this.bondingDate = bondingDate;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}
	
	public String getIdentificationNumber() {
		return identificationNumber;
	}

	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	public Date getBondingDate() {
		return bondingDate;
	}

	public void setBondingDate(Date bondingDate) {
		this.bondingDate = bondingDate;
	}
	
}
