package com.funsocietry.data;

import com.google.appengine.repackaged.com.google.api.client.util.Beta;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;

@AllArgsConstructor
public class ServiceConfiguration {

    @Bean
    public AppCache getAppCache(){
        return new AppCache();
    }

    @Bean
    public Controller getControllerBean(AppCache appCache){
        return new Controller(appCache);
    }

}
