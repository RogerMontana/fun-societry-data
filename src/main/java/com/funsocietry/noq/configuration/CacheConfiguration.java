package com.funsocietry.noq.configuration;

import com.funsocietry.noq.chache.ResponseCache;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@AllArgsConstructor
@Configuration
public class CacheConfiguration {

    @Bean
    public ResponseCache responseCache(){
        return new ResponseCache();
    }


}
