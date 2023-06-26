package me.xiayong.example.springboot2.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

/**
 * @author: Yong Xia.
 * @date: Jun-27/2023
 * @since: v1.0
 **/
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CountryServiceTests {

    @Autowired
    private ICountryService countryService;

    @Test
    public void testTrans() {
        countryService.saveManyCountries(List.of("ABCDEFG", "ABCDEFG1", "ABCDEFG2"));
    }
}
