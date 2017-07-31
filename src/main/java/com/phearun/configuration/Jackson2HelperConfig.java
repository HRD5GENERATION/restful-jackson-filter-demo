package com.phearun.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ch.mfrey.jackson.antpathfilter.Jackson2Helper;

@Configuration
public class Jackson2HelperConfig {

    @Bean
    public Jackson2Helper jackson2Helper() {
    	return new Jackson2Helper();
    }
}
