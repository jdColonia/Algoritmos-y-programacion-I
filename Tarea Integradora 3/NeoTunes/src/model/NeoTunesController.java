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
	
	// AUXILIAR METHODS

    /**
     * <pre>
     * <strong>Description:</strong> The method getGenreType allows to display the genre type of the songs
	 * <strong>pre:</strong> NA
	 * <strong>pos:</strong> NA
     * @return msg <strong>String</strong> Message with type of genre songs
     * </pre>
     */
	public String getGenreType() {		
		String msg = "";		
		GenreType[] genreType = GenreType.values();		
		for (int i = 0; i < genreType.length; i++) {			
			msg += "\n[" + (i+1) + "]" + genreType[i];			
		}		
		return msg;		
	}
	
    /**
     * <pre>
     * <strong>Description:</strong> The method getPodcastCategory allows to display the categories of the podcast
	 * <strong>pre:</strong> NA
	 * <strong>pos:</strong> NA
     * @return msg <strong>String</strong> Message with the podcast categories 
     * </pre>
     */
	public String getPodcastCategory() {		
		String msg = "";		
		PodcastCategory[] podcastCategory = PodcastCategory.values();		
		for (int i = 0; i < podcastCategory.length; i++) {			
			msg += "\n[" + (i+1) + "]" + podcastCategory[i];			
		}		
		return msg;		
	}
	
    /**
     * <pre>
     * <strong>Description:</strong> The method getPlaylistType allows to display the types of the playlist
	 * <strong>pre:</strong> NA
	 * <strong>pos:</strong> NA
     * @return msg <strong>String</strong> Message with the playlist types 
     * </pre>
     */
	public String getPlaylistType() {		
		String msg = "";		
		PlaylistType[] playlistType = PlaylistType.values();		
		for (int i = 0; i < playlistType.length; i++) {			
			msg += "\n[" + (i+1) + "]" + playlistType[i];			
		}		
		return msg;		
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The convertToSec method allows to convert duration in seconds
	 * <strong>pre:</strong> NA
	 * <strong>pos:</strong> NA
	 * @param min <strong>int</strong> Time in mins
	 * @param sec <strong>int</strong> Time in seconds
     * @return totalSec <strong>int</strong> Duration in seconds
	 * </pre>
	 */
	public int convertToSec(int min, int sec) {	
		int totalSec; 		
		totalSec = (min * 60) + sec;		
		return totalSec;		
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The convertToSec method allows to convert duration in seconds
	 * <strong>pre:</strong> NA
	 * <strong>pos:</strong> NA
	 * @param hour <strong>int</strong> Time in hours
	 * @param min <strong>int</strong> Time in mins
	 * @param sec <strong>int</strong> Time in seconds
     * @return totalSec <strong>int</strong> Duration in seconds
	 * </pre>
	 */
	public int convertToSec(int hour, int min, int sec) {		
		int totalSec; 		
		totalSec = (hour * 3600) + (min * 60) + sec;		
		return totalSec;		
	}
	
	// SEARCH METHODS
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method searchUser allows to check if the user name is registered in the system
	 * <strong>pre:</strong> userList must be initialized
	 * <strong>pos:</strong> NA
	 * @param nameUser <strong>String</strong> User name
	 * @return user <strong>User</strong> User that match the name
	 * </pre>
	 */
    public User searchUser(String nameUser){
		User user = null; 
		boolean isFound = false; 
		for (int i = 0; i < userList.size() && !isFound; i++) {
			if (userList.get(i).getNameUser().equalsIgnoreCase(nameUser)) {
				user = userList.get(i); 
				isFound = true; 
			}
		}
		return user; 
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method searchAudio allows to check if the audio name is registered in the system
	 * <strong>pre:</strong> audioList must be initialized
	 * <strong>pos:</strong> NA
	 * @param nameAudio <strong>String</strong> Audio name
	 * @return audio <strong>Audio</strong> Audio that match the name
	 * </pre>
	 */
	public Audio searchAudio(String nameAudio){
        Audio audio = null;
        boolean isFound = false;
         for (int i = 0; i < audioList.size() && !isFound; i++){
            if (audioList.get(i).getNameAudio().equalsIgnoreCase(nameAudio)) {
                audio = audioList.get(i);
                isFound = true;
            }
         }   
        return audio;
    }

	// REGISTER METHODS
    
	/**
	 * <pre>
	 * <strong>Description:</strong> The method registerProducerUser allows to register producer user to the system
	 * <strong>pre:</strong> userList must be initialized
	 * <strong>pos:</strong> User is registered
	 * @param optProducer <strong>int</strong> Type of producer user
	 * @param nameUser <strong>String</strong> User name
	 * @param identificationNumber <strong>String</strong> User identification number
	 * @param year <strong>String</strong> User registration date	 
	 * @param month <strong>String</strong> User registration date
	 * @param day <strong>String</strong> User registration date
	 * @param photoURL <strong>String</strong> Url of the user's photo
	 * @return msg <strong>String</strong> Information on the result of the process
	 * </pre>
	*/
    public String registerProducerUser(int optProducer, String nameUser, String identificationNumber, int year, int month, int day, String photoURL) {
	
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
					return "Content creator registered successfully";
				}
			default:
				return "Error, user couldn't be registered";
			}
		}
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method registerBuyerUser allows to register buyer user to the system
	 * <strong>pre:</strong> userList must be initialized
	 * <strong>pos:</strong> User is registered
	 * @param optBuyer <strong>int</strong> Type of buyer user
	 * @param nameUser <strong>String</strong> User name
	 * @param identificationNumber <strong>String</strong> User identification number
	 * @param year <strong>String</strong> User registration date	 
	 * @param month <strong>String</strong> User registration date
	 * @param day <strong>String</strong> User registration date
	 * @return msg <strong>String</strong> Information on the result of the process
	 * </pre>
	*/
	public String registerBuyerUser(int optBuyer, String nameUser, String identificationNumber, int year, int month, int day) {
		
		if (searchUser(nameUser) != null) { 
			return "Error, user name not available";
		} else {
			switch (optBuyer) {
			case 1:
				if (userList.add(new Standard(nameUser, identificationNumber, new Date(year, month, day)))) {
					return "Standard user registered successfully";
				}
			case 2:
				if (userList.add(new Premium(nameUser, identificationNumber, new Date(year, month, day)))) {
					return "Premium user registered successfully";
				}
			default:
				return "Error, user couldn't be registered";
			}
		}
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method registerSong allows to register song to the system
	 * <strong>pre:</strong> audioList must be initialized
	 * <strong>pos:</strong> Song is registered
	 * @param nameArtist <strong>String</strong> Name of the artist producing the song
	 * @param nameSong <strong>String</strong> Song name
	 * @param album <strong>String</strong> Song album
	 * @param genreType <strong>int</strong> Type of song genre
	 * @param url <strong>String</strong> Url of the song's photo
	 * @param duration <strong>String</strong> Duration of the song
	 * @param saleValue <strong>double</strong> Sales value of the song
	 * @return msg <strong>String</strong> Information on the result of the process
	 * </pre>
	*/
	public String registerSong(String nameSong, String album, int genreType, String url, int duration, double saleValue, String nameArtist) {

		User user = searchUser(nameArtist);
		if (user == null) {
			return "Error, user doesn't exist";
		} else {
			if (user instanceof Artist) {
				Producer producer = (Producer) user; // Downcasting of User to Producer
				Audio song = searchAudio(nameSong);
				if (song != null) {
					return "Error, song name not available";
				} else {		
					Song newSong = new Song(nameSong, album, genreType, url, duration, saleValue);
					producer.addAudio(newSong);		
					audioList.add(newSong);			
					return "Song registered successfully";
				}
			} else {
				return "User is not an artist";
			}
		}
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method registerPodcast allows to register podcast to the system
	 * <strong>pre:</strong> audioList must be initialized
	 * <strong>pos:</strong> Podcast is registered
	 * @param nameContentCreator <strong>String</strong> Name of the content creator producing the podcast
	 * @param namePodcast <strong>String</strong> Podcast name
	 * @param description <strong>String</strong> Podcast description
	 * @param podcastCategory <strong>int</strong> Podcast category
	 * @param url <strong>String</strong> Url of the podcast's photo
	 * @param duration <strong>String</strong> Duration of the podcast
	 * @return msg <strong>String</strong> Information on the result of the process
	 * </pre>
	*/
	public String registerPodcast(String namePodcast, String description, int podcastCategory, String url, int duration, String nameContentCreator) {

		User user = searchUser(nameContentCreator);
		if (user == null) {
			return "Error, user doesn't exist";
		} else {
			if (user instanceof ContentCreator) {
				Producer producer = (Producer) user; // Downcasting of User to Producer
				Audio podcast = searchAudio(namePodcast);
				if (podcast != null) {
					return "Error, podcast name not available";
				} else {
					Podcast newPodcast = new Podcast(namePodcast, description, podcastCategory, url, duration);
					producer.addAudio(newPodcast);		
					audioList.add(newPodcast);    
					return "Podcast registered successfully";
				}
			} else {
				return "User is not an content creator";
			}
		}
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method createPlaylist allows to create a playlist in the system
	 * <strong>pre:</strong> userList must be initialized and have at least one buyer user
	 * <strong>pre:</strong> globalPlaylist must be initialized
	 * <strong>pos:</strong> Playlist is registered and added to an user
	 * @param nameUser <strong>String</strong> Name of the user who is going to create the playlist
	 * @param namePlaylist <strong>String</strong> Playlist name
	 * @param playlistType <strong>int</strong> Playlist type
	 * @param matrix <strong>int[][]</strong> Playlist matrix
	 * @param idPlaylist <strong>String</strong> Playlist identifier code 
	 * @return msg <strong>String</strong> Information on the result of the process
	 * </pre>
	 */
	public String createPlaylist(String nameUser, String namePlaylist, int playlistType, int[][] matrix, String idPlaylist) {
		
		String msg = "Error, playlist couldn't be registered";
		User user = searchUser(nameUser);
		if (user == null) {
			msg = "Error, user doesn't exist";
		} else {
			if (user instanceof Buyer) {
				Buyer buyer = (Buyer) user; // Downcasting of User to Buyer
				if (buyer.searchPlaylist(namePlaylist) != null) {
					msg = "Error, playlist name not available";
				} else {
					Playlist newPlaylist = new Playlist(namePlaylist, playlistType, matrix, idPlaylist);
					if (buyer.addPlaylist(newPlaylist)) {
						globalPlaylist.add(newPlaylist);
						msg = "Playlist registered successfully";
					}
				}
			}
		}
		return msg;
	}
	
	// METHODS FOR PLAYLIST'S MATRIX
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method generateMatrix allows to generate a matrix
	 * <strong>pre:</strong> NA
	 * <strong>pos:</strong> NA
	 * @return newMatrix <strong>int[]</strong> Generated Matrix
	 * </pre>
	 */
	public int[][] generateMatrix() {
		
		int[][] newMatrix = new int[6][6];
		for (int i = 0; i < newMatrix.length; i++) {	
			for (int j = 0; j < newMatrix[i].length; j++) {		
				newMatrix[i][j] = random.nextInt(10);				
			}				
		}		
		return newMatrix;		
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method printMatrix allows to print a matrix
	 * <strong>pre:</strong> NA
	 * <strong>pos:</strong> NA
	 * @param matrix <strong>int[][]</strong> Generated Matrix
	 * @return msg <strong>String</strong> Message containing the matrix generated
	 * </pre>
	 */
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
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method generateCodeN allows to generate the playlist identifier code for song-only playlists
	 * <strong>pre:</strong> NA
	 * <strong>pos:</strong> NA
	 * @param matrix <strong>int[][]</strong> Generated Matrix
	 * @return msg <strong>String</strong> Message containing identifier code 
	 * </pre>
	 */
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
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method generateCodeT allows to generate the playlist identifier code for podcast-only playlists
	 * <strong>pre:</strong> NA
	 * <strong>pos:</strong> NA
	 * @param matrix <strong>int[][]</strong> Generated Matrix
	 * @return msg <strong>String</strong> Message containing identifier code 
	 * </pre>
	 */
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
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method generateCodeStaggered allows to generate the playlist identifier code for song and podcast playlists
	 * <strong>pre:</strong> NA
	 * <strong>pos:</strong> NA
	 * @param matrix <strong>int[][]</strong> Generated Matrix
	 * @return msg <strong>String</strong> Message containing identifier code 
	 * </pre>
	 */
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
	
	// PLAYLIST METHODS
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method renamePlaylist allows to modify a playlist's name
	 * <strong>pre:</strong> userList must be initialized and have at least one buyer user
	 * <strong>pre:</strong> globalPlaylist must be initialized and have at least one playlist
	 * <strong>pos:</strong> Name of the playlist is changed
	 * @param nameUser <strong>String</strong> Name of the user who created the playlist
	 * @param namePlaylist <strong>String</strong> Playlist name
	 * @param newNamePlaylist <strong>String</strong> New playlist name
	 * @return msg <strong>String</strong> Information on the result of the process
	 * </pre>
	*/
	public String renamePlaylist(String nameUser, String namePlaylist, String newNamePlaylist) {
		
		String msg = "";
		User user = searchUser(nameUser);
		if (user == null) {
			msg = "Error, user doesn't exist";
		} else {
			if (user instanceof Buyer) {
				Buyer buyer = (Buyer) user; // Downcasting of User to Buyer
				Playlist playlist = buyer.searchPlaylist(namePlaylist);
				if (playlist == null) {
					msg = "Error, playlist not available";
				} else {
					playlist.setNamePlaylist(newNamePlaylist);
					msg = "Playlist's name update"; 
				}
			} else {
				msg = "User is not an buyer user";
			}
		}
		return msg;
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method addAudioToPlaylist allows to add an audio to a playlist
	 * <strong>pre:</strong> userList must be initialized and have at least one buyer user
	 * <strong>pre:</strong> audioList must be initialized and have at least one audio
	 * <strong>pre:</strong> globalPlaylist must be initialized and have at least one playlist
	 * <strong>pos:</strong> Audio is added
	 * @param nameUser <strong>String</strong> Name of the user who created the playlist
	 * @param namePlaylist <strong>String</strong> Playlist name
	 * @param nameAudioToAdd <strong>String</strong> Name of the audio to be added
	 * @return msg <strong>String</strong> Information on the result of the process
	 * </pre>
	*/
	public String addAudioToPlaylist(String nameUser, String namePlaylist, String nameAudioToAdd) {
		
		String msg = "Error, audio couldn't be added";
		User user = searchUser(nameUser);
		Audio audio = searchAudio(nameAudioToAdd);
		if (user == null) {
			msg = "Error, user doesn't exist";
		} else if (audio == null) {
			msg = "Error, audio doesn't exist";
		} else {
			if (user instanceof Buyer) {
				Buyer buyer = (Buyer) user; // Downcasting of User to Buyer	
				Playlist playlist = buyer.searchPlaylist(namePlaylist);
				if (playlist == null) {
					msg = "Error, playlist not available";
				} else {
					if (playlist.getPlaylistType() == PlaylistType.values()[0] && audio instanceof Song) {
						if (playlist.searchAudio(nameAudioToAdd) != null) {
							msg = "Error, audio had already been added";
						} else {
							if (playlist.addAudio(audio)) {
								msg = "Audio added successfully";
							}
						}
					} else if (playlist.getPlaylistType() == PlaylistType.values()[1] && audio instanceof Podcast) {
						if (playlist.searchAudio(nameAudioToAdd) != null) {
							msg = "Error, audio had already been added";
						} else {
							if (playlist.addAudio(audio)) {
								msg = "Audio added successfully";
							}
						}
					} else if (playlist.getPlaylistType() == PlaylistType.values()[2]) {
						if (playlist.searchAudio(nameAudioToAdd) != null) {
							msg = "Error, audio had already been added";
						} else {
							if (playlist.addAudio(audio)) {
								msg = "Audio added successfully";
							}
						}
					}
				}	
			} else {
				msg = "User is not an buyer user";
			}
		}
		return msg;	
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method removeAudioOfPlaylist allows to remove an audio of a playlist
	 * <strong>pre:</strong> userList must be initialized and have at least one buyer user
	 * <strong>pre:</strong> audioList must be initialized and have at least one audio
	 * <strong>pre:</strong> globalPlaylist must be initialized and have at least one playlist
	 * <strong>pos:</strong> Audio is removed
	 * @param nameUser <strong>String</strong> Name of the user who created the playlist
	 * @param namePlaylist <strong>String</strong> Playlist name
	 * @param nameAudioToRemove <strong>String</strong> Name of the audio to be removed
	 * @return msg <strong>String</strong> Information on the result of the process
	 * </pre>
	*/
	public String removeAudioOfPlaylist(String nameUser, String namePlaylist, String nameAudioToRemove) {
		
		String msg = "";
		User user = searchUser(nameUser);
		if (user == null) {
			msg = "Error, user doesn't exist";
		} else {
			if (user instanceof Buyer) {
				Buyer buyer = (Buyer) user; // Downcasting of User to Buyer
				Playlist playlist = buyer.searchPlaylist(namePlaylist);
				if (playlist == null) {
					msg = "Error, playlist not available";
				} else {
					Audio audio = playlist.searchAudio(nameAudioToRemove);
					if (audio == null) {
						msg = "Error, audio is not in the playlist";
					} else {
						if (playlist.searchAudio(nameAudioToRemove) != null) {
							if (playlist.removeAudio(audio)) {
								msg = "Audio playlist's remove";
							}
						}
					}
				}
			} else {
				msg = "User is not an buyer user";
			}
		}
		return msg;
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method sharePlaylist allows to share the playlist of a user
	 * <strong>pre:</strong> userList must be initialized and have at least one buyer user
	 * <strong>pre:</strong> globalPlaylist must be initialized and have at least one playlist
	 * <strong>pos:</strong> Playlist is shared
	 * @param nameUser <strong>String</strong> Name of the user who created the playlist
	 * @param namePlaylist <strong>String</strong> Playlist name
	 * @return msg <strong>String</strong> Information on the result of the process
	 * </pre>
	*/
	public String sharePlaylist(String nameUser, String namePlaylist) {
		
		String msg = "";
		User user = searchUser(nameUser);
		if (user == null) {
			msg = "Error, user doesn't exist";
		} else {
			if (user instanceof Buyer) {
				Buyer buyer = (Buyer) user; // Downcasting of User to Buyer
				Playlist playlist = buyer.searchPlaylist(namePlaylist);
				if (playlist == null) {
					msg = "Error, playlist not found";
				} else {
					msg = printMatrix(playlist.getMatrix()) + "Playlist's code is: " + playlist.getIdPlayList();
				}	
			} else {
				msg = "User is not an buyer user";
			}
		}		
		return msg;
	}
	
	// INTERACTION USER
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method playAudio allows to simulate the playback of a song or podcast
	 * <strong>pre:</strong> userList must be initialized and have at least one buyer user
	 * <strong>pre:</strong> audioList must be initialized and have at least one audio
	 * <strong>pos:</strong> Audio is played
	 * @param nameUser <strong>String</strong> User name
	 * @param nameAudio <strong>String</strong> Audio name
	 * @return msg <strong>String</strong> Information on the result of the process
	 * </pre>
	*/
	public String playAudio(String nameUser, String nameAudio) {
		
		String msg = "";
		User user = searchUser(nameUser);
		Audio audio = searchAudio(nameAudio);
		if (user == null) {
			msg = "Error, user doesn't exist";
		} else if (audio == null) {
			msg = "Error, audio doesn't exist";
		} else {
			if (user instanceof Buyer) {
				if (user instanceof Standard) {
					Standard standard = (Standard) user; // Downcasting of User to Standard
					msg = standard.play(audio);
					if (msg != null) {
						updateState(audio);					
					} else {
						msg = "Error, user has not bought the song";
					}
				} else if (user instanceof Premium) {
					Premium premium = (Premium) user; // Downcasting of User to Premium
					msg = premium.play(audio);
					if (msg != null) {
						updateState(audio);
					} else {
						msg = "Error, user has not bought the song";
					}
				}
			} else {
				msg = "User is not an buyer user";
			}
		}
		return msg;
	}

	/**
	 * <pre>
	 * <strong>Description:</strong> The method updateState allows to update producer and audio attributes
	 * <strong>pre:</strong> NA
	 * <strong>pos:</strong> All attributes are updated
	 * @param audio <strong>Audio</strong> Object audio
	 * </pre>
	 */
	public void updateState(Audio audio) {
	    
		if(audio instanceof Song){
			Song song = (Song) audio; // Downcasting of Audio to Song
	        boolean stopFlag = false;
	        for (int i = 0; i < userList.size() && !stopFlag; i++) {
	        	if (userList.get(i) instanceof Artist) {
	                Artist artist = (Artist) userList.get(i);
	                for (int j = 0; j < artist.getSongs().size() && !stopFlag; j++) {
		                if (artist.getSongs().get(j).equals(audio)) {
		                	artist.setTotalViews(1);
		                    artist.setTotalTimePlayed(song.getDuration());
		                    audio.setNumberPlays(1);
		                    stopFlag = true;
		                }
	                }
	            }
	        }
		} else if (audio instanceof Podcast) {
			Podcast podcast = (Podcast) audio; // Downcasting of Audio to Podcast
	        boolean stopFlag = false;
	        for (int i = 0; i < userList.size() && !stopFlag; i++) {
	        	if (userList.get(i) instanceof ContentCreator) {
	        		ContentCreator contentCreator = (ContentCreator) userList.get(i);
	                for (int j = 0; j < contentCreator.getPodcasts().size() && !stopFlag; j++) {
		                if (contentCreator.getPodcasts().get(j).equals(podcast)) {
		                	contentCreator.setTotalViews(1);
		                	contentCreator.setTotalTimePlayed(podcast.getDuration());
		                    audio.setNumberPlays(1);
		                    stopFlag = true;
		                }
	                }
	            }
	        }	
		}
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method buySong allows to buy a song from a buyer user
	 * <strong>pre:</strong> userList must be initialized and have at least one buyer user
	 * <strong>pre:</strong> audioList must be initialized and have at least one audio
	 * <strong>pos:</strong> Audio is buyed
	 * @param nameUser <strong>String</strong> User's name that will buy the song
	 * @param nameSong <strong>String</strong> Name of the song to buy
	 * @return msg <strong>String</strong> Information on the result of the process
	 * </pre>
	*/
	public String buySong(String nameUser, String nameSong) {
		
		String msg = "Error, song couldn't be buyed";
		User user = searchUser(nameUser);
		Audio audio = searchAudio(nameSong);
		if (user == null) {
			msg = "Error, user doesn't exist";
		} else if (audio == null) {
			msg = "Error, song doesn't exist";
		} else {
			if (audio instanceof Song && user instanceof Buyer) {
				Buyer buyer = (Buyer) user; // Downcasting of User to Buyer
				Song song = (Song) audio; // Downcasting of Audio to Song
				if (buyer.searchSong(song)) {
					msg = "Error, song was previously purchased";
				} else {
					if (buyer.addSong(song)){
						song.setNumberTimesSold(1);	
						msg = "Song buyed successfully";
					}
				}
			}
		}
		return msg;
	}
	
	// STATISTICS
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method showTotalAccumulatedReproductions allows to generate a report of the total accumulated plays for the entire platform for each type of audio
	 * <strong>pre:</strong> audioList must be initialized and have at least one audio
	 * @param optAudio <strong>opt</strong> Action selected by the user
	 * @return msg <strong>String</strong> Information on the result of the process
	 * </pre>
	*/
	public int showTotalAccumulatedReproductions(int optAudio) {
		
		int totalReproductions = 0;
		switch(optAudio) {
		case 1:
			for (int i = 0; i < audioList.size(); i++) {
				if (audioList.get(i) instanceof Song) {
					totalReproductions += audioList.get(i).getNumberPlays();
				}
			}		
			break;
		case 2:
			for (int i = 0; i < audioList.size(); i++) {
				if (audioList.get(i) instanceof Podcast) {
					totalReproductions += audioList.get(i).getNumberPlays();
				}
			}	
			break;
		}
		return totalReproductions;
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method showMostPlayedSongGenre allows to generate a report showing the most listened song genre in the whole platform
	 * <strong>pre:</strong> audioList must be initialized and have at least one audio
	 * @return msg <strong>String</strong> Information on the result of the process
	 * </pre>
	*/
	public String showMostPlayedSongGenre() {
		
		String msg = "";
		int[] genreType = new int[4];
		for (int i = 0; i < audioList.size(); i++) {
			if (audioList.get(i) instanceof Song) {
				Song song = (Song) audioList.get(i);
				if (song.getGenreType().equals(GenreType.values()[0])) { // ROCK
					genreType[0] += song.getNumberPlays();
				} else if (song.getGenreType().equals(GenreType.values()[1])) { // POP
					genreType[1] += song.getNumberPlays();
				} else if (song.getGenreType().equals(GenreType.values()[2])) { // TRAP
					genreType[2] += song.getNumberPlays();
				} else if (song.getGenreType().equals(GenreType.values()[3])) { // HOUSE
					genreType[3] += song.getNumberPlays();
				}
			}
		}
		int max = 0;
        int pos = -1;
        for (int i = 0; i < genreType.length; i++) {
            if (genreType[i] > max) {
                max = genreType[i];
                pos = i;
            }
        }
        switch (pos) {
        case 0:
            msg = "The most listened genre is: Rock, with a total of " + max + " plays";
            break;
        case 1:
            msg = "The most listened genre is: Pop, with a total of " + max + " plays";
            break;
        case 2:
            msg = "The most listened genre is: Trap, with a total of " + max + " plays";
            break;
        case 3:
            msg = "The most listened genre is: House, with a total of " + max + " plays";
            break;
        }
		return msg;
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method showUserMostPlayedSongGenre allows to generate a report showing the most listened song genre by user
	 * <strong>pre:</strong> userList must be initialized and have at least one buyer user
	 * <strong>pre:</strong> audioList must be initialized and have at least one audio
	 * @param nameUser <strong>String</strong> User name
	 * @return msg <strong>String</strong> Information on the result of the process
	 * </pre>
	*/
	public String showUserMostPlayedSongGenre(String nameUser) {
		
		String msg = "";
		User user = searchUser(nameUser);
		int[] genreType = new int[4];
		if (user == null) {
			msg = "Error, user doesn't exist";
		}  else {
			if (user instanceof Buyer) {
				if (user instanceof Standard) {
					Standard standard = (Standard) user; // Downcasting of User to Standard
					for (int i = 0; i < standard.getPlayback().size(); i++) {
						if (standard.getPlayback().get(i) instanceof Song) {
							Song song = (Song) standard.getPlayback().get(i);
							if (song.getGenreType().equals(GenreType.values()[0])) { // ROCK
								genreType[0] += 1;
							} else if (song.getGenreType().equals(GenreType.values()[1])) { // POP
								genreType[1] += 1;
							} else if (song.getGenreType().equals(GenreType.values()[2])) { // TRAP
								genreType[2] += 1;
							} else if (song.getGenreType().equals(GenreType.values()[3])) { // HOUSE
								genreType[3] += 1;
							}
						}
					}
					int max = 0;
			        int pos = -1;
			        for (int i = 0; i < genreType.length; i++) {
			            if (genreType[i] > max) {
			                max = genreType[i];
			                pos = i;
			            }
			        }
			        switch (pos) {
			        case 0:
			            msg = "The most listened genre is: Rock, with a total of " + max + " plays";
			            break;
			        case 1:
			            msg = "The most listened genre is: Pop, with a total of " + max + " plays";
			            break;
			        case 2:
			            msg = "The most listened genre is: Trap, with a total of " + max + " plays";
			            break;
			        case 3:
			            msg = "The most listened genre is: House, with a total of " + max + " plays";
			            break;
			        }
				} else if (user instanceof Premium) {
					Premium premium = (Premium) user; // Downcasting of User to Premium
					for (int i = 0; i < premium.getPlayback().size(); i++) {
						if (premium.getPlayback().get(i) instanceof Song) {
							Song song = (Song) premium.getPlayback().get(i);
							if (song.getGenreType().equals(GenreType.values()[0])) { // ROCK
								genreType[0] += 1;
							} else if (song.getGenreType().equals(GenreType.values()[1])) { // POP
								genreType[1] += 1;
							} else if (song.getGenreType().equals(GenreType.values()[2])) { // TRAP
								genreType[2] += 1;
							} else if (song.getGenreType().equals(GenreType.values()[3])) { // HOUSE
								genreType[3] += 1;
							}
						}
					}
					int max = 0;
			        int pos = -1;
			        for (int i = 0; i < genreType.length; i++) {
			            if (genreType[i] > max) {
			                max = genreType[i];
			                pos = i;
			            }
			        }
			        switch (pos) {
			        case 0:
			            msg = "The most listened genre is: Rock, with a total of " + max + " plays";
			            break;
			        case 1:
			            msg = "The most listened genre is: Pop, with a total of " + max + " plays";
			            break;
			        case 2:
			            msg = "The most listened genre is: Trap, with a total of " + max + " plays";
			            break;
			        case 3:
			            msg = "The most listened genre is: House, with a total of " + max + " plays";
			            break;
			        }
				}
			} else {
				msg = "User is not an buyer user";
			}
		}	
		return msg;
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method showMostPlayedPodcastCategory allows to generate a report showing the most listened podcast category in platform
	 * <strong>pre:</strong> audioList must be initialized and have at least one audio
	 * @return msg <strong>String</strong> Information on the result of the process
	 * </pre>
	*/
	public String showMostPlayedPodcastCategory() {
		
		String msg = "";
		int[] podcastCategory = new int[4];
		for (int i = 0; i < audioList.size(); i++) {
			if (audioList.get(i) instanceof Podcast) {
				Podcast podcast = (Podcast) audioList.get(i);
				if (podcast.getPodcastCategory().equals(PodcastCategory.values()[0])) { // POLITICS
					podcastCategory[0] += podcast.getNumberPlays();
				} else if (podcast.getPodcastCategory().equals(PodcastCategory.values()[1])) { // ENTERTAINMENT
					podcastCategory[1] += podcast.getNumberPlays();
				} else if (podcast.getPodcastCategory().equals(PodcastCategory.values()[2])) { // VIDEOGAMES
					podcastCategory[2] += podcast.getNumberPlays();
				} else if (podcast.getPodcastCategory().equals(PodcastCategory.values()[3])) { // FASHION
					podcastCategory[3] += podcast.getNumberPlays();
				}
			}
		}
		int max = 0;
        int pos = -1;
        for (int i = 0; i < podcastCategory.length; i++) {
            if (podcastCategory[i] > max) {
                max = podcastCategory[i];
                pos = i;
            }
        }
        switch (pos) {
        case 0:
            msg = "The most listened category is: Politics, with a total of " + max + " plays";
            break;
        case 1:
            msg = "The most listened category is: Entertainment, with a total of " + max + " plays";
            break;
        case 2:
            msg = "The most listened category is: Videogames, with a total of " + max + " plays";
            break;
        case 3:
            msg = "The most listened category is: Fashion, with a total of " + max + " plays";
            break;
        }
		return msg;
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method showUserMostPlayedPodcastCategory allows to generate a report showing the most listened podcast category per user
	 * <strong>pre:</strong> userList must be initialized and have at least one buyer user
	 * <strong>pre:</strong> audioList must be initialized and have at least one audio
	 * @param nameUser <strong>String</strong> User name
	 * @return msg <strong>String</strong> Information on the result of the process
	 * </pre>
	*/
	public String showUserMostPlayedPodcastCategory(String nameUser) {
		
		String msg = "";
		User user = searchUser(nameUser);
		int[] podcastCategory = new int[4];
		if (user == null) {
			msg = "Error, user doesn't exist";
		}  else {
			if (user instanceof Buyer) {
				if (user instanceof Standard) {
					Standard standard = (Standard) user; // Downcasting of User to Standard
					for (int i = 0; i < standard.getPlayback().size(); i++) {
						if (standard.getPlayback().get(i) instanceof Podcast) {
							Podcast podcast = (Podcast) standard.getPlayback().get(i);
							if (podcast.getPodcastCategory().equals(PodcastCategory.values()[0])) { // POLITICS
								podcastCategory[0] += 1;
							} else if (podcast.getPodcastCategory().equals(PodcastCategory.values()[1])) { // ENTERTAINMENT
								podcastCategory[1] += 1;
							} else if (podcast.getPodcastCategory().equals(PodcastCategory.values()[2])) { // VIDEOGAMES
								podcastCategory[2] += 1;
							} else if (podcast.getPodcastCategory().equals(PodcastCategory.values()[3])) { // FASHION
								podcastCategory[3] += 1;
							}
						}
					}
					int max = 0;
			        int pos = -1;
			        for (int i = 0; i < podcastCategory.length; i++) {
			            if (podcastCategory[i] > max) {
			                max = podcastCategory[i];
			                pos = i;
			            }
			        }
			        switch (pos) {
			        case 0:
			            msg = "The most listened category is: Politics, with a total of " + max + " plays";
			            break;
			        case 1:
			            msg = "The most listened category is: Entertainment, with a total of " + max + " plays";
			            break;
			        case 2:
			            msg = "The most listened category is: Videogames, with a total of " + max + " plays";
			            break;
			        case 3:
			            msg = "The most listened category is: Fashion, with a total of " + max + " plays";
			            break;
			        }
				} else if (user instanceof Premium) {
					Premium premium = (Premium) user; // Downcasting of User to Premium
					for (int i = 0; i < premium.getPlayback().size(); i++) {
						if (premium.getPlayback().get(i) instanceof Podcast) {
							Podcast podcast = (Podcast) premium.getPlayback().get(i);
							if (podcast.getPodcastCategory().equals(PodcastCategory.values()[0])) { // POLITICS
								podcastCategory[0] += 1;
							} else if (podcast.getPodcastCategory().equals(PodcastCategory.values()[1])) { // ENTERTAINMENT
								podcastCategory[1] += 1;
							} else if (podcast.getPodcastCategory().equals(PodcastCategory.values()[2])) { // VIDEOGAMES
								podcastCategory[2] += 1;
							} else if (podcast.getPodcastCategory().equals(PodcastCategory.values()[3])) { // FASHION
								podcastCategory[3] += 1;
							}
						}
					}
					int max = 0;
			        int pos = -1;
			        for (int i = 0; i < podcastCategory.length; i++) {
			            if (podcastCategory[i] > max) {
			                max = podcastCategory[i];
			                pos = i;
			            }
			        }
			        switch (pos) {
			        case 0:
			            msg = "The most listened category is: Politics, with a total of " + max + " plays";
			            break;
			        case 1:
			            msg = "The most listened category is: Entertainment, with a total of " + max + " plays";
			            break;
			        case 2:
			            msg = "The most listened category is: Videogames, with a total of " + max + " plays";
			            break;
			        case 3:
			            msg = "The most listened category is: Fashion, with a total of " + max + " plays";
			            break;
			        }
				}
			} else {
				msg = "User is not an buyer user";
			}
		}	
		return msg;
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method bubbleSort allows to sort the array descending
	 * <strong>pre:</strong> array must be initialized
	 * <strong>pos:</strong> Sort the array descending
	 * @param array <strong>int[]</strong> Array to sort
	 * </pre>
	*/
    public void bubbleSort (int[] array) {
        for (int i = 0; i < array.length; i++) {      	
            for (int j = 0; j < array.length - 1; j++) {           	
                int currentItem = array[j],
                	nextItem = array[j + 1];             
                if (currentItem < nextItem) {
                	array[j] = nextItem;
                	array[j + 1] = currentItem;                
                }                
            }            
        }       
    }
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method isRepeated allows to check if the element is already inside the array
	 * <strong>pre:</strong> array must be initialized
	 * <strong>pos:</strong> Determine if the element is already inside the array
	 * @param array <strong>int[]</strong> Array for save the elements without repeated
	 * @param aux <strong>int</strong> Aux to search
	 * @return stopFlag <strong>boolean</strong> Flag to know if the process was successful or not
	 * </pre>
	*/
    public boolean isRepeated(int[] array, int aux) {
		boolean stopFlag = false;
		for (int i = 0; i < array.length; i++) {	
			if (array[i] == aux) {		
				return stopFlag = true;		
			}
		}
		return stopFlag;		
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method showTopArtist allows to show the top 5 artists
	 * <strong>pre:</strong> userList must be initialized and have at least one buyer user
	 * @return msg <strong>String</strong> Information on the result of the process
	 * </pre>
	*/
	public String showTopArtist() {
		
		ArrayList<Artist> artistsGlobal = new ArrayList<Artist>();
		int[] artistsGlobalPlayed = new int[userList.size()], artistsGlobalPlayedWithoutRepeated = new int[userList.size()];
		int count = 0, playedAux = 0, k = 0, top = 0;
		String msg = "";
		//Loop to fill array
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i) instanceof Artist) {
				Artist artist = (Artist) userList.get(i);
				if (artist.getTotalViews() != 0) {
					artistsGlobal.add(artist); // Fill array artist
					artistsGlobalPlayed[i] = artist.getTotalViews(); //Fill array global	
				}
			}
		}
		//Bubble sort from largest to smallest
		bubbleSort(artistsGlobalPlayed);
		//Loop to remove duplicate elements
		for (int i = 0; i < artistsGlobalPlayed.length; i++) {
			playedAux = artistsGlobalPlayed[i];		
			if  (!isRepeated(artistsGlobalPlayedWithoutRepeated, playedAux)) {			
				artistsGlobalPlayedWithoutRepeated[k] = playedAux;
				k++;			
			}
		}
		//Loop to compare and determine the podium
		for (int i = 0; i < artistsGlobalPlayedWithoutRepeated.length; i++) {	
			for (int j = 0; j < artistsGlobal.size(); j++) {		
				if (count < 5) {								
					if (artistsGlobal.get(j).getTotalViews() == artistsGlobalPlayedWithoutRepeated[i]) {											
						msg += "\n" + (top+1) + ". " + artistsGlobal.get(j).getNameUser() + "          " + artistsGlobal.get(j).getTotalViews();
						count++;
						top++;					
					}							
				}						
			}			
		}			
		return msg;
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method showTopContentCreator allows to show the top 5 content creators
	 * <strong>pre:</strong> userList must be initialized and have at least one buyer user
	 * @return msg <strong>String</strong> Information on the result of the process
	 * </pre>
	*/
	public String showTopContentCreator() {
		
		ArrayList<ContentCreator> contentCreatorsGlobal = new ArrayList<ContentCreator>();
		int[] contentCreatorsGlobalPlayed = new int[userList.size()], contentCreatorsGlobalPlayedWithoutRepeated = new int[userList.size()];
		int count = 0, playedAux = 0, k = 0, top = 0;
		String msg = "";
		//Loop to fill array
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i) instanceof ContentCreator) {
				ContentCreator contentCreator = (ContentCreator) userList.get(i);
				if (contentCreator.getTotalViews() != 0) {
					contentCreatorsGlobal.add(contentCreator); // Fill array artist
					contentCreatorsGlobalPlayed[i] = contentCreator.getTotalViews(); //Fill array global	
				}
			}
		}
		//Bubble sort from largest to smallest
		bubbleSort(contentCreatorsGlobalPlayed);
		//Loop to remove duplicate elements
		for (int i = 0; i < contentCreatorsGlobalPlayed.length; i++) {
			playedAux = contentCreatorsGlobalPlayed[i];		
			if  (!isRepeated(contentCreatorsGlobalPlayedWithoutRepeated, playedAux)) {			
				contentCreatorsGlobalPlayedWithoutRepeated[k] = playedAux;
				k++;			
			}
		}
		//Loop to compare and determine the podium
		for (int i = 0; i < contentCreatorsGlobalPlayedWithoutRepeated.length; i++) {	
			for (int j = 0; j < contentCreatorsGlobal.size(); j++) {		
				if (count < 5) {								
					if (contentCreatorsGlobal.get(j).getTotalViews() == contentCreatorsGlobalPlayedWithoutRepeated[i]) {											
						msg += "\n" + (top+1) + ". " + contentCreatorsGlobal.get(j).getNameUser() + "          " + contentCreatorsGlobal.get(j).getTotalViews();
						count++;
						top++;					
					}							
				}						
			}			
		}			
		return msg;
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method showTopSong allows to show the top 10 songs
	 * <strong>pre:</strong> audioList must be initialized and have at least one audio
	 * @return msg <strong>String</strong> Information on the result of the process
	 * </pre>
	*/
	public String showTopSong() {
		
		ArrayList<Song> songsGlobal = new ArrayList<Song>();
		int[] songsGlobalPlayed = new int[userList.size()], songsGlobalPlayedWithoutRepeated = new int[userList.size()];
		int count = 0, playedAux = 0, k = 0, top = 0;
		String msg = "";
		//Loop to fill array
		for (int i = 0; i < audioList.size(); i++) {
			if (audioList.get(i) instanceof Song) {
				Song song = (Song) audioList.get(i);
				if (song.getNumberPlays() != 0) {
					songsGlobal.add(song); // Fill array artist
					songsGlobalPlayed[i] = song.getNumberPlays(); //Fill array global	
				}
			}
		}
		//Bubble sort from largest to smallest
		bubbleSort(songsGlobalPlayed);
		//Loop to remove duplicate elements
		for (int i = 0; i < songsGlobalPlayed.length; i++) {
			playedAux = songsGlobalPlayed[i];		
			if  (!isRepeated(songsGlobalPlayedWithoutRepeated, playedAux)) {			
				songsGlobalPlayedWithoutRepeated[k] = playedAux;
				k++;			
			}
		}
		//Loop to compare and determine the podium
		for (int i = 0; i < songsGlobalPlayedWithoutRepeated.length; i++) {	
			for (int j = 0; j < songsGlobal.size(); j++) {		
				if (count < 10) {								
					if (songsGlobal.get(j).getNumberPlays() == songsGlobalPlayedWithoutRepeated[i]) {											
						msg += "\n" + (top+1) + ". " + songsGlobal.get(j).getNameAudio() + "          " + songsGlobal.get(j).getGenreType() + "          " + songsGlobal.get(j).getNumberPlays();
						count++;
						top++;					
					}							
				}						
			}			
		}			
		return msg;
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method showTopPodcast allows to show the top 10 podcasts
	 * <strong>pre:</strong> audioList must be initialized and have at least one audio
	 * @return msg <strong>String</strong> Information on the result of the process
	 * </pre>
	*/
	public String showTopPodcast() {
		
		ArrayList<Podcast> podcastsGlobal = new ArrayList<Podcast>();
		int[] podcastsGlobalPlayed = new int[userList.size()], podcastsGlobalPlayedWithoutRepeated = new int[userList.size()];
		int count = 0, playedAux = 0, k = 0, top = 0;
		String msg = "";
		//Loop to fill array
		for (int i = 0; i < audioList.size(); i++) {
			if (audioList.get(i) instanceof Podcast) {
				Podcast podcast = (Podcast) audioList.get(i);
				if (podcast.getNumberPlays() != 0) {
					podcastsGlobal.add(podcast); // Fill array artist
					podcastsGlobalPlayed[i] = podcast.getNumberPlays(); //Fill array global	
				}
			}
		}
		//Bubble sort from largest to smallest
		bubbleSort(podcastsGlobalPlayed);
		//Loop to remove duplicate elements
		for (int i = 0; i < podcastsGlobalPlayed.length; i++) {
			playedAux = podcastsGlobalPlayed[i];		
			if  (!isRepeated(podcastsGlobalPlayedWithoutRepeated, playedAux)) {			
				podcastsGlobalPlayedWithoutRepeated[k] = playedAux;
				k++;			
			}
		}
		//Loop to compare and determine the podium
		for (int i = 0; i < podcastsGlobalPlayedWithoutRepeated.length; i++) {	
			for (int j = 0; j < podcastsGlobal.size(); j++) {		
				if (count < 10) {								
					if (podcastsGlobal.get(j).getNumberPlays() == podcastsGlobalPlayedWithoutRepeated[i]) {											
						msg += "\n" + (top+1) + ". " + podcastsGlobal.get(j).getNameAudio() + "          " + podcastsGlobal.get(j).getPodcastCategory() + "          " + podcastsGlobal.get(j).getNumberPlays();
						count++;
						top++;					
					}							
				}						
			}			
		}			
		return msg;
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method showInfoByGenreSong allows to generate a report showing the number of songs sold and the total sales value for each genre
	 * <strong>pre:</strong> audioList must be initialized and have at least one audio
	 * @param genreType <strong>int</strong> Type of song genre
	 * @return msg <strong>String</strong> Information on the result of the process
	 * </pre>
	*/
	public String showInfoByGenreSong(int genreType) {
		
		int amountSales = 0;
		double sellTotalValue = 0;
		for (int i = 0; i < audioList.size(); i++) {
			if (audioList.get(i) instanceof Song) {
				Song song = (Song) audioList.get(i);
				if (song.getGenreType().equals(GenreType.values()[genreType])) {
					amountSales += song.getNumberTimesSold();
					sellTotalValue += (song.getNumberTimesSold()*song.getSaleValue());
				}
			}
		}
		return "The number of songs sold is " + amountSales + " and total sales value $" + sellTotalValue;
	}
	
	/**
	 * <pre>
	 * <strong>Description:</strong> The method showBestSellerSong allows to generate a report of the best-selling song on the platform
	 * <strong>pre:</strong> audioList must be initialized and have at least one audio
	 * @return msg <strong>String</strong> Information on the result of the process
	 * </pre>
	*/
	public String showBestSellerSong() {
		
		String msg = "Error, no songs have been sold";
	    Song max = null;
	    for (int i = 0; i < audioList.size(); i++) {
	    	if (audioList.get(i) instanceof Song) {
                Song song = (Song) audioList.get(i);
                if (max == null) {
                    max = song;
                }
                if (song.getNumberTimesSold() > max.getNumberTimesSold()) {
                    max = song;
                }
	    	}
	    }
        if (max != null) {
            if (max.getNumberTimesSold() > 0) {
                msg = "The best-selling song is " + max.getNameAudio() + " with " + max.getNumberTimesSold() + " sales and a collection of $" + (max.getNumberTimesSold()*max.getSaleValue() + " ");
            }
        }
		return msg;
	}

}
