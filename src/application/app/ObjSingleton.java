package application.app;

import application.entity.Customer;

//Java program implementing Singleton class
//with using getInstance() method

//Class 1
//Helper class
class ObjSingleton {
	// Static variable reference of single_instance
	// of type Singleton
	private static ObjSingleton single_instance = null;

	// Declaring a variable of type String
	public Object s;

	// Constructor
	// Here we will be creating private constructor
	// restricted to this class itself
	private ObjSingleton()
	{
//		s = "Hello I am a string part of Singleton class";
		s=new Object();
	}

	// Static method
	// Static method to create instance of Singleton class
	public static ObjSingleton getInstance()
	{
		if (single_instance == null)
			single_instance = new ObjSingleton();

		return single_instance;
	}

	public static ObjSingleton getSingle_instance() {
		return single_instance;
	}

	public static void setSingle_instance(ObjSingleton single_instance) {
		ObjSingleton.single_instance = single_instance;
	}

	public Object getS() {
		return s;
	}

	public void setS(Object s) {
		this.s = s;
//		System.out.println(((Customer) s).getPassword());
	}
	
}

//Class 2
//Main class
//class GFG {
//	// Main driver method
//	public static void main(String args[])
//	{
//		// Instantiating Singleton class with variable x
//		Singleton x = Singleton.getInstance();
//
//		// Instantiating Singleton class with variable y
//		Singleton y = Singleton.getInstance();
//
//		// Instantiating Singleton class with variable z
//		Singleton z = Singleton.getInstance();
//
//		// Printing the hash code for above variable as
//		// declared
//		System.out.println("Hashcode of x is "
//						+ x.hashCode());
//		System.out.println("Hashcode of y is "
//						+ y.hashCode());
//		System.out.println("Hashcode of z is "
//						+ z.hashCode());
//
//		// Condition check
//		if (x == y && y == z) {
//
//			// Print statement
//			System.out.println(
//				"Three objects point to the same memory location on the heap i.e, to the same object");
//		}
//
//		else {
//			// Print statement
//			System.out.println(
//				"Three objects DO NOT point to the same memory location on the heap");
//		}
//	}
//}

