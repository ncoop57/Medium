package application;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.*;

public class View extends Application{
	private Stage window;
	private Parent root;
	private Scene scene;
	private Player player;
	private FXMLLoader loader;
	
	public static void main(String[] args){
		launch(args);
	}
	
	public void start(Stage primaryStage) throws Exception{

		window = primaryStage;
		loader = new FXMLLoader();
		root = loader.load(getClass().getResource("/resources/login.fxml").openStream());
		LoginController loginCont = (LoginController)loader.getController();
		loginCont.setPlayer(player);
		System.out.println("Debugging");
		scene = new Scene(root, 800, 600);		
		window.setScene(scene);
//		window.setOpacity(0.95);
		window.show();
	}
	
}
