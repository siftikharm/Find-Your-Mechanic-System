package application.app;

import application.entity.Customer;
import application.service.CustomerService;
import application.service.CustomerServiceImp;
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

public class Controller_VehicleUserSignIn {
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

	private CustomerService service = new CustomerServiceImp();

	@FXML
	public void SignIn(ActionEvent event) throws Exception {

		String username = Username.getText();
		String password = Password.getText();

		Customer customer = service.customerLogin(username, password);
		ObjSingleton singleton = ObjSingleton.getInstance();

		if (customer != null) {
			singleton.setS(customer);
			BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("VehicleUserInterface.fxml"));
			Scene scene = new Scene(root, 600, 400);
			Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			primaryStage.resizableProperty().setValue(Boolean.FALSE);
			primaryStage.setScene(scene);
			primaryStage.show();
		} else
			Message.setText("Incorrect Password");

	}

	@FXML
	public void Back(ActionEvent event) throws Exception {
		BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("HomeScreen.fxml"));
		Scene scene = new Scene(root, 600, 400);
		Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		primaryStage.resizableProperty().setValue(Boolean.FALSE);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
