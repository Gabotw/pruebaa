package biz.restobar.platform.u202018627;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PruebaaApplication {

    public static void main(String[] args) {
        SpringApplication.run(PruebaaApplication.class, args);
    }

}
