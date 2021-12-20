package application.app;

import java.io.IOException;
import java.util.Scanner;


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
		int db=0;
		Scanner input = new Scanner(System.in);
		do {
	    	
	    	System.out.println("1. MySQL DataBase\n");
	    	System.out.println("2. File System\n");
	    	System.out.println("0. Exit\n");
	    	db = input.nextInt();
	    	input.nextLine();
		} while (db<0||db>2);
		input.close();
		DBSingleton singleton=DBSingleton.getInstance();
		if (db==1) {
			singleton.setS("mysql");
		}
		else if (db==2) {
			singleton.setS("file");
		}
		else {
			return;
		}
		launch(args);
	}
}
