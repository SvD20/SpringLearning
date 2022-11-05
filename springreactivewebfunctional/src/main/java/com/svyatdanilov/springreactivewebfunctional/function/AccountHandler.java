package main.java.com.svyatdanilov.springreactivewebfunctional.function;

public class AccountHandler {

    private final AccountRepository repository;

    public AccountHandler(AccountRepository repository) {
        this.repository = repository;
    }

    public Mono<ServerResponse> findById(ServerRequest request) {
        Long accountId = Long.valueOf(request.pathVariable("id"));
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        Mono<Account> accountMono = this.repository.findById(accountId);
        return accountMono
                .flatMap(account -> ServerResponse.ok().contentType(APPLICATION_JSON).body(fromObject(account)))
                .switchIfEmpty(notFound);
    }

    public Mono<ServerResponse> findAll(ServerRequest request) {
        Flux<Account> accounts = this.repository.findAll();
        return ServerResponse.ok().contentType(APPLICATION_JSON).body(accounts, Account.class);
    }

    public Mono<ServerResponse> create(ServerRequest request) {
        Mono<Account> account = request.bodyToMono(Account.class);
        return ServerResponse.ok().build(this.repository.save(account));
    }


}
