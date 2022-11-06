package model;

import java.util.ArrayList;
import java.util.Date;
import  java.util.Random;

public class NeoTunesController {
	
	private ArrayList<User> userList;
	private ArrayList<Audio> audioList;
    private ArrayList<Playlist> globalPlaylist;
	private Random random;
	
	public NeoTunesController() {
		this.userList = new ArrayList<User>();
		this.audioList = new ArrayList<Audio>();
        this.globalPlaylist = new ArrayList<Playlist>();
		this.random = new Random();
		testCase();
	}
	
	public void testCase() {
		
		Artist artist = new Artist("Juan", "A00395956", new Date(2022, 8, 19), "png");

		ContentCreator contentCreator = new ContentCreator("Camila", "A00312345", new Date(2021, 9, 21), "png");
		
		Standard standardBuyer = new Standard("Andres", "12345", new Date(2021, 1, 11));

		Premium premiumBuyer = new Premium("Valentina", "67890", new Date(2021, 6, 23));
		
		userList.add(artist);
		userList.add(contentCreator);
		userList.add(standardBuyer);
		userList.add(premiumBuyer);		
	}
		
	public ArrayList<User> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}

	public ArrayList<Audio> getAudioList() {
		return audioList;
	}

	public void setAudioList(ArrayList<Audio> audioList) {
		this.audioList = audioList;
	}

	public ArrayList<Playlist> getGlobalPlaylist() {
		return globalPlaylist;
	}

	public void setGlobalPlaylist(ArrayList<Playlist> globalPlaylist) {
		this.globalPlaylist = globalPlaylist;
	}

	public String getGenreType() {		
		String msg = "";		
		GenreType[] genreType = GenreType.values();		
		for (int i = 0; i < genreType.length; i++) {			
			msg += "\n[" + (i+1) + "]" + genreType[i];			
		}		
		return msg;		
	}
	
	public String getPodcastCategory() {		
		String msg = "";		
		PodcastCategory[] podcastCategory = PodcastCategory.values();		
		for (int i = 0; i < podcastCategory.length; i++) {			
			msg += "\n[" + (i+1) + "]" + podcastCategory[i];			
		}		
		return msg;		
	}
	
	public String getPlaylistType() {		
		String msg = "";		
		PlaylistType[] playlistType = PlaylistType.values();		
		for (int i = 0; i < playlistType.length; i++) {			
			msg += "\n[" + (i+1) + "]" + playlistType[i];			
		}		
		return msg;		
	}
	
	public int convertToSec(int min, int sec) {	
		int totalSec; 		
		totalSec = (min * 60) + sec;		
		return totalSec;		
	}
	
	public int convertToSec(int hour, int min, int sec) {		
		int totalSec; 		
		totalSec = (hour * 3600) + (min * 60) + sec;		
		return totalSec;		
	}
	
    public User searchUser(String nameUser){
		User user = null; 
		boolean isFound = false; 
		for(int i = 0; i < userList.size() && !isFound; i++) {
			if(userList.get(i).getNameUser().equalsIgnoreCase(nameUser)) {
				user = userList.get(i); 
				isFound = true; 
			}
		}
		return user; 
	}
	
	public Audio searchAudio(String nameAudio){
        Audio audio = null;
        boolean isFound = false;
         for(int i = 0; i < audioList.size() && !isFound; i++){
            if(audioList.get(i).getNameAudio().equalsIgnoreCase(nameAudio)) {
                audio = audioList.get(i);
                isFound = true;
            }
         }
    
        return audio;
    }
    
    public String registerProducerUser(int optProducer, String nameUser, String identificationNumber, int year, int month, int day, String photoURL) {
	
		String msg = "";
		if (searchUser(nameUser) != null) { 
			return "Error, user name not available";
		} else {
			switch (optProducer) {
			case 1:
				if (userList.add(new Artist(nameUser, identificationNumber, new Date(year, month, day), photoURL))) {
					return "Artist registered successfully";
				}
			case 2:
				if (userList.add(new ContentCreator(nameUser, identificationNumber, new Date(year, month, day), photoURL))) {
					return "Content Creator registered successfully";
				}
			default:
				return "Error, User couldn't be registered";
			}
		}
	}
	
	public String registerBuyerUser(int optBuyer, String nameUser, String identificationNumber, int year, int month, int day) {
		
		if (searchUser(nameUser) != null) { 
			return "Error, user name not available";
		} else {
			switch (optBuyer) {
			case 1:
				if (userList.add(new Standard(nameUser, identificationNumber, new Date(year, month, day)))) {
					return "Standard User registered successfully";
				}
			case 2:
				if (userList.add(new Premium(nameUser, identificationNumber, new Date(year, month, day)))) {
					return "Premium User registered successfully";
				}
			default:
				return "Error, User couldn't be registered";
			}
		}
	}
	
	public String registerSong(String nameSong, String album, int genreType, String url, int duration, double saleValue, String nameArtist) {

		User user = searchUser(nameArtist);
		Producer producer = (Producer) user; // Downcasting of User to Producer
		if (producer == null) {
			return "Error, User doesn't exist";
		} else {
			if (producer instanceof Artist) {
				Audio song = searchAudio(nameSong);
				if (song != null) {
					return "Error, the Song is already registered";
				} else {		
					Song newSong = new Song(nameSong, album, genreType, url, duration, saleValue);
					audioList.add(newSong);
					producer.addAudio(newSong);					
					return "Song registered successfully";
				}
			} else {
				return "User is not an artist";
			}
		}
	}
	
	public String registerPodcast(String namePodcast, String description, int podcastCategory, String url, int duration, String nameContentCreator) {

		User user = searchUser(nameContentCreator);
		Producer producer = (Producer) user; // Downcasting of User to Producer
		if (producer == null) {
			return "Error, User doesn't exist";
		} else {
			if (producer instanceof ContentCreator) {
				Audio podcast = searchAudio(namePodcast);
				if (podcast != null) {
					return "Error, the Podcast is already registered";
				} else {
					Podcast newPodcast = new Podcast(namePodcast, description, podcastCategory, url, duration);
					audioList.add(newPodcast);
					producer.addAudio(newPodcast);						        
					return "Podcast registered successfully";
				}
			} else {
				return "User is not an content creator";
			}
		}
	}
	
	public String createPlaylist(String nameUser, String namePlaylist, int playlistType, int[][] matrix, String idPlaylist) {
		
		String msg = "Error, Playlist couldn't be registered";
		User user = searchUser(nameUser);
		Buyer buyer = (Buyer) user; // Downcasting of User to Buyer
		if (buyer == null) {
			msg = "Error, User doesn't exist";
		} else {
			Playlist newPlaylist = new Playlist(namePlaylist, playlistType, matrix, idPlaylist);
			if (buyer.addPlaylist(newPlaylist)) {
				globalPlaylist.add(newPlaylist);
				msg = "Playlist registered successfully";	
			}
		}
		return msg;
	}
	
	public int[][] generateMatrix() {
		
		int[][] newMatrix = new int[6][6];
		for (int i = 0; i < newMatrix.length; i++) {	
			for (int j = 0; j < newMatrix[i].length; j++) {		
				newMatrix[i][j] = random.nextInt(10);				
			}				
		}		
		return newMatrix;		
	}
	
	public String printMatrix(int[][] matrix) {		
		
		String msg = "";		
		for (int i = 0; i < matrix.length; i++) {			
			for (int j = 0; j < matrix[i].length; j++) {				
				msg += matrix[i][j] + " ";			
			}			
			msg += "\n";			
		}
		return msg;
	}
		
	public String generateCodeN(int[][] matrix) {
		
		String msg = "";
		for (int i = matrix.length; i > 0; i--) { // Gets the values of the first column of the matrix
			msg += matrix[i - 1][0];
		}
        for (int i = 1, j = 1; i < matrix.length -1; i++, j++) { // Gets the values of the diagonal of the matrix           
        	msg += matrix[i][j];      	
        }
		for (int i = matrix.length; i > 0; i--) { // Gets the values of the last column of the matrix
			msg += matrix[i - 1][matrix[0].length - 1];
		}
		return msg;
	}
	
	public String generateCodeT(int[][] matrix) {
		
		String msg = "";
		for (int j = 0; j < matrix.length -4; j++) { // Gets the values of the first row, since column zero until column two
			msg += matrix[0][j];
		}
		for (int i = 0; i < matrix.length; i++) { // Gets the values of the column two
			msg += matrix[i][2];
		}
		for (int i = matrix.length; i > 0; i--) { // Gets the values of the column three
			msg += matrix[i - 1][3];
		}
		for (int j = matrix.length -2; j < matrix.length; j++ ) { // Gets the values of the first row, since column four until column five
			msg += matrix[0][j];
		}
		return msg;	
	}
	
	public String generateCodeStaggered(int[][] matrix) {
		
		String msg = "";
		for (int i = matrix.length -1; i >= 0; i--) {			
			for (int j = matrix.length -1; j >= 0 ; j--) {			
				if (((i + j) % 2 != 0) && ((i + j) > 1)) {				
					msg += matrix[i][j];
				}
			}			
		}		
		return msg;	
	}

}
