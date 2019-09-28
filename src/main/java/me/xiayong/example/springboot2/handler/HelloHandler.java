package me.xiayong.example.springboot2.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @author YongXia.
 * @since 1.0
 */
@Slf4j
@Component
public class HelloHandler {

    public Mono<ServerResponse> hello(ServerRequest request) {
        log.info("session: {}", request.session().toString());
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).body(Mono.just("Welcome to reactive world ~"), String.class);
    }
}
