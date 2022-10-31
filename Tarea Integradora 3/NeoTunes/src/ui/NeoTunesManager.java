package ui;

import java.util.Scanner;
import model.NeoTunesController;

public class NeoTunesManager {
	
	public Scanner sc;
	public NeoTunesController controller;

	public static void main(String[] args) {
		NeoTunesManager manager = new NeoTunesManager();
		manager.showMainMenu();
	}

	public NeoTunesManager() {
		sc = new Scanner(System.in);
		controller = new NeoTunesController();
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method showMainMenu allows to show the main menu of the system
	 * <strong>pre:</strong> NA
	 * <strong>pos:</strong> NA
	 * </pre>
	 */
	public void showMainMenu() {

		System.out.println("WELCOME TO NEOTUNES");

		boolean stopFlag = false;

		while (!stopFlag) {

			System.out.println("\nMain menu:"
					+ "\n[1] Register producer user"
					+ "\n[2] Register buyer user"
					+ "\n[3] Register audios"
					+ "\n[4] Create a playlist"
					+ "\n[5] Edit a playlist"
					+ "\n[0] Exit");
			System.out.print("Select an option: ");
			int mainOption = sc.nextInt();

			switch (mainOption) {

			case 1:
				System.out.println("\n[1] Register artist" + "\n[2] Register content creator");
				System.out.print("Select an option: ");
				int optProducer = sc.nextInt();

				switch (optProducer) {
				case 1:
					registerArtist();
					break;
				case 2:
					registerContentCreator();
					break;
				default:
					System.out.println("You must type a valid option");
					break;
				}
				
				break;
			case 2:
				System.out.println("\n[1] Register standard user" + "\n[2] Register premium user");
				System.out.print("Select an option: ");
				int optBuyer = sc.nextInt();

				switch (optBuyer) {
				case 1:
					registerStandardUser();
					break;
				case 2:
					registerPremiumUser();
					break;
				default:
					System.out.println("You must type a valid option");
					break;
				}
				
				break;
			case 3:
				System.out.println("\n[1] Register song" + "\n[2] Register podcast");
				System.out.print("Select an option: ");
				int optAudio = sc.nextInt();

				switch (optAudio) {
				case 1:
					registerSong();
					break;
				case 2:
					registerPodcast();
					break;
				default:
					System.out.println("You must type a valid option");
					break;
				}
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 0:
				System.out.println("Thanks for using our system");
				stopFlag = true;
				break;
			default:
				System.out.println("You must type a valid option");
				break;

			}

		}

	}
	
	public void registerArtist() {
		
		System.out.println("Type the new Artist's name: ");
		sc.nextLine();
		String nameUser = sc.nextLine();

		System.out.println("Type the new Artist's bonding date (YYYY-MM-DD): ");
		String bondingDate = sc.nextLine();

		int year = Integer.parseInt(date.split("-")[0]);
		int month = Integer.parseInt(date.split("-")[1]);
		int day = Integer.parseInt(date.split("-")[2]);

		System.out.println("Type the new Artist's photo: ");
		String photoURL = sc.nextLine();

		/*if (controller.registerRegularUser(name, id, email, phone)) {

			System.out.println("User registered successfully");

		} else {

			System.out.println("Error, User couldn't be registered");
			
		}*/
	}
	
	public void registerContentCreator() {
		
		System.out.println("Type the new Content Creator's name: ");
		sc.nextLine();
		String nameUser = sc.nextLine();

		System.out.println("Type the new Content Creator's bonding date (YYYY-MM-DD): ");
		String bondingDate = sc.nextLine();

		int year = Integer.parseInt(date.split("-")[0]);
		int month = Integer.parseInt(date.split("-")[1]);
		int day = Integer.parseInt(date.split("-")[2]);

		System.out.println("Type the new Content Creator's photo: ");
		String photoURL = sc.nextLine();

		/*if (controller.registerRegularUser(name, id, email, phone)) {

			System.out.println("User registered successfully");

		} else {

			System.out.println("Error, User couldn't be registered");
			
		}*/
		
	}
		
	public void registerStandardUser() {
		
		System.out.println("Type the new Standard User's name: ");
		sc.nextLine();
		String nameUser = sc.nextLine();

		System.out.println("Type the new Standard User's bonding date (YYYY-MM-DD): ");
		String bondingDate = sc.nextLine();

		int year = Integer.parseInt(date.split("-")[0]);
		int month = Integer.parseInt(date.split("-")[1]);
		int day = Integer.parseInt(date.split("-")[2]);

		System.out.println("Type the new Standard User's identification number: ");
		String identificationNumber = sc.nextLine();

		/*if (controller.registerRegularUser(name, id, email, phone)) {

			System.out.println("User registered successfully");

		} else {

			System.out.println("Error, User couldn't be registered");
			
		}*/
		
	}
	
	public void registerPremiumUser() {
		
		System.out.println("Type the new Premium User's name: ");
		sc.nextLine();
		String nameUser = sc.nextLine();

		System.out.println("Type the new Premium User's bonding date (YYYY-MM-DD): ");
		String bondingDate = sc.nextLine();

		int year = Integer.parseInt(date.split("-")[0]);
		int month = Integer.parseInt(date.split("-")[1]);
		int day = Integer.parseInt(date.split("-")[2]);

		System.out.println("Type the new Premium User's identification number: ");
		String identificationNumber = sc.nextLine();

		/*if (controller.registerRegularUser(name, id, email, phone)) {

			System.out.println("User registered successfully");

		} else {

			System.out.println("Error, User couldn't be registered");
			
		}*/
		
	}
	
	public void registerSong() {
		
		
	}
	
	public void registerPodcast() {
		
		
	}
	

}
