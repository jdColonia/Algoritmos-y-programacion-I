package model;

import java.util.Date;

public abstract class Buyer extends User {
	
	public Buyer(String nameUser, String identificationNumber, Date bondingDate) {
		super(nameUser, identificationNumber, bondingDate);
	}
	
	public abstract boolean addPlaylist(Playlist newPlaylist);
	public abstract Song searchSong(String nameAudio);
    public abstract boolean addSong(Song newSong);
       
}
