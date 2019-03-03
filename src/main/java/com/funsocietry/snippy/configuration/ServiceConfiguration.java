package com.funsocietry.snippy.configuration;


import com.funsocietry.snippy.service.ImgService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

    @Bean
    public ImgService qrPaymentService(){
        return new ImgService();
    }


}
