package model;

import java.util.ArrayList;
import java.util.Date;

public class Premium extends Buyer {

	private ArrayList<Playlist> playlists;
	private ArrayList<Purchase> purchasedSong;
    private ArrayList<Audio> playback;

	public Premium(String nameUser, String identificationNumber, Date bondingDate) {
		super(nameUser, identificationNumber, bondingDate);
		this.playlists = new ArrayList<Playlist>();
		this.purchasedSong = new ArrayList<Purchase>();
		this.playback = new ArrayList<Audio>();
	}

	public ArrayList<Playlist> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(ArrayList<Playlist> playlists) {
		this.playlists = playlists;
	}

	public ArrayList<Purchase> getPurchasedSong() {
		return purchasedSong;
	}

	public void setPurchasedSong(ArrayList<Purchase> purchasedSong) {
		this.purchasedSong = purchasedSong;
	}

	public ArrayList<Audio> getPlayback() {
		return playback;
	}

	public void setPlayback(ArrayList<Audio> playback) {
		this.playback = playback;
	}

	@Override
	/**
	 * <pre>
	 * <strong>Description:</strong> The method searchPlaylist allows to check if the playlist name is registered in the system
	 * <strong>pre:</strong> playlists must be initialized
	 * <strong>pos:</strong> NA
	 * @param nameAudio <strong>String</strong> Playlist name
	 * @return playlist <strong>Playlist</strong> Playlist that match the name
	 * </pre>
	 */
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
	/**
	 * <pre>
	 * <strong>Description:</strong> The method addPlaylist allows to add playlist to a buyer user
	 * <strong>pre:</strong> playlists must be initialized
	 * <strong>pos:</strong> Playlist is added
	 * @param newPlaylist </strong>Playlist</strong> Playlist to add
	 * @return status </strong>boolean</strong> To know if the process was successful or not
	 * </pre>
	*/
	public boolean addPlaylist(Playlist newPlaylist) {
		return getPlaylists().add(newPlaylist);
	}

	@Override
	/**
	 * <pre>
	 * <strong>Description:</strong> The method searchSong allows to check if the song was purchased by the user
	 * <strong>pre:</strong> purchasedSong must be initialized
	 * <strong>pos:</strong> NA
	 * @param song <strong>Song</strong> Object song
	 * @return isFound <strong>boolean</strong> To know if was bought or not
	 * </pre>
	 */
	public boolean searchSong(Song song) {
		boolean isFound = false;
		for (int i = 0; i < purchasedSong.size() && !isFound; i++) {
			if (purchasedSong.get(i).getSong().equals(song)) {
				isFound = true;
			}
		}
		return isFound;
	}

	@Override
	/**
	 * <pre>
	 * <strong>Description:</strong> The method addSong allows to add song to a buyer user
	 * <strong>pre:</strong> purchasedSong must be initialized
	 * <strong>pos:</strong> Song is added
	 * @param newSong </strong>Song</strong> Song to add
	 * @return status </strong>boolean</strong> To know if the process was successful or not
	 * </pre>
	*/
	public boolean addSong(Song newSong) {
		return purchasedSong.add(new Purchase(newSong, new Date()));
	}

	@Override
	/**
	 * <pre>
	 * <strong>Description:</strong> The method play allows to play an audio
	 * <strong>pre:</strong> playback must be initialized
	 * <strong>pos:</strong> Song is played and added to playback
	 * @return msg </strong>String</strong> Information on the result of the process
	 * </pre>
	*/
	public String play(Audio audio) {
		
		String msg = null;
		if(audio instanceof Song){
			Song song = (Song) audio;
			if (searchSong(song)) {
				msg = "| PLAYING SONG |";
				playback.add(song);
			}
		} else if (audio instanceof Podcast) {
			Podcast podcast = (Podcast) audio;
			msg = "\n| PLAYING PODCAST |";
			playback.add(podcast);
		}
		return msg;
	}
	
}
