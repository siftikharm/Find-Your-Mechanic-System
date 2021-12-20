package application.service;

import java.util.ArrayList;

import application.app.DBSingleton;
import application.doa.CustomerDOA;
import application.doa.CustomerDOAImp;
import application.doa.CustomerFileImp;
import application.entity.Customer;
import application.entity.Vehicle;
import exceptionHandling.InvalidLoginCredentials;
import exceptionHandling.UserAlreadyExists;
import javafx.collections.ObservableList;


public class CustomerServiceImp implements CustomerService {
	
	private CustomerDOA customerDAO;
	
	public CustomerServiceImp() {
		DBSingleton singleton=DBSingleton.getInstance();
		if (singleton.getS().equals("mysql")) {
			customerDAO = new CustomerDOAImp();
		}
		else {
			customerDAO = new CustomerFileImp();
		}
		
	}
	
//	public  static CustomerDOA getInstance() {
//		return customerDAO;
//	}
	
	@Override
	public boolean registerCustomer(Customer customer) throws UserAlreadyExists {
		boolean flag = true;
		ArrayList<Customer> customers= customerDAO.getCustomers();
		for (int i = 0; i < customers.size(); i++) {
			if (customers.get(i).getUsername().equals(customer.getUsername())) {
				flag = false; 
			}
		}
		
		if(!flag) {
			throw new UserAlreadyExists("duplicate username found");
		}
		else {
			customerDAO.registerCustomer(customer);
		}
		return flag;
	}

	@Override
	public ObservableList<Vehicle> displayVehicles(String username) {
		
		ArrayList<Customer> customers=customerDAO.getCustomers();
		Customer customer=new Customer();
		for (int i = 0; i < customers.size(); i++) {
			if(customers.get(i).getUsername().equals(username)) {
				customer=customers.get(i);
			}
		}
		ObservableList<Vehicle> vehicles= customerDAO.getVehiclesbyUsername(username,customer);
		
		return vehicles;
	}

	@Override
	public void addVehicle(Vehicle vehicle,String username) {

		ArrayList<Customer> customers= customerDAO.getCustomers();
		Customer customer=new Customer();
		for (int i = 0; i < customers.size(); i++) {
			if (customers.get(i).getUsername().equals(username)) {
				customer=customers.get(i);
			}
		}
		ObservableList<Vehicle> vehicles= customerDAO.getVehiclesbyUsername(username, customer);
		for (int i = 0; i < vehicles.size(); i++) {
			if (vehicles.get(i).getPlateNumber().equals(vehicle.getPlateNumber())) {
				return;
			}
		}
		//		System.out.print(customer.getUsername());
		customerDAO.addVehicle(vehicle,customer);
//		customerDAO.registerCustomer(vehicle);
	}

	@Override
	public void removeVehicle(String customerID, String vehicle) {
		// TODO Auto-generated method stub
		ArrayList<Customer> customers= customerDAO.getCustomers();
		Customer customer=new Customer();
		for (int i = 0; i < customers.size(); i++) {
			if (customers.get(i).getUsername().equals(customerID)) {
				customer=customers.get(i);
			}
		}
		customerDAO.removeVehicle(vehicle,customer);
	}

	@Override
	public Customer customerLogin(String customerID, String password) throws InvalidLoginCredentials {
		ArrayList<Customer> customers= customerDAO.getCustomers();
		for (int i = 0; i < customers.size(); i++) {
			if(customers.get(i).getUsername().equals(customerID)&& customers.get(i).getPassword().equals(password)) {
				return customers.get(i);
			}
		}
		throw new InvalidLoginCredentials("User name or password incorrect");
		
	}

}
