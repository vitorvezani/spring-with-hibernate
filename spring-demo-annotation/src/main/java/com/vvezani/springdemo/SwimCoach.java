package com.vvezani.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

  private FortuneService fortuneService;

  @Value("${foo.name}")
  private String name;

  @Value("${foo.email}")
  private String email;

  public SwimCoach(FortuneService fortuneService) {
    this.fortuneService = fortuneService;
  }

  @Override
  public String getDailyWorkout( ) {
    return name + " you should swim 1000 meters a day, I ll email you @ " + email;
  }

  @Override
  public String getDailyFortune() {
    return fortuneService.getFortune();
  }

}
