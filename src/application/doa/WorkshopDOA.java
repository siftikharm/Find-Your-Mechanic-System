package application.doa;

import java.util.ArrayList;
import java.util.LinkedList;

import application.entity.Feedback;
import application.entity.ServicesOffered;
import application.entity.Workshop;
import javafx.collections.ObservableList;



public interface WorkshopDOA {
	public void addServices(ServicesOffered service);
	public void removeServices(int workshopID , ServicesOffered service);
	public void searchWorkshop(LinkedList<ServicesOffered> services , String carMake);
	public void provideWorkshopFeedback(Feedback feedback);
	public void displayWorkshopServices(int workshopID);
	public ArrayList<Workshop> getWorkshops();
	void registerWorkshop(Object object);
	public ObservableList<ServicesOffered> getServices(int workShopID);
	public void deleteServices(String service, int workShopID);
	public ArrayList<Feedback> getFeedbacks(int workShopID);
}
