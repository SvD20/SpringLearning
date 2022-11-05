package bankapp;

import bankapp.model.Account;
import bankapp.service.AccountService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringCacheDemo {

    public static void main(String[] args) {
        //ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        AccountService transferService = applicationContext.getBean(AccountService.class);
        Account account = transferService.findOne(1l);
        System.out.println(account);
        account = transferService.findOne(1l);
        System.out.println(account);
        applicationContext.close();
    }

}
