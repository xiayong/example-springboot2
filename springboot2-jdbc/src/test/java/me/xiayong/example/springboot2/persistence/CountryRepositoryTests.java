package me.xiayong.example.springboot2.persistence;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CountryRepositoryTests {

    @Autowired
    CountryRepository countryRepository;



}
