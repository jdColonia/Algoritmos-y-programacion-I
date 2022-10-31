package model;

public class Playlist {
	
	private String namePlaylist;
	private String idPlayList;
	
	public Playlist(String namePlaylist, String iDPlayList) {
		super();
		this.namePlaylist = namePlaylist;
		this.idPlayList = iDPlayList;
	}
	
	public String getNamePlaylist() {
		return namePlaylist;
	}
	
	public void setNamePlaylist(String namePlaylist) {
		this.namePlaylist = namePlaylist;
	}

	public String getIdPlayList() {
		return idPlayList;
	}

	public void setIdPlayList(String idPlayList) {
		this.idPlayList = idPlayList;
	}
	
}
