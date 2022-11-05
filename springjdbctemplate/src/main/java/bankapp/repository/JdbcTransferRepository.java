package bankapp.repository;

import bankapp.model.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class JdbcTransferRepository implements TransferRepository {

    JdbcTemplate jdbcTemplate;

    public JdbcTransferRepository(DataSource dataSource) {
        super();
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void transfer(Long amount, Account account) {
        String sql = "UPDATE Account SET balance = "+amount+" WHERE id ="+account.getId();
        jdbcTemplate.update(sql);
    }

}
