package com.vvezani.springdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.vvezani.springdemo.Coach;
import com.vvezani.springdemo.FortuneService;
import com.vvezani.springdemo.SadFortuneService;
import com.vvezani.springdemo.SwimCoach;

@Configuration
// @ComponentScan("com.vvezani.springdemo")
@PropertySource("classpath:application.properties")
public class AppConfig {

  @Bean
  public Coach swimCoach() {
    return new SwimCoach(sadFortuneService());
  }

  @Bean
  public FortuneService sadFortuneService() {
    return new SadFortuneService();
  }

}
