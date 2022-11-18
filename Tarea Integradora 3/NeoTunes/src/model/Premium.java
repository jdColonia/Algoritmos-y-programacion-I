package model;

import java.util.ArrayList;
import java.util.Date;

public class Premium extends Buyer {

	private ArrayList<Playlist> playlists;
	private ArrayList<Song> purchasedSong;
    private ArrayList<Audio> playback;

	public Premium(String nameUser, String identificationNumber, Date bondingDate) {
		super(nameUser, identificationNumber, bondingDate);
		this.playlists = new ArrayList<Playlist>();
		this.purchasedSong = new ArrayList<Song>();
		this.playback = new ArrayList<Audio>();
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
		for (int i = 0; i < playlists.size() && !isFound; i++) {
			if (playlists.get(i).getNamePlaylist().equalsIgnoreCase(namePlaylist)) {
				playlist = playlists.get(i);
				isFound = true;
			}
		}
		return playlist;
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
		return purchasedSong.add(newSong);
	}

	@Override
	public String play(Audio audio) {
		
		String msg = null;
		if(audio instanceof Song){
			Song song = (Song) audio;
			if (searchSong(song.getNameAudio()) != null) {
				msg = "| PLAYING AUDIO |";
				playback.add(song);
			}
		} else if (audio instanceof Podcast) {
			Podcast podcast = (Podcast) audio;
			msg = "\n| PLAYING AUDIO |";
			playback.add(podcast);
		}
		return msg;
	}
	
}
