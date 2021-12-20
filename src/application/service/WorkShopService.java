package application.service;

import java.util.ArrayList;

import application.entity.Feedback;
import application.entity.ServicesOffered;
import application.entity.Workshop;
import exceptionHandling.IncorrectFeedback;
import exceptionHandling.InvalidLoginCredentials;
import javafx.collections.ObservableList;

public interface WorkShopService {
	public void addServices(ServicesOffered service, String workShopID);// done

	public void provideWorkshopFeedback(String workShopID, Feedback feedback) throws IncorrectFeedback;// done

	public ObservableList<ServicesOffered> displayWorkshopServices(String workshopID);// done

	public boolean registerWorkshop(Workshop workshop, ArrayList<String> services);// done

	public Workshop workshopLogin(String username, String password) throws InvalidLoginCredentials;// done

	void removeServices(String workshopID, String service);// done

	ObservableList<Workshop> searchWorkshop(ArrayList<String> ser);// done
}
