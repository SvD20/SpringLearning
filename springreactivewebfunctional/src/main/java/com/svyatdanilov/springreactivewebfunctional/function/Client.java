package main.java.com.svyatdanilov.springreactivewebfunctional.function;

import org.apache.catalina.Server;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeFunction;
import org.springframework.web.reactive.function.client.ExchangeFunctions;
import reactor.core.publisher.Mono;

import java.net.URI;

public class Client {

    private ExchangeFunction exchange = ExchangeFunctions.create(new ReactorClientHttpConnector());


    public static void main(String[] args) throws Exception {
        Client client = new Client();
        client.createAccount();
        client.findAllAccounts();
    }

    public void findAllAccounts() {
        URI uri = URI.create(String.format("http://%s:%d/account", Server.HOST, Server.TOMCAT_PORT));
        ClientRequest request = ClientRequest.method(HttpMethod.GET, uri).build();

        Flux<Account> account = exchange.exchange(request)
                .flatMapMany(response -> response.bodyToFlux(Account.class));

        Mono<List<Account>> accountList = account.collectList();
        System.out.println(accountList.block());
    }

    public void createAccount() {
        URI uri = URI.create(String.format("http://%s:%d/account", Server.HOST, Server.TOMCAT_PORT));
        Account account = new Account(5000l, "Arnav Rajput", 500000l, "Sector-5");

        ClientRequest request = ClientRequest.method(HttpMethod.POST, uri)
                .body(BodyInserters.fromObject(account)).build();

        Mono<ClientResponse> response = exchange.exchange(request);

        System.out.println(response.block().statusCode());
    }

}
