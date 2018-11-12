package com.funsocietry.noq.configuration;


import com.funsocietry.noq.chache.ResponseCache;
import com.funsocietry.noq.service.QrPaymentService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

    @Bean
    public QrPaymentService qrPaymentService(){
        return new QrPaymentService();
    }


}
