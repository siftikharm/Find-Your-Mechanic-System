package application.doa;

import java.util.ArrayList;

import application.entity.Customer;
import application.entity.Vehicle;
import javafx.collections.ObservableList;

public interface CustomerDOA {
	public void registerCustomer(Object customer);
	public void addVehicle(Vehicle vehicle, Customer customer);
	public void removeVehicle(String vehicle , Customer customer);
	public void displayVehciles(String username);
	public ArrayList<Customer> getCustomers();
	public ObservableList<Vehicle> getVehiclesbyUsername(String username, Customer customer);
}
