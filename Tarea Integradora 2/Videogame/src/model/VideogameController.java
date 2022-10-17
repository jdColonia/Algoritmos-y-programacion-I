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
	 * <strong>Description:</strong> The createLevel method allows to create each level of the game
	 * <strong>pre:</strong> levels must be initialized
	 * <strong>pos:</strong> Levels are created with their respective attributes
	 * </pre>
	 */
	public void createLevel() {
		String id = "";
		int points = 0;
		for (int i = 0; i < levels.length; i++) {
			Level myLevel = new Level();
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
	 * <strong>Description:</strong> The method verifyNickname allows to check if the nickname is registered in the system
	 * <strong>pre:</strong> playerList must be initialized
	 * <strong>pos:</strong> Know if nickname to register is not registered for another player
	 * @param nickname <strong>String</strong> Nickname of the player
	 * @return stopFlag <strong>boolean</strong> Flag to know if the process was successful or not
	 * </pre>
	 */
	public boolean verifyNickname (String nickname) {
		boolean stopFlag = false;
		for (int i = 0; i < playersList.length; i++) {
			if (playersList[i] != null) {
				if (nickname.equals(playersList[i].getNickname())) {
					return stopFlag = true;
				}
			}
		}
		return stopFlag;
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method createPlayer allows to register one player to the system
	 * <strong>pre:</strong> playerList must be initialized
	 * <strong>pos:</strong> Player is registered in the playerList
	 * @param nickname <strong>String</strong> Nickname of the player
	 * @param namePlayer <strong>String</strong> Name of the player
	 * @return stopFlag <strong>boolean</strong> Flag to know if the process was successful or not
	 * </pre>
	 */
	public boolean createPlayer(String nickname, String namePlayer) {
		boolean stopFlag = false;
		Player myPlayer = new Player(nickname, namePlayer);
		for (int i = 0; i < playersList.length; i++) {
			if (playersList[i] == null) {
				playersList[i] = myPlayer;
				return stopFlag = true;	
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
				msg += "\n[" + (i+1) + "] " + levels[i].getId();	
			}
		}
		return msg;
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
	 * @param scoreAwardedToPlayer </strong>int</strong> Score that the treasure award the player
	 * @param numTreasures </strong>int</strong> Number of treasures that will be added in the level
	 * @return stopFlag </strong>boolean</strong> Flag to know if the process was successful or not
	 * </pre>
	*/
	public boolean createTreasure(int optionLevel, String nameTreasure, String image, int scoreAwardedToPlayer, int numTreasures) {
		boolean stopFlag = false;
		for (int i = 0; i < levels.length; i++) {
			if (levels[i].getId().equals(levels[optionLevel].getId())) {
				for (int j = 0; j < numTreasures; j++) {
					stopFlag = levels[i].addTreasure(nameTreasure, image, scoreAwardedToPlayer, generatePositionX(), generatePositionY());
				}
			}
		}
		return stopFlag;
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method createTreasure allows to register an enemy to the system
	 * <strong>pre:</strong> enemiesList must be initialized
	 * <strong>pos:</strong> Enemy is register in the enemiesList
	 *@param optionLevel </strong>int</strong> Option of the level where the enemy will be added
	 *@param nameEnemy </strong>String</strong> Name of the enemy
	 *@param enemyType </strong>int</strong> Type of the enemy
	 *@param scoreSubtractedToPlayer </strong>int</strong> Score that the enemy subtract from the player
	 *@param scoreAwardedToPlayer </strong>int</strong> Score that the enemy award the player
	 *@return stopFlag </strong>boolean</strong> Flag to know if the process was successful or not
	 * </pre>
	*/
	public boolean createEnemy(int optionLevel, String nameEnemy, int enemyType, int scoreSubtractedToPlayer, int scoreAwardedToPlayer) {
		boolean stopFlag = false;
		for (int i = 0; i < levels.length; i++) {
			if (levels[i].getId().equals(levels[optionLevel].getId())) {
				return stopFlag = levels[i].addEnemy(nameEnemy, enemyType, scoreSubtractedToPlayer, scoreAwardedToPlayer, generatePositionX(), generatePositionY());
			}	
		}
		return stopFlag;	
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
				msg += "\n[" + (i + 1) + "] " + playersList[i].getNickname();	
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
				if (playersList[optionPlayer].getScore() >= levels[newLevel].getPoints()) {							
					playersList[optionPlayer].setLevel("Level " + (newLevel+1));
					return stopFlag = true;					
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
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method searchTreasure allows to check if the name of the treasure is registered in the system
	 * <strong>pre:</strong> levels must be initialized
	 * <strong>pos:</strong> Know if name of the treasure is registered
	 * @param nameTreasure <strong>String</strong> Name of the treasure
	 * @return stopFlag <strong>boolean</strong> Flag to know if the process was successful or not
	 * </pre>
	 */
	public boolean searchTreasure(String nameTreasure) {
		boolean stopFlag = false;
		for (int i = 0; i < levels.length; i++) {	
			for (int j = 0; j < levels[i].getTreasuresList().length; j++) {				
				if (levels[i].getTreasuresList()[j] != null) {				
					if (levels[i].getTreasuresList()[j].getNameTreasure().equals(nameTreasure)) {						
						return stopFlag = true;						
					}					
				}				
			}				
		}		
		return stopFlag;
	}

	/**
	 * <pre>
	 * <strong>Description:</strong> The method amountTreasureLevels allows to find the amount of a treasure in all levels
	 * <strong>pre:</strong> levels must be initialized
	 * <strong>pos:</strong> Determine the amount of a treasure in all levels
	 * @param nameTreasure </strong>String</strong> Name of the treasure from which its amount will be obtained
	 * @return numTreasuresInAllLevel </strong>int</strong> Amount of a treasure in all levels
	 * </pre>
	*/
	public int amountTreasureLevels(String nameTreasure) {
		int numTreasuresInAllLevel = 0;	
		for (int i = 0; i < levels.length; i++) {		
			numTreasuresInAllLevel += levels[i].amountTreasureLevel(nameTreasure);		
		}		
		return numTreasuresInAllLevel;		
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method searchEnemyType allows to check if there are enemies registered with that type in the system
	 * <strong>pre:</strong> levels must be initialized
	 * <strong>pos:</strong> Know if there are enemies registered with that type
	 * @param enemyType <strong>int</strong> Type of enemy from which its amount will be obtained
	 * @return stopFlag <strong>boolean</strong> Flag to know if the process was successful or not
	 * </pre>
	 */
	public boolean searchEnemyType(int enemyType) {
		boolean stopFlag = false;	
		for (int i = 0; i < levels.length; i++) {			
			for (int j = 0; j < levels[i].getEnemiesList().length; j++) {				
				if (levels[i].getEnemiesList()[j] != null) {				
					if (levels[i].getEnemiesList()[j].getEnemyType().equals(EnemyType.values()[enemyType])) {						
						return stopFlag = true;						
					}					
				}				
			}						
		}		
		return stopFlag;
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method amountEnemyLevels allows to find the amount of a type of enemy in all levels
	 * <strong>pre:</strong> levels must be initialized
	 * <strong>pos:</strong> Determine the amount of a type of enemy in all levels
	 * @param enemyType </strong>int</strong> Enemy type from which its amount will be obtained
	 * @return numTreasuresInAllLevel </strong>int</strong> Amount of a type of enemy in all levels
	 * </pre>
	*/
	public int amountEnemyLevels(int enemyType) {	
		int numEnemiesInAllLevel = 0;		
		for (int i = 0; i < levels.length; i++) {			
			numEnemiesInAllLevel += levels[i].amountEnemyLevel(enemyType);			
		}		
		return numEnemiesInAllLevel;		
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method showTreasureMostRepeated allows to find the most repeated treasure in all levels
	 * <strong>pre:</strong> levels must be initialized
	 * <strong>pos:</strong> Determine the most repeated treasure
	 * @return msg </strong>String</strong> Message with the name and the amount of the treasure most repeated
	 * </pre>
	*/
	public String showTreasureMostRepeated() {
		String[] globalTreasuresList = new String[500], globalTreasureListWithoutRepeated = new String[globalTreasuresList.length];
		String nameTreasure = "", treasureMostRepeated = "", treasureAux = "", msg = "";
		int cantTreasureMostRepeated = 0, cantTreasureAux = 0;
		int k = 0, l = 0;
		//Loop to fill arrays
		for (int i = 0; i < levels.length; i++) {	
			for (int j = 0; j < levels[i].getTreasuresList().length; j++) {
				if (levels[i].getTreasuresList()[j] != null) {					
					globalTreasuresList[k] = levels[i].getTreasuresList()[j].getNameTreasure(); //Fill array global
					nameTreasure = levels[i].getTreasuresList()[j].getNameTreasure();					
					if  (!isRepeated(globalTreasureListWithoutRepeated, nameTreasure)) {							
						globalTreasureListWithoutRepeated[l] = nameTreasure; //Fill array global without repeats
						l++;							
					}		
				}				
				k++;					
			}
		}
		//Loop to compare and determine the most repeated treasure
		for (int i = 0; i < globalTreasureListWithoutRepeated.length; i++) {		
			cantTreasureAux = 0;		
			for (int j = 0; j < globalTreasuresList.length; j++) {		
				if (globalTreasuresList[j] != null) {					
					if (globalTreasuresList[j].equals(globalTreasureListWithoutRepeated[i])) {							
						treasureAux = globalTreasureListWithoutRepeated[i];
						cantTreasureAux++;							
					}					
				}			
			}			
			if (cantTreasureAux > cantTreasureMostRepeated) {			
				treasureMostRepeated = treasureAux;
				cantTreasureMostRepeated = cantTreasureAux;			
			}	
		}
		//Message by console
		if (treasureMostRepeated != "" && cantTreasureMostRepeated != 0) {
			msg = "TREASURE MOST REPEATED:"
					+ "\nName: " + treasureMostRepeated
					+ "\nAmount: " + cantTreasureMostRepeated;
		}
		return msg;	
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method isRepeated allows to check if the element is already inside the array
	 * <strong>pre:</strong> globalTreasureListWithoutRepeated must be initialized
	 * <strong>pos:</strong> Determine if the element is already inside the array
	 * @param globalTreasureListWithoutRepeated </strong>String[]</strong> Array for save the treasures without repeated
	 * @param nameTreasure </strong>String</strong> Name of the treasure to search
	 * @return stopFlag <strong>boolean</strong> Flag to know if the process was successful or not
	 * </pre>
	*/
	private boolean isRepeated(String[] globalTreasureListWithoutRepeated, String nameTreasure) {
		boolean stopFlag = false;
		for (int i = 0; i < globalTreasureListWithoutRepeated.length; i++) {		
			if (globalTreasureListWithoutRepeated[i] != null) {		
				if (globalTreasureListWithoutRepeated[i].equals(nameTreasure)) {				
					return stopFlag = true;				
				}				
			}			
		}		
		return stopFlag;		
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method showEnemyWithHighestScore allows to find the enemy that award the highest score
	 * <strong>pre:</strong> levels must be initialized
	 * <strong>pos:</strong> Determine the enemy that award the highest score
	 * @return msg </strong>String</strong> Message with the name, level and score of the enemy that award the highest score
	 * </pre>
	*/
	public String showEnemyWithHighestScore() {
		int[] globalScoreAwardedToPlayerByEnemy = new int [250];
		String msg = "";
		int k = 0;
		//Loop to fill array
		for (int i = 0; i < levels.length; i++) {	
			for (int j = 0; j < levels[i].getEnemiesList().length; j++) {
				if (levels[i].getEnemiesList()[j] != null) {					
					globalScoreAwardedToPlayerByEnemy[k] = levels[i].getEnemiesList()[j].getScoreAwardedToPlayer(); //Fill array global
					k++;
				}									
			}						
		}
		//Bubble sort from largest to smallest
		bubbleSort(globalScoreAwardedToPlayerByEnemy); 
		//Loop to compare and determine the enemy with the highest score
		for (int i = 0; i < levels.length; i++) {		
			for (int j = 0; j < levels[i].getEnemiesList().length; j++) {		
				if (levels[i].getEnemiesList()[j] != null) {
					if (levels[i].getEnemiesList()[j].getScoreAwardedToPlayer() == globalScoreAwardedToPlayerByEnemy[0]) {
						return msg = "ENEMY WITH HIGHEST SCORE: "
								+ "\nName: " + levels[i].getEnemiesList()[0].getNameEnemy()
								+ "\nLevel: " + levels[i].getId()
								+ "\nScore: " + levels[i].getEnemiesList()[0].getScoreAwardedToPlayer();
					}				
				}			
			}		
		}
		return msg;		
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method bubbleSort allows to sort the array descending
	 * <strong>pre:</strong> array must be initialized
	 * <strong>pos:</strong> Sort the array descending
	 * @param array </strong>int[]</strong> Array to sort
	 * </pre>
	*/
    private void bubbleSort (int[] array) {
        for (int i = 0; i < array.length; i++) {      	
            for (int j = 0; j < array.length - 1; j++) {           	
                int currentItem = array[j],
                	nextItem = array[j + 1];             
                if (currentItem < nextItem) {
                	array[j] = nextItem;
                	array[j + 1] = currentItem;                
                }                
            }            
        }       
    }
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method countConsonant allows to count the number of consonants found in the names of enemies
	 * <strong>pre:</strong> levels must be initialized
	 * <strong>pos:</strong> Determine the number of consonants found in the names of enemies
	 * @return countConsonant </strong>int</strong> Amount of consonants found
	 * </pre>
	*/
	public int countConsonant() {
		int countConsonant = 0;	
		for (int i = 0; i < levels.length; i++) {
			for (int j = 0; j < levels[i].getEnemiesList().length; j++) {				
				if (levels[i].getEnemiesList()[j] != null) {					
					String nameEnemy = levels[i].getEnemiesList()[j].getNameEnemy();		
					for (int k = 0; k < nameEnemy.length(); k++) {						
						char letter = nameEnemy.charAt(k);						
						if (isConsonant(letter)) {							
							countConsonant++;							
						}						
					}				
				}				
			}		
		}		
		return countConsonant;		
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method isConsonant allows to determine if the letter is a consonant or not
	 * <strong>pre:</strong> NA
	 * <strong>pos:</strong> Determine if the letter is a consonant or not
	 * @param letter </strong>char</strong> Enemy name letter
	 * @return  </strong>boolean</strong> If is or no consonant
	 * </pre>
	*/
	private boolean isConsonant(char letter) {	
		return "bcdfghjklmnñpqrstvwxyz".contains(String.valueOf(letter).toLowerCase());	
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method showTopFive allows to show the top 5 of the players according to the score
	 * <strong>pre:</strong> levels must be initialized
	 * <strong>pos:</strong> Determine the show the top 5 of the players according to the score
	 * @return msg </strong>String</strong> Message with the nickname and score of the players of the top
	 * </pre>
	*/
	public String showTopFive() {
		int[] playersGlobalScore = new int[20], playersGlobalScoreWithoutRepeated = new int[playersGlobalScore.length];
		int count = 0, scoreAux = 0, k = 0, top = 0;
		String msg = "";
		//Loop to fill array
		for (int i = 0; i < playersList.length; i++) {
			if (playersList[i] != null) {		
				playersGlobalScore[i] = playersList[i].getScore(); //Fill array global	
			}
		}
		//Bubble sort from largest to smallest
		bubbleSort(playersGlobalScore);
		//Loop to remove duplicate elements
		for (int i = 0; i < playersGlobalScore.length; i++) {
			scoreAux = playersGlobalScore[i];		
			if  (!isRepeated(playersGlobalScoreWithoutRepeated, scoreAux)) {			
				playersGlobalScoreWithoutRepeated[k] = scoreAux;
				k++;			
			}
		}
		//Loop to compare and determine the podium
		for (int i = 0; i < playersGlobalScoreWithoutRepeated.length; i++) {	
			for (int j = 0; j < playersList.length; j++) {		
				if (playersList[j] != null && count < 5) {								
					if (playersList[j].getScore() == playersGlobalScoreWithoutRepeated[i]) {											
						msg += "\n" + (top+1) + ". " + playersList[j].getNickname() + "          " + playersList[j].getScore();
						count++;
						top++;					
					}							
				}						
			}			
		}			
		return msg;		
	}
    
	/**
	 * <pre>
	 * <strong>Description:</strong> The method isRepeated allows to check if the element is already inside the array
	 * <strong>pre:</strong> playersGlobalScoreWithoutRepeated must be initialized
	 * <strong>pos:</strong> Determine if the element is already inside the array
	 * @param playersGlobalScoreWithoutRepeated </strong>int[]</strong> Array for save the scores without repeated
	 * @param scoreAux </strong>int</strong> Score to search
	 * @return stopFlag <strong>boolean</strong> Flag to know if the process was successful or not
	 * </pre>
	*/
    private boolean isRepeated(int[] playersGlobalScoreWithoutRepeated, int scoreAux) {
		boolean stopFlag = false;
		for (int i = 0; i < playersGlobalScoreWithoutRepeated.length; i++) {	
			if (playersGlobalScoreWithoutRepeated[i] == scoreAux) {		
				return stopFlag = true;		
			}
		}
		return stopFlag;		
	}
    
}