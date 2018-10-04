package com.funsocietry.vision.configuration;

import com.funsocietry.vision.chache.ImageCache;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@AllArgsConstructor
@Configuration
public class ChacheConfiguration {

    @Bean
    public ImageCache imageChache(){
        return new ImageCache();
    }


}
