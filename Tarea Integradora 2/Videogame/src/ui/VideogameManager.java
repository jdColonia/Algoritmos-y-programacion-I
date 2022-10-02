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
					+ "\n[2] Create treasure"
					+ "\n[3] Create enemy"
					+ "\n[4] "
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
				addTreasureToLevel();
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
	 *Input:  nickname	String	Nickname of the player to register
	 *Input: namePlayer	String	Name of the player to register
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
	 *Description: The method createTreasure allow to register one treasure to the system
	 *pre: controller must be initialized
	 *pos: No aplica
	 *Input: nameTreasure	String	Name of the treasure to register
	 *Input: image	String	Image of the treasure 
	 *Input: scoreAwardedToPlayer	int	Score that the treasure award from the player
	*/
	public static void createTreasure() {
		
		System.out.print("Type the name of the new treasure: ");
		sc.nextLine();
		String nameTreasure = sc.nextLine();
		
		System.out.print("Type the adress of the image of the new treasure: ");
		String image = sc.nextLine();
		
		System.out.print("Type the score that award to player the new treasure: ");
		int scoreAwardedToPlayer = sc.nextInt();
				
		if (controller.createTreasure(nameTreasure, image, scoreAwardedToPlayer)) {
			
				System.out.println("Treasure successfully registered");

		} else {
			
			System.out.println("Error, treasure registration failed");
			
		}
		
	}
	
	
	/**
	 *Description: The method createEnemy allow to register one enemy to the system
	 *pre: controller must be initialized
	 *pos: No aplica
	 *Input: nameEnemy	String	Name of the enemy to register
	 *Input: 
	 *Input: scoreSubtractedToPlayer	int	Score that the enemy subtract from the player
	 *Input: scoreAwardedToPlayer	int	Score that the enemy award from the player
	*/
	public static void createEnemy() {
		
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
		
		if (controller.verifyEnemy(nameEnemy)) {
			
			if (controller.createEnemy(nameEnemy, enemyType, scoreSubtractedToPlayer, scoreAwardedToPlayer)) {
			
				System.out.println("Enemy successfully registered");
			
			}

		} else {
			
			System.out.println("Error, enemy registration failed");
			
		}
		
	}
	
	
	/**FALTA
	 *Description: The method addTreasureToLevel allow to register one enemy to the system
	 *pre: controller must be initialized
	 *pos: No aplica
	 *Input: nameEnemy	String	Name of the enemy to register
	 *Input: 
	 *Input: scoreSubtractedToPlayer	int	Score that the enemy subtract from the player
	 *Input: scoreAwardedToPlayer	int	Score that the enemy award from the player
	*/
	public static void addTreasureToLevel() {
		
		String levelsList = controller.showLevels();
		
		System.out.println("These are the levels currently registered:" + levelsList);
		System.out.print("Type the ID of the level you want to register a Treasure: ");
		int optionLevel = sc.nextInt();
		
		String treasuresList = controller.showTreasuresList();
		
		System.out.println("These are the treasures currently registered:" + treasuresList);
		System.out.print("Type the Name of the Treasure: ");
		int optionTreasure = sc.nextInt();
		
		System.out.print("Type the the number of treasure that will register in the level: ");
		int numTreasure = sc.nextInt();
		
		for (int i = 0; i < numTreasure; i++) {
			
			if (controller.addTreasureToLevel((optionLevel-1), (optionTreasure-1))) {
				
				System.out.println("Successfully added treasure to level");

			} else {
				
				System.out.println("Error, it was not possible to add the treasure to the level");
				
			}
		}
		
		
	}
}