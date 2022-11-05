package bankapp.service;

import bankapp.model.Account;
import bankapp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransferServiceImpl implements TransferService{

    @Autowired
    AccountRepository accountRepository;

    @Override
    @Transactional
    public void transfer(Long amount, Long a, Long b){
        Account accountA = accountRepository.findOne(a);
        Account accountB = accountRepository.findOne(b);
        System.out.println(accountRepository.findAccountByName("Dinesh"));
        System.out.println(accountRepository.findAll());
        System.out.println("Amount has been transfered from "+accountA +" to "+accountB);
        System.out.println(accountRepository.readRecord(2000l));
    }
}
