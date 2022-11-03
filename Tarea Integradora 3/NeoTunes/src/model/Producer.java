package model;

import java.util.Date;

public abstract class Producer extends User {
	
	private String photoURL;

	public Producer(String nameUser, String identificationNumber, Date bondingDate, String photoURL) {
		super(nameUser, identificationNumber, bondingDate);
		this.photoURL = photoURL;
	}

	public String getPhotoURL() {
		return photoURL;
	}

	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}

}
