package com.nocountry.ecommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CrossOriginConfig implements WebMvcConfigurer {


    @Override
    public void addCorsMappings(CorsRegistry registry){
        
        registry.addMapping("/**")
                .allowedOrigins("https://meliclon.web.app") 
                .allowedMethods("GET","POST","PUT", "DELETE")
                .allowedHeaders("*");
    }
}
