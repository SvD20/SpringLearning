package bankapp.config;

import bankapp.repository.AccountRepository;
import bankapp.repository.JdbcAccountRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("bankapp")
public class AppConfig {
    @Bean(initMethod = "populateCache")
    public AccountRepository accountRepository(){
        return new JdbcAccountRepository();
    }
}
