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
					+ "\n[5] Modify level of a player"
					+ "\n[6] Show treasures and enemies of a level"
					+ "\n[7] Show amount of a treasure in all levels"
					+ "\n[8] Show amount of a enemy in all levels"
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
	 * <pre>
	 * <strong>Description:</strong> The method createEnemy allows to register one enemy to a level
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
		int optionLevel = sc.nextInt();
		
		System.out.print("Type the name of the new enemy: ");
		sc.nextLine();
		String nameEnemy = sc.nextLine();
		
		System.out.println("These are the possible types of enemies:" + controller.getEnemyType());
		System.out.println("Type the type of the enemy: ");
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
		
		String playersList = controller.showPlayersList();
		
		if (playersList.equals("")) {
			
			System.out.println("There aren't any Players registered.");
			
		} else {
		
			System.out.println("These are the players currently registered:" + playersList);
			System.out.print("Type the nickname of the player whose points you want to modify: ");
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
		
		String playersList = controller.showPlayersList();
		
		if (playersList.equals("")) {
			
			System.out.println("There aren't any Players registered.");
			
		} else {
		
			System.out.println("These are the players currently registered:" + playersList);
			System.out.print("Type the nickname of the player whose level you want to modify: ");
			int optionPlayer = sc.nextInt();
			
			System.out.println("These are the levels currently registered:" + controller.showLevels());
			System.out.print("Type the ID of the level you want to raise the player to: ");
			int newLevel = sc.nextInt();
			
			if (controller.modifyLevelPlayer((optionPlayer-1),(newLevel-1))) {
				
				System.out.println("Change was made successfully");
	
			} else {
				
				System.out.println("Error, change failed. " + "The score required to advance to the next level is: " + controller.scoreRequiredToPassLevel((optionPlayer-1),(newLevel-1))  + " points");
				
			}
		
		}
		
	}
	
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method showTreasuresAndEnemies allows show a list of registered treasures and enemies in a level
	 * <strong>pre:</strong> controller must be initialized
	 * <strong>pos:</strong> NA
	 * <strong>Inputs:</strong> optionLevel <strong>int</strong> Level from which the list is obtained
	 * <strong>Outputs:</strong> Message by console
	 * </pre>
	 */
	public static void showTreasuresAndEnemies() {
		
		System.out.println("These are the levels currently registered:" + controller.showLevels());
		System.out.print("Type the ID of the level in which you want to see the registered treasures and enemies: ");
		int optionLevel = sc.nextInt();
		
		System.out.println(controller.showTreasuresAndEnemies((optionLevel-1)));
		
	}
	
	public static void showAmountTreasure() {
		
		System.out.print("Type the name of the treasure: ");
		sc.nextLine();
		String nameTreasure = sc.nextLine();
		
		if (controller.searchTreasure(nameTreasure)) {
			
			System.out.println("The amount of " + nameTreasure + " is: " + controller.amountTreasureLevels(nameTreasure));
			
			
		} else {
			
			System.out.println("Error, treasure is not registered in any level");
			
		}
		
	}
	
	
	public static void showAmountEnemy() {
		
		System.out.print("Type the name of the enemy: ");
		sc.nextLine();
		String nameEnemy = sc.nextLine();
		
		if (controller.searchEnemy(nameEnemy)) {
			
			System.out.println("The amount of " + nameEnemy + " is: " + controller.amountEnemyLevels(nameEnemy));
			
			
		} else {
			
			System.out.println("Error, enemy is not registered in any level");
			
		}
		
	}
	


}