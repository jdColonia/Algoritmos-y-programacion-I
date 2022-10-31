package model;

import java.util.Date;

public abstract class User {
	
	private String nameUser;
	private Date bondingDate;
	
	public User(String nameUser, Date bondingDate) {
		this.nameUser = nameUser;
		this.bondingDate = bondingDate;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public Date getBondingDate() {
		return bondingDate;
	}

	public void setBondingDate(Date bondingDate) {
		this.bondingDate = bondingDate;
	}
	
}
