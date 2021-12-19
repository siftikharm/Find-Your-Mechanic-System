package application.app;

import java.util.ArrayList;

import application.entity.ServicesOffered;
import application.entity.Vehicle;
import application.entity.Workshop;
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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Controller_WorkshopMechanicInterface 
{
	private WorkShopService service=new WorkshopServiceImp();
	@FXML
    private TextField delServiceName;

	@FXML
	private TextField VehicleLicense;
	@FXML
    private TextField serviceDesc;
	@FXML
    private TextField serviceName;
    @FXML
    private GridPane serviceGrid;
    @FXML
    private TextField serviceCharges;
	@FXML
	private Tab Tab_MechanicProfile;
	
		@FXML
		private Label Username;

		@FXML
		private Label FullName;

		@FXML
		private Label PhoneNumber;
		@FXML
	    private TableColumn<ServicesOffered, String> wDesc;
		@FXML
	    private TableView<ServicesOffered> wTable;
		@FXML
	    private TableColumn<ServicesOffered, String> wName;
		@FXML
	    private TableColumn<ServicesOffered, String> wCharges;
	@FXML
	private Tab Tab_WorkshopProfile;

		@FXML
		private Label WorkshopName;

//		@FXML
//		private Label WorkshopNumber;

//		@FXML
//		private Label StreetNumber;

//		@FXML
//		private Label DistrictArea;
//		
//		@FXML
//		private Label ProvinceCity;
		
		@FXML
		private Label CountryRegion;
		
	@FXML
	private Tab Tab_WorkshopServices;
	
	@FXML
	private Tab Tab_Settings;
	
		@FXML
		private Tab Tab_MechanicProfileSettings;
			
			@FXML
			private TextField NewProfileName;

			@FXML
			private TextField NewProfilePhone;
			
			@FXML
			private Button ProfileSave;

		@FXML
		private Tab Tab_WorkshopProfileSettings;
		
			@FXML
			private TextField NewWorkshopName;
	
			@FXML
			private TextField NewWorkshopNumber;
			
			@FXML
			private TextField NewStreetNumber;

			@FXML
			private TextField NewArea;

			@FXML
			private TextField NewCity;

			@FXML
			private TextField NewCountry;
			
			@FXML
			private Button WorkshopSave;

		@FXML
		private Tab Tab_ManageServices;
		
			@FXML
			private Button AddService;

			@FXML
			private Button DeleteService;
		
		@FXML
		private Tab Tab_SecuritySettings;
		
			@FXML
			private PasswordField OldPassword;

			@FXML
			private PasswordField NewPassword;

			@FXML
			private PasswordField RetypeNewPassword;
			
			@FXML
			private Button SecuritySave;
		
		@FXML
		private Button Logout;
			
	
	@FXML
	public void ProfileSave(ActionEvent event) 
	{
			
	}
	

	@FXML
	public void WorkshopSave(ActionEvent event) 
	{
			
	}

	@FXML
	public void SecuritySave(ActionEvent event) 
	{
			
	}
	
	@FXML
	public void AddWorkshopService(ActionEvent event) 
	{
			
	}

	@FXML
	public void RemoveWorkshopService(ActionEvent event) 
	{
		ObjSingleton singleton=ObjSingleton.getInstance();
		Workshop cus=(Workshop) singleton.getS();
//		ServicesOffered ser=new ServicesOffered(serviceName.getText(), serviceDesc.getText(), Integer.parseInt(serviceCharges.getText()));
//		Username.setText(cus.getUsername());
//		FullName.setText(cus.getWorkshopName());
		service.removeServices(cus.getUsername(), delServiceName.getText());
		delServiceName.setText("");
	}
	public void initialize()
	{
		ObjSingleton singleton=ObjSingleton.getInstance();
		Workshop cus=(Workshop) singleton.getS();

		Username.setText(cus.getUsername());
		FullName.setText(cus.getWorkshopName());
		
		PhoneNumber.setText(cus.getContactNumber());
		CountryRegion.setText(cus.getWorkshopAddress());
		WorkshopName.setText(cus.getWorkshopName());
		
		ObservableList<ServicesOffered> workshops=service.displayWorkshopServices(cus.getUsername());
//		for (int i = 0; i < workshops.size(); i++) {
//
//            Text btn = new Text();
//            btn.setText(workshops.get(i).getName());
//            serviceGrid.add(btn, 0, i); // Text is added to next row every time.
//
//        }
		wName.setCellValueFactory(cellData->	new SimpleStringProperty(cellData.getValue().getName()));
		wDesc.setCellValueFactory(cellData->	new SimpleStringProperty(cellData.getValue().getDescription()));
		wCharges.setCellValueFactory(cellData->	new SimpleStringProperty(Integer.toString(cellData.getValue().getCharges())));
		wTable.setItems(workshops);
		
	}
	@FXML
    void addService(ActionEvent event) {
		ObjSingleton singleton=ObjSingleton.getInstance();
		Workshop cus=(Workshop) singleton.getS();
		ServicesOffered ser=new ServicesOffered(serviceName.getText(), serviceDesc.getText(), Integer.parseInt(serviceCharges.getText()));
//		Username.setText(cus.getUsername());
//		FullName.setText(cus.getWorkshopName());
		service.addServices(ser, cus.getUsername());
		serviceName.setText("");
		serviceCharges.setText("");
		serviceDesc.setText("");
//		PhoneNumber.setText(cus.getContactNumber());
//		CountryRegion.setText(cus.getWorkshopAddress());
//		WorkshopName.setText(cus.getWorkshopName());
    }
	@FXML
	public void Logout(ActionEvent event) throws Exception
	{
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("HomeScreen.fxml"));
		Scene scene = new Scene(root, 600, 400);
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
	}	
}
