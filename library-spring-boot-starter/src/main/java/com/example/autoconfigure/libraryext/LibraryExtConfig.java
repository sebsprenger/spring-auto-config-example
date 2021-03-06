package com.example.autoconfigure.libraryext;

import com.example.handlers.SmsHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@ConditionalOnClass(SmsHandler.class)
public class LibraryExtConfig {

    @Bean
    @ConditionalOnMissingBean
    SmsHandler smsHandler(@Value("${example.number:0123-45678912}") String number) {
        return new SmsHandler(number);
    }
}
