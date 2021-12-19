package application.app;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class DrivingInterface extends Application 
{
	@Override
	public void start(Stage primaryStage) throws IOException 
	{
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("HomeScreen.fxml"));
		Scene scene = new Scene(root, 600, 400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.resizableProperty().setValue(Boolean.FALSE);
		primaryStage.setScene(scene);
		primaryStage.show();		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
