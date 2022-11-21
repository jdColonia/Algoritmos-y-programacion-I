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
	 * <strong>pos:</strong> 
	 * <strong>Inputs:</strong> mainOption <strong>int</strong> Option selected by user
	 * <strong>Outputs:</strong> Message by console
	 * </pre>
	 */
	public void showMainMenu() {

		System.out.println("WELCOME TO NEOTUNES");
		boolean stopFlag = false;

		while (!stopFlag) {	
			System.out.print("************************************************");
			System.out.println("\nMain menu:"
					+ "\n[1] Register producer user"
					+ "\n[2] Register buyer user"
					+ "\n[3] Register audios"
					+ "\n[4] Create a playlist"
					+ "\n[5] Edit a playlist"
					+ "\n[6] Share a playlist"
					+ "\n[7] Play an audio"
					+ "\n[8] Buy a song"
					+ "\n[9] Generate reports"
					+ "\n[0] Exit");
			System.out.print("Select an option: ");
			int mainOption = sc.nextInt();
			System.out.print("************************************************");
			
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
				createPlaylist();
				break;
			case 5:
				editPlaylist();
				break;
			case 6:
				sharePlaylist();
				break;
			case 7:
				playAudio();
				break;
			case 8:
				buySong();
				break;
			case 9:
				System.out.println("\n[1] Show the total accumulated reproductions on the entire platform" 
								+ "\n[2] Show the most listened song genre" 
								+ "\n[3] Show the most listened podcast category" 
								+ "\n[4] Show top producers" 
								+ "\n[5] Show top audio" 
								+ "\n[6] Show sales information of a genre type" 
								+ "\n[7] Show the best-selling song on the platform");
				System.out.print("Select an option: ");
				int optReport = sc.nextInt();

				switch (optReport) {
				case 1:
					showTotalAccumulatedReproductions();
					break;
				case 2:
					showMostPlayedSongGenre();
					break;
				case 3:
					showMostPlayedPodcastCategory();
					break;
				case 4:
					showTopProducers();
					break;
				case 5:
					showTopAudio();
					break;
				case 6:
					showInfoByGenreSong();
					break;
				case 7:
					showBestSellerSong();
					break;
				default:
					System.out.println("You must type a valid option");
					break;
				}
				break;
			case 0:
				stopFlag = true;
				break;
			default:
				System.out.println("You must type a valid option");
				break;

			}

		}

	}

	/**
	 * <pre>
	 * <strong>Description:</strong> The method registerProducerUser allows to register producer user to the system
	 * <strong>pre:</strong> controller must be initialized
	 * <strong>pos:</strong> NA
	 * <strong>Inputs:</strong> optProducer <strong>int</strong> Type of producer user
	 * <strong>Inputs:</strong> nameUser <strong>String</strong> User name
	 * <strong>Inputs:</strong> identificationNumber <strong>String</strong> User identification number
	 * <strong>Inputs:</strong> bondingDate <strong>String</strong> User registration date
	 * <strong>Inputs:</strong> photoURL <strong>String</strong> Url of the user's photo
	 * <strong>Outputs:</strong> Message by console
	 * </pre>
	 */
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
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method registerBuyerUser allows to register buyer user to the system
	 * <strong>pre:</strong> controller must be initialized
	 * <strong>pos:</strong> NA
	 * <strong>Inputs:</strong> optBuyer <strong>int</strong> Type of buyer user
	 * <strong>Inputs:</strong> nameUser <strong>String</strong> User name
	 * <strong>Inputs:</strong> identificationNumber <strong>String</strong> User identification number
	 * <strong>Inputs:</strong> bondingDate <strong>String</strong> User registration date
	 * <strong>Outputs:</strong> Message by console
	 * </pre>
	 */
	public void registerBuyerUser() {
		
		System.out.println("\n[1] Register Standard User" + "\n[2] Register Premium User");
		System.out.print("Select an option: ");
		int optBuyer = sc.nextInt();
		
		System.out.print("Type the new Buyer User's name: ");
		sc.nextLine();
		String nameUser = sc.nextLine();
		
		System.out.print("Type the new Buyer User's identification number: ");
		String identificationNumber = sc.nextLine();

		System.out.print("Type the new Buyer User's bonding date [YYYY-MM-DD]: ");
		String bondingDate = sc.nextLine();

		int year = Integer.parseInt(bondingDate.split("-")[0]);
		int month = Integer.parseInt(bondingDate.split("-")[1]);
		int day = Integer.parseInt(bondingDate.split("-")[2]);

		System.out.println("...\n" + controller.registerBuyerUser(optBuyer, nameUser, identificationNumber, year, month, day));
		
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method registerSong allows to register song to the system
	 * <strong>pre:</strong> controller must be initialized
	 * <strong>pos:</strong> NA
	 * <strong>Inputs:</strong> nameArtist <strong>String</strong> Name of the artist producing the song
	 * <strong>Inputs:</strong> nameSong <strong>String</strong> Song name
	 * <strong>Inputs:</strong> album <strong>String</strong> Song album
	 * <strong>Inputs:</strong> genreType <strong>int</strong> Type of song genre
	 * <strong>Inputs:</strong> url <strong>String</strong> Url of the song's photo
	 * <strong>Inputs:</strong> duration <strong>String</strong> Duration of the song
	 * <strong>Inputs:</strong> saleValue <strong>double</strong> Sales value of the song
	 * <strong>Outputs:</strong> Message by console
	 * </pre>
	 */
	public void registerSong() {
		
		System.out.print("Type the Producer's name of the song: ");
		sc.nextLine();
		String nameArtist = sc.nextLine();
		
		System.out.print("Type the new Song's name: ");
		String nameSong = sc.nextLine();
		
		System.out.print("Type the new Song's album: ");
		String album = sc.nextLine();
		
		System.out.print("These are the possible genre type: " + controller.getGenreType());
		System.out.print("\nType the new Song's genre type: ");
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
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method registerPodcast allows to register podcast to the system
	 * <strong>pre:</strong> controller must be initialized
	 * <strong>pos:</strong> NA
	 * <strong>Inputs:</strong> nameContentCreator <strong>String</strong> Name of the content creator producing the podcast
	 * <strong>Inputs:</strong> nameSong <strong>String</strong> Podcast name
	 * <strong>Inputs:</strong> description <strong>String</strong> Podcast description
	 * <strong>Inputs:</strong> podcastCategory <strong>int</strong> Podcast category
	 * <strong>Inputs:</strong> url <strong>String</strong> Url of the podcast's photo
	 * <strong>Inputs:</strong> duration <strong>String</strong> Duration of the podcast
	 * <strong>Outputs:</strong> Message by console
	 * </pre>
	 */
	public void registerPodcast() {
		
		System.out.print("Type the Producer's name of the podcast: ");
		sc.nextLine();
		String nameContentCreator = sc.nextLine();
		
		System.out.print("Type the new Podcast's name: ");
		String namePodcast = sc.nextLine();
		
		System.out.print("Type the new Podcast's description: ");
		String description = sc.nextLine();
		
		System.out.print("These are the possible podcast category: " + controller.getPodcastCategory());
		System.out.print("\nType the new Podcast's category: ");
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
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method createPlaylist allows to create a playlist in the system
	 * <strong>pre:</strong> controller must be initialized
	 * <strong>pos:</strong> NA
	 * <strong>Inputs:</strong> nameUser <strong>String</strong> Name of the user who is going to create the playlist
	 * <strong>Inputs:</strong> namePlaylist <strong>String</strong> Playlist name
	 * <strong>Inputs:</strong> playlistType <strong>int</strong> Playlist type
	 * <strong>Outputs:</strong> Message by console
	 * </pre>
	 */
	public void createPlaylist() {
		
		System.out.print("\nType the User's name that creating the playlist: ");
		sc.nextLine();
		String nameUser = sc.nextLine();
		
		System.out.print("Type the new Playlist's name: ");
		String namePlaylist = sc.nextLine();
		
		System.out.print("These are the possible playlist type: " + controller.getPlaylistType());
		System.out.print("\nType the new Playlist's type: ");
		int playlistType = (sc.nextInt()-1);
		
		int[][] matrix = controller.generateMatrix();	
		
		String idPlaylist;
		
		switch (playlistType) {
		case 0:
			idPlaylist = controller.generateCodeN(matrix);
			System.out.println("...\n" + controller.createPlaylist(nameUser, namePlaylist, playlistType, matrix, idPlaylist));
			break;
		case 1:
			idPlaylist = controller.generateCodeT(matrix);
			System.out.println("...\n" + controller.createPlaylist(nameUser, namePlaylist, playlistType, matrix, idPlaylist));
			break;
		case 2:
			idPlaylist = controller.generateCodeStaggered(matrix);
			System.out.println("...\n" + controller.createPlaylist(nameUser, namePlaylist, playlistType, matrix, idPlaylist));
			break;
		default:
			System.out.println("...\n" + "Error, you must type a valid option");
			break;
		}
		
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method editPlaylist allows to edit the playlist of a user
	 * <strong>pre:</strong> controller must be initialized
	 * <strong>pos:</strong> NA
	 * <strong>Inputs:</strong> nameUser <strong>String</strong> Name of the user who created the playlist
	 * <strong>Inputs:</strong> namePlaylist <strong>String</strong> Playlist name
	 * <strong>Inputs:</strong> optEdit <strong>int</strong> Editing action available to the user
	 * <strong>Outputs:</strong> Message by console
	 * </pre>
	 */
	public void editPlaylist() {
		
		System.out.print("\nType the User's name that created the playlist: ");
		sc.nextLine();
		String nameUser = sc.nextLine();
		
		System.out.print("Type the Playlist's name: ");
		String namePlaylist = sc.nextLine();
		
		System.out.println("The following options are available: ");
		System.out.println("[1] Rename playlist" + "\n[2] Add audio to playlist" + "\n[3] Remove audio the playlist");
		System.out.print("Select an option: ");
		int optEdit = sc.nextInt();
		
		switch (optEdit) {
		case 1:
			System.out.print("Type new the Playlist's name: ");
			sc.nextLine();
			String newNamePlaylist = sc.nextLine();
			System.out.println("...\n" + controller.renamePlaylist(nameUser, namePlaylist, newNamePlaylist));
			break;
		case 2:
			System.out.print("Type the Audio's name to add: ");
			sc.nextLine();
			String nameAudioToAdd = sc.nextLine();
			System.out.println("...\n" + controller.addAudioToPlaylist(nameUser, namePlaylist, nameAudioToAdd));
			break;
		case 3:
			System.out.print("Type the Audio's name to remove: ");
			sc.nextLine();
			String nameAudioToRemove = sc.nextLine();
			System.out.println("...\n" + controller.removeAudioOfPlaylist(nameUser, namePlaylist, nameAudioToRemove));
			break;
		default:
			System.out.println("...\n" + "Error, you must type a valid option");
			break;
		}
			
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method sharePlaylist allows to share the playlist of a user
	 * <strong>pre:</strong> controller must be initialized
	 * <strong>pos:</strong> NA
	 * <strong>Inputs:</strong> nameUser <strong>String</strong> Name of the user who created the playlist
	 * <strong>Inputs:</strong> namePlaylist <strong>String</strong> Playlist name
	 * <strong>Outputs:</strong> Message by console
	 * </pre>
	 */
	public void sharePlaylist() {
		
		System.out.print("\nType the User's name that created the playlist: ");
		sc.nextLine();
		String nameUser = sc.nextLine();
		
		System.out.print("Type the Playlist's name: ");
		String namePlaylist = sc.nextLine();
		
		System.out.println("...\n" + controller.sharePlaylist(nameUser, namePlaylist));
		
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method playAudio allows to simulate the playback of a song or podcast
	 * <strong>pre:</strong> controller must be initialized
	 * <strong>pos:</strong> NA
	 * <strong>Inputs:</strong> nameUser <strong>String</strong> User name
	 * <strong>Inputs:</strong> nameAudio <strong>String</strong> Audio name
	 * <strong>Outputs:</strong> Message by console
	 * </pre>
	 */
	public void playAudio() {
		
		System.out.print("\nType the User's name that has the audio: ");
		sc.nextLine();
		String nameUser = sc.nextLine();
		
		System.out.print("Type the Audio's name: ");
		String nameAudio = sc.nextLine();
		
		System.out.println("...\n" + controller.playAudio(nameUser, nameAudio) + "\n...");
		
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method buySong allows to buy a song from a buyer user
	 * <strong>pre:</strong> controller must be initialized
	 * <strong>pos:</strong> NA
	 * <strong>Inputs:</strong> nameUser <strong>String</strong> User's name that will buy the song
	 * <strong>Inputs:</strong> nameSong <strong>String</strong> Name of the song to buy
	 * <strong>Outputs:</strong> Message by console
	 * </pre>
	 */
	public void buySong() {
		
		System.out.print("\nType the User's name that will buy the song: ");
		sc.nextLine();
		String nameUser = sc.nextLine();
		
		System.out.print("Type the Song's name: ");
		String nameSong = sc.nextLine();
		
		System.out.println("...\n" + controller.buySong(nameUser, nameSong));
		
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method showTotalAccumulatedReproductions allows to generate a report of the total accumulated plays for the entire platform for each type of audio
	 * <strong>pre:</strong> controller must be initialized
	 * <strong>pos:</strong> NA
	 * <strong>Inputs:</strong> optAudio <strong>int</strong> Actions available to the user
	 * <strong>Outputs:</strong> Message by console
	 * </pre>
	 */
	public void showTotalAccumulatedReproductions() {
		
		System.out.println("...\n" + "The following options are available: ");
		System.out.println("[1] Show total accumulated reproductions of songs" + "\n[2] Show total accumulated reproductions of podcast");
		System.out.print("Select an option: ");
		int optAudio = sc.nextInt();
		
		switch (optAudio) {
		case 1:
			System.out.println("...\n" + "Total accumulated reproductions of songs: " + controller.showTotalAccumulatedReproductions(optAudio));
			break;
		case 2:
			System.out.println("...\n" + "Total accumulated reproductions of podcast: " + controller.showTotalAccumulatedReproductions(optAudio));
			break;
		default:
			System.out.println("...\n" + "Error, you must type a valid option");
			break;
		}
		
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method showMostPlayedSongGenre allows to generate a report showing the most listened song genre by user and in the whole platform
	 * <strong>pre:</strong> controller must be initialized
	 * <strong>pos:</strong> NA
	 * <strong>Inputs:</strong> opt <strong>int</strong> Actions available to the user
	 * <strong>Outputs:</strong> Message by console
	 * </pre>
	 */
	public void showMostPlayedSongGenre() {
		
		System.out.println("...\n" + "The following options are available: ");
		System.out.println("[1] Show the most listened genre for the entire platform" + "\n[2] Show the most listened genre for a user");
		System.out.print("Select an option: ");
		int opt = sc.nextInt();
		
		switch (opt) {
		case 1:
			if (controller.showMostPlayedSongGenre().equals("")) {
				System.out.println("...\n" + "Error, no user has played a song");
			} else {
				System.out.println("...\n" + controller.showMostPlayedSongGenre());
			}
			break;
		case 2:
			System.out.print("Type the User's name: ");
			sc.nextLine();
			String nameUser = sc.nextLine();
			if (controller.showUserMostPlayedSongGenre(nameUser).equals("")) {
				System.out.println("...\n" + "Error, the user has not played any song");
			}
			System.out.println("...\n" + controller.showUserMostPlayedSongGenre(nameUser));
			break;
		default:
			System.out.println("...\n" + "Error, you must type a valid option");
			break;
		}
		
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method showMostPlayedPodcastCategory allows to generate a report showing the most listened podcast category per user and platform
	 * <strong>pre:</strong> controller must be initialized
	 * <strong>pos:</strong> NA
	 * <strong>Inputs:</strong> opt <strong>int</strong> Actions available to the user
	 * <strong>Outputs:</strong> Message by console
	 * </pre>
	 */
	public void showMostPlayedPodcastCategory() {
		
		System.out.println("...\n" + "The following options are available: ");
		System.out.println("[1] Show the most listened category for the entire platform" + "\n[2] Show the most listened category for a user");
		System.out.print("Select an option: ");
		int opt = sc.nextInt();
		
		switch (opt) {
		case 1:
			if (controller.showMostPlayedPodcastCategory().equals("")) {
				System.out.println("...\n" + "Error, no user has played a podcast");
			} else {
				System.out.println("...\n" + controller.showMostPlayedPodcastCategory());
			}
			break;
		case 2:
			System.out.print("Type the User's name: ");
			sc.nextLine();
			String nameUser = sc.nextLine();
			if (controller.showUserMostPlayedPodcastCategory(nameUser).equals("")) {
				System.out.println("...\n" + "Error, the user has not played any podcast");
			} else {
				System.out.println("...\n" + controller.showUserMostPlayedPodcastCategory(nameUser));
			}
			break;
		default:
			System.out.println("...\n" + "Error, you must type a valid option");
			break;
		}
		
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method showTopProducers allows to show the top 5 producers
	 * <strong>pre:</strong> controller must be initialized
	 * <strong>pos:</strong> NA
	 * <strong>Inputs:</strong> opt <strong>int</strong> Actions available to the user
	 * <strong>Outputs:</strong> Message by console
	 * </pre>
	 */
	public void showTopProducers() {
		
		System.out.println("...\n" + "The following options are available: ");
		System.out.println("[1] Show top 5 artist" + "\n[2] Show top 5 content creator");
		System.out.print("Select an option: ");
		int opt = sc.nextInt();
		
		switch (opt) {
		case 1:
			if (controller.showTopArtist().equals("")) {
				System.out.println("...\n" + "Error, no songs by any artist have been played");
			} else {
				System.out.println("...\n" + controller.showTopArtist());
			}
			break;
		case 2:
			if (controller.showTopContentCreator().equals("")) {
				System.out.println("...\n" + "Error, no podcasts by any content creator have been played");
			} else {
				System.out.println("...\n" + controller.showTopContentCreator());
			}
			break;
		default:
			System.out.println("...\n" + "Error, you must type a valid option");
			break;
		}
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method showTopAudio allows to show the top 10 audio
	 * <strong>pre:</strong> controller must be initialized
	 * <strong>pos:</strong> NA
	 * <strong>Inputs:</strong> opt <strong>int</strong> Actions available to the user
	 * <strong>Outputs:</strong> Message by console
	 * </pre>
	 */
	public void showTopAudio() {
		
		System.out.println("...\n" + "The following options are available: ");
		System.out.println("[1] Show top 10 song" + "\n[2] Show top 10 podcast");
		System.out.print("Select an option: ");
		int opt = sc.nextInt();
		
		switch (opt) {
		case 1:
			if (controller.showTopSong().equals("")) {
				System.out.println("...\n" + "Error, no songs by any artist have been played");
			} else {
				System.out.println("...\n" + controller.showTopSong());
			}
			break;
		case 2:
			if (controller.showTopPodcast().equals("")) {
				System.out.println("...\n" + "Error, no podcasts by any content creator have been played");
			} else {
				System.out.println("...\n" + controller.showTopPodcast());
			}
			break;
		default:
			System.out.println("...\n" + "Error, you must type a valid option");
			break;
		}
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method showInfoByGenreSong allows to generate a report showing the number of songs sold and the total sales value for each genre
	 * <strong>pre:</strong> controller must be initialized
	 * <strong>pos:</strong> NA
	 * <strong>Inputs:</strong> int <strong>genreType</strong> Type of song genre
	 * <strong>Outputs:</strong> Message by console
	 * </pre>
	 */
	public void showInfoByGenreSong() {
		
		System.out.print("...\n" + "These are the available genre type: " + controller.getGenreType());
		System.out.print("\nType the new Song's genre type: ");
		int genreType = (sc.nextInt()-1);
		System.out.println("...\n" + controller.showInfoByGenreSong(genreType));
		
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method showBestSellerSong allows to generate a report of the best-selling song on the platform
	 * <strong>pre:</strong> controller must be initialized
	 * <strong>pos:</strong> NA
	 * <strong>Outputs:</strong> Message by console
	 * </pre>
	 */
	public void showBestSellerSong() {
		
		System.out.println("...\n" + controller.showBestSellerSong());
		
	}

}
