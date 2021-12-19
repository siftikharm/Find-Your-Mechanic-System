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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Controller_VehicleUserSignUp
{
	@FXML
	private TextField Username;

	@FXML
	private TextField FullName;

	@FXML
	private TextField EmailAddress;
	
	@FXML
	private TextField PhoneNumber;
		
	@FXML
	private TextField Gender;
	
	@FXML
	private PasswordField Password;

	@FXML
	private PasswordField RetypedPassword;
		
	@FXML
	private Button Back;
	
	@FXML
	private Button SignUp;	
	private CustomerService service=new CustomerServiceImp();
	@FXML
	public void Back_Function(ActionEvent event) throws Exception
	{
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("HomeScreen.fxml"));
		Scene scene = new Scene(root, 600, 400);
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@FXML
	public void SignUp_Function(ActionEvent event) throws Exception
	{
		String username = Username.getText();
		String name = FullName.getText();
		String email = EmailAddress.getText();
		String phone = PhoneNumber.getText();
		String gender = Gender.getText();
		String password = Password.getText();
		String retypedpassword = RetypedPassword.getText();
		
		if(password.equals(retypedpassword))
		{	
			Customer customer = new Customer(name,phone,gender,email,username,password);
			service.registerCustomer(customer);
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("HomeScreen.fxml"));
			Scene scene = new Scene(root, 600, 400);
			Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.show();
			
		}
		
	}

}
