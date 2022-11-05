package bankapp.repository;

import bankapp.model.Account;
import bankapp.model.Amount;

public interface TransferRepository {

    void transfer(Account accountA, Account accountB, Amount amount);

}
