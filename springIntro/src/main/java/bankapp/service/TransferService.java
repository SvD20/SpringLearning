package bankapp.service;

import bankapp.model.Amount;

public interface TransferService {

    void transferAmount(Long a, Long b, Amount amount);

}
