package bankapp.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

    @Override
    public Integer totalAccountsByBranch(String branchName) {
        String sql = "SELECT count(*) FROM Account WHERE branchName = "+branchName;
        return this.getJdbcTemplate().queryForObject(sql, Integer.class);
    }

}
