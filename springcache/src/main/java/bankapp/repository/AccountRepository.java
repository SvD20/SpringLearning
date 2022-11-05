package bankapp.repository;

import bankapp.model.Account;

import java.util.List;

public interface AccountRepository {

    Account findAccountById(Long id);

    List<Account> findAll();

    Long save(Account account);

    Double checkAccountBalance(Account account);

}
