package application.app;

import java.util.ArrayList;

import application.entity.Customer;
import application.entity.Feedback;
import application.entity.Vehicle;
import application.entity.Workshop;
import application.service.CustomerService;
import application.service.CustomerServiceImp;
import application.service.WorkShopService;
import application.service.WorkshopServiceImp;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Controller_VehicleUserInterface {

	private CustomerService service = new CustomerServiceImp();
	private WorkShopService wService = new WorkshopServiceImp();
	@FXML
	private GridPane searchGrid;
	@FXML
	private TextField deleteRegister;
	@FXML
	private Tab Tab_UserProfile;
	ObjSingleton singleton = ObjSingleton.getInstance();
	@FXML
	private Label Username;

	@FXML
	private Label FullName;

	@FXML
	private Label Gender;

	@FXML
	private Label EmailAddress;

	@FXML
	private Label PhoneNumber;

	@FXML
	private Label AccountType;

	@FXML
	private Tab Tab_VehicleProfile;

	@FXML
	private Tab Tab_SearchWorkshop;

	private ArrayList<String> WorkshopServices = new ArrayList<String>();

	@FXML
	private TextField serviceCharges;

	@FXML
	private CheckBox BasicTuning;

	@FXML
	private CheckBox PowerTuning;

	@FXML
	private CheckBox VehicleInspection;

	@FXML
	private CheckBox BrakeService;

	@FXML
	private CheckBox HeadRepair;

	@FXML
	private CheckBox EngineRepair;

	@FXML
	private CheckBox ClutchRepair;

	@FXML
	private CheckBox PressurePlate;

	@FXML
	private CheckBox WheelAllignment;

	@FXML
	private CheckBox TankCleaning;

	@FXML
	private CheckBox GasKitRepair;
	@FXML
	private GridPane vehicleGrid;
	@FXML
	private CheckBox RadiatorService;

	@FXML
	private CheckBox ElectricService;

	@FXML
	private CheckBox FilterService;

	@FXML
	private CheckBox FuelPumpRepair;

	@FXML
	private CheckBox ACService;

	@FXML
	private CheckBox SuspentionService;

	@FXML
	private Button Search;

	public void workshopServiceCheckBox() {
		String checkBox = null;

		if (BasicTuning.isSelected()) {
			checkBox = BasicTuning.getText();
			WorkshopServices.add(checkBox);
		}

		if (PowerTuning.isSelected()) {
			checkBox = PowerTuning.getText();
			WorkshopServices.add(checkBox);
		}

		if (VehicleInspection.isSelected()) {
			checkBox = VehicleInspection.getText();
			WorkshopServices.add(checkBox);
		}

		if (BrakeService.isSelected()) {
			checkBox = BrakeService.getText();
			WorkshopServices.add(checkBox);
		}

		if (HeadRepair.isSelected()) {
			checkBox = HeadRepair.getText();
			WorkshopServices.add(checkBox);
		}

		if (ClutchRepair.isSelected()) {
			checkBox = ClutchRepair.getText();
			WorkshopServices.add(checkBox);
		}

		if (PressurePlate.isSelected()) {
			checkBox = PressurePlate.getText();
			WorkshopServices.add(checkBox);
		}

		if (WheelAllignment.isSelected()) {
			checkBox = WheelAllignment.getText();
			WorkshopServices.add(checkBox);
		}

		if (TankCleaning.isSelected()) {
			checkBox = TankCleaning.getText();
			WorkshopServices.add(checkBox);
		}

		if (GasKitRepair.isSelected()) {
			checkBox = GasKitRepair.getText();
			WorkshopServices.add(checkBox);
		}

		if (RadiatorService.isSelected()) {
			checkBox = RadiatorService.getText();
			WorkshopServices.add(checkBox);
		}

		if (ElectricService.isSelected()) {
			checkBox = ElectricService.getText();
			WorkshopServices.add(checkBox);
		}

		if (FilterService.isSelected()) {
			checkBox = FilterService.getText();
			WorkshopServices.add(checkBox);
		}

		if (FuelPumpRepair.isSelected()) {
			checkBox = FuelPumpRepair.getText();
			WorkshopServices.add(checkBox);
		}

		if (ACService.isSelected()) {
			checkBox = ACService.getText();
			WorkshopServices.add(checkBox);
		}

		if (SuspentionService.isSelected()) {
			checkBox = SuspentionService.getText();
			WorkshopServices.add(checkBox);
		}
	}

	@FXML
	private Tab Tab_Settings;

	@FXML
	private Tab Tab_UserProfileSettings;

	@FXML
	private TextField NewName;

	@FXML
	private TextField NewEmail;

	@FXML
	private TextField NewPhone;

	@FXML
	private TextField NewGender;

	@FXML
	private Button UserProfileSave;

	@FXML
	private Tab Tab_ManageVehicles;

	@FXML
	private Tab Tab_AddVehicle;

	@FXML
	private TextField VehicleName;

	@FXML
	private TextField VehicleModel;

	@FXML
	private TextField VehicleCompany;

	@FXML
	private TextField VehicleLicensePlate;

	@FXML
	private Button AddVehicle;

	@FXML
	private Tab Tab_RemoveVehicle;

	@FXML
	private Button DeleteVehicle;

	@FXML
	private Tab Tab_SecuritySettings;
	@FXML
	private TableColumn<Vehicle, String> vName;
	@FXML
	private TableColumn<Vehicle, String> vRegNo;
	@FXML
	private TableColumn<Vehicle, String> vModel;
	@FXML
	private TableView<Vehicle> regTable;
	@FXML
	private TableColumn<Vehicle, String> vMake;
	@FXML
	private PasswordField OldPassword;

	@FXML
	private PasswordField NewPassword;

	@FXML
	private PasswordField NewRetypedPassword;
	@FXML
	private TableView<Workshop> table;
	@FXML
	private TableColumn<Workshop, String> tableAddr;

	@FXML
	private TableColumn<Workshop, String> tableRatings;
	@FXML
	private TableColumn<Workshop, String> tableID;
	@FXML
	private TableColumn<Workshop, String> tableName;
	@FXML
	private Button SecuritySave;

	@FXML
	private Button Logout;

	@FXML
	private TextField feedBackRatings;
	@FXML
	private TextArea feedbackComents;
	@FXML
	private Tab Tab_FeedBack;
	@FXML
	private TextField feedBackwork;

	public void initialize() {
		Customer cus = (Customer) singleton.getS();

		Username.setText(cus.getUsername());
		FullName.setText(cus.getName());
		Gender.setText(cus.getGender());
		EmailAddress.setText(cus.getEmail());
		PhoneNumber.setText(cus.getPhNo());
		AccountType.setText("Vehicle Account");
		ObservableList<Vehicle> workshops = service.displayVehicles(cus.getUsername());
		vName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
		vMake.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMake()));
		vModel.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getModel()));
		vRegNo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPlateNumber()));
		regTable.setItems(workshops);

	}

	@FXML
	void feedback(ActionEvent event) {
		Feedback feedback = new Feedback();
		try {
			feedback.setRating(Integer.parseInt(feedBackRatings.getText()));
			feedback.setComments(feedbackComents.getText());
			wService.provideWorkshopFeedback(feedBackwork.getText(), feedback);
		} catch (Exception e) {

		} finally {
			feedbackComents.setText("");
			feedBackRatings.setText("");
			feedBackwork.setText("");
		}
	}

	@FXML
	public void SearchWorkshop(ActionEvent event) throws Exception {
		for (int i = 0; i < table.getItems().size(); i++) {
			table.getItems().clear();
		}
		workshopServiceCheckBox();
		ObservableList<Workshop> workshops = wService.searchWorkshop(WorkshopServices);
		tableID.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUsername()));
		tableName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getWorkshopName()));
		tableAddr.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getWorkshopAddress()));
		tableRatings.setCellValueFactory(
				cellData -> new SimpleStringProperty(Double.toString(cellData.getValue().getRatings())));
		table.setItems(workshops);
		WorkshopServices.clear();

	}

	@FXML
	public void AddVehicle(ActionEvent event) throws Exception {
		Customer cus = (Customer) singleton.getS();

		String vehicleName = VehicleName.getText();
		String vehicleModel = VehicleModel.getText();
		String vehicleCompany = VehicleCompany.getText();
		String vehiclePlate = VehicleLicensePlate.getText();
		Vehicle vehicle = new Vehicle(vehicleName, vehicleModel, vehicleCompany, vehiclePlate);
		service.addVehicle(vehicle, cus.getUsername());
		VehicleName.setText("");
		VehicleModel.setText("");
		VehicleCompany.setText("");
		VehicleLicensePlate.setText("");
	}

	@FXML
	public void DeleteVehicle(ActionEvent event) throws Exception {
		Customer cus = (Customer) singleton.getS();

		service.removeVehicle(cus.getUsername(), deleteRegister.getText());
		deleteRegister.setText("");
	}

	@FXML
	public void UserProfileSave(ActionEvent event) throws Exception {

	}

	@FXML
	public void SecuritySave(ActionEvent event) throws Exception {

	}

	@FXML
	public void Logout(ActionEvent event) throws Exception {
		BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("HomeScreen.fxml"));
		Scene scene = new Scene(root, 600, 400);
		Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		primaryStage.resizableProperty().setValue(Boolean.FALSE);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}