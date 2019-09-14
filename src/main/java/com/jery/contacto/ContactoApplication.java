package com.jery.contacto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableJpaRepositories(basePackages = {"com.jery.contacto.repository"})
@EntityScan(value = {"com.jery.contacto.entity"})
@SpringBootApplication
public class ContactoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactoApplication.class, args);
	}

}
