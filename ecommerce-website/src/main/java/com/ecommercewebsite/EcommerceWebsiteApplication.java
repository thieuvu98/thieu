package com.ecommercewebsite;

import com.ecommercewebsite.service.impl.JedisPractice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.jmx.support.RegistrationPolicy;

@SpringBootApplication
@EnableMBeanExport(registration= RegistrationPolicy.IGNORE_EXISTING)
public class EcommerceWebsiteApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(EcommerceWebsiteApplication.class, args);
		JedisPractice jedisPractice = context.getBean(JedisPractice.class);
		jedisPractice.test();
	}

}
