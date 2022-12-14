package bankapp.service;

import bankapp.model.Account;
import bankapp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

@Service
public class AccountServiceImpl implements AccountService {

    //single TransactionTemplate shared amongst all methods in this instance
    private final TransactionTemplate transactionTemplate;

    @Autowired
    @Qualifier("hibernateAccountRepository")
    AccountRepository accountRepository;

    // use constructor-injection to supply the PlatformTransactionManager
    public AccountServiceImpl(PlatformTransactionManager transactionManager) {
        this.transactionTemplate = new TransactionTemplate(transactionManager);
    }

    @Override
    public Double checkAccountBalance(Account account) {
        return transactionTemplate.execute(new TransactionCallback<Double>() {
            // the code in this method executes in a transactional context
            public Double doInTransaction(TransactionStatus status) {
                return accountRepository.checkAccountBalance(account);
            }
        });
    }
}