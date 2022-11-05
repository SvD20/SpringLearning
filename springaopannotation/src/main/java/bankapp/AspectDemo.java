package bankapp;

import bankapp.config.AppConfig;
import bankapp.service.TransferService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AspectDemo {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        TransferService transferService = applicationContext.getBean(TransferService.class);
        transferService.transfer("accountA", "accountB", 50000l);
        applicationContext.close();
    }

}
