package com.funsocietry.noq.configuration;

import com.funsocietry.noq.chache.ResponseCache;
import com.funsocietry.noq.service.QrPaymentService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class CacheConfiguration {

    @Bean
    public ResponseCache responseCache(QrPaymentService paymentservice){
        return new ResponseCache(paymentservice);
    }


}