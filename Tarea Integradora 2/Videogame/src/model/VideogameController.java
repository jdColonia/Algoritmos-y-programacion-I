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

	
	/**
	 *Description: The method createLevel allows to add the id and the points to the level
	 *pre: levels must be initialized
	 *pos: The id and points are added to each level
	*/
	public void createLevel() {
		
		for (int i = 0; i < levels.length; i++) {
			
			Level myLevel = new Level ();
			
			String id = "";
			int points = 0;
			
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
	 *Description: The method verifyNickname allows to check if the nickname is in the system
	 *pre: playerList must be initialized
	 *pos: Know if nickname to register is not registered for another player
	 *@param nickname	String	Nickname of the player
	 *@return stopFlag	boolean	Flag to know if the process was successful or not
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
	 *Description: The method createPlayer allow to register one player to the system
	 *pre: playerList must be initialized
	 *pos: Player is register in the playerList
	 *@param nickname	String	Nickname of the player
	 *@param namePlayer	String	Name of the player
	 *@return stopFlag	boolean	Flag to know if the process was successful or not
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
	 *Description: The method generatePositionX allow to register one player to the system
	 *pre: random must be initialized
	 *pos: positionX is automatically generated
	 *@return positionX	int	Random position of a treasure or enemy
	*/
	public int generatePositionX() {
		
		int positionX = random.nextInt(1281);
		
		return positionX;
	}
	
	
	/**
	 *Description: The method generatePositionY allow to register one player to the system
	 *pre: random must be initialized
	 *pos: positionY is automatically generated
	 *@return positionY	int	Random position of a treasure or enemy
	*/
	public int generatePositionY() {
		
		int positionY = random.nextInt(721);
		
		return positionY;
	}
	
	
	/**
	 *Description: The method createTreasure allow to register treasures to a level
	 *pre: levels must be initialized
	 *pos: Treasure is registered in a level
	 *@param optionLevel	int	Option of the level where the treasure will be added
	 *@param nameTreasure	String	Name of the treasure
	 *@param image	String	Image of the treasure 
	 *@param scoreAwardedToPlayer	int	Score that the treasure award from the player
	 *@param numTreasures	int	Number of treasures that will be added in the level
	 *@return stopFlag	boolean	Flag to know if the process was successful or not
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
	
	
	public String getEnemyType() {
		
		String msg = "";
		
		EnemyType[] enemyType = EnemyType.values();
		
		for (int i = 0; i < enemyType.length; i++) {
			
			msg += "[" + (i+1) + "]" + enemyType[i] + "\n";
			
		}
		
		return msg;
		
	}
	
	
	/**
	 *Description: The method createTreasure allow to register one treasure to the system
	 *pre: enemiesList must be initialized
	 *pos: Enemy is register in the enemiesList
	 *@param optionLevel	int	Option of the level where the enemy will be added
	 *@param nameEnemy	String	Name of the enemy
	 *@param enemyType	int	Type of the enemy
	 *@param scoreSubtractedToPlayer	int	Score that the enemy subtract from the player
	 *@param scoreAwardedToPlayer	int	Score that the enemy award from the player
	 *@return stopFlag boolean Flag to know if the process was successful or not
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
	 *Description: The method showLevels allow show the list of levels of the system
	 *pre: levels must be initialized
	 *pos: Show list of levels
	 *@return msg	String	Message with list of levels (only id)
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
	 *Description: The method showPlayerList allow show the list of players registered in the system
	 *pre: playersList must be initialized
	 *pos: Show list of players
	 *@return msg	String	Message with list of players (only nickname)
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
	 *Description: The method modifyScorePlayer allow to modify a player's score
	 *pre: playersList must be initialized
	 *pos: Score of a player changed
	 *@param optionPlayer	int	Option of the player whose score will be changed
	 *@param newScore	int	New score of the player
	 *@return stopFlag	boolean	Flag to know if the process was successful or not
	*/
	public boolean modifyScorePlayer(int optionPlayer, int newScore) {
		
		boolean stopFlag = false;
		
		for (int i = 0; i < playersList.length; i++) {
			
			if (playersList[i] != null) {
				
				if (playersList[i].getNickname().equals(playersList[optionPlayer].getNickname())) {
					
					playersList[optionPlayer].setScore(newScore);
					return stopFlag = true;
				}
			
			}
			
		}
		
		return stopFlag;
		
	}



}