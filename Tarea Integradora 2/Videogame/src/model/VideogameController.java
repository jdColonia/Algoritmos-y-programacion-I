package model;

import  java.util.Random;

public class VideogameController{
	
	public static Random random = new Random();
	private Player[] playersList;
	private Level[] levels;
	private Treasure[] treasuresList; //Arrays for register treasure in the system
	private Enemy[] enemiesList; //Array for register enemy in the system
	
	public VideogameController() {
		this.playersList = new Player[20];
		this.levels = new Level[10];
		this.treasuresList = new Treasure[50];
		this.enemiesList = new Enemy[25];
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
				
				id = "Nivel " + (i + 1);
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
				
				//myPlayer.setLevel("");
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
	 *Description: The method createTreasure allow to register one treasure to the system
	 *pre: treasureList must be initialized
	 *pos: Treasure is register in the treasureList
	 *@param nameTreasure	String	Name of the treasure
	 *@param image	String	Image of the treasure 
	 *@param scoreAwardedToPlayer	int Score that the enemy award from the player
	 *@param positionX	int	Position in X of the treasure
	 *@param positionY	int	Position in Y of the treasure
	 *@return stopFlag	boolean	Flag to know if the process was successful or not
	*/
	public boolean createTreasure(String nameTreasure, String image, int scoreAwardedToPlayer) {
		
		Treasure myTreasure = new Treasure(nameTreasure, image, scoreAwardedToPlayer);
		
		boolean stopFlag = false;
		
		for (int i = 0; i < treasuresList.length; i++) {
			
			if (treasuresList[i] == null) {
				
				treasuresList[i] = myTreasure;
				return stopFlag = true;
				
			}

		}

		return stopFlag;
	}
	
	
	//NO SE COMO HACER EL CONTRATO
	public String getEnemyType() {
		
		String msg = "";
		
		EnemyType[] enemyType = EnemyType.values();
		
		for (int i = 0; i < enemyType.length; i++) {
			
			msg += "[" + (i+1) + "]" + enemyType[i] + "\n";
			
		}
		
		return msg;
		
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
	 *Description: The method createTreasure allow to register one treasure to the system
	 *pre: enemiesList must be initialized
	 *pos: Enemy is register in the enemiesList
	 *@param nameEnemy	String	Name of the enemy
	 *@param scoreAwardedToPlayer int Score that the enemy award from the player
	 *@param scoreSubtractedToPlayer	int	Score that the enemy subtract from the player
	 *@param positionX int Position in X of the enemy
	 *@param positionY int Position in Y of the enemy
	 *@return stopFlag boolean Flag to know if the process was successful or not
	*/
	public boolean createEnemy(String nameEnemy, int enemyType, int scoreSubtractedToPlayer, int scoreAwardedToPlayer) {
		
		Enemy myEnemy = new Enemy(nameEnemy, enemyType, scoreSubtractedToPlayer, scoreAwardedToPlayer);
		
		boolean stopFlag = false;
		
		for (int i = 0; i < enemiesList.length; i++) {
			
			if (enemiesList[i] == null) {
				
				enemiesList[i] = myEnemy;
				return stopFlag = true;
				
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
	 *Description: The method showTreasuresList allow show the list of treasures registered in the system
	 *pre: treasuresList must be initialized
	 *pos: Show list of treasures
	 *@return msg	String	Message with list of treasures (only name of the treasure)
	*/
	public String showTreasuresList() {

		String msg = "";

		for (int i = 0; i < treasuresList.length; i++) {

			if (treasuresList[i] != null) {

				msg += "\n[" + (i+1) + "]" + treasuresList[i].getNameTreasure();
				
			}
			
		}

		return msg;

	}
	
	
	/**
	 *Description: The method showEnemiesList allow show the list of enemies registered in the system
	 *pre: enemiesList must be initialized
	 *pos: Show list of enemies
	 *@return msg	String	Message with list of enemies (only name of the enemy)
	*/
	public String showEnemiesList() {

		String msg = "";

		for (int i = 0; i < enemiesList.length; i++) {

			if (enemiesList[i] != null) {

				msg += "\n[" + (i+1) + "]" + enemiesList[i].getNameEnemy();
				
			}
			
		}

		return msg;

	} 
	
	/**
	 * 
	 * @param optionTeam
	 * @param optionPokemon
	 * @return
	 */
	public boolean addTreasureToLevel (int optionLevel, int optionTreasure) {
		
		return levels[(optionLevel)].addTreasure(treasuresList[(optionTreasure)]);

	}
	
	



}