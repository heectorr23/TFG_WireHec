package com.wirehec.microservice_Contability;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MicroserviceContabilityApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceContabilityApplication.class, args);
	}

}
