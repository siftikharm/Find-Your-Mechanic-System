package testing;

import static org.junit.Assert.assertEquals;

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

import application.entity.Customer;
import application.entity.Feedback;
import application.entity.ServicesOffered;
import application.entity.Vehicle;
import application.entity.Workshop;
import application.service.CustomerService;
import application.service.CustomerServiceImp;
import exceptionHandling.UserAlreadyExists;
import javafx.collections.ObservableList;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestCustomerService {

	private static SessionFactory sf;
	private CustomerService customerService = new CustomerServiceImp();
	private static Customer customer = new Customer("testName", "testContact", "testG", "testEmail", "testUsername",
			"testPass");
	private Vehicle vehicle = new Vehicle("TestVname", "testVmodel", "testVmake", "testVnum");

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
	public void testRegisterCustomer() {
		try {
			assertEquals(true, customerService.registerCustomer(customer));
		} catch (UserAlreadyExists e) {
			// TODO Auto-generated catch block

		}
	}

//	@Test
//	@Order(2)
//	public void testRegisterCustomerNegative() throws UserAlreadyExists {
//		assertEquals(false , customerService.registerCustomer(customer) );
//	}

	@Test
	@Order(2)
	public void testAddVehicle() {
		customerService.addVehicle(vehicle, customer.getUsername());
		ObservableList<Vehicle> vehicles = customerService.displayVehicles(customer.getUsername());
		assertEquals(1, vehicles.size());
	}

	@Test
	@Order(3)
	public void testremoveVehicle() {
		customerService.removeVehicle(customer.getUsername(), vehicle.getPlateNumber());
		ObservableList<Vehicle> vehicles = customerService.displayVehicles(customer.getUsername());
		assertEquals(false, vehicles.contains(vehicle));
	}

	@AfterAll
	public static void tearDown() throws Exception {
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		session.createQuery("delete from Customer where username = :user ").setParameter("user", customer.getUsername())
				.executeUpdate();

		trans.commit();
		session.close();

	}
}
