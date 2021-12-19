package application.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Vehicle {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int vehicleID;
	private String name;
	private String model;
	private String make;
	private String plateNumber;
	@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private Customer customer;
	
	public Vehicle() {
	}
	

	public Vehicle(String name, String model, String make, String plateNumber) {
		super();
		this.name = name;
		this.model = model;
		this.make = make;
		this.plateNumber = plateNumber;
	}


	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public int getVehicleID() {
		return vehicleID;
	}
	public void setVehicleID(int vehicleID) {
		this.vehicleID = vehicleID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	
}
