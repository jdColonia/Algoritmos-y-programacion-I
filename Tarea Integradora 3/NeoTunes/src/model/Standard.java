package model;

import java.util.Date;

public class Standard extends Buyer {

	private Playlist[] playlists;
	private Song[] purchasedSong;

	public Standard(String nameUser, String identificationNumber, Date bondingDate) {
		super(nameUser, identificationNumber, bondingDate);
		this.playlists = new Playlist[20];
		this.purchasedSong = new Song[100];
	}

	public Playlist[] getPlaylists() {
		return playlists;
	}

	public void setPlaylists(Playlist[] playlists) {
		this.playlists = playlists;
	}

	public Song[] getPurchasedSong() {
		return purchasedSong;
	}

	public void setPurchasedSong(Song[] purchasedSong) {
		this.purchasedSong = purchasedSong;
	}
	
	@Override
	public Playlist searchPlaylist(String namePlaylist) {
		Playlist playlist = null;
		boolean isFound = false;
		for (int i = 0; i < playlists.length && !isFound; i++) {
			if (playlists[i] != null) {
				if (playlists[i].getNamePlaylist().equalsIgnoreCase(namePlaylist)) {
					playlist = playlists[i];
					isFound = true;
				}
			}
		}
		return playlist;
	}

	@Override
	public boolean addPlaylist(Playlist newPlaylist) {
		boolean stopFlag = false;
		for (int i = 0; i < playlists.length; i++) {
			if (playlists[i] == null) {
				playlists[i] = newPlaylist;
				return stopFlag = true;
			}
		}
		return stopFlag;
	}

	@Override
	public Song searchSong(String nameAudio) {
		Song song = null;
		boolean isFound = false;
		for (int i = 0; i < purchasedSong.length && !isFound; i++) {
			if (purchasedSong[i] != null) {
				if (purchasedSong[i].getNameAudio().equalsIgnoreCase(nameAudio)) {
					song = purchasedSong[i];
					isFound = true;
				}
			}
		}
		return song;
	}

	@Override
	public boolean addSong(Song newSong) {
		boolean stopFlag = false;
		for (int i = 0; i < purchasedSong.length; i++) {
			if (purchasedSong[i] == null) {
				purchasedSong[i] = newSong;
				return stopFlag = true;
			}
		}
		return stopFlag;
	}

}
