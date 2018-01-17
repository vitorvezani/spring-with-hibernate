package com.vvezani.springdemo;

public class FootballCoach implements Coach {

  private FortuneService fortuneService;

  public FootballCoach() {
    System.out.println("FootballCoach - constructor");
  }

  public FootballCoach(FortuneService fortuneService) {
    this.fortuneService = fortuneService;
  }

  @Override
  public String getDailyWorkout() {
    return "Go Ronaldo!";
  }

  @Override
  public String getDailyFortune() {
    return this.fortuneService.getFortune();
  }

  public FortuneService getFortuneService() {
    return fortuneService;
  }

  public void setFortuneService(FortuneService fortuneService) {
    System.out.println("FootballCoach - setFortuneService");
    this.fortuneService = fortuneService;
  }

}
