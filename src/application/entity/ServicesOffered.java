package application.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ServicesOffered {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int serviceID;
	private String name;
	private String description;
	private int charges;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Workshop workshop;

	public ServicesOffered() {
		// TODO Auto-generated constructor stub
	}

	public ServicesOffered(String name, String description, int charges) {
		super();
		this.name = name;
		this.description = description;
		this.charges = charges;
	}

	public Workshop getWorkshop() {
		return workshop;
	}

	public void setWorkshop(Workshop workshop) {
		this.workshop = workshop;
	}

	public int getServiceID() {
		return serviceID;
	}

	public void setServiceID(int serviceID) {
		this.serviceID = serviceID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCharges() {
		return charges;
	}

	public void setCharges(int charges) {
		this.charges = charges;
	}

}
