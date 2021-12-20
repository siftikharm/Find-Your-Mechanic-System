package application.app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Controller_HomeScreen {
	@FXML
	private Button VehicleUser_SignIn;

	@FXML
	private Button VehicleUser_SignUp;

	@FXML
	private Button WorkshopMechanic_SignIn;

	@FXML
	private Button WorkshopMechanic_SignUp;

	@FXML
	private Button Exit;

	@FXML
	public void VehicleUser_SignIn_Function(ActionEvent event) throws Exception {
		BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("VehicleUserSignIn.fxml"));
		Scene scene = new Scene(root, 600, 400);
		Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		primaryStage.resizableProperty().setValue(Boolean.FALSE);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	@FXML
	public void VehicleUser_SignUp_Function(ActionEvent event) throws Exception {
		BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("VehicleUserSignUp.fxml"));
		Scene scene = new Scene(root, 600, 400);
		Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		primaryStage.resizableProperty().setValue(Boolean.FALSE);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	@FXML
	public void MechanicWorkshop_SignIn_Function(ActionEvent event) throws Exception {
		BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("WorkshopMechanicSingIn.fxml"));
		Scene scene = new Scene(root, 600, 400);
		Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		primaryStage.resizableProperty().setValue(Boolean.FALSE);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	@FXML
	public void MechanicWorkshop_SignUp_Function(ActionEvent event) throws Exception {
		BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("MechanicSignUp.fxml"));
		Scene scene = new Scene(root, 600, 400);
		Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@FXML
	public void Exit_Function(ActionEvent event) throws Exception {
		BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("ExitScreen.fxml"));
		Scene scene = new Scene(root, 600, 400);
		Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
