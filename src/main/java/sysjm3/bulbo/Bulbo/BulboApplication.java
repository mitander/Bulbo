package sysjm3.bulbo.Bulbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"sysjm3.bulbo.Bulbo"})
public class BulboApplication {

	public static void main(String[] args) {
		SpringApplication.run(BulboApplication.class, args);
		System.out.println("YAY");
	}

}
