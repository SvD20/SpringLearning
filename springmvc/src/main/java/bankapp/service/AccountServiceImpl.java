package bankapp.service;

import bankapp.model.Account;
import bankapp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account open(Account account) {
        return account = accountRepository.save(account);
    }

    @Override
    public List<Account> findAllAccounts() {
        return (List<Account>) accountRepository.findAll();
    }

    @Override
    public Account findOne(Long accountId) {
        return accountRepository.findOne(accountId);
    }

}
