package bankapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages={"bankapp.repository", "bankapp.service"})
@Import({InfrastructureConfig.class})
public class AppConfig {

}
