package application.app;

import java.util.ArrayList;
import java.util.LinkedList;

import application.entity.Workshop;
import application.service.WorkShopService;
import application.service.WorkshopServiceImp;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Controller_WorkshopMechanicSignUp 
{
	Workshop workshop=new Workshop();
	private WorkShopService service=new WorkshopServiceImp();
	@FXML
	private TextField Username;

	@FXML
	private TextField FullName;

	@FXML
	private TextField PhoneNumber;
	
	@FXML
	private PasswordField Password;

	@FXML
	private PasswordField RetypedPassword;

	@FXML
	private TextField WorkshopName;
		
	@SuppressWarnings("unused")
	private String WorkshopAddress;
	
		@FXML
		private TextField WorkshopNumber;
	
		@FXML
		private TextField StreetNumber;
	
		@FXML
		private TextField DistrictArea;
	
		@FXML
		private TextField City;
		
		@FXML
		private TextField Country;	

	@SuppressWarnings("unused")
	private ArrayList<String> WorkshopServices = new ArrayList<String>();
	
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
		
	@SuppressWarnings("unused")
	private ArrayList<String> VehicleComapany = new ArrayList<String>();
	
		@FXML
		private CheckBox Toyota;
		
		@FXML
		private CheckBox Honda;
	
		@FXML
		private CheckBox Suzuki;
	
		@FXML
		private CheckBox BMW;
	
		@FXML
		private CheckBox Ford;
	
		@FXML
		private CheckBox Mercedes;
	
		@FXML
		private CheckBox Audi;
	
		@FXML
		private CheckBox KIA;
	
		@FXML
		private CheckBox Hyndai;
	
		@FXML
		private CheckBox Lexus;
	
		@FXML
		private CheckBox Nissan;
	
		@FXML
		private CheckBox Others;
	
	@FXML
	private Button SignUp;	
	
	@FXML
	private Button Next;

	@FXML
	private Button Back;
	
	public void vehicleCompanyCheckBox()
	{
		String checkBox = null;
		
		if(Toyota.isSelected())
		{	
			System.out.println("toyota");
			checkBox = Toyota.getText();
			VehicleComapany.add(checkBox);
		}

		if(Honda.isSelected())
		{	
			checkBox = Honda.getText();
			VehicleComapany.add(checkBox);
		}

		if(Suzuki.isSelected())
		{	
			checkBox = Suzuki.getText();
			VehicleComapany.add(checkBox);
		}

		if(BMW.isSelected())
		{	
			checkBox = BMW.getText();
			VehicleComapany.add(checkBox);
		}

		if(Ford.isSelected())
		{	
			checkBox = Ford.getText();
			VehicleComapany.add(checkBox);
		}

		if(Mercedes.isSelected())
		{	
			checkBox = Mercedes.getText();
			VehicleComapany.add(checkBox);
		}

		if(Audi.isSelected())
		{	
			checkBox = Audi.getText();
			VehicleComapany.add(checkBox);
		}

		if(Hyndai.isSelected())
		{	
			checkBox = Hyndai.getText();
			VehicleComapany.add(checkBox);
		}
		
		if(KIA.isSelected())
		{	
			checkBox = KIA.getText();
			VehicleComapany.add(checkBox);
		}

		if(Lexus.isSelected())
		{	
			checkBox = Lexus.getText();
			VehicleComapany.add(checkBox);
		}

		if(Nissan.isSelected())
		{	
			checkBox = Nissan.getText();
			VehicleComapany.add(checkBox);
		}

		if(Others.isSelected())
		{	
			checkBox = Others.getText();
			VehicleComapany.add(checkBox);
		}					
	}

	public void workshopServiceCheckBox()
	{
		String checkBox = null;
		
		if(BasicTuning.isSelected())
		{	
			checkBox = BasicTuning.getText();
			WorkshopServices.add(checkBox);
		}

		if(PowerTuning.isSelected())
		{	
			checkBox = PowerTuning.getText();
			WorkshopServices.add(checkBox);
		}

		if(VehicleInspection.isSelected())
		{	
			checkBox = VehicleInspection.getText();
			WorkshopServices.add(checkBox);
		}

		if(BrakeService.isSelected())
		{	
			checkBox = BrakeService.getText();
			WorkshopServices.add(checkBox);
		}

		if(HeadRepair.isSelected())
		{	
			checkBox = HeadRepair.getText();
			WorkshopServices.add(checkBox);
		}

		if(ClutchRepair.isSelected())
		{	
			checkBox = ClutchRepair.getText();
			WorkshopServices.add(checkBox);
		}

		if(PressurePlate.isSelected())
		{	
			checkBox = PressurePlate.getText();
			WorkshopServices.add(checkBox);
		}

		if(WheelAllignment.isSelected())
		{	
			checkBox = WheelAllignment.getText();
			WorkshopServices.add(checkBox);
		}
		
		if(TankCleaning.isSelected())
		{	
			checkBox = TankCleaning.getText();
			WorkshopServices.add(checkBox);
		}

		if(GasKitRepair.isSelected())
		{	
			checkBox = GasKitRepair.getText();
			WorkshopServices.add(checkBox);
		}

		if(RadiatorService.isSelected())
		{	
			checkBox = RadiatorService.getText();
			WorkshopServices.add(checkBox);
		}

		if(ElectricService.isSelected())
		{	
			checkBox = ElectricService.getText();
			WorkshopServices.add(checkBox);
		}

		if(FilterService.isSelected())
		{	
			checkBox = FilterService.getText();
			WorkshopServices.add(checkBox);
		}

		if(FuelPumpRepair.isSelected())
		{	
			checkBox = FuelPumpRepair.getText();
			WorkshopServices.add(checkBox);
		}

		if(ACService.isSelected())
		{	
			checkBox = ACService.getText();
			WorkshopServices.add(checkBox);
		}

		if(SuspentionService.isSelected())
		{	
			checkBox = SuspentionService.getText();
			WorkshopServices.add(checkBox);
		}		
	}
	
	@FXML
	public void Next(ActionEvent event) throws Exception
	{
		vehicleCompanyCheckBox();

		String username =  Username.getText();
		String name = FullName.getText();
		String phone = PhoneNumber.getText();
		String password = Password.getText();
		String retypedpassword = RetypedPassword.getText();
		workshop.setUsername(username);
		workshop.setContactNumber(phone);
		workshop.setPassword(retypedpassword);
		ObjSingleton singleton=ObjSingleton.getInstance();
		singleton.setS(workshop);
		if(Password.getText().equals(RetypedPassword.getText()))
		{
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("WorkshopSignUp.fxml"));
			Scene scene = new Scene(root, 600, 400);
			Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
			primaryStage.resizableProperty().setValue(Boolean.FALSE);
			primaryStage.setScene(scene);
			primaryStage.show();
		}
//			
	}

	@FXML
	public void SignUp(ActionEvent event) throws Exception
	{
		workshopServiceCheckBox();
		
		String name = WorkshopName.getText();
		String shopno = WorkshopNumber.getText();
		String streetno = StreetNumber.getText();
		String area = DistrictArea.getText();
		String city = City.getText();
		String country = Country.getText();
		
		WorkshopAddress = shopno + ", st "+ streetno + ", "+ area + ", "+ city;
		ObjSingleton singleton=ObjSingleton.getInstance();
		workshop=(Workshop) singleton.getS();
		workshop.setWorkshopName(name);
		workshop.setWorkshopAddress(WorkshopAddress);
		
		service.registerWorkshop(workshop, WorkshopServices);
//		service.registerWorkshop(, WorkshopServices)
//		System.out.println(workshop.getUsername());
//		}
		
		
		
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("HomeScreen.fxml"));
		Scene scene = new Scene(root, 600, 400);
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	@FXML
	public void Back(ActionEvent event) throws Exception
	{
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("HomeScreen.fxml"));
		Scene scene = new Scene(root, 600, 400);
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
