package me.shackox;

import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableJSONDoc
public class DemobookinApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemobookinApplication.class, args);
	}
}
