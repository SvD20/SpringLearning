package main.java.com.svyatdanilov.springreactivewebfunctional.function;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.http.server.reactive.ServletHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.ipc.netty.http.server.HttpServer;

import javax.xml.ws.spi.http.HttpHandler;

public class Server {

    public static final String HOST = "localhost";

    public static final int TOMCAT_PORT = 8080;
    public static final int REACTOR_PORT = 8181;

    public static void main(String[] args) throws Exception {
        Server server = new Server();
        server.startReactorServer();
        server.startTomcatServer();

        System.out.println("Press ENTER to exit.");
        System.in.read();
    }

    public RouterFunction<ServerResponse> routingFunction() {
        AccountRepository repository = new AccountRepositoryImpl();
        AccountHandler handler = new AccountHandler(repository);

        return nest(path("/account"),
                nest(accept(APPLICATION_JSON),
                        route(GET("/{id}"), handler::findById)
                                .andRoute(method(HttpMethod.GET), handler::findAll)
                ).andRoute(POST("/").and(contentType(APPLICATION_JSON)), handler::create));
    }

    public void startReactorServer() throws InterruptedException {
        RouterFunction<ServerResponse> route = routingFunction();
        HttpHandler httpHandler = toHttpHandler(route);

        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(httpHandler);
        HttpServer server = HttpServer.create(HOST, REACTOR_PORT);
        server.newHandler(adapter).block();
    }

    public void startTomcatServer() throws LifecycleException {
        RouterFunction<?> route = routingFunction();
        HttpHandler httpHandler = toHttpHandler(route);

        Tomcat tomcatServer = new Tomcat();
        tomcatServer.setHostname(HOST);
        tomcatServer.setPort(TOMCAT_PORT);
        Context rootContext = tomcatServer.addContext("", System.getProperty("java.io.tmpdir"));
        ServletHttpHandlerAdapter servlet = new ServletHttpHandlerAdapter(httpHandler);
        Tomcat.addServlet(rootContext, "httpHandlerServlet", servlet);
        rootContext.addServletMapping("/", "httpHandlerServlet");
        tomcatServer.start();
    }

}

