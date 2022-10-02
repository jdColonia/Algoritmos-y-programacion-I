package model;

public class Level{
	
	private String id;
	private int points;
	private Treasure[] treasuresLevel; //Array for add treasure to a level
	private Enemy[] enemiesLevel; //Array for add enemy to a level
	
	public Level() {
		this.id = "";
		this.points = 0;
		this.treasuresLevel = new Treasure[50];
		this.enemiesLevel = new Enemy[25];
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	
	public Treasure[] getTreasuresLevel() {
		return treasuresLevel;
	}

	public void setTreasuresLevel(Treasure[] treasuresLevel) {
		this.treasuresLevel = treasuresLevel;
	}

	public Enemy[] getEnemiesLevel() {
		return enemiesLevel;
	}

	public void setEnemiesLevel(Enemy[] enemiesLevel) {
		this.enemiesLevel = enemiesLevel;
	}

	
	/**
	 * 
	 * @param myTreasure
	 * @return
	 */
	public boolean addTreasure(Treasure myTreasure) {
		
		for (int i = 0; i < treasuresLevel.length; i++) {

			if (treasuresLevel[i] == null) {
				
				treasuresLevel[i] = myTreasure;
				
				return true;
				
			}

		}

		return false;

	}

	
	
}