package model;

import java.util.ArrayList;
import java.util.Date;

public class NeoTunesController {
	
	private ArrayList<User> userList;
	private ArrayList<Audio> audioList;
	
	public NeoTunesController() {
		this.userList = new ArrayList<User>();
		this.audioList = new ArrayList<Audio>();
		testCase();
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

	public void testCase() {
		
		
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
	
	public boolean registerArtist(String nameUser, String identificationNumber, int year, int month, int day, String photoURL) {

		return userList.add(new Artist(nameUser, identificationNumber, new Date(year, month, day), photoURL));

	}

	public boolean registerContentCreator(String nameUser, String identificationNumber, int year, int month, int day, String photoURL) {

		return userList.add(new ContentCreator(nameUser, identificationNumber, new Date(year, month, day), photoURL));

	}
	
	public boolean registerStandardUser(String nameUser, String identificationNumber, int year, int month, int day) {

		return userList.add(new Standard(nameUser, identificationNumber, new Date(year, month, day)));

	}

	public boolean registerPremiumUser(String nameUser, String identificationNumber, int year, int month, int day) {

		return userList.add(new Premium(nameUser, identificationNumber, new Date(year, month, day)));

	}
	
	public boolean registerSong(String nameSong, String album, int genreType, String url, int duration, double saleValue) {
		
		return audioList.add(new Song(nameSong, album, genreType, url, duration, saleValue, 0, 0));
		
	}
	
	public boolean registerPodcast(String namePodcast, String description, int podcastCategory, String url, int duration) {
		
		return audioList.add(new Podcast(namePodcast, description, podcastCategory, url, duration, 0));
		
	}
	
	
	

}
