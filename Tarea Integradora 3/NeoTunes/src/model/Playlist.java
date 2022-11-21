package model;

import java.util.ArrayList;

public class Playlist {

	private String namePlaylist;
	private PlaylistType playlistType;
	private int[][] matrix;
	private String idPlayList;
	private ArrayList<Audio> audioList;

	public Playlist(String namePlaylist, int playlistType, int[][] matrix, String idPlaylist) {
		this.namePlaylist = namePlaylist;
		this.playlistType = PlaylistType.values()[playlistType];
		this.matrix = matrix;
		this.idPlayList = idPlaylist;
		this.audioList = new ArrayList<Audio>();
	}

	public String getNamePlaylist() {
		return namePlaylist;
	}

	public void setNamePlaylist(String namePlaylist) {
		this.namePlaylist = namePlaylist;
	}

	public PlaylistType getPlaylistType() {
		return playlistType;
	}

	public void setPlaylistType(PlaylistType playlistType) {
		this.playlistType = playlistType;
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

	public String getIdPlayList() {
		return idPlayList;
	}

	public void setIdPlayList(String idPlayList) {
		this.idPlayList = idPlayList;
	}

	public ArrayList<Audio> getAudioList() {
		return audioList;
	}

	public void setAudioList(ArrayList<Audio> audioList) {
		this.audioList = audioList;
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method searchAudio allows to check if the audio is in the playlist
	 * <strong>pre:</strong> audioList must be initialized
	 * <strong>pos:</strong> NA
	 * @param nameAudio <strong>String</strong> Audio name
	 * @return audio <strong>Audio</strong> Audio that match the name
	 * </pre>
	 */
	public Audio searchAudio(String nameAudio) {
		Audio audio = null;
		boolean isFound = false;
		for (int i = 0; i < audioList.size() && !isFound; i++) {
			if (audioList.get(i).getNameAudio().equalsIgnoreCase(nameAudio)) {
				audio = audioList.get(i);
				isFound = true;
			}
		}
		return audio;
	}

	/**
	 * <pre>
	 * <strong>Description:</strong> The method addAudio allows to add an audio
	 * <strong>pre:</strong> audioList must be initialized
	 * <strong>pos:</strong> Audio is added
	 * @param newAudio <strong>Audio</strong> Object audio
	 * @return status <strong>boolean</strong> To know if the process was successful or not
	 * </pre>
	*/
	public boolean addAudio(Audio newAudio) {
		return audioList.add(newAudio);
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method removeAudio allows to remove an audio
	 * <strong>pre:</strong> audioList must be initialized
	 * <strong>pos:</strong> Audio is removed
	 * @param newAudio <strong>String</strong> Object audio
	 * @return status <strong>boolean</strong> To know if the process was successful or not
	 * </pre>
	*/
	public boolean removeAudio(Audio newAudio) {
		return audioList.remove(newAudio);
	}

}
