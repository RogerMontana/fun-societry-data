package com.funsocietry.data;

import com.google.appengine.repackaged.com.google.api.client.util.Beta;
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

    @Bean
    public Controller controllerBean(AppCache appCache){
        return new Controller(appCache);
    }

}
