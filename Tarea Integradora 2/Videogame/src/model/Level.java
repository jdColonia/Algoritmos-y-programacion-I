package model;

public class Level{
	
	private String id;
	private int points;
	private ComplexityLevel complexityLevel;
	private Treasure[] treasuresList;
	private Enemy[] enemiesList;
	
	public Level() {
		this.id = "";
		this.points = 0;
		//this.complexityLevel = ComplexityLevel.values()[complexityLevel];
		this.treasuresList = new Treasure[50];
		this.enemiesList = new Enemy[25];
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
	
	public ComplexityLevel getComplexityLevel() {
		return complexityLevel;
	}

	public void setComplexityLevel(ComplexityLevel complexityLevel) {
		this.complexityLevel = complexityLevel;
	}

	public Treasure[] getTreasuresList() {
		return treasuresList;
	}

	public void setTreasuresList(Treasure[] treasuresList) {
		this.treasuresList = treasuresList;
	}

	public Enemy[] getEnemiesList() {
		return enemiesList;
	}

	public void setEnemiesList(Enemy[] enemiesList) {
		this.enemiesList = enemiesList;
	}
	
	
	/**
	 *Description: The method addTreasure allow to add treasures to a level
	 *pre: treasuresList must be initialized
	 *pos: Treasure is register in a level
	 *@param nameTreasure	String	Name of the treasure
	 *@param image	String	Image of the treasure 
	 *@param scoreAwardedToPlayer	int Score that the treasure award from the player
	 *@param positionX	int	Position in X of the treasure
	 *@param positionY	int	Position in Y of the treasure
	 *@return stopFlag	boolean	Flag to know if the process was successful or not
	*/
	public boolean addTreasure(String nameTreasure, String image, int scoreAwardedToPlayer, int positionX, int positionY) {
		
		boolean stopFlag = false;
		
		Treasure myTreasure = new Treasure(nameTreasure, image, scoreAwardedToPlayer, positionX, positionY);
		
		for (int i = 0; i < treasuresList.length; i++) {

			if (treasuresList[i] == null) {
				
				treasuresList[i] = myTreasure;
				return stopFlag = true;
				
			}

		}

		return stopFlag;

	}
	
	
	/**
	 *Description: The method verifyEnemy allows to check if the name of the enemy is in the system
	 *pre: enemiesList must be initialized
	 *pos: Know if nameEnemy to register is not registered for another enemy
	 *@param nameEnemy	String	Name of the enemy
	 *@return stopFlag	boolean	Flag to know if the process was successful or not
	 */
	public boolean verifyEnemy (String nameEnemy) {
		
		boolean stopFlag = true;
		
		for (int i = 0; i < enemiesList.length; i++) {
			
			if (enemiesList[i] != null) {
				
				if (nameEnemy.equals(enemiesList[i].getNameEnemy())) {
					
					return stopFlag = false;
					
				}
				
			}

		}
		
		return stopFlag;
		
	}
	
	
	/**
	 *Description: The method addEnemy allow to add enemies to a level
	 *pre: enemiesList must be initialized
	 *pos: Enemy is register in the enemiesList
	 *@param nameEnemy	String	Name of the enemy
	 *@param enemyType	int	Type of the enemy
	 *@param scoreSubtractedToPlayer	int	Score that the enemy subtract from the player
	 *@param scoreAwardedToPlayer	int	Score that the enemy award from the player
	 *@param positionX	int	Position in X of the enemy
	 *@param positionY	int	Position in Y of the enemy
	 *@return stopFlag	boolean	Flag to know if the process was successful or not
	*/
	public boolean addEnemy(String nameEnemy, int enemyType, int scoreSubtractedToPlayer, int scoreAwardedToPlayer, int positionX, int positionY) {
		
		boolean stopFlag = false;
		
		Enemy myEnemy = new Enemy(nameEnemy, enemyType, scoreSubtractedToPlayer, scoreAwardedToPlayer, positionX, positionY);
		
		for (int i = 0; i < enemiesList.length; i++) {

			if (enemiesList[i] == null) {
				
				if (verifyEnemy(nameEnemy)) {
				
					enemiesList[i] = myEnemy;
					return stopFlag = true;
				
				}
				
			}

		}

		return stopFlag;

	}

	
	
}