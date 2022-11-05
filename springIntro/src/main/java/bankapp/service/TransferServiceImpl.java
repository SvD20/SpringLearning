package bankapp.service;

import bankapp.model.Account;
import bankapp.model.Amount;
import bankapp.repository.AccountRepository;
import bankapp.repository.TransferRepository;
import org.springframework.stereotype.Component;

@Component
public class TransferServiceImpl implements TransferService{

    AccountRepository accountRepository;
    TransferRepository transferRepository;

    public TransferServiceImpl(AccountRepository accountRepository, TransferRepository transferRepository) {
        super();
        this.accountRepository = accountRepository;
        this.transferRepository = transferRepository;
    }

    @Override
    public void transferAmount(Long a, Long b, Amount amount) {
        Account accountA = accountRepository.findByAccountId(a);
        Account accountB = accountRepository.findByAccountId(b);
        transferRepository.transfer(accountA, accountB, amount);
    }


}
