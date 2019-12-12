package com.ananas.backendapi;


import com.ananas.backendapi.gatewayReader.GatewayService;
import com.ananas.backendapi.properties.ConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class BackendApiApplication{

	private static int TIME = 0;
	private static final TimeUnit TIME_UNIT = TimeUnit.MINUTES;
	private static ConfigProperties component;

	@Autowired
	private ConfigProperties autowiredComponent;

	@Primary
	@PostConstruct
	private void init() {
		component = autowiredComponent;
	}

	public static void main(String[] args) {
		// Launch Spring application
		System.setProperty("spring.config.location", "target/classes/application.properties");
		SpringApplication.run(BackendApiApplication.class, args);
		GatewayService service = new GatewayService(component);

		// Launch GET from sensorGateway services
		Thread t1 = new Thread(service);
		t1.start();
	}
}