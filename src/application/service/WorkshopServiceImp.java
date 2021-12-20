package application.service;

import java.util.ArrayList;
import java.util.Iterator;

import application.app.DBSingleton;
import application.doa.WorkShopDOAImp;
import application.doa.WorkshopDOA;
import application.doa.WorkshopFileImp;
import application.entity.Feedback;
import application.entity.ServicesOffered;
import application.entity.Workshop;
import exceptionHandling.IncorrectFeedback;
import exceptionHandling.InvalidLoginCredentials;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class WorkshopServiceImp implements WorkShopService {
	private WorkshopDOA workshopDAO;

	public WorkshopServiceImp() {
		// TODO Auto-generated constructor stub
		DBSingleton singleton = DBSingleton.getInstance();
		if (singleton.getS().equals("mysql")) {
			workshopDAO = new WorkShopDOAImp();
		} else {
			workshopDAO = new WorkshopFileImp();
		}
	}

	@Override
	public void addServices(ServicesOffered service, String workshopID) {
		// TODO Auto-generated method stub
		ArrayList<Workshop> workshops = workshopDAO.getWorkshops();
		Workshop workshop = new Workshop();
		for (int i = 0; i < workshops.size(); i++) {
			if (workshops.get(i).getUsername().equals(workshopID)) {
				workshop = workshops.get(i);
			}
		}
		ObservableList<ServicesOffered> services = workshopDAO.getServices(workshop.getWorkShopID());
		for (int i = 0; i < services.size(); i++) {
			if (services.get(i).getName().equals(service.getName())) {
				return;
			}
		}
		service.setWorkshop(workshop);
		workshopDAO.addServices(service);
	}

	@Override
	public boolean registerWorkshop(Workshop workshop, ArrayList<String> services) {
		// TODO Auto-generated method stub
		ArrayList<Workshop> workshops = workshopDAO.getWorkshops();
		for (int i = 0; i < workshops.size(); i++) {
			if (workshops.get(i).getUsername().equals(workshop.getUsername())) {
				return false;
			}
		}

		workshopDAO.registerWorkshop(workshop);
		if (services != null) {
			for (int i = 0; i < services.size(); i++) {
				ServicesOffered service = new ServicesOffered();
				service.setName(services.get(i));
				service.setCharges(0);
				service.setDescription("");
				service.setWorkshop(workshop);
				service.setServiceID(workshop.getWorkShopID());
				addServices(service, workshop.getUsername());
			}
		}

		return true;
	}

	@Override
	public Workshop workshopLogin(String username, String password) throws InvalidLoginCredentials {
		// TODO Auto-generated method stub
		boolean found = false;
		ArrayList<Workshop> workshops = workshopDAO.getWorkshops();
		for (int i = 0; i < workshops.size(); i++) {
			if (workshops.get(i).getUsername().equals(username) && workshops.get(i).getPassword().equals(password)) {
				found = true;
				return workshops.get(i);
			}
		}

		if (!found) {
			throw new InvalidLoginCredentials("User name or password incorrect");
		}
		return null;
	}

	@Override
	public void removeServices(String workshopID, String service) {
		ArrayList<Workshop> workshops = workshopDAO.getWorkshops();
		Workshop workshop = new Workshop();
		for (int i = 0; i < workshops.size(); i++) {
			if (workshops.get(i).getUsername().equals(workshopID)) {
				workshop = workshops.get(i);
			}
		}
		workshopDAO.deleteServices(service, workshop.getWorkShopID());
	}

	@SuppressWarnings({ "unused", "rawtypes" })
	@Override
	public ObservableList<Workshop> searchWorkshop(ArrayList<String> services) {
		ArrayList<Workshop> workshops = workshopDAO.getWorkshops();
		ObservableList<Workshop> res = FXCollections.observableArrayList();
		Workshop workshop = new Workshop();
		for (int i = 0; i < workshops.size(); i++) {
			ArrayList<ServicesOffered> ser = new ArrayList<>();
			for (Iterator iterator = workshops.get(i).getWorkshopServices().iterator(); iterator.hasNext();) {
				ser.add((ServicesOffered) iterator.next());
			}
			boolean flag = false;
			for (int j = 0; j < ser.size(); j++) {
				for (int k = 0; k < services.size(); k++) {
					if (ser.get(j).getName().equals(services.get(k))) {
						flag = true;
					}
				}
			}
			int count = 0;
			double total = 0;
			ArrayList<Feedback> feedbacks = workshopDAO.getFeedbacks(workshops.get(i).getWorkShopID());
			for (int j = 0; j < feedbacks.size(); j++) {
				count++;
				total += feedbacks.get(j).getRating();
			}
			workshops.get(i).setRatings(total / count);
			if (flag) {
				res.add(workshops.get(i));
			}

		}
		return res;
	}

	@Override
	public void provideWorkshopFeedback(String workShopID, Feedback feedback) throws IncorrectFeedback {
		// TODO Auto-generated method stub
		if (feedback.getRating() > 5 || feedback.getRating() < 0) {
			throw new IncorrectFeedback("Rating 1 - 5");
		}
		ArrayList<Workshop> workshops = workshopDAO.getWorkshops();
		Workshop workshop = new Workshop();
		for (int i = 0; i < workshops.size(); i++) {
			if (workshops.get(i).getUsername().equals(workShopID)) {
				workshop = workshops.get(i);
			}
		}

		feedback.setWorkshop(workshop);
		workshopDAO.provideWorkshopFeedback(feedback);
	}

	@Override
	public ObservableList<ServicesOffered> displayWorkshopServices(String workshopID) {
		ArrayList<Workshop> workshops = workshopDAO.getWorkshops();
		Workshop workshop = new Workshop();
		for (int i = 0; i < workshops.size(); i++) {
			if (workshops.get(i).getUsername().equals(workshopID)) {
				workshop = workshops.get(i);
			}
		}
		ObservableList<ServicesOffered> services = workshopDAO.getServices(workshop.getWorkShopID());
		return services;
	}

}
