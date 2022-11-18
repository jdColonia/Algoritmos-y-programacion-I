package model;

import java.util.ArrayList;
import java.util.Date;

public class Standard extends Buyer implements IAdvertisement{

	private Playlist[] playlists;
	private Song[] purchasedSong;
    private ArrayList<Audio> playback;

	public Standard(String nameUser, String identificationNumber, Date bondingDate) {
		super(nameUser, identificationNumber, bondingDate);
		this.playlists = new Playlist[20];
		this.purchasedSong = new Song[100];
		this.playback = new ArrayList<Audio>();
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
	
	public ArrayList<Audio> getPlayback() {
		return playback;
	}

	public void setPlayback(ArrayList<Audio> playback) {
		this.playback = playback;
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
	
	@Override
    public String play(Audio audio) {
		
		String msg = null;
		if(audio instanceof Song){
			Song song = (Song) audio;
			if (searchSong(song.getNameAudio()) != null) {
				msg = "| PLAYING AUDIO |";
				int reproductions = playback.size();
				if (reproductions != 0 && (reproductions % 2) == 0) {
					int r = (int) (Math.random() * ( 4 - 1 )) + 1;
					switch (r) {
					case 1:
						msg += "\n" + ADD_NIKE;
						break;
					case 2:
						msg += "\n" + ADD_COKE;
						break;
					case 3:
						msg += "\n" + ADD_MMS;
						break;
					}
				} else {
					playback.add(song);
				}
			}
		} else if (audio instanceof Podcast) {
			Podcast podcast = (Podcast) audio;
			int r = (int) (Math.random() * ( 4 - 1 )) + 1;
			switch (r) {
			case 1:
				msg = ADD_NIKE;
				break;
			case 2:
				msg = ADD_COKE;
				break;
			case 3:
				msg = ADD_MMS;
				break;
			}
			msg += "\n| PLAYING AUDIO |";
			playback.add(podcast);
		}
		return msg;
	}

}
