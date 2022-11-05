package main.java.com.svyatdanilov.springreactivewebfunctional.repository;

import main.java.com.svyatdanilov.springreactivewebfunctional.model.Account;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountRepository {

    Mono<Account> findById(Long id);

    Flux<Account> findAll();

    Mono<Void> save(Mono<Account> account);

}
