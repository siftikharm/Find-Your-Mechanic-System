module APFinalProject {
	requires javafx.controls;
	requires java.persistence;
	requires java.sql;
//	requires hibernate.jpa;
//	requires org.hibernate.commons.annotations;
	requires org.hibernate.orm.core;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	requires junit; 
	requires org.junit.jupiter.api;
	requires org.junit.platform.suite.api;
//	requires hibernate.jpa;
	opens application.app to hibernate.jpa,javafx.graphics, javafx.fxml;
	opens application.entity to org.hibernate.orm.core;
}
