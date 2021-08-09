package me.xiayong.example.springboot2.router;

import me.xiayong.example.springboot2.handler.HelloHandler;
import me.xiayong.example.springboot2.handler.TimeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @author YongXia.
 * @since 1.0
 */
@Configuration
public class RouterConfig {
    @Autowired
    private HelloHandler helloHandler;
    @Autowired
    private TimeHandler timeHandler;


    @Bean
    public RouterFunction<ServerResponse> router() {
        return RouterFunctions.route(RequestPredicates.GET("/hello1"), helloHandler::hello)
                .andRoute(RequestPredicates.GET("/hello2"), timeHandler)
                .andRoute(RequestPredicates.GET("/hello3"), timeHandler::sendTimePerSec)
                ;
    }
}
