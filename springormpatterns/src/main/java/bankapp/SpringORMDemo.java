package bankapp;

import bankapp.config.AppConfig;
import bankapp.service.TransferService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringORMDemo {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        TransferService transferService = applicationContext.getBean(TransferService.class);
        transferService.transfer(50000l, 1000l, 2000l);
        applicationContext.close();
    }

}
