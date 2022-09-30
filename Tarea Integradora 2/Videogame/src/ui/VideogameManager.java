package ui;

import java.util.Scanner;

import model.VideogameController;

public class VideogameManager{
	
	public static Scanner sc;
	public static VideogameController controller;

	public static void main(String[] args) {

		init();
		showMainMenu();

	}

	public static void init() {

		sc = new Scanner(System.in);
		controller = new VideogameController();

	}
	
	
	public static void showMainMenu() {
		
		System.out.println("Welcome to Videogame");
		
		boolean stopFlag = false;
		
		while (!stopFlag) {
			
			System.out.println("\nSelect an option"
					+ "\n[1] Create player "
					+ "\n[2] "
					+ "\n[3] "
					+ "\n[4] "
					+ "\n[0] Exit");
			
			int mainOption = sc.nextInt();
			
			switch (mainOption) {
			
			case 1:
				createPlayer();
				break;
			case 2:
				
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
	 *pre: Controller must be initialized
	 *pos: No aplica
	 *Input:  nickname	String Nickname of the player to register
	 *Input: namePlayer String Name of the player to register
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
}