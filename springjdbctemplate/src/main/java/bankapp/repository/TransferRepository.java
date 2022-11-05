package bankapp.repository;

import bankapp.model.Account;

public interface TransferRepository {

    void transfer(Long amount, Account account);

}
