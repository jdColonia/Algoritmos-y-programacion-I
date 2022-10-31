package model;

import java.util.Date;

public class Buyer extends User {
	
	private String identificationNumber;

	public Buyer(String nameUser, Date bondingDate, String identificationNumber) {
		super(nameUser, bondingDate);
		this.identificationNumber = identificationNumber;
	}

	public String getIdentificationNumber() {
		return identificationNumber;
	}

	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

}
