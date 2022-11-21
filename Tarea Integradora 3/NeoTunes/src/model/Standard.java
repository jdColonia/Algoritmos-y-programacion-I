package model;

import java.util.ArrayList;
import java.util.Date;

public class Standard extends Buyer implements IAdvertisement{

	private Playlist[] playlists;
	private Purchase[] purchasedSong;
    private ArrayList<Audio> playback;

	public Standard(String nameUser, String identificationNumber, Date bondingDate) {
		super(nameUser, identificationNumber, bondingDate);
		this.playlists = new Playlist[20];
		this.purchasedSong = new Purchase[100];
		this.playback = new ArrayList<Audio>();
	}

	public Playlist[] getPlaylists() {
		return playlists;
	}

	public void setPlaylists(Playlist[] playlists) {
		this.playlists = playlists;
	}

	public Purchase[] getPurchasedSong() {
		return purchasedSong;
	}

	public void setPurchasedSong(Purchase[] purchasedSong) {
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
	/**
	 * <pre>
	 * <strong>Description:</strong> The method addPlaylist allows to add playlist to a buyer user
	 * <strong>pre:</strong> playlists must be initialized
	 * <strong>pos:</strong> Playlist is added
	 * @param newPlaylist </strong>Playlist</strong> Playlist to add
	 * @return stopFlag </strong>boolean</strong> To know if the process was successful or not
	 * </pre>
	*/
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
		for (int i = 0; i < purchasedSong.length && !isFound; i++) {
			if (purchasedSong[i] != null) {
				if (purchasedSong[i].getSong().equals(song)) {
					isFound = true;
				}
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
	 * @return stopFlag </strong>boolean</strong> To know if the process was successful or not
	 * </pre>
	*/
	public boolean addSong(Song newSong) {
		boolean stopFlag = false;
		for (int i = 0; i < purchasedSong.length && !stopFlag; i++) {
			if (purchasedSong[i] == null) {
				purchasedSong[i] = new Purchase(newSong, new Date());
				stopFlag = true;
			}
		}
		return stopFlag;
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
				playback.add(song);
				msg = "| PLAYING SONG |";
				int reproductions = 0;
				for (int i = 0; i < playback.size(); i++) {
					if (playback.get(i) instanceof Song) {
						reproductions++;
					}
				}
				if ((reproductions % 2) == 0) {
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
			msg += "\n| PLAYING PODCAST |";
			playback.add(podcast);
		}
		return msg;
	}

}
