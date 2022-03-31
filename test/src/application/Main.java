package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;


public class Main extends Application {
	
	private static Stage newStage;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			newStage = primaryStage;
			Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
			
			primaryStage.setResizable(false);
			primaryStage.setTitle("Prison Management");
			
			Image icon = new Image("istockphoto-1310565161-612x612.jpg");
			primaryStage.getIcons().add(icon);
			
			//primaryStage.setFullScreen(true);
			//primaryStage.setFullScreenExitHint("YOU CAN'T ESCAPE unless you press esc");
			
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void changeScene(String abc) throws IOException{
		Parent pane = FXMLLoader.load(getClass().getResource(abc));
		newStage.getScene().setRoot(pane);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
