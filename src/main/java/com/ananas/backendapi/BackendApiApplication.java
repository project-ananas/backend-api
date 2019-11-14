package com.ananas.backendapi;

import com.ananas.backendapi.gatewayReader.GatewayService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApiApplication {

	// TODO: Move this property to application.properties
	public static final int TIME = 1;


	public static void main(String[] args) {
		SpringApplication.run(BackendApiApplication.class, args);

		// Start gateway service to get data from gateway to database.
		Thread t1 = new Thread(new GatewayService(TIME));
		t1.start();
	}
}