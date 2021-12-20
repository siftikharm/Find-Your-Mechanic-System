package testing;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import application.doa.WorkShopDOAImp;
import application.doa.WorkshopDOA;
import application.entity.Customer;
import application.entity.Feedback;
import application.entity.ServicesOffered;
import application.entity.Vehicle;
import application.entity.Workshop;
import application.service.WorkShopService;
import application.service.WorkshopServiceImp;
import exceptionHandling.IncorrectFeedback;
import exceptionHandling.InvalidLoginCredentials;
import javafx.collections.ObservableList;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestWorkshopService {

	private ServicesOffered service = new ServicesOffered("Paint Job", "Denting and paiting", 2000);
	private ArrayList<String> workshopServices = new ArrayList<String>();
	private static WorkshopDOA wDoa = new WorkShopDOAImp();
	private WorkShopService workshopService = new WorkshopServiceImp();
	private static SessionFactory sf;
	private static Workshop workshop = new Workshop("testName", "testAddress", "testContact", "testUsername",
			"testPass", 0.0, null, null);
	private Feedback feedback = new Feedback("testFeedback", 5);

	@BeforeAll
	public static void setUp() throws Exception {
		Configuration con = new Configuration();
		con.configure().addAnnotatedClass(Customer.class);
		con.configure().addAnnotatedClass(Vehicle.class);
		con.configure().addAnnotatedClass(Workshop.class);
		con.configure().addAnnotatedClass(Feedback.class);
		con.configure().addAnnotatedClass(ServicesOffered.class);
		sf = con.buildSessionFactory();
	}

	@Test
	@Order(1)
	public void testRegisterWorkshop() {
		assertEquals(true, workshopService.registerWorkshop(workshop, null));
	}

	@Test
	@Order(1)
	public void testRegisterWorkshop1() {
		assertEquals(false, workshopService.registerWorkshop(workshop, null));
	}

	@Test
	void LoginTesting() {
		Throwable exception = assertThrows(InvalidLoginCredentials.class, () -> {
			workshopService.workshopLogin("qwerty", "ytrew");
		});
		assertEquals("User name or password incorrect", exception.getMessage());
	}

	@SuppressWarnings({ "unused", "rawtypes" })
	@Test
	@Order(2)
	public void testAddServices() {
		workshopService.addServices(service, workshop.getUsername());
		Workshop work = new Workshop();
		ArrayList<Workshop> workshops = wDoa.getWorkshops();
		for (int i = 0; i < workshops.size(); i++) {
			if (workshops.get(i).getUsername().equals(workshop.getUsername())) {
				work = workshops.get(i);
			}
		}
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		ArrayList<ServicesOffered> ser = new ArrayList<>();
		List getService = session.createQuery("from ServicesOffered where workshop_workShopID = :user")
				.setParameter("user", work.getWorkShopID()).list();
		for (Iterator iterator = getService.iterator(); iterator.hasNext();) {
			ser.add((ServicesOffered) iterator.next());
		}
		assertEquals(service.getName(), ser.get(0).getName());
		assertEquals(service.getCharges(), ser.get(0).getCharges());
		assertEquals(service.getDescription(), ser.get(0).getDescription());

	}

	@Test
	@Order(3)
	public void testSearchWorkshop() {
		workshopServices.add("Paint Job");
		ObservableList<Workshop> workshops = workshopService.searchWorkshop(workshopServices);
		assertEquals(1, workshops.size());

	}

	@SuppressWarnings({ "rawtypes", "unused" })
	@Test
	@Order(4)
	public void testRemoveServices() {
		workshopService.removeServices(workshop.getUsername(), service.getName());
		Workshop work = new Workshop();
		ArrayList<Workshop> workshops = wDoa.getWorkshops();
		for (int i = 0; i < workshops.size(); i++) {
			if (workshops.get(i).getUsername().equals(workshop.getUsername())) {
				work = workshops.get(i);
			}
		}
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		List getService = session.createQuery("from ServicesOffered where workshop_workShopID = :user")
				.setParameter("user", work.getWorkShopID()).list();
		assertEquals(0, getService.size());

	}

	@SuppressWarnings("rawtypes")
	@Test
	@Order(5)
	public void testProvideFeedback() throws IncorrectFeedback {
		workshopService.provideWorkshopFeedback(workshop.getUsername(), feedback);
		Workshop work = new Workshop();
		ArrayList<Workshop> workshops = wDoa.getWorkshops();
		for (int i = 0; i < workshops.size(); i++) {
			if (workshops.get(i).getUsername().equals(workshop.getUsername())) {
				work = workshops.get(i);
			}
		}

		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		List feedbacks = session.createQuery("from Feedback where workshop_workShopID = :user")
				.setParameter("user", work.getWorkShopID()).list();
		assertEquals(((Feedback) feedbacks.get(0)).getRating(), feedback.getRating());
		assertEquals(((Feedback) feedbacks.get(0)).getComments(), feedback.getComments());
		trans.commit();
		session.close();

	}

	@Test
	@Order(6)
	void FeedbackTesting() {
		feedback.setRating(6);
		Throwable exception = assertThrows(IncorrectFeedback.class, () -> {
			workshopService.provideWorkshopFeedback(workshop.getUsername(), feedback);
		});
		assertEquals("Rating 1 - 5", exception.getMessage());
	}

	@AfterAll
	public static void tearDown() throws Exception {
		Workshop work = new Workshop();
		ArrayList<Workshop> workshops = wDoa.getWorkshops();
		for (int i = 0; i < workshops.size(); i++) {
			if (workshops.get(i).getUsername().equals(workshop.getUsername())) {
				work = workshops.get(i);
			}
		}
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		session.createQuery("delete from Feedback where workshop_workShopID = :user ")
				.setParameter("user", work.getWorkShopID()).executeUpdate();
		session.createQuery("delete from Workshop where username = :user ").setParameter("user", work.getUsername())
				.executeUpdate();

		trans.commit();
		session.close();
	}
}
