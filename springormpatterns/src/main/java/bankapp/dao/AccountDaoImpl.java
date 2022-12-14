package bankapp.dao;

import org.hibernate.SessionFactory;

public class AccountDaoImpl implements AccountDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Integer totalAccountsByBranch(String branchName) {
        String sql = "SELECT count(*) FROM Account WHERE branchName = "+branchName;
        return this.sessionFactory.getCurrentSession().createQuery(sql, Integer.class).getSingleResult();
    }

}
