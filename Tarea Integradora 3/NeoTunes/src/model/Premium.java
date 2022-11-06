package model;

import java.util.ArrayList;
import java.util.Date;

public class Premium extends Buyer {

	private ArrayList<Playlist> playlists;
	private ArrayList<Song> purchasedSong;

	public Premium(String nameUser, String identificationNumber, Date bondingDate) {
		super(nameUser, identificationNumber, bondingDate);
		this.playlists = new ArrayList<Playlist>();
		this.purchasedSong = new ArrayList<Song>();
	}

	public ArrayList<Playlist> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(ArrayList<Playlist> playlists) {
		this.playlists = playlists;
	}

	public ArrayList<Song> getPurchasedSong() {
		return purchasedSong;
	}

	public void setPurchasedSong(ArrayList<Song> purchasedSong) {
		this.purchasedSong = purchasedSong;
	}

	@Override
	public boolean addPlaylist(Playlist newPlaylist) {
		return getPlaylists().add(newPlaylist);
	}

	@Override
	public Song searchSong(String nameAudio) {
		Song song = null;
		boolean isFound = false;
		for (int i = 0; i < purchasedSong.size() && !isFound; i++) {
			if (purchasedSong.get(i).getNameAudio().equalsIgnoreCase(nameAudio)) {
				song = purchasedSong.get(i);
				isFound = true;
			}
		}
		return song;
	}

	@Override
	public boolean addSong(Song newSong) {
		if (searchSong(newSong.getNameAudio()) != null) {
			return false;
		}
		getPurchasedSong().add(newSong);
		newSong.setNumberTimesSold(1);
		return true;
	}

}
