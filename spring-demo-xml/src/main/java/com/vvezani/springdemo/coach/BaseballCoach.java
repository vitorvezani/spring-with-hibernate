package com.vvezani.springdemo.coach;

import com.vvezani.springdemo.fortune.FortuneService;

public class BaseballCoach implements Coach {

  private FortuneService fortuneService;

  public BaseballCoach(FortuneService fortuneService) {
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
