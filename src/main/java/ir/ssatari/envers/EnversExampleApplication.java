package ir.ssatari.envers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EnversExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnversExampleApplication.class, args);
	}

}
