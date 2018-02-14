package application;
import java.util.ArrayList;
import javafx.scene.media.*;

public class Player {
	private User currentUser;
	private Song currentSong;
	private Boolean playing;
	private Playlist currentPlaylist;
	private ArrayList<Song> allSongs;
	private ArrayList<User> allUsers;
	public DatabaseConnector dbconn;
	public MediaPlayer mplayer;
	public Media media;
	
	public Player(){
		this.setPlaying(false); 
		this.currentUser = new User("Administrator", "root", "root");
		this.allUsers = new ArrayList<User>();
		this.allUsers.add(this.currentUser);
//		this.currentUser.getAllSongs().add(
//				new Song("Don't Wanna Know", 
//						240, 
//						"Maroon 5", 
//						"C:\\DataBM\\Songs\\DWK.mp3", 
//						"Maroon 5", 
//						30.00, 
//						"C:\\DataBM\\Icons\\DWK.png"));
//		this.currentUser.getAllSongs().add(new Song("The Best Day of My Life"));
//		this.currentUser.getAllSongs().add(new Song("Demons"));
//		this.currentUser.getAllSongs().add(new Song("Apologize"));
//		this.currentUser.getAllSongs().add(new Song("Numb"));
//		this.currentUser.getAllSongs().add(new Song("In The End"));
//		this.currentUser.getAllSongs().add(new Song("Stitches"));
//		this.currentUser.getAllSongs().add(new Song("Sugar"));
//		this.currentUser.getAllSongs().add(new Song("Radioactive"));
		
		
	}
	
	public void init(){
		this.dbconnect();
//		this.currentUser.getAllSongs().get(0).setFile("src/resources/Dont_Wanna_Know.mp3");
		String in = getClass().getResource("/resources/Dont_Wanna_Know.mp3").toString();
		this.media = new Media(in);
		this.mplayer = new MediaPlayer(this.media);
		
	}
	
	public void dbconnect(){
		this.dbconn = new DatabaseConnector();
		this.setAllSongs(this.dbconn.getDbSongs());
		dbconn.printSongs(this.allSongs);
		for(Song s: this.allSongs){
			this.currentUser.getAllSongs().add(s);
		}
	}	
	public ArrayList<Song> getAllSongs() {
		return allSongs;
	}

	public void setAllSongs(ArrayList<Song> allSongs) {
		this.allSongs = allSongs;
	}
	
	public void addUser(User user){
		this.currentUser = user;
		this.allUsers.add(user);
	}
	
	public User getCurrentUser() {
		return currentUser;
	}
	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
	public Song getCurrentSong() {
		return currentSong;
	}
	public void setCurrentSong(Song currentSong) {
		this.currentSong = currentSong;
	}
	public Boolean getPlaying() {
		return playing;
	}
	public void setPlaying(Boolean playing) {
		this.playing = playing;
	}

	public Playlist getCurrentPlaylist() {
		return currentPlaylist;
	}
	public void setCurrentPlaylist(Playlist currentPlaylist) {
		this.currentPlaylist = currentPlaylist;
	}
	public ArrayList<User> getAllUsers() {
		return allUsers;
	}
	public void setAllUsers(ArrayList<User> allUsers) {
		this.allUsers = allUsers;
	}
	public void setMedia(Media media){
		this.media = media;
		this.mplayer = new MediaPlayer(media);
	}
}
