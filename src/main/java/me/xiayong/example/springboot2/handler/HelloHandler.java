package me.xiayong.example.springboot2.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @author YongXia.
 * @since 1.0
 */
@Component
public class HelloHandler {
    Logger logger = LoggerFactory.getLogger(HelloHandler.class);

    public Mono<ServerResponse> hello(ServerRequest request) {
        logger.info("session: {}", request.session().toString());
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).body(Mono.just("Welcome to reactive world ~"), String.class);
    }
}
