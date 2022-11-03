package model;

import java.util.Date;

public abstract class Buyer extends User {
	
	public Buyer(String nameUser, String identificationNumber, Date bondingDate) {
		super(nameUser, identificationNumber, bondingDate);
	}

}
