package bankapp.callbacks;

import bankapp.model.Account;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountExtractor implements ResultSetExtractor<List<Account>> {

    @Override
    public List<Account> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        List<Account> extractedAccounts = null;
        Account account = null;
        while (resultSet.next()) {
            if (extractedAccounts == null) {
                extractedAccounts = new ArrayList<>();
                //account = new Account(resultSet.getLong("ID"), resultSet.getString("NAME"));
            }
            account = new Account(resultSet.getLong("ID"), resultSet.getString("NAME"));
            extractedAccounts.add(account);
        }
        return extractedAccounts;
    }

}
