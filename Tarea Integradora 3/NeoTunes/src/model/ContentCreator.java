package model;

import java.util.ArrayList;
import java.util.Date;

public class ContentCreator extends Producer {
	
	private ArrayList <Podcast> podcasts;

	public ContentCreator(String nameUser, String identificationNumber, Date bondingDate, String photoURL) {
		super(nameUser, identificationNumber, bondingDate, photoURL);
		this.podcasts = new ArrayList<Podcast>();
	}

	public ArrayList<Podcast> getPodcasts() {
		return podcasts;
	}

	public void setPodcasts(ArrayList<Podcast> podcasts) {
		this.podcasts = podcasts;
	}
	
    @Override
    public void addAudio(Audio newAudio) {
    	podcasts.add( (Podcast) newAudio ); //Downcasting of Audio to Podcast
    }

}
