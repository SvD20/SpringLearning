package bankapp.repository;

import bankapp.model.Account;

import java.io.Writer;
import java.util.List;

public interface AccountRepository {

    Account findAccountById(Long id);
    void generateReport(Writer out, String city);
    List<Account> extractAccounts();

}
