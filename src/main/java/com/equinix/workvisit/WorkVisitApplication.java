package com.equinix.workvisit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.equinix.workvisit"})
//@SpringBootApplication(scanBasePackages={"com.equinix.workvisit"})
public class WorkVisitApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkVisitApplication.class, args);
	}
}
