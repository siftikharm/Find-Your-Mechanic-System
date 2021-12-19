package application.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import application.doa.CustomerDOA;
import application.doa.CustomerDOAImp;
import application.doa.WorkShopDOAImp;
import application.doa.WorkshopDOA;
import application.entity.Customer;
import application.entity.Feedback;
import application.entity.ServicesOffered;
import application.entity.Workshop;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



public class WorkshopServiceImp implements WorkShopService {
	private WorkshopDOA workshopDAO = new WorkShopDOAImp();
	@Override
	public void addServices(ServicesOffered service,String workshopID) {
		// TODO Auto-generated method stub
		ArrayList<Workshop> workshops= workshopDAO.getWorkshops();
		Workshop workshop=new Workshop();
		for (int i = 0; i < workshops.size(); i++) {
			if (workshops.get(i).getUsername().equals(workshopID)) {
				workshop=workshops.get(i);	
			}
		}
		ObservableList<ServicesOffered> services=workshopDAO.getServices(workshop.getWorkShopID());
		for (int i = 0; i < services.size(); i++) {
			if (services.get(i).getName().equals(service.getName())) {
				return;
			}
		}
//		System.out.println(workshop.getWorkShopID());
		service.setWorkshop(workshop);
		workshopDAO.addServices(service);
	}

	@Override
	public boolean registerWorkshop(Workshop workshop,ArrayList<String> services) {
		// TODO Auto-generated method stub
		ArrayList<Workshop> workshops= workshopDAO.getWorkshops();
		for (int i = 0; i < workshops.size(); i++) {
			if (workshops.get(i).getUsername().equals(workshop.getUsername())) {
				return false; 
			}
		}
		
		workshopDAO.registerWorkshop(workshop);
		for (int i = 0; i < services.size(); i++) {
			ServicesOffered service=new ServicesOffered();
			service.setName(services.get(i));
			service.setCharges(0);
			service.setDescription("");
			service.setWorkshop(workshop);
			service.setServiceID(workshop.getWorkShopID());
			addServices(service,workshop.getUsername());
		}
		
		return true;
	}

	@Override
	public Workshop workshopLogin(String username, String password) {
		// TODO Auto-generated method stub
		ArrayList<Workshop> workshops= workshopDAO.getWorkshops();
		for (int i = 0; i < workshops.size(); i++) {
			if(workshops.get(i).getUsername().equals(username)&& workshops.get(i).getPassword().equals(password)) {
				return workshops.get(i);
			}
		}
		return null;
	}









	@Override
	public void removeServices(String workshopID, String service) {
		ArrayList<Workshop> workshops= workshopDAO.getWorkshops();
		Workshop workshop=new Workshop();
		for (int i = 0; i < workshops.size(); i++) {
			if (workshops.get(i).getUsername().equals(workshopID)) {
				workshop=workshops.get(i);	
			}
		}
		workshopDAO.deleteServices(service,workshop.getWorkShopID());
	}

	@Override
	public ObservableList<Workshop> searchWorkshop(ArrayList<String> services) {
		ArrayList<Workshop> workshops= workshopDAO.getWorkshops();
		ObservableList<Workshop> res= FXCollections.observableArrayList();
//		ArrayList<Workshop> res=new ArrayList<>();
		Workshop workshop=new Workshop();
		for (int i = 0; i < workshops.size(); i++) {
			ArrayList<ServicesOffered> ser=new ArrayList<>();
			for (Iterator iterator = workshops.get(i).getWorkshopServices().iterator(); iterator.hasNext();) {
//				Workshop workshop = (Workshop) iterator.next();
				ser.add((ServicesOffered) iterator.next());
			}
			boolean flag=false;
			for (int j = 0; j < ser.size(); j++) {
				for (int k = 0; k < services.size(); k++) {
					if(ser.get(j).getName().equals(services.get(k) )) {
						flag=true;
					}
				}
			}
			int count=0;
			double total=0; 
			ArrayList<Feedback> feedbacks=workshopDAO.getFeedbacks(workshops.get(i).getWorkShopID());
			for (int j = 0; j < feedbacks.size(); j++) {
				count++;
				total+=feedbacks.get(j).getRating();
			}
			workshops.get(i).setRatings(total/count);
			if(flag) {
				res.add(workshops.get(i));
			}
			
		}
		return res;
	}

	@Override
	public void provideWorkshopFeedback(String workShopID, Feedback feedback) {
		// TODO Auto-generated method stub
		if(feedback.getRating()>5 || feedback.getRating()<0) {
			return;
		}
		ArrayList<Workshop> workshops= workshopDAO.getWorkshops();
		Workshop workshop=new Workshop();
		for (int i = 0; i < workshops.size(); i++) {
			if (workshops.get(i).getUsername().equals(workShopID)) {
				workshop=workshops.get(i);	
			}
		}
		
		feedback.setWorkshop(workshop);
		workshopDAO.provideWorkshopFeedback(feedback);
	}


	@Override
	public ObservableList<ServicesOffered> displayWorkshopServices(String workshopID) {
		ArrayList<Workshop> workshops= workshopDAO.getWorkshops();
		Workshop workshop=new Workshop();
		for (int i = 0; i < workshops.size(); i++) {
			if (workshops.get(i).getUsername().equals(workshopID)) {
				workshop=workshops.get(i);	
			}
		}
		ObservableList<ServicesOffered> services=workshopDAO.getServices(workshop.getWorkShopID());
		return services;
	}
	
}