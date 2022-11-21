package model;

import java.util.Date;

public abstract class Buyer extends User implements IPlaying {
	
	public Buyer(String nameUser, String identificationNumber, Date bondingDate) {
		super(nameUser, identificationNumber, bondingDate);
	}

	public abstract Playlist searchPlaylist(String namePlaylist);
	public abstract boolean addPlaylist(Playlist newPlaylist);
	public abstract boolean searchSong(Song song);
    public abstract boolean addSong(Song newSong);
     
}
