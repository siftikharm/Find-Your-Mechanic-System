package application.app;

class ObjSingleton {
	private static ObjSingleton single_instance = null;

	public Object s;

	private ObjSingleton() {
		s = new Object();
	}

	public static ObjSingleton getInstance() {
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
	}

}
