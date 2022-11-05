package bankapp.service;

import bankapp.model.Account;

public interface AccountService {

    Account findOne(Long id);

    Long save(Account account);

    void remove(Long id);

}
