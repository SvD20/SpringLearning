package bankapp.service;

import bankapp.model.Account;

import java.util.List;

public interface AccountService {

    Account open(Account account);

    List<Account> findAllAccounts();

    Account findOne(Long accountId);

}
