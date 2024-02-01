package com.polovyi.ivan.configuration;

import feign.Logger;
import feign.Request.Options;
import feign.Retryer;
import feign.Retryer.Default;
import java.util.concurrent.TimeUnit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfigs {

    @Bean
    public Logger.Level loggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public Retryer retryer() {
        return new Default(1000, 2000, 4);
    }

    @Bean
    public Options options() {
        return new Options(5, TimeUnit.SECONDS, 10, TimeUnit.SECONDS, true);
    }

}
