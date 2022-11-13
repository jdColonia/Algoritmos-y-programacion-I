package model;

public abstract class Audio {
	
	private String nameAudio;
	private String url;
	private int duration;
	private int numberPlays;
	
	public Audio(String nameAudio, String url, int duration) {
		this.nameAudio = nameAudio;
		this.url = url;
		this.duration = duration;
		this.numberPlays = 0;
	}

	public String getNameAudio() {
		return nameAudio;
	}

	public void setNameAudio(String nameAudio) {
		this.nameAudio = nameAudio;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getNumberPlays() {
		return numberPlays;
	}

	public void setNumberPlays(int numberPlays) {
		this.numberPlays += numberPlays;
	}

}
