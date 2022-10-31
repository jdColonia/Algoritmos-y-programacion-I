package model;

import java.util.Date;

public class Producer extends User {
	
	private String photoURL;

	public Producer(String nameUser, Date bondingDate, String photoURL) {
		super(nameUser, bondingDate);
		this.photoURL = photoURL;
	}

	public String getPhotoURL() {
		return photoURL;
	}

	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}

}
