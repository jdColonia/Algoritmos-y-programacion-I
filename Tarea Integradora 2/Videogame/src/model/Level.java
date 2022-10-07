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
	 * <pre>
	 * <strong>Description:</strong> The method addTreasure allows to add treasures to a level
	 * <strong>pre:</strong> treasuresList must be initialized
	 * <strong>pos:</strong> Treasure is register in a level
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
				
				if (verifyEnemy(nameEnemy)) {
				
					enemiesList[i] = myEnemy;
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
				
				msg = "There aren't any treasures registered in this level";
			
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
			
			msg = "There aren't any enemies registered in this level";
		
		}
		
	return msg;
		
	}
	
}