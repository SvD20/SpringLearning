package bankapp.repository;

import bankapp.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface TransferRepository extends CrudRepository<Account, Long> {

}
