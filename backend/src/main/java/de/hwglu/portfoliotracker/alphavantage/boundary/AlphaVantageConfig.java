package de.hwglu.portfoliotracker.alphavantage.boundary;

import com.crazzyghost.alphavantage.AlphaVantage;
import com.crazzyghost.alphavantage.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class AlphaVantageConfig {

    @Value("${alphavantage.key}")
    private String key;

    @Bean
    public void initialise() {
        AlphaVantage.api().init(Config.builder().key(key).timeOut(10).build());
        log.info("AlphaVantage connection initialised");
    }
}
