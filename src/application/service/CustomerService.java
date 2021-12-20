package application.service;

import application.entity.Customer;
import application.entity.Vehicle;
import exceptionHandling.InvalidLoginCredentials;
import exceptionHandling.UserAlreadyExists;
import javafx.collections.ObservableList;


public interface CustomerService {
	public boolean registerCustomer(Customer customer) throws UserAlreadyExists;//done
	public ObservableList<Vehicle> displayVehicles(String username);//done
	public void addVehicle(Vehicle vehicle, String string);//done
	public void removeVehicle(String customerID , String vehicle);//done
	public Customer customerLogin(String customerID , String password) throws InvalidLoginCredentials;//done
}
