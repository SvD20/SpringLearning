package bankapp.repository;

import bankapp.model.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JpaAccountRepository  {

    //@Override
    public Account findAccountById(Long id) {
        return new Account(id);
    }

    //@Override
    public List<Account> findAll() {
        return null;
    }

    //@Override
    public Long save(Account account) {
        return null;
    }

    //@Override
    public Double checkAccountBalance(Account account) {
        return null;
    }

}
