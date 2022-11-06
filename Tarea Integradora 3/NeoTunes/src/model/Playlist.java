package model;

import java.util.ArrayList;

public class Playlist {
	
	private String namePlaylist;
	private int[][] matrix;
	private String idPlayList;
	private ArrayList<Audio> audioList;
	
	public Playlist(String namePlaylist, int[][] matrix, String iDPlayList) {
		this.namePlaylist = namePlaylist;
		this.matrix = matrix;
		this.idPlayList = iDPlayList;
	}
	
	public String getNamePlaylist() {
		return namePlaylist;
	}
	
	public void setNamePlaylist(String namePlaylist) {
		this.namePlaylist = namePlaylist;
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
