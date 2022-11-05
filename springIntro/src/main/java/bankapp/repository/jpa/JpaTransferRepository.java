package bankapp.repository.jpa;

import bankapp.model.Account;
import bankapp.model.Amount;
import bankapp.repository.TransferRepository;

public class JpaTransferRepository implements TransferRepository {

    @Override
    public void transfer(Account accountA, Account accountB, Amount amount) {
        System.out.println("Transfering amount from account A to B via JPA implementation");
    }

}
