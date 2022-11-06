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

}
