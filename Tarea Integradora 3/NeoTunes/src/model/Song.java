package model;

public class Song extends Audio {

	private String album;
	private double saleValue;
	private int numberTimesSold;
	private GenreType genreType;

	public Song(String nameAudio, String album, int genreType, String url, int duration, double saleValue,
			int numberPlays, int numberTimesSold) {
		super(nameAudio, url, duration, numberPlays);
		this.album = album;
		this.genreType = GenreType.values()[genreType];
		this.saleValue = saleValue;
		this.numberTimesSold = numberTimesSold;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public double getSaleValue() {
		return saleValue;
	}

	public void setSaleValue(double saleValue) {
		this.saleValue = saleValue;
	}

	public int getNumberTimesSold() {
		return numberTimesSold;
	}

	public void setNumberTimesSold(int numberTimesSold) {
		this.numberTimesSold = numberTimesSold;
	}

	public GenreType getGenreType() {
		return genreType;
	}

	public void setGenreType(GenreType genreType) {
		this.genreType = genreType;
	}

}
