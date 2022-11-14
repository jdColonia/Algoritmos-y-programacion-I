package model;

import java.util.Date;

public abstract class Producer extends User {
	
	private String photoURL;
    private int totalViews;
    private int totalTimePlayed;

	public Producer(String nameUser, String identificationNumber, Date bondingDate, String photoURL) {
		super(nameUser, identificationNumber, bondingDate);
		this.photoURL = photoURL;
		this.totalViews = 0;
		this.totalTimePlayed = 0;
	}

	public String getPhotoURL() {
		return photoURL;
	}

	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}

	public int getTotalViews() {
		return totalViews;
	}

	public void setTotalViews(int totalViews) {
		this.totalViews += totalViews;
	}

	public int getTotalTimePlayed() {
		return totalTimePlayed;
	}

	public void setTotalTimePlayed(int totalTimePlayed) {
		this.totalTimePlayed += totalTimePlayed;
	}
	
	public abstract void addAudio(Audio newAudio);

}
