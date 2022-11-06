package model;

import java.util.ArrayList;
import java.util.Date;

public class Premium extends Buyer {
	
    private ArrayList<Song> songs;
    private ArrayList<Playlist> playlists;

	public Premium(String nameUser, String identificationNumber, Date bondingDate) {
		super(nameUser, identificationNumber, bondingDate);
	}
	
    public ArrayList<Song> getSongs() {
		return songs;
	}

	public void setSongs(ArrayList<Song> songs) {
		this.songs = songs;
	}

	public ArrayList<Playlist> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(ArrayList<Playlist> playlists) {
		this.playlists = playlists;
	}
	
}
