package application.app;

import application.entity.Customer;
import application.entity.Workshop;
import application.service.WorkShopService;
import application.service.WorkshopServiceImp;
import exceptionHandling.InvalidLoginCredentials;
import exceptionHandling.UserAlreadyExists;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Controller_WorkshopMechanicSignIn 
{
	WorkShopService service=new WorkshopServiceImp();
	@FXML
	private TextField Username;

	@FXML
	private PasswordField Password;
	
	@FXML
	private Label Message;
	
	@FXML
	private Button SignIn;

	@FXML
	private Button Back;
	
	
	@FXML
	public void SignIn_Function(ActionEvent event) throws Exception
	{
		
		String username = Username.getText();
		String password = Password.getText();
		Workshop workshop=null;
		try {
			workshop=service.workshopLogin(username, password);
		} catch (InvalidLoginCredentials e) {
			// TODO: handle exception
		}
	
		if(workshop!=null) 
		{
		
			ObjSingleton sin=ObjSingleton.getInstance();
			sin.setS(workshop);
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("WorkshopMechanicInterface.fxml"));
			Scene scene = new Scene(root, 600, 400);
			Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
			primaryStage.resizableProperty().setValue(Boolean.FALSE);
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		else
	        Message.setText("Incorrect Password");   
	
	}
	
	@FXML
	public void Back_Function(ActionEvent event) throws Exception
	{
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("HomeScreen.fxml"));
		Scene scene = new Scene(root, 600, 400);
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
