package yavirac.labyac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "yavirac.labyac")
public class LabyacApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabyacApplication.class, args);
	}

}
