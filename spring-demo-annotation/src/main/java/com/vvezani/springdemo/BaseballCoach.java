package com.vvezani.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {

  private FortuneService fortuneService;

  @Autowired
  public BaseballCoach(@Qualifier("fileRandomFortuneService") FortuneService fortuneService) {
    this.fortuneService = fortuneService;
  }

  @Override
  public String getDailyWorkout( ) {
    return "Spend 30 minutes on batting practive";
  }

  @Override
  public String getDailyFortune() {
    return fortuneService.getFortune();
  }

  public void initMethod() {
    System.out.println("BaseballCoach#initMethod");
  }

  public void destroyMethod() {
    System.out.println("BaseballCoach#destroyMethod");
  }


}
