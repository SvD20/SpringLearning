package bankapp.repository;

import bankapp.model.Account;
import bankapp.model.Amount;
import org.springframework.stereotype.Repository;
import javax.annotation.PostConstruct;

@Repository
public class JdbcAccountRepository implements AccountRepository{

    @Override
    public Account findByAccountId(Long accountId) {
        return new Account(accountId, "Arnav Rajput", new Amount(3000.0));
    }

    @PostConstruct
    void populateCache(){
        System.out.println("Called populateCache() method");
    }

}
