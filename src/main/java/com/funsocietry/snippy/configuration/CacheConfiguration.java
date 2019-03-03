package com.funsocietry.snippy.configuration;

import com.funsocietry.snippy.cache.ResponseCache;
import com.funsocietry.snippy.service.ImgService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class CacheConfiguration {

    @Bean
    public ResponseCache responseCache(ImgService paymentservice){
        return new ResponseCache(paymentservice);
    }


}
