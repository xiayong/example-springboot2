package me.xiayong.example.springboot2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author YongXia.
 * @since 1.0
 */
@RestController
public class HelloController {
    @GetMapping("hello")
    public Mono<String> hello() {
        return Mono.just( "Welcome to reactive world ~");
    }
}
