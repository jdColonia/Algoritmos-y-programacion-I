package model;

import java.util.ArrayList;
import java.util.Date;

public class Artist extends Producer {
	
	private ArrayList <Song> songs;
	
	public Artist(String nameUser, String identificationNumber, Date bondingDate, String photoURL) {
		super(nameUser, identificationNumber, bondingDate, photoURL);
        this.songs = new ArrayList<Song>();
	}

	public ArrayList<Song> getSongs() {
		return songs;
	}

	public void setSongs(ArrayList<Song> songs) {
		this.songs = songs;
	}
	
    @Override
	/**
	 * <pre>
	 * <strong>Description:</strong> The method addAudio allows to add a new song to the artist's song collection
	 * <strong>pre:</strong> songs must be initialized
	 * <strong>pos:</strong> Song added
	 * </pre>
	 */
    public void addAudio(Audio newAudio) {
        songs.add( (Song) newAudio );
    }

}
