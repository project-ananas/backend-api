package com.ananas.backendapi;

import com.ananas.backendapi.gatewayReader.GatewayService;
import com.ananas.backendapi.util.ConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Primary;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class BackendApiApplication {

	@Autowired
	private ConfigProperties autowiredComponent;

	private static ConfigProperties component;

	@Primary
	@PostConstruct
	private void init() {
		component = autowiredComponent;
	}

	public static void main(String[] args) {
		SpringApplication.run(BackendApiApplication.class, args);
		GatewayService service = new GatewayService(component);
		// Launch GET from sensorGateway services
		Thread t1 = new Thread(service);
		t1.start();
	}
}
