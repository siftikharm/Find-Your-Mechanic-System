package application.app;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
		BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("HomeScreen.fxml"));
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

//public class Main /*extends Application*/ {
//	@Override
//	public void start(Stage primaryStage) {
//		try {
//			BorderPane root = new BorderPane();
//			Scene scene = new Scene(root,400,400);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			primaryStage.setScene(scene);
//			primaryStage.show();
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public static void main(String[] args) {
//		WorkShopService wService=new WorkshopServiceImp();
//		Workshop workshop = new Workshop();
//		workshop.setContactNumber("1234");
//		workshop.setPassword("1234");
//		workshop.setUsername("lgbtq");
//		workshop.setWorkshopAddress("G-11");
//		workshop.setWorkshopName("LGBTQ");
//		ArrayList<String> services=new ArrayList<>();
//		services.add("tyres");
//		services.add("Breaks");
//		WorkShopService wService=new WorkshopServiceImp();
//		Workshop workshop = new Workshop();
//		workshop.setContactNumber("1234");
//		workshop.setPassword("1234");
//		workshop.setUsername("aslamjanu");
//		workshop.setWorkshopAddress("G-12");
//		workshop.setWorkshopName("Aslam's Shop");
//		ArrayList<String> services=new ArrayList<>();
//		services.add("Power Tuning");
//		services.add("Clutch");
//		wService.registerWorkshop(workshop,services);
//		ServicesOffered servi=new ServicesOffered();
//		servi.setName("Clutch");
//		wService.removeServices(workshop.getUsername(),servi);
//		wService.registerWorkshop(workshop, services);
//		wService.addServices(servi, workshop.getUsername());
//		Feedback feedback=new Feedback();
//		feedback.setRating(4);
//		wService.provideWorkshopFeedback(workshop.getUsername(), feedback);
//		ArrayList<ServicesOffered> ser=wService.displayWorkshopServices(workshop.getUsername());
//		ArrayList<ServicesOffered> ser=new ArrayList<>();
//		
//		ser.add(servi);
//		ServicesOffered servi2=new ServicesOffered();
//		
//		servi2.setName("Gas Kit");
//		ser.add(servi2);
//		ArrayList<Workshop> w= wService.searchWorkshop(ser);
//		for (int i = 0; i < w.size(); i++) {
//			System.out.println(w.get(i).getUsername());
//		}
//		ArrayList<ServicesOffered> ser=wService.displayWorkshopServices(workshop.getUsername());
//		for (int i = 0; i < ser.size(); i++) {
//			System.out.println(ser.get(i).getName());
//			
//		}
// launch(args);
//		CustomerService service = new CustomerServiceImp();
//		Customer c = new Customer();
//		c.setfName("Hunaid");
//		c.setEmail("qwer");
//		c.setGender("male");
//		c.setlName("Mehdi");
//		c.setPassword("1234");
//		c.setUsername("hunaid");
//		c.setVehicles();

//		Vehicle vehcile = new Vehicle("Prius" , "2020" , "Changan");
//		vehcile.setPlateNumber("ISB-2021");
//		c.saveVechicle(vehcile);
//		c.getVehicles().add(vehcile);
//	
//		ArrayList<Vehicle> v=service.displayVehicles("hunaid");
//		for (int i = 0; i < v.size(); i++) {
//			System.out.println(v.get(i).getName());
//		}
//		service.addVehicle(vehcile,c.getUsername());
//		service.registerCustomer(c);
//		System.out.println(service.customerLogin("hunaid", "1234"));
//		service.removeVehicle("hunaid", vehcile);
//	}
//}
