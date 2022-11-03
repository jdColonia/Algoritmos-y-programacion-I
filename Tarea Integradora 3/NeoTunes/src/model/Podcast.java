package model;

public class Podcast extends Audio {
	
	private String description;
	private PodcastCategory podcastCategory;

	public Podcast(String nameAudio, String description, int podcastCategory, String url, int duration, int numberPlays) {
		super(nameAudio, url, duration, numberPlays);
		this.description = description;
		this.podcastCategory = PodcastCategory.values()[podcastCategory];
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PodcastCategory getPodcastCategory() {
		return podcastCategory;
	}

	public void setPodcastCategory(PodcastCategory podcastCategory) {
		this.podcastCategory = podcastCategory;
	}	

}
