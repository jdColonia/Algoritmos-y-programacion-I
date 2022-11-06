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
			System.out.print("*******************************************");
			System.out.println("\nMain menu:"
					+ "\n[1] Register producer user"
					+ "\n[2] Register buyer user"
					+ "\n[3] Register audios"
					+ "\n[4] Create a playlist"
					+ "\n[5] Edit a playlist"
					+ "\n[0] Exit");
			System.out.print("Select an option: ");
			int mainOption = sc.nextInt();
			System.out.print("*******************************************");
			
			switch (mainOption) {
			case 1:
				registerProducerUser();
				break;
			case 2:
				registerBuyerUser();
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
				//createPlaylist();
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
	

	public void registerProducerUser() {
		
		System.out.println("\n[1] Register artist" + "\n[2] Register content creator");
		System.out.print("Select an option: ");
		int optProducer = sc.nextInt();
		
		System.out.print("Type the new Producer's name: ");
		sc.nextLine();
		String nameUser = sc.nextLine();
		
		System.out.print("Type the new Producer's identification number: ");
		String identificationNumber = sc.nextLine();

		System.out.print("Type the new Producer's bonding date [YYYY-MM-DD]: ");
		String bondingDate = sc.nextLine();

		int year = Integer.parseInt(bondingDate.split("-")[0]);
		int month = Integer.parseInt(bondingDate.split("-")[1]);
		int day = Integer.parseInt(bondingDate.split("-")[2]);

		System.out.print("Type the new Producer's photo: ");
		String photoURL = sc.nextLine();

		System.out.println("...\n" + controller.registerProducerUser(optProducer, nameUser, identificationNumber, year, month, day, photoURL));
		
	}
	
	public void registerBuyerUser() {
		
		System.out.println("\n[1] Register Standard User" + "\n[2] Register Premium User");
		System.out.print("Select an option: ");
		int optBuyer = sc.nextInt();
		
		System.out.print("Type the new Buyer User's name: ");
		sc.nextLine();
		String nameUser = sc.nextLine();

		System.out.print("Type the new Buyer User's bonding date [YYYY-MM-DD]: ");
		String bondingDate = sc.nextLine();

		int year = Integer.parseInt(bondingDate.split("-")[0]);
		int month = Integer.parseInt(bondingDate.split("-")[1]);
		int day = Integer.parseInt(bondingDate.split("-")[2]);

		System.out.print("Type the new Buyer User's identification number: ");
		String identificationNumber = sc.nextLine();
		
		System.out.println("...\n" + controller.registerBuyerUser(optBuyer, nameUser, identificationNumber, year, month, day));
		
	}
	
	public void registerSong() {
		
		System.out.print("Type the Producer's name of the song: ");
		sc.nextLine();
		String nameArtist = sc.nextLine();
		
		System.out.print("Type the new Song's name: ");
		String nameSong = sc.nextLine();
		
		System.out.print("Type the new Song's album: ");
		String album = sc.nextLine();
		
		System.out.print("These are the possible genre type: " + controller.getGenreType());
		System.out.print("Type the new Song's genre type: ");
		int genreType = (sc.nextInt()-1);

		System.out.print("Type the new Song's photo: ");
		sc.nextLine();
		String url = sc.nextLine();
		
		System.out.print("Type the new Song's duration [MIN:SEC]: ");
		String durationString = sc.nextLine();
		int min = Integer.parseInt(durationString.split(":")[0]);
		int sec = Integer.parseInt(durationString.split(":")[1]);
		int duration = controller.convertToSec(min, sec);
		
		System.out.print("Type the new Song's sale value: ");
		double saleValue = sc.nextDouble();
		
		System.out.println("...\n" + controller.registerSong(nameSong, album, genreType, url, duration, saleValue, nameArtist));
		
	}
	
	public void registerPodcast() {
		
		System.out.print("Type the Producer's name of the podcast: ");
		sc.nextLine();
		String nameContentCreator = sc.nextLine();
		
		System.out.print("Type the new Podcast's name: ");
		String namePodcast = sc.nextLine();
		
		System.out.print("Type the new Podcast's description: ");
		String description = sc.nextLine();
		
		System.out.print("These are the possible podcast category: " + controller.getPodcastCategory());
		System.out.print("Type the new Podcast's category: ");
		int podcastCategory = (sc.nextInt()-1);

		System.out.print("Type the new Podcast's photo: ");
		sc.nextLine();
		String url = sc.nextLine();
		
		System.out.print("Type the new Podcast's duration [H:MIN:SEC]: ");
		String durationString = sc.nextLine();
		int hour = Integer.parseInt(durationString.split(":")[0]);
		int min = Integer.parseInt(durationString.split(":")[1]);
		int sec = Integer.parseInt(durationString.split(":")[2]);
		int duration = controller.convertToSec(hour, min, sec);
		
		System.out.println("...\n" + controller.registerPodcast(namePodcast, description, podcastCategory, url, duration, nameContentCreator));
	
	}
	
		public void createPlaylist() {
		
		System.out.print("Type the User's name that creating the playlist: ");
		sc.nextLine();
		String nameUser = sc.nextLine();
		
		System.out.print("Type the new Playlist's name: ");
		String namePlaylist = sc.nextLine();
		
		System.out.println("...\n" + controller.createPlaylist(nameUser, namePlaylist));
		
	}

}
