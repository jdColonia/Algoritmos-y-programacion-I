package model;

import  java.util.Random;

public class VideogameController{
	
	public static Random random = new Random();
	private Player[] playersList;
	private Level[] levels;
	
	public VideogameController() {
		this.playersList = new Player[20];
		this.levels = new Level[10];
	}
	
	public Player[] getPlayersList() {
		return playersList;
	}

	public void setPlayersList(Player[] playersList) {
		this.playersList = playersList;
	}

	public Level[] getLevels() {
		return levels;
	}

	public void setLevels(Level[] levels) {
		this.levels = levels;
	}
	
	public String getEnemyType() {
		
		String msg = "";
		
		EnemyType[] enemyType = EnemyType.values();
		
		for (int i = 0; i < enemyType.length; i++) {
			
			msg += "\n[" + (i+1) + "]" + enemyType[i];
			
		}
		
		return msg;
		
	}
	
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method createLevel allows to add the id and the points to the level
	 * <strong>pre:</strong> levels must be initialized
	 * <strong>pos:</strong> The id and points are added to each level
	 * </pre>
	 */
	public void createLevel() {
		
		String id = "";
		int points = 0;
		
		for (int i = 0; i < levels.length; i++) {
			
			Level myLevel = new Level ();
			
			if (levels[i] == null) {
				
				id = "Level " + (i + 1);
				myLevel.setId(id);
				points += 10; 
				myLevel.setPoints(points);
				levels[i] = myLevel;
				
			}
				
		}
		
	}

	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method verifyNickname allows to check if the nickname is in the system
	 * <strong>pre:</strong> playerList must be initialized
	 * <strong>pos:</strong> Know if nickname to register is not registered for another player
	 * @param nickname <strong>String</strong> Nickname of the player
	 * @return stopFlag <strong>boolean</strong> Flag to know if the process was successful or not
	 * </pre>
	 */
	public boolean verifyNickname (String nickname) {
		
		boolean stopFlag = true;
		
		for (int i = 0; i < playersList.length; i++) {
			
			if (playersList[i] != null) {
				
				if (nickname.equals(playersList[i].getNickname())) {
					
					return stopFlag = false;
					
				}
				
			}

		}
		
		return stopFlag;
		
	}
	
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method createPlayer allows to register one player to the system
	 * <strong>pre:</strong> playerList must be initialized
	 * <strong>pos:</strong> Player is register in the playerList
	 * @param nickname <strong>String</strong> Nickname of the player
	 * @param namePlayer <strong>String</strong> Name of the player
	 * @return stopFlag <strong>boolean</strong> Flag to know if the process was successful or not
	 * </pre>
	 */
	public boolean createPlayer(String nickname, String namePlayer) {
		
		Player myPlayer = new Player(nickname, namePlayer);
		
		boolean stopFlag = false;
		
		for (int i = 0; i < playersList.length; i++) {
			
			if (playersList[i] == null) {
				
				myPlayer.setLevel("Level " + (i +1));
				myPlayer.setScore(10);
				myPlayer.setNumberLives(5);
				playersList[i] = myPlayer;
				return stopFlag = true;
				
			}

		}

		return stopFlag;
		
	}
	
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method generatePositionX allows to randomly generate the X position of the treasure or enemy
	 * <strong>pre:</strong> random must be initialized
	 * <strong>pos:</strong> positionX is automatically generated
	 * @return positionX <strong>int</strong> Random position of a treasure or enemy
	 * </pre>
	 */
	public int generatePositionX() {
		
		int positionX = random.nextInt(1281);
		
		return positionX;
	}
	
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method generatePositionY allows to randomly generate the Y position of the treasure or enemy
	 * <strong>pre:</strong> random must be initialized
	 * <strong>pos:</strong> positionY is automatically generated
	 * @return positionY <strong>int</strong> Random position of a treasure or enemy
	 * </pre>
	 */
	public int generatePositionY() {
		
		int positionY = random.nextInt(721);
		
		return positionY;
	}
	
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method createTreasure allows to register treasures to a level
	 * <strong>pre:</strong> levels must be initialized
	 * <strong>pos:</strong> Treasure is registered in a level
	 * @param optionLevel </strong>int</strong> Level where the treasure will be added
	 * @param nameTreasure </strong>String</strong> Name of the treasure
	 * @param image </strong>String</strong> Image of the treasure 
	 * @param scoreAwardedToPlayer </strong>int</strong> Score that the treasure award from the player
	 * @param numTreasures </strong>int</strong> Number of treasures that will be added in the level
	 * @return stopFlag </strong>boolean</strong> Flag to know if the process was successful or not
	 * </pre>
	*/
	public boolean createTreasure(int optionLevel, String nameTreasure, String image, int scoreAwardedToPlayer, int numTreasures) {

		boolean stopFlag = false;
		
		for (int i = 0; i < levels.length; i++) {
	
			for (int j = 0; j < numTreasures; j++) {
				
				if (levels[i].getId().equals(levels[optionLevel].getId())) {
							
					int positionX = generatePositionX();
					int positionY = generatePositionY();
							
					stopFlag = levels[i].addTreasure(nameTreasure, image, scoreAwardedToPlayer, positionX, positionY);
				
				}
	
			}
			
		}

		return stopFlag;

	}
	
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method createTreasure allows to register one treasure to the system
	 * <strong>pre:</strong> enemiesList must be initialized
	 * <strong>pos:</strong> Enemy is register in the enemiesList
	 *@param optionLevel </strong>int</strong> Option of the level where the enemy will be added
	 *@param nameEnemy </strong>String</strong> Name of the enemy
	 *@param enemyType </strong>int</strong> Type of the enemy
	 *@param scoreSubtractedToPlayer </strong>int</strong> Score that the enemy subtract from the player
	 *@param scoreAwardedToPlayer </strong>int</strong> Score that the enemy award from the player
	 *@return stopFlag </strong>boolean</strong> Flag to know if the process was successful or not
	 * </pre>
	*/
	public boolean createEnemy(int optionLevel, String nameEnemy, int enemyType, int scoreSubtractedToPlayer, int scoreAwardedToPlayer) {
		
		boolean stopFlag = false;
		
		for (int i = 0; i < levels.length; i++) {
	
			if (levels[i].getId().equals(levels[optionLevel].getId())) {
							
				int positionX = generatePositionX();
				int positionY = generatePositionY();
					
				stopFlag = levels[i].addEnemy(nameEnemy, enemyType, scoreSubtractedToPlayer, scoreAwardedToPlayer, positionX, positionY);
				
			}
			
		}

		return stopFlag;
		
	}

	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method showLevels allows to show the list of levels of the system
	 * <strong>pre:</strong> levels must be initialized
	 * <strong>pos:</strong> Show list of levels
	 * @return msg </strong>String</strong> Message with list of levels (only id)
	 * </pre>
	*/
	public String showLevels() {

		String msg = "";

		for (int i = 0; i < levels.length; i++) {

			if (levels[i] != null) {

				msg += "\n[" + (i+1) + "]" + levels[i].getId();
				
			}
			
		}

		return msg;

	}
	
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method showPlayerList allows to show the list of players registered in the system
	 * <strong>pre:</strong> playersList must be initialized
	 * <strong>pos:</strong> Show list of players
	 * @return msg </strong>String</strong> Message with list of players (only nickname)
	 * </pre>
	*/
	public String showPlayersList() {

		String msg = "";

		for (int i = 0; i < playersList.length; i++) {

			if (playersList[i] != null) {

				msg += "\n[" + (i+1) + "]" + playersList[i].getNickname();
				
			}
			
		}

		return msg;

	}
	
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method modifyScorePlayer allows to modify a player's score
	 * <strong>pre:</strong> playersList must be initialized
	 * <strong>pos:</strong> Score of a player changed
	 * @param optionPlayer </strong>int</strong> Player whose score will be changed
	 * @param newScore </strong>int</strong> New score of the player
	 * @return stopFlag </strong>boolean</strong> Flag to know if the process was successful or not
	 * </pre>
	*/
	public boolean modifyScorePlayer(int optionPlayer, int newScore) {
		
		boolean stopFlag = false;
		
		for (int i = 0; i < playersList.length; i++) {
			
			if ((playersList[i] != null) && (playersList[i].getNickname().equals(playersList[optionPlayer].getNickname()))) {
				
				playersList[optionPlayer].setScore(newScore);
				return stopFlag = true;
			
			}
			
		}
		
		return stopFlag;
		
	}
	
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method modifyLevelPlayer allows to modify a player's level
	 * <strong>pre:</strong> playersList must be initialized
	 * <strong>pos:</strong> Level of a player changed
	 * @param optionPlayer </strong>int</strong> Player whose level will be changed
	 * @param newLevel </strong>int</strong> New level of the player
	 * @return stopFlag </strong>boolean</strong> Flag to know if the process was successful or not
	 * </pre>
	*/
	public boolean modifyLevelPlayer(int optionPlayer, int newLevel) {
		
		boolean stopFlag = false;
				
		for (int i = 0; i < playersList.length; i++) {
				
			if ((playersList[i] != null) && (playersList[i].getNickname().equals(playersList[optionPlayer].getNickname()))) {
						
				if (playersList[optionPlayer].getScore() > levels[newLevel].getPoints()) {
							
					playersList[optionPlayer].setLevel("Level " + (newLevel+1));
					stopFlag = true;
					
				}
				
			}
			
		}		
		
		return stopFlag;
		
	}
	
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method scoreRequiredToPassLevel allows you know what score is needed to go to the next level
	 * <strong>pre:</strong> playersList must be initialized
	 * <strong>pos:</strong> Determine the score required to move to the next level
	 * @param optionPlayer </strong>int</strong> Player whose level will be changed
	 * @param newLevel </strong>int</strong> New level of the player
	 * @return scoreRequired </strong>int</strong> Score required to go to the next level
	 * </pre>
	*/
	public int scoreRequiredToPassLevel(int optionPlayer, int newLevel) {
		
		int scoreRequired = 0;
		
		for (int i = 0; i < playersList.length; i++) {
			
			if ((playersList[i] != null) && (playersList[i].getNickname().equals(playersList[optionPlayer].getNickname()))) {
				
				if (playersList[optionPlayer].getScore() < levels[newLevel].getPoints()) {
					
					scoreRequired = levels[newLevel].getPoints();
					
				}

			}
			
		}
		
		return scoreRequired;
		
	}
	
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method showTreasuresAndEnemies allows to show a list of registered treasures and enemies in a level
	 * <strong>pre:</strong> levels must be initialized
	 * <strong>pos:</strong> Show list of registered treasures and enemies in a level
	 * @param optionLevel </strong>int</strong> Level from which the list is obtained
	 * @return msg </strong>String</strong> Message with list of registered treasures and enemies in a level
	 * </pre>
	*/
	public String showTreasuresAndEnemies (int optionLevel) {
		
		String msgTreasures = "";
		String msgEnemies = "";
		
		for (int i = 0; i < levels.length; i++) {
			
			if (levels[i].getId().equals(levels[optionLevel].getId())) {
					
				msgTreasures += levels[(optionLevel)].showTreasuresByLevel();
				msgEnemies += levels[(optionLevel)].showEnemiesByLevel();
				
			}
			
		}
		
		String msg = msgTreasures + "\n" + msgEnemies;
		
		return msg;
			
	}
	
	public boolean searchTreasure(String nameTreasure) {
		
		boolean stopFlag = false;
		
		for (int i = 0; i < levels.length; i++) {
			
			for (int j = 0; j < levels[i].getTreasuresList().length; j++) {
				
				if (levels[i].getTreasuresList()[j] != null) {
				
					if (levels[i].getTreasuresList()[j].getNameTreasure().equals(nameTreasure)) {
						
						stopFlag = true;
						
					}
					
				}
				
			}
			
			
		}
		
		return stopFlag;

	}
	
	
	public int amountTreasureLevels(String nameTreasure) {
		
		int numTreasuresInAllLevel = 0;
		
		for (int i = 0; i < levels.length; i++) {
			
			numTreasuresInAllLevel += levels[i].amountTreasureLevel(nameTreasure);
			
		}
		
		return numTreasuresInAllLevel;
		
	}
	
	
	public boolean searchEnemy(String nameEnemy) {
		
		boolean stopFlag = false;
		
		for (int i = 0; i < levels.length; i++) {
			
			for (int j = 0; j < levels[i].getEnemiesList().length; j++) {
				
				if (levels[i].getEnemiesList()[j] != null) {
				
					if (levels[i].getEnemiesList()[j].getNameEnemy().equals(nameEnemy)) {
						
						stopFlag = true;
						
					}
					
				}
				
			}
			
			
		}
		
		return stopFlag;

	}
	
	
	public int amountEnemyLevels(String nameEnemy) {
		
		int numEnemiesInAllLevel = 0;
		
		for (int i = 0; i < levels.length; i++) {
			
			numEnemiesInAllLevel += levels[i].amountEnemyLevel(nameEnemy);
			
		}
		
		return numEnemiesInAllLevel;
		
	}
	



}