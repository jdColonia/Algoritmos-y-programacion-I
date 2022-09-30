package model;

public class VideogameController{

	private Player[] playerList;
	
	
	public VideogameController() {
		
		this.playerList = new Player[20];
		
	}
	
	public Player[] getPlayerList() {
		return playerList;
	}

	public void setPlayerList(Player[] playerList) {
		this.playerList = playerList;
	}

	/**
	 *Description: The method verifyNickname allows to check if the nickname is in the system
	 *pre: playerList must be initialized
	 *pos: Know if nickname to register is not registered for another player
	 *@param nickname	String Nickname of the player
	 *@return stopFlag boolean Flag to know if the process was successful or not
	*/
	public boolean verifyNickname (String nickname) {
		
		boolean stopFlag = true;
		
		for (int i = 0; i < playerList.length; i++) {
			
			if (playerList[i] != null) {
				
				if (nickname.equals(playerList[i].getNickname())) {
					
					stopFlag = false;
					
				}
				
			}

		}
		
		return stopFlag;
		
	}
	
	
	/**
	 *Description: The method createPlayer allow to register one player to the system
	 *pre: playerList must be initialized
	 *pos: Player is register in the playerList
	 *@param nickname	String Nickname of the player
	 *@param namePlayer String Name of the player
	 *@return stopFlag boolean Flag to know if the process was successful or not
	*/
	public boolean createPlayer(String nickname, String namePlayer) {
		
		Player myPlayer = new Player(nickname, namePlayer);
		
		boolean stopFlag = false;
		
		for (int i = 0; i < playerList.length; i++) {
			
			if (playerList[i] == null) {
				
				//myPlayer.setLevel("");
				myPlayer.setScore(10);
				myPlayer.setNumberLives(5);
				playerList[i] = myPlayer;
				stopFlag = true;
				
			}

		}

		return stopFlag;
		
	}
	



}