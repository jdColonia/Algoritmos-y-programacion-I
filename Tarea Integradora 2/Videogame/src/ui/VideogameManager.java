package ui;

import java.util.Scanner;

import model.VideogameController;

public class VideogameManager{
	
	public static Scanner sc = new Scanner(System.in);
	public static VideogameController controller = new VideogameController();

	public static void main(String[] args) {
		
		controller.createLevel();
		showMainMenu();

	}
	
	public static void showMainMenu() {
		
		System.out.println("Welcome to Videogame");
		
		boolean stopFlag = false;
		
		while (!stopFlag) {
			
			System.out.println("\nSelect an option"
					+ "\n[1] Create player "
					+ "\n[2] Register treasure to a level"
					+ "\n[3] Register enemy to a level "
					+ "\n[4] Modify score of a player"
					+ "\n[0] Exit");
			
			int mainOption = sc.nextInt();
			
			switch (mainOption) {
			
			case 1:
				createPlayer();
				break;
			case 2:
				createTreasure();
				break;
			case 3:
				createEnemy();
				break;
			case 4:
				modifyScorePlayer();
				break;
			case 0:
				stopFlag = true;
				System.out.println("Thanks for using our system");
			default:
				System.out.println("You must type a valid option");
				break;
			}
		
		}
		
	}
	
	
	/**
	 *Description: The method createPlayer allow to register one player to the system
	 *pre: controller must be initialized
	 *pos: No aplica
	 *Input:  nickname	String	Nickname of the player
	 *Input: namePlayer	String	Name of the player
	*/
	public static void createPlayer() {
		
		System.out.print("Type the nickname of the new player: ");
		sc.nextLine();
		String nickname = sc.nextLine();
		
		System.out.print("Type the name of the new player: ");
		String namePlayer = sc.nextLine();
		
		if (controller.verifyNickname(nickname)) {
			
			if (controller.createPlayer(nickname, namePlayer)) {
			
				System.out.println("Player successfully registered");
			
			}

		} else {
			
			System.out.println("Error, player registration failed");
			
		}
		
	}
	
	
	/**
	 *Description: The method createTreasure allow to register treasures to a level
	 *pre: controller must be initialized
	 *pos: No aplica
	 *Input: optionLevel	int	Option of the level where the treasure will be added
	 *Input: nameTreasure	String	Name of the treasure
	 *Input: image	String	Image of the treasure 
	 *Input: scoreAwardedToPlayer	int	Score that the treasure award from the player
	 *Input: numTreasures	int	Number of treasures that will be added in the level
	*/
	public static void createTreasure() {
		
		String levelsList = controller.showLevels();
		
		System.out.println("These are the levels currently registered:" + levelsList);
		System.out.print("Type the ID of the level you want to register a Treasure: ");
		int optionLevel = sc.nextInt();
		
		System.out.println("Type the following information to register a treasure at a level");
		
		System.out.print("Type the name of the new treasure: ");
		sc.nextLine();
		String nameTreasure = sc.nextLine();
		
		System.out.print("Type the adress of the image of the new treasure: ");
		String image = sc.nextLine();
		
		System.out.print("Type the score that award to player the new treasure: ");
		int scoreAwardedToPlayer = sc.nextInt();
		
		System.out.print("Type the the number of treasure that will register in the level: ");
		int numTreasures = sc.nextInt();
				
		if (controller.createTreasure((optionLevel-1), nameTreasure, image, scoreAwardedToPlayer, numTreasures)) {
			
			System.out.println("Treasure successfully registered");

		} else {
			
			System.out.println("Error, treasure registration failed");
			
		}
		
	}
	
	
	/**
	 *Description: The method createEnemy allow to register one enemy to a level
	 *pre: controller must be initialized
	 *pos: No aplica
	 *Input: optionLevel	int	Option of the level where the enemy will be added
	 *Input: nameEnemy	String	Name of the enemy
	 *Input: enemyType	int	Type of the enemy
	 *Input: scoreSubtractedToPlayer	int	Score that the enemy subtract from the player
	 *Input: scoreAwardedToPlayer	int	Score that the enemy award from the player
	*/
	public static void createEnemy() {
		
		String levelsList = controller.showLevels();
		
		System.out.println("These are the levels currently registered:" + levelsList);
		System.out.print("Type the ID of the level you want to register a Enemy: ");
		int optionLevel = sc.nextInt();
		
		System.out.print("Type the name of the new enemy: ");
		sc.nextLine();
		String nameEnemy = sc.nextLine();
		
		System.out.println("Type the type of the enemy");
		System.out.print(controller.getEnemyType());
		int enemyType = (sc.nextInt()-1);
		
		System.out.print("Type the score that subtract to player the new enemy: ");
		int scoreSubtractedToPlayer = sc.nextInt();
		
		System.out.print("Type the score that award to player the new enemy: ");
		int scoreAwardedToPlayer = sc.nextInt();
			
		if (controller.createEnemy((optionLevel-1), nameEnemy, enemyType, scoreSubtractedToPlayer, scoreAwardedToPlayer)) {
			
			System.out.println("Enemy successfully registered");

		} else {
			
			System.out.println("Error, enemy registration failed");
			
		}
		
	}
	
	
	/**
	 *Description: The method modifyScorePlayer allow to modify a player's score
	 *pre: controller must be initialized
	 *pos: No aplica
	 *Input: optionPlayer	int	Option of the player whose score will be changed
	 *Input: newScore	int	New score of the player
	*/
	public static void modifyScorePlayer() {
		
		String playersList = controller.showPlayersList();
		
		if (playersList.equals("")) {
			
			System.out.println("There aren't any Players registered.");
			
		} else {
		
			System.out.println("These are the players currently registered:" + playersList);
			System.out.print("Type the Nickname of the player whose points you want to modify: ");
			int optionPlayer = sc.nextInt();
			
			System.out.print("Type the new score of the player: ");
			int newScore = sc.nextInt();
			
			if (controller.modifyScorePlayer((optionPlayer-1), newScore)) {
				
				System.out.println("Change was made successfully");
	
			} else {
				
				System.out.println("Error, change failed");
				
			}
		
		}
		
	}
	

}