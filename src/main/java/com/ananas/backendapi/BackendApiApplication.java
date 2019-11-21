package com.ananas.backendapi;


import com.ananas.backendapi.gatewayReader.GatewayService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class BackendApiApplication{

	// TODO: Move this property to application.properties
	private static final int TIME = 1;
	private static final TimeUnit TIME_UNIT = TimeUnit.MINUTES;


	public static void main(String[] args) {
		// Launch Spring application
		SpringApplication.run(BackendApiApplication.class, args);
		GatewayService service = new GatewayService(TIME,TIME_UNIT);

		Thread t1 = new Thread(service);
		t1.start();
	}
}