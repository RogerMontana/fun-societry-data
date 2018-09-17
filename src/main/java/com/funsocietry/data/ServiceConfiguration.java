package com.funsocietry.data;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@AllArgsConstructor
@Configuration
public class ServiceConfiguration {

    @Bean
    public AppCache appCache(){
        return new AppCache();
    }


}
