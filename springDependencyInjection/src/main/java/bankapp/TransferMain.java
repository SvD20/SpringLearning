package bankapp;

import bankapp.config.AppConfig;
import bankapp.model.Amount;
import bankapp.service.TransferService;
import bankapp.service.TransferServiceImpl;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TransferMain {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        TransferService transferService = applicationContext.getBean(TransferService.class);
        transferService.transferAmount(100l, 200l, new Amount(2000.0));
        applicationContext.close();
    }

}
