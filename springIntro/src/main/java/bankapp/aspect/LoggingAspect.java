package bankapp.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

    @Before("execution(* *.transferAmount(..))")
    public void logBeforeTransfer(){
        System.out.println("####LoggingAspect.logBeforeTransfer() method called before transfer amount####");
    }

    @After("execution(* *.transferAmount(..))")
    public void logAfterTransfer(){
        System.out.println("####LoggingAspect.logAfterTransfer() method called after transfer amount####");
    }
}
