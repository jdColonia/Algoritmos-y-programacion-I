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
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method showMainMenu allows to show the main menu of the system
	 * <strong>pre:</strong> NA
	 * <strong>pos:</strong> NA
	 * <strong>Inputs:</strong> mainOption <strong>int</strong> Option selected by user
	 * <strong>Outputs:</strong> Message by console
	 * </pre>
	 */
	public static void showMainMenu() {
		System.out.println("WELCOME TO VIDEOGAME");
		boolean stopFlag = false;
		while (!stopFlag) {
			System.out.println("\nMain menu:"
					+ "\n[1] Create player "
					+ "\n[2] Register treasure to a level"
					+ "\n[3] Register enemy to a level "
					+ "\n[4] Modify a player's score"
					+ "\n[5] Modify a player's level"
					+ "\n[6] Show the treasures and enemies of a level"
					+ "\n[7] Show the amount of a treasure in all levels"
					+ "\n[8] Show the amount of an enemy type in all levels"
					+ "\n[9] Show the most repeated treasure in all levels"
					+ "\n[10] Show enemy with the highest score"
					+ "\n[11] Show number of consonants in enemy names"
					+ "\n[12] Show podium"
					+ "\n[0] Exit");
			System.out.print("Option: ");
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
			case 5:
				modifyLevelPlayer();
				break;
			case 6:
				showTreasuresAndEnemies();
				break;
			case 7:
				showAmountTreasure();
				break;
			case 8:
				showAmountEnemy();
				break;
			case 9:
				showTreasureMostRepeated();	
				break;
			case 10:
				showEnemyWithHighestScore();
				break;
			case 11:
				showAmountConsonant();
				break;
			case 12:
				showTopFive();
				break;
			case 0:
				stopFlag = true;
				System.out.println("Thanks for using our system");
				break;
			default:
				System.out.println("You must type a valid option");
				break;
			}
		}		
	}

	/**
	 * <pre>
	 * <strong>Description:</strong> The method createPlayer allows to register one player to the system
	 * <strong>pre:</strong> controller must be initialized
	 * <strong>pos:</strong> NA
	 * <strong>Inputs:</strong> nickname <strong>String</strong> Nickname of the player
	 * <strong>Inputs:</strong> namePlayer <strong>String</strong> Name of the player
	 * <strong>Outputs:</strong> Message by console
	 * </pre>
	 */
	public static void createPlayer() {
		System.out.print("Type the nickname: ");
		sc.nextLine();
		String nickname = sc.nextLine();
		System.out.print("Type the name: ");
		String namePlayer = sc.nextLine();
		if (controller.verifyNickname(nickname)) {
			System.out.println("Error, player registration failed");
		} else {
			if (controller.createPlayer(nickname, namePlayer)) {
				System.out.println("Player successfully registered");
			}
		}
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method createTreasure allows to register treasures to a level
	 * <strong>pre:</strong> controller must be initialized
	 * <strong>pos:</strong> NA
	 * <strong>Inputs:</strong> optionLevel <strong>int</strong> Level where the treasure will be added
	 * <strong>Inputs:</strong> nameTreasure <strong>String</strong> Name of the treasure
	 * <strong>Inputs:</strong> image <strong>String</strong> Image of the treasure
	 * <strong>Inputs:</strong> scoreAwardedToPlayer <strong>int</strong> Score that the treasure award from the player
	 * <strong>Inputs:</strong> numTreasures <strong>int</strong> Number of treasures that will be added in the level
	 * <strong>Outputs:</strong> Message by console
	 * </pre>
	 */
	public static void createTreasure() {
		System.out.println("These are the levels currently registered:" + controller.showLevels());
		System.out.print("Type the ID of the level you want to register a Treasure: ");
		int optionLevel = (sc.nextInt()-1);
		System.out.println("Type the following information to register treasures at a level");
		System.out.print("Type the name: ");
		sc.nextLine();
		String nameTreasure = sc.nextLine();
		System.out.print("Type the adress of the image: ");
		String image = sc.nextLine();
		System.out.print("Type the score that award the player: ");
		int scoreAwardedToPlayer = sc.nextInt();
		System.out.print("Type the the number of treasure that will register in the level: ");
		int numTreasures = sc.nextInt();	
		if (controller.createTreasure(optionLevel, nameTreasure, image, scoreAwardedToPlayer, numTreasures)) {
			System.out.println("Treasure successfully registered");
		} else {
			System.out.println("Error, treasure registration failed");
		}
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method createEnemy allows to register an enemy to a level
	 * <strong>pre:</strong> controller must be initialized
	 * <strong>pos:</strong> NA
	 * <strong>Inputs:</strong> optionLevel <strong>int</strong> Level where the enemy will be added
	 * <strong>Inputs:</strong> nameEnemy <strong>String</strong> Name of the enemy
	 * <strong>Inputs:</strong> enemyType <strong>int</strong> Type of the enemy
	 * <strong>Inputs:</strong> scoreSubtractedToPlayer <strong>int</strong> Score that the enemy subtract from the player
	 * <strong>Inputs:</strong> scoreAwardedToPlayer <strong>int</strong> Score that the enemy award from the player
	 * <strong>Outputs:</strong> Message by console
	 * </pre>
	 */
	public static void createEnemy() {
		System.out.println("These are the levels currently registered:" + controller.showLevels());
		System.out.print("Type the ID of the level you want to register a Enemy: ");
		int optionLevel = (sc.nextInt()-1);
		System.out.print("Type the name: ");
		sc.nextLine();
		String nameEnemy = sc.nextLine();
		System.out.println("These are the possible types of enemies:" + controller.getEnemyType());
		System.out.println("Type the type of the enemy: ");
		int enemyType = (sc.nextInt()-1);
		System.out.print("Type the score that subtract from the player: ");
		int scoreSubtractedToPlayer = sc.nextInt();
		System.out.print("Type the score that award the player: ");
		int scoreAwardedToPlayer = sc.nextInt();
		if (controller.createEnemy(optionLevel, nameEnemy, enemyType, scoreSubtractedToPlayer, scoreAwardedToPlayer)) {
			System.out.println("Enemy successfully registered");
		} else {	
			System.out.println("Error, enemy registration failed");	
		}
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method modifyScorePlayer allows to modify a player's score
	 * <strong>pre:</strong> controller must be initialized
	 * <strong>pos:</strong> NA
	 * <strong>Inputs:</strong> optionPlayer <strong>int</strong> Player whose score will be changed
	 * <strong>Inputs:</strong> newScore <strong>int</strong> New score of the player
	 * <strong>Outputs:</strong> Message by console
	 * </pre>
	 */
	public static void modifyScorePlayer() {
		if (controller.showPlayersList().equals("")) {
			System.out.println("Error, there aren't any Players registered.");
		} else {
			System.out.println("These are the players currently registered:" + controller.showPlayersList());
			System.out.print("Type the nickname of the player whose points you want to modify: ");
			int optionPlayer = (sc.nextInt()-1);
			System.out.print("Type the new score of the player: ");
			int newScore = sc.nextInt();
			if (controller.modifyScorePlayer(optionPlayer, newScore)) {
				System.out.println("Change was made successfully");
			} else {
				System.out.println("Error, change failed");
			}
		}
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method modifyLevelPlayer allows to modify a player's level
	 * <strong>pre:</strong> controller must be initialized
	 * <strong>pos:</strong> NA
	 * <strong>Inputs:</strong> optionPlayer <strong>int</strong> Player whose level will be changed
	 * <strong>Inputs:</strong> newLevel <strong>int</strong> New level of the player
	 * <strong>Outputs:</strong> Message by console
	 * </pre>
	 */
	public static void modifyLevelPlayer() {
		if (controller.showPlayersList().equals("")) {	
			System.out.println("Error, there aren't any Players registered.");	
		} else {
			System.out.println("These are the players currently registered:" + controller.showPlayersList());
			System.out.print("Type the nickname of the player whose level you want to modify: ");
			int optionPlayer = (sc.nextInt()-1);
			System.out.println("These are the levels currently registered:" + controller.showLevels());
			System.out.print("Type the ID of the level you want to raise the player to: ");
			int newLevel = (sc.nextInt()-1);
			if (controller.modifyLevelPlayer(optionPlayer, newLevel)) {	
				System.out.println("Change was made successfully");
			} else {
				System.out.println("Error, change failed. " + "The score required to advance to the next level is: " + controller.scoreRequiredToPassLevel(optionPlayer,newLevel)  + " points");	
			}
		}	
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method showTreasuresAndEnemies allows to show a list of registered treasures and enemies in a level
	 * <strong>pre:</strong> controller must be initialized
	 * <strong>pos:</strong> NA
	 * <strong>Inputs:</strong> optionLevel <strong>int</strong> Level from which the list is obtained
	 * <strong>Outputs:</strong> Message by console
	 * </pre>
	 */
	public static void showTreasuresAndEnemies() {
		System.out.println("These are the levels currently registered:" + controller.showLevels());
		System.out.print("Type the ID of the level in which you want to see the registered treasures and enemies: ");
		int optionLevel = (sc.nextInt()-1);
		System.out.println(controller.showTreasuresAndEnemies(optionLevel));
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method showAmountTreasure allows to show the amount of a treasure in all levels
	 * <strong>pre:</strong> controller must be initialized
	 * <strong>pos:</strong> NA
	 * <strong>Inputs:</strong> nameTreasure <strong>String</strong> Name of the treasure from which its amount will be obtained
	 * <strong>Outputs:</strong> Message by console
	 * </pre>
	 */
	public static void showAmountTreasure() {
		System.out.print("Type the name of the treasure: ");
		sc.nextLine();
		String nameTreasure = sc.nextLine();
		if (controller.searchTreasure(nameTreasure)) {	
			System.out.println("The amount of " + nameTreasure + " is: " + controller.amountTreasureLevels(nameTreasure));		
		} else {	
			System.out.println("Error, there aren't any treasures registered.");		
		}	
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method showAmountEnemy allows to show the amount of a type of enemy in all levels
	 * <strong>pre:</strong> controller must be initialized
	 * <strong>pos:</strong> NA
	 * <strong>Inputs:</strong> enemyType <strong>int</strong> Type of enemy from which its amount will be obtained
	 * <strong>Outputs:</strong> Message by console
	 * </pre>
	 */
	public static void showAmountEnemy() {
		System.out.println("These are the types of enemies:" + controller.getEnemyType());
		System.out.println("Type the type of the enemy: ");
		int enemyType = (sc.nextInt()-1);	
		if (controller.searchEnemyType(enemyType)) {			
			System.out.println("The amount of ese tipo de enemigo is: " + controller.amountEnemyLevels(enemyType));						
		} else {			
			System.out.println("Error, there aren't any enemies registered");			
		}		
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method showTreasureMostRepeated allows to show the most repeated treasure in all levels
	 * <strong>pre:</strong> controller must be initialized
	 * <strong>pos:</strong> NA
	 * <strong>Outputs:</strong> Message by console
	 * </pre>
	 */
	public static void showTreasureMostRepeated() {
		if (controller.showTreasureMostRepeated().equals("")) {
			System.out.println("Error, there aren't any treasures registered.");	
		} else {
			System.out.println(controller.showTreasureMostRepeated());
		}	
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method showEnemyWithHighestScore allows to show the enemy that award the highest score
	 * <strong>pre:</strong> controller must be initialized
	 * <strong>pos:</strong> NA
	 * <strong>Outputs:</strong> Message by console
	 * </pre>
	 */
	public static void showEnemyWithHighestScore() {
		if (controller.showEnemyWithHighestScore().equals("")) {
			System.out.println("Error, there aren't any enemies registered.");	
		} else {
			System.out.println(controller.showEnemyWithHighestScore());
		}		
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method showAmountConsonant allows to show the number of consonants found in the names of enemies
	 * <strong>pre:</strong> controller must be initialized
	 * <strong>pos:</strong> NA
	 * <strong>Outputs:</strong> Message by console
	 * </pre>
	 */
	public static void showAmountConsonant() {
		if (controller.countConsonant() == 0) {
			System.out.println("Error, there aren't any enemies registered.");	
		} else {
			System.out.println("The number of consonants is: " + controller.countConsonant());
		}	
		
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method showTopFive allows to show the top 5 of the players according to the score
	 * <strong>pre:</strong> controller must be initialized
	 * <strong>pos:</strong> NA
	 * <strong>Outputs:</strong> Message by console
	 * </pre>
	 */
	public static void showTopFive() {
		if (controller.showTopFive().equals("")) {
			System.out.println("Error, there aren't any Players registered.");
		} else {
			System.out.println(controller.showTopFive());	
		}
	}

}