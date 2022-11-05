package bankapp.repository.jdbc;

import bankapp.model.Account;
import bankapp.model.Amount;
import bankapp.repository.AccountRepository;

public class JdbcAccountRepository implements AccountRepository {

    @Override
    public Account findByAccountId(Long accountId) {
        return new Account(accountId, "Arnav Rajput", new Amount(3000.0));
    }
}
