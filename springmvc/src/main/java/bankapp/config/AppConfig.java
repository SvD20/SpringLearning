package bankapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages={"bankapp.repository", "bankapp.service"})
@Import({InfrastructureConfig.class})
@EnableJpaRepositories(("bankapp.repository"))
public class AppConfig {

}
