package model;

public class Treasure{
	
	private String nameTreasure;
	private String image;
	private int scoreAwardedToPlayer;
	private int positionX;
	private int positionY;
	
	public Treasure(String nameTreasure, String image, int scoreAwardedToPlayer, int positionX, int positionY) {
		this.nameTreasure = nameTreasure;
		this.image = image;
		this.scoreAwardedToPlayer = scoreAwardedToPlayer;
		this.positionX = positionX;
		this.positionY = positionY;
	}

	public String getNameTreasure() {
		return nameTreasure;
	}

	public void setNameTreasure(String nameTreasure) {
		this.nameTreasure = nameTreasure;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getScoreAwardedToPlayer() {
		return scoreAwardedToPlayer;
	}

	public void setScoreAwardedToPlayer(int scoreAwardedToPlayer) {
		this.scoreAwardedToPlayer = scoreAwardedToPlayer;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

}