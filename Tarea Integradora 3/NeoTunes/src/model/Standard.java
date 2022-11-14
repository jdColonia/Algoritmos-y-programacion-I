package model;

import java.util.ArrayList;
import java.util.Date;

public class Standard extends Buyer {

	private Playlist[] playlists;
	private Song[] purchasedSong;
    private ArrayList<Song> playbackSongs;
    private final String ADD_NIKE = "  Nike - Just Do It";
    private final String ADD_COKE = "  Coca-Cola - Open Happiness";
    private final String ADD_MMS = "  M&Ms - Melts in Your Mouth, Not in Your Hands";

	public Standard(String nameUser, String identificationNumber, Date bondingDate) {
		super(nameUser, identificationNumber, bondingDate);
		this.playlists = new Playlist[20];
		this.purchasedSong = new Song[100];
		this.playbackSongs = new ArrayList<Song>();
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
	
	public ArrayList<Song> getPlaybackSongs() {
		return playbackSongs;
	}

	public void setPlaybackSongs(ArrayList<Song> playbackSongs) {
		this.playbackSongs = playbackSongs;
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
				int reproductions = playbackSongs.size();
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
					playbackSongs.add(song);
				}
			}
		} else if (audio instanceof Podcast) {
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
		}
		return msg;
	}

}
