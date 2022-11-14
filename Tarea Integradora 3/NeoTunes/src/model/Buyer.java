package model;

import java.util.ArrayList;
import java.util.Date;

public abstract class Buyer extends User implements IPlaying {
	
	private ArrayList<Audio> playedAudioList;
	
	public Buyer(String nameUser, String identificationNumber, Date bondingDate) {
		super(nameUser, identificationNumber, bondingDate);
		this.playedAudioList = new ArrayList<Audio>();
	}
		
	public ArrayList<Audio> getPlayedAudioList() {
		return playedAudioList;
	}
	
	public void setPlayedAudioList(ArrayList<Audio> playedAudioList) {
		this.playedAudioList = playedAudioList;
	}

	public abstract Playlist searchPlaylist(String namePlaylist);
	public abstract boolean addPlaylist(Playlist newPlaylist);
	public abstract Song searchSong(String nameAudio);
    public abstract boolean addSong(Song newSong);
     
}
