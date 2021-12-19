package application.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Workshop {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int workShopID;
	private String workshopName;
	private String workshopAddress;
	private String contactNumber;
	private String username;
	private String password;
	private double ratings;
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER,mappedBy = "workshop")
	private Set<ServicesOffered> workshopServices;
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER,mappedBy = "workshop")
	private Set<Feedback> feedbacks;
	
	public Workshop() {
		workshopServices = new HashSet<ServicesOffered>();
		feedbacks = new HashSet<Feedback>();
	}
	

	public Workshop(String workshopName, String workshopAddress, String contactNumber, String username, String password,
			double ratings, Set<ServicesOffered> workshopServices, Set<Feedback> feedbacks) {
		this.workshopName = workshopName;
		this.workshopAddress = workshopAddress;
		this.contactNumber = contactNumber;
		this.username = username;
		this.password = password;
		this.ratings = ratings;
		this.workshopServices = workshopServices;
		this.feedbacks = feedbacks;
	}


	public int getWorkShopID() {
		return workShopID;
	}
	public void setWorkShopID(int workShopID) {
		this.workShopID = workShopID;
	}
	
	public double getRatings() {
		return ratings;
	}
	
	public void setRatings(double ratings) {
		this.ratings = ratings;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getWorkshopName() {
		return workshopName;
	}
	public void setWorkshopName(String workshopName) {
		this.workshopName = workshopName;
	}
	public String getWorkshopAddress() {
		return workshopAddress;
	}
	public void setWorkshopAddress(String workshopAddress) {
		this.workshopAddress = workshopAddress;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public Set<ServicesOffered> getWorkshopServices() {
		return workshopServices;
	}
	public void setWorkshopServices(Set<ServicesOffered> workshopServices) {
		this.workshopServices = workshopServices;
	}
	public Set<Feedback> getFeedbacks() {
		return feedbacks;
	}
	public void setFeedbacks(Set<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}
	
}
