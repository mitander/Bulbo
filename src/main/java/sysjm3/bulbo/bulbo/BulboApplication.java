package sysjm3.bulbo.bulbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"sysjm3.bublo.bublo"})
public class BulboApplication {

    public static void main(String[] args) {
        SpringApplication.run(BulboApplication.class, args);
    }

}
