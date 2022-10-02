package model;

public class Enemy{
	
	private String nameEnemy;
	private int scoreSubtractedToPlayer;
	private int scoreAwardedToPlayer;
	private int positionX;
	private int positionY;
	private EnemyType enemyType;
	
	public Enemy(String nameEnemy, int enemyType, int scoreSubtractedToPlayer, int scoreAwardedToPlayer) {
		this.nameEnemy = nameEnemy;
		this.enemyType = EnemyType.values()[enemyType];
		this.scoreSubtractedToPlayer = scoreSubtractedToPlayer;
		this.scoreAwardedToPlayer = scoreAwardedToPlayer;
		this.positionX = 0;
		this.positionY = 0;
	}

	public String getNameEnemy() {
		return nameEnemy;
	}

	public void setNameEnemy(String nameEnemy) {
		this.nameEnemy = nameEnemy;
	}

	public int getScoreSubtractedToPlayer() {
		return scoreSubtractedToPlayer;
	}

	public void setScoreSubtractedToPlayer(int scoreSubtractedToPlayer) {
		this.scoreSubtractedToPlayer = scoreSubtractedToPlayer;
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

	public EnemyType getEnemyType() {
		return enemyType;
	}

	public void setEnemyType(EnemyType enemyType) {
		this.enemyType = enemyType;
	}
	
	
	

}