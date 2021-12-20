package application.doa;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import application.entity.Customer;
import application.entity.Feedback;
import application.entity.ServicesOffered;
import application.entity.Vehicle;
import application.entity.Workshop;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class WorkshopFileImp implements WorkshopDOA {
	
	private SessionFactory sf;
	
	public WorkshopFileImp(){
		
		Configuration con = new Configuration();
    	con.configure().addAnnotatedClass(Customer.class);
    	con.configure().addAnnotatedClass(Vehicle.class);
    	con.configure().addAnnotatedClass(Workshop.class);
     	con.configure().addAnnotatedClass(Feedback.class);
     	con.configure().addAnnotatedClass(ServicesOffered.class);
    	sf = con.buildSessionFactory();
		
	}
	@Override
	public void addServices(ServicesOffered service) {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		session.save(service);
		trans.commit();
		session.close();
		try {
			 
            FileOutputStream fileOut = new FileOutputStream("services.txt");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(service);
            objectOut.close();
 
        } catch (Exception ex) {
        }
	}

	@Override
	public void removeServices(int workshopID, ServicesOffered service) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void searchWorkshop(LinkedList<ServicesOffered> services, String carMake) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void provideWorkshopFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		session.save(feedback);
		trans.commit();
		session.close();
		try {
			 
            FileOutputStream fileOut = new FileOutputStream("feedbacks.txt");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(feedback);
            objectOut.close();
 
        } catch (Exception ex) {
        }
	}

	@Override
	public void displayWorkshopServices(int workshopID) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("rawtypes")
	@Override
	public ArrayList<Workshop> getWorkshops() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		List workshops=session.createQuery("from Workshop").list();
		ArrayList<Workshop> workshop=new ArrayList<>();
		for (Iterator iterator = workshops.iterator(); iterator.hasNext();) {
			workshop.add((Workshop) iterator.next());
		}
		trans.commit();
		session.close();
		return workshop;
		
	}
	@Override
	public void registerWorkshop(Object object) {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		session.saveOrUpdate(object);
		trans.commit();
		session.close();
		try {
			 
            FileOutputStream fileOut = new FileOutputStream("workshops.txt");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(object);
            objectOut.close();
 
        } catch (Exception ex) {
        }
	}
	@SuppressWarnings("rawtypes")
	@Override
	public ObservableList<ServicesOffered> getServices(int workShopID) {
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		
		List vehicles= session.createQuery("from ServicesOffered where workshop_workShopID = :user").setParameter("user", workShopID).list();
		
		trans.commit();
		session.close();
		ObservableList<ServicesOffered> services=FXCollections.observableArrayList();
		for (Iterator iterator = vehicles.iterator(); iterator.hasNext();) {
			services.add((ServicesOffered) iterator.next());
		}
		return services;
	}
	@Override
	public void deleteServices(String service, int workShopID) {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		session.createQuery("delete from ServicesOffered where workshop_workShopID = :user and name = :name").setParameter("user", workShopID).setParameter("name", service).executeUpdate();
		
		trans.commit();
		session.close();

	}
	@SuppressWarnings("rawtypes")
	@Override
	public ArrayList<Feedback> getFeedbacks(int workShopID) {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		
		List feedbacks= session.createQuery("from Feedback where workshop_workShopID = :user").setParameter("user", workShopID).list();
		
		trans.commit();
		session.close();
		ArrayList<Feedback> services=new ArrayList<>();
		for (Iterator iterator = feedbacks.iterator(); iterator.hasNext();) {
			services.add((Feedback) iterator.next());
		}
		return services;
	}

}

