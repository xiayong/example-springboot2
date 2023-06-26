package me.xiayong.example.springboot2.service;

import lombok.extern.slf4j.Slf4j;
import me.xiayong.example.springboot2.persistence.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.List;

/**
 * @author: Yong Xia.
 * @date: Jun-27/2023
 * @since: v1.0
 **/
@Service
@Slf4j
public class CountryServiceImpl implements ICountryService{
    @Autowired
    private CountryRepository countryRepository;




    @Override
    public void saveCountry(String country) {

    }

    @Override
    @Transactional(readOnly = true)
    public void saveManyCountries(List<String> countries) {
        log.info("CurrentTransactionReadOnly={}", TransactionSynchronizationManager.isCurrentTransactionReadOnly());
        for (int i = 0; i < countries.size(); i++) {
            String country = countries.get(i);
            countryRepository.insertCountry(country);
            if (i >= 2) {
                throw new RuntimeException("exception occurred !");
            }
        }
    }
}
