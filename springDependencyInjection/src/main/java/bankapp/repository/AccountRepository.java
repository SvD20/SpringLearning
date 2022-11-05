package bankapp.repository;

import bankapp.model.Account;

public interface AccountRepository {

    Account findByAccountId(Long accountId);

}
