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

}
