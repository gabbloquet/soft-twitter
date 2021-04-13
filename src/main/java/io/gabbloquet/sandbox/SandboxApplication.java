package io.gabbloquet.sandbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories("io.gabbloquet.sandbox.infrastructure.postgres")
public class SandboxApplication {
	public static void main(String[] args) {
		SpringApplication.run(SandboxApplication.class, args);
	}
}
