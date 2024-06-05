package dh.backend.clinicamvc;

import dh.backend.clinicamvc.db.H2Connection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClinicaMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicaMvcApplication.class, args);
		H2Connection.crearTablas();
	}

}
