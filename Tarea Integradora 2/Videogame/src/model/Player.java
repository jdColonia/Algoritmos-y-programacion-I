package model;

public class Player{

	private String nickname;
	private String namePlayer;
	private String level;
	private int numberLives;
	private int score;
	
	public Player(String nickname, String namePlayer) {
		this.nickname = nickname;
		this.namePlayer = namePlayer;
		this.level = null;
		this.numberLives = 0;
		this.score = 0;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getNamePlayer() {
		return namePlayer;
	}

	public void setNamePlayer(String namePlayer) {
		this.namePlayer = namePlayer;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public int getNumberLives() {
		return numberLives;
	}

	public void setNumberLives(int numberLives) {
		this.numberLives = numberLives;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}