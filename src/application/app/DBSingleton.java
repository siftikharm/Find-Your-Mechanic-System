package application.app;

public class DBSingleton {
	private static DBSingleton single_instance = null;

	public String s;

	private DBSingleton() {
		s = "";
	}

	public static DBSingleton getInstance() {
		if (single_instance == null)
			single_instance = new DBSingleton();

		return single_instance;
	}

	public static DBSingleton getSingle_instance() {
		return single_instance;
	}

	public static void setSingle_instance(DBSingleton single_instance) {
		DBSingleton.single_instance = single_instance;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}
}
