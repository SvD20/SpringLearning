package bankapp.service;

public interface TransferService {

    void transfer(String accountA, String accountB, Long amount);

}
