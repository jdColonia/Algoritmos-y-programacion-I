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
		this.complexityLevel = ComplexityLevel.values()[1];
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

	public void setComplexityLevel(int scoreTreasures, int scoreEnemies) {
		if (scoreTreasures > scoreEnemies) {
			this.complexityLevel = ComplexityLevel.values()[0];
		} else if (scoreTreasures < scoreEnemies) {
			this.complexityLevel = ComplexityLevel.values()[2];
		} else {
			this.complexityLevel = ComplexityLevel.values()[1];
		}
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
	 * <pre>
	 * <strong>Description:</strong> The countScoreTreasures method allows to count the points awarded for the treasures to a player
	 * <strong>pre:</strong> treasuresList must be initialized
	 * <strong>pos:</strong> The total score awarded by the treasures to a player is obtained
	 * @return scoreTreasures </strong>int</strong> Total score awarded to player
	 * </pre>
	*/
	public int countScoreTreasures() {
		int scoreTreasures = 0;
		for (int i = 0; i < treasuresList.length; i++) {
			if (treasuresList[i] != null) {
				scoreTreasures = treasuresList[i].getScoreAwardedToPlayer();
			}
		}
		return scoreTreasures;
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The countScoreEnemies method allows to count the points awarded for the enemies to a player
	 * <strong>pre:</strong> enemiesList must be initialized
	 * <strong>pos:</strong> The total score awarded by the enemies to a player is obtained
	 * @return scoreEnemies </strong>int</strong> Total score awarded to player
	 * </pre>
	*/
	public int countScoreEnemies() {
		int scoreEnemies = 0;
		for (int i = 0; i < enemiesList.length; i++) {
			if (enemiesList[i] != null) {
				scoreEnemies = enemiesList[i].getScoreAwardedToPlayer();
			}
		}
		return scoreEnemies;
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method addTreasure allows to add treasures to a level
	 * <strong>pre:</strong> treasuresList must be initialized
	 * <strong>pos:</strong> Treasure is register in a level and the level of complexity of the level is updated
	 * @param nameTreasure </strong>String</strong> Name of the treasure
	 * @param image </strong>String</strong> Image of the treasure 
	 * @param scoreAwardedToPlayer </strong>int</strong> Score that the treasure award from the player
	 * @param positionX </strong>int</strong> Position in X of the treasure
	 * @param positionY </strong>int</strong> Position in Y of the treasure
	 * @return stopFlag </strong>boolean</strong> Flag to know if the process was successful or not
	 * </pre>
	*/
	public boolean addTreasure(String nameTreasure, String image, int scoreAwardedToPlayer, int positionX, int positionY) {	
		boolean stopFlag = false;
		Treasure myTreasure = new Treasure(nameTreasure, image, scoreAwardedToPlayer, positionX, positionY);
		for (int i = 0; i < treasuresList.length; i++) {
			if (treasuresList[i] == null) {
				treasuresList[i] = myTreasure;
				setComplexityLevel(countScoreTreasures(), countScoreEnemies());
				return stopFlag = true;
			}
		}
		return stopFlag;
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method verifyEnemy allows to check if the name of the enemy is in the system
	 * <strong>pre:</strong> enemiesList must be initialized
	 * <strong>pos:</strong> Know if nameEnemy to register is not registered for another enemy
	 * @param nameEnemy </strong>String</strong> Name of the enemy
	 * @return stopFlag </strong>boolean</strong> Flag to know if the process was successful or not
	 * </pre>
	 */
	public boolean verifyEnemy (String nameEnemy) {
		boolean stopFlag = false;
		for (int i = 0; i < enemiesList.length; i++) {
			if (enemiesList[i] != null) {
				if (enemiesList[i].getNameEnemy().equals(nameEnemy)) {	
					return stopFlag = true;	
				}
			}
		}
		return stopFlag;	
	}
	
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method addEnemy allows to add enemies to a level
	 * <strong>pre:</strong> enemiesList must be initialized
	 * <strong>pos:</strong> Enemy is register in the enemiesList
	 * @param nameEnemy </strong>String</strong> Name of the enemy
	 * @param enemyType </strong>int</strong> Type of the enemy
	 * @param scoreSubtractedToPlayer </strong>int</strong> Score that the enemy subtract from the player
	 * @param scoreAwardedToPlayer </strong>int</strong> Score that the enemy award from the player
	 * @param positionX </strong>int</strong> Position in X of the enemy
	 * @param positionY </strong>int</strong> Position in Y of the enemy
	 * @return stopFlag </strong>boolean</strong> Flag to know if the process was successful or not
	 * </pre>
	*/
	public boolean addEnemy(String nameEnemy, int enemyType, int scoreSubtractedToPlayer, int scoreAwardedToPlayer, int positionX, int positionY) {
		boolean stopFlag = false;
		Enemy myEnemy = new Enemy(nameEnemy, enemyType, scoreSubtractedToPlayer, scoreAwardedToPlayer, positionX, positionY);
		for (int i = 0; i < enemiesList.length; i++) {
			if (enemiesList[i] == null) {	
				if (!verifyEnemy(nameEnemy)) {
					enemiesList[i] = myEnemy;
					setComplexityLevel(countScoreTreasures(), countScoreEnemies());
					return stopFlag = true;
				}		
			}
		}
		return stopFlag;
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method showTreasuresByLevel allows to show the list of treasures registered in a level
	 * <strong>pre:</strong> treasuresList must be initialized
	 * <strong>pos:</strong> Get the list of treasures in a level
	 * @return msg </strong>String</strong> Message with list of treasures
	 * </pre>
	*/
	public String showTreasuresByLevel() {
		String msg = "";	
		if (treasuresList[0] != null) {	
			for (int i = 0; i < treasuresList.length; i++) {	
				if (treasuresList[i] != null) {					
					if (i == 0) {							
						msg += "Treasures: " + treasuresList[i].getNameTreasure() + ", ";								
					} else if (i < treasuresList.length-1) {				
						msg += treasuresList[i].getNameTreasure() + ", ";							
					} else {							
						msg += treasuresList[i].getNameTreasure() + ".";					
					} 	
				}
			}		
		} else {	
			msg = "There aren't any treasures registered in this level.";	
		}	
		return msg;		
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method showEnemiesByLevel allows to show the list of enemies registered in a level
	 * <strong>pre:</strong> enemiesList must be initialized
	 * <strong>pos:</strong> Get the list of enemies in a level
	 * @return msg </strong>String</strong> Message with list of enemies
	 * </pre>
	*/
	public String showEnemiesByLevel() {	 
		String msg = "";
		if (enemiesList[0] != null) {	
			for (int i = 0; i < enemiesList.length; i++) {			
				if (enemiesList[i] != null) {				
					if (i == 0) {						
						msg += "Enemies: " + enemiesList[i].getNameEnemy() + ", ";							
					} else if (i < enemiesList.length-1) {							
						msg += enemiesList[i].getNameEnemy() + ", ";						
					} else {							
						msg += enemiesList[i].getNameEnemy() + ".";							
					} 				
				}				
			}			
		} else {			
			msg = "There aren't any enemies registered in this level.";		
		}		
		return msg;		
	}

	/**
	 * <pre>
	 * <strong>Description:</strong> The method amountTreasureLevel allows to find the amount of a treasure in a level
	 * <strong>pre:</strong> treasuresList must be initialized
	 * <strong>pos:</strong> Determine the amount of a treasure
	 * @param nameTreasure </strong>String</strong> Name of the treasure from which its amount will be obtained
	 * @return numTreasuresInTheLevel </strong>int</strong> Amount of a treasure in a level
	 * </pre>
	*/
	public int amountTreasureLevel (String nameTreausure) {	
		int numTreasuresInTheLevel = 0;		
		for (int i = 0; i < treasuresList.length; i++) {			
			if ((treasuresList[i] != null) && (treasuresList[i].getNameTreasure().equals(nameTreausure))) {				
				numTreasuresInTheLevel += 1;				
			}			
		}		
		return numTreasuresInTheLevel;		  
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method amountEnemyLevel allows to find the amount of a type of enemy in a level
	 * <strong>pre:</strong> enemiesList must be initialized
	 * <strong>pos:</strong> Determine the amount of a type of enemy
	 * @param enemyType </strong>int</strong> Enemy type from which its amount will be obtained
	 * @return numEnemiesInTheLevel </strong>int</strong> Amount of a type of enemy in a level
	 * </pre>
	*/
	public int amountEnemyLevel (int enemyType) {		
		int numEnemiesInTheLevel = 0;		
		for (int i = 0; i < enemiesList.length; i++) {			
			if ((enemiesList[i] != null) && (enemiesList[i].getEnemyType().equals(EnemyType.values()[enemyType]))) {				
				numEnemiesInTheLevel += 1;				
			}			
		}		
		return numEnemiesInTheLevel;		  
	}	
			
}
	