package model;

import java.util.Date;

public class Purchase {
	
	private Song song;
	private Date datePurchase;
	
	public Purchase(Song song, Date datePurchase) {
		this.song = song;
		this.datePurchase = datePurchase;
	}

	public Song getSong() {
		return song;
	}

	public void setSong(Song song) {
		this.song = song;
	}

	public Date getDatePurchase() {
		return datePurchase;
	}

	public void setDatePurchase(Date datePurchase) {
		this.datePurchase = datePurchase;
	}

}
